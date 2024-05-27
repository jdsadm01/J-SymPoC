package jp.co.jdsnet.common.logic;

import java.util.NoSuchElementException;
import jp.co.jdsnet.common.domain.vo.HikiateKanosuuVo;
import jp.co.jdsnet.common.utils.GlobalConstants.Rmcod;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;

/**
 * 引当可能数算出共通サービス
 *
 * @author r-matsumura
 *
 */
public interface HikiateKanoSuuCalculateService {

  /**
   * 引当可能数を算出する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kigbng 記号番号
   * @param skocodList 算出対象倉庫（サマリーしたい倉庫を指定する）
   * @param trncod トラン
   * @param rmcod リマーク
   * @param isMinus true・・・可能数がマイナス値の場合はそのまま、false・・・マイナス値になったら０とする
   * @return 算出された引当可能数VO
   * @throws NoSuchElementException マスター不整合時
   */
  public HikiateKanosuuVo getHatKnoSuu(String daikaiskbcod, String kigbng, String[] skocodList,
      Trncod trncod, Rmcod rmcod, boolean isMinus) throws NoSuchElementException;

  /**
   * 引当可能数を算出する（在庫確保数まで参照する）
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kigbng 記号番号
   * @param skocodList 算出対象倉庫（サマリーしたい倉庫を指定する）
   * @param trncod トラン
   * @param rmcod リマーク
   * @param tokcod 得意先
   * @param jucsur 受注数
   * @param isMinus true・・・可能数がマイナス値の場合はそのまま、false・・・マイナス値になったら０とする
   * @return 算出された引当可能数VO
   * @throws NoSuchElementException マスター不整合時
   */
  public HikiateKanosuuVo getHatKnoSuu(String daikaiskbcod, String kigbng, String[] skocodList,
      Trncod trncod, Rmcod rmcod, String tokcod, boolean isMinus) throws NoSuchElementException;
}
