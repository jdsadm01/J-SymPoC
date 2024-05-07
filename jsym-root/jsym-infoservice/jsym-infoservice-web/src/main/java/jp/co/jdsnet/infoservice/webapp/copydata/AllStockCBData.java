package jp.co.jdsnet.infoservice.webapp.copydata;

import jp.co.jdsnet.base.webapp.parts.CommonClipboardData;
import jp.co.jdsnet.infoservice.webapp.form.AllStockForm;

public class AllStockCBData extends CommonClipboardData<AllStockForm> {

  @Override
  protected void createClipboardData(AllStockForm form) {
    // ヘッダー部
    editHeader(form);

    // 品番情報部
    editHinInfo(form);

    enter();// １行空ける

    // 明細見出し部
    editDetailHeadline(form);

    // 明細部
    editDetail(form);
  }

  /**
   * ヘッダー部のデータを編集します。
   * 
   * @param fmForm
   */
  private void editHeader(AllStockForm fmForm) {

    // //全国在庫照会
    // addln(fmForm.getMessage("label.zaiko"));
    //
    // //会社
    // add(createStringSet(fmForm.getMessage("label.kai"),
    // toText(fmForm.getMap("kai"))));
    // //記号－番号
    // addln(createStringSet(fmForm.getMessage("label.kig_Bng"),
    // toText(((String) fmForm.getMap("kigBng")).toUpperCase())));
  }

  /**
   * 品番情報部のデータを編集します。
   * 
   * @param fmForm
   */
  private void editHinInfo(AllStockForm fmForm) {

    // //品番情報は'mapRow'というmapに保持しています
    // HashMap mapRow = (HashMap)fmForm.getMapRow();
    //
    // //表示品番
    // add(createStringSet(fmForm.getMessage("label.hjihnb"),
    // toText(mapRow.get("hjiHnb"))));
    // //タイトル
    // add(createStringSet(fmForm.getMessage("label.tit"),
    // toText(mapRow.get("titKj"))));
    // //アーティスト
    // add(createStringSet(fmForm.getMessage("label.artist"),
    // toText(mapRow.get("artKj"))));
    // //売上累計
    // addln(createStringSet(fmForm.getMessage("label.urirui"),
    // toDigit(mapRow.get("urirui"))));
    //
    // //ランク
    // add(createStringSet(fmForm.getMessage("label.rnk"),
    // toText(mapRow.get("tomRak"))));
    // //セット数
    // add(createStringSet(fmForm.getMessage("label.setsuu"),
    // toDigit(mapRow.get("setSuu"))));
    // //発売日
    // add(createStringSet(fmForm.getMessage("label.hbidte"),
    // toDate(mapRow.get("hbiDte"))));
    // //形態
    // add(createStringSet(fmForm.getMessage("label.ketcod"),
    // toText(mapRow.get("ketCod"))));
    // //面替
    // add(createStringSet(fmForm.getMessage("label.mng"),
    // toText(mapRow.get("mngSgn"))));
    // //再発品番
    // add(createStringSet(fmForm.getMessage("label.sht"),
    // toText(mapRow.get("shtKigBng"))));
    //
    // //税抜価格
    // add(createStringSet(fmForm.getMessage("label.zeinktka"),
    // toDigit(mapRow.get("zeinkiTka"))));
    // //仕切単価
    // add(createStringSet(fmForm.getMessage("label.skrtan"),
    // toDigit(mapRow.get("skrTanIpn"))));
    //
    // //入庫予定日／予定数
    // addTab((fmForm.getMessage("label.nykytedte")+fmForm.getMessage("label.sla")+fmForm.getMessage("label.ytesuu")));
    //
    // //入庫予定情報は'mapRow'に'nykYteList'という名前で保持されてます。
    // LinkedList nykYteList = (LinkedList)fmForm.getMapRow("nykYteList");
    //
    // for (Iterator iter = nykYteList.iterator(); iter.hasNext(); ) {
    //
    // HashMap nykMap = (HashMap) iter.next();
    // addTab(toDate(nykMap.get("nki")));
    // addTab(toDigit(nykMap.get("hacSuu")));
    // }
    //
    // if(nykYteList.size()<=0){
    // addTab(toDate(fmForm.getMap("nki")));
    // addTab(toDigit(fmForm.getMap("hacSuu")));
    // }
    //
    // //Ｌ(出荷制限対象品)
    // addln(createStringSet(fmForm.getMessage("label.l"),
    // toText(mapRow.get("syaSgnFlg"))));
  }

