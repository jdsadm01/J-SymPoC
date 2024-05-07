package jp.co.jdsnet.base.validation;

import jp.co.jdsnet.base.annotation.CheckRelationRequired;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@CheckRelationRequired(condField = "testFeild1", checkField = "testFeild2")
public class ValidatorTestBean {
  String testFeild1;
  String testFeild2;
  String testFeild3;
}
