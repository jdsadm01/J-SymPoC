package jp.co.jdsnet.common.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import jp.co.jdsnet.common.domain.entity.sysmas.JokenEntity;
import jp.co.jdsnet.common.domain.mapper.sysmas.JokenMapper;
import jp.co.jdsnet.common.domain.vo.KaishaProcDateInfo;
import jp.co.jdsnet.common.logic.implement.KaishaRelatedSharedServiceImpl;
import lombok.RequiredArgsConstructor;

@SpringBootTest(classes = KaishaRelatedSharedService.class)
public class KaishaRelatedSharedServiceServiceTest {

  @InjectMocks
  private KaishaRelatedSharedServiceImpl target;

  @Mock
  private JokenMapper jokenMapper;

  @Nested
  class getKaishaProcDateInfo {
    @RequiredArgsConstructor
    enum Param {
      test("ADI",
          "20240425202201105280124CO 210731  0000000000210630210709210630     SME210731  0000000000210630210709210630     JDS210720  0000000000210618210709210618     PCH210731  0000000000210630210709210630     WP 210730  0000000000210625210709210625     SCE210731  0000000000210630210709210630     SPE210731  0000000000210630210709210630     ADI210731  0000000000210630210709210630     ENI210731  0000000000210630210709210630     KOE210731  0000000000210630210709210630     DDD210731  0000000000210630210709210630     CAP210731  0000000000210630210709210630     K  210720  0000000000210618210709210618     BW 210720  0000000000210618210709210618     KII210720  0000000000210618210709210618     FX 210731  0000000000210630210709210630     VAP210731  0000000000210630210709210630     FDI210731  0000000000210630210709210630     TCE210731  0000000000210630210709210630     SEG210731  0000000000210630210709210630     BAN210731  0000000000210630210709210630     LV 210731  0000000000210630210709210630     API210731  0000000000210630210709210630     KAD210731  0000000000210630210709210630                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ");

      private final String daikaiskbcod;
      private final String txt;

      public JokenEntity getEntity() {
        return JokenEntity.builder().txt(txt).build();
      }
    }

    @ParameterizedTest
    @EnumSource
    void test(Param parm) {
      when(jokenMapper.selectWithoutLogicalDelete(Mockito.any())).thenReturn(parm.getEntity());
      KaishaProcDateInfo result = target.getKaishaProcDateInfo(parm.daikaiskbcod);
      assertAll("適切な値で取得したかどうか確認",
          () -> assertThat(result.getPrcdte()).isEqualTo(20240425),
          () -> assertThat(result.getLastPrcdte()).isEqualTo(20220110),
          () -> assertThat(result.getDayOfWeek()).isEqualTo("5"),
          () -> assertThat(result.getWeekOfYear()).isEqualTo(28),
          () -> assertThat(result.getDaikaiskbcod()).isEqualTo("ADI"),
          () -> assertThat(result.getMkrsmedte()).isEqualTo(210731),
          () -> assertThat(result.getCalendarPosition()).isEqualTo("  "),
          () -> assertThat(result.getKaddtekbn()).isEqualTo("0"),
          () -> assertThat(result.getEdpPrcdtekbn()).isEqualTo("0"),
          () -> assertThat(result.getEdpSmedtekbn()).isEqualTo("0"),
          () -> assertThat(result.getEdpWeeklykbn()).isEqualTo("0"),
          () -> assertThat(result.getEdpEndOfMonthkbn()).isEqualTo("0"),
          () -> assertThat(result.getLastMkrsmedte()).isEqualTo(210630),
          () -> assertThat(result.getLastWeeklyprcdte()).isEqualTo(210709),
          () -> assertThat(result.getLastEndOfMonthprcdte()).isEqualTo(210630));
    }
  }
}
