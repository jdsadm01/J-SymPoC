package jp.co.jdsnet.common.domain.entity.soko;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * ゲーム共通得意先変換Entityクラス
 *
 * @author ソース生成ツール
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GameKyotsuTokuisakiHenkanEntity extends GeneratedGameKyotsuTokuisakiHenkanEntity {

  // 関連属性 ↓

  /** 得意先名 */
  @Builder.Default
  private String toknm = "";

  /** ゲーム共通得意先名 */
  @Builder.Default
  private String gkytoknm = "";
}
