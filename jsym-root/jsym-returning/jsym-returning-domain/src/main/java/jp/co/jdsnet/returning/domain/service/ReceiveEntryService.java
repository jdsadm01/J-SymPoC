package jp.co.jdsnet.returning.domain.service;

import jp.co.jdsnet.returning.domain.dto.ReceiveEntryDTO;
import jp.co.jdsnet.returning.domain.dto.ReceiveEntryDetailDTO;

public interface ReceiveEntryService {

  /**
   * 画面表示の初期処理を行う
   * @return
   */
  public ReceiveEntryDTO init(String daikaiskbcod, String usrbun);
  
  /**
   * 見出の入力チェックを行う
   * @param dto
   * @return
   */
  public ReceiveEntryDTO checkHeader(ReceiveEntryDTO dto) throws Exception;

  /**
   * 明細の入力チェックを行う
   * @param dto
   * @return
   */
  public ReceiveEntryDTO checkDetail(ReceiveEntryDTO dto) throws Exception;

  /**
   * 品番チェックを行う
   * @param dto
   * @return
   */
  public ReceiveEntryDetailDTO checkHinban(ReceiveEntryDetailDTO dto) throws Exception;

  /**
   * エントリー登録
   * @param dto
   * @return
   */
  public void submit(ReceiveEntryDTO dto) throws Exception;
}
