package jp.co.jdsnet.common.domain.entity.tokuisaki;

import jp.co.jdsnet.common.utils.GlobalConstants.CodeInterface;
import jp.co.jdsnet.common.utils.StringUtility;
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
 * ＤＳEntityクラス
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
public class DsEntity extends GeneratedDsEntity {

  // 関連定数 ↓
  @RequiredArgsConstructor
  public enum Sinkyuusekbn implements CodeInterface<String> {
    BOTH_POSSIBLE("0"), SINPU_ONLY("1"), KYUFU_ONLY("2");
    private final String code;

    public String getCode() {
      return this.code;
    }
  }

  // 関連属性 ↓

  // メソッド ↓
  /**
   * DS名１＋２を結合して返す
   *
   * @return DS名１＋２
   */
  public String getDsnm() {
    return StringUtility.removeSuffix(super.getDsnm1() + super.getDsnm2(), "　");
  }
}
