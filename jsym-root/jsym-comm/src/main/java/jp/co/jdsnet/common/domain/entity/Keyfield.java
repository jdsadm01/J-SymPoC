package jp.co.jdsnet.common.domain.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Entityの主キーを指定します.
 * <p>
 * 文字列出力用に順序も指定します.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Keyfield {
    short index();
}
