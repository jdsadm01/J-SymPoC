package jp.co.jdsnet.base.validation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.CheckString;

public class FormatStringValidator implements ConstraintValidator<CheckString, String> {
  private CheckString.CheckStyle checkstyle;
  
  @Override
  public void initialize(CheckString annotation) {
    this.checkstyle = annotation.style();
  }
  
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isBlank(value)) {
      return true;
    }
    
    if (checkstyle.isCorrectFormat(value)) {
      return true;
    }

    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate(checkstyle.getMessage()).addConstraintViolation();
    return false;
  }
}
