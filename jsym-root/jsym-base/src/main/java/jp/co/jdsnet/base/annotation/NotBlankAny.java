package jp.co.jdsnet.base.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jp.co.jdsnet.base.validation.NotBlankAnyValidator;

@Retention(RUNTIME)
@Target({TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = NotBlankAnyValidator.class)
public @interface NotBlankAny {
  String message() default "{NotBlankAny.default}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String[] fields();

}
