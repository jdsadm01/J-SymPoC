package jp.co.jdsnet.common.domain.entity.soko;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedGameKyotsuTokuisakiHenkanEntity implements EntityInterface {
  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 得意先コード */
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Builder.Default
  private String dscod = "";

  /** ゲーム共通得意先コード */
  @Builder.Default
  private String gkytokcod = "";

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
