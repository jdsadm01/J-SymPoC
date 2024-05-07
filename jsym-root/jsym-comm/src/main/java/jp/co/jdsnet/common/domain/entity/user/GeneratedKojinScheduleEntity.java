package jp.co.jdsnet.common.domain.entity.user;

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
 * 個人スケジュールEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedKojinScheduleEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーID */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** スケジュール日付 */
  @Keyfield(index = 2)
  @Builder.Default
  private int schdte = 0;

  /** SEQ */
  @Keyfield(index = 3)
  @Builder.Default
  private int seq = 0;

  /** テキスト */
  @Builder.Default
  private String txt = "";

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
