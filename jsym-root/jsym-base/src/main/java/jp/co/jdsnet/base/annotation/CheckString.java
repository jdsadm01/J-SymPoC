package jp.co.jdsnet.base.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jp.co.jdsnet.base.validation.FormatStringValidator;
import jp.co.jdsnet.common.utils.StringUtility;
import lombok.RequiredArgsConstructor;

/**
 * 半角英数字のみかどうかをチェックする
 */
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {FormatStringValidator.class})
@ReportAsSingleViolation
public @interface CheckString {
  String message() default "{CheckString.default}";
  CheckStyle style();
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

  @Target({FIELD})
  @Retention(RUNTIME)
  @interface List {
    CheckString[] format();
  }

  @RequiredArgsConstructor
  enum CheckStyle {
    ASCII("CheckString.ascii") {
      public boolean isCorrectFormat(String value) {
        return StringUtility.isAscii(value);
      }
    },
    ASCII_NOLOWERCASE("CheckString.ascii.NoLowerCase") {
      public boolean isCorrectFormat(String value) {
        return StringUtility.isAsciiNoLowercase(value);
      }
    },
    ASCII_DIGIT("CheckString.asciiDigit") {
      public boolean isCorrectFormat(String value) {
        return StringUtility.isAsciiDigit(value);
      }
    },
    HANKAKU("CheckString.hankaku") {
      public boolean isCorrectFormat(String value) {
        return StringUtility.isHankaku(value);
      }
    },
    HANKAKU_NOLOWERCASE("CheckString.hankaku.NoLowerCase") {
      public boolean isCorrectFormat(String value) {
        return StringUtility.isHankakuNoLowercase(value);
      }
    },
    ZENKAKU("CheckString.zenkaku") {
      public boolean isCorrectFormat(String value) {
        return StringUtility.isZenkaku(value);
      }
    };
    
    final String messageKey;

    public abstract boolean isCorrectFormat(String value);

    public String getMessage() {
      return "{" + messageKey + "}";
    }
  }
}
