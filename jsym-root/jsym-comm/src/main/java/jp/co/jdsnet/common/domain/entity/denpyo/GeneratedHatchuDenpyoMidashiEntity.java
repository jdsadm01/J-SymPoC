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
 * 発注伝票見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHatchuDenpyoMidashiEntity implements EntityInterface {

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

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 発注新譜旧譜区分 */
  @Builder.Default
  private String hacsinkyukbn = "";

  /** メーカー分類コード */
  @Builder.Default
  private String mkrbuncod = "";

  /** 市販特販品区分 */
  @Builder.Default
  private String shnthnhinkbn = "";

  /** サンプルサイン */
  @Builder.Default
  private String smpsgn = "";

  /** ＥＤＩ済フラグ */
  @Builder.Default
  private String edizflg = "0";

  /** ＥＤＩ日付 */
  @Builder.Default
  private int edidte = 0;

  /** ＥＤＩ時刻 */
  @Builder.Default
  private int edijkk = 0;

  /** 伝票統合入力済フラグ */
  @Builder.Default
  private String dentguinpzflg = "0";

  /** 伝票統合入力日付 */
  @Builder.Default
  private int dentguinpdte = 0;

  /** 伝票統合入力時刻 */
  @Builder.Default
  private int dentguinpjkk = 0;

  /** 伝票作成日付 */
  @Builder.Default
  private int denssedte = 0;

  /** 伝票作成時刻 */
  @Builder.Default
  private int denssejkk = 0;

  /** 伝票トラン作成済フラグ */
  @Builder.Default
  private String dentrnssezflg = "0";

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
