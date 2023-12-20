package jp.co.jdsnet.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {})
@Pattern(regexp = "^[a-zA-Z0-9 ]*$")
@ReportAsSingleViolation
public @interface CheckAsciiDigit {
  String message() default "{error.CheckAsciiDigit}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
