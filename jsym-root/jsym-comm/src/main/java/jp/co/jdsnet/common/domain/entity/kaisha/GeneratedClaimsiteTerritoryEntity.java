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
public class GeneratedClaimsiteTerritoryEntity implements EntityInterface {

  // 永続属性 ↓
  /** 会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String kaiskbcod = "";

  /** 営業所コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String tercod = "";

  /** テリトリー名（カナ） */
  @Builder.Default
  private String ternmkn = "";

  /** テリトリー名（漢字） */
  @Builder.Default
  private String ternmkj = "";

  /** 営業所課コード */
  @Builder.Default
  private String eigkacod = "";

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 営業地区コード */
  @Builder.Default
  private String eigtik = "";

}
