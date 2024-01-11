package jp.co.jdsnet.backlendcost.domain.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDetailDTO;
import jp.co.jdsnet.backlendcost.domain.service.BackDeleteService;
import jp.co.jdsnet.common.domain.mapper.chuzan.ChuzanMapper;
import jp.co.jdsnet.common.logic.CheckSharedService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BackDeleteServiceImpl implements BackDeleteService {

  private final CheckSharedService checkSharedService;
  private final ChuzanMapper chuzanMapper;
  private final String SHUYAKUTENMODE = "2";

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
  public BackDeleteDTO search(BackDeleteDTO dto) throws Exception {

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
    } else if (!StringUtils.isAscii(dto.getKaiskbcod())) {
      // 会社半角英数以外エラー
    }

    if (StringUtils.isBlank(dto.mkrbuncod()) && StringUtils.isBlank(dto.kigbng())
        && StringUtils.isBlank(dto.tokcod()) && StringUtils.isBlank(dto.eigcod())
        && StringUtils.isBlank(dto.jucdtefrom()) && StringUtils.isBlank(dto.jucdteto())
        && StringUtils.isBlank(dto.hbidtefrom()) && StringUtils.isBlank(dto.hbidteto())) {
      // いずれか必須エラー
    }

    if (!StringUtils.isBlank(dto.dscod()) && StringUtils.isBlank(dto.tokcod())) {
      // DS入力ありのとき得意先必須エラー
    }

    if (!StringUtils.isBlank(dto.tercod()) && StringUtils.isBlank(dto.eigcod())) {
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
    if (!StringUtils.isBlank(dto.skocod())) {
      // 共通処理・倉庫整合性チェック
      // 存在しない場合エラー
    }

    // 記号番号チェック
    if (!StringUtils.isBlank(dto.kigbng())) {
      // 共通処理・品番変換
      // 存在しない場合エラー
    }

    // 営業所チェック
    if (!StringUtils.isBlank(dto.eigcod())) {
      // 共通処理・営業所整合性チェック
      // 存在しない場合エラー
    }

    // 得意先チェック
    if (!StringUtils.isBlank(dto.tokcod())) {
      // 共通処理・得意先&DS整合性チェック
      // 存在しない場合エラー
    }

    // 受注日チェック
    // ※yyMMdd型チェックはバリデータチェックで行う
    if ((!StringUtils.isBlank(dto.jucdtefrom()) && !StringUtils.isBlank(dto.jucdteTo()))
        && dto.jucdtefrom() > dto.jucdteTo()) {
      // Fromのほうが未来日付の場合エラー
    }

    // 発売日チェック
    // ※yyMMdd型チェックはバリデータチェックで行う
    if ((!StringUtils.isBlank(dto.hbidtefrom()) && !StringUtils.isBlank(dto.hbidteto()))
        && dto.hbidtefrom() > dto.hbidteto()) {
      // Fromのほうが未来日付の場合エラー
    }

    // ===↑整合性チェック===

    // 品番情報取得
    if (!StringUtils.isBlank(dto.kigbng())) {
      // 記号番号取得
    }

    // 得意先情報取得
    if (!StringUtils.isBlank(dto.tokcod())) {
      // 得意先情報取得
    }

    // 注残データ取得※別メソッド
    getChuzanData(dto);


    // 検索処理終了 controllerに戻る
    return dto.toBuilder().kaiskbcod(dto.getkaiskbcod()).mkrbuncod(dto.getmkrbuncod())
        .skocod(dto.getskocod()).kigbng(dto.getkigbng()).tokcod(dto.gettokcod())
        .dscod(dto.getdscod()).eigcod(dto.geteigcod()).tercod(dto.gettercod())
        .updkbn(dto.getupdkbn()).jucdtefrom(dto.getjucdtefrom()).jucdteto(dto.getjucdteto())
        .hbidtefrom(dto.gethbidtefrom()).hbidteto(dto.gethbidtefrom())
        .datailList(dto.getdetaillist()).build();

  }

  /**
   * 注残データ取得処理
   */
  public void getChuzanData(BackDeleteDTO dto) {

    int pageNo = 0;
    // 注残データの件数を取得するxmlにアクセスし(たぶんcountだけのsqlを作成する)件数を取得する
    int chuzanDataCnt = chuzanMapper.builder().selectcount();

    // 入力値がブランクではない場合条件を追加していく
    // //受託メーカーの場合は表示されている会社を代入する
    // String inputkaiskbcod = dto.getUserMap().get(usrDaikaiskbcod); //ユーザー代表会社
    // if(daikaiskbcod.equals(dto.getUserMap().get(usrkaiskbcod)) &&
    // "MKR".equals(dto.getUserMap().get(usrbun))){

    // inputkaiskbcod = gmnKaiskbcod;
    // }
    // M分類
    // 倉庫
    // 記号番号
    // 得意先
    // DS
    // 営業所
    // テリトリー
    // 受注日From - To
    // 発売日From - To

    // 押下されたボタンが「前100」「次100」の場合pagekey

    // pageKeyもセットする

    if (chuzanDataCnt == 0) {
      // 0件エラー
      // errors.notExistData 該当するデータが存在しません。
      return;
    } else if (chuzanDataCnt <= 10000) {
      // 件数上限突破エラー
      // errors.exceed.reinput 件数制限を超えました。再度条件を指定してください。
      return;
    }

    // 注残データを取得するxmlにアクセスし、データを取得する
    List<BackDeleteDetailDTO> detailList = new ArrayList<>();
    
    // int detailTopNo = pagekey * 100 + 1;
    // int detailBottomNo = (pagekey + 1) * 100;

    switch (押下されたボタン) {
      case 実行:
        IntStream.range(0, 99).forEach(i -> {
          detailList.add(BackDeleteDetailDTO.builder().kaiskbcod(dto.getkaiskbcod())
              .mkrbuncod(dto.getmkrbuncod()).skocod(dto.getskoCod()).kigbng(dto.getkigbng())
              .tokcod(dto.gettokcod()).dscod(dto.getdscod()).eigcod(dto.geteigcod())
              .tercod(dto.gettercod()).jucdtefrom(dto.getjucdtefrom()).jucdteto(dto.getjucdteto())
              .hbidtefrom(dto.gethbidtefrom()).hbidteto(dto.gethbidteto()));
        });
        break;

      case 前100件:
        break;

      case 次100件:
        break;

    }

    // 情報を足す処理
    
    //品番情報の追加
    String addhjihnb;
    String addtomrakcod;
    String addhbidte;
    //得意先情報の追加
    String addtoknm;
    // 注残削除区分の追加
    String addchzdelkbn;

    List<BackDeleteDetailDTO> detailListPlus = new ArrayList<>();
    
    IntStream.range(0, detailList.size()).forEach(i -> {

      if (StringUtils.isBlank(dto.kigbng())) {
        // 共通処理で品番検索
        addhjihnb = "";
        addtomrakcod = "";
        addhbidte = "";
      } else {
        // 検索条件入力チェック処理の品番をセット
        addhjihnb = dto.hjihnb();
        addtomrakcod = dto.tomrakcod();
        addhbidte = dto.hbidte();
      }

      if (StringUtils.isBlank(dto.tokcod()) || SHUYAKUTENMODE.equals(radiotokcod)) {
        // 共通処理で得意先検索
        addtoknm = "";
      } else {
        // 検索条件入力チェック処理の得意先をセット
        addtoknm = dto.toknm(); // toknm1 + toknm2
      }

      if (i.getchzdeldte() > i.getchzdelkjndte()) {
        addchzdelkbn = "E";
      } else if ("B".equals(i.getrmcod())) {
        addchzdelkbn = "N";
      } else {
        addchzdelkbn = "";
      }

      // 取得した付加情報をセットしていく
      detailListPlus = dto.toBuilder().detailList().hjihnb(addhjihnb).tomrakcod(addtomrakcod)
          .hbidte(addhbidte).toknm(addtoknm).chzdelkbn(addchzdelkbn).build();


      if (i == (detailList.size())) {
        // 明細が100件以上ある場合で100件目に表示する値は保持
        List<BackDeleteDTO> lastDataList = new ArrayList<>();

        lastDataList.add(dto.chzdte);
        lastDataList.add(dto.chzjkk);
        lastDataList.add(dto.chzrelno);
        lastDataList.add(dto.eigcod);
        lastDataList.add(dto.kigbng);
        lastDataList.add(dto.tokcod);
        lastDataList.add(dto.dscod);

      }
    });
  }
  /**
   * 前次100件処理
   */
  public BackDeleteDTO next100Search(BackDeleteDTO dto) throws Exception {
    // サービス時間チェック
    boolean isOnline = false;
    if (CheckSharedService.SERVICETIME_ONLINE
        .equals(checkSharedService.checkServiceTime(daikaiskbcod, usrbun, "VHJ002", "001", "O"))) {
      isOnline = true;
    }

    // 削除対象存在チェック

    // 表示されている明細のチェックボックスを全部確認する
    IntStream.range(0, 99).forEach(i -> {
      if (FLG_ON.equals(dto.getdeletechk())) {
        // 修正データが存在します。送信してください。
        return dto.tobuilder().detailList(dto.getDetailList()).build();
        // 一つでも存在した時点で処理終了。
      }
    });

    // 付加情報
    String inputkaiskbcod = dto.getUserMap().get(usrDaikaiskbcod); // ユーザー代表会社
    if (daikaiskbcod.equals(dto.getUserMap().get(usrkaiskbcod))
        && "MKR".equals(dto.getUserMap().get(usrbun))) {

      inputkaiskbcod = gmnKaiskbcod;
    }

    // 注残データ取得※別メソッド
    getChuzanData(dto);

    // 検索処理終了 controllerに戻る
    return dto.toBuilder().kaiskbcod(dto.getkaiskbcod()).mkrbuncod(dto.getmkrbuncod())
        .skocod(dto.getskocod()).kigbng(dto.getkigbng()).tokcod(dto.gettokcod())
        .dscod(dto.getdscod()).eigcod(dto.geteigcod()).tercod(dto.gettercod())
        .updkbn(dto.getupdkbn()).jucdtefrom(dto.getjucdtefrom()).jucdteto(dto.getjucdteto())
        .hbidtefrom(dto.gethbidtefrom()).hbidteto(dto.gethbidtefrom())
        .datailList(dto.getdetaillist()).build();

  }


  /**
   * 削除入力チェック処理
   */
  public BackDeleteDTO chkInputDeleteData(BackDeleteDTO dto) throws Exception {

    return null;
  }


  /**
   * 送信処理
   */
  public void submit(BackDeleteDTO dto) throws Exception {

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


}
