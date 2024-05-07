package jp.co.jdsnet.common.domain.entity.denpyo;

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
 * 発注伝票明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHatchuDenpyoMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String kaiskbcod = "";

  /** 発注先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String hacsakcod = "";

  /** トランコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String trncod = "";

  /** 発注伝票番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String hacdenbng = "";

  /** 伝票日付 */
  @Keyfield(index = 5)
  @Builder.Default
  private int dendte = 0;

  /** 行番号 */
  @Keyfield(index = 6)
  @Builder.Default
  private String gyb = "";

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 発注種別区分 */
  @Builder.Default
  private String hacsybkbn = "";

  /** 発注数量 */
  @Builder.Default
  private int hacsur = 0;

  /** 納期 */
  @Builder.Default
  private int nki = 0;

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** 入荷先コード */
  @Builder.Default
  private String nyasakcod = "";

  /** セット数 */
  @Builder.Default
  private int setsuu = 0;

  /** ジャケット納期 */
  @Builder.Default
  private int jaknki = 0;

  /** レーベル引当可能数量 */
  @Builder.Default
  private int lblhatkansur = 0;

  /** 製袋数量／加工納期使用区分 */
  @Builder.Default
  private String seasurkkonkiusekbn = "";

  /** 製袋引当可能数量 */
  @Builder.Default
  private int seahatkansur = 0;

  /** 加工納期 */
  @Builder.Default
  private int kkonki = 0;

  /** 未製袋引当可能数量 */
  @Builder.Default
  private int msehatkansur = 0;

  /** 発注元伝番号 */
  @Builder.Default
  private String hacmtdbng = "";

  /** 発注元伝行番号 */
  @Builder.Default
  private String hacmtdgyb = "";

  /** 発注元伝日付 */
  @Builder.Default
  private int hacmtddte = 0;

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 制作部コード */
  @Builder.Default
  private String ssbcod = "";

}
