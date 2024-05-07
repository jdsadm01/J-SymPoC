package jp.co.jdsnet.common.domain.entity.kaisha;

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
 * テリトリーEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTerritoryEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 営業所コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String tercod = "";

  /** テリトリー名カナ */
  @Builder.Default
  private String ternmkn = "";

  /** テリトリー名 */
  @Builder.Default
  private String ternm = "";

  /** 営業所課コード */
  @Builder.Default
  private String eigkacod = "";

  /** 営業地区コード */
  @Builder.Default
  private String egytikcod = "";

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
