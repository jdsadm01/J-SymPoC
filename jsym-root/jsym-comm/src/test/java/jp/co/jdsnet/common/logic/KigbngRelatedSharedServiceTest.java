package jp.co.jdsnet.common.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.hinban.ShikiritankaEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.HinbanTokuisakiKakeritsuTankaEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KyotsuTokuisakiEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.ShikirikakeritsuEntity;
import jp.co.jdsnet.common.domain.mapper.hatchu.HatchuMapper;
import jp.co.jdsnet.common.domain.mapper.hinban.HinbanMapper;
import jp.co.jdsnet.common.domain.mapper.hinban.ShikiritankaMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.HinbanTokuisakiKakeritsuTankaMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KakushaTokuisakiMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KyotsuTokuisakiMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.ShikirikakeritsuMapper;
import jp.co.jdsnet.common.logic.implement.KigbngRelatedSharedServiceImpl;
import lombok.RequiredArgsConstructor;

@SpringBootTest(classes = KigbngRelatedSharedService.class)
public class KigbngRelatedSharedServiceTest {
  @InjectMocks
  private KigbngRelatedSharedServiceImpl target;

  @Mock
  private HatchuMapper hatchuMapper;
  @Mock
  private HinbanMapper hinbanMapper;
  @Mock
  private KyotsuTokuisakiMapper kyotsuTokuisakiMapper;
  @Mock
  private KakushaTokuisakiMapper kakushaTokuisakiMapper;
  @Mock
  private ShikirikakeritsuMapper shikirikakeritsuMapper;
  @Mock
  private ShikiritankaMapper shikiritankaMapper;
  @Mock
  private HinbanTokuisakiKakeritsuTankaMapper hinbanTokuisakiKakeritsuTankaMapper;
  @Mock
  private MessageSource messageSource;

  @Nested
  class getNkiHacSuu {
    @RequiredArgsConstructor
    enum Param {
      データ有り(240301, 200, 2), データ無し(null, null, 0);

      private final Integer nki;
      private final Integer nyukoyoteisuu;
      private final int datasize;
    }

