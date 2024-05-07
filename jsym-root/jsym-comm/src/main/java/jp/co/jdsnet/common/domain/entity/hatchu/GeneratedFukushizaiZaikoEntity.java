package jp.co.jdsnet.common.domain.entity.hatchu;

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
 * 副資材在庫Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedFukushizaiZaikoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private String kigbng = "";

  /** 発注種別区分 */
  @Keyfield(index = 3)
  @Builder.Default
  private String hacsybkbn = "";

  /** セット記号 */
  @Builder.Default
  private String setkig = "";

  /** 部品区分 */
  @Builder.Default
  private String bhnkbn = "";

  /** 部品枝番 */
  @Builder.Default
  private String bhneda = "";

  /** メーカー分類コード */
  @Builder.Default
  private String mkrbuncod = "";

  /** 本盤在庫数量 */
  @Builder.Default
  private int honzaisur = 0;

  /** 本盤在庫訂正数量（＋） */
  @Builder.Default
  private int honzaiteisurpls = 0;

  /** 本盤在庫訂正数量（－） */
  @Builder.Default
  private int honzaiteisurmns = 0;

  /** 本盤仮引当数量 */
  @Builder.Default
  private int honkhasur = 0;

  /** サンプル在庫数量 */
  @Builder.Default
  private int smpzaisur = 0;

  /** サンプル在庫訂正数量（＋） */
  @Builder.Default
  private int smpzaiteisurpls = 0;

  /** サンプル在庫訂正数量（－） */
  @Builder.Default
  private int smpzaiteisurmns = 0;

  /** サンプル仮引当数量 */
  @Builder.Default
  private int smpkhasur = 0;

  /** 発注先コード */
  @Builder.Default
  private String hacsakcod = "";

  /** 納期１ */
  @Builder.Default
  private int nki1 = 0;

  /** 発注残数（納期１） */
  @Builder.Default
  private int hacznsnki1 = 0;

  /** 納期２ */
  @Builder.Default
  private int nki2 = 0;

  /** 発注残数（納期２） */
  @Builder.Default
  private int hacznsnki2 = 0;

  /** 納期３ */
  @Builder.Default
  private int nki3 = 0;

  /** 発注残数（納期３以降） */
  @Builder.Default
  private int hacznsnki3ik = 0;

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
