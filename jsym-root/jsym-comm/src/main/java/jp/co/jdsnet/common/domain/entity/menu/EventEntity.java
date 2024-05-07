package jp.co.jdsnet.common.domain.entity.menu;

import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * イベントマスタEntityクラス
 *
 * @author ソース生成ツール
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EventEntity extends GeneratedEventEntity {

  /**
   * 画面区分定数enum
   */
  @RequiredArgsConstructor
  public enum Gmnkbn {
    ServiceTimeCheck("O "), Add("A "), Update("U "), Delete("D "), Search("S ")
    , Entry("E "), ListCreate("TS"), Admin("K ");

    private final String code;

    public String getCode() {
      return this.code;
    }
  }
  // 関連属性 ↓

}
