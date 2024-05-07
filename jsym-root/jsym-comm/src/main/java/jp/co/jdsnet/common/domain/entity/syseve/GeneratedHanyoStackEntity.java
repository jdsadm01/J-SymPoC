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
 * 汎用スタックEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHanyoStackEntity implements EntityInterface {

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

  /** スタックコントロールＳＥＱ */
  @Keyfield(index = 6)
  @Builder.Default
  private int stacnlseq = 0;

  /** 受信レコード本体 */
  @Builder.Default
  private String jsnrecbdy = "";

  /** スタック解除済フラグ */
  @Builder.Default
  private String stakjyzflg = "0";

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
