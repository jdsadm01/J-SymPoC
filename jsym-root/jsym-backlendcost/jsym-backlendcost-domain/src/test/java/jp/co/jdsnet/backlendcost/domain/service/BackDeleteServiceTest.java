package jp.co.jdsnet.backlendcost.domain.service;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
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
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDetailDTO;
import jp.co.jdsnet.backlendcost.domain.service.implement.BackDeleteServiceImpl;
import jp.co.jdsnet.base.webapp.parts.LabelData;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.common.domain.entity.chuzan.ChuzanEntity;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;
import jp.co.jdsnet.common.domain.mapper.chuzan.ChuzanMapper;
import jp.co.jdsnet.common.domain.vo.TokuisakiAndDsVO;
import jp.co.jdsnet.common.logic.CheckSharedService;
import jp.co.jdsnet.common.logic.DataGetSharedService;
import jp.co.jdsnet.common.logic.KigbngCheckSharedService;

@SpringBootTest(classes = BackDeleteService.class)
public class BackDeleteServiceTest {

  @InjectMocks
  private BackDeleteServiceImpl target;

  @Mock
  private CheckSharedService checkSharedService;

  @Mock
  private KigbngCheckSharedService kigbngCheckSharedService;

  @Mock
  private DataGetSharedService dataGetSharedService;

  @Mock
  private ChuzanMapper chuzanMapper;

  @Mock
  private TokuisakiAndDsVO tokuisakiAndDsVo;

  @Mock
  private KakushaTokuisakiEntity kakushaTokuisakiEntity;


  @Nested
  class init {

