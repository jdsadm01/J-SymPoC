package jp.co.jdsnet.common.logic.implement;

import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.common.domain.entity.kaisha.JsymKaishaEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.DsEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.DsEntity.Sinkyuusekbn;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KyotsuTokuisakiEntity;
import jp.co.jdsnet.common.domain.mapper.kaisha.JsymKaishaMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.DsMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KakushaTokuisakiMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KyotsuTokuisakiMapper;
import jp.co.jdsnet.common.domain.vo.TokuisakiAndDsVO;
import jp.co.jdsnet.common.logic.TokuisakiRelatedSharedService;
import jp.co.jdsnet.common.utils.GlobalConstants;
import jp.co.jdsnet.common.utils.GlobalConstants.Flg;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;
import jp.co.jdsnet.common.utils.GlobalConstants.Updkbn;
import jp.co.jdsnet.common.utils.StringUtility;
import lombok.RequiredArgsConstructor;

/**
 * 得意先関連の共通処理実装クラス
 *
 * @author r-matsumura
 *
 */
@RequiredArgsConstructor
@Service
public class TokuisakiRelatedSharedServiceImpl implements TokuisakiRelatedSharedService {

  private final JsymKaishaMapper jsymkaishaMapper;
  private final KyotsuTokuisakiMapper kyotsuTokuisakiMapper;
  private final KakushaTokuisakiMapper kakushaTokuisakiMapper;
  private final DsMapper dsMapper;

  @Override
  public TokuisakiAndDsVO getTokuisakiAndDsFullData(String daikaiskbcod, String tokcod,
      String dscod) throws NoSuchElementException, Exception {

    String tokcod8kt = convertTokcod8kt(daikaiskbcod, tokcod);
    return TokuisakiAndDsVO.builder().kyotsuTokuisaki(selectKyotsuTokuisaki(tokcod8kt))
        .kakushaTokuisaki(selectKakushaTokuisaki(daikaiskbcod, tokcod8kt))
        .ds(selectDs(tokcod8kt, dscod)).build();
  }

  @Override
  public TokuisakiAndDsVO getKyotsuTokuisaki(String daikaiskbcod, String tokcod)
      throws NoSuchElementException, Exception {

    String tokcod8kt = convertTokcod8kt(daikaiskbcod, tokcod);
    return TokuisakiAndDsVO.builder().kyotsuTokuisaki(selectKyotsuTokuisaki(tokcod8kt)).build();
  }

  @Override
  public TokuisakiAndDsVO getKakushaTokuisaki(String daikaiskbcod, String tokcod)
      throws NoSuchElementException, Exception {

    String tokcod8kt = convertTokcod8kt(daikaiskbcod, tokcod);
    return TokuisakiAndDsVO.builder()
        .kakushaTokuisaki(selectKakushaTokuisaki(daikaiskbcod, tokcod8kt)).build();
  }

  @Override
  public TokuisakiAndDsVO getDs(String daikaiskbcod, String tokcod, String dscod)
      throws NoSuchElementException, Exception {

    String tokcod8kt = convertTokcod8kt(daikaiskbcod, tokcod);
    return TokuisakiAndDsVO.builder().ds(selectDs(tokcod8kt, dscod)).build();
  }

  @Override
  public TokuisakiAndDsVO getKyotsuAndDs(String daikaiskbcod, String tokcod, String dscod)
      throws NoSuchElementException, Exception {

    String tokcod8kt = convertTokcod8kt(daikaiskbcod, tokcod);
    return TokuisakiAndDsVO.builder().kyotsuTokuisaki(selectKyotsuTokuisaki(tokcod8kt))
        .ds(selectDs(tokcod8kt, dscod)).build();
  }

  @Override
  public boolean checkDsBySinkyuusekbn(Sinkyuusekbn sinkyuusekbn, Trncod trncod) {
    if (trncod.isSinpuTrn() && Sinkyuusekbn.KYUFU_ONLY == sinkyuusekbn) {
      return false;
    } else if (!trncod.isSinpuTrn() && Sinkyuusekbn.SINPU_ONLY == sinkyuusekbn) {
      return false;
    }
    return true;
  }

  private KyotsuTokuisakiEntity selectKyotsuTokuisaki(String tokcod) throws NoSuchElementException {
    KyotsuTokuisakiEntity entity =
        kyotsuTokuisakiMapper.select(KyotsuTokuisakiEntity.builder().tokcod(tokcod).build());
    if (Objects.isNull(entity)
        || Updkbn.DELETE == GlobalConstants.valueOf(Updkbn.class, entity.getUpdkbn())) {
      throw new NoSuchElementException("得意先エラーです");
    }
    return entity;
  }

  private KakushaTokuisakiEntity selectKakushaTokuisaki(String daikaiskbcod, String tokcod)
      throws NoSuchElementException {
    KakushaTokuisakiEntity entity = kakushaTokuisakiMapper
        .select(KakushaTokuisakiEntity.builder().daikaiskbcod(daikaiskbcod).tokcod(tokcod).build());
    if (Objects.isNull(entity)
        || Updkbn.DELETE == GlobalConstants.valueOf(Updkbn.class, entity.getUpdkbn())) {
      throw new NoSuchElementException("得意先エラーです");
    }
    return entity;
  }

  private DsEntity selectDs(String tokcod, String dscod) throws NoSuchElementException {
    if ("".equals(dscod)) {
      return DsEntity.builder().build();
    }
    DsEntity entity = dsMapper.select(DsEntity.builder().tokcod(tokcod).dscod(dscod).build());
    if (Objects.isNull(entity)
        || Updkbn.DELETE == GlobalConstants.valueOf(Updkbn.class, entity.getUpdkbn())) {
      throw new NoSuchElementException("DSエラーです");
    }
    return entity;
  }

  @Override
  public String convertTokcod8kt(String daikaiskbcod, String tokcod) throws Exception {
    if (StringUtils.isBlank(tokcod)) {
      return "";
    }

    if (tokcod.length() > 6) {
      return StringUtility.lpad(tokcod, 8, "0");
    }

    String kaicod = "00";
    String head = "00";

    if ("***".equals(daikaiskbcod)) {
      head = "99";
    } else if (!"JDS".equals(daikaiskbcod)) {
      JsymKaishaEntity kaishaEntity =
          jsymkaishaMapper.select(JsymKaishaEntity.builder().kaiskbcod(daikaiskbcod).build());
      if (Objects.isNull(kaishaEntity)
          || Updkbn.DELETE == GlobalConstants.valueOf(Updkbn.class, kaishaEntity.getUpdkbn())) {
        throw new NoSuchElementException("会社無し");
      }

      if (Flg.ON == GlobalConstants.valueOf(Flg.class, kaishaEntity.getGamflg())) {
        head = "99";
      }
      kaicod = kaishaEntity.getKaicod();
    }

    tokcod = StringUtility.lpad(tokcod, 6, "0");
    String tokcodHead2kt = tokcod.substring(0, 2);
    if ("00".equals(tokcodHead2kt) || tokcodHead2kt.compareTo("09") >= 0) {
      head = kaicod;
    }
    return head + tokcod;
  }

}
