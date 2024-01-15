package jp.co.jdsnet.backlendcost.domain.service.implement;

import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDetailDTO;
import jp.co.jdsnet.backlendcost.domain.service.BackDeleteService;
import jp.co.jdsnet.common.domain.entity.chuzan.ChuzanEntity;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.mapper.chuzan.ChuzanMapper;
import jp.co.jdsnet.common.domain.mapper.hinban.HinbanMapper;
import jp.co.jdsnet.common.logic.CheckSharedService;
import jp.co.jdsnet.common.logic.KigbngCheckSharedService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BackDeleteServiceImpl implements BackDeleteService {

  private final CheckSharedService checkSharedService;
  private final KigbngCheckSharedService kigbngCheckSharedService;
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
        .equals(checkSharedService.checkServiceTime(daikaiskbcod, usrbun, "VHJ002", "001", "O"))) {
      isOnline = true;
    }

    // 項目の初期化
    return null;
  }

  /**
   * 検索条件入力チェック処理
   */
  public BackDeleteDTO search(BackDeleteDTO dto, String button) throws Exception {

    String usrbun = "";
    String daikaiskbcod = "";

    // サービス時間チェック
    boolean isOnline = false;
    if (CheckSharedService.SERVICETIME_ONLINE
        .equals(checkSharedService.checkServiceTime(daikaiskbcod, usrbun, "VHJ002", "001", "O"))) {
      isOnline = true;
    }

    // 権限チェック

    // この時点でエラー発生している場合処理終了
    // return dto;

    // ===↓バリデータチェック===

    if (StringUtils.isBlank(dto.getKaiskbcod())) {
      // 会社必須エラー
    }
    // else if (!StringUtils.isAscii(dto.getKaiskbcod())) {
    // // 会社半角英数以外エラー
    // }

    if (StringUtils.isBlank(dto.getMkrbuncod()) && StringUtils.isBlank(dto.getKigbng())
        && StringUtils.isBlank(dto.getTokcod()) && StringUtils.isBlank(dto.getEigcod())
        && StringUtils.isBlank(String.valueOf(dto.getJucdtefrom()))
        && StringUtils.isBlank(String.valueOf(dto.getJucdteto()))
        && StringUtils.isBlank(String.valueOf(dto.getHbidtefrom()))
        && StringUtils.isBlank(String.valueOf(dto.getHbidteto()))) {
      // いずれか必須エラー
    }

    if (!StringUtils.isBlank(dto.getDscod()) && StringUtils.isBlank(dto.getTokcod())) {
      // DS入力ありのとき得意先必須エラー
    }

    if (!StringUtils.isBlank(dto.getTercod()) && StringUtils.isBlank(dto.getEigcod())) {
      // テリトリー入力ありのとき営業所必須エラー
    }


    // ===↑バリデータチェック===
    // ===↓整合性チェック===

    // 会社チェック
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
        && dto.getJucdtefrom() > dto.getJucdteto())) {
      // Fromのほうが未来日付の場合エラー
    }

    // 発売日チェック
    // ※yyMMdd型チェックはバリデータチェックで行う
    if ((!StringUtils.isBlank(String.valueOf(dto.getHbidtefrom()))
        && !StringUtils.isBlank(String.valueOf(dto.getHbidteto())))
        && dto.getHbidtefrom() > dto.getHbidteto()) {
      // Fromのほうが未来日付の場合エラー
    }

    // ===↑整合性チェック===

    // 品番情報取得
    if (!StringUtils.isBlank(dto.getKigbng())) {
      // 記号番号取得
    }

    // 得意先情報取得
    if (!StringUtils.isBlank(dto.getTokcod())) {
      // 得意先情報取得
    }

    // 注残データ取得※別メソッド
    getChuzanData(dto);


    // 検索処理終了 controllerに戻る
    return dto.toBuilder().kaiskbcod(dto.getKaiskbcod()).mkrbuncod(dto.getMkrbuncod())
        .skocod(dto.getSkocod()).kigbng(dto.getKigbng()).tokcod(dto.getTokcod())
        .dscod(dto.getDscod()).eigcod(dto.getEigcod()).tercod(dto.getTercod())
        .updKbn(dto.getUpdKbn()).jucdtefrom(dto.getJucdtefrom()).jucdteto(dto.getJucdteto())
        .hbidtefrom(dto.getHbidtefrom()).hbidteto(dto.getHbidtefrom())
        .detailList(dto.getDetailList()).build();

  }

  /**
   * 注残データ取得処理
   */
  public void getChuzanData(BackDeleteDTO dto, String button) {

    int pageNo = 0;

    // 前100、次100の場合のページキー
    List<String> keyList = new ArrayList<>();

    keyList = dto.getPageKey();
    // 注残データの件数を取得するxmlにアクセスし(たぶんcountだけのsqlを作成する)件数を取得する
    int chuzanDataCnt = chuzanMapper.selectCount(chuzanEntity, keyList);

    if (chuzanDataCnt == 0) {
      // 0件エラー
      // errors.notExistData 該当するデータが存在しません。
      return;
    } else if (chuzanDataCnt <= 10000) {
      // 件数上限突破エラー
      // errors.exceed.reinput 件数制限を超えました。再度条件を指定してください。
      return;
    }

    int pageKey = 0;

    // 押下されたボタンによってどこの明細を取得するか変える
    switch (button) {
      case "search":

        break;

      case "prev":
        // pageKey = 画面ページNo - 1
        pageKey = dto.getPageNo() - 1;
        break;

      case "next":
        // pageKey = 画面ページNo + 1
        pageKey = dto.getPageNo() + 1;
        break;

    }
    int detailTopNo = pageKey * 100 + 1;
    int detailBottomNo = (pageKey + 1) * 100;
    
    // 注残データを取得するxmlにアクセスし、データを取得する
    //注残情報取得
    List<ChuzanEntity> chuzanEntityList = chuzanMapper.select("jds", detailTopNo);

    
    List<BackDeleteDetailDTO> detailList = chuzanEntityList.stream().map(t -> {
      
      if (!StringUtils.isBlank(dto.getKigbng())) {
        // 品番情報の追加
        HinbanEntity hinbanEntity = getHinban("JDS", dto.getKigbng());
      }
      if (!StringUtils.isBlank(dto.getTokcod())) {
        // 得意先情報の追加
      }

      if (t == (detailList.size())) {
        // 明細が100件以上ある場合で100件目に表示する値は保持
        List<BackDeleteDTO> lastDataList = new ArrayList<>();

        lastDataList.add(chuzanEntity.getChzdte());
        lastDataList.add(chuzanEntity.getchzjkk());
        lastDataList.add(chuzanEntity.getchzrelno());
        lastDataList.add(chuzanEntity.geteigcod());
        lastDataList.add(chuzanEntity.kigbng());
        lastDataList.add(chuzanEntity.tokcod());
        lastDataList.add(chuzanEntity.dscod());
      }
      
      return BackDeleteDetailDTO.builder()
          .no(t)
          .skocod(detailList.getChzskocod())
          .kigbng(chuzanEntity.getKigbng())
          .chzsur(chuzanEntity.getChzsur())
          .tomrakcod(chuzanEntity.getTomrakcod()).hbidte(chuzanEntity.getHtbdte())
          .usnjndte(chuzanEntity.getChzdte())
          .urisyytencod(chuzanEntity.getUrisyytencod()).tokcod(chuzanEntity.getTokcod())
          .dscod(chuzanEntity.getDscod()).toknm(chuzanEntity.getToknm1() + chuzanEntity.getToknm2())
          .jucdte(chuzanEntity.getJucdte()).chzdeldte(addchzdelkbn)
          .build();

    }).collect(toList());

      
  }
  
  
  /**
   * 前次100件処理
   */
  public BackDeleteDTO next100Search(BackDeleteDTO dto, String button) throws Exception {
    // サービス時間チェック
    // boolean isOnline = false;
    // if (CheckSharedService.SERVICETIME_ONLINE
    // .equals(checkSharedService.checkServiceTime(daikaiskbcod, usrbun, "VHJ002", "001", "O"))) {
    // isOnline = true;
    // }

    // 削除対象存在チェック

    // 表示されている明細のチェックボックスを全部確認する
    IntStream.range(0, 99).forEach(i -> {
      if (FLG_ON.equals(dto.getDelchk())) {
        // 修正データが存在します。送信してください。
        return;
        // 一つでも存在した時点で処理終了。
      }
    });


    // 注残データ取得※別メソッド
    getChuzanData(dto);

    // 検索処理終了 controllerに戻る
    return dto.toBuilder().kaiskbcod(dto.getKaiskbcod()).mkrbuncod(dto.getMkrbuncod())
        .skocod(dto.getSkocod()).kigbng(dto.getKigbng()).tokcod(dto.getTokcod())
        .dscod(dto.getDscod()).eigcod(dto.getEigcod()).tercod(dto.getTercod())
        .updKbn(dto.getUpdKbn()).jucdtefrom(dto.getJucdtefrom()).jucdteto(dto.getJucdteto())
        .hbidtefrom(dto.getHbidtefrom()).hbidteto(dto.getHbidtefrom())
        .detailList(dto.getDetailList()).build();

  }


  /**
   * 削除入力チェック処理
   */
  public BackDeleteDTO chkInputDeleteData(BackDeleteDTO dto) throws Exception {
    
    boolean updflg = false;

    //削除チェック個数
    long delcnt = dto.getDetailList().stream().filter(t -> FLG_ON.equals(t.getDeletechk())).count();
    //注残数サマリ
    
    //一括削除にチェックされている場合は更新あり、明細行すべてにチェックをいれる
    if (FLG_ON.equals(dto.getAllDeletechk())) {
      updflg = true;
      
      dto.getDetailList().stream().forEach(i -> {
        i.toBuilder().deletechk(FLG_ON);

      });
      
      //全部足してるのでチェックされているものだけ足すよう改変
      int chzsurTotal = 0;
      
      dto.getDetailList().stream().filter(t -> FLG_ON.equals(t.getDeletechk())).map(t ->{
        chzsurTotal = dto.getDetailList().stream().collect(Collectors.summingInt(dto.getChzCnt()));
      });
      
      
    }

    if(0 == delcnt) {
      //処理に該当するデータが存在しません。
      return dto.toBuilder().build();
    }

    return dto.toBuilder().build();;

  }


  /**
   * 送信処理
   */
  public void submit(BackDeleteDTO dto) throws Exception {

    // ユーザー権限チェック
    // 送信処理

    if ("ONLINE".equals("servicetime")) {
      // 送信処理
    } else {
      // サービス時間外ですエラー
    }

  }

  /**
   * 部分初期化処理
   */
  public void initPartOfForm() throws Exception {

  }

  /**
   * 戻る処理
   */
  public void back() throws Exception {


  }

  @Override
  public BackDeleteDTO prev100Search(BackDeleteDTO dto, String button) throws Exception {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

  @Override
  public void getChuzanData(BackDeleteDTO dto) throws Exception {
    // TODO 自動生成されたメソッド・スタブ

  }

  private HinbanEntity getHinban(String daikaiskbcod, String kigbng) throws Exception {
    // 品番チェック
    HinbanEntity hinbanEntity = kigbngCheckSharedService.getHinban(daikaiskbcod, kigbng);
    if ("D".equals(hinbanEntity.getUpdkbn())) {
      throw new Exception("削除済みです。");
    }
    return hinbanEntity;
  }



}
