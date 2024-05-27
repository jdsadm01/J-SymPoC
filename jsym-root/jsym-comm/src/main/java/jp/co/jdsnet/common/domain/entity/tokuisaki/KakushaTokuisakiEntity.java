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
 * 各社得意先Entityクラス
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
public class KakushaTokuisakiEntity extends GeneratedKakushaTokuisakiEntity {

  @RequiredArgsConstructor
  public enum Hsuchskbn implements CodeInterface<String> {
    /** 円未満を四捨五入する */
    ROUND_OFF_ONE_YEN("0") {
      public double ajustSkrtan(double skrtan) {
        return Math.round(skrtan);
      }
    },
    /** 円未満を切り捨てする */
    ROUND_DOWN_ONE_YEN("1") {
      public double ajustSkrtan(double skrtan) {
        return (int) skrtan;
      }
    },
    /** 円未満を切り上げする */
    ROUND_UP_ONE_YEN("2") {
      public double ajustSkrtan(double skrtan) {
        return Math.ceil(skrtan);
      }
    },
    /** 10円未満を四捨五入する */
    ROUND_OFF_TEN_YEN("3") {
      public double ajustSkrtan(double skrtan) {
        return Math.round(skrtan / 10) * 10;
      }
    },
    /** 10円未満を切り捨てする */
    ROUND_DOWN_TEN_YEN("4") {
      public double ajustSkrtan(double skrtan) {
        return ((int) skrtan / 10) * 10;
      }
    },
    /** 10円未満を切り上げする */
    ROUND_UP_TEN_YEN("5") {
      public double ajustSkrtan(double skrtan) {
        return Math.ceil(skrtan / 10) * 10;
      }
    },
    /** 端数調整しない */
    NO_CALCULATION("9") {
      public double ajustSkrtan(double skrtan) {
        return skrtan;
      }
    };

    private final String code;

    public String getCode() {
      return this.code;
    }

    abstract public double ajustSkrtan(double skrtan);
  }
  // 関連属性 ↓

}
