package jp.co.jdsnet.common.logic.implement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import jp.co.jdsnet.common.domain.entity.kaisha.EigyoshoShuyakuMeisaiEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.EigyoshoShuyakuSokoShuyakuMidashiEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.KaishaQueryControlEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.SokoShuyakuMeisaiEntity;
import jp.co.jdsnet.common.domain.entity.sysmas.JokenEntity;
import jp.co.jdsnet.common.domain.mapper.kaisha.EigyoshoShuyakuMeisaiMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.EigyoshoShuyakuSokoShuyakuMidashiMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaQueryControlMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.SokoShuyakuMeisaiMapper;
import jp.co.jdsnet.common.domain.mapper.sysmas.JokenMapper;
import jp.co.jdsnet.common.domain.vo.EigyoshoSokoGroupVo;
import jp.co.jdsnet.common.domain.vo.KaishaProcDateInfo;
import jp.co.jdsnet.common.logic.KaishaRelatedSharedService;
import lombok.RequiredArgsConstructor;

/**
 * 会社関連の共通処理実装クラス
 *
 * @author r-matsumura
 *
 */

@RequiredArgsConstructor
@Service
public class KaishaRelatedSharedServiceImpl implements KaishaRelatedSharedService {

  private final KaishaQueryControlMapper kaishaQueryControlMapper;
  private final KaishaMapper kaishaMapper;
  // private final EigyoshoSokoRelationMapper eigyoshoSokoRelationMapper;
  private final EigyoshoShuyakuSokoShuyakuMidashiMapper eigyoshoShuyakuSokoShuyakuMidashiMapper;
  private final EigyoshoShuyakuMeisaiMapper eigyoshoShuyakuMeisaiMapper;
  private final SokoShuyakuMeisaiMapper sokoShuyakuMeisaiMapper;
  private final JokenMapper jokenMapper;

  @Override
  public List<String> getKaiQueryList(String daikaiskbcod, String kaiskbcod, String tblnm) {
    List<String> kaishaList = new ArrayList<>();

    KaishaQueryControlEntity entity = kaishaQueryControlMapper
        .select(KaishaQueryControlEntity.builder().daikaiskbcod(daikaiskbcod).tblnm(tblnm).build());

    if (Objects.isNull(entity) || "0".equals(entity.getKaigetkbn())) {
      kaishaList.add(daikaiskbcod);
    } else if ("1".equals(entity.getKaigetkbn())
        || ("2".equals(entity.getKaigetkbn()) && !daikaiskbcod.equals(kaiskbcod))) {
      kaishaList.add(kaiskbcod);
    } else {
      kaishaList.addAll(kaishaMapper.getKaiskbcodList(daikaiskbcod));
    }
    return kaishaList;
  }

  @Override
  public List<EigyoshoSokoGroupVo> getEigSkoGrpList(String daikaiskbcod, String kaiskbcod,
      String gmnlstid, String gmnlstkbn, String fncno) throws NoSuchElementException {

    List<EigyoshoShuyakuSokoShuyakuMidashiEntity> eigskoEntityList =
        eigyoshoShuyakuSokoShuyakuMidashiMapper
            .selectEigSkoList(daikaiskbcod, gmnlstid, fncno, daikaiskbcod, gmnlstkbn).stream()
            .sorted(Comparator.comparing(EigyoshoShuyakuSokoShuyakuMidashiEntity::getSrtseq))
            .toList();

    if (eigskoEntityList.isEmpty()) {
      throw new NoSuchElementException();
    }

    List<EigyoshoSokoGroupVo> result = eigskoEntityList.stream().map(entity -> {
      List<String> eigcodList = eigyoshoShuyakuMeisaiMapper
          .selectEigcodList(daikaiskbcod, daikaiskbcod, gmnlstkbn, entity.getEigsyycod())
          .stream().sorted(Comparator.comparing(EigyoshoShuyakuMeisaiEntity::getSrtseq))
          .map(t -> t.getEigcod()).toList();
      if (eigcodList.isEmpty()) {
        eigcodList = Stream.concat(eigcodList.stream(), Stream.of(entity.getEigsyycod())).toList();
      }

      List<String> skocodList = sokoShuyakuMeisaiMapper
          .selectSkocodList(daikaiskbcod, daikaiskbcod, gmnlstkbn, entity.getSkosyycod())
          .stream().sorted(Comparator.comparing(SokoShuyakuMeisaiEntity::getSrtseq))
          .map(t -> t.getSkocod()).toList();
      if (skocodList.isEmpty()) {
        skocodList = Stream.concat(skocodList.stream(), Stream.of(entity.getSkosyycod())).toList();
      }

      return EigyoshoSokoGroupVo.builder().eighjinm(entity.getEigsyynm())
          .skohjinm(entity.getSkosyynm()).eiggrpcod(entity.getEigsyycod())
          .skogrpcod(entity.getSkosyycod()).eigcodList(eigcodList)
          .skocodList(skocodList).build();
    }).collect(Collectors.toList());

    return result;
  }

  @Override
  public KaishaProcDateInfo getKaishaProcDateInfo(String daikaiskbcod)
      throws NoSuchElementException {
    List<KaishaProcDateInfo> procDateInfoList = new ArrayList<>();
    JokenEntity entity = jokenMapper.selectWithoutLogicalDelete(
        JokenEntity.builder().kaiskbcod("JDS").keyfld("M05010V").build());
    if (Objects.isNull(entity)) {
      throw new NoSuchElementException("条件テーブルに「キー：M05010V」が登録されていません。");
    }

    String txt = entity.getTxt();
    KaishaProcDateInfo baseData =
        KaishaProcDateInfo.builder().prcdte(Integer.parseInt(txt.substring(0, 8)))
            .lastPrcdte(Integer.parseInt(txt.substring(8, 16))).dayOfWeek(txt.substring(16, 17))
            .weekOfYear(Integer.parseInt(txt.substring(17, 19))).build();

    int startIdx = 23;
    for (int i = 0; i < Integer.parseInt(txt.substring(21, 23)); i++) {
      KaishaProcDateInfo kaishaProcDateInfo = baseData.toBuilder()
          .daikaiskbcod(txt.substring(startIdx, startIdx += 3))
          .mkrsmedte(Integer.parseInt(txt.substring(startIdx, startIdx += 6)))
          .calendarPosition(txt.substring(startIdx, startIdx += 2))
          .kaddtekbn(txt.substring(startIdx, startIdx += 1))
          .edpPrcdtekbn(txt.substring(startIdx, startIdx += 1))
          .edpSmedtekbn(txt.substring(startIdx, startIdx += 1))
          .edpWeeklykbn(txt.substring(startIdx, startIdx += 1))
          .edpEndOfMonthkbn(txt.substring(startIdx, startIdx += 1))
          .lastMkrsmedte(Integer.parseInt(txt.substring(startIdx += 5, startIdx += 6)))
          .lastWeeklyprcdte(Integer.parseInt(txt.substring(startIdx, startIdx += 6)))
          .lastEndOfMonthprcdte(Integer.parseInt(txt.substring(startIdx, startIdx += 6))).build();

      procDateInfoList.add(kaishaProcDateInfo);
      startIdx += 5;
    }

    return procDateInfoList.stream().filter(v -> daikaiskbcod.equals(v.getDaikaiskbcod()))
        .findFirst().orElseThrow(() -> new NoSuchElementException("会社の情報が登録されていません。"));
  }
}
