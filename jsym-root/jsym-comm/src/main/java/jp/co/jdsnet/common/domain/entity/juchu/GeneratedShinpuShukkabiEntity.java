package jp.co.jdsnet.common.domain.entity.juchu;

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
 * 新譜出荷日Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuShukkabiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 発売日 */
  @Keyfield(index = 2)
  @Builder.Default
  private int hbidte = 0;

  /** 新譜追加受注フラグ */
  @Keyfield(index = 3)
  @Builder.Default
  private String sintuijucflg = "0";

  /** 出荷日付コード群 */
  @Builder.Default
  private String syadtecodgun = "";

  /** 出荷日付群 */
  @Builder.Default
  private String syadtegun = "";

  /** 配送日付コード群 */
  @Builder.Default
  private String hsodtecodgun = "";

  /** 配送日付群 */
  @Builder.Default
  private String hsodtegun = "";

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
