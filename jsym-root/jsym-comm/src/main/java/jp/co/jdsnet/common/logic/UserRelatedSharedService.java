package jp.co.jdsnet.common.logic;

/**
 * ユーザー関連の共通処理サービス
 *
 * @author r-matsumura
 *
 */
public interface UserRelatedSharedService {

  /**
   * NOテーブルから値を取得する
   *
   * @param usrid ユーザーID
   * @param bun 分類
   * @param prckbn 値を＋１するかどうか、DB更新するかどうか
   * @return prckbnに基づいたカレントNo
   */
  public int getCurrentNo(String usrid, String bun, CurrentNoGetType prckbn);

  enum CurrentNoGetType {
    /** 取得した値そのまま かつ DB更新無し */
    ASISVALUE_NOUPDATE,
    /** 取得した値＋１ かつ DB更新有り */
    VALUEPLUSONE_UPDATE,
    /** 取得した値そのまま かつ DB更新有り */
    ASISVALUE_UPDATE
  }
}