  /**
   * 明細部の見出しを設定します。
   * 
   * @param fmForm
   */
  private void editDetailHeadline(AllStockForm fmForm) {

    // addln(createStringSet(
    // new String[]{
    // fmForm.getMessage("label.sko"), //倉庫
    // fmForm.getMessage("label.s"), //Ｓ
    // fmForm.getMessage("label.c"), //Ｃ
    // fmForm.getMessage("label.zai"), //在庫数
    // fmForm.getMessage("label.kano"), //可能数
    // fmForm.getMessage("label.reza"), //リザーブ
    // fmForm.getMessage("label.shz"), //注残
    // fmForm.getMessage("label.sinpInit")+
    // fmForm.getMessage("label.jucSuu"), //新譜初回受注数
    // fmForm.getMessage("label.sinpInit")+
    // fmForm.getMessage("label.syaSuu"), //新譜初回出荷数
    // fmForm.getMessage("label.sek"), //積送
    // fmForm.getMessage("label.kdazan"), //貸出残
    // fmForm.getMessage("label.miha"), //未引当
    // fmForm.getMessage("label.today")+
    // fmForm.getMessage("label.jucSuu"), //当日受注数
    // fmForm.getMessage("label.today")+
    // fmForm.getMessage("label.syaSuu"), //当日出荷数
    // fmForm.getMessage("label.month")+
    // fmForm.getMessage("label.jucSuu"), //当月受注数
    // fmForm.getMessage("label.month")+
    // fmForm.getMessage("label.syaSuu") //当月出荷数
    // }
    // ));
  }

  /**
   * 明細データを編集します。
   * 
   * @param fmForm
   */
  private void editDetail(AllStockForm fmForm) {

    fmForm.getDetailList().forEach(t -> {
      addln(createStringSet(new String[] {toText(t.getHjinm2()), toText(t.getSyacod()),
          toText(t.getCchhinkbn()), toDigit(t.getZaisur()), toDigit(t.getSyaknosur()),
          toDigit(t.getZaikhokhasur()), toDigit(t.getChzkhasur()), toDigit(t.getSinjuckhasur()),
          toDigit(t.getSinsyasur()), toDigit(t.getSekzansur()), toDigit(t.getKdazansur()),
          toDigit(t.getYkesyakhasur()), toDigit(t.getTodjucsur()), toDigit(t.getTodsyasur()),
          toDigit(t.getTomjucsur()), toDigit(t.getTomsyasur())}));
    });
    // //明細は'mapRow'に'AzaiList_1'という名前で保持されてます。
    // ArrayList rows = (ArrayList)fmForm.getMapRow("AzaiList_1");
    //
    // int index = 0;
    // for (Iterator iter = rows.iterator(); iter.hasNext(); index++) {
    //
    // HashMap row = (HashMap) iter.next();
    //
    // addln(createStringSet(
    // new String[]{
    // toText(row.get("hjiNm2")), //倉庫
    // toText(row.get("syaCod")), //Ｓ
    // toText(row.get("cchFlg")), //Ｃ
    // toDigit(row.get("zaiSuu")), //在庫数
    // toDigit(row.get("syaKnoSuu")), //可能数
    // toDigit(row.get("rsvSkoSum")), //リザーブ
    // toDigit(row.get("jucZan")), //注残
    // toDigit(row.get("sinIntJucSuu")), //受注数
    // toDigit(row.get("sinIntSyaSuu")), //出荷数
    // toDigit(row.get("sekZana")), //積送
    // toDigit(row.get("kdaZan")), //貸出残
    // toDigit(row.get("mrgSkoSum")), //未引当
    // toDigit(row.get("todJucSuu")), //受注数
    // toDigit(row.get("todSyaSuu")), //出荷数
    // toDigit(row.get("tomJucSuu")), //受注数
    // toDigit(row.get("tomSyaSuu")) //出荷数
    // }
    // ));
    // }
  }
}
