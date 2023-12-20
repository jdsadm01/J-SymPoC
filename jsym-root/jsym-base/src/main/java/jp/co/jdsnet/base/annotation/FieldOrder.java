package jp.co.jdsnet.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassのFieldの順序を指定します.
 * <p>
 * Javaの仕様としてFieldの順序は保証されないため、ClassのFiled順序を指定するためのAnnotationです.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldOrder {

    short value() default Short.MAX_VALUE;
}
