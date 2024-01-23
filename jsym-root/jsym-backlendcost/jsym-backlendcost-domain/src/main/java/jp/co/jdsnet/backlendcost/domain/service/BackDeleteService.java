package jp.co.jdsnet.backlendcost.domain.service;

import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;

public interface BackDeleteService {

  /** 
   * 画面OPEN時の処理
   * @param daikaiskbcod
   * @param usrbun
   * @return
   *  */
  public BackDeleteDTO init(String daikaiskbcod, String usrbun);

  /**
   * 検索条件入力チェック処理
   * @param dto
   * @return
   * */
  public BackDeleteDTO search(BackDeleteDTO dto) throws Exception;

  /**
   * 次100件照会処理
   * 
   * @param dto
   * @return
   */
  public BackDeleteDTO next100Search(BackDeleteDTO dto, int pageNo, String Key) throws Exception;
  
  /**
   * 削除入力チェック処理
   * @param dto
   * @return
   * */
  public BackDeleteDTO chkInputDeleteData(BackDeleteDTO dto) throws Exception;
  
  /**
   * 送信処理
   * @param dto
   * @return
   * */
  public void submit(BackDeleteDTO dto) throws Exception;
  

  /**
   * 部分初期化処理
   * @param dto
   * @return
   * */
  public BackDeleteDTO initPartOfForm(String daikaiskbcod, String usrbun) throws Exception;

  /**
   * 戻る
   * @param dto
   * @return
   */
  public BackDeleteDTO back(BackDeleteDTO dto) throws Exception;

}
