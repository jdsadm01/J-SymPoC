package jp.co.jdsnet.common.domain.entity.control;

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
 * ログイン管理テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedLoginControlEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーID */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** セッションID */
  @Builder.Default
  private String sessionid = "";

  /** ステータス */
  @Builder.Default
  private String sts = "";

  /** ログイン日付 */
  @Builder.Default
  private int logindte = 0;

  /** ログイン時刻 */
  @Builder.Default
  private int loginjkk = 0;

  /** ログアウト日付 */
  @Builder.Default
  private int logoutdte = 0;

  /** ログアウト時刻 */
  @Builder.Default
  private int logoutjkk = 0;

  /** ブラウザバージョン */
  @Builder.Default
  private String browserversion = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 初期表示メニュー区分 */
  @Builder.Default
  private String intmnukbn = "";

}
