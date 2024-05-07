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
 * 出荷制限Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShukkaSeigenEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private String kigbng = "";

  /** 出荷制限グループコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String syasgegrpcod = "";

  /** 出荷制限数量 */
  @Builder.Default
  private int syasgesur = 0;

  /** 出荷制限期間受注数量 */
  @Builder.Default
  private int syasgekknjucsur = 0;

  /** 出荷制限期間出荷数量 */
  @Builder.Default
  private int syasgekknsyasur = 0;

  /** 出荷制限期間ＦＲＯＭ */
  @Builder.Default
  private int syasgekknfrm = 0;

  /** 出荷制限期間ＴＯ */
  @Builder.Default
  private int syasgekknto = 0;

  /** 当日受注数量 */
  @Builder.Default
  private int todjucsur = 0;

  /** 当日出荷数量 */
  @Builder.Default
  private int todsyasur = 0;

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
