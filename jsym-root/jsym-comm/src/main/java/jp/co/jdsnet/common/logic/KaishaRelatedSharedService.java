package jp.co.jdsnet.common.logic;

import java.util.List;
import java.util.NoSuchElementException;
import jp.co.jdsnet.common.domain.vo.EigyoshoSokoGroupVo;
import jp.co.jdsnet.common.domain.vo.KaishaProcDateInfo;

/**
 * 会社関連の共通処理サービス
 *
 * @author r-matsumura
 *
 */
public interface KaishaRelatedSharedService {

  /**
   * 会社クエリーコントロールテーブルから会社識別コードの一覧を取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kaiskbcod 会社識別コード
   * @param tblnm 対象テーブルID
   * @return 会社識別コードリスト
   */
	public List<String> getKaiQueryList(String daikaiskbcod, String kaiskbcod, String tblnm);

    /**
     * 営業所倉庫グループ関連の一覧を取得する。 営業所集約明細・倉庫集約明細のデータも合わせて取得する。
     *
     * @param daikaiskbcod 代表会社識別コード
     * @param kaiskbcod 会社識別コード
     * @param pnlLstId 画面リストＩＤ
     * @param pnlLstKbn 画面リスト区分
     * @param sykKbn 機能ＮＯ
     * @return 取得したデータ
     * @throws NoSuchElementException 営業所倉庫グループの登録無し
     */
    public List<EigyoshoSokoGroupVo> getEigSkoGrpList(String daikaiskbcod, String kaiskbcod,
        String gmnlstid, String gmnlstkbn, String fncno) throws NoSuchElementException;

    /**
     * 条件テーブルから処理日条件を取得する。
     *
     * @param daikaiskbcod 代表会社識別コード
     * @return 取得したデータ
     * @throws NoSuchElementException 処理日条件の登録無し
     */
    public KaishaProcDateInfo getKaishaProcDateInfo(String daikaiskbcod)
        throws NoSuchElementException;
}
