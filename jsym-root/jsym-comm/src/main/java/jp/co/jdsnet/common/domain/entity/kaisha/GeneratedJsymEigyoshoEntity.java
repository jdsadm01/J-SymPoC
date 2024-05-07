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
 * 営業所Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedJsymEigyoshoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String kaiskbcod = "";

  /** 営業所コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String eigcod = "";

  /** 営業所名（カナ） */
  @Builder.Default
  private String eignmkn = "";

  /** 営業所名（漢字） */
  @Builder.Default
  private String eignmkj = "";

  /** 営業部コード */
  @Builder.Default
  private String eibcod = "";

  /** 当月営業日数 */
  @Builder.Default
  private String tomeignsu = "";

  /** 営業所予算 */
  @Builder.Default
  private String eigysn = "";

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private String upddte = "";

  /** 最新更新時刻 */
  @Builder.Default
  private String updjkk = "";

  /** 売上計上有フラグ */
  @Builder.Default
  private String urikjuariflg = "";

}
