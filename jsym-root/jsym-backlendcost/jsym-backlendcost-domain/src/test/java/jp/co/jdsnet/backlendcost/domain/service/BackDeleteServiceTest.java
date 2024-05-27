// package jp.co.jdsnet.backlendcost.domain.service;
//
//
// import static org.junit.jupiter.api.Assertions.assertAll;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.when;
// import java.lang.reflect.Method;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import org.junit.jupiter.api.Nested;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.springframework.boot.test.context.SpringBootTest;
// import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
// import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDetailDTO;
// import jp.co.jdsnet.backlendcost.domain.service.implement.BackDeleteServiceImpl;
// import jp.co.jdsnet.base.webapp.parts.LabelData;
// import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
// import jp.co.jdsnet.common.domain.entity.chuzan.ChuzanEntity;
// import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
// import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;
// import jp.co.jdsnet.common.domain.mapper.chuzan.ChuzanMapper;
// import jp.co.jdsnet.common.domain.vo.TokuisakiAndDsVO;
// import jp.co.jdsnet.common.logic.CommonCheckSharedService;
// import jp.co.jdsnet.common.logic.KaishaRelatedSharedService;
// import jp.co.jdsnet.common.logic.KigbngRelatedSharedService;
//
// @SpringBootTest(classes = BackDeleteService.class)
// public class BackDeleteServiceTest {
//
// @InjectMocks
// private BackDeleteServiceImpl target;
//
// @Mock
// private CommonCheckSharedService checkSharedService;
//
// @Mock
// private KigbngRelatedSharedService kigbngCheckSharedService;
//
// @Mock
// private KaishaRelatedSharedService dataGetSharedService;
//
// @Mock
// private ChuzanMapper chuzanMapper;
//
// @Mock
// private TokuisakiAndDsVO tokuisakiAndDsVo;
//
// @Mock
// private KakushaTokuisakiEntity kakushaTokuisakiEntity;
//
// // TODO 分岐の網羅＝条件それぞれに対してのtrueとfalseの両パターンを行う
//
// @Nested
// class init {
//
// @Test
// void サービス時間内() {
//
// when(checkSharedService.checkServiceTime(Mockito.anyString(), Mockito.anyString(),
// Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
// .thenReturn(CommonCheckSharedService.SERVICETIME_ONLINE);
//
// BackDeleteDTO result = target.init("", "");
//
// assertAll("結果確認", () -> assertEquals(false, result.isInServiceTime(), "サービス時間が一致"));
// }
// }
//
// /** 検索=============================================================== */
// @Nested
// class search {
//
// @Test
// void 注残件数が101以上であれば次100件ボタンを表示させる() throws Exception {
// int countSouteichi = 101;
// int chzsurSouteichi = 101;
// when(chuzanMapper.selectCount(Mockito.any())).thenReturn(countSouteichi);
// when(chuzanMapper.selectTotalchzSur(Mockito.any())).thenReturn(chzsurSouteichi);
// when(chuzanMapper.select(Mockito.any())).thenReturn(dummyChuzanDataList101());
// // when(target.getChuzanData(testDTO(), 0, Mockito.anyString())).thenReturn(dummyDto());
// // TODO コメントアウトしてる方でモックするべき
//
// BackDeleteDTO resultDTO = target.search(testDTO());
//
// assertAll("結果確認",
// () -> assertEquals(true, resultDTO.isNextFlg(), "trueが返却されました。次100件を表示させます"));
// }
//
// // private BackDeleteDTO dummyDto() {
// // return BackDeleteDTO.builder().chzCnt(101).pageNo(0).build();
// // }
//
// }
//
// /** 注残データ取得=============================================================== */
// // TODO テストが足りない。
// @Nested
// class getChuzanData {
//
// @Test
// void ゼロ件() throws Exception {
//
// int souteichi = 0;
// int yosochi = 0;
//
// when(chuzanMapper.selectCount(Mockito.any())).thenReturn(souteichi);
//
// Method method = BackDeleteServiceImpl.class.getMethod("getChuzanData", BackDeleteDTO.class,
// int.class, String.class);
//
// // 引数 dto pageNo pageKey;
// BackDeleteDTO resultDTO =
// (BackDeleteDTO) method.invoke(target, testDTO(), 0, Mockito.anyString());
//
// assertAll("結果確認", () -> assertEquals(yosochi, resultDTO.getChzCnt(), "0件"));
//
// }
//
// @Test
// void 一万件超え() throws Exception {
//
// int souteichi = 10000;
// int yosochi = 10000;
//
// when(chuzanMapper.selectCount(Mockito.any())).thenReturn(souteichi);
//
// Method method = BackDeleteServiceImpl.class.getMethod("getChuzanData", BackDeleteDTO.class,
// int.class, String.class);
//
// BackDeleteDTO resultDTO =
// (BackDeleteDTO) method.invoke(target, testDTO(), 0, Mockito.anyString());
//
// assertAll("結果確認", () -> assertEquals(yosochi, resultDTO.getChzCnt(), "10000件"));
// }
//
// // TODO 違うメソッドのテストが混ざっている
// @Test
// void 記号番号を取得する() throws Exception {
// when(kigbngCheckSharedService.getHinban(Mockito.anyString(), Mockito.anyString()))
// .thenReturn(getHinban());
//
// Method method =
// BackDeleteServiceImpl.class.getDeclaredMethod("getHinban", String.class, String.class);
// method.setAccessible(true);
// HinbanEntity result =
// (HinbanEntity) method.invoke(target, Mockito.anyString(), Mockito.anyString());
//
// assertAll("結果確認", () -> assertEquals(getHinban().toString(), result.toString(), "品番が取得できた"));
// }
//
// private HinbanEntity getHinban() {
// return HinbanEntity.builder().daikaiskbcod("ADI").kigbng("AVCD000011670").build();
// }
//
//
// // TODO モックが足りない 品番の取得でexceptionが発生している
// @Test
// void データ取得時のチェック() throws Exception {
// // テスト1:削除区分
// // テスト2:ページキーのセット
// int countSouteichi = 101;
// int chzsurSouteichi = 101;
// when(chuzanMapper.selectCount(Mockito.any())).thenReturn(countSouteichi);
// when(chuzanMapper.selectTotalchzSur(Mockito.any())).thenReturn(chzsurSouteichi);
// when(chuzanMapper.select(Mockito.any())).thenReturn(dummyChuzanDataList101());
//
// BackDeleteDTO resultDTO = target.getChuzanData(testDTO(), 0, "");
//
// assertAll("結果確認",
// () -> assertEquals("E", resultDTO.getDetailList().get(1).getChzdelKbn(), "削除区分Eで一致"),
// () -> assertEquals("N", resultDTO.getDetailList().get(2).getChzdelKbn(), "削除区分Nで一致"),
// () -> assertEquals(getPagekey(), resultDTO.getPageKeyNext(), "ページキーセット完了"));
// }
//
// private String getPagekey() {
// return "200202. 200222. 8222282000000000009900000099099";
// }
//
// }
//
// /** 次100件=============================================================== */
// // TODO テストが足りない
// @Nested
// class next100Search {
//
// @Test
// void チェックされている行がある場合遷移しない() throws Exception {
// // エラーメッセージを実装していないのでページキーが上書きされるかどうかで判定する
// // チェックがある場合は注残データを取得しない(キーが変更されない)ので第3引数がそのまま返却される
//
// // int countSouteichi = 101;
// // int chzsurSouteichi = 101;
// // when(chuzanMapper.selectCount(Mockito.any())).thenReturn(countSouteichi);
// // when(chuzanMapper.selectTotalchzSur(Mockito.any())).thenReturn(chzsurSouteichi);
// // when(chuzanMapper.select(Mockito.any())).thenReturn(dummyChuzanDataList101());
//
// BackDeleteDTO resultDTO = target.next100Search(testDTO(), 1, testDTO().getPageKeyNext());
//
// assertAll("結果確認", () -> assertEquals("DUMMYKEY", resultDTO.getPageKeyNext(), "チェックあり"));
//
// }
//
// }
//
// /** 削除対象チェック=============================================================== */
// // TODO テストが足りない
// @Nested
// class chkInputDeleteData {
//
// @Test
// void チェック0なら送信前画面に遷移しない() throws Exception {
// // モック対象なし
//
// BackDeleteDTO resultDTO = target.chkInputDeleteData(inputData());
//
// assertAll("結果確認",
// () -> assertEquals("", resultDTO.getNextGamenMode(), "チェックされている行がないので遷移しません"));
// // 削除対象があるとブランクではなくsubmitが返却
// }
//
// private BackDeleteDTO inputData() {
//
// List<BackDeleteDetailDTO> detailDTOChk = new ArrayList<>();
// detailDTOChk.add(BackDeleteDetailDTO.builder().deletechk("0").build());
// detailDTOChk.add(BackDeleteDetailDTO.builder().deletechk("0").build());
// detailDTOChk.add(BackDeleteDetailDTO.builder().deletechk("0").build());
// // detailDTOChk.add(BackDeleteDetailDTO.builder().deletechk("1").build());
//
// return BackDeleteDTO.builder().detailList(detailDTOChk).build();
// }
//
// }
//
//
// /** Entityセット ======================================================================== */
// public ChuzanEntity inputChuzanData() {
//
// return ChuzanEntity.builder().kaiskbcod("ADI").daikaiskbcod("ADI").pageKey(Mockito.anyString())
// .skocod(Mockito.anyString()).mkrbuncod(Mockito.anyString()).kigbng(Mockito.anyString())
// .tokcod(Mockito.anyString()).dscod(Mockito.anyString()).eigcod(Mockito.anyString())
// .tercod(Mockito.anyString()).jucdtefrom(Mockito.anyInt()).jucdteto(Mockito.anyInt())
// .hbidtefrom(Mockito.anyInt()).hbidteto(Mockito.anyInt()).tokkbn(Mockito.anyString())
// .usrDaikaiskbcod(Mockito.anyString()).usrKaiskbcod(Mockito.anyString()).build();
//
// }
//
// /** DTOセット ======================================================================== */
// public BackDeleteDTO testDTO() {
// List<String> testList1 = new ArrayList<String>();
// List<LabelData> testListTok = new ArrayList<LabelData>();
// List<LabelData> testListUpd = new ArrayList<LabelData>();
// Map<Integer, String> testChkBox = new HashMap<Integer, String>();
// List<BackDeleteDetailDTO> detailList = new ArrayList<>();
// List<BackDeleteDetailDTO> testList6 = new ArrayList<BackDeleteDetailDTO>();
// Map<String, String> testRadiotok = new HashMap<String, String>();
//
// detailList.add(BackDeleteDetailDTO.builder().skocod("011").build());
// detailList.add(BackDeleteDetailDTO.builder().skocod("011").deletechk("1").build());//
// next100で削除チェックする
//
// UserInfoVO userVo = UserInfoVO.builder().usrid("").usrnm("").daikaiskbcod("JDS")
// .kaiskbcod("ADI").usrbun("").bshcod("").mnugrpcod("").cpuid("").tmlid("")
// .lastAccessTime(LocalDateTime.now()).build();
//
// return BackDeleteDTO.builder().userInfo(userVo).kaiskbcod("ADI").mkrbuncod("A").skocod("")
// .kigbng("").tokcod("").dscod("").eigcod("").tercod("").updkbn("S").jucdtefrom("200101")
// .jucdteto("").hbidtefrom("").hbidteto("").titnm("").artnm("").toknm("").tokkbn("1").dsnm("")
// .chzCnt(0).chzsurTotal(0).allDeletechk("").detailBottomList(testList1)
// .tokkbnList(testListTok).updkbnList(testListUpd).checkBoxDelete(testChkBox)
// .detailList(detailList).deleteList(testList6).pageKeyPrev("").pageKeyNow("")
// .pageKeyNext("DUMMYKEY")
// .pageNo(0).prevFlg(false).nextFlg(false).nextGamenMode("").radioTokcod(testRadiotok)
// .build();
// }
//
// /** 101件のダミー検索結果 ======================================================================== */
// public List<ChuzanEntity> dummyChuzanDataList101() {
// List<ChuzanEntity> list = new ArrayList<>();
// // int t = 1; // 日付カウント
// // int u = 1; // 日付代入用数値
// // for (int i = 0; i < 101; i++) {
// //
// // if (i < 10) {
// // list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000000" + i)
// // .chzdeldte(200300 + u)
// // .build());
// // } else {
// // list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("0000000" + i)
// // .chzdeldte(200300 + u).build());
// // }
// //
// // t++;
// // u++;
// //
// // if (t == 30) {
// // u = u + 71;
// // t = 1;
// // }
// //
// // }
//
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000000").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000001").chzdeldte(200301)
// .chzdelkjndte(200228).build());// 基準日付2/28 注残区分B
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000002").chzdeldte(200301)
// .chzdelkjndte(200302).rmcod("B").build());// リマークB 注残区分N
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000003").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000004").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000005").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000006").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000007").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000008").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000009").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000010").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000011").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000012").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000013").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000014").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000015").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000016").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000017").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000018").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000019").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000020").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000021").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000022").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000023").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000024").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000025").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000026").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000027").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000028").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000029").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000030").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000031").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000032").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000033").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000034").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000035").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000036").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000037").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000038").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000039").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000040").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000041").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000042").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000043").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000044").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000045").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000046").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000047").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000048").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000049").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000050").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000051").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000052").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000053").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000054").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000055").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000056").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000057").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000058").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000059").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000060").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000061").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000062").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000063").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000064").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000065").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000066").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000067").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000068").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000069").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000070").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000071").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000072").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000073").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000074").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000075").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000076").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000077").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000078").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000079").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000080").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000081").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000082").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000083").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000084").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000085").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000086").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000087").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000088").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000089").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000090").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000091").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000092").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000093").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000094").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000095").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000096").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000097").chzdeldte(200301)
// .chzdelkjndte(200302).build());
// list.add(
// ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000098").chzdeldte(200301).chzdte(200101)
// .chzjkk(200111).chzrelno(81111).eigcod("81").kigbng("0000000000098").dscod("098")// 99明細目
// .chzdelkjndte(200302).build());
// list.add(
// ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000099").chzdeldte(200301).chzdte(200202)
// .chzjkk(200222).chzrelno(82222).eigcod("82").kigbng("0000000000099").dscod("099")// 100明細目
// .chzdelkjndte(200302).build());
// list.add(
// ChuzanEntity.builder().kaiskbcod("KAI").tokcod("00000100").chzdeldte(200301).chzdte(200303)
// .chzjkk(200333).chzrelno(83333).eigcod("83").kigbng("0000000000100").dscod("100")// 101明細目
// .chzdelkjndte(200302).build());
//
// return list;
// }
//
//
//
// }
