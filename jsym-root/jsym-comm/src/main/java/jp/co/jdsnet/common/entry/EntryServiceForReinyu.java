package jp.co.jdsnet.common.entry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import jp.co.jdsnet.common.domain.entity.kashidashi.KashidashiReinyuMeisaiEntity;
import jp.co.jdsnet.common.domain.entity.kashidashi.KashidashiReinyuMidashiEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity;
import jp.co.jdsnet.common.domain.entity.syseve.TargetEntity;
import jp.co.jdsnet.common.domain.mapper.kashidashi.KashidashiReinyuMeisaiMapper;
import jp.co.jdsnet.common.domain.mapper.kashidashi.KashidashiReinyuMidashiMapper;
import jp.co.jdsnet.common.utils.GlobalConstants.Flg;
import jp.co.jdsnet.common.utils.GlobalConstants.Updkbn;
import lombok.RequiredArgsConstructor;

/**
 * 貸出戻入用エントリーサービス
 *
 * @author r-matsumura
 *
 */
@RequiredArgsConstructor
@Service("EntryServiceForReinyu")
public class EntryServiceForReinyu implements EntryService<KashidashiReinyuMidashiEntity> {

  private final KashidashiReinyuMidashiMapper kashidashiReinyuMidashiMapper;
  private final KashidashiReinyuMeisaiMapper kashidashiReinyuMeisaiMapper;

  private int sysdate = 0;
  private int systime = 0;

  /**
   * 受注見出/明細に登録を行う。
   *
   * <p>
   * SEQと共通固定値の項目は当サービス内でセットして登録を行う。<br>
   * 業務で必要な項目については各画面内でEntityにセットすること。
   */
  @Override
  @Transactional(propagation = Propagation.MANDATORY)
  public TargetEntity entry(final EventEntity eventEntity,
      KashidashiReinyuMidashiEntity midashiEntity)
      throws Exception {
    LocalDateTime now = LocalDateTime.now();
    sysdate = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("yyMMdd")));
    systime = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HHmmss")));

    String keyString = insertEntity(midashiEntity);

    return TargetEntity.builder().trnfulcod(eventEntity.getPrctrn())
        .motsvcid(eventEntity.getGmnid()).saksvcid(eventEntity.getSvcid()).kenkey(keyString)
        .tgtstskbn("0").updkbn(Updkbn.INSERT.getCode()).inpdte(sysdate).inpjkk(systime)
        .upddte(sysdate).updjkk(systime).build();
  }

  private String insertEntity(KashidashiReinyuMidashiEntity entity) throws Exception {
    entity = insertMidashi(entity);

    insertMeisai(entity.getSeq(), entity.getMeisaiList());

    return entity.getKeyString();
  }

  private KashidashiReinyuMidashiEntity insertMidashi(KashidashiReinyuMidashiEntity entity)
      throws Exception {
    int kdareimdsseq = kashidashiReinyuMidashiMapper.getNextSeq(entity.getKdareidte(),
        entity.getTokcod(), entity.getDscod());

    KashidashiReinyuMidashiEntity midashiEntity =
        entity.toBuilder().seq(kdareimdsseq).reistskbn("0").inpchkerrkbn("0")
            .stakjyzflg(Flg.OFF.getCode()).delflg(Flg.OFF.getCode()).errariflg(Flg.OFF.getCode())
        .updkbn(Updkbn.INSERT.getCode()).upddte(sysdate).updjkk(systime).build();

    while (true) {
      try {
        kashidashiReinyuMidashiMapper.insert(midashiEntity);
      } catch (DuplicateKeyException e) {
        midashiEntity = midashiEntity.toBuilder().seq(++kdareimdsseq).build();
        continue;
      }
      break;
    }
    return midashiEntity;
  }

  private void insertMeisai(int kdareimdsseq, List<KashidashiReinyuMeisaiEntity> meisaiList) {
    meisaiList.stream()
        .map(t -> t.toBuilder().kdareimdsseq(kdareimdsseq).seq(meisaiList.indexOf(t) + 1)
            .inpchkerrkbn("0").errariflg(Flg.OFF.getCode()).upddte(sysdate).updjkk(systime).build())
        .forEach(t -> {
          kashidashiReinyuMeisaiMapper.insert(t);
        });
  }

  @Override
  public String getServiceId() {
    return EntryServiceForReinyu.class.getSimpleName();
  }
}
