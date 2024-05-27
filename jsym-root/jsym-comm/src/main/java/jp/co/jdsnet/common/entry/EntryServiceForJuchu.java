package jp.co.jdsnet.common.entry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import jp.co.jdsnet.common.domain.entity.juchu.JuchuMeisaiEntity;
import jp.co.jdsnet.common.domain.entity.juchu.JuchuMidashiEntity;
import jp.co.jdsnet.common.domain.entity.juchu.OrderStatusEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity;
import jp.co.jdsnet.common.domain.entity.syseve.TargetEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KyotsuTokuisakiEntity;
import jp.co.jdsnet.common.domain.mapper.juchu.JuchuMeisaiMapper;
import jp.co.jdsnet.common.domain.mapper.juchu.JuchuMidashiMapper;
import jp.co.jdsnet.common.domain.mapper.juchu.OrderStatusMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KyotsuTokuisakiMapper;
import jp.co.jdsnet.common.logic.UserRelatedSharedService;
import jp.co.jdsnet.common.logic.UserRelatedSharedService.CurrentNoGetType;
import jp.co.jdsnet.common.utils.GlobalConstants;
import jp.co.jdsnet.common.utils.GlobalConstants.Flg;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;
import jp.co.jdsnet.common.utils.GlobalConstants.Updkbn;
import lombok.RequiredArgsConstructor;

/**
 * 受注用エントリーサービス
 *
 * @author r-matsumura
 *
 */
@RequiredArgsConstructor
@Service("EntryServiceForJuchu")
public class EntryServiceForJuchu implements EntryService<JuchuMidashiEntity> {

  private final JuchuMidashiMapper juchuMidashiMapper;
  private final JuchuMeisaiMapper juchuMeisaiMapper;
  private final KyotsuTokuisakiMapper kyotsuTokuisakiMapper;
  private final UserRelatedSharedService userSharedService;
  private final OrderStatusMapper orderStatusMapper;

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
  public TargetEntity entry(final EventEntity eventEntity, JuchuMidashiEntity midashiEntity)
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

  private String insertEntity(JuchuMidashiEntity entity) throws Exception {
    entity = insertJuchuMidashi(entity);

    insertJuchuMeisai(entity.getSeq(), entity.getMeisaiList());

    return entity.getKeyString();
  }

  private JuchuMidashiEntity insertJuchuMidashi(JuchuMidashiEntity entity) throws Exception {
    int jucmdsseq =
        juchuMidashiMapper.getNextSeq(entity.getJucdte(), entity.getTokcod(), entity.getDscod());

    JuchuMidashiEntity midashiEntity = entity.toBuilder().seq(jucmdsseq).jucstskbn("0")
        .inpchkerrkbn("0").ykesyaflg(Flg.OFF.getCode()).ykesyakjyzflg(Flg.OFF.getCode())
        .stakjyzflg(Flg.OFF.getCode()).delflg(Flg.OFF.getCode()).errariflg(Flg.OFF.getCode())
        .updkbn(Updkbn.INSERT.getCode()).upddte(sysdate).updjkk(systime).build();

    while (true) {
      try {
        juchuMidashiMapper.insert(midashiEntity);
      } catch (DuplicateKeyException e) {
        midashiEntity = midashiEntity.toBuilder().seq(++jucmdsseq).build();
        continue;
      }
      break;
    }
    return midashiEntity;
  }

  private void insertJuchuMeisai(int jucmdsseq, List<JuchuMeisaiEntity> juchuMeisaiList) {
    juchuMeisaiList.stream().map(t -> t.toBuilder().seq(juchuMeisaiList.indexOf(t) + 1)
        .prckruflg(Flg.OFF.getCode()).inpchkerrkbn("0").ykesyaflg(Flg.OFF.getCode())
        .ykesyahatzflg(Flg.OFF.getCode()).chzflg(Flg.OFF.getCode()).errcod("000")
        .errariflg(Flg.OFF.getCode()).updkbn(Updkbn.INSERT.getCode()).upddte(sysdate)
        .updjkk(systime).build()).forEach(t -> {
          juchuMeisaiMapper.insert(t);
        });
  }

  @Override
  public String getServiceId() {
    return EntryServiceForJuchu.class.getSimpleName();
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY)
  public void insertEny01(JuchuMidashiEntity entity, String usrid, String cpuid, String tmlid,
      String usrbshcod, boolean isKyodoJuchu) {
    String tikcod = kyotsuTokuisakiMapper
        .select(KyotsuTokuisakiEntity.builder().tokcod(entity.getTokcod()).build()).getTikcod();
    int usrseq = userSharedService.getCurrentNo(usrid, "Z53", CurrentNoGetType.ASISVALUE_NOUPDATE);
    int sysdte8kt =
        Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    String sinkyukbn = "2";
    Trncod trncod = GlobalConstants.valueOf(Trncod.class, entity.getTrnfulcod().substring(0, 5));
    if (!isKyodoJuchu) {
      if (trncod.isSinpuTrn()) {
        sinkyukbn = "0";
      } else {
        sinkyukbn = "1";
      }
    }

    OrderStatusEntity baseOrderStatus =
        OrderStatusEntity.builder().usrseqno(usrseq).usrid(usrid).cpuid(cpuid).tmlid(tmlid)
            .jucdte(sysdte8kt).jucjkk(entity.getJucjkk()).tokcod(entity.getTokcod())
            .dscod(entity.getDscod()).trncod(trncod.getCode()).tikcod(tikcod).bshcod(usrbshcod)
            .juckbn(isKyodoJuchu ? entity.getJuckbn() : "").sinkyukbn(sinkyukbn)
            .updkbn(Updkbn.INSERT.getCode()).upddte(sysdte8kt).updjkk(entity.getUpdjkk()).build();

    // 受注明細の会社単位で数値サマリーとインサートを実施する
    Map<String, List<JuchuMeisaiEntity>> kaigrpMeisai = entity.getMeisaiList().stream()
        .collect(Collectors.groupingBy(JuchuMeisaiEntity::getDaikaiskbcod, TreeMap::new,
            Collectors.toList()));

    int ordersuu = 1;
    for (Map.Entry<String, List<JuchuMeisaiEntity>> entry : kaigrpMeisai.entrySet()) {
      int jucgyosuu = entry.getValue().size();
      int jucsurttl = entry.getValue().stream().mapToInt(JuchuMeisaiEntity::getJucsur).sum();
      OrderStatusEntity orderStatus = baseOrderStatus.toBuilder().kaiskbcod(entry.getKey())
          .jucgysuu(jucgyosuu).jucsuu(jucsurttl).ordsuu(ordersuu).build();
      orderStatusMapper.insert(orderStatus);
      // １明細目のみ1をセットし、以降は0をセットする
      ordersuu = 0;
    }
  }
}
