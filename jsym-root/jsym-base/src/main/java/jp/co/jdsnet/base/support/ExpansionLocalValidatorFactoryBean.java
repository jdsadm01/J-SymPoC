package jp.co.jdsnet.base.support;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import jakarta.validation.ConstraintViolation;
import jp.co.jdsnet.base.annotation.FieldOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * {@link LocalValidatorFactoryBean}の拡張クラス
 *
 * <p>拡張対象メソッド：<br>
 * {@linkplain #processConstraintViolations(Set, Errors)}
 *
 * @author r-matsumura
 *
 */
@Slf4j
public class ExpansionLocalValidatorFactoryBean extends LocalValidatorFactoryBean {

  /**
   * Validatorのメッセージ表示順を{@link FieldOrder}で指定した順に変更する。
   *
   * <p>デフォルトだとHashSetなので順序が保証されない。<br>
   * したがって{@link FieldOrder}でLinkedHashSetに詰め替えを行うことで指定順に表示させる。
   */
  @Override
  protected void processConstraintViolations(Set<ConstraintViolation<Object>> violations,
      Errors errors) {
    Class<FieldOrder> clazz = FieldOrder.class;
    List<Temp> temp = new ArrayList<>();
    for (ConstraintViolation<Object> violation : violations) {
      int order = Integer.MAX_VALUE;
      try {
        Field field =
            violation.getRootBeanClass().getDeclaredField(violation.getPropertyPath().toString());
        order = Optional.ofNullable(field.getAnnotation(clazz)).get().value();
      } catch (NoSuchFieldException | SecurityException | NoSuchElementException e) {
        log.warn("表示順指定なし：Class=" + violation.getRootBeanClass().toString() + "Field="
            + violation.getPropertyPath().toString());
      }
      temp.add(new Temp(order, violation.getPropertyPath().toString(), violation));
    }
    Set<ConstraintViolation<Object>> sortedViolations =
        temp.stream().sorted(Comparator.comparing(Temp::getOrder).thenComparing(Temp::getField))
            .map(e -> e.getViolation())
            .collect(Collectors.toCollection(LinkedHashSet<ConstraintViolation<Object>>::new));
    super.processConstraintViolations(sortedViolations, errors);
  }

  @Getter
  @AllArgsConstructor
  private class Temp {
    private int order;
    private String field;
    private ConstraintViolation<Object> violation;
  }
}