    @Test
    void サービス時間内() {

      when(checkSharedService.checkServiceTime(Mockito.anyString(), Mockito.anyString(),
          Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
              .thenReturn(CheckSharedService.SERVICETIME_ONLINE);

      BackDeleteDTO result = target.init("", "");

      assertAll("結果確認", () -> assertEquals(false, result.isInServiceTime(), "サービス時間が一致"));
    }
  }
  /** 検索=============================================================== */
  @Nested
  class search {

    /** 注残件数が101以上であれば次100件ボタンを表示させる */
    @Test
    void 次100件ボタン() throws Exception {

      // ↓検索したDTOを返してもらう Searchメソッドを動かす
      when(target.search(testDTO())).thenReturn(getNext100Flg());

      Method method = BackDeleteServiceImpl.class.getMethod("search", BackDeleteDTO.class);
      method.setAccessible(true);

      BackDeleteDTO resultDTO =
          (BackDeleteDTO) method.invoke(target, testDTO(), 0, Mockito.anyString());

      // resultDTO
      assertAll("結果確認", () -> assertEquals(getNext100Flg().isNextFlg(), resultDTO.isNextFlg(),
          "trueが返却されました。次100件を表示させます"));
    }

    private BackDeleteDTO getNext100Flg() {
      return BackDeleteDTO.builder().nextFlg(true).build();
    }
  }

  /** 注残データ取得=============================================================== */
  @Nested
  class getChuzanData {

    /** 受注日TOが999999に補正されるかチェック */
    @Test
    void 受注日TOの補正() throws Exception {

      int jucdteTo = 999999;
      BackDeleteDTO testDtoDtehosei = testDTO().toBuilder().jucdtefrom("220101").build();

      when(target.getChuzanData(testDtoDtehosei, 0, Mockito.anyString())).thenReturn(getJucDteTo());

      Method method = BackDeleteServiceImpl.class.getMethod("getChuzanData", BackDeleteDTO.class,
          int.class, String.class);
      method.setAccessible(true);

      BackDeleteDTO resultDTO =
          (BackDeleteDTO) method.invoke(target, testDTO(), 0, Mockito.anyString());

      assertAll("結果確認", () -> assertEquals(jucdteTo, resultDTO.getJucdteto(), "受注日Toは999999が自動入力"));
    }

    private BackDeleteDTO getJucDteTo() {
      return BackDeleteDTO.builder().jucdteto("999999").build();
    }

    /** 注残カウント数0 */
    @Test
    void ゼロ件() throws Exception {

      int souteichi = 0;
      int yosochi = 0;

      when(chuzanMapper.selectCount(Mockito.any())).thenReturn(souteichi);

      Method method = BackDeleteServiceImpl.class.getMethod("getChuzanData", BackDeleteDTO.class,
          int.class, String.class);
      // method.setAccessible(true);

      // 引数 dto pageNo pageKey;
      BackDeleteDTO resultDTO =
          (BackDeleteDTO) method.invoke(target, testDTO(), 0, Mockito.anyString());

      assertAll("結果確認", () -> assertEquals(yosochi, resultDTO.getChzCnt(), "0件"));

    }

    /** 注残カウント数10000 */
    @Test
    void 一万件超え() throws Exception {

      int souteichi = 10000;
      int yosochi = 10000;

      when(chuzanMapper.selectCount(Mockito.any())).thenReturn(souteichi);

      Method method = BackDeleteServiceImpl.class.getMethod("getChuzanData", BackDeleteDTO.class,
          int.class, String.class);
      // method.setAccessible(true);

      BackDeleteDTO resultDTO =
          (BackDeleteDTO) method.invoke(target, testDTO(), 0, Mockito.anyString());

      assertAll("結果確認", () -> assertEquals(yosochi, resultDTO.getChzCnt(), "0件"));
    }

    /** 記号番号が取得できたか */
    @Test
    void 記号番号を取得する() throws Exception {
      when(kigbngCheckSharedService.getHinban(Mockito.anyString(), Mockito.anyString()))
          .thenReturn(getHinban());

      Method method =
          BackDeleteServiceImpl.class.getDeclaredMethod("getHinban", String.class, String.class);
      method.setAccessible(true);
      HinbanEntity result =
          (HinbanEntity) method.invoke(target, Mockito.anyString(), Mockito.anyString());

      assertAll("結果確認", () -> assertEquals(getHinban().toString(), result.toString(), "品番が取得できた"));
    }

    private HinbanEntity getHinban() {
      return HinbanEntity.builder().daikaiskbcod("ADI").kigbng("AVCD000011670").build();
    }


    /** 注残削除区分追加処理 */
    // 注残情報を取得する
    // 取得した注残削除日付
    @Test
    void 注残区分を振り分ける() throws Exception {
      when(chuzanMapper.select(inputChuzanData())).thenReturn(dummyChuzanDataList());

      Method method =
          BackDeleteServiceImpl.class.getMethod("getChuzanData", String.class, String.class);
      // method.setAccessible(true);
      BackDeleteDTO dto = BackDeleteDTO.builder().kaiskbcod("ADI").tokcod("00039371").build();

      BackDeleteDTO result = target.getChuzanData(dto, 0, "");

      assertAll("結果確認",
          () -> assertEquals("E", result.getDetailList().get(0).getChzdelKbn(), "区分E"));

    }

    /** 100行目を取得できたらページキーをセットするテスト */
    @Test
    void ページキーセット() throws Exception {
      when(chuzanMapper.select(Mockito.any())).thenReturn(dummyChuzanDataList100());

      Method method = BackDeleteServiceImpl.class.getMethod("getChuzanData", BackDeleteDTO.class,
          int.class, String.class);
      // method.setAccessible(true);

      BackDeleteDTO resultDTO =
          (BackDeleteDTO) method.invoke(target, testDTO(), 0, Mockito.anyString());

      assertAll("結果確認",
          () -> assertEquals(getPagekey(), resultDTO.getDetailList().get(99).getChzdeldte()
              + resultDTO.getDetailList().get(99).getTokcod(), "区分E"));
    }

    private List<ChuzanEntity> dummyChuzanDataList() {
      List<ChuzanEntity> list = new ArrayList<>();
      list.add(
          ChuzanEntity.builder().kaiskbcod("KAI1").tokcod("00000001").chzdeldte(200201).build());
      list.add(
          ChuzanEntity.builder().kaiskbcod("KAI1").tokcod("00000002").chzdeldte(200202).build());
      list.add(
          ChuzanEntity.builder().kaiskbcod("KAI1").tokcod("00000003").chzdeldte(200203).build());
      list.add(
          ChuzanEntity.builder().kaiskbcod("KAI1").tokcod("00000004").chzdeldte(200204).build());

      return list;
    }

    private String getPagekey() {
      List<ChuzanEntity> list100 = dummyChuzanDataList100();

      return String.valueOf(list100.get(99).getChzdeldte())
          + String.valueOf(list100.get(99).getTokcod());

    }

    private List<ChuzanEntity> dummyChuzanDataList100() {
      List<ChuzanEntity> list = new ArrayList<>();
      int u = 1;
      for (int i = 0; i < 100; i++) {

        if (i < 10) {
          list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000000" + i)
              .chzdeldte(200300 + u).build());
        } else {
          list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("0000000" + i)
              .chzdeldte(200300 + u).build());
        }
        if (u == 30) {
          u = u + 71;
        }

      }

      return list;
    }

  }
  /** 次100件=============================================================== */
  @Nested
  class next100Search {

