package jp.co.jdsnet.common.logic.implement;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.common.domain.entity.control.ServiceControlEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity.Gmnkbn;
import jp.co.jdsnet.common.domain.entity.sysmas.DaihyoKaishaCalendarEntity;
import jp.co.jdsnet.common.domain.entity.sysmas.JdsCalendarEntity;
import jp.co.jdsnet.common.domain.entity.sysmas.JokenEntity;
import jp.co.jdsnet.common.domain.entity.sysmas.JsymMsEntity;
import jp.co.jdsnet.common.domain.mapper.control.ServiceControlMapper;
import jp.co.jdsnet.common.domain.mapper.menu.EventMapper;
import jp.co.jdsnet.common.domain.mapper.sysmas.DaihyoKaishaCalendarMapper;
import jp.co.jdsnet.common.domain.mapper.sysmas.JdsCalendarMapper;
import jp.co.jdsnet.common.domain.mapper.sysmas.JokenMapper;
import jp.co.jdsnet.common.domain.mapper.sysmas.JsymMsMapper;
import jp.co.jdsnet.common.logic.CommonCheckSharedService;
import jp.co.jdsnet.common.logic.UserRelatedSharedService;
import jp.co.jdsnet.common.logic.UserRelatedSharedService.CurrentNoGetType;
import jp.co.jdsnet.common.utils.FormatUtility;
import jp.co.jdsnet.common.utils.GlobalConstants;
import jp.co.jdsnet.common.utils.GlobalConstants.Flg;
import jp.co.jdsnet.common.utils.GlobalConstants.Rmcod;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;
import jp.co.jdsnet.common.utils.GlobalConstants.Usrbun;
import jp.co.jdsnet.common.utils.StringUtility;
import lombok.RequiredArgsConstructor;

/**
 * 各種チェックの共通処理の実装クラス
 *
 * @author r-matsumura
 *
 */
@RequiredArgsConstructor
@Service
public class CommonCheckSharedServiceImpl implements CommonCheckSharedService {

  private final MessageSource messageSource;
  private final EventMapper eventMapper;
  private final ServiceControlMapper serviceControlMapper;
  private final JsymMsMapper msMapper;
  private final JokenMapper jokenMapper;
  private final JdsCalendarMapper jdsCalendarMapper;
  private final DaihyoKaishaCalendarMapper daihyoKaishaCalendarMapper;
  private final UserRelatedSharedService userRelatedSharedService;

  @Override
  public ServiceTime checkServiceTime(String daikaiskbcod, String usrbun, String gmnid,
      String gmnseq, EventEntity.Gmnkbn gmnkbn) throws NoSuchElementException {

    EventEntity eventEntity = eventMapper
        .select(
            EventEntity.builder().gmnid(gmnid).gmnseqno(gmnseq).gmnkbn(gmnkbn.getCode()).build());
    if (Objects.isNull(eventEntity)) {
      throw new NoSuchElementException("イベントマスタ(VTBCNL10)未登録　画面ID：" + gmnid + ",画面SeqNo：" + gmnseq
          + ",画面区分：" + gmnkbn.getCode());
    }

    ServiceControlEntity serviceControlEntity =
        serviceControlMapper.select(ServiceControlEntity.builder().daikaiskbcod(daikaiskbcod)
            .usrbun(usrbun).gymid(eventEntity.getGymid()).prckbn(eventEntity.getPrckbn()).build());
    if (Objects.isNull(serviceControlEntity)) {
      throw new NoSuchElementException(
          "サービスコントロールテーブル(VTBCNL01)未登録　代表会社識別コード：" + daikaiskbcod + ",ユーザー分類：" + usrbun + ",業務ID："
              + eventEntity.getGymid() + ",処理区分：" + eventEntity.getPrckbn());
    }

    LocalDateTime now = LocalDateTime.now();
    int sysdate = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    int systime = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HHmmss")));

    if (isInServiceTime(GlobalConstants.valueOf(Flg.class, serviceControlEntity.getSvcflg1()),
        serviceControlEntity.getSvcsttdte1(), serviceControlEntity.getSvcenddte1(),
        serviceControlEntity.getSvcsttjkk1(), serviceControlEntity.getSvcendjkk1(), sysdate,
        systime)) {
      return ServiceTime.ONLINE;
    } else if (isInServiceTime(GlobalConstants.valueOf(Flg.class, serviceControlEntity.getSvcflg2()),
        serviceControlEntity.getSvcsttdte2(), serviceControlEntity.getSvcenddte2(),
        serviceControlEntity.getSvcsttjkk2(), serviceControlEntity.getSvcendjkk2(), sysdate,
        systime)) {
      return ServiceTime.SUBTIME;
    } else {
      return ServiceTime.TIMEOUT;
    }
  }


