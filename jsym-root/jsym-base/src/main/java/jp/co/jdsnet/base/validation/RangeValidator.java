package jp.co.jdsnet.base.validation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.Range;

public class RangeValidator implements ConstraintValidator<Range, String> {
  private double min;
  private double max;
  
  @Override
  public void initialize(Range annotation) {
    min = annotation.min();
    max = annotation.max();
  }
  
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isBlank(value)) {
      return true;
    }
    
    try {
      double dValue = Double.parseDouble(value);
      if (dValue >= min && dValue <= max) {
        return true;
      } else {
        return false;
      }
    } catch (NumberFormatException e) {
      return true;
    }
  }
}
