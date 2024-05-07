package jp.co.jdsnet.base.validation;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.CheckDate;

public class FormatDateValidator implements ConstraintValidator<CheckDate, String> {
  private CheckDate.FormatType format;
  private CheckDate.AllowException allow;
  
  @Override
  public void initialize(CheckDate annotation) {
    format = annotation.format();
    allow = annotation.allow();
  }
  
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isBlank(value)) {
      return true;
    }
    
    if (!format.isCorrectFormat(value)) {
      return allow.isAllowFormat(value, format.name().length());
    }

    try {
      DateTimeFormatter formatter = 
          DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT);
      
      LocalDate.parse(format.getFormatYYYYMMDD(value), formatter);
      return true;
    } catch (DateTimeException e) {
      return false;
    }
  }
}
