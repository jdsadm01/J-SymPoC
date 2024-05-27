package jp.co.jdsnet.common.logic;

import java.util.Map;
import java.util.NoSuchElementException;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;

/**
 * 記号番号関連の共通サービス
 *
 * @author r-matsumura
 *
 */
public interface KigbngRelatedSharedService {

  /**
   * 品番を取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kigbng 入力値の記号番号
   * @return 取得した品番のEntity
   * @throws NoSuchElementException 該当データ無し
   * @throws Exception 予期せぬエラー
   */
  public HinbanEntity getHinban(String daikaiskbcod, String kigbng)
      throws NoSuchElementException, Exception;

  /**
   * 品番を取得する（受託チェック）
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kaiskbcod 会社識別コード
   * @param kigbng 入力値の記号番号
   * @return 取得した品番のEntity
   * @throws NoSuchElementException 該当データ無し
   * @throws Exception 予期せぬエラー
   */
  public HinbanEntity getHinban(String daikaiskbcod, String kaiskbcod, String kigbng)
      throws NoSuchElementException, Exception;

  /**
   * 13桁の記号番号を生成する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kigbng 入力値の記号番号
   * @return 変換した記号番号
   * @throws Exception 予期せぬエラー
   */
  public String makeKigBng(String daikaiskbcod, String kigbng) throws Exception;

  /**
   * 入庫予定日、入庫予定数を取得する
   *
   * <p>
   * 入庫予定日 キー：nki<br>
   * 入庫予定数 キー：hacsuu
   * 
   * @param daikaiskbcod 代表会社識別コード
   * @param kaiskbcod 会社識別コード
   * @param kigbng 記号番号
   * @return 入庫予定日、入庫予定数 データ無しの場合は空で返す
   * @throws Exception
   */
  public Map<String, Integer> getNkiHacSuu(String daikaiskbcod, String kaiskbcod, String kigbng)
      throws Exception;

  /**
   * 仕切単価決定処理
   * <p>
   * PCH社個社仕様：品番得意先掛率単価マスタの登録有無により通常の算出方法を使用するかどうか分岐する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kigbng 記号番号
   * @param tokcod 得意先コード
   * @param skrkrt 仕切掛率
   * @return 仕切単価
   * @throws Exception
   */
  public double getSkrtan(String daikaiskbcod, String kigbng, String tokcod, double skrkrt)
      throws Exception;
}
