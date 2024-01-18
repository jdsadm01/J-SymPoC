package jp.co.jdsnet.backlendcost.domain.service.implement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDetailDTO;
import jp.co.jdsnet.backlendcost.domain.service.BackDeleteService;
import jp.co.jdsnet.base.webapp.parts.LabelData;
import jp.co.jdsnet.common.domain.entity.chuzan.ChuzanEntity;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.KaishaEntity;
import jp.co.jdsnet.common.domain.mapper.chuzan.ChuzanMapper;
import jp.co.jdsnet.common.domain.mapper.hinban.HinbanMapper;
import jp.co.jdsnet.common.domain.vo.TokuisakiAndDsVO;
import jp.co.jdsnet.common.logic.CheckSharedService;
import jp.co.jdsnet.common.logic.DataGetSharedService;
import jp.co.jdsnet.common.logic.KigbngCheckSharedService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BackDeleteServiceImpl implements BackDeleteService {

  private final CheckSharedService checkSharedService;
  private final KigbngCheckSharedService kigbngCheckSharedService;
  private final DataGetSharedService dataGetSharedService;
  private final ChuzanMapper chuzanMapper;
  private final HinbanMapper hinbanMapper;
  private final String SHUYAKUTENMODE = "2";
  private String FLG_ON = "1";
  private String FLG_OFF = "0";

  ChuzanEntity chuzanEntity;

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
        .tokkbnList(createTokkbnList()).build();
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
    if (!StringUtils.isBlank(dto.getKigbng())) {
      HinbanEntity hinbanEntity = getHinban(dto.getKaiskbcod(), dto.getKigbng());
      titnm = hinbanEntity.getTitnm();
      artnm = hinbanEntity.getArtnm();
      hjihnb = hinbanEntity.getHjihnb();
      tomrakcod = hinbanEntity.getTomrakcod();
      hbidte = String.valueOf(hinbanEntity.getHbidte());
    }


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
    BackDeleteDetailDTO detailDto;
    List<String> lastDataList = new ArrayList<>();// 100件目保持する用リスト

    dto = getChuzanData(dto, 0);


    // 検索処理終了 controllerに戻る
    return dto.toBuilder().kaiskbcod(dto.getKaiskbcod()).mkrbuncod(dto.getMkrbuncod())
        .skocod(dto.getSkocod()).kigbng(dto.getKigbng()).tokcod(dto.getTokcod())
        .dscod(dto.getDscod()).eigcod(dto.getEigcod()).tercod(dto.getTercod())
        .updkbn(dto.getUpdkbn()).jucdtefrom(dto.getJucdtefrom()).jucdteto(dto.getJucdteto())
        .hbidtefrom(dto.getHbidtefrom()).hbidteto(dto.getHbidtefrom())
        .titnm(titnm).artnm(artnm).toknm(toknm).dsnm(
            dsnm)
        .detailList(dto.getDetailList()).detailBottomList(dto.getDetailBottomList())
        .build();

  }

  /**
   * 注残データ取得処理
   */
  public BackDeleteDTO getChuzanData(BackDeleteDTO dto, int pageNo) {

    BackDeleteDetailDTO detailDto = null;

    // 前100、次100の場合のページキー
    List<String> keyList = new ArrayList<>();

    String pageKey = dto.getPageKey();
    // 1.注残データの"件数"を取得する
    int chuzanDataCnt = chuzanMapper.selectCount(chuzanEntity);

    if (chuzanDataCnt == 0) {
      // 0件エラー
      // errors.notExistData
      return BackDeleteDTO.builder().build();
    } else if (chuzanDataCnt <= 10000) {
      // 件数上限突破エラー
      // errors.exceed.reinput
      return BackDeleteDTO.builder().build();
    }

    
    // 注残データを取得するxmlにアクセスし、データを取得する
    List<ChuzanEntity> chuzanEntityList = chuzanMapper.select("jds", pageKey);

    // 3.代表会社設定(品番検索で必要)
    String inputkaiskbcod = dto.getUserInfo().getDaikaiskbcod(); // ユーザー代表会社
    if (dto.getKaiskbcod().equals(dto.getUserInfo().getKaiskbcod())
        && "MKR".equals(dto.getUserInfo().getUsrbun())) {

      inputkaiskbcod = dto.getKaiskbcod();
    }

    // 4.追加情報設定、リストに追加していく
    List<BackDeleteDetailDTO> detailDTO = new ArrayList<>();
    List<String> lastDataList = new ArrayList<>();// 100件目保持する用リスト

    // 明細Noを設定 +1スタートなので一の位0スタート
    AtomicInteger atomicNo = new AtomicInteger(dto.getPageNo() - 1);

    // ここからstreamスタート
    chuzanEntityList.stream().forEach(t -> {
      atomicNo.incrementAndGet();

      // 2のリストに品番、得意先、注残削除区分を追加してリストを更新する。
      String addchzdelkbn = "";
      HinbanEntity hinbanEntity = null;
      TokuisakiAndDsVO tokuisakiAndDsVO = null;
      try {
        // 品番情報取得
        if (!StringUtils.isBlank(dto.getKigbng())) {
          hinbanEntity = getHinban(dto.getKaiskbcod(), dto.getKigbng());
          // 記号番号取得
        }

        // 得意先情報取得
        if (!StringUtils.isBlank(dto.getTokcod())) {
          tokuisakiAndDsVO = dataGetSharedService
              .getKyotsuAndKakushaTokuisakiData(dto.getKaiskbcod(), dto.getTokcod());
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


      detailDTO.add(BackDeleteDetailDTO.builder().no(atomicNo.incrementAndGet())// 明細No
          .skocod(chuzanEntity.getChzskocod())
          .kigbng(chuzanEntity.getKigbng()).hjihnb(hjihnb) // 実際には追加品番情報から取得
          .chzsur(chuzanEntity.getChzsur()).tomrakcod(tomrakcod) // 実際には追加品番情報から取得
          .hbidte(hbidte) // 実際には追加品番情報から取得
          .usnjndte(String.valueOf(chuzanEntity.getChzdte()))
          .urisyytencod(chuzanEntity.getUrisyytencod())
          .tokcod(chuzanEntity.getTokcod()).dscod(chuzanEntity.getDscod())
          .toknm(toknm) // 実際には追加得意先情報から取得
          .jucdte(String.valueOf(chuzanEntity.getJucdte()))
          .chzdeldte(String.valueOf(chuzanEntity.getJucdte()) + addchzdelkbn).build());

    });;


    // 5.100件目は別で保持
    pageKey = "";
    detailDTO.stream().skip(100).limit(1).forEach(t -> {

      lastDataList.add(String.valueOf(chuzanEntity.getChzdte()));
      lastDataList.add(String.valueOf(chuzanEntity.getChzjkk()));
      lastDataList.add(String.valueOf(chuzanEntity.getChzrelno()));
      lastDataList.add(chuzanEntity.getEigcod());
      lastDataList.add(chuzanEntity.getKigbng());
      lastDataList.add(chuzanEntity.getTokcod());
      lastDataList.add(chuzanEntity.getDscod());

    });

    pageKey = getKey(lastDataList);

    // 注残の取得データと100件目の明細を返却
    return BackDeleteDTO.builder().deleteList(detailDTO).pageKey(pageKey).build();

      
  }
  
  private String getKey(List<String> lastDataList) {

    return StringUtils.truncate(lastDataList.get(0), 6, " ")
        + StringUtils.truncate(lastDataList.get(1), 6, " ")
        + StringUtils.truncate(lastDataList.get(2), 5, " ")
        + StringUtils.truncate(lastDataList.get(3), 2, " ")
        + StringUtils.truncate(lastDataList.get(4), 13, " ")
        + StringUtils.truncate(lastDataList.get(5), 8, " ")
        + StringUtils.truncate(lastDataList.get(6), 3, " ");
  }

  /**
   * 前100件処理 次100件処理と同じなので呼び出して終了
   */
  @Override
  public BackDeleteDTO prev100Search(BackDeleteDTO dto, int PageNo) throws Exception {

    return next100Search(dto, PageNo);
  }

  
  /**
   * 前次100件処理
   */
  public BackDeleteDTO next100Search(BackDeleteDTO dto, int pageNo) throws Exception {


    BackDeleteDetailDTO detailDto = null;

    // 削除対象存在チェック

    // 表示されている明細のチェックボックスを全部確認する
    IntStream.range(0, 99).forEach(i -> {
      if (FLG_ON.equals(dto.getDelchk())) {
        // 一つでも存在した時点で処理終了。「修正データが存在します。送信してください。」
        return;
      }
    });

    // 以下検索処理と同じ

    BackDeleteDTO newdto;

    // 注残データ取得※別メソッド
    newdto = getChuzanData(dto, pageNo);

    // 検索処理終了 controllerに戻る
    return newdto.toBuilder().kaiskbcod(newdto.getKaiskbcod()).mkrbuncod(newdto.getMkrbuncod())
        .skocod(newdto.getSkocod()).kigbng(newdto.getKigbng()).tokcod(newdto.getTokcod())
        .dscod(newdto.getDscod()).eigcod(newdto.getEigcod()).tercod(newdto.getTercod())
        .updkbn(newdto.getUpdkbn()).jucdtefrom(newdto.getJucdtefrom())
        .jucdteto(newdto.getJucdteto()).hbidtefrom(newdto.getHbidtefrom())
        .hbidteto(newdto.getHbidtefrom()).detailList(newdto.getDetailList()).build();

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
      return dto.toBuilder().build();
    }

    // ▼▼▼▼▼▼▼▼強引にintにキャスト
    return dto.toBuilder().chzsurTotal((int) chzsurTotal).build();

  }


  /**
   * 送信処理
   */
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

    for (BackDeleteDetailDTO t : submitList) {
      ChuzanEntity submitEntity = ChuzanEntity.builder().delflg(FLG_ON).upddte(sysdate)
          .updjkk(systime).updkbn("U").chzskocod(t.getSkocod()).kigbng(t.getKigbng())
          .chzsur(t.getChzsur()).tomrakcod(t.getTomrakcod()).htbdte(Integer.valueOf(t.getHbidte()))
          .chzdte(Integer.valueOf(t.getChzdeldte())).urisyytencod(t.getUrisyytencod())
          .tokcod(t.getTokcod()).dscod(t.getDscod()).jucdte(Integer.valueOf(t.getJucdte()))
          .chzdeldte(Integer.valueOf(t.getChzdeldte())).build();

      chuzanMapper.update(submitEntity);
    }



    //チェックのついた行だけ抜粋
    
    String kari = "kari";
    int intkari = 0;


    ChuzanEntity entity = null;
    for (BackDeleteDetailDTO t : dto.getDetailList()) {
      entity = null;
      // entity.toBuilder().jucdte(Integer.valueOf(t.getJucdte()))
      // .tokcod(t.getTokcod())
      // .dscod(t.getDscod())
      // .jucmdsseq(intkari)
      // .jucmsiseq(intkari)
      // .seq(intkari)
      // .trncod(kari)
      // .

      // entity.toBuilder().daikaiskbcod(t.getDaikaiskbcod())
      // .chzskocod(t.getSkocod())
      // .kigbng(t.getKigbng())
      // .eigcod(t.getEigCod())
      // .tercod(t.tercod())
      // .tokcod(t.getTokcod())
      // .tokkbn()
      // .dscod()
      // .mk
      //
      //
      //
      //
      //
      // chuzanMapper.update();

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
        .tokkbnList(createTokkbnList()).detailList(null).detailBottomList(null).build();

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

    return dto.toBuilder().kaiskbcod(dto.getKaiskbcod()).mkrbuncod(dto.getMkrbuncod())
        .skocod(dto.getSkocod()).kigbng(dto.getKigbng()).tokcod(dto.getTokcod())
        .dscod(dto.getDscod()).eigcod(dto.getEigcod()).tercod(dto.getTercod())
        .updkbn(dto.getUpdkbn()).jucdtefrom(dto.getJucdtefrom()).jucdteto(dto.getJucdteto())
        .hbidtefrom(dto.getHbidtefrom()).hbidteto(dto.getHbidtefrom()).titnm(dto.getTitnm())
        .artnm(dto.getArtnm()).toknm(dto.getToknm()).dsnm(dto.getDsnm())
        .detailList(dto.getDetailList())
        .detailBottomList(dto.getDetailBottomList()).build();

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

  private List<LabelData> createTokkbnList() {
    List<LabelData> tokkbnList = new ArrayList<>();
    tokkbnList.add(LabelData.builder().value("1").text("単独店").build());
    tokkbnList.add(LabelData.builder().value("2").text("集約店").build());

    return tokkbnList;
  }



}