    /** 削除チェックマーク数チェック */
    @Test
    void 削除チェックが存在するか() throws Exception {
      when(target.next100Search(testDTO(), 0, Mockito.anyString())).thenReturn(existChk());

      Method method = BackDeleteServiceImpl.class.getDeclaredMethod("next100Search",
          BackDeleteDTO.class, int.class, String.class);

      BackDeleteDTO resultDTO =
          (BackDeleteDTO) method.invoke(target, testDTO(), 0, Mockito.anyString());

      long checkcnt =
          resultDTO.getDetailList().stream().filter(t -> "1".equals(t.getDeletechk())).count();

      assertAll("結果確認", () -> assertEquals(2, checkcnt, "チェックは2個"));

    }



    private BackDeleteDTO existChk() {

      List<BackDeleteDetailDTO> detailDTOChk = new ArrayList<>();
      detailDTOChk.add(BackDeleteDetailDTO.builder().deletechk("1").build());
      detailDTOChk.add(BackDeleteDetailDTO.builder().deletechk("1").build());
      detailDTOChk.add(BackDeleteDetailDTO.builder().deletechk("0").build());

      return BackDeleteDTO.builder().detailList(detailDTOChk).build();

    }

  }


  // Entityセット======================================================================================
  public ChuzanEntity inputChuzanData() {

    return ChuzanEntity.builder().kaiskbcod("ADI").daikaiskbcod("ADI").pageKey(Mockito.anyString())
        .skocod(Mockito.anyString()).mkrbuncod(Mockito.anyString()).kigbng(Mockito.anyString())
        .tokcod(Mockito.anyString()).dscod(Mockito.anyString()).eigcod(Mockito.anyString())
        .tercod(Mockito.anyString()).jucdtefrom(Mockito.anyInt()).jucdteto(Mockito.anyInt())
        .hbidtefrom(Mockito.anyInt()).hbidteto(Mockito.anyInt()).tokkbn(Mockito.anyString())
        .usrDaikaiskbcod(Mockito.anyString()).usrKaiskbcod(Mockito.anyString()).build();

  }

  // DTOセット======================================================================================
  public BackDeleteDTO testDTO() {
    List<String> testList1 = new ArrayList<String>();
    List<LabelData> testListTok = new ArrayList<LabelData>();
    List<LabelData> testListUpd = new ArrayList<LabelData>();
    Map<Integer, String> testChkBox = new HashMap<Integer, String>();
    List<BackDeleteDetailDTO> detailList = new ArrayList<>();
    List<BackDeleteDetailDTO> testList6 = new ArrayList<BackDeleteDetailDTO>();
    Map<String, String> testRadiotok = new HashMap<String, String>();

    detailList.add(BackDeleteDetailDTO.builder().skocod("011").build());

    UserInfoVO userVo = UserInfoVO.builder().usrid("").usrnm("").daikaiskbcod("JDS")
        .kaiskbcod("ADI").usrbun("").bshcod("").mnugrpcod("").cpuid("").tmlid("")
        .lastAccessTime(LocalDateTime.now()).build();

    return BackDeleteDTO.builder().userInfo(userVo).kaiskbcod("ADI").mkrbuncod("A").skocod("")
        .kigbng("").tokcod("").dscod("").eigcod("").tercod("").updkbn("S").jucdtefrom("")
        .jucdteto("").hbidtefrom("").hbidteto("").titnm("").artnm("").toknm("").tokkbn("1").dsnm("")
        .chzCnt(0).chzsurTotal(0).allDeletechk("").detailBottomList(testList1)
        .tokkbnList(testListTok).updkbnList(testListUpd).checkBoxDelete(testChkBox)
        .detailList(detailList).deleteList(testList6).pageKeyPrev("").pageKeyNow("").pageKeyNext("")
        .pageNo(0).prevFlg(false).nextFlg(false).nextGamenMode("").radioTokcod(testRadiotok)
        .build();
  }



}
