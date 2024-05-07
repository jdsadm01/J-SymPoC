package jp.co.jdsnet.common.logic.implement;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.DaihyoKaishaJokenEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.TantoTerritoryEntity;
import jp.co.jdsnet.common.domain.entity.zaiko.AzaikoEntity;
import jp.co.jdsnet.common.domain.entity.zaiko.ZaikoKakuhoEntity;
import jp.co.jdsnet.common.domain.mapper.hinban.HinbanMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.DaihyoKaishaJokenMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KakushaTokuisakiMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.TantoTerritoryMapper;
import jp.co.jdsnet.common.domain.mapper.zaiko.AzaikoMapper;
import jp.co.jdsnet.common.domain.mapper.zaiko.ZaikoKakuhoMapper;
import jp.co.jdsnet.common.domain.vo.HikiateKanosuuVo;
import jp.co.jdsnet.common.logic.HikiateKanoSuuCalculateService;
import jp.co.jdsnet.common.utils.GlobalConstants;
import jp.co.jdsnet.common.utils.GlobalConstants.Rmcod;
import jp.co.jdsnet.common.utils.GlobalConstants.Syacod;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;
import lombok.RequiredArgsConstructor;

/**
 * 引当可能数算出実装クラス
 *
 * @author r-matsumura
 *
 */
@RequiredArgsConstructor
@Service
public class HikiateKanoSuuCalculateServiceImpl implements HikiateKanoSuuCalculateService {

  private final DaihyoKaishaJokenMapper daihyoKaishaJokenMapper;
  private final AzaikoMapper azaikoMapper;
  private final KakushaTokuisakiMapper kakushaTokuisakiMapper;
  private final HinbanMapper hinbanMapper;
  private final TantoTerritoryMapper tantoTerritoryMapper;
  private final ZaikoKakuhoMapper zaikoKakuhoMapper;

  @Override
  public HikiateKanosuuVo getHatKnoSuu(String daikaiskbcod, String kigbng, String[] skocodList,
      Trncod trncod, Rmcod rmcod, boolean isMinus) {
    DaihyoKaishaJokenEntity kaishaJokenEntity = getDaihyoKaishaJoken(daikaiskbcod);
    HikiateKanosuuVo.builder builder = new HikiateKanosuuVo.builder();
    Arrays.stream(skocodList).forEach(s -> {
      int knosuu =
          getCalculateBean(kaishaJokenEntity, kigbng, s, trncod, rmcod).getHikiateKanosuu();
      builder.add(s, (knosuu < 0 && !isMinus) ? 0 : knosuu);
    });
    return builder.build();
  }

  @Override
  public HikiateKanosuuVo getHatKnoSuu(String daikaiskbcod, String kigbng, String[] skocodList,
      Trncod trncod, Rmcod rmcod, String tokcod, boolean isMinus) {
    DaihyoKaishaJokenEntity kaishaJokenEntity = getDaihyoKaishaJoken(daikaiskbcod);
    HikiateKanosuuVo.builder builder = new HikiateKanosuuVo.builder();
    Arrays.stream(skocodList).forEach(s -> {
      int knosuu =
          getCalculateBean(kaishaJokenEntity, kigbng, s, trncod, rmcod).getHikiateKanosuuRsv(tokcod,
              rmcod);
      builder.add(s, (knosuu < 0 && !isMinus) ? 0 : knosuu);
    });
    return builder.build();
  }

  private DaihyoKaishaJokenEntity getDaihyoKaishaJoken(String daikaiskbcod)
      throws NoSuchElementException {
    DaihyoKaishaJokenEntity entity = daihyoKaishaJokenMapper
        .select(DaihyoKaishaJokenEntity.builder().daikaiskbcod(daikaiskbcod).build());
    if (Objects.isNull(entity)) {
      throw new NoSuchElementException("代表会社条件が存在しません。");
    }
    return entity;
  }

  private CalculateBean getCalculateBean(DaihyoKaishaJokenEntity kaishaJokenEntity, String kigbng,
      String skocod, Trncod trncod, Rmcod rmcod) throws NoSuchElementException {

    AzaikoEntity azaikoEntity = azaikoMapper.selectForCalcurateKanosuu(AzaikoEntity.builder()
        .daikaiskbcod(kaishaJokenEntity.getDaikaiskbcod()).kigbng(kigbng).skocod(skocod).build());

    CalculateBean calbean = new CalculateBean(azaikoEntity);
    calbean.adjustMinusData();
    calbean.ajustSettingValue(trncod, rmcod);
    calbean.ajustCyzupdkbn(kaishaJokenEntity.getCyzupdkbn());

    return calbean;
  }

