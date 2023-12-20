package jp.co.jdsnet.base.validation;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.FormatDate;

public class FormatDateValidator implements ConstraintValidator<FormatDate, String> {
  private FormatDate.FormatType format;
  
  @Override
  public void initialize(FormatDate formatDate) {
    format = formatDate.format();
  }
  
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isBlank(value)) {
      return true;
    }
    
    if (!format.isCorrectFormat(value)) {
      return false;
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
