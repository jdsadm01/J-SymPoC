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
}
