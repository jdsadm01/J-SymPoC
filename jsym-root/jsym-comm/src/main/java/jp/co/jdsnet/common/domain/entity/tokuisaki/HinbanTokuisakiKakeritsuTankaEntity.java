package jp.co.jdsnet.common.domain.entity.tokuisaki;

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
 * 品番得意先掛率単価Entityクラス
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
public class HinbanTokuisakiKakeritsuTankaEntity extends GeneratedHinbanTokuisakiKakeritsuTankaEntity {

  @RequiredArgsConstructor
  public enum Krttankbn implements CodeInterface<String> {
    KAKERITU_SHITEI("0"), TANKA_SHITEI("1");

    private final String code;

    public String getCode() {
      return this.code;
    }
  }
  // 関連属性 ↓

}
