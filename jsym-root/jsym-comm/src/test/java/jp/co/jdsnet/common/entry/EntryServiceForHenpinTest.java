package jp.co.jdsnet.common.entry;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import jp.co.jdsnet.common.domain.entity.henpin.HenpinShijiMeisaiEntity;
import jp.co.jdsnet.common.domain.entity.henpin.HenpinShijiMidashiEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity;
import jp.co.jdsnet.common.domain.entity.syseve.TargetEntity;
import jp.co.jdsnet.common.domain.mapper.henpin.HenpinShijiMeisaiMapper;
import jp.co.jdsnet.common.domain.mapper.henpin.HenpinShijiMidashiMapper;
import lombok.RequiredArgsConstructor;

@SpringBootTest(classes = EntryService.class)
public class EntryServiceForHenpinTest {

  @InjectMocks
  private EntryServiceForHenpin target;

  @Mock
  private HenpinShijiMidashiMapper henpinShijiMidashiMapper;
  @Mock
  private HenpinShijiMeisaiMapper henpinShijiMeisaiMapper;

  @RequiredArgsConstructor
  enum Param {
    CASE1_NOMAL(240101, "C400", 123456, "240101C400123456"), // 全項目最大桁
    CASE2_DATE3KT(101, "C400", 123456, "000101C400123456"), // 日付６桁未満
    CASE2_BSH3KT(240101, "C40", 123456, "240101C40 123456"), // 場所４桁未満
    CASE2_SEQ3KT(240101, "C400", 123, "240101C400000123"); // SEQ６桁未満

    private final int inpdte;
    private final String bshcod;
    private final int seq;
    private final String exp;
  }

  @ParameterizedTest
  @EnumSource
  void 返品指示見出生成(Param param) throws Exception {
    HenpinShijiMidashiEntity entity =
        HenpinShijiMidashiEntity.builder().inpdte(param.inpdte).bshcod(param.bshcod).build();
    Method method = EntryServiceForHenpin.class.getDeclaredMethod("createHnpsjimdsid",
        HenpinShijiMidashiEntity.class, int.class);
    method.setAccessible(true);
    String result = (String) method.invoke(target, entity, param.seq);

    assertAll("結果確認", () -> assertEquals(param.exp, result, "一致"));
  }

  @Test
  void entryTest() throws Exception {
    final ArgumentCaptor<HenpinShijiMidashiEntity> cap_shijimidashi = ArgumentCaptor.forClass(HenpinShijiMidashiEntity.class);
    final ArgumentCaptor<HenpinShijiMeisaiEntity> cap_shijimeisai = ArgumentCaptor.forClass(HenpinShijiMeisaiEntity.class);

    EventEntity eventEntity = EventEntity.builder().prctrn("trn").gmnid("aaa").svcid("bbb").build();
    
    when(henpinShijiMidashiMapper.getNextSeq(Mockito.anyInt(), Mockito.anyString())).thenReturn(10);
    doNothing().when(henpinShijiMidashiMapper).insert(cap_shijimidashi.capture());
    doNothing().doNothing().when(henpinShijiMeisaiMapper).insert(cap_shijimeisai.capture());

    LocalDateTime ldt = LocalDateTime.of(2024, 3, 1, 12, 0, 0);
    try (MockedStatic<LocalDateTime> mockldt = Mockito.mockStatic(LocalDateTime.class)) {
      mockldt.when(() -> LocalDateTime.now()).thenReturn(ldt);
      TargetEntity result = target.entry(eventEntity, getInputMidashi());
      assertAll(() -> assertEquals(getExpTarget().toString(), result.toString(), "ターゲットの不一致"),
          () -> assertEquals(getExpMidashi().toString(), cap_shijimidashi.getValue().toString(),
              "返品指示見出の不一致"),
          () -> assertEquals(getExpMeisaiList().get(0).toString(),
              cap_shijimeisai.getAllValues().get(0).toString(), "返品指示明細１の不一致"),
          () -> assertEquals(getExpMeisaiList().get(1).toString(),
              cap_shijimeisai.getAllValues().get(1).toString(), "返品指示明細２の不一致"));
    }

  }

  private HenpinShijiMidashiEntity getInputMidashi() {
    return HenpinShijiMidashiEntity.builder().inpdte(240301).bshcod("bsh").daikaiskbcod("daikai")
        .tokcod("000123456").trncod("260").hpnjurdte(240302).hpnutkbng("123456").knrkbn("00")
        .kinhjikbn("1").smtcod("2").skrkrt(1).tokdenbng1("12345678").tokdenbng2("987654")
        .locbng("loc").odrno("123456").hpnsur(3).hpnkin(3).mscod("ms").fmg1("fmg1").fmg2("fmg2")
        .msisuu(2).hpntsyukeflg("0").suksgn("1").cpufulid("cpu").wsseq4kt(0).prckruflg("0")
        .delflg("0").errariflg("0").stakjyzflg("0").tmukjyzflg("0").stasteflg("0").tmusteflg("0")
        .meisaiList(getInputMeisaiList()).build();
  }

  private HenpinShijiMidashiEntity getExpMidashi() {
    return getInputMidashi().toBuilder().hpnsjimdsid("240301bsh 000010").seq(10).updkbn("A ")
        .upddte(240301).updjkk(120000).build();
  }

  private List<HenpinShijiMeisaiEntity> getInputMeisaiList() {
    List<HenpinShijiMeisaiEntity> meisaiList = new ArrayList<>();
    meisaiList.add(HenpinShijiMeisaiEntity.builder().kigbng("kigbng1").seq(1).hpnsur(1).skrtan(1)
        .hpnkin(1).rmcod("rm1").errariflg("1").tankinstekbn("1").build());
    meisaiList.add(HenpinShijiMeisaiEntity.builder().kigbng("kigbng2").seq(2).hpnsur(2).skrtan(2)
        .hpnkin(2).rmcod("rm2").errariflg("2").tankinstekbn("2").build());

    return meisaiList;
  }

  @SuppressWarnings("unchecked")
  private List<HenpinShijiMeisaiEntity> getExpMeisaiList() {
    return (List<HenpinShijiMeisaiEntity>) getInputMeisaiList().stream().map(t -> {
      return t.toBuilder().hpnsjimdsid("240301bsh 000010").updkbn("A ").upddte(240301)
          .updjkk(120000).build();
    }).toList();
  }

  private TargetEntity getExpTarget() {
    return TargetEntity.builder().trnfulcod("trn").motsvcid("aaa").saksvcid("bbb")
        .kenkey("240301bsh 000010").tgtstskbn("0").inpdte(240301).inpjkk(120000).updkbn("A ")
        .upddte(240301).updjkk(120000).build();
  }

  
  private enum test {
    TEST("1234567890", "abcdefg"), TEST2("1234567890", "abcdefg"),
    TEST3("1234567890","abcdefg"), TEST4("1234567890", "abcdefg"), 
    TEST5("1234567890", "abcdefg"), TEST6("1234567890", "abcdefg"), 
    TEST7("1234567890", "abcdefg"), TEST8("1234567890","abcdefg"), 
    TEST9("1234567890", "abcdefg"), TEST10("1234567890", "abcdefg");
    private String a;
    private String b;
    test(String a, String b) {
      this.a = a;
      this.b = b;
    }
  }
}
