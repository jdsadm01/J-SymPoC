package jp.co.jdsnet.common.domain.entity.menu;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import jp.co.jdsnet.common.domain.entity.Keyfield;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * メニューグループマスターEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedMenuGroupEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** ユーザー分類 */
  @Keyfield(index = 2)
  @Builder.Default
  private String usrbun = "";

  /** メニューグループコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String mnugrpcod = "";

  /** メニューグループ名 */
  @Builder.Default
  private String mnugrpnmkj = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 共同物流メニューパターンコード */
  @Builder.Default
  private String avismnuptncod = "";

  /** 物流110番メニューパターンコード */
  @Builder.Default
  private String claimmnuptncod = "";

  /** 得意先104番シングルサインオン */
  @Builder.Default
  private String tok104mnuptncod = "";

  /** 生産発注LIGHTメニューパターンコード */
  @Builder.Default
  private String lightmnuptncod = "";

  /** JCOBSメニューパターンコード */
  @Builder.Default
  private String jcobsmnuptncod = "";

  /** 物流状況管理メニューパターンコード */
  @Builder.Default
  private String dmsysmnuptncod = "";

  /** ZZSYSメニューパターンコード */
  @Builder.Default
  private String zzsysmnuptncod = "";

  /** SSSYSメニューパターンコード */
  @Builder.Default
  private String sssysmnuptncod = "";

  /** TTSYSメニューパターンコード */
  @Builder.Default
  private String ttsysmnuptncod = "";

  /** KKSYSメニューパターンコード */
  @Builder.Default
  private String kksysmnuptncod = "";

  /** アシスタントメニューパターンコード */
  @Builder.Default
  private String commmnuptncod = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** ﾏﾙﾁﾃﾞﾊﾞｲｽﾒﾆｭｰﾊﾟﾀﾝｺｰﾄﾞ */
  @Builder.Default
  private String mdvmnuptncod = "";

  /** MySymphonyﾒﾆｭｰﾊﾟﾀｰﾝｺｰﾄﾞ */
  @Builder.Default
  private String mysymmnuptncod = "";

  /** 得意先サイトシングルサインオン */
  @Builder.Default
  private String toksitemnuptncod = "";

}