  private boolean isInServiceTime(Flg flg, int startDate, int endDate, int startTime, int endTime,
      int sysDate, int sysTime) {
    return Flg.ON == flg && isOk(startDate, endDate, sysDate) && isOk(startTime, endTime, sysTime);
  }

  private boolean isOk(int startDateTime, int endDateTime, int sysDateTime) {
    return startDateTime <= sysDateTime && sysDateTime <= endDateTime;
  }


  @Override
  public boolean isUsableMscod(String mscod, String daikaiskbcod) {
    if ("Z9".equals(mscod) || "4X".equals(mscod) || "ZU".equals(mscod)) {
      return false;
    }
    return isUsableAllMscod(mscod, daikaiskbcod);
  }

  @Override
  public boolean isUsableAllMscod(String mscod, String daikaiskbcod) {
    // JDSで共通MSを検索
    JsymMsEntity msEntity = JsymMsEntity.builder().kaiskbcod("JDS").mscod(mscod).build();
    JsymMsEntity resultEntity = msMapper.selectWithoutLogicalDelete(msEntity);
    if (Objects.nonNull(resultEntity)) {
      return true;
    }

    // 共通で存在しない場合は個社MSを検索する
    msEntity = msEntity.toBuilder().kaiskbcod(daikaiskbcod).build();
    resultEntity = msMapper.selectWithoutLogicalDelete(msEntity);
    if (Objects.nonNull(resultEntity)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isUsableSmtcod(String smtcod, String daikaiskbcod, Trncod trncod) {
    String keyfld = "SMV" + trncod.getCode().trim();
    JokenEntity entity = jokenMapper.selectWithoutLogicalDelete(
        JokenEntity.builder().kaiskbcod(daikaiskbcod).keyfld(keyfld).build());
    if (Objects.isNull(entity)) {
      return false;
    }

    Set<String> resultSet = expandTxt(entity.getTxt(), 2, 2);
    if (resultSet.isEmpty() || !resultSet.contains(smtcod)) {
      return false;
    }

    return true;
  }

  @Override
  public boolean isUsableTrncod(Trncod trncod, String daikaiskbcod) {
    // トランについては他と違い、利用できないコードが登録されている。

    String keyfld = "TRTRNV";
    JokenEntity entity = jokenMapper.selectWithoutLogicalDelete(
        JokenEntity.builder().kaiskbcod(daikaiskbcod).keyfld(keyfld).build());
    if (Objects.isNull(entity)) {
      return true;
    }

    Set<String> resultSet = expandTxt(entity.getTxt(), 2, 5);
    if (resultSet.isEmpty() || resultSet.contains(trncod.getCode())) {
      // データは存在しても明細数０はデータ不良としてエラー扱い
      return false;
    }

    return true;
  }

  @Override
  public boolean isUsableBshcod(String bshcod, String daikaiskbcod, Usrbun usrbun) {
    String keyfld = "M1301";
    if (usrbun == Usrbun.JAR || usrbun == Usrbun.TAK) {
      keyfld += " " + usrbun.name();
    }

    JokenEntity entity = jokenMapper.selectWithoutLogicalDelete(
        JokenEntity.builder().kaiskbcod(daikaiskbcod).keyfld(keyfld).build());
    if (Objects.isNull(entity)) {
      return false;
    }
    Set<String> resultSet = expandTxt(entity.getTxt(), 3, 4);
    if (resultSet.isEmpty() || !resultSet.contains(bshcod)) {
      return false;
    }

    return true;
  }

  @Override
  public boolean isUsableKdakbn(String kdakbn, String daikaiskbcod, Trncod trncod) {
    String keyfld = "KRV" + trncod.getCode().trim();

    JokenEntity entity = jokenMapper.selectWithoutLogicalDelete(
        JokenEntity.builder().kaiskbcod(daikaiskbcod).keyfld(keyfld).build());
    if (Objects.isNull(entity)) {
      return false;
    }
    Set<String> resultSet = expandTxt(entity.getTxt(), 2, 2);
    if (!resultSet.contains(kdakbn)) {
      return false;
    }

    return true;
  }

  /**
   * {@inheritDoc} 貸出区分と処理は同じだが、今後に備えてメソッド分離する
   */
  @Override
  public boolean isUsableKnrkbn(String knrkbn, String daikaiskbcod, Trncod trncod) {
    return isUsableKdakbn(knrkbn, daikaiskbcod, trncod);
  }

  @Override
  public boolean isUsableRmcodForHeader(Rmcod rmcod, Trncod trncod, String checkKey) {
    if (rmcod == Rmcod.SHITEINASHI) {
      return true;
    }
    return isUsableRmcod(rmcod, trncod, checkKey, Flg.OFF);
  }

  @Override
  public boolean isUsableRmcodForDetail(Rmcod rmcod, Rmcod rmHeader, Trncod trncod,
      String checkKey) {
    if (rmcod == Rmcod.SHITEINASHI) {
      return true;
    }

    // 共通の組合せチェック
    switch (rmHeader) {
      case NOHINZUMI:
        if (rmcod != Rmcod.NOHINZUMI) {
          return false;
        }
        break;
      case RESERVE:
      case RESERVE_FURYO:
        if (rmcod != Rmcod.RESERVE && rmcod != Rmcod.RESERVE_FURYO) {
          return false;
        }
        break;
      case KYOSEI_RESERVE:
        return false;
      default:
        break;
    }

    // トラン別の組合せチェック
    switch (trncod) {
      case KEIHI_SHUKKO:
      case SHOHIN_URIAGE:
      case KASHIDASHI_SHUKKA:
      case KASHIDASHI_SHUKKA_TSUJOGAI:
      case KYOSEI_URIAGE:
      case TSUJOGAI_URIAGE:
      case TOKUCHU_URIAGE:
      case YUSHUTSU_URIAGE:
      case TOKUHAN_URIAGE:
        if (rmHeader == Rmcod.KYOSEI && rmcod != Rmcod.RESERVE) {
          return false;
        }
        break;
      case FURIKAE_SHUKKO:
        if ((rmHeader == Rmcod.KYOSEI || rmHeader == Rmcod.SINPU) && rmcod == Rmcod.RESERVE) {
          return false;
        }
        break;
      default:
        if (rmHeader == Rmcod.KYOSEI && rmcod != Rmcod.KYOSEI) {
          return false;
        }
    }

    return isUsableRmcod(rmcod, trncod, checkKey, Flg.ON);
  }

  private boolean isUsableRmcod(Rmcod rmcod, Trncod trncod, String checkKey, Flg detailFlg) {
    try {
      Set<String> resultSet = getUsableRmcod(trncod, checkKey, detailFlg);
      if (resultSet.isEmpty() || !resultSet.contains(rmcod.getCode())) {
        return false;
      }
    } catch (NoSuchElementException e) {
      return false;
    }
    return true;
  }

  private Set<String> getUsableRmcod(Trncod trncod, String checkKey, Flg detailFlg)
      throws NoSuchElementException {
    String keyfld = "RMV" + detailFlg.getCode() + trncod.getCode().trim() + checkKey;

    JokenEntity entity = jokenMapper
        .selectWithoutLogicalDelete(JokenEntity.builder().kaiskbcod("JDS").keyfld(keyfld).build());
    if (Objects.isNull(entity)) {
      throw new NoSuchElementException();
    }
    return expandTxt(entity.getTxt(), 2, 2);
  }

  /**
   * 条件テーブルのテキストフィールドを分解する
   *
   * @param txt 条件テーブル．TXT
   * @param msilen 明細数のレングス
   * @param fieldlen １項目のレングス
   * @return 分解した結果
   */
  private Set<String> expandTxt(String txt, int msilen, int fieldlen) {
    int msisuu = Integer.parseInt(txt.substring(0, msilen).trim());
    Set<String> resultSet = new HashSet<>();

    int startIdx = msilen;
    for (int i = 0; i < msisuu; i++) {
      try {
        resultSet.add(txt.substring(startIdx, startIdx + fieldlen));
        startIdx += fieldlen;
      } catch (IndexOutOfBoundsException e) {
        // 頭の明細数より実際のテキストが短い場合はそこまでのデータとして返却する
        break;
      }
    }

    return resultSet;
  }

  @Override
  public String getNextKadoDte(String baseDte8kt)
      throws DateTimeParseException, NoSuchElementException {
    LocalDate ld = DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT)
        .parse(baseDte8kt, LocalDate::from);

    int from8kt = Integer.parseInt(ld.plusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    int to8kt = Integer.parseInt(ld.plusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));

    List<JdsCalendarEntity> calenderEntity =
        jdsCalendarMapper.selectListByFromToDate(from8kt, to8kt);

    return calenderEntity.stream()
        .filter(t -> "0".equals(t.getKaddtekbn()))
        .sorted(Comparator.comparing(JdsCalendarEntity::getDte8kt)).findFirst()
        .map(t -> String.valueOf(t.getDte8kt()))
        .orElseThrow(() -> new NoSuchElementException(messageSource.getMessage("error.ismissing",
            new Object[] {
                messageSource.getMessage("arg.applicabledata", null, Locale.getDefault())},
            Locale.getDefault())));
  }


  @Override
  public String checkStack(String stakjydte, String usrid, String tmlid, String stano,
      String daikaiskbcod, String usrbun, String gmnid, String gmnseqno, Gmnkbn gmnkbn)
      throws Exception {
    return checkStack(stakjydte, usrid, tmlid, stano, daikaiskbcod, usrbun, gmnid, gmnseqno, gmnkbn,
        null);
  }

  @Override
  public String checkStack(String stakjydte, String usrid, String tmlid, String stano,
      String daikaiskbcod, String usrbun, String gmnid, String gmnseqno, Gmnkbn gmnkbn,
      Trncod trncod) throws Exception {

    if (!StringUtils.isBlank(stakjydte) && "0".equals(stakjydte)) {
      checkStackDateRange(stakjydte);
      if (ServiceTime.ONLINE == checkServiceTime(daikaiskbcod, usrbun, gmnid, gmnseqno, gmnkbn)) {
        boolean isJuchuShukkaAriTrn = Objects.nonNull(trncod) && trncod.isOnlyJuAriKadoTrn();
        if (checkNextKadoDate(stakjydte, daikaiskbcod, isJuchuShukkaAriTrn)) {

        }
      }
    }

    if (StringUtils.isBlank(stano)) {
      int curno = userRelatedSharedService.getCurrentNo(usrid, usrbun,
          CurrentNoGetType.VALUEPLUSONE_UPDATE);
      stano = createStaNo(tmlid, String.valueOf(curno));
    }
    return stano;
  }

  private void checkStackDateRange(String stakjydte) throws DateTimeException {
    try {
      LocalDate stack =
          DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT).parse(
              String.valueOf(FormatUtility.convertYYYYMMDD(Integer.parseInt(stakjydte))),
              LocalDate::from);

      LocalDate now = LocalDate.now();
      if (stack.isBefore(now) || stack.isEqual(now)) {
        throw new DateTimeException("過去日付");
      }

      if (stack.isAfter(now.plusMonths(1))) {
        throw new DateTimeException("１か月オーバー");
      }
    } catch (DateTimeException e) {
      throw e;
    }
  }

