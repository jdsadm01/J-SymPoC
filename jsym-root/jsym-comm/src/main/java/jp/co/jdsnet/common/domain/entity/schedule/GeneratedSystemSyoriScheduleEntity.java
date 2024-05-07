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
 * システム処理スケジュールEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSystemSyoriScheduleEntity implements EntityInterface {

  // 永続属性 ↓
  /** スケジュールＳＥＱ */
  @Keyfield(index = 1)
  @Builder.Default
  private int schseq = 0;

  /** スケジュール日付 */
  @Builder.Default
  private int schdte = 0;

  /** システム処理ＩＤ */
  @Builder.Default
  private String sysprcid = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** ユーザー分類 */
  @Builder.Default
  private String usrbun = "";

  /** スケジュール詳細 */
  @Builder.Default
  private String schssi = "";

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
