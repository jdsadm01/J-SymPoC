package jp.co.jdsnet.infoservice.domain.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.KaishaEntity;
import jp.co.jdsnet.common.domain.mapper.hatchu.HatchuMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaMapper;
import jp.co.jdsnet.common.domain.mapper.soko.ZaikoJokenMapper;
import jp.co.jdsnet.common.domain.mapper.uriagejisseki.EigyoshobetsuHinbanUriageMapper;
import jp.co.jdsnet.common.domain.mapper.zaiko.AZaikoMapper;
import jp.co.jdsnet.common.logic.CheckSharedService;
import jp.co.jdsnet.common.logic.DataGetSharedService;
import jp.co.jdsnet.common.logic.KigbngCheckSharedService;
import jp.co.jdsnet.infoservice.domain.dto.AllStockDTO;
import jp.co.jdsnet.infoservice.domain.service.Implement.AllStockServiceImpl;

@SpringBootTest(classes = AllStockService.class)
public class TestAllStockService {
	
    @InjectMocks
	private AllStockServiceImpl target;

	@Mock
	private KaishaMapper kaishaMapper;
	@Mock
	private EigyoshobetsuHinbanUriageMapper eigyoshobetsuHinbanUriageMapper;
	@Mock
	private HatchuMapper hatchuMapper;
	@Mock
	private AZaikoMapper aZaikoMapper;
	@Mock
	private ZaikoJokenMapper zaikoJokenMapper;

	@Mock
	private CheckSharedService checkSharedService;
	@Mock
	private KigbngCheckSharedService kigbngCheckSharedService;
	@Mock
	private DataGetSharedService dataGetSharedService;
	
