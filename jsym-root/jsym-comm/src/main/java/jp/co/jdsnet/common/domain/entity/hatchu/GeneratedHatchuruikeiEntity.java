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
 * 発注累計Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHatchuruikeiEntity implements EntityInterface {

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

  /** 本盤発注数量累計 */
  @Builder.Default
  private int honhacsurrui = 0;

  /** 本盤入荷数量累計 */
  @Builder.Default
  private int honnyasurrui = 0;

  /** 当月本盤発注数量 */
  @Builder.Default
  private int tomhonhacsur = 0;

  /** 当月本盤入荷数量 */
  @Builder.Default
  private int tomhonnyasur = 0;

  /** 償却経費当月数量 */
  @Builder.Default
  private int skykehtomsuu = 0;

  /** 償却経費累計数量 */
  @Builder.Default
  private int skykehruisuu = 0;

  /** サンプル発注数量累計 */
  @Builder.Default
  private int smphacsurrui = 0;

  /** サンプル入荷数量累計 */
  @Builder.Default
  private int smpnyasurrui = 0;

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
