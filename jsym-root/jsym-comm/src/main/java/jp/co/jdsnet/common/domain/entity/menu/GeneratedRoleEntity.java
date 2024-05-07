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
 * ロールマスタEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedRoleEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 業務ＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String gymid = "";

  /** メニューパターンコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String mnuptncod = "";

  /** 画面ＩＤ */
  @Keyfield(index = 4)
  @Builder.Default
  private String gmnid = "";

  /** 管理者権限 */
  @Builder.Default
  private String rolek = "";

  /** 照会権限 */
  @Builder.Default
  private String roles = "";

  /** 登録権限 */
  @Builder.Default
  private String rolea = "";

  /** 更新権限 */
  @Builder.Default
  private String roleu = "";

  /** 削除権限 */
  @Builder.Default
  private String roled = "";

  /** エントリー権限 */
  @Builder.Default
  private String rolee = "";

  /** 帳票作成権限 */
  @Builder.Default
  private String rolets = "";

  /** 帳票受信権限 */
  @Builder.Default
  private String roletr = "";

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
