package jp.co.jdsnet.master.domain.service;

import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.master.domain.dto.NohsakEntryDTO;

public interface NohsakEntryService {

  /**
   * 初期処理
   * 
   * @param vo
   * @return
   * @throws Exception
   */
  public NohsakEntryDTO init(UserInfoVO vo) throws Exception;

  /**
   * ゲーム共同得意先を検索する
   * 
   * @param dto
   * @return
   * @throws Exception
   */
  public NohsakEntryDTO searchByTokcod(NohsakEntryDTO dto) throws Exception;

  /**
   * ゲーム共同得意先から得意先を検索する
   * 
   * @param dto
   * @return
   * @throws Exception
   */
  public NohsakEntryDTO searchByGkyTokcod(NohsakEntryDTO dto) throws Exception;

  /**
   * 明細チェック
   * 
   * @param dto
   * @return
   * @throws Exception
   */
  public NohsakEntryDTO checkDetail(NohsakEntryDTO dto) throws Exception;

  /**
   * データ更新
   * 
   * @param dto
   * @return
   * @throws Exception
   */
  public NohsakEntryDTO update(NohsakEntryDTO dto) throws Exception;
}
