package jp.co.jdsnet.common.domain.entity.syseve;

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
 * バッチワークデータEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedBatchWorkDataEntity implements EntityInterface {

  // 永続属性 ↓
  /** バッチＳＥＱ */
  @Keyfield(index = 1)
  @Builder.Default
  private int batseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 2)
  @Builder.Default
  private int seq = 0;

  /** ジョブＩＤ */
  @Builder.Default
  private String jobid = "";

  /** バッチワークデータ本体 */
  @Builder.Default
  private String batwkdtabdy = "";

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
