package jp.co.jdsnet.base.validation;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
import lombok.RequiredArgsConstructor;

@SpringBootTest(classes = CheckRelationRequiredValidator.class)
public class CheckRelationRequiredValidatorTest {
  @Autowired
  private Validator validator;

//  @BeforeTestClass
//  public static void setUpBeforeClass() {
//    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//    validator = validatorFactory.getValidator();
//  }

  @ParameterizedTest
  @EnumSource
  public void 正常系(正常系Param parm) {

    // setup
    ValidatorTestBean form = new ValidatorTestBean();
    form.setTestFeild1(parm.param1);
    form.setTestFeild2(parm.param2);
    BindingResult bindingResult = new BindException(form, "form");

//    // run the test
//    Set<ConstraintViolation<ValidatorTestBean>> violations = validator.validate(form); // (2)
//
//    // assert
//    assertThat(violations).isEmpty(); // (3)

     validator.validate(form, bindingResult);
     // 結果検証
     assertNull(bindingResult.getFieldError());

  }

  @RequiredArgsConstructor
  enum 正常系Param {
    TEST1("notBlank", "notBlank", false), TEST2("", "", false);

    private final String param1;
    private final String param2;
    private final boolean expected;
  }
}
