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
 * 新譜受注実績　テリトリー別サマリーEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuJuchuJissekiTerritoryBetsuSummaryEntity implements EntityInterface {

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

  /** 新譜番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String sinbng = "";

  /** 新譜行番号 */
  @Keyfield(index = 5)
  @Builder.Default
  private int singyb = 0;

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** 売上グループコード */
  @Builder.Default
  private int urigrpcod = 0;

  /** 新譜確注数量 */
  @Builder.Default
  private int sinkcysur = 0;

  /** 新譜確注数量（一般店） */
  @Builder.Default
  private int sinkcysuripn = 0;

  /** 新譜確注数量（貸レ店） */
  @Builder.Default
  private int sinkcysurkre = 0;

  /** 新譜追加数量 */
  @Builder.Default
  private int sintuisur = 0;

  /** 新譜追加数量（一般店） */
  @Builder.Default
  private int sintuisuripn = 0;

  /** 新譜追加数量（貸レ店） */
  @Builder.Default
  private int sintuisurkre = 0;

  /** 新譜受注金額 */
  @Builder.Default
  private long sinjuckin = 0L;

  /** 新譜受注金額（一般店） */
  @Builder.Default
  private long sinjuckinipn = 0L;

  /** 新譜受注金額（貸レ店） */
  @Builder.Default
  private long sinjuckinkre = 0L;

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
