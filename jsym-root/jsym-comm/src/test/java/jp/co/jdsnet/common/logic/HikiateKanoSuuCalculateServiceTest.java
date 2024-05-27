package jp.co.jdsnet.common.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.DaihyoKaishaJokenEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.TantoTerritoryEntity;
import jp.co.jdsnet.common.domain.entity.zaiko.AzaikoEntity;
import jp.co.jdsnet.common.domain.entity.zaiko.ZaikoKakuhoEntity;
import jp.co.jdsnet.common.domain.mapper.hinban.HinbanMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.DaihyoKaishaJokenMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KakushaTokuisakiMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.TantoTerritoryMapper;
import jp.co.jdsnet.common.domain.mapper.zaiko.AzaikoMapper;
import jp.co.jdsnet.common.domain.mapper.zaiko.ZaikoKakuhoMapper;
import jp.co.jdsnet.common.domain.vo.HikiateKanosuuVo;
import jp.co.jdsnet.common.logic.implement.HikiateKanoSuuCalculateServiceImpl;
import jp.co.jdsnet.common.utils.GlobalConstants.Rmcod;
import jp.co.jdsnet.common.utils.GlobalConstants.Syacod;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;

@SpringBootTest(classes = HikiateKanoSuuCalculateService.class)
public class HikiateKanoSuuCalculateServiceTest {

  @InjectMocks
  HikiateKanoSuuCalculateServiceImpl target;

  @Mock
  AzaikoMapper azaikoMapper;
  @Mock
  DaihyoKaishaJokenMapper daihyoKaishaJokenMapper;
  @Mock
  KakushaTokuisakiMapper kakushaTokuisakiMapper;
  @Mock
  HinbanMapper hinbanMapper;
  @Mock
  TantoTerritoryMapper tantoTerritoryMapper;
  @Mock
  ZaikoKakuhoMapper zaikoKakuhoMapper;
  @Mock
  private MessageSource messageSource;

  @Nested
  class getHatKnoSuuTest {

