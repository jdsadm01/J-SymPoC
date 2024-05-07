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
 * 郵便番号マスタEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedPostCodeEntity implements EntityInterface {

  // 永続属性 ↓
  /** 郵便番号（７桁） */
  @Keyfield(index = 1)
  @Builder.Default
  private String ybnbng7kt = "";

  /** 宅急便仕分コード（７桁） */
  @Builder.Default
  private String tkbswkcod7kt = "";

  /** メール便仕分コード */
  @Builder.Default
  private String mlbswkcod = "";

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
