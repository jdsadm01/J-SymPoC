package jp.co.jdsnet.base.validation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.jdsnet.base.annotation.NotBlankAny;
import jp.co.jdsnet.base.support.MessageHelper;

public class NotBlankAnyValidator implements ConstraintValidator<NotBlankAny, Object> {
  private String[] fields;

  @Autowired
  private MessageHelper messageUtility;

  @Override
  public void initialize(NotBlankAny annotation) {
    this.fields = annotation.fields();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    if (Objects.isNull(value)) {
      return true;
    }

    List<String> msgfileds = Stream.of(fields).map(v -> messageUtility.getMessage(v)).toList();

    HibernateConstraintValidatorContext hiContext =
        context.unwrap(HibernateConstraintValidatorContext.class);
    String messageTmplate = hiContext.getDefaultConstraintMessageTemplate();
    if (msgfileds.size() == 2) {
      messageTmplate = "{NotBlankAny.whichone}";
    }
    hiContext.disableDefaultConstraintViolation();
    hiContext.addMessageParameter("fields", String.join("、", msgfileds))
        .buildConstraintViolationWithTemplate(messageTmplate)
        .addConstraintViolation();


    BeanWrapper beanWrapper = new BeanWrapperImpl(value);
    return Stream.of(fields).map(beanWrapper::getPropertyValue).filter(v -> Objects.nonNull(v))
        .map(Object::toString).anyMatch(v -> !v.isBlank());
  }
}
