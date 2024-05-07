package jp.co.jdsnet.common.domain.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder(toBuilder = true)
@Setter(value = AccessLevel.NONE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KaishaProcDateInfo {
  /** 処理日 **/
  private int prcdte;
  /** 前回処理日 */
  private int lastPrcdte;
  /** 曜日 **/
  private String dayOfWeek;
  /** 週度 **/
  private int weekOfYear;
  /** 代表会社識別コード **/
  private String daikaiskbcod;
  /** メーカー締日 **/
  private int mkrsmedte;
  /** カレンダー位置 **/
  private String calendarPosition;
  /** 稼働日区分 **/
  private String kaddtekbn;
  /** EDP処理日区分 **/
  private String edpPrcdtekbn;
  /** EDP締日区分 **/
  private String edpSmedtekbn;
  /** EDP週次区分 **/
  private String edpWeeklykbn;
  /** EDP月末区分 **/
  private String edpEndOfMonthkbn;
  /** 前回メーカー締日 **/
  private int lastMkrsmedte;
  /** 前回週次処理日 **/
  private int lastWeeklyprcdte;
  /** 前回月末処理日 **/
  private int lastEndOfMonthprcdte;
}
