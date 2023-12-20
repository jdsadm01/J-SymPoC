package jp.co.jdsnet.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jp.co.jdsnet.base.validation.FormatDateValidator;
import jp.co.jdsnet.common.utils.FormatUtility;

@Target ({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE}) 
@Retention (RetentionPolicy.RUNTIME) 
@Constraint (validatedBy = {FormatDateValidator.class}) 
public @interface FormatDate {
  String message() default "{custom.validation.FormatDate.message}";
  FormatType format();
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  
  @Target ({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE}) 
  @Retention (RetentionPolicy.RUNTIME) 
  @interface List {
    FormatDate[] format();
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
}
