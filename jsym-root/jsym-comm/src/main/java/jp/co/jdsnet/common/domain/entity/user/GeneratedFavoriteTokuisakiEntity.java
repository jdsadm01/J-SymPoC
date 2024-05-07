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
 * お気に入り（得意先）Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedFavoriteTokuisakiEntity implements EntityInterface {

  // 永続属性 ↓
  /** マルチデバイスユーザーＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String mdvusrid = "";

  /** 代表会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 得意先コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String tokcod = "";

  /** 入力日付 */
  @Builder.Default
  private int inpdte = 0;

  /** 入力時刻 */
  @Builder.Default
  private int inpjkk = 0;

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
