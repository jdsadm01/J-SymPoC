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
 * 使用画面マスタEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedUseGamenEntity implements EntityInterface {

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

  /** 画面ID */
  @Keyfield(index = 5)
  @Builder.Default
  private String gmnid = "";

  /** 表示業務ID */
  @Builder.Default
  private String hjigymid = "";

  /** 表示カテゴリコード */
  @Builder.Default
  private String hjictgcod = "";

  /** 画面表示順 */
  @Builder.Default
  private int gmnhjijun = 0;

  /** 契約区分 */
  @Builder.Default
  private String kykkbn = "";

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
