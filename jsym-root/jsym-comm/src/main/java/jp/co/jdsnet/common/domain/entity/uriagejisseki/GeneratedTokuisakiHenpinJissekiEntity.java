package jp.co.jdsnet.common.domain.entity.uriagejisseki;

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
 * 得意先返品実績Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTokuisakiHenpinJissekiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** 返品グループコード */
  @Keyfield(index = 3)
  @Builder.Default
  private int hpngrpcod = 0;

  /** 当月返品枠内受入金額 */
  @Builder.Default
  private int tomhwnukekin = 0;

  /** 当月返品枠外（不良品）受入金額 */
  @Builder.Default
  private int tomhwgfryukekin = 0;

  /** 当月返品枠外（廃盤）受入金額 */
  @Builder.Default
  private int tomhwghibukekin = 0;

  /** 当月返品枠外（その他）受入金額 */
  @Builder.Default
  private int tomhwgetcukekin = 0;

  /** 当月無条件返送金額 */
  @Builder.Default
  private int tommjnhnskin = 0;

  /** 当月枠オーバー返送金額 */
  @Builder.Default
  private int tomwkuovrhnskin = 0;

  /** 当月売上金額 */
  @Builder.Default
  private long tomurikin = 0L;

  /** 当月返品金額 */
  @Builder.Default
  private long tomhpnkin = 0L;

  /** 当月翌勘売上金額 */
  @Builder.Default
  private long tomyknurikin = 0L;

  /** 前月売上金額 */
  @Builder.Default
  private long znmurikin = 0L;

  /** 前月返品金額 */
  @Builder.Default
  private long znmhpnkin = 0L;

  /** 前月翌勘売上金額 */
  @Builder.Default
  private long znmyknurikin = 0L;

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
