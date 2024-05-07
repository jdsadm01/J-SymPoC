package jp.co.jdsnet.base.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jp.co.jdsnet.base.validation.FormatDateValidator;
import jp.co.jdsnet.common.utils.FormatUtility;

@Target({FIELD, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint (validatedBy = {FormatDateValidator.class}) 
public @interface CheckDate {
  String message() default "{CheckDate.default}";
  FormatType format();

  AllowException allow() default AllowException.NOT_ALLOW;
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  
  @Target({FIELD, PARAMETER, TYPE_USE})
  @Retention (RetentionPolicy.RUNTIME) 
  @interface List {
    CheckDate[] format();

    CheckDate[] allow();
  }

  enum FormatType {
    YYMMDD {
      @Override
      public boolean isCorrectFormat(String value) {
        return value.matches("^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$");
      }
      @Override
      public String getFormatYYYYMMDD(String value) {
        return FormatUtility.convertYYYYMMDD(value);
      }
    },
    YYYYMMDD {
      @Override
      public boolean isCorrectFormat(String value) {
        return value.matches("^[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$");
      }
      @Override
      public String getFormatYYYYMMDD(String value) {
        return value;
      }
    };
    
    public abstract boolean isCorrectFormat(String value);
    public abstract String getFormatYYYYMMDD(String value);
  }

  enum AllowException {
    NOT_ALLOW {
      public boolean isAllowFormat(String value, int len) {
        return false;
      }
    },
    ALL0 {
      public boolean isAllowFormat(String value, int len) {
        return value.matches(getPattern("0", len));
      }
    },
    ALL9 {
      public boolean isAllowFormat(String value, int len) {
        return value.matches(getPattern("9", len));
      }
    },
    ALL0_ALL9_0 {
      public boolean isAllowFormat(String value, int len) {
        return "0".equals(value) || value.matches(getPattern("0", len))
            || value.matches(getPattern("9", len));
      }
    };

    private static String getPattern(String allowString, int len) {
      return allowString + "{" + len + "}";
    }

    public abstract boolean isAllowFormat(String value, int len);
  }
}
