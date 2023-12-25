package jp.co.jdsnet.base.validation;

import java.util.Locale;
import java.util.Optional;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.CheckRelationRequired;

public class CheckRelationRequiredValidator
    implements ConstraintValidator<CheckRelationRequired, Object> {
  private String condField;
  private String checkField;

  @Autowired
  private MessageSource messageSource;

  @Override
  public void initialize(CheckRelationRequired annotation) {
    this.condField = annotation.condField();
    this.checkField = annotation.checkField();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    BeanWrapper beanWrapper = new BeanWrapperImpl(value);
    Object condFieldValue = beanWrapper.getPropertyValue(condField);
    Object checkFieldValue = beanWrapper.getPropertyValue(checkField);

    context.unwrap(HibernateConstraintValidatorContext.class).addExpressionVariable("condFieldName",
        Optional.ofNullable(messageSource.getMessage(condField, null, Locale.getDefault()))
            .orElse(condField));
    context.unwrap(HibernateConstraintValidatorContext.class).addExpressionVariable(
        "checkFieldName",
        Optional.ofNullable(messageSource.getMessage(checkField, null, Locale.getDefault()))
            .orElse(checkField));

    if (StringUtils.isBlank((String) condFieldValue)) {
      return true;
    } else {
      if (StringUtils.isBlank((String) checkFieldValue)) {
        return false;
      } else {
        return true;
      }
    }
  }
}
