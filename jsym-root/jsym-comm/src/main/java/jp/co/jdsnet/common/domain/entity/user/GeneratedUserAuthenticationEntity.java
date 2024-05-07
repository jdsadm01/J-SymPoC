package jp.co.jdsnet.common.domain.entity.user;

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
 * ユーザー認証テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedUserAuthenticationEntity implements EntityInterface {

  // 永続属性 ↓
  /** ネットワーク識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String netwrkskbcod = "";

  /** 入力用ユーザーID */
  @Keyfield(index = 2)
  @Builder.Default
  private String enyusrid = "";

  /** パスワード */
  @Builder.Default
  private String pwd = "";

  /** パスワード有効期限日付 */
  @Builder.Default
  private int pwdkgndte = 0;

  /** ユーザーID */
  @Builder.Default
  private String usrid = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** マルチデバイスパスワード誤入力回数 */
  @Builder.Default
  private int mdvpwdginpksu = 0;

  /** マルチデバイスユーザーロックフラグ */
  @Builder.Default
  private String mdvusrlockflg = "0";

  /** マルチデバイスユーザーロック日付 */
  @Builder.Default
  private int mdvusrlockdte = 0;

  /** マルチデバイスユーザーロック時刻 */
  @Builder.Default
  private int mdvusrlockjkk = 0;

  /** J-Symphonyパスワード誤入力回数 */
  @Builder.Default
  private int jsympwdginpksu = 0;

  /** J-Symphonyユーザーロックフラグ */
  @Builder.Default
  private String jsymusrlockflg = "0";

  /** J-Symphonyユーザーロック日付 */
  @Builder.Default
  private int jsymusrlockdte = 0;

  /** J-Symphonyユーザーロック時刻 */
  @Builder.Default
  private int jsymusrlockjkk = 0;

}
