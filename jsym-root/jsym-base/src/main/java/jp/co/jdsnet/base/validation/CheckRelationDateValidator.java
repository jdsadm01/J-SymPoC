package jp.co.jdsnet.base.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.CheckRelationDate;
import jp.co.jdsnet.base.annotation.CheckRelationDate.CheckMode;
import jp.co.jdsnet.common.utils.FormatUtility;

public class CheckRelationDateValidator
    implements ConstraintValidator<CheckRelationDate, Object> {
  private String first;
  private String second;
  CheckMode mode;
  private String message_after = "{CheckRelationDate.after}";

  @Override
  public void initialize(CheckRelationDate annotation) {
    this.first = annotation.firstField();
    this.second = annotation.secondField();
    this.mode = annotation.mode();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    BeanWrapper beanWrapper = new BeanWrapperImpl(value);
    String firstValue = (String) beanWrapper.getPropertyValue(this.first);
    String secondValue = (String) beanWrapper.getPropertyValue(this.second);

    if (StringUtils.isBlank(firstValue) || StringUtils.isBlank(secondValue)) {
      return true;
    }

    try {
      if (this.mode == CheckMode.AFTER) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message_after).addConstraintViolation();
      }
      return this.mode.compareDate(convertDate(firstValue), convertDate(secondValue));
    } catch (NumberFormatException e) {
      return true;
    }
  }

  private LocalDate convertDate(String value) {
    try {
      return DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT).parse(
          String.valueOf(FormatUtility.convertYYYYMMDD(Integer.parseInt(value))), LocalDate::from);
    } catch (NumberFormatException e) {
      throw e;
    }
  }
}
