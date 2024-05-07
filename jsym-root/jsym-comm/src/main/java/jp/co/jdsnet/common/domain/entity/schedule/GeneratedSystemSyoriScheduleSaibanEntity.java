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
 * システム処理スケジュール採番Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSystemSyoriScheduleSaibanEntity implements EntityInterface {

  // 永続属性 ↓
  /** 採番ＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String sibid = "";

  /** 代表会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String daikaiskbcod = "";

  /** ユーザー分類 */
  @Keyfield(index = 3)
  @Builder.Default
  private String usrbun = "";

  /** カレントＮＯ */
  @Builder.Default
  private int curno = 0;

  /** 上限ＮＯ */
  @Builder.Default
  private int jogno = 0;

  /** 下限ＮＯ */
  @Builder.Default
  private int kagno = 0;

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
