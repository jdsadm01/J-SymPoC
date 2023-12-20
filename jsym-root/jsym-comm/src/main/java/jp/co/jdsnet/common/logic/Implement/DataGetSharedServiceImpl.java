package jp.co.jdsnet.common.logic.Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.common.domain.entity.dbc.EigyoshoSokoEntity;
import jp.co.jdsnet.common.domain.entity.dbc.KaishaQueryControlEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.Vtbkai01Entity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KyotsuTokuisakiEntity;
import jp.co.jdsnet.common.domain.mapper.dbc.EigyoshoGroupMapper;
import jp.co.jdsnet.common.domain.mapper.dbc.EigyoshoSokoMapper;
import jp.co.jdsnet.common.domain.mapper.dbc.KaishaQueryControlMapper;
import jp.co.jdsnet.common.domain.mapper.dbc.SokoGroupMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.Vtbkai01Mapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KakushaTokuisakiMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KyotsuTokuisakiMapper;
import jp.co.jdsnet.common.domain.vo.EigyoshoSokoGroupVO;
import jp.co.jdsnet.common.domain.vo.TokuisakiAndDsVO;
import jp.co.jdsnet.common.logic.DataGetSharedService;
import jp.co.jdsnet.common.utils.StringUtility;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataGetSharedServiceImpl implements DataGetSharedService {

  private final KaishaQueryControlMapper kaishaQueryControlMapper;
  private final KaishaMapper kaishaMapper;
  private final Vtbkai01Mapper ka01Mapper;
  private final EigyoshoSokoMapper eigyoshoSokoMapper;
  private final EigyoshoGroupMapper eigyoshoGroupMapper;
  private final SokoGroupMapper sokoGroupMapper;
  private final KyotsuTokuisakiMapper kyotsuTokuisakiMapper;
  private final KakushaTokuisakiMapper KakushaTokuisakiMapper;

  public List<String> getKaiQueryList(String daikaiskbcod, String kaiskbcod, String tblnm) {
    List<String> kaiQueryList = new ArrayList<>();

    KaishaQueryControlEntity entity = kaishaQueryControlMapper
        .select(KaishaQueryControlEntity.builder().daikaiskbcod(daikaiskbcod).tblnm(tblnm).build());

    if (Objects.isNull(entity) || "0".equals(entity.getKaigetkbn())) {
      kaiQueryList.add(daikaiskbcod);
    } else if ("1".equals(entity.getKaigetkbn())
        || ("2".equals(entity.getKaigetkbn()) && !daikaiskbcod.equals(kaiskbcod))) {
      kaiQueryList.add(kaiskbcod);
    } else {
      kaiQueryList.addAll(kaishaMapper.selectKaiskbcodList(daikaiskbcod));
    }
    return kaiQueryList;
  }

  public List<EigyoshoSokoGroupVO> getEigSkoGrpList(String daikaiskbcod, String kaiskbcod,
      String pnlLstId, String pnlLstKbn, String sykKbn) throws Exception {
//    List<EigyoshoSokoGroupVO> result = new LinkedList<>();

    List<EigyoshoSokoEntity> eigskoEntityList = eigyoshoSokoMapper.selectEigSkoList(daikaiskbcod,
        pnlLstId, sykKbn, this.getKaiQueryList(daikaiskbcod, kaiskbcod, "VTBDBC08"), pnlLstKbn);

    if (eigskoEntityList.isEmpty()) {
      throw new Exception();
    }

    List<EigyoshoSokoGroupVO> result = eigskoEntityList.stream().map(entity -> {
      List<String> eigcodList = eigyoshoGroupMapper
          .selectEigcodList(daikaiskbcod, this.getKaiQueryList(daikaiskbcod, kaiskbcod, "VTBDBC09"),
              pnlLstKbn, entity.getEiggrpcod())
          .stream().map(t -> t.getEigcod()).collect(Collectors.toList());
      if (eigcodList.isEmpty()) {
        eigcodList.add(entity.getEiggrpcod());
      }

      List<String> skocodList = sokoGroupMapper
          .selectSkocodList(daikaiskbcod, this.getKaiQueryList(daikaiskbcod, kaiskbcod, "VTBDBC10"),
              pnlLstKbn, entity.getSkogrpcod())
          .stream().map(t -> t.getSkocod()).collect(Collectors.toList());
      if (skocodList.isEmpty()) {
        skocodList.add(entity.getSkogrpcod());
      }

//      result.add(EigyoshoSokoGroupVO.builder()
//      .hjinm1(entity.getHjinm1())
//      .hjinm2(entity.getHjinm2())
//      .eiggrpcod(entity.getEiggrpcod())
//      .skogrpcod(entity.getSkogrpcod())
//      .eigcodList(eigcodList)
//      .skocodList(skocodList)
//      .build());
      return EigyoshoSokoGroupVO.builder().hjinm1(entity.getHjinm1()).hjinm2(entity.getHjinm2())
          .eiggrpcod(entity.getEiggrpcod()).skogrpcod(entity.getSkogrpcod()).eigcodList(eigcodList)
          .skocodList(skocodList).build();
    }).collect(Collectors.toList());

    return result;
  }

  public TokuisakiAndDsVO getKyotsuAndKakushaTokuisakiData(String daikaiskbcod, String tokcod)
      throws Exception {
    String tokcod8kt = convertTokcod8kt(daikaiskbcod, tokcod);
    
    return TokuisakiAndDsVO.builder()
        .kyotsuTokuisaki(checkKkyotsuTokuisaki(tokcod8kt))
        .kakushaTokuisaki(checkKakushaTokuisaki(daikaiskbcod, tokcod8kt))
        .build();
  }

  private KyotsuTokuisakiEntity checkKkyotsuTokuisaki(String tokcod) throws Exception {
    KyotsuTokuisakiEntity entity = kyotsuTokuisakiMapper
        .selectWithoutLogicalDelete(KyotsuTokuisakiEntity.builder().tokcod(tokcod).build());
    if (Objects.isNull(entity)) {
      throw new Exception("得意先無しエラー");
    }
    return entity;
  }

  private KakushaTokuisakiEntity checkKakushaTokuisaki(String daikaiskbcod, String tokcod)
      throws Exception {
    KakushaTokuisakiEntity entity = KakushaTokuisakiMapper.selectWithoutLogicalDelete(
        KakushaTokuisakiEntity.builder().daikaiskbcod(daikaiskbcod).tokcod(tokcod).build());
    if (Objects.isNull(entity)) {
      throw new Exception("得意先無しエラー");
    }
    return entity;
  }

  public String convertTokcod8kt(String daikaiskbcod, String tokcod) throws Exception {
    if (StringUtils.isBlank(tokcod)) {
      return "";
    }

    if (tokcod.length() > 6) {
      return StringUtility.lpad(tokcod, 8, "0");
    }

    String kaicod = "00";
    String head = "00";

    tokcod = StringUtility.lpad(tokcod, 6, "0");
    String tokcodHead2kt = tokcod.substring(0, 2);
    if ("***".equals(daikaiskbcod)) {
      head = "99";
    } else if (!"JDS".equals(daikaiskbcod)) {
      Vtbkai01Entity kai01Entity = ka01Mapper
          .selectWithoutLogicalDelete(Vtbkai01Entity.builder().kaiskbcod(daikaiskbcod).build());
      if (Objects.isNull(kai01Entity)) {
        throw new Exception("会社無し");
      }
      if ("1".equals(kai01Entity.getGamflg())) {
        head = "99";
      }
      kaicod = kai01Entity.getKaicod();
    }
    if ("00".equals(tokcodHead2kt) || tokcodHead2kt.compareTo("09") >= 0) {
      head = kaicod;
    }
    return head + tokcod;
  }
}
