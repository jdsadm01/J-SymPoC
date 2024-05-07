package jp.co.jdsnet.common.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import jp.co.jdsnet.common.domain.entity.control.ServiceControlEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity.Gmnkbn;
import jp.co.jdsnet.common.domain.entity.sysmas.JdsCalendarEntity;
import jp.co.jdsnet.common.domain.entity.sysmas.JokenEntity;
import jp.co.jdsnet.common.domain.entity.sysmas.JsymMsEntity;
import jp.co.jdsnet.common.domain.mapper.control.ServiceControlMapper;
import jp.co.jdsnet.common.domain.mapper.menu.EventMapper;
import jp.co.jdsnet.common.domain.mapper.sysmas.JdsCalendarMapper;
import jp.co.jdsnet.common.domain.mapper.sysmas.JokenMapper;
import jp.co.jdsnet.common.domain.mapper.sysmas.JsymMsMapper;
import jp.co.jdsnet.common.logic.CommonCheckSharedService.ServiceTime;
import jp.co.jdsnet.common.logic.implement.CommonCheckSharedServiceImpl;
import jp.co.jdsnet.common.utils.GlobalConstants.Flg;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;
import jp.co.jdsnet.common.utils.GlobalConstants.Usrbun;
import lombok.RequiredArgsConstructor;

@SpringBootTest(classes = CommonCheckSharedService.class)
public class CommonCheckSharedServiceTest {

  @InjectMocks
  private CommonCheckSharedServiceImpl target;

  @Mock
  private EventMapper eventMapper;
  @Mock
  private ServiceControlMapper serviceControlMapper;
  @Mock
  private JsymMsMapper msMapper;
  @Mock
  private JokenMapper jokenMapper;
  @Mock
  private JdsCalendarMapper jdsCalendarMapper;

