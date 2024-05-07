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
 * テリトリー別売上Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTerritorybetsuUriageEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 営業所コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String tercod = "";

  /** 売上グループコード */
  @Keyfield(index = 4)
  @Builder.Default
  private int urigrpcod = 0;

  /** 売上目標 */
  @Builder.Default
  private String urimok = "";

  /** 当日新譜初月売上金額 */
  @Builder.Default
  private int todsinsgturikin = 0;

  /** 当日旧譜売上金額 */
  @Builder.Default
  private int todkyuurikin = 0;

  /** 当日返品金額 */
  @Builder.Default
  private long todhpnkin = 0L;

  /** 当月売上金額 */
  @Builder.Default
  private long tomurikin = 0L;

  /** 当月新譜確注売上金額 */
  @Builder.Default
  private long tomsinkcyurikin = 0L;

  /** 当月売上新譜バック */
  @Builder.Default
  private long tomurisinbak = 0L;

  /** 当月新譜初月売上金額 */
  @Builder.Default
  private long tomsinsgturikin = 0L;

  /** 当月期内新譜売上金額 */
  @Builder.Default
  private long tomknisinurikin = 0L;

  /** 当月旧譜売上金額 */
  @Builder.Default
  private long tomkyuurikin = 0L;

  /** 当月返品金額 */
  @Builder.Default
  private long tomhpnkin = 0L;

  /** 当月新譜確注返品金額 */
  @Builder.Default
  private long tomsinkcyhpnkin = 0L;

  /** 当月新譜初月返品金額 */
  @Builder.Default
  private long tomsinsgthpnkin = 0L;

  /** 当月新譜旧譜返品金額 */
  @Builder.Default
  private long tomsinkyuhpnkin = 0L;

  /** 期間売上金額 */
  @Builder.Default
  private long kknurikin = 0L;

  /** 期間新譜確注売上金額 */
  @Builder.Default
  private long kknsinkcyurikin = 0L;

  /** 期間新譜初月売上金額 */
  @Builder.Default
  private long kknsinsgturikin = 0L;

  /** 期間期内新譜売上金額 */
  @Builder.Default
  private long kknknisinurikin = 0L;

  /** 期間返品金額 */
  @Builder.Default
  private long kknhpnkin = 0L;

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
