package jp.co.jdsnet.backlendcost.webapp.copydata;

import jp.co.jdsnet.backlendcost.webapp.form.BackDeleteForm;
import jp.co.jdsnet.base.webapp.parts.CommonClipboardData;
import jp.co.jdsnet.common.utils.FormatUtility;

public class BackDeleteCBData extends CommonClipboardData<BackDeleteForm> {

  @Override
  protected void createClipboardData(BackDeleteForm form) {

    // ヘッダー
    editHeader(form);

    // ヘッダ2
    editHeader2(form);

    // 合計
    editTotal(form);

    enter();

    // 明細見出し
    editDetailHeadline(form);

    // 明細
    editDetail(form);

  }

  /**
   * ヘッダ
   */
  private void editHeader(BackDeleteForm form) {

    // 注残一括削除
    addln("注残一括削除");

  }

  /**
   * ヘッダ2
   */
  private void editHeader2(BackDeleteForm form) {



    add(createStringSet("label.kaiskbcod", toText(form.getKaiskbcod())));
    add(createStringSet("label.mkrbuncod", toText(form.getMkrbuncod())));
    add(createStringSet("label.skocod", toText(form.getSkocod())));
    add(createStringSet("label.kigbng", toText(form.getKigbng())));
    add(createStringSet("label.tokcod", toText(form.getTokcod())));
    add(createStringSet("label.dscod", toText(form.getDscod())));
    add(createStringSet("label.eigcod", toText(form.getEigcod())));
    add(createStringSet("label.tercod", toText(form.getTercod())));
    add(createStringSet("label.jucdtefrom", toText(form.getJucdtefrom())));
    add(createStringSet("label.jucdteto", toText(form.getJucdteto())));
    add(createStringSet("label.hbidtefrom", toText(form.getHbidtefrom())));
    add(createStringSet("label.hbidteto", toText(form.getHbidteto())));
  }

  /**
   * 合計
   */
  private void editTotal(BackDeleteForm form) {

    add(createStringSet("label.chzcnt", toText(form.getChzCnt())));
    add(createStringSet("label.chzsurTotal", toText(form.getChzsurTotal())));

  }


  /**
   * 明細見出し
   */
  private void editDetailHeadline(BackDeleteForm form) {

    addln(createStringSet(
        new String[] {("label.no"), 
            ("label.skocod"), 
            ("label.kigbng"),
            ("label.chzsur"), 
            ("label.hbidte"),
            ("label.usnjndte"),
            ("label.urisyytencod"),
            ("label.tokcod"),
            ("label.dscod"),
            ("label.toknm"),
            ("label.jucdte"),
            ("label.chzdeldte")}));
            
  }

  /**
   * 明細
   */
  private void editDetail(BackDeleteForm form) {

    form.getDetailList().forEach(t -> {
      addln(createStringSet(
          new String[] {toText(t.getNo()), toText(t.getSkocod()), toText(t.getKigbng()),
              toDigit(t.getChzsur()), toDate(FormatUtility.convertYYYYMMDD(t.getHbidte())),
              toDate(FormatUtility.convertYYYYMMDD(t.getUsnjndte())),
              toText(t.getUrisyytencod()), toText(t.getTokcod()), toText(t.getDscod()),
              toText(t.getToknm()), toDate(FormatUtility.convertYYYYMMDD(t.getJucdte())),
              toDate(FormatUtility.convertYYYYMMDD(t.getChzdeldte()))}));
    });

  }

}
