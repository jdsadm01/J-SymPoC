package jp.co.jdsnet.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jp.co.jdsnet.base.validation.CheckRelationRequiredValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = CheckRelationRequiredValidator.class)
public @interface CheckRelationRequired {
  String message() default "{error.CheckRelationRequired}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String condField();

  String checkField();

  @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  public @interface List {
    CheckRelationRequired[] value();
  }
}
