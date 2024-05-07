package jp.co.jdsnet.common.domain.entity.menu;

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
 * 使用カテゴリマスタEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedUseCategoryEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** ユーザー分類 */
  @Keyfield(index = 2)
  @Builder.Default
  private String usrbun = "";

  /** 業務ID */
  @Keyfield(index = 3)
  @Builder.Default
  private String gymid = "";

  /** カテゴリコード */
  @Keyfield(index = 4)
  @Builder.Default
  private String ctgcod = "";

  /** 表示業務ID */
  @Builder.Default
  private String hjigymid = "";

  /** 表示カテゴリコード */
  @Builder.Default
  private String hjictgcod = "";

  /** カテゴリ表示順 */
  @Builder.Default
  private int ctghjijun = 0;

  /** 使用開始日 */
  @Builder.Default
  private int usesttdte = 0;

  /** 使用停止日 */
  @Builder.Default
  private int useenddte = 0;

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
