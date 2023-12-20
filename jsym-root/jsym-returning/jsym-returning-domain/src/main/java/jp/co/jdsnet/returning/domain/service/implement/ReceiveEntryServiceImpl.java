package jp.co.jdsnet.returning.domain.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.base.webapp.parts.LabelData;
import jp.co.jdsnet.common.domain.entity.henpin.HenpinShijiMeisaiEntity;
import jp.co.jdsnet.common.domain.entity.henpin.HenpinShijiMidashiEntity;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.soko.ZaikoJokenEntity;
import jp.co.jdsnet.common.domain.entity.syseve.TargetEntity;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaMapper;
import jp.co.jdsnet.common.domain.mapper.soko.ZaikoJokenMapper;
import jp.co.jdsnet.common.domain.vo.TokuisakiAndDsVO;
import jp.co.jdsnet.common.entry.EntryServiceForHenpin;
import jp.co.jdsnet.common.logic.DataGetSharedService;
import jp.co.jdsnet.common.logic.KigbngCheckSharedService;
import jp.co.jdsnet.returning.domain.dto.ReceiveEntryDTO;
import jp.co.jdsnet.returning.domain.dto.ReceiveEntryDetailDTO;
import jp.co.jdsnet.returning.domain.service.ReceiveEntryService;
import lombok.RequiredArgsConstructor;

/**
 * 返品入力
 *
 * @author xx
 *
 */
