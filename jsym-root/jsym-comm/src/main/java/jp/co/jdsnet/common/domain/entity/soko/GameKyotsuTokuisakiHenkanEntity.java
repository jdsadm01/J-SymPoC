package jp.co.jdsnet.common.domain.entity.soko;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GameKyotsuTokuisakiHenkanEntity extends GeneratedGameKyotsuTokuisakiHenkanEntity {
  /** 得意先名 */
  @Builder.Default
  private String toknm = "";

  /** ゲーム共同得意先名 */
  @Builder.Default
  private String gkytoknm = "";
}
