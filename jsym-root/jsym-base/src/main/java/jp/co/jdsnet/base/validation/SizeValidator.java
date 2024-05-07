package jp.co.jdsnet.base.validation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.Size;

public class SizeValidator implements ConstraintValidator<Size, String> {
  private int min;
  private int max;

  private String min_message = "{Size.min}";
  private String max_message = "{Size.max}";
  
  @Override
  public void initialize(Size annotation) {
    min = annotation.min();
    max = annotation.max();
  }
  
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isBlank(value)) {
      return true;
    }
    
    if (value.length() < min || value.length() > max) {
      if (min == 0) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(max_message).addConstraintViolation();
      } else if (max == Integer.MAX_VALUE) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(min_message).addConstraintViolation();
      }
      return false;
    }
    return true;
  }
}
