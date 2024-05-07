package jp.co.jdsnet.common.logic;

import java.time.format.DateTimeParseException;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity;
import jp.co.jdsnet.common.utils.GlobalConstants.Rmcod;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;
import jp.co.jdsnet.common.utils.GlobalConstants.Usrbun;

public interface CommonCheckSharedService {

  enum ServiceTime {
    ONLINE, SUBTIME, TIMEOUT
  }

  /**
   * サービス時間の判定を行う
   *
   * @param daikaiskbcod ユーザー代表会社識別コード
   * @param usrbun ユーザー分類
   * @param gmnid チェック対象の画面ID
   * @param gmnseq チェック対象の画面SEQ
   * @param gmnkbn チェック対象の画面区分
   * @return サービス時間の判定結果
   */
  public ServiceTime checkServiceTime(String daikaiskbcod, String usrbun, String gmnid,
      String gmnseq, EventEntity.Gmnkbn gmnkbn);

  /**
   * MSコードが利用可能かどうかをチェックする。 特定MSコードは利用不可の判定とする。
   *
   * @param mscod チェック対象のMSコード
   * @param daikaiskbcod 代表会社識別コード
   * @return 利用可能な場合true
   */
  public boolean isUsableMscod(String mscod, String daikaiskbcod);

  /**
   * MSコードが利用可能かどうかをチェックする。
   *
   * @param mscod チェック対象のMSコード
   * @param daikaiskbcod 代表会社識別コード
   * @return 利用可能な場合true
   */
  public boolean isUsableAllMscod(String mscod, String daikaiskbcod);

  /**
   * 仕向地コードが利用可能かチェックする。
   *
   * @param smtcod チェック対象の仕向地コード
   * @param daikaiskbcod 代表会社識別コード
   * @param trncod 利用トラン
   * @return 利用可能な場合true
   */
  public boolean isUsableSmtcod(String smtcod, String daikaiskbcod, Trncod trncod);

  /**
   * トランコードが利用可能かチェックする。
   *
   * @param trncod チェック対象のトランコード
   * @param daikaiskbcod 代表会社識別コード
   * @return 利用可能な場合true
   */
  public boolean isUsableTrncod(Trncod trncod, String daikaiskbcod);

  /**
   * 場所コードが利用可能かチェックする。
   *
   * @param bshcod チェック対象の場所コード
   * @param daikaiskbcod 代表会社識別コード
   * @param usrbun ユーザー分類
   * @return 利用可能な場合true
   */
  public boolean isUsableBshcod(String bshcod, String daikaiskbcod, Usrbun usrbun);

  /**
   * 貸出区分が利用可能かチェックする。
   *
   * @param kdakbn チェック対象の貸出区分
   * @param daikaiskbcod 代表会社識別コード
   * @param trncod 利用トラン
   * @return 利用可能な場合true
   */
  public boolean isUsableKdakbn(String kdakbn, String daikaiskbcod, Trncod trncod);

  /**
   * 管理区分が利用可能かチェックする。
   *
   * @param knrkbn チェック対象の管理区分
   * @param daikaiskbcod 代表会社識別コード
   * @param trncod 利用トラン
   * @return 利用可能な場合true
   */
  public boolean isUsableKnrkbn(String knrkbn, String daikaiskbcod, Trncod trncod);

  /**
   * リマークが利用可能かチェックする。（見出用）
   *
   * @param rmcod チェック対象のリマークコード
   * @param trncod 利用トラン
   * @param checkKey 条件テーブル検索時にトランの後ろに付与するキー値
   * @return 利用可能な場合true
   */
  public boolean isUsableRmcodForHeader(Rmcod rmcod, Trncod trncod, String checkKey);

  /**
   * リマークが利用可能かチェックする。（明細用）
   *
   * @param rmcod チェック対象のリマークコード
   * @param rmHeader ヘッダーリマークコード
   * @param trncod 利用トラン
   * @param checkKey 条件テーブル検索時にトランの後ろに付与するキー値
   * @return 利用可能な場合true
   */
  public boolean isUsableRmcodForDetail(Rmcod rmcod, Rmcod rmHeader, Trncod trncod,
      String checkKey);

  /**
   * 基準日から翌稼働日を取得する。
   *
   * @param baseDte8kt 基準日８桁
   * @return 稼働日８桁
   * @throws DateTimeParseException 存在しない日付を指定した場合
   */
  public String getNextKadoDte(String baseDte8kt) throws DateTimeParseException;
}
