package jp.co.jdsnet.master.domain.service.implement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.common.domain.entity.soko.GameKyotsuTokuisakiHenkanEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KyotsuTokuisakiEntity;
import jp.co.jdsnet.common.domain.mapper.soko.GameKyotsuTokuisakiHenkanMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KyotsuTokuisakiMapper;
import jp.co.jdsnet.common.logic.CheckSharedService;
import jp.co.jdsnet.common.logic.DataGetSharedService;
import jp.co.jdsnet.master.domain.dto.NohsakEntryDTO;
import jp.co.jdsnet.master.domain.dto.NohsakEntryDetailDTO;
import jp.co.jdsnet.master.domain.service.NohsakEntryService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NohsakEntryServiceImpl implements NohsakEntryService {

  private final CheckSharedService checkSharedService;
  private final DataGetSharedService dataGetSharedService;
  private final GameKyotsuTokuisakiHenkanMapper gameKyotsuTokuisakiHenkanMapper;
  private final KyotsuTokuisakiMapper kyotsuTokuisakiMapper;

  /**
   * {@inheritDoc}
   */
  @Override
  public NohsakEntryDTO init(UserInfoVO vo) throws Exception {
    boolean isOnline = CheckSharedService.SERVICETIME_ONLINE.equals(checkSharedService
        .checkServiceTime(vo.getDaikaiskbcod(), vo.getUsrbun(), "VMJ026", "001", "O"));

    return NohsakEntryDTO.builder().userInfo(vo).yykflg("0").yykdte("").bshcod(vo.getBshcod())
        .prckbn("S").detailList(createDetailList(90)).build();
  }

  // private List<LabelData> createPrckbnList() {
  // List<LabelData> prckbnList = new ArrayList<>();
  // prckbnList.add(LabelData.builder().value("T").text("S 得意先コード照会").build());
  // prckbnList.add(LabelData.builder().value("S").text("S 納品先コード照会").build());
  // prckbnList.add(LabelData.builder().value("U").text("U 納品先コード更新").build());
  // prckbnList.add(LabelData.builder().value("A").text("A 納品先コード登録").build());
  // prckbnList.add(LabelData.builder().value("D").text("D 納品先コード削除").build());
  // return prckbnList;
  // }

  private List<NohsakEntryDetailDTO> createDetailList(int msisuu) {
    List<NohsakEntryDetailDTO> detailList = new ArrayList<>();
    IntStream.range(0, msisuu).forEach(i -> {
      detailList.add(NohsakEntryDetailDTO.builder().build());
    });
    return detailList;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public NohsakEntryDTO searchByTokcod(NohsakEntryDTO dto) throws Exception {
    List<NohsakEntryDetailDTO> detailList = dto.getDetailList().stream().map(t -> {
      if(StringUtils.isBlank(t.getTokcod())) {
        return t;
      }
      //得意先チェック
      //DSチェック
      GameKyotsuTokuisakiHenkanEntity entity =
          gameKyotsuTokuisakiHenkanMapper.selectWithName(GameKyotsuTokuisakiHenkanEntity.builder()
              .bshcod(dto.getBshcod()).tokcod(t.getTokcod()).dscod(t.getDscod()).build());
      return t.toBuilder().gkytokcod(entity.getGkytokcod()).gkytoknm(entity.getGkytoknm())
          .toknm(entity.getToknm()).updkbn(entity.getUpdkbn()).upddte(entity.getUpddte())
          .updjkk(entity.getUpdjkk()).build();
    }).collect(Collectors.toList());
    return dto.toBuilder().detailList(detailList).build();
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public NohsakEntryDTO searchByGkyTokcod(NohsakEntryDTO dto) throws Exception {
    List<NohsakEntryDetailDTO> detailList = new ArrayList<>();
    for (NohsakEntryDetailDTO detail : dto.getDetailList()) {
      if (StringUtils.isBlank(detail.getGkytokcod())) {
        continue;
      }
      List<GameKyotsuTokuisakiHenkanEntity> entityList = gameKyotsuTokuisakiHenkanMapper
          .selectWithNameByGyktokcod(GameKyotsuTokuisakiHenkanEntity.builder()
              .bshcod(dto.getBshcod()).gkytokcod(detail.getGkytokcod()).build());

      List<NohsakEntryDetailDTO> subList = entityList.stream().map(t -> {
        return NohsakEntryDetailDTO.builder().tokcod(t.getTokcod()).gkytokcod(t.getGkytokcod())
            .gkytoknm(t.getGkytoknm()).toknm(t.getToknm()).updkbn(t.getUpdkbn())
            .upddte(t.getUpddte()).updjkk(t.getUpdjkk()).build();
      }).collect(Collectors.toList());
      detailList.addAll(subList);
    }
    return dto.toBuilder().detailList(detailList).build();
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public NohsakEntryDTO checkDetail(NohsakEntryDTO dto) throws Exception {
    List<NohsakEntryDetailDTO> detailList =
        dto.getDetailList().stream().filter(t -> !StringUtils.isBlank(t.getTokcod())).map(t -> {
          KyotsuTokuisakiEntity entity;
          try {
            entity = kyotsuTokuisakiMapper.selectWithoutLogicalDelete(
                KyotsuTokuisakiEntity.builder().tokcod(t.getGkytokcod()).build());
          } catch (Exception e) {
            entity = KyotsuTokuisakiEntity.builder().build();
            e.printStackTrace();
          }
          return t.toBuilder()
              .gkytoknm(entity.getToknm1() + entity.getToknm2())
              .build();
        }).collect(Collectors.toList());
    return dto.toBuilder().detailList(detailList).build();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public NohsakEntryDTO update(NohsakEntryDTO dto) throws Exception {
    LocalDateTime now = LocalDateTime.now();
    int sysdate = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("uuMMdd")));
    int systime = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HHmmss")));
    dto.getDetailList().forEach(t -> {
      GameKyotsuTokuisakiHenkanEntity lock =
          gameKyotsuTokuisakiHenkanMapper.selectForUpdate(GameKyotsuTokuisakiHenkanEntity.builder()
              .bshcod(dto.getBshcod()).tokcod(t.getTokcod()).dscod(t.getDscod()).build());

      if (Objects.nonNull(lock)) {
        gameKyotsuTokuisakiHenkanMapper.update(lock.toBuilder().gkytokcod(t.getGkytokcod())
            .updkbn("U").upddte(sysdate).updjkk(systime).build());
      }
    });
    // throw new RuntimeException();
    return dto;
  }
}