  private boolean checkNextKadoDate(String stakjydte, String daikaiskbcod,
      boolean isJuchuShukkaAri) {
    JdsCalendarEntity entity = jdsCalendarMapper.select(JdsCalendarEntity.builder()
        .dte8kt(FormatUtility.convertYYYYMMDD(Integer.valueOf(stakjydte))).build());
    if (!"0".equals(entity.getKaddtekbn())) {
      return false;
    } else if (isJuchuShukkaAri) {
      DaihyoKaishaCalendarEntity daihyoKaishaCalendar =
          daihyoKaishaCalendarMapper.select(DaihyoKaishaCalendarEntity.builder()
              .daikaiskbcod(daikaiskbcod).dte8kt(Integer.valueOf(stakjydte)).build());
      if (!"0".equals(daihyoKaishaCalendar.getNotegydteflg())) {
        return false;
      }
    }

    String nextKadoDte = null;
    if (isJuchuShukkaAri) {
      nextKadoDte = getNextJuchuShukkaAriKadoDte(daikaiskbcod);
    } else {
      nextKadoDte = getNextKadoDte(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

    if (StringUtils.isBlank(nextKadoDte) || nextKadoDte.equals(String.valueOf(stakjydte))) {
      return false;
    }

    return true;
  }

  private String getNextJuchuShukkaAriKadoDte(String daikaiskbcod) {
    LocalDate ld = LocalDate.now();
    int from8kt = Integer.parseInt(ld.plusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    int to8kt = Integer.parseInt(ld.plusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));

    List<DaihyoKaishaCalendarEntity> calenderEntity =
        daihyoKaishaCalendarMapper.selectListByFromToDate(daikaiskbcod, from8kt, to8kt);

    return calenderEntity.stream().filter(t -> "0".equals(t.getKaddtekbn()))
        .filter(t -> "0".equals(t.getNotegydteflg()))
        .sorted(Comparator.comparing(DaihyoKaishaCalendarEntity::getDte8kt)).findFirst()
        .map(t -> String.valueOf(t.getDte8kt())).orElse(null);
  }

  private String createStaNo(String tmlId, String staNo) {
    return tmlId + "-" + StringUtility.lpad(staNo, 4, "0");
  }

}
