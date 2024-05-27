package jp.co.jdsnet.common.domain.mapper.hatchu;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import jp.co.jdsnet.common.domain.mapper.MapperTest;
import lombok.RequiredArgsConstructor;

@MapperTest
public class HatchuMapperTest {
  @Autowired
  HatchuMapper target;

  @Nested
  class getNkiMostRecently {
    @RequiredArgsConstructor
    enum Param {
      CASE1_DAIHYO("AAA", "AAA", "TEST000000001", 240301),
      CASE2_JYUTAKU("AAA", "AAB", "TEST000000001", 240302),
      CASE3_NODATA("AAA", "AAA", "TEST000000003", null);

      private final String daikaiskbcod;
      private final String kaiskbcod;
      private final String kigbng;
      private final Integer expNki;

    }

    @ParameterizedTest
    @EnumSource
    @Sql("/sql/hatchu/hatchuMapper/nkiMostRecently_dataset.sql")
    void test(Param param) {
      Integer ret = target.getNkiMostRecently(param.daikaiskbcod, param.kaiskbcod, param.kigbng);
      assertThat(ret).isEqualTo(param.expNki);
    }
  }

  @Nested
  class getNyukoYoteisuu {
    @RequiredArgsConstructor
    enum Param {
      CASE1_DAIHYO("AAA", "AAA", "TEST000000001", 240301, 280),
      CASE2_JYUTAKU("AAA", "AAB", "TEST000000001", 240301, 170),
      CASE3_NODATA("AAA", "AAA", "TEST000000001", 240303, null);

      private final String daikaiskbcod;
      private final String kaiskbcod;
      private final String kigbng;
      private final int nki;
      private final Integer exp;

    }

    @ParameterizedTest
    @EnumSource
    @Sql("/sql/hatchu/hatchuMapper/nyukoYoteisuu_dataset.sql")
    void test(Param param) {
      Integer ret = target.getNyukoYoteisuu(param.daikaiskbcod, param.kaiskbcod, param.kigbng, param.nki);
      assertThat(ret).isEqualTo(param.exp);
    }
  }
}
