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
 * 発注予定Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHatchuYoteiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 発注予定リラティブＮＯ */
  @Keyfield(index = 2)
  @Builder.Default
  private String hacyterelno = "";

  /** 発注予定入力日付 */
  @Keyfield(index = 3)
  @Builder.Default
  private int hacyteinpdte = 0;

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 発注種別区分 */
  @Builder.Default
  private String hacsybkbn = "";

  /** 生産仕入区分 */
  @Builder.Default
  private String prdsirkbn = "";

  /** 市販特販品区分 */
  @Builder.Default
  private String shnthnhinkbn = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** セット数 */
  @Builder.Default
  private int setsuu = 0;

  /** サンプルサイン */
  @Builder.Default
  private String smpsgn = "";

  /** 発注新譜旧譜区分 */
  @Builder.Default
  private String hacsinkyukbn = "";

  /** ジャケット納期 */
  @Builder.Default
  private int jaknki = 0;

  /** ジャケット発注先コード */
  @Builder.Default
  private String jakhacsakcod = "";

  /** 受注．発注品サイン */
  @Builder.Default
  private String juchachin = "";

  /** メーカー分類コード */
  @Builder.Default
  private String mkrbuncod = "";

  /** カテゴリーコード */
  @Builder.Default
  private String ctgcod = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** 副資材管理コード */
  @Builder.Default
  private String fuksziknrcod = "";

  /** 発注数量 */
  @Builder.Default
  private int hacsur = 0;

  /** 納期 */
  @Builder.Default
  private int nki = 0;

  /** 発注先コード */
  @Builder.Default
  private String hacsakcod = "";

  /** 入荷先コード */
  @Builder.Default
  private String nyasakcod = "";

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

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
