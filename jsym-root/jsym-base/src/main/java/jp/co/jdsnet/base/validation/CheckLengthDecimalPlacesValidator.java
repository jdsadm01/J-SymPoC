package jp.co.jdsnet.base.validation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.CheckLengthDecimalPlaces;

public class CheckLengthDecimalPlacesValidator
    implements ConstraintValidator<CheckLengthDecimalPlaces, String> {
  private String pattern;
  
  @Override
  public void initialize(CheckLengthDecimalPlaces annotation) {
    pattern = "[+-]?([0-9]+)(\\.[0-9]{1," + annotation.value() + "}|)";
  }
  
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isBlank(value)) {
      return true;
    }
    return value.matches(pattern);
  }
}