    @Test
    void 標準() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111","222","333"};
      
      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);
      
      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);
      
      HikiateKanosuuVo result = target.getHatKnoSuu("","",skolist,trncod,rmcod,isMinus);
      assertAll("可能数算出結果検証",
          () -> assertThat(result.getKnosuu("111")).isEqualTo(88_888_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-33_333_333),
          () -> assertThat(result.getKnosuu()).isEqualTo(88_888_888),
          () -> assertThat(result.getKnosuuSum()).isEqualTo(155_555_554));
    }

    @Test
    void 標準_マイナス補正() {
      boolean isMinus = false;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(88_888_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(0));
    }

    @Test
    void 帳残更新有() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      String cyzupdkbn = "Y";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(88_888_899),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-33_333_300));
    }

    @Test
    void 標準_230() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.SHOHIN_URIAGE;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(88_888_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-33_333_333));
    }

    @Test
    void 標準_252() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.TSUJOGAI_URIAGE;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(88_888_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-33_333_333));
    }

    @Test
    void 標準_285() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.YUSHUTSU_URIAGE_PLUS;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(88_888_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-33_333_333));
    }

    @Test
    void 旧判定で条件にあったELSEと同じもの() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.KEIHI_SHUKKO;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(89_988_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-30_033_333));
    }

    @Test
    void 生産仕入返品1() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.SEISAN_HENPIN;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(89_999_988),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-30_000_033));
    }

    @Test
    void 生産仕入返品2() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.SHIIRE_HENPIN_PLUS;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(89_999_988),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-30_000_033));
    }

    @Test
    void 強制() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.KYOSEI;
      Trncod trncod = Trncod.SHIIRE_HENPIN_PLUS;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(99_988_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-33_333));
    }

    @Test
    void 注残無視() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.SHIIRE_HENPIN_PLUS;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.CHUZAN_MUSHI);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(99_988_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-33_333));
    }

    @Test
    void リザーブ() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.RESERVE;
      Trncod trncod = Trncod.TSUJO_URIAGE_PLUS;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(89_998_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-30_003_333));
    }

    @Test
    void 強制リザーブ() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.KYOSEI_RESERVE;
      Trncod trncod = Trncod.TSUJO_URIAGE_PLUS;
      String cyzupdkbn = "";
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken(cyzupdkbn);

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(99_998_888),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(99_999_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(-3_333));
    }

    @Test
    void 代表会社条件無し() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu, Syacod.TSUJO);
      DaihyoKaishaJokenEntity daikaijkn = null;

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);
      when(messageSource.getMessage(Mockito.anyString(), Mockito.any(), Mockito.any(Locale.class)))
          .thenReturn("").thenReturn("");
      final ArgumentCaptor<String> cap = ArgumentCaptor.forClass(String.class);

      Throwable ex = assertThrows(RuntimeException.class,
          () -> target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus));
      assertAll("Exception検証",
          () -> assertThat(ex.getClass()).isEqualTo(NoSuchElementException.class),
          () -> verify(messageSource, times(2)).getMessage(cap.capture(), Mockito.any(),
              Mockito.any(Locale.class)),
          () -> assertThat(cap.getAllValues().get(0)).isEqualTo("arg.table.daihyokaishajoken"),
          () -> assertThat(cap.getAllValues().get(1)).isEqualTo("error.notexist"));
    }

    @Test
    void A在庫無し() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      String skolist[] = {"111", "222", "333"};

      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken("");

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(null).thenReturn(null)
          .thenReturn(null);
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);
      when(messageSource.getMessage(Mockito.anyString(), Mockito.any(), Mockito.any(Locale.class)))
          .thenReturn("").thenReturn("");
      final ArgumentCaptor<String> cap = ArgumentCaptor.forClass(String.class);

      Throwable ex = assertThrows(RuntimeException.class,
          () -> target.getHatKnoSuu("", "", skolist, trncod, rmcod, isMinus));
      assertAll("Exception検証",
          () -> assertThat(ex.getClass()).isEqualTo(NoSuchElementException.class),
          () -> verify(messageSource, times(2)).getMessage(cap.capture(), Mockito.any(),
              Mockito.any(Locale.class)),
          () -> assertThat(cap.getAllValues().get(0)).isEqualTo("arg.table.azaiko"),
          () -> assertThat(cap.getAllValues().get(1)).isEqualTo("error.notexist"));
    }

    private List<AzaikoEntity> createAzaiko(int skosuu, Syacod syacod) {
      int zaisur = 99_999_999;
      int basetomzaiteisurpls = 1;
      int basetomzaiteisurmns = 2;
      int basezmmzaiteisurpls = 10;
      int basezmmzaiteisurmns = 20;
      int basecchkhasur = 100;
      int baseexpkho = 1_000;
      int basezaikhokhasur = 10_000;
      int basechzkhasur = 100_000;
      int baseykesyakhasur = 1_000_000;
      int basesinjuckhasur = 10_000_000;
      int basekigbng = 1111;
      int baseskocod = 111;
      List<AzaikoEntity> ret = new ArrayList<>();
      IntStream.range(1, skosuu + 1).forEach(i -> {
        int minus = (i % 2 == 0) ? -1 : 1; // 偶数は在庫数以外の数量をマイナスにする
        int zaikozero = (i % 3 == 0) ? 0 : 1; // ３の倍数のとき在庫数を０にする
        ret.add(AzaikoEntity.builder().kigbng(String.valueOf(basekigbng * i))
            .skocod(String.valueOf(baseskocod * i)).zaisur(zaisur * zaikozero)
            .tomzaiteisurpls(basetomzaiteisurpls * i * minus)
            .tomzaiteisurmns(basetomzaiteisurmns * i * minus)
            .zmmzaiteisurpls(basezmmzaiteisurpls * i * minus)
            .zmmzaiteisurmns(basezmmzaiteisurmns * i * minus).cchkhasur(basecchkhasur * i * minus)
            .expkho(baseexpkho * i * minus).zaikhokhasur(basezaikhokhasur * i * minus)
            .chzkhasur(basechzkhasur * i * minus).ykesyakhasur(baseykesyakhasur * i * minus)
            .sinjuckhasur(basesinjuckhasur * i * minus).syacod(syacod.getCode()).build());
      });
      return ret;
    }

    private DaihyoKaishaJokenEntity createKaishaJoken(String cyzupdkbn) {
      return DaihyoKaishaJokenEntity.builder().cyzupdkbn(cyzupdkbn).build();
    }
  }


  @Nested
  class getHatKnoSuuWithTokcodTest {
    @Test
    void 標準() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.SHITEINASHI;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      int skosuu = 2;
      String skolist[] = {"111", "222"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken();
      List<ZaikoKakuhoEntity> zaikholist = new ArrayList<>();
      zaikholist.add(createZaikoKakuho(900));
      zaikholist.add(createZaikoKakuho(98));
      List<ZaikoKakuhoEntity> zaikholist2 = new ArrayList<>();
      zaikholist2.add(createZaikoKakuho(1900));
      zaikholist2.add(createZaikoKakuho(102));

      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);
      when(hinbanMapper.select(Mockito.any())).thenReturn(HinbanEntity.builder().build());
      when(tantoTerritoryMapper.select(Mockito.any()))
          .thenReturn(TantoTerritoryEntity.builder().build());
      when(zaikoKakuhoMapper.selectZaikoKakuhoList(Mockito.any(), Mockito.any(), Mockito.any()))
          .thenReturn(zaikholist).thenReturn(zaikholist2);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, "", isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(-1),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(1));
    }

    @Test
    void リザーブ() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.RESERVE;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      int skosuu = 3;
      String skolist[] = {"111", "222", "333"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken();
      List<ZaikoKakuhoEntity> zaikholist = new ArrayList<>();
      zaikholist.add(createZaikoKakuho(900));
      zaikholist.add(createZaikoKakuho(98));
      List<ZaikoKakuhoEntity> zaikholist2 = new ArrayList<>();
      zaikholist2.add(createZaikoKakuho(1900));
      zaikholist2.add(createZaikoKakuho(102));
      List<ZaikoKakuhoEntity> zaikholist3 = new ArrayList<>();
      zaikholist3.add(createZaikoKakuho(2900));
      zaikholist3.add(createZaikoKakuho(101));

      when(kakushaTokuisakiMapper.select(Mockito.any()))
          .thenReturn(KakushaTokuisakiEntity.builder().build());
      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1)).thenReturn(azailist.get(2));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);
      when(hinbanMapper.select(Mockito.any())).thenReturn(HinbanEntity.builder().build());
      when(tantoTerritoryMapper.select(Mockito.any()))
          .thenReturn(TantoTerritoryEntity.builder().eigcod("aaa").build());
      when(zaikoKakuhoMapper.selectZaikoKakuhoList(Mockito.any(), Mockito.any(), Mockito.any()))
          .thenReturn(zaikholist).thenReturn(zaikholist2).thenReturn(zaikholist3);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, "", isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(998),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(1_999),
          () -> assertThat(result.getKnosuu("333")).isEqualTo(3_000));
    }

    @Test
    void 強制リザーブ() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.KYOSEI_RESERVE;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      int skosuu = 2;
      String skolist[] = {"111", "222"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken();
      List<ZaikoKakuhoEntity> zaikholist = new ArrayList<>();
      zaikholist.add(createZaikoKakuho(900));
      zaikholist.add(createZaikoKakuho(98));
      List<ZaikoKakuhoEntity> zaikholist2 = new ArrayList<>();
      zaikholist2.add(createZaikoKakuho(1900));
      zaikholist2.add(createZaikoKakuho(102));

      when(kakushaTokuisakiMapper.select(Mockito.any()))
          .thenReturn(KakushaTokuisakiEntity.builder().build());
      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);
      when(hinbanMapper.select(Mockito.any())).thenReturn(HinbanEntity.builder().build());
      when(tantoTerritoryMapper.select(Mockito.any()))
          .thenReturn(TantoTerritoryEntity.builder().build());
      when(zaikoKakuhoMapper.selectZaikoKakuhoList(Mockito.any(), Mockito.any(), Mockito.any()))
          .thenReturn(zaikholist).thenReturn(zaikholist2);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, "", isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(998),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(1_999));
    }

    @Test
    void リザーブ不良() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.RESERVE_FURYO;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      int skosuu = 2;
      String skolist[] = {"111", "222"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken();
      List<ZaikoKakuhoEntity> zaikholist = new ArrayList<>();
      zaikholist.add(createZaikoKakuho(900));
      zaikholist.add(createZaikoKakuho(98));
      List<ZaikoKakuhoEntity> zaikholist2 = new ArrayList<>();
      zaikholist2.add(createZaikoKakuho(1900));
      zaikholist2.add(createZaikoKakuho(102));

      when(kakushaTokuisakiMapper.select(Mockito.any()))
          .thenReturn(KakushaTokuisakiEntity.builder().build());
      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);
      when(hinbanMapper.select(Mockito.any())).thenReturn(HinbanEntity.builder().build());
      when(tantoTerritoryMapper.select(Mockito.any()))
          .thenReturn(TantoTerritoryEntity.builder().build());
      when(zaikoKakuhoMapper.selectZaikoKakuhoList(Mockito.any(), Mockito.any(), Mockito.any()))
          .thenReturn(zaikholist).thenReturn(zaikholist2);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, "", isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(-1),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(1));
    }

    @Test
    void 担当テリトリーなし_品番テリトリーグループのみなし() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.RESERVE;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      int skosuu = 2;
      String skolist[] = {"111", "222"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken();
      List<ZaikoKakuhoEntity> zaikholist = new ArrayList<>();
      zaikholist.add(createZaikoKakuho(900));
      zaikholist.add(createZaikoKakuho(98));
      List<ZaikoKakuhoEntity> zaikholist2 = new ArrayList<>();
      zaikholist2.add(createZaikoKakuho(1900));
      zaikholist2.add(createZaikoKakuho(102));

      when(kakushaTokuisakiMapper.select(Mockito.any()))
          .thenReturn(KakushaTokuisakiEntity.builder().build());
      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);
      when(hinbanMapper.select(Mockito.any())).thenReturn(HinbanEntity.builder().build());
      when(tantoTerritoryMapper.select(Mockito.any())).thenReturn(null)
          .thenReturn(TantoTerritoryEntity.builder().eigcod("aaa").build());
      when(zaikoKakuhoMapper.selectZaikoKakuhoList(Mockito.any(), Mockito.any(), Mockito.any()))
          .thenReturn(zaikholist).thenReturn(zaikholist2);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, "", isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(998),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(1_999));
    }

    @Test
    void 担当テリトリーなし_全てなし() {
      boolean isMinus = true;
      Rmcod rmcod = Rmcod.RESERVE;
      Trncod trncod = Trncod.TSUJO_URIAGE;
      int skosuu = 2;
      String skolist[] = {"111", "222"};

      List<AzaikoEntity> azailist = createAzaiko(skosuu);
      DaihyoKaishaJokenEntity daikaijkn = createKaishaJoken();
      List<ZaikoKakuhoEntity> zaikholist = new ArrayList<>();
      zaikholist.add(createZaikoKakuho(900));
      zaikholist.add(createZaikoKakuho(98));
      List<ZaikoKakuhoEntity> zaikholist2 = new ArrayList<>();
      zaikholist2.add(createZaikoKakuho(1900));
      zaikholist2.add(createZaikoKakuho(102));

      when(kakushaTokuisakiMapper.select(Mockito.any()))
          .thenReturn(KakushaTokuisakiEntity.builder().build());
      when(azaikoMapper.selectForCalcurateKanosuu(Mockito.any())).thenReturn(azailist.get(0))
          .thenReturn(azailist.get(1));
      when(daihyoKaishaJokenMapper.select(Mockito.any())).thenReturn(daikaijkn);
      when(hinbanMapper.select(Mockito.any())).thenReturn(HinbanEntity.builder().build());
      when(tantoTerritoryMapper.select(Mockito.any())).thenReturn(null).thenReturn(null);
      when(zaikoKakuhoMapper.selectZaikoKakuhoList(Mockito.any(), Mockito.any(), Mockito.any()))
          .thenReturn(zaikholist).thenReturn(zaikholist2);

      HikiateKanosuuVo result = target.getHatKnoSuu("", "", skolist, trncod, rmcod, "", isMinus);
      assertAll("可能数算出結果検証", () -> assertThat(result.getKnosuu("111")).isEqualTo(998),
          () -> assertThat(result.getKnosuu("222")).isEqualTo(1_999));
    }

    private List<AzaikoEntity> createAzaiko(int skosuu) {
      int zaisur = 1_000;
      int basekigbng = 1111;
      int baseskocod = 111;
      List<AzaikoEntity> ret = new ArrayList<>();
      IntStream.range(1, skosuu + 1).forEach(i -> {
        int zaikhokes = (i % 2 == 0) ? -1 : 1;
        ret.add(AzaikoEntity.builder().kigbng(String.valueOf(basekigbng * i))
            .skocod(String.valueOf(baseskocod * i)).zaisur(zaisur * i)
            .zaikhokhasur((zaisur * i) + zaikhokes).build());
      });
      return ret;
    }

    private DaihyoKaishaJokenEntity createKaishaJoken() {
      return DaihyoKaishaJokenEntity.builder().build();
    }

    private ZaikoKakuhoEntity createZaikoKakuho(int zaikhokhasur) {
      return ZaikoKakuhoEntity.builder().zaikhokhasur(zaikhokhasur).build();
    }
  }

}