    @Nested
	class init {
		@Test
		void 正常() {
			when(checkSharedService.checkServiceTime(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(CheckSharedService.SERVICETIME_ONLINE);
			when(kaishaMapper.selectAll()).thenReturn(createTestDaikaiList());
			
			AllStockDTO result = target.init("", "");
			assertAll("結果確認"
					,() -> assertEquals(true, result.isInServiceTime(), "サービス時間が一致")
					,() -> assertEquals("DAI1", result.getDaikaiskbcodList().get(0), "会社リスト１が一致")
					,() -> assertEquals("DAI2", result.getDaikaiskbcodList().get(1), "会社リスト２が一致")
					,() -> assertEquals("DAI3", result.getDaikaiskbcodList().get(2), "会社リスト３が一致"));
		}
		
		@Test
		void サービス時間外() {
			when(checkSharedService.checkServiceTime(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(CheckSharedService.SERVICETIME_TIMEOUT);
			when(kaishaMapper.selectAll()).thenReturn(createTestDaikaiList());
			
			AllStockDTO result = target.init("", "");
			assertAll("結果確認"
					,() -> assertEquals(false, result.isInServiceTime(), "サービス時間が一致"));
		}
		
		private List<KaishaEntity> createTestDaikaiList() {
			List<KaishaEntity> list = new ArrayList<>();
			list.add(KaishaEntity.builder().kaiskbcod("KAI1").daikaiskbcod("DAI1").build());
			list.add(KaishaEntity.builder().kaiskbcod("KAI2").daikaiskbcod("DAI3").build());
			list.add(KaishaEntity.builder().kaiskbcod("KAI3").daikaiskbcod("DAI2").build());
			list.add(KaishaEntity.builder().kaiskbcod("KAI4").daikaiskbcod("DAI2").build());
			return list;
		}
	}

    @Nested
	class getHinban {
		@Test
		void 正常() throws Exception {
			when(kigbngCheckSharedService.getHinban(Mockito.anyString(), Mockito.anyString())).thenReturn(createTestHinban_new());
			
			Method method = AllStockServiceImpl.class.getDeclaredMethod("getHinban",String.class,String.class);
			method.setAccessible(true);
			HinbanEntity result = (HinbanEntity)method.invoke(target, Mockito.anyString(), Mockito.anyString());
			
			assertAll("結果確認"
					,() -> assertEquals(createTestHinban_new().toString(), result.toString(), "取得した品番が一致"));
		}
		
		@Test
		void 論理削除() throws Exception {
			when(kigbngCheckSharedService.getHinban(Mockito.anyString(), Mockito.anyString())).thenReturn(createTestHinban_logicaldelete());
			//privateメソッド実行のためリフレクションを利用
			Method method = AllStockServiceImpl.class.getDeclaredMethod("getHinban",String.class,String.class);
			method.setAccessible(true);

			Throwable e = assertThrows(Exception.class, () -> { method.invoke(target, Mockito.anyString(), Mockito.anyString()); });
			
			assertAll("結果確認"
					,() -> assertEquals("削除済みです。", e.getMessage(), "例外メッセージが一致"));
		}
		
		@Test
		void データ無し() throws Exception {
			doThrow(new Exception("") {
				private static final long serialVersionUID = 1L;
			}).when(kigbngCheckSharedService).getHinban(Mockito.anyString(), Mockito.anyString());
			//privateメソッド実行のためリフレクションを利用
			Method method = AllStockServiceImpl.class.getDeclaredMethod("getHinban",String.class,String.class);
			method.setAccessible(true);

			Throwable e = assertThrows(Exception.class, () -> { method.invoke(target, Mockito.anyString(), Mockito.anyString()); });
			
			assertAll("結果確認"
					,() -> assertEquals("", e.getMessage(), "例外メッセージが一致"));
		}
		
		private HinbanEntity createTestHinban_new() {
			return HinbanEntity.builder()
					.daikaiskbcod("DAI")
					.kigbng("TEST000000001")
					.updkbn("A")
					.build();
		}
		private HinbanEntity createTestHinban_logicaldelete() {
			return HinbanEntity.builder()
					.daikaiskbcod("DAI")
					.kigbng("TEST000000001")
					.updkbn("D")
					.build();
		}
	}

    @Nested
	class setSykkaStopChzBadByTomRak {
		@Test
		void ランクD() throws Exception {
			Map<String, Boolean> w_warning = new HashMap<>();
			w_warning.put("isChzFka", false);
			w_warning.put("isSyaStop", false);
			
			Method method = AllStockServiceImpl.class.getDeclaredMethod("setSykkaStopChzBadByTomRak",String.class,Map.class);
			method.setAccessible(true);
			method.invoke(target, "D", w_warning);
			
			assertAll("結果確認"
					,() -> assertEquals(true, w_warning.get("isChzFka"), "注残不可判定が一致")
					,() -> assertEquals(false, w_warning.get("isSyaStop"), "出荷STOP判定が一致"));
		}
		@Test
		void ランクE() throws Exception {
			Map<String, Boolean> w_warning = new HashMap<>();
			w_warning.put("isChzFka", false);
			w_warning.put("isSyaStop", false);
			
			Method method = AllStockServiceImpl.class.getDeclaredMethod("setSykkaStopChzBadByTomRak",String.class,Map.class);
			method.setAccessible(true);
			method.invoke(target, "E", w_warning);
			
			assertAll("結果確認"
					,() -> assertEquals(false, w_warning.get("isChzFka"), "注残不可判定が一致")
					,() -> assertEquals(true, w_warning.get("isSyaStop"), "出荷STOP判定が一致"));
		}
		@Test
		void ランクF() throws Exception {
			Map<String, Boolean> w_warning = new HashMap<>();
			w_warning.put("isChzFka", false);
			w_warning.put("isSyaStop", false);
			
			Method method = AllStockServiceImpl.class.getDeclaredMethod("setSykkaStopChzBadByTomRak",String.class,Map.class);
			method.setAccessible(true);
			method.invoke(target, "F", w_warning);
			
			assertAll("結果確認"
					,() -> assertEquals(false, w_warning.get("isChzFka"), "注残不可判定が一致")
					,() -> assertEquals(true, w_warning.get("isSyaStop"), "出荷STOP判定が一致"));
		}
		@Test
		void ランクFF() throws Exception {
			Map<String, Boolean> w_warning = new HashMap<>();
			w_warning.put("isChzFka", false);
			w_warning.put("isSyaStop", false);
			
			Method method = AllStockServiceImpl.class.getDeclaredMethod("setSykkaStopChzBadByTomRak",String.class,Map.class);
			method.setAccessible(true);
			method.invoke(target, "FF", w_warning);
			
			assertAll("結果確認"
					,() -> assertEquals(false, w_warning.get("isChzFka"), "注残不可判定が一致")
					,() -> assertEquals(true, w_warning.get("isSyaStop"), "出荷STOP判定が一致"));
		}
		@Test
		void ランク他() throws Exception {
			Map<String, Boolean> w_warning = new HashMap<>();
			w_warning.put("isChzFka", false);
			w_warning.put("isSyaStop", false);
			
			Method method = AllStockServiceImpl.class.getDeclaredMethod("setSykkaStopChzBadByTomRak",String.class,Map.class);
			method.setAccessible(true);
			method.invoke(target, "A", w_warning);
			
			assertAll("結果確認"
					,() -> assertEquals(false, w_warning.get("isChzFka"), "注残不可判定が一致")
					,() -> assertEquals(false, w_warning.get("isSyaStop"), "出荷STOP判定が一致"));
		}
	}

}
