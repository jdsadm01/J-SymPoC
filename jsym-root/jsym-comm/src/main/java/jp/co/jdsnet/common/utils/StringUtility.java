package jp.co.jdsnet.common.utils;

import java.io.UnsupportedEncodingException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Formatter;
import java.util.Objects;
import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
// import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtility {

  /**
   * 左方ゼロ埋め（文字列型数値）<BR>
   * 引数が空の場合、変換後文字列の長さ分"0"を返す<BR>
   * 引数が数字でない場合は、例外が発生する<BR>
   * 
   * @param str 文字列型変換前数値
   * @param len 変換後文字列の長さ
   * @return 左方ゼロ埋めした文字列。変換前の長さが変換後の長さよりも大きい場合に、例外が発生する。
   */
  public static String padZero(String str, int len) {

    int i = 0;

    if (StringUtils.isNotBlank(str.trim())) {
      i = Integer.parseInt(str);
    }
    return padZero(i, len, true, false);

  }

  /**
   * 左方ゼロ埋め
   * 
   * @param i 変換前数値
   * @param len 変換後文字列の長さ
   * @param todoCheckLength 変換前の長さが変換後の長さよりも大きい場合に、例外が発生するどうか。
   * @param todoTrim 変換前の長さが変換後の長さよりも大きい場合に、右方切り捨てを行うかどうか。
   * @return 左方ゼロ埋めした文字列
   */
  public static String padZero(int i, int len, boolean todoCheckLength, boolean todoTrim) {
    return padZero(Integer.valueOf(i).longValue(), len, todoCheckLength, todoTrim);
  }

  /**
   * 左方ゼロ埋め
   * 
   * @param l 変換前数値
   * @param len 変換後文字列の長さ
   * @param todoCheckLength 変換前の長さが変換後の長さよりも大きい場合に、例外が発生するどうか。
   * @param todoTrim 変換前の長さが変換後の長さよりも大きい場合に、右方切り捨てを行うかどうか。
   * @return 左方ゼロ埋めした文字列
   */
  public static String padZero(long l, int len, boolean todoCheckLength, boolean todoTrim) {

    if (len <= 0) {
      throw new IllegalArgumentException("変換後の文字列の長さに0以下を指定した。: len = " + len);
    }

    String tmpStr = Long.toString(l);

    if (isOverMaxLength(tmpStr, len)) {

      if (todoCheckLength) {
        throw new IndexOutOfBoundsException(
            "変換前の文字列の長さが変換後の文字列の長さよりも大きい。: str = " + tmpStr + " ,len = " + len);
      }

      if (todoTrim) {

        tmpStr = rTrim(tmpStr, len);

        if ("-".equals(tmpStr) || "+".equals(tmpStr)) {
          tmpStr = "0";
        }
      }

    }

    try (Formatter format =
        new Formatter().format("%1$0" + Integer.toString(len) + "d", Long.parseLong(tmpStr))) {
      return format.toString();
    } catch (NumberFormatException e) {
      throw e;
    }
  }

  /**
   * 文字列の左字埋めを行います。
   * 
   * @param target 字埋め対象の文字列
   * @param length 字埋め後の文字列長
   * @param pad 追加される文字
   * @return targetの前にpadが追加された文字列。追加された結果がlength以上の長さになるときは、(結果の長さ-length)からの部分文字列。
   * @exception NullPointerException 引数がnullの場合
   * @exception IllegalArgumentException lengthが負の場合
   * @exception IllegalArgumentException padが空の文字列の場合
   */
  public static String lpad(String target, int length, String pad) {
    if (Objects.isNull(target) || Objects.isNull(pad))
      throw new java.lang.NullPointerException();
    if (length < 0)
      throw new java.lang.IllegalArgumentException("lenght is too small");
    if (StringUtils.isEmpty(pad))
      throw new java.lang.IllegalArgumentException("pad has no character");

    StringBuilder sb = new StringBuilder(target);
    while (sb.length() < length) {
      sb.insert(0, pad);
    }

    return sb.substring(sb.length() - length);
  }

  /**
   * 右方切捨て<BR>
   * マルチバイト文字を含む場合は、例外を発生する。<BR>
   * 
   * @param str 変換前文字列
   * @param len 切捨て後文字列長さ
   * @return 長さが切捨て後文字列長さよりも大きい場合は、右方切捨てした文字列。
   */
  public static String rTrim(String str, int len) {

    if (isContainMultiByte(str)) {
      throw new IllegalArgumentException("マルチバイト文字を含む文字列を指定した。: str = " + str);
    }

    if (isOverMaxLength(str, len)) {
      return str.substring(0, len);
    } else {
      return str;
    }
  }

  /**
   * マルチバイト文字を含むか
   * 
   * @param str 文字列
   * @return マルチバイト文字を含むかどうか。
   */
  public static boolean isContainMultiByte(String str) {
    if (str == null) {
      return false;
    } else {
      try {
        return (str.length() != str.getBytes("IBM943").length);
      } catch (UnsupportedEncodingException e) {
        // log.info(LOG_MESSAGE_BASE_CHARSET_IS_UNSUPORTED, e);
        return false;
      }
    }
  }

  /**
   * 長さが最大長（文字数）よりも大きいか
   * 
   * @param str 文字列
   * @param len 指定長さ
   * @return 長さが指定長さよりも大きいかどうか。
   */
  public static boolean isOverMaxLength(String str, int len) {

    if (str == null) {
      return false;
    } else if (str.length() > len) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * 文字列の右端から指定した文字を取り除いた新しい文字列を返します。
   * 
   * @param target 対象の文字列
   * @param suffix 取り除きたい文字列
   * @return 指定した文字を取り除いた文字列。引数が空のときはtargetをそのまま返す。
   * @exception NullPointerException 引数がnullの場合
   */
  public static String removeSuffix(String target, String suffix) {
    if (Objects.isNull(target) || Objects.isNull(suffix))
      throw new java.lang.NullPointerException();
    if (StringUtils.isBlank(target) || StringUtils.isBlank(suffix))
      return target;

    String str = target;
    while (str.endsWith(suffix)) {
      str = str.substring(0, str.length() - suffix.length());
    }

    return str;
  }

  /**
   * 文字列が半角英数のみかどうかを判定する。
   *
   * @param str 検査文字列
   * @return 半角英数のみならばtrue、そうでなければfalse(null・ブランクもfalse)
   */
  public static boolean isAscii(String str) {
    return checkStyleCommon(str, CheckType.ASCII);
  }

  /**
   * 文字列が半角英数のみかどうかを判定する。ただし英小文字はNGとする。
   *
   * @param str 検査文字列
   * @return 半角英数のみならばtrue、そうでなければfalse(null・ブランクもfalse)
   */
  public static boolean isAsciiNoLowercase(String str) {
    return checkStyleCommon(str, CheckType.ASCII_NO_LOWERCASE);
  }

  /**
   * 文字列が半角数字のみかどうかを判定する。
   *
   * @param str 検査文字列
   * @return 半角数字のみならばtrue、そうでなければfalse(null・ブランクもfalse)
   */
  public static boolean isAsciiDigit(String str) {
    return checkStyleCommon(str, CheckType.ASCII_DIGIT);
  }

  /**
   * 文字列が半角英数カナのみかどうかを判定する。
   *
   * @param str 検査文字列
   * @return 半角英数カナのみならばtrue、そうでなければfalse(null・ブランクもfalse)
   */
  public static boolean isHankaku(String str) {
    return checkStyleCommon(str, CheckType.HANKAKU);
  }

  /**
   * 文字列が半角英数カナのみかどうかを判定する。ただし英小文字はNGとする。
   *
   * @param str 検査文字列
   * @return 半角英数カナのみならばtrue、そうでなければfalse(null・ブランクもfalse)
   */
  public static boolean isHankakuNoLowercase(String str) {
    return checkStyleCommon(str, CheckType.HANKAKU_NO_LOWERCASE);
  }

  /**
   * 文字列が全角のみかどうかを判定する。ただし英小文字はNGとする。
   *
   * @param str 検査文字列
   * @return 全角のみならばtrue、そうでなければfalse(null・ブランクもfalse)
   */
  public static boolean isZenkaku(String str) {
    return checkStyleCommon(str, CheckType.ZENKAKU);
  }

  /**
   * 文字列が指定の型どおりかどうかを判定する。nullとブランクはチェックなしにNGとする。
   *
   * @param str 検査文字列
   * @param checkType 検査型
   * @return 型どおりの場合はtrue、そうでなければfalse
   */
  private static boolean checkStyleCommon(String str, CheckType checkType) {
    if (StringUtils.isBlank(str)) {
      return false;
    }

    CharacterIterator iter = new StringCharacterIterator(str);
    for (char c = iter.first(); c != CharacterIterator.DONE; c = iter.next()) {
      if (!checkType.isOk(c)) {
        return false;
      }
    }
    return checkType.isNotNgWord(str);
  }

  /**
   * 型チェックで使用する。どの文字を許可するかを定義する。 <br>
   * チェックする型のパターンが増えた場合はこれに追加すること。
   */
  private enum CheckType {
    ASCII {
      @Override
      public boolean isOk(char c) {
        return isBasicLatin(c);
      }
    },
    ASCII_NO_LOWERCASE {
      @Override
      public boolean isOk(char c) {
        return isBasicLatin(c) && !isLowerCase(c);
      }
    },
    ASCII_DIGIT {
      @Override
      public boolean isOk(char c) {
        return isBasicLatin(c) && Character.isDigit(c);
      }
    },
    HANKAKU {
      @Override
      public boolean isOk(char c) {
        return isBasicLatin(c) || isHankakuKana(c);
      }
    },
    HANKAKU_NO_LOWERCASE {
      @Override
      public boolean isOk(char c) {
        return (isBasicLatin(c) || isHankakuKana(c)) && !isLowerCase(c);
      }
    },
    ZENKAKU {
      @Override
      public boolean isOk(char c) {
        return !isBasicLatin(c) && !isHankakuKana(c);
      }

      @Override
      public boolean isNotNgWord(String str) {
        return !isNgWord(str);
      }
    };

    public abstract boolean isOk(char c);

    /**
     * 禁止文字が使用されているか判定する。<br>
     * 基本的にマルチバイトのチェックの為、全角の判定時のみオーバーライドすること。
     *
     * @param str 検査文字列
     * @return 禁止文字が含まれていない場合はtrue、含まれている場合はfalse
     */
    public boolean isNotNgWord(String str) {
      return true;
    };
  }

  /**
   * 文字が半角英数かどうかを判定する
   *
   * @param c チェック文字
   * @return 半角英数ならばtrue そうでなければ false
   */
  private static boolean isBasicLatin(char c) {
    return Character.UnicodeBlock.of(c).equals(Character.UnicodeBlock.BASIC_LATIN);
  }

  /**
   * 文字が半角カナかどうかを判定する
   *
   * @param c チェック文字
   * @return 半角カナならばtrue そうでなければ false
   */
  private static boolean isHankakuKana(char c) {
    // Halfwidth Katakana variants or Halfwidth CJK punctuation
    return c >= '\uff61' && c <= '\uff9f';
  }

  /**
   * 文字がUS-ASCIIの小文字かどうかを判定する
   *
   * @param c チェック文字
   * @return US-ASCIIの小文字ならばtrue そうでなければ false
   */
  private static boolean isLowerCase(char c) {
    return c >= '\u0061' && c <= '\u007A';
  }

  /**
   * 文字列内にHOSTで使用出来ない文字が混じっていないか判定する。
   * 
   * @param str 検査文字列
   * @return 全て使用可能文字なら true、そうでない場合は false。引数をCp930にエンコード出来なかった場合は false。
   */
  public static boolean isNgWord(String str) {
    final String ngWord = "?";
    final String ngWord2 = "~";
    final String ngWord3 = "\\";
    final String hostCharacterCode = "Cp930";
    final String printNgChars = "凜煕";

    // 使用不可文字が混じっていないかチェック
    try {
      // もともと"?"が含まれていた場合は"*"に置き換えておく
      str = str.replace(ngWord, "*");
      byte[] strByte = str.getBytes(hostCharacterCode);
      String chgStr = new String(strByte, hostCharacterCode);
      if (chgStr.indexOf(ngWord) >= 0) {// 変換結果に"?"が含まれていたら
        return true;
      } else if (chgStr.indexOf(ngWord2) >= 0) {// 変換結果に"~"が含まれていたら
        return true;
      } else if (chgStr.indexOf(ngWord3) >= 0) {// 変換結果に"\"が含まれていたら
        return true;
      } else {
        // HOSTのプリンターで印刷できない文字チェック 2005/01/11 add
        for (int i = 0; i < printNgChars.length(); i++) {
          if (str.indexOf(printNgChars.charAt(i)) >= 0) {
            return true;
          }
        }
      }
    } catch (UnsupportedEncodingException e) {
      return true;
    }
    return false;
  }
}
