package jp.co.jdsnet.common.domain.entity.syseve;

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
 * スタックコントロールEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedStackControlEntity implements EntityInterface {

  // 永続属性 ↓
  /** 入力日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int inpdte = 0;

  /** ＣＰＵＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String cpuid = "";

  /** 端末ＩＤ */
  @Keyfield(index = 3)
  @Builder.Default
  private String tmlid = "";

  /** スタックＮＯ */
  @Keyfield(index = 4)
  @Builder.Default
  private String stano = "";

  /** 場所コード */
  @Keyfield(index = 5)
  @Builder.Default
  private String bshcod = "";

  /** ＳＥＱ */
  @Keyfield(index = 6)
  @Builder.Default
  private int seq = 0;

  /** トランフルコード */
  @Builder.Default
  private String trnfulcod = "";

  /** スタック解除日付 */
  @Builder.Default
  private int stakjydte = 0;

  /** スタック解除済フラグ */
  @Builder.Default
  private String stakjyzflg = "0";

  /** スタック分類区分 */
  @Builder.Default
  private String stabunkbn = "";

  /** スタックソートコード */
  @Builder.Default
  private String stasrtcod = "";

  /** 先サービスＩＤ */
  @Builder.Default
  private String saksvcid = "";

  /** 検索キー */
  @Builder.Default
  private String kenkey = "";

  /** 削除フラグ */
  @Builder.Default
  private String delflg = "0";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
