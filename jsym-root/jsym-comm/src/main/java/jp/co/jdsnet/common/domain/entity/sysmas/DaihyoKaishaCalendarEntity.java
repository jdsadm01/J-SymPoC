package jp.co.jdsnet.common.domain.entity.sysmas;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 代表会社カレンダーEntityクラス
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
public class DaihyoKaishaCalendarEntity extends GeneratedDaihyoKaishaCalendarEntity {

  // 関連属性 ↓
  /** 稼働日区分 */
  @Builder.Default
  private String kaddtekbn = "";

}
