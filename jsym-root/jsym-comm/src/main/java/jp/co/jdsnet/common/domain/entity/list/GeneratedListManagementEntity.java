package jp.co.jdsnet.common.domain.entity.list;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import jp.co.jdsnet.common.domain.entity.Keyfield;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 帳票管理テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedListManagementEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String kaiskbcod = "";

  /** 帳票ＩＤ */
  @Keyfield(index = 3)
  @Builder.Default
  private String chyid = "";

  /** 帳票管理№ */
  @Keyfield(index = 4)
  @Builder.Default
  private String chyknrno = "";

  /** 分割ＮＯ */
  @Keyfield(index = 5)
  @Builder.Default
  private int bktno = 0;

  /** 作成状況フラグ */
  @Builder.Default
  private String ssejyoflg = "0";

  /** データ表示フラグ */
  @Builder.Default
  private String dtahjiflg = "0";

  /** 処理区分 */
  @Builder.Default
  private String prckbn = "";

  /** 作成指示日付 */
  @Builder.Default
  private String ssesjidte = "";

  /** 作成完了日付 */
  @Builder.Default
  private String ssekrydte = "";

  /** 帳票データファイルＩＤ */
  @Builder.Default
  private String chydtafleid = "";

  /** 作成頁数 */
  @Builder.Default
  private int ssepag = 0;

  /** ユーザーＩＤ */
  @Builder.Default
  private String usrid = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** 売上分類集約パターンコード */
  @Builder.Default
  private String uribunsyyptncod = "";

  /** 登録名 */
  @Builder.Default
  private String trknm = "";

  /** 作成担当者 */
  @Builder.Default
  private String ssetnt = "";

  /** 作成コメント */
  @Builder.Default
  private String ssecmt = "";

  /** 帳票サイズ */
  @Builder.Default
  private String chysize = "";

  /** チェックフラグ */
  @Builder.Default
  private String chkflg = "0";

  /** 帳票作成処理受付日付 */
  @Builder.Default
  private int chysseukedte = 0;

  /** 帳票作成処理受付時刻 */
  @Builder.Default
  private int chysseukejkk = 0;

  /** 帳票作成処理開始日付 */
  @Builder.Default
  private int chyssesttdte = 0;

  /** 帳票作成処理開始時刻 */
  @Builder.Default
  private int chyssesttjkk = 0;

  /** 帳票作成処理終了日付 */
  @Builder.Default
  private int chysseenddte = 0;

  /** 帳票作成処理終了時刻 */
  @Builder.Default
  private int chysseendjkk = 0;

  /** 帳票作成処理ステータス */
  @Builder.Default
  private String chyssests = "";

  /** 帳票作成処理プロセスＩＤ */
  @Builder.Default
  private String chyssepid = "";

  /** 帳票作成処理エラー内容 */
  @Builder.Default
  private String chysseerr = "";

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
