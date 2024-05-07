package jp.co.jdsnet.base.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jp.co.jdsnet.base.validation.SizeValidator;

/**
 * 桁数チェック
 * <p>
 * 指定桁数の範囲内にあるかどうかをチェックする。
 * 
 * @author r-matsumura
 *
 */
@Target({FIELD, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {SizeValidator.class})
public @interface Size {
  String message() default "{Size.default}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  
  int min() default 0;

  int max() default Integer.MAX_VALUE;

  @Target({FIELD, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  @interface List {
    Size[] value();
  }
}