  /**
   * 可能数計算Bean
   *
   * @author r-matsumura
   *
   */
  private class CalculateBean {

    /** 在庫数量 */
    private int zaisur;
    /** 当月在庫訂正数量（＋） */
    private int tomzaiteisurpls;
    /** 当月在庫訂正数量（－） */
    private int tomzaiteisurmns;
    /** 前月迄在庫訂正数量（＋） */
    private int zmmzaiteisurpls;
    /** 前月迄在庫訂正数量（－） */
    private int zmmzaiteisurmns;
    /** 在庫訂正数量（＋） 当月＋前月迄の合算値 */
    private int sumzaiteisurpls;
    /** 在庫訂正数量（－） 当月＋前月迄の合算値 */
    private int sumzaiteisurmns;
    /** Ｃ直仮引当数量 */
    private int cchkhasur;
    /** 輸出確保分 */
    private int expkho;
    /** 在庫確保仮引当数量（算出用) */
    private int zaikhokhasur;
    /** 在庫確保仮引当数量(リザーブ算出用:ゼロ調整されない) */
    private int orgZaikhokhasur;
    /** 注残仮引当数量 */
    private int chzkhasur;
    /** 翌営出荷仮引当数量 */
    private int ykesyakhasur;
    /** 新譜受注仮引当数量 */
    private int sinjuckhasur;
    /** 出荷コード */
    private Syacod syacod;
    /** 代表会社識別コード */
    private String daikaiskbcod;
    /** 記号番号 */
    private String kigbng;
    /** 倉庫コード */
    private String skocod;

    /**
     * コンストラクタ
     *
     * @param azaiko 算出対象A在庫Entity
     */
    public CalculateBean(AzaikoEntity azaiko) {
      this.zaisur = azaiko.getZaisur();
      this.tomzaiteisurpls = azaiko.getTomzaiteisurpls();
      this.tomzaiteisurmns = azaiko.getTomzaiteisurmns();
      this.zmmzaiteisurpls = azaiko.getZmmzaiteisurpls();
      this.zmmzaiteisurmns = azaiko.getZmmzaiteisurmns();
      this.sumzaiteisurpls = this.tomzaiteisurpls + this.zmmzaiteisurpls;
      this.sumzaiteisurmns = this.tomzaiteisurmns + this.zmmzaiteisurmns;
      this.cchkhasur = azaiko.getCchkhasur();
      this.expkho = azaiko.getExpkho();
      this.zaikhokhasur = azaiko.getZaikhokhasur();
      this.orgZaikhokhasur = azaiko.getZaikhokhasur();
      this.chzkhasur = azaiko.getChzkhasur();
      this.ykesyakhasur = azaiko.getYkesyakhasur();
      this.sinjuckhasur = azaiko.getSinjuckhasur();
      this.syacod = GlobalConstants.valueOf(Syacod.class, azaiko.getSyacod());
      this.daikaiskbcod = azaiko.getDaikaiskbcod();
      this.kigbng = azaiko.getKigbng();
      this.skocod = azaiko.getSkocod();
    }

    /**
     * マイナス数量の調整を行う。 マイナス値の場合は０に調整。
     */
    public void adjustMinusData() {
      if (this.sumzaiteisurpls < 0) {
        this.sumzaiteisurpls = 0;
      }
      if (this.sumzaiteisurmns < 0) {
        this.sumzaiteisurmns = 0;
      }
      if (this.cchkhasur < 0) {
        this.cchkhasur = 0;
      }
      if (this.expkho < 0) {
        this.expkho = 0;
      }
      if (this.zaikhokhasur < 0) {
        this.zaikhokhasur = 0;
      }
      if (this.chzkhasur < 0) {
        this.chzkhasur = 0;
      }
      if (this.ykesyakhasur < 0) {
        this.ykesyakhasur = 0;
      }
      if (this.sinjuckhasur < 0) {
        this.sinjuckhasur = 0;
      }
    }

