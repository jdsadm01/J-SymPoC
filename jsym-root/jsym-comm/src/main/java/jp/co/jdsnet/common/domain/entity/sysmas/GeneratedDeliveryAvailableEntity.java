package jp.co.jdsnet.common.domain.entity.sysmas;

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
 * 配達可能日時判定マスタEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDeliveryAvailableEntity implements EntityInterface {

  // 永続属性 ↓
  /** 発送管理コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String hasknrcod = "";

  /** 宅急便仕分コード（５桁） */
  @Keyfield(index = 2)
  @Builder.Default
  private String tkbswkcod5kt = "";

  /** 配達可能日付区分 */
  @Builder.Default
  private String htakandtekbn = "";

  /** 配達可能時間帯区分 */
  @Builder.Default
  private String htakanjktkbn = "";

  /** 使用開始日付 */
  @Builder.Default
  private int usesttdte = 0;

  /** 作成日付 */
  @Builder.Default
  private int ssedte = 0;

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
