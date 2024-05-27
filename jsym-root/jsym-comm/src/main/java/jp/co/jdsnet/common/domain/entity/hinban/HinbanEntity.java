package jp.co.jdsnet.common.domain.entity.hinban;

import jp.co.jdsnet.common.utils.GlobalConstants.CodeInterface;
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
 * 品番Entityクラス
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
public class HinbanEntity extends GeneratedHinbanEntity {

  @RequiredArgsConstructor
  public enum Skrtanktikbn implements CodeInterface<String> {
    /** 品番マスタの仕切単価 */
    HINBAN_SKRTAN("0"),
    /** 品番マスタの税抜き価格 × 掛率単価マスタの仕切掛率 */
    ZNUPRI_TIMES_SKRKRT("1"),
    /** 単価マスタの仕切単価 */
    TANKA_SKRTAN("2");

    private final String code;

    public String getCode() {
      return this.code;
    }
  }
  // 関連属性 ↓

}