    /**
     * トラン・リマークによる数量調整を行う。 計算対象にしない項目の数値を０にする。
     *
     * @param trncod トランコード
     * @param rmcod リマークコード
     */
    public void ajustSettingValue(Trncod trncod, Rmcod rmcod) {
      if (Rmcod.KYOSEI == rmcod || Syacod.CHUZAN_MUSHI == this.syacod) {
        this.chzkhasur = 0;
        this.ykesyakhasur = 0;
        this.sinjuckhasur = 0;
      } else if (Rmcod.RESERVE == rmcod) {
        this.zaikhokhasur = 0;
        this.chzkhasur = 0;
        this.ykesyakhasur = 0;
      } else if (Rmcod.KYOSEI_RESERVE == rmcod) {
        this.zaikhokhasur = 0;
        this.chzkhasur = 0;
        this.ykesyakhasur = 0;
        this.sinjuckhasur = 0;
      } else if (trncod.isMae3kt("125") || trncod.isMae3kt("127")) {
        this.cchkhasur = 0;
        this.expkho = 0;
        this.zaikhokhasur = 0;
        this.chzkhasur = 0;
        this.ykesyakhasur = 0;
      } else if (trncod.isMae3kt("230") || trncod.isMae3kt("250") || trncod.isMae3kt("252")
          || trncod.isMae3kt("285") || trncod.isMae3kt("290")) {
        // 調整なし
      } else {
        this.chzkhasur = 0;
        this.ykesyakhasur = 0;
      }
    }

    /**
     * 帳残更新有無による数量調整を行う 帳残更新有りの場合は在庫訂正数を０で計算する
     *
     * @param cyzupdkbn 帳残更新区分
     */
    public void ajustCyzupdkbn(String cyzupdkbn) {
      if ("Y".equals(cyzupdkbn)) {
        this.sumzaiteisurpls = 0;
        this.sumzaiteisurmns = 0;
      }
    }

    /**
     * 引当可能数を算出する。
     *
     * @return 算出結果
     */
    public int getHikiateKanosuu() {
      return (this.zaisur + this.sumzaiteisurpls - this.sumzaiteisurmns - this.cchkhasur
          - this.expkho - this.zaikhokhasur - this.chzkhasur - this.ykesyakhasur
          - this.sinjuckhasur);
    }

    public int getHikiateKanosuuRsv(String tokcod, Rmcod rmcod) {
      if (Rmcod.RESERVE != rmcod && Rmcod.KYOSEI_RESERVE != rmcod
          && Rmcod.RESERVE_FURYO != rmcod) {
        return this.getHikiateKanosuu();
      }

      int[] values = new int[3];
      values[0] = this.getHikiateKanosuu();
      values[1] = this.orgZaikhokhasur;

      KakushaTokuisakiEntity kakushaTokuisakiEntity = kakushaTokuisakiMapper.select(
          KakushaTokuisakiEntity.builder().daikaiskbcod(this.daikaiskbcod).tokcod(tokcod).build());
      if (Objects.nonNull(kakushaTokuisakiEntity)) {
        // 品番マスタに存在しないことは想定しない
        int tergrpcod = hinbanMapper
            .select(
                HinbanEntity.builder().daikaiskbcod(this.daikaiskbcod).kigbng(this.kigbng).build())
            .getTergrpcod();

        TantoTerritoryEntity tantoTerritoryEntity = Optional
            .ofNullable(tantoTerritoryMapper.select(TantoTerritoryEntity.builder()
                .daikaiskbcod(this.daikaiskbcod).tokcod(tokcod).tergrpcod(tergrpcod).build()))
            .orElseGet(() -> tantoTerritoryMapper.select(TantoTerritoryEntity.builder()
                .daikaiskbcod(this.daikaiskbcod).tokcod(tokcod).tergrpcod(1).build()));

        String eigcod =
            Objects.nonNull(tantoTerritoryEntity) ? tantoTerritoryEntity.getEigcod() : "";

        ZaikoKakuhoEntity jokenTokuisaki =
            ZaikoKakuhoEntity.builder().daikaiskbcod(this.daikaiskbcod).kigbng(this.kigbng)
                .skocod(this.skocod).zkhtoksyykbn("2").tokcod(tokcod).zaikhokbn("0").build();
        ZaikoKakuhoEntity jokenSyyten = jokenTokuisaki.toBuilder().zkhtoksyykbn("1").build();
        ZaikoKakuhoEntity jokenEigyosho =
            ZaikoKakuhoEntity.builder().daikaiskbcod(this.daikaiskbcod).kigbng(this.kigbng)
                .skocod(this.skocod).eigcod(eigcod).zaikhokbn("0").build();

        List<ZaikoKakuhoEntity> zaikoKakuhoList =
            zaikoKakuhoMapper.selectZaikoKakuhoList(jokenTokuisaki, jokenSyyten, jokenEigyosho);
        values[2] = zaikoKakuhoList.stream().mapToInt(t -> t.getZaikhokhasur()).sum();
      }

      return Arrays.stream(values).sorted().findFirst().getAsInt();
    }
  }
}
