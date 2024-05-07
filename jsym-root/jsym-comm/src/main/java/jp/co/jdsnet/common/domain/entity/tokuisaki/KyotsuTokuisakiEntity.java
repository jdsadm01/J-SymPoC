package jp.co.jdsnet.common.domain.entity.tokuisaki;

import jp.co.jdsnet.common.utils.StringUtility;
import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 共通得意先Entityクラス
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
public class KyotsuTokuisakiEntity extends GeneratedKyotsuTokuisakiEntity {

  // 関連属性 ↓

  // メソッド ↓
  /**
   * 得意先名１＋２を結合して返す
   *
   * @return 得意先名１＋２
   */
  public String getToknm() {
    return StringUtility.removeSuffix(super.getToknm1() + super.getToknm2(), "　");
  }
}
