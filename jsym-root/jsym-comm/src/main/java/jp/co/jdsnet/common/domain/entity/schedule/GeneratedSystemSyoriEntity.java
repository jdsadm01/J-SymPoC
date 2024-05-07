package jp.co.jdsnet.common.domain.entity.schedule;

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
 * システム処理Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSystemSyoriEntity implements EntityInterface {

  // 永続属性 ↓
  /** システム処理ＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String sysprcid = "";

  /** システム処理名 */
  @Builder.Default
  private String sysprcnm = "";

  /** ノード区分 */
  @Builder.Default
  private String nodkbn = "";

  /** 親ノードＩＤ */
  @Builder.Default
  private String oyanodid = "";

  /** 登録可能日区分 */
  @Builder.Default
  private String trkkandtekbn = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** システム処理名略称 */
  @Builder.Default
  private String sysprcnmryk = "";

}
