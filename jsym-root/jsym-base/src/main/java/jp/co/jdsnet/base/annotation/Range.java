package jp.co.jdsnet.base.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jp.co.jdsnet.base.validation.RangeValidator;

/**
 * 範囲チェック
 * <p>
 * 指定の範囲内にあるかどうかをチェックする。<br>
 * 必須・型チェックがある前提の為、ブランクおよび数値変換不可の場合はエラーとしない。
 * 
 * @author r-matsumura
 *
 */
@Target({FIELD, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {RangeValidator.class})
public @interface Range {
  String message() default "{Range}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  
  double min();

  double max();

  @Target({FIELD, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  @interface List {
    Range[] value();
  }
}
