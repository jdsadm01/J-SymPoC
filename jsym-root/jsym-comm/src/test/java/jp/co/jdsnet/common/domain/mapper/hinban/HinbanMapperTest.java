package jp.co.jdsnet.common.domain.mapper.hinban;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.mapper.MapperTest;
import lombok.RequiredArgsConstructor;

@MapperTest
public class HinbanMapperTest {
  @Autowired
  HinbanMapper target;

  private static Comparator<HinbanEntity> comparator =
      Comparator.comparing(HinbanEntity::getDaikaiskbcod).thenComparing(HinbanEntity::getKigbng)
          .thenComparing(HinbanEntity::getKaiskbcod);

  @Nested
  class selectByInputKigbng {
    @RequiredArgsConstructor
    enum Param {
      CASE1_DAIHYO("AAA", "TEST000000001", "AAA") {
        @Override
        public List<HinbanEntity> getExpEntityList() {
          List<HinbanEntity> exp =
              getExpEntityListAll().stream().filter(t -> t.getDaikaiskbcod().equals("AAA"))
                  .filter(t -> t.getKigbng().equals("TEST000000001")).sorted(comparator).toList();
          exp.addAll(getExpEntityListAll().stream().filter(t -> t.getDaikaiskbcod().equals("AAA"))
              .filter(t -> t.getSryhnb().equals("TEST000000001")).sorted(comparator).toList());
          exp.addAll(getExpEntityListAll().stream().filter(t -> t.getDaikaiskbcod().equals("AAA"))
              .filter(t -> t.getJancod().equals("TEST000000001")).sorted(comparator).toList());
          return exp;

        }
      },
      CASE2_JYUTAKU("AAA", "TEST000000001", "AAB") {
        @Override
        public List<HinbanEntity> getExpEntityList() {
          return getExpEntityListAll().stream().filter(t -> t.getDaikaiskbcod().equals("AAA"))
              .filter(t -> t.getKigbng().equals("TEST000000001"))
              .filter(t -> t.getKaiskbcod().equals("AAB")).sorted(comparator).toList();
        }
      };

      private final String daikaiskbcod;
      private final String kigbng;
      private final String kaiskbcod;

      public HinbanEntity getInputEntity() {
        return HinbanEntity.builder().daikaiskbcod(daikaiskbcod).kigbng(kigbng).kaiskbcod(kaiskbcod)
            .build();
      }

      abstract public List<HinbanEntity> getExpEntityList();

      private static List<HinbanEntity> getExpEntityListAll() {
        List<HinbanEntity> explist = new ArrayList<>();
        explist.add(HinbanEntity.builder().daikaiskbcod("AAA").kigbng("TEST000000001")
            .kaiskbcod("AAB").titnm("テスト結果確認用タイトル１").build());
        explist.add(HinbanEntity.builder().daikaiskbcod("AAA").kigbng("TEST000000011")
            .kaiskbcod("AAB").titnm("テスト結果確認用タイトル２").sryhnb("TEST000000001").build());
        explist.add(HinbanEntity.builder().daikaiskbcod("AAA").kigbng("TEST000000021")
            .kaiskbcod("AAB").titnm("テスト結果確認用タイトル３").jancod("TEST000000001").build());
        explist.add(HinbanEntity.builder().daikaiskbcod("AAA").kigbng("TEST00000002")
            .kaiskbcod("AAB").titnm("テスト結果確認用タイトル４").build());
        explist.add(HinbanEntity.builder().daikaiskbcod("AAA").kigbng("TEST00000001")
            .kaiskbcod("AAC").titnm("テスト結果確認用タイトル５").build());
        explist.add(HinbanEntity.builder().daikaiskbcod("BBB").kigbng("TEST00000001")
            .kaiskbcod("AAB").titnm("テスト結果確認用タイトル６").build());

        return explist;
      }
    }

    @ParameterizedTest
    @EnumSource
    @Sql("/sql/hinban/hinbanMapper/selectByInputKigbng_dataset.sql")
    void test(Param param) {
      List<HinbanEntity> ret =
          target.selectByInputKigbng(param.daikaiskbcod, param.kigbng, param.kaiskbcod).stream()
              .sorted(comparator).toList();
      List<HinbanEntity> exp = param.getExpEntityList();
      assertAll(() -> assertThat(ret.size()).isEqualTo(exp.size()), () -> {
        for (int i = 0; i < ret.size(); i++) {
          assertThat(ret.get(i).toString()).isEqualTo(exp.get(i).toString());
        }
      });
    }
  }

  @Nested
  class test {
    @Test
    void testInsert() {
      HinbanEntity e = HinbanEntity.builder().daikaiskbcod("SME").kigbng("TEST000000001").build();
      target.insert(e);
    }
  }
}
