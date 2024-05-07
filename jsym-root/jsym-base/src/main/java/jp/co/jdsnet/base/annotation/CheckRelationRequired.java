package jp.co.jdsnet.base.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jp.co.jdsnet.base.validation.CheckRelationRequiredValidator;

@Retention(RUNTIME)
@Target({TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = CheckRelationRequiredValidator.class)
public @interface CheckRelationRequired {
  String message() default "{CheckRelationRequired.default}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String condField();

  String checkField();

  @Target({TYPE, ANNOTATION_TYPE})
  @Retention(RUNTIME)
  public @interface List {
    CheckRelationRequired[] value();
  }
}
