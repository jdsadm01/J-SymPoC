package jp.co.jdsnet.common.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import jp.co.jdsnet.common.domain.entity.kaisha.KaishaBunruiEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.KaishaEntity;
import jp.co.jdsnet.common.domain.entity.sysmas.JokenEntity;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaBunruiMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaMapper;
import jp.co.jdsnet.common.domain.mapper.sysmas.JokenMapper;
import jp.co.jdsnet.common.domain.vo.KaishaProcDateInfo;
import jp.co.jdsnet.common.logic.implement.KaishaRelatedSharedServiceImpl;
import jp.co.jdsnet.common.utils.GlobalConstants.Usrbun;
import lombok.RequiredArgsConstructor;

@SpringBootTest(classes = KaishaRelatedSharedService.class)
public class KaishaRelatedSharedServiceTest {

  @InjectMocks
  private KaishaRelatedSharedServiceImpl target;

  @Mock
  private JokenMapper jokenMapper;
  @Mock
  private KaishaMapper kaishaMapper;
  @Mock
  private KaishaBunruiMapper kaishaBunruiMapper;
  @Mock
  private MessageSource messageSource;

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

  @Nested
  class getKaisha {
    @RequiredArgsConstructor
    enum Param1 {
      CASE1_MKR(Usrbun.MKR), CASE2_JDS(Usrbun.JDS), CASE3_JAR(Usrbun.JAR), CASE4_TAK(Usrbun.TAK);

      private final Usrbun usrbun;

      public KaishaEntity getKaishaEntity() {
        return KaishaEntity.builder().daikaiskbcod("TST").kaibunkbn("0").build();
      }
    }

    @ParameterizedTest
    @EnumSource
    void 正常終了(Param1 param) {
      when(kaishaMapper.selectWithoutLogicalDelete(Mockito.any())).thenReturn(param.getKaishaEntity());
      when(kaishaBunruiMapper.select(Mockito.any())).thenReturn(KaishaBunruiEntity.builder().build());
      
      KaishaEntity result = target.getKaisha("", param.usrbun);
      assertThat(result.toString()).isEqualTo(param.getKaishaEntity().toString());
    }

    @RequiredArgsConstructor
    enum Param2 {
      CASE1_会社マスタ無し(Usrbun.MKR, "0", List.of("kaiskbcod", "error.errors")) {
        @Override
        public KaishaEntity getKaishaEntity() {
          return null;
        }
      },
      CASE2_受託設定(Usrbun.JDS, "1", List.of("kaiskbcod", "error.errors")), 
      CASE3_物流拠点NG_JAR(Usrbun.JAR, "0", List.of("arg.kaikyy", "error.errors")) {
        @Override
        public KaishaBunruiEntity getKaishaBunruiEntity() {
          return null;
        }
      },
      CASE4__物流拠点NG_TAK(Usrbun.TAK, "0", List.of("arg.kaikyy", "error.errors")) {
        @Override
        public KaishaBunruiEntity getKaishaBunruiEntity() {
          return null;
        }
      };

      private final Usrbun usrbun;
      private final String kaibunkbn;
      private final List<String> msgkeys;

      public KaishaEntity getKaishaEntity() {
        return KaishaEntity.builder().daikaiskbcod("TST").kaibunkbn(this.kaibunkbn).build();
      }

      public KaishaBunruiEntity getKaishaBunruiEntity() {
        return KaishaBunruiEntity.builder().build();
      }
    }

    @ParameterizedTest
    @EnumSource
    void 異常終了(Param2 param) {
      final ArgumentCaptor<String> cap = ArgumentCaptor.forClass(String.class);
      when(kaishaMapper.selectWithoutLogicalDelete(Mockito.any()))
          .thenReturn(param.getKaishaEntity());
      when(kaishaBunruiMapper.select(Mockito.any())).thenReturn(param.getKaishaBunruiEntity());
      when(messageSource.getMessage(Mockito.anyString(), Mockito.any(), Mockito.any(Locale.class)))
          .thenReturn("").thenReturn("");

      Throwable ex = assertThrows(Exception.class, () -> target.getKaisha("", param.usrbun));
      assertAll("Exception検証",
          () -> assertThat(ex.getClass()).isEqualTo(NoSuchElementException.class),
          () -> verify(messageSource, times(2)).getMessage(cap.capture(), Mockito.any(),
              Mockito.any(Locale.class)),
          () -> assertThat(cap.getAllValues().get(0)).isEqualTo(param.msgkeys.get(0)),
          () -> assertThat(cap.getAllValues().get(1)).isEqualTo(param.msgkeys.get(1)));
    }

  }
}
