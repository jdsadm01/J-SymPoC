package jp.co.jdsnet.home.domain.service;

import jp.co.jdsnet.home.domain.dto.LoginDTO;

/**
 * ログインサービス
 * 
 * @author xxx
 *
 */
public interface LoginService {
  /**
   * ネットワーク識別コードを取得する
   * 
   * @param ippadr
   * @return
   */
  public String getNetwrkskbcod(String ippadr);

  /**
   * ログイン処理
   * 
   * @param dto
   * @return
   */
  public LoginDTO entry(LoginDTO dto) throws Exception;
}