  @Nested
  class checkServiceTimeTest {
    @RequiredArgsConstructor
    enum 正常終了_TestParam {
      // システム時間は2024/03/01 12：00：00でテスト
      時間内_1_1(Flg.ON, 20240229, 20240302, 115959, 120001, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE),
      時間内_1_2(Flg.ON, 20240229, 20240302, 115959, 120000, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE),
      時間内_1_3(Flg.ON, 20240229, 20240302, 120000, 120001, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_1_4(Flg.ON, 20240229, 20240302, 120000,120000, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_2_1(Flg.ON, 20240229,20240301, 115959, 120001, Flg.OFF, 0, 0, 0, 0,ServiceTime.ONLINE), 
      時間内_2_2(Flg.ON, 20240229, 20240301, 115959, 120000, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_2_3(Flg.ON, 20240229, 20240301, 120000, 120001, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_2_4(Flg.ON, 20240229, 20240301, 120000, 120000, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_3_1(Flg.ON, 20240301, 20240302, 115959, 120001, Flg.OFF, 0, 0,0, 0, ServiceTime.ONLINE), 
      時間内_3_2(Flg.ON, 20240301, 20240302, 115959, 120000, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_3_3(Flg.ON, 20240301, 20240302, 120000, 120001, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_3_4(Flg.ON, 20240301, 20240302, 120000, 120000, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_4_1(Flg.ON, 20240301, 20240301, 115959, 120001, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_4_2(Flg.ON, 20240301, 20240301, 115959, 120000, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE), 
      時間内_4_3(Flg.ON, 20240301, 20240301, 120000, 120001, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE),
      時間内_4_4(Flg.ON, 20240301, 20240301, 120000, 120000, Flg.OFF, 0, 0, 0, 0, ServiceTime.ONLINE),
      溜打ち_1_1(Flg.OFF, 20240229, 20240302, 115959, 120001, Flg.ON, 20240229, 20240302, 115959, 120001, ServiceTime.SUBTIME), 
      溜打ち_1_2(Flg.ON, 20240229, 20240229, 115959, 120001, Flg.ON, 20240229, 20240302, 115959, 120000, ServiceTime.SUBTIME), 
      溜打ち_1_3(Flg.ON, 20240302, 20240302, 115959, 120001, Flg.ON, 20240229, 20240302, 120000, 120001, ServiceTime.SUBTIME), 
      溜打ち_1_4(Flg.ON, 20240229, 20240302, 115959, 115959, Flg.ON, 20240229, 20240302, 120000, 120000, ServiceTime.SUBTIME), 
      溜打ち_2_1(Flg.ON, 20240229, 20240301, 120001, 120001, Flg.ON, 20240229, 20240301, 115959, 120001, ServiceTime.SUBTIME), 
      溜打ち_2_2(Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240229, 20240301, 115959, 120000, ServiceTime.SUBTIME), 
      溜打ち_2_3(Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240229, 20240301, 120000, 120001, ServiceTime.SUBTIME), 
      溜打ち_2_4(Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240229, 20240301, 120000, 120000, ServiceTime.SUBTIME), 
      溜打ち_3_1(Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240301, 20240302, 115959, 120001, ServiceTime.SUBTIME), 
      溜打ち_3_2(Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240301, 20240302, 115959, 120000, ServiceTime.SUBTIME), 
      溜打ち_3_3(Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240301, 20240302, 120000, 120001, ServiceTime.SUBTIME), 
      溜打ち_3_4(Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240301, 20240302, 120000, 120000, ServiceTime.SUBTIME), 
      溜打ち_4_1(Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240301, 20240301, 115959, 120001, ServiceTime.SUBTIME), 
      溜打ち_4_2( Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240301, 20240301, 115959, 120000, ServiceTime.SUBTIME), 
      溜打ち_4_3(Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240301, 20240301, 120000, 120001, ServiceTime.SUBTIME), 
      溜打ち_4_4( Flg.OFF, 0, 0, 0, 0, Flg.ON, 20240301, 20240301, 120000, 120000, ServiceTime.SUBTIME),
      時間外_1(Flg.OFF, 20240229, 20240302, 115959, 120001, Flg.OFF, 20240229, 20240302, 115959, 120001, ServiceTime.TIMEOUT), 
      時間外_2(Flg.ON, 20240229, 20240229, 115959, 120001, Flg.ON, 20240229, 20240229, 115959, 120001, ServiceTime.TIMEOUT), 
      時間外_3(Flg.ON, 20240302, 20240302, 115959, 120001, Flg.ON, 20240302, 20240302, 115959, 120001, ServiceTime.TIMEOUT), 
      時間外_4(Flg.ON, 20240301, 20240301, 115959, 115959, Flg.ON, 20240301, 20240301, 115959, 115959, ServiceTime.TIMEOUT), 
      時間外_5(Flg.ON, 20240301, 20240301, 120001, 120001, Flg.ON, 20240301, 20240301, 120001, 120001, ServiceTime.TIMEOUT),;

      private final Flg svcflg1;
      private final int svcsttdte1;
      private final int svcenddte1;
      private final int svcsttjkk1;
      private final int svcendjkk1;
      private final Flg svcflg2;
      private final int svcsttdte2;
      private final int svcenddte2;
      private final int svcsttjkk2;
      private final int svcendjkk2;
      private final ServiceTime exp;
    }

    @ParameterizedTest
    @EnumSource
    void 正常終了(正常終了_TestParam param) {
      when(eventMapper.select(Mockito.any())).thenReturn(EventEntity.builder().build());
      ServiceControlEntity scEntity = ServiceControlEntity.builder().svcflg1(param.svcflg1.getCode())
          .svcsttdte1(param.svcsttdte1).svcenddte1(param.svcenddte1).svcsttjkk1(param.svcsttjkk1)
          .svcendjkk1(param.svcendjkk1).svcflg2(param.svcflg2.getCode()).svcsttdte2(param.svcsttdte2)
          .svcenddte2(param.svcenddte2).svcsttjkk2(param.svcsttjkk2).svcendjkk2(param.svcendjkk2).build();
      when(serviceControlMapper.select(Mockito.any())).thenReturn(scEntity);
      
      LocalDateTime ldt = LocalDateTime.of(2024, 3, 1, 12, 0, 0);
      try (MockedStatic<LocalDateTime> mockldt = Mockito.mockStatic(LocalDateTime.class)) {
        mockldt.when(() -> LocalDateTime.now()).thenReturn(ldt);
        ServiceTime result = target.checkServiceTime("", "", "", "", Gmnkbn.ServiceTimeCheck);
        assertThat(result).isEqualTo(param.exp);
      }
    }

    @RequiredArgsConstructor
    enum 異常終了_TestParam {
      イベントマスタ無し(null, null,
          "イベントマスタ(VTBCNL10)未登録　画面ID：,画面SeqNo：,画面区分：S "),
      サービスコントロール無し(EventEntity.builder().build(), null,
          "サービスコントロールテーブル(VTBCNL01)未登録　代表会社識別コード：,ユーザー分類：,業務ID：,処理区分：");

      private final EventEntity eventEntity;
      private final ServiceControlEntity serviceControlEntity;
      private final String exceptionMessage;
    }

    @ParameterizedTest
    @EnumSource
    void 異常終了(異常終了_TestParam param) {
      when(eventMapper.select(Mockito.any())).thenReturn(param.eventEntity);
      when(serviceControlMapper.select(Mockito.any())).thenReturn(param.serviceControlEntity);
      Throwable ex = assertThrows(RuntimeException.class,
          () -> target.checkServiceTime("", "", "", "", EventEntity.Gmnkbn.Search));
      
      assertAll("Exception検証",
          ()-> assertThat(ex.getClass()).isEqualTo(NoSuchElementException.class),
          ()-> assertThat(ex.getMessage()).isEqualTo(param.exceptionMessage));
    }

    @RequiredArgsConstructor
    enum isOkメソッド_TestParam {
      ST等価_ED等価(20240301,20240301,20240301,true),
      ST等価_ED未満(20240301,20240229,20240301,false),
      ST等価_ED超過(20240301,20240302,20240301,true),
      ST未満_ED等価(20240229,20240301,20240301,true),
      ST未満_ED未満(20240229,20240229,20240301,false),
      ST未満_ED超過(20240229,20240302,20240301,true),
      ST超過_ED等価(20240302,20240301,20240301,false),
      ST超過_ED未満(20240302,20240229,20240301,false),
      ST超過_ED超過(20240302,20240302,20240301,false);
      private final int stt;
      private final int end;
      private final int sys;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void isOkメソッド(isOkメソッド_TestParam param) throws Exception {
      Method method = CommonCheckSharedServiceImpl.class.getDeclaredMethod("isOk", int.class,
          int.class, int.class);
      method.setAccessible(true);
      boolean result = (boolean)method.invoke(target, param.stt, param.end, param.sys);
      assertThat(result).isEqualTo(param.exp);
    }
    
    @RequiredArgsConstructor
    enum isInServiceTimeメソッド_TestParam {
      フラグON_日付TRUE_時刻TRUE(Flg.ON, 20240301, 20240301, 20240301, 120000, 120000, 120000, true),
      フラグON_日付FALSE_時刻TRUE(Flg.ON, 20240301, 20240301, 20240302, 120000, 120000, 120000, false),
      フラグON_日付TRUE_時刻FALSE(Flg.ON, 20240301, 20240301, 20240301, 120000, 120000, 120001, false),
      フラグON_日付FALSE_時刻FALSE(Flg.ON, 20240301, 20240301, 20240302, 120000, 120000, 120001, false),
      フラグOFF_日付TRUE_時刻TRUE(Flg.OFF, 20240301, 20240301, 20240301, 120000, 120000, 120000, false),
      フラグOFF_日付FALSE_時刻TRUE(Flg.OFF, 20240301, 20240301, 20240302, 120000, 120000, 120000, false),
      フラグOFF_日付TRUE_時刻FALSE(Flg.OFF, 20240301, 20240301, 20240301, 120000, 120000, 120001, false),
      フラグOFF_日付FALSE_時刻FALSE(Flg.OFF, 20240301, 20240301, 20240302, 120000, 120000, 120001, false);

      private final Flg flg;
      private final int stdte;
      private final int eddte;
      private final int sysdte;
      private final int stjkk;
      private final int edjkk;
      private final int sysjkk;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void isInServiceTimeメソッド(isInServiceTimeメソッド_TestParam param) throws Exception {
      Method method = CommonCheckSharedServiceImpl.class.getDeclaredMethod("isInServiceTime", Flg.class,
          int.class, int.class, int.class, int.class, int.class, int.class);
      method.setAccessible(true);
      boolean result = (boolean) method.invoke(target, param.flg, param.stdte, param.eddte,
          param.stjkk, param.edjkk, param.sysdte, param.sysjkk);
      assertThat(result).isEqualTo(param.exp);
    }
  }
  
  @Nested
  class isUsableMscod {
    @RequiredArgsConstructor
    enum Param {
      MS_4X("4X", false),
      MS_Z9("Z9", false),
      MS_ZU("ZU", false);
      private final String mscod;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void test(Param parm) {
      boolean result = target.isUsableMscod(parm.mscod, "");
      assertThat(result).isEqualTo(parm.exp);
    }
  }

  @Nested
  class isUsableAllMscod {
    @RequiredArgsConstructor
    enum Param {
      共通有り(JsymMsEntity.builder().build(), null, true),
      個社有り(null, JsymMsEntity.builder().build(), true),
      該当無し(null, null, false);
      private final JsymMsEntity first;
      private final JsymMsEntity second;
      private final boolean exp;
    }

    @ParameterizedTest
    @EnumSource
    void test(Param parm) {
      when(msMapper.selectWithoutLogicalDelete(Mockito.any())).thenReturn(parm.first).thenReturn(parm.second);
      boolean result = target.isUsableAllMscod("", "");
      assertThat(result).isEqualTo(parm.exp);
    }
  }
  
  @Nested
  class isUsableSmtcod {
    @RequiredArgsConstructor
    enum Param {
      該当有り("BB", "03AABBCC", true),
      該当無し("CC", "02AABB", false),
      明細無し("AA", "00", false),
      登録無し("", "", false) {
        @Override
        public JokenEntity getEntity() {
          return null;
        }
      };
      private final String input;
      private final String txt;
      private final boolean exp;
      public JokenEntity getEntity() {
        return JokenEntity.builder().txt(txt).build();
      }
    }

    @ParameterizedTest
    @EnumSource
    void test(Param parm) {
      when(jokenMapper.selectWithoutLogicalDelete(Mockito.any())).thenReturn(parm.getEntity());
      boolean result = target.isUsableSmtcod(parm.input, "", Trncod.TSUJO_URIAGE);
      assertThat(result).isEqualTo(parm.exp);
    }
  }

  @Nested
  class isUsableTrncod {
    @RequiredArgsConstructor
    enum Param {
      該当有り(Trncod.TSUJO_URIAGE, "03120  250  292  ", false),
      該当無し(Trncod.TSUJO_URIAGE, "02120  260  ", true),
      明細無し(Trncod.TSUJO_URIAGE, "00", false),
      登録無し(Trncod.TSUJO_URIAGE, "", true) {
        @Override
        public JokenEntity getEntity() {
          return null;
        }
      };
      private final Trncod input;
      private final String txt;
      private final boolean exp;
      public JokenEntity getEntity() {
        return JokenEntity.builder().txt(txt).build();
      }
    }

    @ParameterizedTest
    @EnumSource
    void test(Param parm) {
      when(jokenMapper.selectWithoutLogicalDelete(Mockito.any())).thenReturn(parm.getEntity());
      boolean result = target.isUsableTrncod(parm.input, "");
      assertThat(result).isEqualTo(parm.exp);
    }
  }

  @Nested
  class isUsableBshcod {
    @RequiredArgsConstructor
    enum Param {
      該当有り("A123", Usrbun.JDS, "003H001A123M032", true, "M1301"),
      該当無し("A123", Usrbun.MKR, "002H001C400", false, "M1301"),
      明細無し("A123", Usrbun.JDS, "000", false, "M1301"),
      登録無し("A123", Usrbun.JDS, "", false, "M1301") {
        @Override
        public JokenEntity getEntity() {
          return null;
        }
      },
      JARED("A123", Usrbun.JAR, "000", false, "M1301 JAR"),
      タカセ("A123", Usrbun.TAK, "000", false, "M1301 TAK");
      private final String input;
      private final Usrbun usrbun;
      private final String txt;
      private final boolean exp;
      private final String expKeyfld;
      public JokenEntity getEntity() {
        return JokenEntity.builder().txt(txt).build();
      }
    }

    @ParameterizedTest
    @EnumSource
    void test(Param parm) {
      final ArgumentCaptor<JokenEntity> captor = ArgumentCaptor.forClass(JokenEntity.class);
      when(jokenMapper.selectWithoutLogicalDelete(captor.capture())).thenReturn(parm.getEntity());
      boolean result = target.isUsableBshcod(parm.input, "", parm.usrbun);
      assertAll("結果と適切なキーで取得したかどうか確認",
          () -> assertThat(result).isEqualTo(parm.exp),
          () -> assertThat(captor.getValue().getKeyfld()).isEqualTo(parm.expKeyfld));
    }
  }

  @Nested
  class getNextKadoDte {
    @RequiredArgsConstructor
    enum Param {
      うるう年("20240228", 20240229, 20240328, "3") {
        public List<JdsCalendarEntity> getEntityList() {
          List<JdsCalendarEntity> ret = new ArrayList<>();
          for (int i = 0; i < 10; i++) {
            JdsCalendarEntity entity = JdsCalendarEntity.builder().dte8kt(i).kaddtekbn("1").build();
            if (i == 3) {
              entity = entity.toBuilder().kaddtekbn("0").build();
            }
            ret.add(entity);
          }
          return ret;
        }
      },
      通常年("20230228", 20230301, 20230328, "9") {
        public List<JdsCalendarEntity> getEntityList() {
          List<JdsCalendarEntity> ret = new ArrayList<>();
          for (int i = 0; i < 10; i++) {
            JdsCalendarEntity entity = JdsCalendarEntity.builder().dte8kt(i).kaddtekbn("1").build();
            if (i == 9) {
              entity = entity.toBuilder().kaddtekbn("0").build();
            }
            ret.add(entity);
          }
          return ret;
        }
      },
      範囲内に稼働日無し("20240229", 20240301, 20240329, null) {
        public List<JdsCalendarEntity> getEntityList() {
          List<JdsCalendarEntity> ret = new ArrayList<>();
          for (int i = 0; i < 10; i++) {
            JdsCalendarEntity entity = JdsCalendarEntity.builder().dte8kt(i).kaddtekbn("1").build();
            ret.add(entity);
          }
          return ret;
        }
      };

      private final String input;
      private final int expFrmDte;
      private final int expToDte;
      private final String expKadoDte;

      public abstract List<JdsCalendarEntity> getEntityList();
    }

    @ParameterizedTest
    @EnumSource
    void 正常(Param param) {
      final ArgumentCaptor<Integer> captor_from = ArgumentCaptor.forClass(Integer.class);
      final ArgumentCaptor<Integer> captor_to = ArgumentCaptor.forClass(Integer.class);
      when(jdsCalendarMapper.selectListByFromToDate(captor_from.capture(), captor_to.capture()))
          .thenReturn(param.getEntityList());
      String result = target.getNextKadoDte(param.input);
      assertAll("結果と検索日付範囲を確認",
          () -> assertThat(result).isEqualTo(param.expKadoDte),
          () -> assertThat(captor_from.getValue()).isEqualTo(param.expFrmDte),
          () -> assertThat(captor_to.getValue()).isEqualTo(param.expToDte));
    }

    @Test
    void 日付範囲外() {
      Throwable ex = assertThrows(RuntimeException.class, () -> target.getNextKadoDte("20230229"));

      assertThat(ex.getClass()).isEqualTo(DateTimeParseException.class);
    }
  }
}
