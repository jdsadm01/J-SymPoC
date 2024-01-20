package jp.co.jdsnet.backlendcost.webapp.copydata;

import jp.co.jdsnet.backlendcost.webapp.form.BackDeleteForm;
import jp.co.jdsnet.base.webapp.parts.CommonClipboardData;

public class BackDeleteCBData extends CommonClipboardData<BackDeleteForm> {

  @Override
  protected void createClipboardData(BackDeleteForm form) {

    // ヘッダー
    editHeader(form);

    // ヘッダー
    editHinInfo(form);

    // ヘッダー
    editDetailHeadline(form);

    // ヘッダー
    editDetail(form);

  }

  /**
   * 
   * */
  private void editHeader(BackDeleteForm form) {

  }

  /**
   * 
   * */
  private void editHinInfo(BackDeleteForm form) {

  }

  /**
   * 
   * */
  private void editDetailHeadline(BackDeleteForm form) {

  }

  /**
   * 
   * */
  private void editDetail(BackDeleteForm form) {

    form.getDetailList().forEach(t -> {
      addln(createStringSet(
          new String[] {toText(t.getNo()), toText(t.getSkocod()), toText(t.getKigbng()),
              toDigit(t.getChzsur()), toText(t.getHbidte()), toText(t.getChzdeldte()),
              toText(t.getUrisyytencod()), toText(t.getTokcod()), toText(t.getDscod()),
              toText(t.getToknm()), toText(t.getJucdte()), toText(t.getChzdeldte())}));
    });

  }

}