    @ParameterizedTest
    @EnumSource
    void test(Param param) throws Exception {
      when(hatchuMapper.getNkiMostRecently(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(param.nki);
      when(hatchuMapper.getNyukoYoteisuu(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt())).thenReturn(param.nyukoyoteisuu);
      Map<String, Integer> result = target.getNkiHacSuu(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
      
      assertAll(() -> assertThat(result.size()).isEqualTo(param.datasize),
          () -> assertThat(result.get("nki")).isEqualTo(param.nki),
          () -> assertThat(result.get("hacsuu")).isEqualTo(param.nyukoyoteisuu));
    }
  }

  @Nested
  class getSkrtan {
    @RequiredArgsConstructor
    enum Test1_Param {
      CASE1_仕切率指定("1", 0.9d, 1000d, 2000d, 3000d, "1", 9d),
      CASE2_仕切単価決定パターン1_一般("0", 0d, 1000d, 2000d, 3000d, "0", 2000d), 
      CASE3_仕切単価決定パターン1_貸レ("0", 0d, 1000d, 2000d, 3000d, "1", 3000d), 
      CASE4_仕切単価決定パターン2("1", 0d, 1000d, 2000d, 3000d, "1", 500d), 
      CASE5_仕切単価決定パターン3("2", 0d, 1000d, 2000d, 3000d, "1", 4000d),
      ;

      private final String skrtanktikbn;
      private final double skrkrt;
      private final double znupri;
      private final double skrtanipn;
      private final double skrtankre;
      private final String krerntkbn;
      private final double expskrtan;

      public HinbanEntity getHinbanEntity() {
        return HinbanEntity.builder().znupri(this.znupri).skrtanktikbn(this.skrtanktikbn)
            .skrtanipn(this.skrtanipn).skrtankre(this.skrtankre).build();
      }

      public KyotsuTokuisakiEntity getKyotsuTokuisakiEntity() {
        return KyotsuTokuisakiEntity.builder().krerntkbn(this.krerntkbn).build();
      }

      public KakushaTokuisakiEntity getKakushaTokuisakiEntity() {
        return KakushaTokuisakiEntity.builder().hsuchskbn("9").build();
      }

      public ShikirikakeritsuEntity getShikirikakeritsuEntity() {
        return ShikirikakeritsuEntity.builder().skrkrt(50d).build();
      }

      public ShikiritankaEntity getShikiritankaEntity() {
        return ShikiritankaEntity.builder().skrtan(4000d).build();
      }

    }

    @ParameterizedTest
    @EnumSource
    void Test1_正常終了_各決定パターンのテスト(Test1_Param param) throws Exception {
      when(hinbanMapper.select(Mockito.any())).thenReturn(param.getHinbanEntity());
      when(kyotsuTokuisakiMapper.select(Mockito.any())).thenReturn(param.getKyotsuTokuisakiEntity());
      when(kakushaTokuisakiMapper.select(Mockito.any())).thenReturn(param.getKakushaTokuisakiEntity());
      when(shikirikakeritsuMapper.select(Mockito.any())).thenReturn(param.getShikirikakeritsuEntity());
      when(shikiritankaMapper.select(Mockito.any())).thenReturn(param.getShikiritankaEntity());
      
      double result = target.getSkrtan("AAA", "TEST000000001", "AAB", param.skrkrt);
      assertThat(result).isEqualTo(param.expskrtan);
    }
    
    @RequiredArgsConstructor
    enum Test2_Param {
      CASE1_1_端数調整_0_切捨て("0", 1011.4d, 1011d), 
      CASE1_2_端数調整_0_切上げ("0", 1011.5d, 1012d), 
      CASE2_端数調整_1("1", 1011.9d, 1011d), 
      CASE3_端数調整_2("2", 1011.1d, 1012d), 
      CASE4_1_端数調整_3_切捨て("3", 1014.5d, 1010d), 
      CASE4_2_端数調整_3_切上げ("3", 1015.4d, 1020d), 
      CASE5_端数調整_4("4", 1019.1d, 1010d), 
      CASE6_端数調整_5("5", 1011.9d, 1020d), 
      CASE7_端数調整_9("9", 1011.999d, 1011.99d),
      ;
      private final String hsuchskbn;
      private final double skrtanipn;
      private final double expskrtan;

      public HinbanEntity getHinbanEntity() {
        return HinbanEntity.builder().skrtanktikbn("0").skrtanipn(this.skrtanipn).build();
      }

      public KyotsuTokuisakiEntity getKyotsuTokuisakiEntity() {
        return KyotsuTokuisakiEntity.builder().krerntkbn("0").build();
      }

      public KakushaTokuisakiEntity getKakushaTokuisakiEntity() {
        return KakushaTokuisakiEntity.builder().hsuchskbn(this.hsuchskbn).build();
      }
    }
    @ParameterizedTest
    @EnumSource
    void Test2_端数調整テスト(Test2_Param param) throws Exception {
      when(hinbanMapper.select(Mockito.any())).thenReturn(param.getHinbanEntity());
      when(kyotsuTokuisakiMapper.select(Mockito.any())).thenReturn(param.getKyotsuTokuisakiEntity());
      when(kakushaTokuisakiMapper.select(Mockito.any())).thenReturn(param.getKakushaTokuisakiEntity());
      
      double result = target.getSkrtan("AAA", "TEST000000001", "AAB", 0d);
      assertThat(result).isEqualTo(param.expskrtan);
    }
    

    @RequiredArgsConstructor
    enum Test3_Param {
      CASE1_仕切率指定("1", 90d, 80d, 2000d, 70d, 3000d, 900d),
      CASE2_マスタ登録無("1", 0d, 80d, 2000d, 70d, 3000d, 1500d) {
        @Override
        public HinbanTokuisakiKakeritsuTankaEntity getHinTokKakeTanTok() {
          return null;
        }
        @Override
        public HinbanTokuisakiKakeritsuTankaEntity getHinTokKakeTanSyy() {
          return null;
        }
      }, 
      CASE3_集約店登録("1", 0d, 80d, 2000d, 70d, 3000d, 3000d) {
        @Override
        public HinbanTokuisakiKakeritsuTankaEntity getHinTokKakeTanTok() {
          return null;
        }
      }, 
      CASE4_区分仕切掛率指定("0", 0d, 80d, 2000d, 70d, 3000d, 800d),
      CASE5_区分単価指定("1", 0d, 80d, 2000.9d, 70d, 3000d, 2000d),
      ;

      private final String krttankbn;
      private final double steskrkrt;
      private final double skrkrt1;
      private final double skrtan1;
      private final double skrkrt2;
      private final double skrtan2;
      private final double expskrtan;

      public HinbanTokuisakiKakeritsuTankaEntity getHinTokKakeTanTok() {
        return HinbanTokuisakiKakeritsuTankaEntity.builder().krttankbn(this.krttankbn).skrkrt(this.skrkrt1).skrtan(this.skrtan1).build();
      }
      public HinbanTokuisakiKakeritsuTankaEntity getHinTokKakeTanSyy() {
        return HinbanTokuisakiKakeritsuTankaEntity.builder().krttankbn(this.krttankbn).skrkrt(this.skrkrt2).skrtan(this.skrtan2).build();
      }
      public HinbanEntity getHinbanEntity() {
        return HinbanEntity.builder().skrtanktikbn("0").znupri(1000d).skrtanipn(1500d).build();
      }

      public KyotsuTokuisakiEntity getKyotsuTokuisakiEntity() {
        return KyotsuTokuisakiEntity.builder().krerntkbn("0").build();
      }

      public KakushaTokuisakiEntity getKakushaTokuisakiEntity() {
        return KakushaTokuisakiEntity.builder().hsuchskbn("9").build();
      }
    }

    @ParameterizedTest
    @EnumSource
    void PCHロジックテスト(Test3_Param param) throws Exception {
      when(hinbanTokuisakiKakeritsuTankaMapper.selectKrtTan(Mockito.any(), Mockito.anyInt())).thenReturn(param.getHinTokKakeTanTok()).thenReturn(param.getHinTokKakeTanSyy());
      when(hinbanMapper.select(Mockito.any())).thenReturn(param.getHinbanEntity());
      when(kyotsuTokuisakiMapper.select(Mockito.any())).thenReturn(param.getKyotsuTokuisakiEntity());
      when(kakushaTokuisakiMapper.select(Mockito.any())).thenReturn(param.getKakushaTokuisakiEntity());

      double result = target.getSkrtan("PCH", "TEST000000001", "AAB", param.steskrkrt);
      assertThat(result).isEqualTo(param.expskrtan);
    }

    @RequiredArgsConstructor
    enum Test4_Param {
      CASE1_PCH区分設定不備("PCH", 0d, "0", IllegalArgumentException.class, 
          List.of("arg.skrtankti", "error.errors")), 
      CASE2_品番無し("AAA", 0d, "0", NoSuchElementException.class, 
          List.of("kigbng", "error.errors")) {
        @Override
        public HinbanEntity getHinbanEntity() {
          return null;
        }
      },
      CASE3_共通得意先無し("AAA", 0d, "0", NoSuchElementException.class,
          List.of("tokcod", "error.errors")) {
        @Override
        public KyotsuTokuisakiEntity getKyotsuTokuisakiEntity() {
          return null;
        }
      },
      CASE4_各社得意先無し("AAA", 0d, "0", NoSuchElementException.class,
          List.of("arg.kaikyy", "error.errors")) {
        @Override
        public KakushaTokuisakiEntity getKakushaTokuisakiEntity() {
          return null;
        }
      },
      CASE5_仕切単価決定区分設定不備("AAA", 0d, "A", IllegalArgumentException.class,
          List.of("arg.skrtankti", "error.errors")), 
      CASE6_1_仕切掛率マスタ無し("AAA", 0d, "1", NoSuchElementException.class, 
          List.of("arg.skrtankti", "error.errors")) {
        @Override
        public ShikirikakeritsuEntity getShikirikakeritsuEntity() {
          return null;
        }
      },
      CASE6_2_仕切掛率マスタ無し("AAA", 0d, "2", NoSuchElementException.class,
          List.of("arg.skrtankti", "error.errors")) {
        @Override
        public ShikirikakeritsuEntity getShikirikakeritsuEntity() {
          return null;
        }
      },
      CASE7_仕切単価マスタ無し("AAA", 0d, "2", NoSuchElementException.class,
          List.of("arg.skrtankti", "error.errors")) {
        @Override
        public ShikiritankaEntity getShikiritankaEntity() {
          return null;
        }
      },
      CASE8_1_算出結果が単価0("AAA", 80d, "0", ArithmeticException.class,
          List.of("arg.skrtankti", "error.errors")), 
      CASE8_2_算出結果が単価0("AAA", 0d, "0", ArithmeticException.class,
          List.of("arg.skrtankti", "error.errors")), 
      CASE8_3_算出結果が単価0("AAA", 0d, "1", ArithmeticException.class,
          List.of("arg.skrtankti", "error.errors")), 
      CASE8_4_算出結果が単価0("AAA", 0d, "2", ArithmeticException.class, 
          List.of("arg.skrtankti", "error.errors")),
      ;

      private final String daikaiskbcod;
      private final double skrkrt;
      private final String skrtanktikbn;
      private final Class<?> exception;
      private final List<String> msgkeys;

      public HinbanTokuisakiKakeritsuTankaEntity getHinTokKakeTan() {
        return HinbanTokuisakiKakeritsuTankaEntity.builder().krttankbn("").build();
      }
      public HinbanEntity getHinbanEntity() {
        return HinbanEntity.builder().skrtanktikbn(this.skrtanktikbn).build();
      }
      public KyotsuTokuisakiEntity getKyotsuTokuisakiEntity() {
        return KyotsuTokuisakiEntity.builder().krerntkbn("0").build();
      }
      public KakushaTokuisakiEntity getKakushaTokuisakiEntity() {
        return KakushaTokuisakiEntity.builder().hsuchskbn("9").build();
      }
      public ShikirikakeritsuEntity getShikirikakeritsuEntity() {
        return ShikirikakeritsuEntity.builder().skrkrt(50d).build();
      }
      public ShikiritankaEntity getShikiritankaEntity() {
        return ShikiritankaEntity.builder().build();
      }
    }

    @ParameterizedTest
    @EnumSource
    void 異常終了テスト(Test4_Param param) throws Exception {
      final ArgumentCaptor<String> cap = ArgumentCaptor.forClass(String.class);
      when(hinbanTokuisakiKakeritsuTankaMapper.selectKrtTan(Mockito.any(), Mockito.anyInt())).thenReturn(param.getHinTokKakeTan());
      when(hinbanMapper.select(Mockito.any())).thenReturn(param.getHinbanEntity());
      when(kyotsuTokuisakiMapper.select(Mockito.any())).thenReturn(param.getKyotsuTokuisakiEntity());
      when(kakushaTokuisakiMapper.select(Mockito.any())).thenReturn(param.getKakushaTokuisakiEntity());
      when(shikirikakeritsuMapper.select(Mockito.any())).thenReturn(param.getShikirikakeritsuEntity());
      when(shikiritankaMapper.select(Mockito.any())).thenReturn(param.getShikiritankaEntity());
      when(messageSource.getMessage(Mockito.anyString(), Mockito.any(), Mockito.any(Locale.class))).thenReturn("").thenReturn("");

      Throwable ex = assertThrows(Exception.class,
          () -> target.getSkrtan(param.daikaiskbcod, "TEST000000001", "AAB", param.skrkrt));
      assertAll("Exception検証",
          () -> assertThat(ex.getClass()).isEqualTo(param.exception),
          () -> verify(messageSource, times(2)).getMessage(cap.capture(), Mockito.any(),
              Mockito.any(Locale.class)),
          () -> assertThat(cap.getAllValues().get(0)).isEqualTo(param.msgkeys.get(0)),
          () -> assertThat(cap.getAllValues().get(1)).isEqualTo(param.msgkeys.get(1)));
    }
  }

}
