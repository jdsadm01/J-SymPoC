package jp.co.jdsnet.common.logic;

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
}
