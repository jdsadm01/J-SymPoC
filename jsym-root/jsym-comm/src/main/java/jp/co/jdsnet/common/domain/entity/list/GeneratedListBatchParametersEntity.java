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
 * 帳票バッチパラメータテーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedListBatchParametersEntity implements EntityInterface {

  // 永続属性 ↓
  /** 帳票データファイルＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String chydtafleid = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 帳票ＩＤ */
  @Builder.Default
  private String chyid = "";

  /** 処理区分 */
  @Builder.Default
  private String prckbn = "";

  /** ユーザーＩＤ */
  @Builder.Default
  private String usrid = "";

  /** 作成担当者 */
  @Builder.Default
  private String ssetnt = "";

  /** 作成コメント */
  @Builder.Default
  private String ssecmt = "";

  /** 作成代表会社 */
  @Builder.Default
  private String ssedaikai = "";

  /** 作成会社 */
  @Builder.Default
  private String ssekai = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** 終了フラグ */
  @Builder.Default
  private String endflg = "0";

  /** 日次／月次区分 */
  @Builder.Default
  private String dlymlykbn = "";

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 作成予約日付 */
  @Builder.Default
  private int sskyykdte = 0;

}
