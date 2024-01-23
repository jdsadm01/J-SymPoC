package jp.co.jdsnet.backlendcost.domain.service.implement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDetailDTO;
import jp.co.jdsnet.backlendcost.domain.service.BackDeleteService;
import jp.co.jdsnet.base.webapp.parts.LabelData;
import jp.co.jdsnet.common.domain.entity.chuzan.ChuzanEntity;
import jp.co.jdsnet.common.domain.entity.chuzan.GeneratedChuzanEntity;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.KaishaEntity;
import jp.co.jdsnet.common.domain.mapper.chuzan.ChuzanMapper;
import jp.co.jdsnet.common.domain.vo.TokuisakiAndDsVO;
import jp.co.jdsnet.common.logic.CheckSharedService;
import jp.co.jdsnet.common.logic.DataGetSharedService;
import jp.co.jdsnet.common.logic.KigbngCheckSharedService;
import jp.co.jdsnet.common.utils.StringUtility;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BackDeleteServiceImpl implements BackDeleteService {

  private final CheckSharedService checkSharedService;
  private final KigbngCheckSharedService kigbngCheckSharedService;
  private final DataGetSharedService dataGetSharedService;
  private final ChuzanMapper chuzanMapper;
  private final String SHUYAKUTENMODE = "2";
  private String FLG_ON = "1";

  /**
   * 画面OPEN時の処理
   */
  public BackDeleteDTO init(String daikaiskbcod, String usrbun) {

    boolean isOnline = false;
    if (CheckSharedService.SERVICETIME_ONLINE
        .equals(checkSharedService.checkServiceTime(daikaiskbcod, usrbun, "VAJ008", "001", "O"))) {
      isOnline = true;
    }


    // 項目の初期化
    return BackDeleteDTO.builder().kaiskbcod(daikaiskbcod).updkbnList(createUpdkbnList())
        .pageKeyNext("")
        .radioTokcod(initRadioTokcod()).build();
  }

  /**
   * 検索条件入力チェック処理
   */
  public BackDeleteDTO search(BackDeleteDTO dto) throws Exception {

    String usrbun = "";
    String daikaiskbcod = "";
    boolean errflg = false;

    // サービス時間チェック
    boolean isOnline = false;
    if (CheckSharedService.SERVICETIME_ONLINE
        .equals(checkSharedService.checkServiceTime(daikaiskbcod, usrbun, "VHJ002", "001", "O"))) {
      isOnline = true;
    }

    // 権限チェック

    // この時点でエラー発生している場合処理終了
    // return dto;

    // ===バリデータチェック===

    // ===↓整合性チェック===

    // 会社チェック
    KaishaEntity kaishaEntity;
    if (usrbun.equals("JDS") || usrbun.equals("TAK") || usrbun.equals("JAR")) {
      // 共通処理・会社整合性チェック
      // 存在しない場合エラー
    }

    // 倉庫チェック
    if (!StringUtils.isBlank(dto.getSkocod())) {
      // 共通処理・倉庫整合性チェック
      // 存在しない場合エラー
    }

    // 記号番号チェック
    if (!StringUtils.isBlank(dto.getKigbng())) {
      // 共通処理・品番変換
      // 存在しない場合エラー
    }

    // 営業所チェック
    if (!StringUtils.isBlank(dto.getEigcod())) {
      // 共通処理・営業所整合性チェック
      // 存在しない場合エラー
    }

    // 得意先チェック
    if (!StringUtils.isBlank(dto.getTokcod())) {
      // 共通処理・得意先&DS整合性チェック
      // 存在しない場合エラー
    }

    // 受注日チェック
    // ※yyMMdd型チェックはバリデータチェックで行う
    if ((!StringUtils.isBlank(String.valueOf(dto.getJucdtefrom()))
        && !StringUtils.isBlank(String.valueOf(dto.getJucdteto()))
        && Integer.valueOf(dto.getJucdtefrom()) > Integer.valueOf(dto.getJucdteto()))) {
      // Fromのほうが未来日付の場合エラー
    }

    // 発売日チェック
    // ※yyMMdd型チェックはバリデータチェックで行う
    if ((!StringUtils.isBlank(String.valueOf(dto.getHbidtefrom()))
        && !StringUtils.isBlank(String.valueOf(dto.getHbidteto())))
        && Integer.valueOf(dto.getHbidtefrom()) > Integer.valueOf(dto.getHbidteto())) {
      // Fromのほうが未来日付の場合エラー
    }

    // ===↑整合性チェック===
    // エラーがあったらここで帰る
    if (errflg) {

      return dto;
    }

    String titnm = "";
    String artnm = "";
    String hjihnb = "";
    String tomrakcod = "";
    String hbidte = "";
    String toknm = "";
    String dsnm = "";

    // 品番情報取得
    // if (!StringUtils.isBlank(dto.getKigbng())) {
    // HinbanEntity hinbanEntity = getHinban(dto.getKaiskbcod(), dto.getKigbng());
    // // List<HinbanEntity> hinbanList = HinbanMapper.select
    // titnm = hinbanEntity.getTitnm();
    // artnm = hinbanEntity.getArtnm();
    // hjihnb = hinbanEntity.getHjihnb();
    // tomrakcod = hinbanEntity.getTomrakcod();
    // hbidte = String.valueOf(hinbanEntity.getHbidte());
    // }


    // 得意先情報取得
    if (!StringUtils.isBlank(dto.getTokcod())) {
      TokuisakiAndDsVO tokuisakiAndDsVO = dataGetSharedService
          .getKyotsuAndKakushaTokuisakiData(dto.getKaiskbcod(), dto.getTokcod());

      toknm = tokuisakiAndDsVO.getKyotsuTokuisaki().getToknm1()
          + tokuisakiAndDsVO.getKyotsuTokuisaki().getToknm2();
      dsnm = tokuisakiAndDsVO.getDs().getDsnm1()
          + tokuisakiAndDsVO.getDs().getDsnm2();
    }

    // 注残データ取得※別メソッド
    dto = getChuzanData(dto, 0, "");

    boolean prevflg = false; // 前100件ボタン表示
    boolean nextflg = false; // 次100件ボタン表示

    if (0 != dto.getPageNo()) {
      prevflg = true;
    }
    if (0 < dto.getChzCnt() - (dto.getPageNo() + 1) * 100) {
      nextflg = true;
    }

    // 検索処理終了 controllerに戻る
    return dto.toBuilder()
        .titnm(titnm).artnm(artnm).toknm(toknm).dsnm(dsnm).chzCnt(dto.getChzCnt())
        .chzsurTotal(dto.getChzsurTotal()).prevFlg(prevflg).nextFlg(nextflg)
        .updkbnList(createUpdkbnList()).radioTokcod(initRadioTokcod())
        .detailList(dto.getDetailList()).detailBottomList(dto.getDetailBottomList())
        .checkBoxDelete(getCheckBoxDelete(1))
        .build();

  }

  /**
   * 注残データ取得処理
   */
  public BackDeleteDTO getChuzanData(BackDeleteDTO dto, int pageNo, String pageKey) {

    BackDeleteDetailDTO detailDto = null;

    // 前100、次100の場合のページキー


    int jucdtefrom = 0;
    int jucdteto = 0;
    int hbidtefrom = 0;
    int hbidteto = 0;

    // intの項目
    if (!StringUtils.isBlank(dto.getJucdtefrom())) {
      jucdtefrom = Integer.valueOf(dto.getJucdtefrom());
      if (StringUtils.isBlank(dto.getJucdteto())) {
        jucdteto = 999999;
      }
    }
    if (!StringUtils.isBlank(dto.getJucdteto())) {
      jucdteto = Integer.valueOf(dto.getJucdteto());
      if (StringUtils.isBlank(dto.getJucdteto())) {
        jucdtefrom = 0;
      }
    }
    if (!StringUtils.isBlank(dto.getHbidtefrom())) {
      hbidtefrom = Integer.valueOf(dto.getHbidtefrom());
      if (StringUtils.isBlank(dto.getHbidteto())) {
        hbidteto = 999999;
      }
    }
    if (!StringUtils.isBlank(dto.getHbidteto())) {
      hbidteto = Integer.valueOf(dto.getHbidteto());
      if (StringUtils.isBlank(dto.getHbidtefrom())) {
        hbidtefrom = 0;
      }
    }

    ChuzanEntity input = ChuzanEntity.builder().kaiskbcod(dto.getKaiskbcod().toUpperCase())
        .daikaiskbcod(dto.getKaiskbcod().toUpperCase()).pageKey(pageKey).skocod(dto.getSkocod())
        .mkrbuncod(dto.getMkrbuncod().toUpperCase()).kigbng(dto.getKigbng())
        .tokcod(dto.getTokcod()).dscod(dto.getDscod()).eigcod(dto.getEigcod())
        .tercod(dto.getTercod()).jucdtefrom(jucdtefrom).jucdteto(jucdteto).hbidtefrom(hbidtefrom)
        .hbidteto(hbidteto).tokkbn(dto.getTokkbn())
        .usrDaikaiskbcod(dto.getUserInfo().getDaikaiskbcod())
        .usrKaiskbcod(dto.getUserInfo().getKaiskbcod()).build();

    // 1.注残データの"件数"を取得する
    int chuzanDataCnt = chuzanMapper.selectCount(input);

    if (chuzanDataCnt == 0) {
      // 0件エラー
      // errors.notExistData
      return BackDeleteDTO.builder().build();
    } else if (chuzanDataCnt >= 10000) {
      // 件数上限突破エラー
      // errors.exceed.reinput
      return BackDeleteDTO.builder().build();
    }

    // 注残数の合計を取得する
    int chuzanTotalchzSur = chuzanMapper.selectTotalchzSur(input);

    // 注残データを取得する
    List<ChuzanEntity> chuzanEntityList = chuzanMapper.select(input);

    // 3.代表会社設定(品番検索で必要)
    String inputkaiskbcod = dto.getUserInfo().getDaikaiskbcod(); // ユーザー代表会社
    if (dto.getKaiskbcod().equals(dto.getUserInfo().getKaiskbcod())
        && "MKR".equals(dto.getUserInfo().getUsrbun())) {

      inputkaiskbcod = dto.getKaiskbcod();
    }

    // 4.追加情報設定、リストに追加していく
    List<BackDeleteDetailDTO> detailDTO = new ArrayList<>();
    List<String> lastDataList = new ArrayList<>();// 100件目保持する用リスト

    // 明細Noを設定
    AtomicInteger meiNo = new AtomicInteger(0);

    meiNo.addAndGet(pageNo * 100);

    // ===================ここからstreamスタート
    chuzanEntityList.stream().forEach(t -> {

      // 2のリストに品番、得意先、注残削除区分を追加してリストを更新する。
      String addchzdelkbn = "";
      HinbanEntity hinbanEntity = null;
      TokuisakiAndDsVO tokuisakiAndDsVO = null;
      try {
        // 品番情報取得
        if (!StringUtils.isBlank(t.getKigbng())) {
          hinbanEntity = getHinban(dto.getKaiskbcod().toUpperCase(), t.getKigbng());
          // 記号番号取得
        }

        // 得意先情報取得
        if (!StringUtils.isBlank(t.getTokcod())) {
          tokuisakiAndDsVO = dataGetSharedService
              .getKyotsuAndKakushaTokuisakiData(dto.getKaiskbcod().toUpperCase(), t.getTokcod());
          // 得意先情報取得
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      // 取得したレコードで比較。注残削除日区分を追加する
      if (t.getChzdeldte() > t.getChzdelkjndte()) {
        addchzdelkbn = "E";
      } else if ("B".equals(t.getRmcod())) {
        addchzdelkbn = "N";
      } else {
        addchzdelkbn = "";
      }

      String hjihnb = "";
      String tomrakcod = "";
      String hbidte = "";
      String toknm = "";

      if (Objects.nonNull(hinbanEntity)) {
        hjihnb = hinbanEntity.getHjihnb();
        tomrakcod = hinbanEntity.getTomrakcod();
        hbidte = String.valueOf(hinbanEntity.getHbidte());
      }

      if (Objects.nonNull(tokuisakiAndDsVO)) {
        toknm = tokuisakiAndDsVO.getKyotsuTokuisaki().getToknm1()
            + tokuisakiAndDsVO.getKyotsuTokuisaki().getToknm2();
      }

      // 取得した注残データを格納
      detailDTO.add(BackDeleteDetailDTO.builder().no(meiNo.incrementAndGet())// 明細No
          .skocod(t.getChzskocod()).kigbng(t.getKigbng()).hjihnb(hjihnb) // 実際には追加品番情報から取得
          .chzsur(t.getChzsur()).tomrakcod(tomrakcod) // 実際には追加品番情報から取得
          .hbidte(hbidte) // 実際には追加品番情報から取得
          .usnjndte(String.valueOf(t.getChzdte())).urisyytencod(t.getUrisyytencod())
          .tokcod(t.getTokcod()).dscod(t.getDscod())
          .toknm(toknm) // 実際には追加得意先情報から取得
          .jucdte(String.valueOf(t.getJucdte()))
          .chzdeldte(String.valueOf(t.getJucdte())).chzdelKbn(addchzdelkbn)
          .jucmdsseq(t.getJucmdsseq())
          .jucmeiseq(t.getJucmsiseq()).seq(t.getSeq()).build());

    });
    // ===================streamおわり

    // 5.100件目は別で保持
    pageKey = "";
    chuzanEntityList.stream().skip(99).limit(1).forEach(t -> {

      lastDataList.add(String.valueOf(t.getChzdte()));
      lastDataList.add(String.valueOf(t.getChzjkk()));
      lastDataList.add(String.valueOf(t.getChzrelno()));
      lastDataList.add(t.getEigcod());
      lastDataList.add(t.getKigbng());
      lastDataList.add(t.getTokcod());
      lastDataList.add(t.getDscod());

    });

    if (0 != lastDataList.size()) {
      pageKey = getKey(lastDataList);
    }

    // 注残の取得データと100件目の明細を返却
    return BackDeleteDTO.builder().kaiskbcod(dto.getKaiskbcod()).mkrbuncod(dto.getMkrbuncod())
        .skocod(dto.getSkocod()).kigbng(dto.getKigbng()).tokcod(dto.getTokcod())
        .chzCnt(chuzanDataCnt).chzsurTotal(chuzanTotalchzSur)
        .dscod(dto.getDscod()).eigcod(dto.getEigcod()).tercod(dto.getTercod())
        .updkbn(dto.getUpdkbn()).jucdtefrom(dto.getJucdtefrom()).jucdteto(dto.getJucdteto())
        .hbidtefrom(dto.getHbidtefrom()).hbidteto(dto.getHbidteto())
        .updkbnList(createUpdkbnList()).radioTokcod(initRadioTokcod()).detailList(detailDTO)
        .pageNo(pageNo)
        .pageKeyPrev(dto.getPageKeyPrev()).pageKeyNow(dto.getPageKeyNow()).pageKeyNext(pageKey)
        .build();

  }
  
  private String getKey(List<String> lastDataList
      ) {

    return
        getNumKey(lastDataList.get(0), 6) + ". " + getNumKey(lastDataList.get(1), 6) + ". "
        + getNumKey(lastDataList.get(2), 5)
        + StringUtils.truncate(lastDataList.get(3), 2, " ")
        + StringUtils.truncate(lastDataList.get(4), 13, " ")
        + StringUtils.truncate(lastDataList.get(5), 8, " ")
            + StringUtils.truncate(lastDataList.get(6), 3, " ");
  }
  
  /**
   * 前次100件処理
   */
  public BackDeleteDTO next100Search(BackDeleteDTO dto, int pageNo, String key) throws Exception {

    boolean prevflg = false; // 前100件ボタン表示
    boolean nextflg = false; // 次100件ボタン表示

    // 削除チェック個数
    // ※ここの都合でlong型
    long delcnt = dto.getDetailList().stream().filter(t -> FLG_ON.equals(t.getDeletechk())).count();

    // 一括削除にチェックされている場合は更新あり、明細行すべてにチェックをいれる
    if (FLG_ON.equals(dto.getAllDeletechk())) {
      delcnt = (long) dto.getDetailList().size();;
    }

    if (0 != delcnt) {

      if (0 != pageNo - 1) {
        prevflg = true;
      }
      if (0 < dto.getChzCnt() - (pageNo) * 100) {
        nextflg = true;
      }

      // チェックされている明細があるので次のページに進めません
      return dto.toBuilder().prevFlg(prevflg).nextFlg(nextflg).radioTokcod(initRadioTokcod())
          .build();
    }

    // 以下検索処理と同じ
    BackDeleteDTO newdto;

    // 注残データ取得※別メソッド
    newdto = getChuzanData(dto, pageNo, key);


    if (0 != pageNo) {
      prevflg = true;
    }
    if (0 < newdto.getChzCnt() - (pageNo + 1) * 100) {
      nextflg = true;
    }

    // 検索処理終了 controllerに戻る
    return newdto.toBuilder().prevFlg(prevflg).nextFlg(nextflg)
        .radioTokcod(initRadioTokcod()).detailList(newdto.getDetailList())
        .checkBoxDelete(getCheckBoxDelete(dto.getDetailList().size()))
        .detailBottomList(newdto.getDetailBottomList()).build();

  }


  /**
   * 削除入力チェック処理
   */
  public BackDeleteDTO chkInputDeleteData(BackDeleteDTO dto) throws Exception {
    
    boolean updflg = false;

    //削除チェック個数
    // ※ここの都合でlong型
    long delcnt = dto.getDetailList().stream().filter(t -> FLG_ON.equals(t.getDeletechk())).count();
    //注残数サマリ
    long chzsurTotal = 0;
    
    //一括削除にチェックされている場合は更新あり、明細行すべてにチェックをいれる
    if (FLG_ON.equals(dto.getAllDeletechk())) {
      updflg = true;

      dto.getDetailList().stream().forEach(i -> {
        i.toBuilder().deletechk(FLG_ON);
      });

      chzsurTotal = dto.getDetailList().stream().filter(t -> FLG_ON.equals(t.getDeletechk()))
          .mapToLong(i -> delcnt)
          .sum();
    }

    if(0 == delcnt) {
      //処理に該当するデータが存在しません。
      return dto.toBuilder().nextGamenMode("").radioTokcod(initRadioTokcod()).build();
    }

    // ▼▼▼▼▼▼▼▼強引にintにキャスト
    return dto.toBuilder().chzsurTotal((int) chzsurTotal).nextGamenMode("submit")
        .radioTokcod(initRadioTokcod()).pageKeyPrev(dto.getPageKeyPrev())
        .pageKeyNow(dto.getPageKeyNow()).pageKeyNext(dto.getPageKeyNext())
        .build();

  }


  /**
   * 送信処理
   */
  @Transactional
  public void submit(BackDeleteDTO dto) throws Exception {

    // ユーザー権限チェック
    // 送信処理

    List<BackDeleteDetailDTO> submitList = dto.getDetailList();

    if ("ONLINE".equals("servicetime")) {
      
    } else {
      // サービス時間外ですエラー
    }
    // end
    
    LocalDateTime now = LocalDateTime.now();
    int sysdate = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("yyMMdd")));
    int systime = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HHmmss")));

    // TODO 更新対象固定ではなく、チェックボックスから選択されたものが対象となるように。
    // TODO 更新時の流れ：主キーで検索⇒返ってきたEntityに変更項目をセット⇒変更したEntityでupdate
    for (BackDeleteDetailDTO t : submitList) {

      if (!"1".equals(t.getDeletechk())) {
        // チェックされていない明細は対象としない
        continue;
      }

      ChuzanEntity updData = ChuzanEntity.builder().jucdte(Integer.valueOf(t.getJucdte()))
          .tokcod(t.getTokcod()).dscod(t.getDscod()).jucmdsseq(t.getJucmdsseq())
          .jucmsiseq(t.getJucmeiseq()).seq(t.getSeq()).build();

      // 注残データを取得する
      GeneratedChuzanEntity updChuzanEntityList = chuzanMapper.selectOnly(updData);
      
      updChuzanEntityList =
          ChuzanEntity.builder().delflg(FLG_ON).updkbn("U").upddte(sysdate).updjkk(systime).build();


      chuzanMapper.update(updChuzanEntityList);
      System.out.println("update= " + updChuzanEntityList);
    }

  }



  /**
   * 部分初期化処理
   */
  public BackDeleteDTO initPartOfForm(String daikaiskbcod, String usrbun) throws Exception {

    // boolean isOnline = false;
    // if (CheckSharedService.SERVICETIME_ONLINE
    // .equals(checkSharedService.checkServiceTime(daikaiskbcod, usrbun, "VAJ008", "001", "O"))) {
    // isOnline = true;
    // }

    return BackDeleteDTO.builder().kaiskbcod(daikaiskbcod).updkbnList(createUpdkbnList())
        .pageKeyPrev("").pageKeyNow("").pageKeyNext("")
        .radioTokcod(initRadioTokcod()).updkbnList(createUpdkbnList()).build();

  }

  /**
   * 戻る処理
   */
  public BackDeleteDTO back(BackDeleteDTO dto) throws Exception {

    // サービス時間チェック
    // boolean isOnline = false;
    // if (CheckSharedService.SERVICETIME_ONLINE
    // .equals(checkSharedService.checkServiceTime(daikaiskbcod, usrbun, "VAJ008", "001", "O"))) {
    // isOnline = true;
    // }

    return dto.toBuilder()
        .radioTokcod(initRadioTokcod()).pageKeyPrev("").pageKeyNow("").pageKeyNext("")
        .build();

  }


  private HinbanEntity getHinban(String daikaiskbcod, String kigbng) throws Exception {
    // 品番チェック
    HinbanEntity hinbanEntity = kigbngCheckSharedService.getHinban(daikaiskbcod, kigbng);
    if ("D".equals(hinbanEntity.getUpdkbn())) {
      throw new Exception("削除済みです。");
    }
    return hinbanEntity;
  }


  private List<LabelData> createUpdkbnList() {
    List<LabelData> updkbnList = new ArrayList<>();
    updkbnList.add(LabelData.builder().value("S").text("S 照会").build());
    updkbnList.add(LabelData.builder().value("D").text("D 削除").build());

    return updkbnList;
  }

  private Map<String, String> initRadioTokcod() {

    Map<String, String> radioTokcod = new LinkedHashMap<>();
    radioTokcod.put("1", "単独店");
    radioTokcod.put("2", "集約店");

    return radioTokcod;
  }

  private Map<Integer, String> getCheckBoxDelete(int meisuu) {
    Map<Integer, String> checkBoxDelete = new LinkedHashMap<Integer, String>();
    checkBoxDelete.put(meisuu, "tr");



    return checkBoxDelete;
  }


  private String getNumKey(String key, int col) {

    String str = key;
    str = StringUtility.lpad(str, col, "0");

    return str;
  }

}
