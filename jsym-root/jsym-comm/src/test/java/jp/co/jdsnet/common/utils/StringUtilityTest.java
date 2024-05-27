package jp.co.jdsnet.common.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import lombok.RequiredArgsConstructor;

public class StringUtilityTest {

  @Nested
  class padZero {
    @RequiredArgsConstructor
    enum Param {
      CASE_1("5", 3, "005"), CASE_2("", 3, "000");

      private final String testStr;
      private final int len;
      private final String expStr;
    }

    @ParameterizedTest
    @EnumSource
    void 正常(Param param) {
      String result = StringUtility.padZero(param.testStr, param.len);
      assertAll("値の検証", () -> assertThat(result).isEqualTo(param.expStr));
    }

    @RequiredArgsConstructor
    enum Param2 {
      CASE_1("1234", 3, IndexOutOfBoundsException.class,
          "変換前の文字列の長さが変換後の文字列の長さよりも大きい。: str = 1234 ,len = 3"),
      CASE_2("1234", 0,
              IllegalArgumentException.class, "変換後の文字列の長さに0以下を指定した。: len = 0");

      private final String testStr;
      private final int len;
      @SuppressWarnings("rawtypes")
      private final Class excecption;
      private final String message;
    }

    @ParameterizedTest
    @EnumSource
    void 異常終了(Param2 param) {
      Throwable ex = assertThrows(RuntimeException.class,
          () -> StringUtility.padZero(param.testStr, param.len));
      assertAll("exceptionの検証",
          () -> assertThat(ex.getClass()).isEqualTo(param.excecption),
          () -> assertThat(ex.getMessage()).isEqualTo(param.message));
    }
  }

  @Nested
  class isAscii {
    @RequiredArgsConstructor
    enum Param {
      CASE1("A", true), CASE2("a", true), CASE3("1", true), CASE4("ｱ", false), CASE5("あ", false),
      CASE6("$", true);

      private final String arg;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void TEST(Param param) {
      boolean result = StringUtility.isAscii(param.arg);
      assertThat(result).isEqualTo(param.exp);
    }
  }

  @Nested
  class isAsciiNoLowercase {
    @RequiredArgsConstructor
    enum Param {
      CASE1("A", true), CASE2("a", false), CASE3("1", true), CASE4("ｱ", false), CASE5("あ", false),
      CASE6("$", true);

      private final String arg;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void TEST(Param param) {
      boolean result = StringUtility.isAsciiNoLowercase(param.arg);
      assertThat(result).isEqualTo(param.exp);
    }
  }

  @Nested
  class isAsciiDigit {
    @RequiredArgsConstructor
    enum Param {
      CASE1("A", false), CASE2("a", false), CASE3("1", true), CASE4("ｱ", false), 
      CASE5("あ", false), CASE6("$", false);

      private final String arg;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void TEST(Param param) {
      boolean result = StringUtility.isAsciiDigit(param.arg);
      assertThat(result).isEqualTo(param.exp);
    }
  }

  @Nested
  class isHankaku {
    @RequiredArgsConstructor
    enum Param {
      CASE1("A", true), CASE2("a", true), CASE3("1", true), CASE4("ｱ", true), CASE5("あ", false),
      CASE6("$", true);

      private final String arg;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void TEST(Param param) {
      boolean result = StringUtility.isHankaku(param.arg);
      assertThat(result).isEqualTo(param.exp);
    }
  }

  @Nested
  class isHankakuNoLowercase {
    @RequiredArgsConstructor
    enum Param {
      CASE1("A", true), CASE2("a", false), CASE3("1", true), CASE4("ｱ", true), CASE5("あ", false),
      CASE6("$", true);

      private final String arg;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void TEST(Param param) {
      boolean result = StringUtility.isHankakuNoLowercase(param.arg);
      assertThat(result).isEqualTo(param.exp);
    }
  }

  @Nested
  class isZenkaku {
    @RequiredArgsConstructor
    enum Param {
      CASE1("A", false), CASE2("a", false), CASE3("1", false), CASE4("ｱ", false), CASE5("あ", true),
      CASE6("$", false), CASE7("凜", false), CASE8("煕", false), CASE9("①", false), CASE10("㈱", true),
      CASE11("〜", true), CASE12("～", true), CASE13("?", false), CASE14("~", false), CASE15("\\", false);

      private final String arg;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void TEST(Param param) {
      boolean result = StringUtility.isZenkaku(param.arg);
      assertThat(result).isEqualTo(param.exp);
    }
  }
}
