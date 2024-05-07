package jp.co.jdsnet.common.logic;

import java.util.NoSuchElementException;
import jp.co.jdsnet.common.domain.entity.tokuisaki.DsEntity.Sinkyuusekbn;
import jp.co.jdsnet.common.domain.vo.TokuisakiAndDsVO;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;;

/**
 * 得意先関連の共通処理サービス
 *
 * @author r-matsumura
 *
 */
public interface TokuisakiRelatedSharedService {

  /**
   * 共通得意先・各社得意先・DSのデータを取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param tokcod 得意先コード（８桁変換不要）
   * @param dscod DSコード
   * @return ３種のEntityがセットされたVO
   * @throws NoSuchElementException 該当データ無し
   * @throws Exception 予期せぬエラー
   */
  public TokuisakiAndDsVO getTokuisakiAndDsFullData(String daikaiskbcod, String tokcod,
      String dscod) throws NoSuchElementException, Exception;

  /**
   * 共通得意先のデータを取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param tokcod 得意先コード（８桁変換不要）
   * @return 共通得意先のEntityがセットされたVO
   * @throws NoSuchElementException 該当データ無し
   * @throws Exception 予期せぬエラー
   */
  public TokuisakiAndDsVO getKyotsuTokuisaki(String daikaiskbcod, String tokcod)
      throws NoSuchElementException, Exception;

  /**
   * 各社得意先のデータを取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param tokcod 得意先コード（８桁変換不要）
   * @return 各社得意先のEntityがセットされたVO
   * @throws NoSuchElementException 該当データ無し
   * @throws Exception 予期せぬエラー
   */
  public TokuisakiAndDsVO getKakushaTokuisaki(String daikaiskbcod, String tokcod)
      throws NoSuchElementException, Exception;

  /**
   * DSのデータを取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param tokcod 得意先コード（８桁変換不要）
   * @param dscod DSコード
   * @return DSのEntityがセットされたVO
   * @throws NoSuchElementException 該当データ無し
   * @throws Exception 予期せぬエラー
   */
  public TokuisakiAndDsVO getDs(String daikaiskbcod, String tokcod, String dscod)
      throws NoSuchElementException, Exception;

  /**
   * 共通得意先・DSのデータを取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param tokcod 得意先コード（８桁変換不要）
   * @param dscod DSコード
   * @return 共通得意先とDSのEntityがセットされたVO
   * @throws NoSuchElementException 該当データ無し
   * @throws Exception 予期せぬエラー
   */
  public TokuisakiAndDsVO getKyotsuAndDs(String daikaiskbcod, String tokcod, String dscod)
      throws NoSuchElementException, Exception;

  /**
   * 指定のトランに対してDSの使用可否（新譜旧譜）をチェックする
   *
   * @param sinkyuusekbn 新譜旧譜使用区分
   * @param trncod トランコード
   * @return 使用可の場合はtrue
   */
  public boolean checkDsBySinkyuusekbn(Sinkyuusekbn sinkyuusekbn, Trncod trncod);

  /**
   * 得意先コードを８桁に変換する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param tokcod 得意先コード
   * @return ８桁変換後の得意先コード
   * @throws Exception 予期せぬエラー
   */
  public String convertTokcod8kt(String daikaiskbcod, String tokcod) throws Exception;

}
