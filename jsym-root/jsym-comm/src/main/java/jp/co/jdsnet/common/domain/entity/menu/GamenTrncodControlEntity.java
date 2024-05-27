package jp.co.jdsnet.common.domain.entity.menu;

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
 * 画面別トラン制御テーブルEntityクラス
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
public class GamenTrncodControlEntity extends GeneratedGamenTrncodControlEntity {

  // 関連属性 ↓
  @Builder.Default
  private String trnnm = "";

}