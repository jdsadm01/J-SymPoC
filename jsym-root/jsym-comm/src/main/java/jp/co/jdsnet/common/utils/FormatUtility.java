package jp.co.jdsnet.common.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FormatUtility {

  /**
   * 6桁の日付を8桁に変換します。(VZJ003)
   * 
   * @param date 6桁の日付
   * @return newDate 8桁の日付
   */
  public static int convertYYYYMMDD(int date) {
    int DTE_BOUNDARY_VALUE = 500000;
    int DTE_MAX_VALUE = 999999;

    int newDate;

    if (date == 0) {
      newDate = 0;
    } else if (date == DTE_MAX_VALUE) {
      newDate = 99999999;
    } else if (date > 0 && date < DTE_BOUNDARY_VALUE) {
      newDate = 20000000 + date;
    } else if (date >= DTE_BOUNDARY_VALUE && date < DTE_MAX_VALUE) {
      newDate = 19000000 + date;
    } else {
      newDate = date;
    }

    return newDate;
  }

  /**
   * 6桁の日付(String)を8桁に変換し、Stringで返します。(VZJ003)
   * 
   * @param date 6桁の日付
   * @return newDate 8桁の日付
   */
  public static String convertYYYYMMDD(String dateStr) {
    String newDate = "";
    try {
      int date = convertYYYYMMDD(Integer.parseInt(dateStr.trim()));
      newDate = String.valueOf(date);
    } catch (NumberFormatException e) {
      newDate = dateStr;
    }
    return newDate;
  }

  /**
   * 日付型（yyyy/MM/dd）にフォーマットした文字列を返します。
   * 
   * @param s フォーマット前のデータ（yyyyMMdd）
   * @return 日付フォーマット済みのデータ（yyyy/MM/dd）
   */
  public static String setFormatYYYYMMDD(String s) {
    if (StringUtils.isBlank(s)) {
      return "";
    } else {
      return DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT)
          .parse(s, LocalDate::from).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
  }

  /**
   * 時刻型（H:MM:SS）にフォーマットした文字列を返します。
   * 
   * @param s フォーマット前のデータ（HMMSS or HHMMSS）
   * @return 時刻フォーマット済みのデータ（H:MM:SS）
   */
  public static String setFormatHHMMSS(String s) {
    if (StringUtils.isBlank(s)) {
      return "";
    } else {
      if (s.length() < 6) {
        s = StringUtility.lpad(s, 5, "0");
      }
      return DateTimeFormatter.ofPattern("Hmmss").withResolverStyle(ResolverStyle.STRICT)
          .parse(s, LocalTime::from).format(DateTimeFormatter.ofPattern("H:mm:ss"));
    }
  }

}
