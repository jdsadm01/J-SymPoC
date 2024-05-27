package jp.co.jdsnet.base.validation;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.CheckRelationRequired;
import jp.co.jdsnet.base.support.MessageHelper;

public class CheckRelationRequiredValidator
    implements ConstraintValidator<CheckRelationRequired, Object> {
  private String condField;
  private String checkField;

  @Autowired
  private MessageHelper messageUtility;

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

    HibernateConstraintValidatorContext hibernateContext =
        context.unwrap(HibernateConstraintValidatorContext.class);
    hibernateContext.disableDefaultConstraintViolation();
    hibernateContext.addMessageParameter("condFieldName", messageUtility.getMessage(condField))
        .addMessageParameter("checkFieldName", messageUtility.getMessage(checkField))
        .buildConstraintViolationWithTemplate(
            hibernateContext.getDefaultConstraintMessageTemplate())
        .addConstraintViolation();

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
