package jp.co.jdsnet.common.domain.entity.kaisha;

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
 * 会社Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedMdvKaishaEntity implements EntityInterface {

  // 永続属性 ↓
  /** 会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String kaiskbcod = "";

  /** ユーザー分類 */
  @Keyfield(index = 2)
  @Builder.Default
  private String usrbun = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** パスワード有効月数 */
  @Builder.Default
  private int pwdykotsu = 0;

  /** パスワード有効日数 */
  @Builder.Default
  private int pwdykonsu = 0;

  /** パスワード最低桁数 */
  @Builder.Default
  private int pwdminkta = 0;

  /** パスワード構成区分（英字） */
  @Builder.Default
  private String pwdkoskbneji = "";

  /** パスワード構成区分（数値） */
  @Builder.Default
  private String pwdkoskbnnum = "";

  /** パスワード構成区分（記号） */
  @Builder.Default
  private String pwdkoskbnkig = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** Ｊ－ＳＹＭロック使用フラグ */
  @Builder.Default
  private String jsymlockuseflg = "0";

  /** Ｊ－ＳＹＭパスワード誤入力上限回数 */
  @Builder.Default
  private int jsympwdginpjogksu = 0;

  /** Ｊ－ＳＹＭロック自動解除フラグ */
  @Builder.Default
  private String jsymlockautkjyflg = "0";

  /** マルチデバイスロック使用フラグ */
  @Builder.Default
  private String mdvlockuseflg = "0";

  /** マルチデバイスパスワード誤入力上限回数 */
  @Builder.Default
  private int mdvpwdginpjogksu = 0;

  /** マルチデバイスロック自動解除フラグ */
  @Builder.Default
  private String mdvlockautkjyflg = "0";

}
