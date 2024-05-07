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
 * 月次システム処理スケジュール状況Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedGetsujiSystemSyoriScheduleJokyoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** ユーザー分類 */
  @Keyfield(index = 2)
  @Builder.Default
  private String usrbun = "";

  /** 年月度 */
  @Keyfield(index = 3)
  @Builder.Default
  private int nengdo = 0;

  /** 月次スケジュールステータス区分 */
  @Builder.Default
  private String gtjschstskbn = "";

  /** スケジュールコメント */
  @Builder.Default
  private String schcmt = "";

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
