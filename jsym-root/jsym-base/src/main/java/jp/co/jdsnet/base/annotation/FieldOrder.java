package jp.co.jdsnet.base.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * ClassのFieldの順序を指定します.
 * <p>
 * Javaの仕様としてFieldの順序は保証されないため、ClassのFiled順序を指定するためのAnnotationです.
 */
@Target({FIELD})
@Retention(RUNTIME)
public @interface FieldOrder {

    short value() default Short.MAX_VALUE;
}
