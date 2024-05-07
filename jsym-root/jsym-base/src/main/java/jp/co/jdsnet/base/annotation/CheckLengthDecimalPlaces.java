package jp.co.jdsnet.base.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jp.co.jdsnet.base.validation.CheckLengthDecimalPlacesValidator;

@Target({FIELD, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {CheckLengthDecimalPlacesValidator.class})
public @interface CheckLengthDecimalPlaces {
  String message() default "{CheckLength.DecimalPlaces}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  int value();

  @Target({FIELD, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  @interface List {
    CheckLengthDecimalPlaces[] value();
  }
}