@RequiredArgsConstructor
@Service
public class ReceiveEntryServiceImpl extends EntryServiceForHenpin<ReceiveEntryDTO>
    implements ReceiveEntryService {

  private final KaishaMapper kaishaMapper;
  private final ZaikoJokenMapper zaikoJokenMapper;
  private final DataGetSharedService dataGetSharedService;
  private final KigbngCheckSharedService kigbngCheckSharedService;

  /**
   * {@inheritDoc}
   */
  @Override
  public ReceiveEntryDTO init(String daikaiskbcod, String usrbun) {
    List<String> daikaiskbcodList = kaishaMapper.selectDaikaiskbcodList(usrbun);
    // TODO 自動生成されたメソッド・スタブ
    return ReceiveEntryDTO.builder().daikaiskbcod(daikaiskbcod).daikaiskbcodList(daikaiskbcodList)
        .trncod("260B").trncodList(createTrncodList()).kinhjikbn("1")
        .kinhjikbnList(createKinhjikbnList()).hpntsyukeflg("0")
        .hpntsyukeflgList(createHpntsyukeflgList()).build();
  }

  private List<LabelData> createTrncodList() {
    List<LabelData> trncodList = new ArrayList<>();
    trncodList.add(LabelData.builder().value("260B").text("260　通常返品バーコード入力").build());
    trncodList.add(LabelData.builder().value("262B").text("262　通常外返品バーコード入力").build());
    trncodList.add(LabelData.builder().value("260").text("260　通常返品入力").build());
    trncodList.add(LabelData.builder().value("262").text("262　通常外返品入力").build());
    trncodList.add(LabelData.builder().value("292").text("292　特販返品入力").build());
    trncodList.add(LabelData.builder().value("232").text("232　商品返品入力").build());
    trncodList.add(LabelData.builder().value("277").text("277　特注返品入力").build());
    trncodList.add(LabelData.builder().value("287").text("287　輸出返品入力").build());
    return trncodList;
  }

  private List<LabelData> createKinhjikbnList() {
    List<LabelData> kinhjikbnList = new ArrayList<>();
    kinhjikbnList.add(LabelData.builder().value("1").text("表示する").build());
    kinhjikbnList.add(LabelData.builder().value("0").text("表示しない").build());
    return kinhjikbnList;
  }

  private List<LabelData> createHpntsyukeflgList() {
    List<LabelData> hpntsyukeflgList = new ArrayList<>();
    hpntsyukeflgList.add(LabelData.builder().value("0").text("特受しない").build());
    hpntsyukeflgList.add(LabelData.builder().value("1").text("特受する").build());
    return hpntsyukeflgList;
  }

  /**
   * {@inheritDoc}
   */
  public ReceiveEntryDTO checkHeader(ReceiveEntryDTO dto) throws Exception {

    // スタックのチェック

    // トランコードチェック

    // 得意先チェック
    TokuisakiAndDsVO tokuisakiVo = dataGetSharedService
        .getKyotsuAndKakushaTokuisakiData(dto.getDaikaiskbcod(), dto.getTokcod());

    // リマークチェック

    // 管理区分チェック

    // 仕向地チェック

    // MSチェック
    
    return dto.toBuilder().tokcod(tokuisakiVo.getKyotsuTokuisaki().getTokcod())
        .toknm(tokuisakiVo.getKyotsuTokuisaki().getToknm1()
            + tokuisakiVo.getKyotsuTokuisaki().getToknm2())
        .telbng(tokuisakiVo.getKyotsuTokuisaki().getToktelbng())
        .smedte(String.valueOf(tokuisakiVo.getKakushaTokuisaki().getSeismb()))
        .detailList(createDetailList(450, dto.getRmcod())).build();
  }

  private List<ReceiveEntryDetailDTO> createDetailList(int msisuu, String rmcod) {
    List<ReceiveEntryDetailDTO> detailList = new ArrayList<>();
    IntStream.range(0, msisuu).forEach(i -> {
      detailList.add(ReceiveEntryDetailDTO.builder().rmcod(rmcod).build());
    });
    return detailList;
  }


  /**
   * {@inheritDoc}
   */
  public ReceiveEntryDTO checkDetail(ReceiveEntryDTO dto) throws Exception {
    List<ReceiveEntryDetailDTO> detailList =
        dto.getDetailList().stream().filter(t -> !StringUtils.isBlank(t.getKigbng())).map(t -> {
          try {
            HinbanEntity hinbanEntity =
                kigbngCheckSharedService.getHinban(dto.getDaikaiskbcod(), t.getKigbng());

            String tna = checkTanaageshiteihin(dto.getDaikaiskbcod(), hinbanEntity.getKigbng());

            return t.toBuilder().kigbng(hinbanEntity.getKigbng()).hjihnb(hinbanEntity.getHjihnb()).artnm(hinbanEntity.getArtnm())
                .titnm(hinbanEntity.getTitnm()).setcod(hinbanEntity.getSetcod())
                .tomrakcod(hinbanEntity.getTomrakcod()).tnpkbn(hinbanEntity.getTnpkbn())
                .hbidte(hinbanEntity.getHbidte()).tnaste(tna).build();

          } catch (Exception e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return t;
          }
        }).collect(Collectors.toList());
    return dto.toBuilder().detailList(detailList).build();
  }

  private String checkTanaageshiteihin(String daikaiskbcod, String kigbng) {
    String result = "";
    ZaikoJokenEntity zaikoJokenEntity = zaikoJokenMapper.selectForTnasth(daikaiskbcod, kigbng)
        .stream().findFirst().orElse(ZaikoJokenEntity.builder().build());

    if (!"3".equals(zaikoJokenEntity.getTnasthkbn()) && zaikoJokenEntity.getTnasjijogsur() > 0) {
      result = "○";
    }
    return result;
  }

  /**
   * {@inheritDoc}
   */
  public ReceiveEntryDetailDTO checkHinban(ReceiveEntryDetailDTO dto) throws Exception {
    try {
      HinbanEntity hinbanEntity =
          kigbngCheckSharedService.getHinban(dto.getDaikaiskbcod(), dto.getKigbng());

      String tna = checkTanaageshiteihin(dto.getDaikaiskbcod(), hinbanEntity.getKigbng());

      return dto.toBuilder().kigbng(hinbanEntity.getKigbng()).hjihnb(hinbanEntity.getHjihnb())
          .artnm(hinbanEntity.getArtnm()).titnm(hinbanEntity.getTitnm())
          .setcod(hinbanEntity.getSetcod()).tomrakcod(hinbanEntity.getTomrakcod())
          .tnpkbn(hinbanEntity.getTnpkbn()).hbidte(hinbanEntity.getHbidte()).tnaste(tna).build();

    } catch (Exception e) {
      return dto.toBuilder().hjihnb("品番エラーです。").artnm("").titnm("").setcod(0).tomrakcod("")
          .tnpkbn("").hbidte(0).tnaste("").build();
    }

  }

  /**
   * {@inheritDoc}
   */
  @Transactional
  public void submit(ReceiveEntryDTO dto) throws Exception {
    // スタックチェック
    // トランフルコード取得
    // バーコードなら明細のサマリーと分割
    TargetEntity target = entry("260  000", "SVCID_D020_00", dto);
    // targetMapper.insert(target);
    System.out.println(target.toString());
    throw new RuntimeException("ロールバックテスト");
  }

  @Override
  protected HenpinShijiMidashiEntity createHenpinShijiMidasi(ReceiveEntryDTO dto) {
    return HenpinShijiMidashiEntity.builder().inpdte(sysdate).bshcod(dto.getUserInfo().getBshcod())
        .daikaiskbcod(dto.getDaikaiskbcod()).tokcod(dto.getTokcod()).trncod(dto.getTrncod())
        .hpnjurdte(Integer.parseInt(dto.getHpnjurdte())).hpnutkbng(dto.getHpnutkbng())
        .knrkbn(dto.getKnrkbn()).kinhjikbn(dto.getKinhjikbn()).smtcod(dto.getSmtcod())
        .skrkrt(Double.parseDouble(dto.getSkrkrt()))/*.tokdenbng1(dto.getTokdenbng1()).tokdenbng2(dto.getTokdenbng2())
        .locbng(dto.getLocbng()).odrno(dto.getOdrno())*/.hpnsur(0).hpnkin(0).mscod(dto.getMscod())
        .fmg1(dto.getFmg1()).fmg2(dto.getFmg2()).msisuu(dto.getDetailList().size())
        .hpntsyukeflg(dto.getHpntsyukeflg())/*.suksgn("")*/.cpufulid(dto.getUserInfo().getCpufulid())
        .wsseq4kt(0).prckruflg("0").delflg("0").errariflg("0").stakjyzflg("0").tmukjyzflg("0")
        .updkbn("A").upddte(sysdate).updjkk(systime).inpjkk(systime).stasteflg("0").tmusteflg("0")
        .build();
  }

  @Override
  protected List<HenpinShijiMeisaiEntity> createHenpinShijiMeisaiList(ReceiveEntryDTO dto) {
    return dto.getDetailList().stream()
        .map(t -> HenpinShijiMeisaiEntity.builder().kigbng(t.getKigbng())
            .seq(dto.getDetailList().indexOf(t))
            .hpnsur(Integer.parseInt(t.getHpnsur()))
            .skrtan(/* Double.parseDouble(t.getSkrtan()) */0)
            .hpnkin(0).rmcod(t.getRmcod()).errariflg("0")
            .updkbn("A").upddte(sysdate).updjkk(systime).tankinstekbn("0").build())
        .collect(Collectors.toList());
  }
}
