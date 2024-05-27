package jp.co.jdsnet.common.entry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import jp.co.jdsnet.common.domain.entity.juchu.JuchuMeisaiEntity;
import jp.co.jdsnet.common.domain.entity.juchu.JuchuMidashiEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity;
import jp.co.jdsnet.common.domain.entity.syseve.TargetEntity;
import jp.co.jdsnet.common.domain.mapper.juchu.JuchuMeisaiMapper;
import jp.co.jdsnet.common.domain.mapper.juchu.JuchuMidashiMapper;

@SpringBootTest(classes = EntryService.class)
public class EntryServiceForJuchuTest {
  @InjectMocks
  private EntryServiceForJuchu target;

  @Mock
  private JuchuMidashiMapper juchuMidashiMapper;
  @Mock
  private JuchuMeisaiMapper juchuMeisaiMapper;


  @Nested
  class entry {

    @Test
    void test() throws Exception {
      final ArgumentCaptor<JuchuMidashiEntity> cap_midashi =
          ArgumentCaptor.forClass(JuchuMidashiEntity.class);
      EventEntity eventEntity =
          EventEntity.builder().prctrn("trn").gmnid("aaa").svcid("bbb").build();
      when(
          juchuMidashiMapper.getNextSeq(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString()))
              .thenReturn(2);
      JuchuMidashiEntity midashi =
          JuchuMidashiEntity.builder().meisaiList(new ArrayList<JuchuMeisaiEntity>()).build();
      doThrow(DuplicateKeyException.class).doThrow(DuplicateKeyException.class).doNothing()
          .when(juchuMidashiMapper).insert(cap_midashi.capture());

      TargetEntity result = target.entry(eventEntity, midashi);
      assertAll("カウントアップしてるかな", () -> assertThat(cap_midashi.getValue().getSeq()).isEqualTo(4));

    }

    private JuchuMidashiEntity getParameter() {
      return JuchuMidashiEntity.builder()
          //引数セット項目
          .jucdte(0).tokcod(null).dscod(null).jucjkk(0).trnfulcod(null).thcbng(null).rmcod(null).sjcod(null)
          .ykncod(null).mscod(null).fmg1(null).fmg2(null).tankinhjiflg(null).skrkrtsteflg(null).skrkrt(0)
          .etcsyaknrkbn(null).smtcod(null).kdakbn(null).ssaytedte(0).mkrstesyadte(0).mtddte(0).mtdbng(null)
          .cpufulid(null).wsseq7kt(0).jsndte8kt(0).jsnjkk9kt(0).juckbn(null).stasteflg(null)
          .kehsyoknrno(null).zeikbn(null).smpsgn(null).kehsyofkesakcod(null).kamcod(null)
          .kehsyoniy(null).kehsyofkeno(null).kehsyotyo(null).meisaiList(null).build();
    }

    private JuchuMidashiEntity getExpMidashi() {
      return getParameter().toBuilder()
          // 固定項目
          .jucstskbn(null).inpchkerrkbn(null).ykesyaflg(null).ykesyakjyzflg(null).stakjyzflg(null)
          .delflg(null).errariflg(null).dengprossnzflgski(null).tmukjyzflg(null).build();
    }
  }
}
