package jp.co.jdsnet.base.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.LocalDate;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jp.co.jdsnet.base.validation.CheckRelationDateValidator;
import lombok.RequiredArgsConstructor;

@Retention(RUNTIME)
@Target({TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = CheckRelationDateValidator.class)
public @interface CheckRelationDate {
  String message() default "{CheckRelationDate.before}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String firstField();

  String secondField();

  CheckMode mode();


  @Target({TYPE, ANNOTATION_TYPE})
  @Retention(RUNTIME)
  public @interface List {
    CheckRelationDate[] value();
  }

  @RequiredArgsConstructor
  enum CheckMode {
    /** firstField ≦ secondField is TRUE */
    BEFORE {
      @Override
      public boolean compareDate(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isBefore(secondDate) || firstDate.isEqual(secondDate);
      }
    },
    /** firstField ≧ secondField is TRUE */
    AFTER {
      @Override
      public boolean compareDate(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isAfter(secondDate) || firstDate.isEqual(secondDate);
      }
    };

    /**
     * ２つの日付を比較する
     * 
     * @param firstDate パラメータ１
     * @param secondDate パラメータ２
     * @return @see CheckMode.BEFORE CheckMode.AFTER
     */
    public abstract boolean compareDate(LocalDate firstDate, LocalDate secondDate);
  }
}
