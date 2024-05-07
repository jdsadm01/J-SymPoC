package jp.co.jdsnet.common.domain.entity.tokuisaki;

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
 * 与信限度Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedYoshingendoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** 当勘新譜売上金額 */
  @Builder.Default
  private long tknsinurikin = 0L;

  /** 翌勘新譜売上金額 */
  @Builder.Default
  private long yknsinurikin = 0L;

  /** 翌々勘新譜売上金額 */
  @Builder.Default
  private long y2knsinurikin = 0L;

  /** 翌々々勘新譜売上金額 */
  @Builder.Default
  private long y3knsinurikin = 0L;

  /** 当勘旧譜売上金額 */
  @Builder.Default
  private long tknkyuurikin = 0L;

  /** 翌勘旧譜売上金額 */
  @Builder.Default
  private long yknkyuurikin = 0L;

  /** 翌々勘旧譜売上金額 */
  @Builder.Default
  private long y2knkyuurikin = 0L;

  /** 翌々々勘旧譜売上金額 */
  @Builder.Default
  private long y3knkyuurikin = 0L;

  /** 当月返品金額 */
  @Builder.Default
  private long tomhpnkin = 0L;

  /** 当月入金金額 */
  @Builder.Default
  private long tomnknkin = 0L;

  /** 当月返金金額 */
  @Builder.Default
  private long tomhnkkin = 0L;

  /** 当月値引金額 */
  @Builder.Default
  private long tomnbikin = 0L;

  /** 貸出残金額 */
  @Builder.Default
  private long kdazankin = 0L;

  /** 売上集約当勘新譜売上金額 */
  @Builder.Default
  private long usytknsinurikin = 0L;

  /** 売上集約翌勘新譜売上金額 */
  @Builder.Default
  private long usyyknsinurikin = 0L;

  /** 売上集約翌々勘新譜売上金額 */
  @Builder.Default
  private long usyy2knsinurikin = 0L;

  /** 売上集約翌々々勘新譜売上金額 */
  @Builder.Default
  private long usyy3knsinurikin = 0L;

  /** 売上集約当勘旧譜売上金額 */
  @Builder.Default
  private long usytknkyuurikin = 0L;

  /** 売上集約翌勘旧譜売上金額 */
  @Builder.Default
  private long usyyknkyuurikin = 0L;

  /** 売上集約翌々勘旧譜売上金額 */
  @Builder.Default
  private long usyy2knkyuurikin = 0L;

  /** 売上集約翌々々勘旧譜売上金額 */
  @Builder.Default
  private long usyy3knkyuurikin = 0L;

  /** 売上集約当月返品金額 */
  @Builder.Default
  private long usytomhpnkin = 0L;

  /** 売上集約当月入金金額 */
  @Builder.Default
  private long usytomnknkin = 0L;

  /** 売上集約当月返金金額 */
  @Builder.Default
  private long usytomhnkkin = 0L;

  /** 売上集約当月値引金額 */
  @Builder.Default
  private long usytomnbikin = 0L;

  /** 売上集約貸出残金額 */
  @Builder.Default
  private long usykdazankin = 0L;

  /** 前回請求金額 */
  @Builder.Default
  private long zkaseikin = 0L;

  /** 前回締切金額 */
  @Builder.Default
  private long zkasmkkin = 0L;

  /** 与信限度額 */
  @Builder.Default
  private long ygdgak = 0L;

  /** 与信限度オーバーフラグ */
  @Builder.Default
  private String ygdovrflg = "0";

  /** その他債権金額 */
  @Builder.Default
  private int etcsaikin = 0;

  /** その他債務金額 */
  @Builder.Default
  private int etcsamkin = 0;

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
