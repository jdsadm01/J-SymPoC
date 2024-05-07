package jp.co.jdsnet.common.entry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import jp.co.jdsnet.common.domain.entity.henpin.HenpinShijiMidashiEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity;
import jp.co.jdsnet.common.domain.entity.syseve.TargetEntity;
import jp.co.jdsnet.common.domain.mapper.henpin.HenpinShijiMeisaiMapper;
import jp.co.jdsnet.common.domain.mapper.henpin.HenpinShijiMidashiMapper;
import jp.co.jdsnet.common.utils.GlobalConstants.Updkbn;
import lombok.RequiredArgsConstructor;

/**
 * 返品用エントリーサービス
 *
 * @author r-matsumura
 *
 */
@RequiredArgsConstructor
@Service("EntryServiceForHenpin")
public class EntryServiceForHenpin implements EntryService<HenpinShijiMidashiEntity> {

  private final HenpinShijiMidashiMapper henpinShijiMidashiMapper;
  private final HenpinShijiMeisaiMapper henpinShijiMeisaiMapper;

  private int sysdate = 0;
  private int systime = 0;

  /**
   * 返品指示見出IDとSEQを付与し、返品指示見出/明細に登録を行う。
   */
  @Override
  public TargetEntity entry(final EventEntity eventEntity, HenpinShijiMidashiEntity midashiEntity)
      throws Exception {
    LocalDateTime now = LocalDateTime.now();
    sysdate = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("yyMMdd")));
    systime = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HHmmss")));

    String keyString = /* insertEntity(midashiEntity) */"";
    System.out.println("insert dummy");

    return TargetEntity.builder().trnfulcod(eventEntity.getPrctrn())
        .motsvcid(eventEntity.getGmnid()).saksvcid(eventEntity.getSvcid()).kenkey(keyString)
        .tgtstskbn("0").updkbn(Updkbn.INSERT.getCode()).inpdte(sysdate).inpjkk(systime)
        .upddte(sysdate).updjkk(systime).build();
  }

  private String insertEntity(HenpinShijiMidashiEntity midashiEntity) throws Exception {
    int nextseq =
        henpinShijiMidashiMapper.getNextSeq(midashiEntity.getInpdte(), midashiEntity.getBshcod());
    while (true) {
      midashiEntity = midashiEntity.toBuilder().seq(nextseq)
          .hpnsjimdsid(createHnpsjimdsid(midashiEntity, nextseq)).updkbn(Updkbn.INSERT.getCode())
          .upddte(sysdate).updjkk(systime).build();
      try {
        henpinShijiMidashiMapper.insert(midashiEntity);
        break;
      } catch (DuplicateKeyException e) {
        nextseq++;
      }
    }
    final String hpnsjimdsid = midashiEntity.getHpnsjimdsid();
    midashiEntity.getMeisaiList().stream().map(t -> t.toBuilder().hpnsjimdsid(hpnsjimdsid)
        .updkbn(Updkbn.INSERT.getCode()).upddte(sysdate).updjkk(systime).build()).forEach(t -> {
          henpinShijiMeisaiMapper.insert(t);
        });

    return hpnsjimdsid;
  }

  private String createHnpsjimdsid(HenpinShijiMidashiEntity entity, int seq) {
    return String.format("%06d", entity.getInpdte()) + String.format("%-4s", entity.getBshcod())
        + String.format("%06d", seq);
  }

  @Override
  public String getServiceId() {
    return EntryServiceForHenpin.class.getSimpleName();
  }
}
