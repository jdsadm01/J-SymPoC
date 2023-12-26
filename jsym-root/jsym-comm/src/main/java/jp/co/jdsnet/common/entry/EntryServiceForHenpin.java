package jp.co.jdsnet.common.entry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import jp.co.jdsnet.common.domain.entity.henpin.HenpinShijiMeisaiEntity;
import jp.co.jdsnet.common.domain.entity.henpin.HenpinShijiMidashiEntity;
import jp.co.jdsnet.common.domain.entity.syseve.TargetEntity;
import jp.co.jdsnet.common.domain.mapper.henpin.HenpinShijiMeisaiMapper;
import jp.co.jdsnet.common.domain.mapper.henpin.HenpinShijiMidashiMapper;

public abstract class EntryServiceForHenpin<T> implements EntryService<T> {

  @Autowired
  private HenpinShijiMidashiMapper henpinShijiMidashiMapper;
  @Autowired
  private HenpinShijiMeisaiMapper henpinShijiMeisaiMapper;

  protected int sysdate = 0;
  protected int systime = 0;

  public TargetEntity entry(final String trnfulcod, final String saksvcid, T dto) throws Exception {
    LocalDateTime now = LocalDateTime.now();
    sysdate = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("yyMMdd")));
    systime = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HHmmss")));

    final HenpinShijiMidashiEntity midashiEntity = insertHenpinShiji(dto);

    return TargetEntity.builder().trnfulcod(trnfulcod).saksvcid(saksvcid)
        .kenkey(midashiEntity.getKeyString()).build();
  }

  private HenpinShijiMidashiEntity insertHenpinShiji(T dto) throws Exception {
    HenpinShijiMidashiEntity midashiEntity = createHenpinShijiMidasi(dto);
    int nextseq =
        henpinShijiMidashiMapper.getNextSeq(midashiEntity.getInpdte(), midashiEntity.getBshcod());
    while (true) {
      midashiEntity = midashiEntity.toBuilder().seq(nextseq)
          .hpnsjimdsid(createHnpsjimdsid(midashiEntity, nextseq)).build();
      try {
        System.out.println("INSERT_DUMMY DATA=" + midashiEntity.toString());
        // henpinShijiMidashiMapper.insert(midashiEntity);
        break;
      } catch (DuplicateKeyException e) {
        nextseq++;
      }
    }
    final String hpnsjimdsid = midashiEntity.getHpnsjimdsid();
    createHenpinShijiMeisaiList(dto).stream()
        .map(t -> t.toBuilder().hpnsjimdsid(hpnsjimdsid).build()).forEach(t -> {
          System.out.println("INSERT_DUMMY DATA=" + t.toString());
          // henpinShijiMeisaiMapper.insert(t);
        });

    return midashiEntity;
  }

  private String createHnpsjimdsid(HenpinShijiMidashiEntity entity, int seq) {
    return String.format("%06d", entity.getInpdte()) + String.format("%-4s", entity.getBshcod())
        + String.format("%06d", seq);
  }

  /**
   * 返品指示見出を作成する. SEQと返品指示見出ID以外をセットすること.
   * 
   * @return
   */
  abstract protected HenpinShijiMidashiEntity createHenpinShijiMidasi(T dto);

  /**
   * 返品指示明細を作成する. 返品指示見出ID以外をセットすること.
   * 
   * @return
   */
  abstract protected List<HenpinShijiMeisaiEntity> createHenpinShijiMeisaiList(T dto);
}
