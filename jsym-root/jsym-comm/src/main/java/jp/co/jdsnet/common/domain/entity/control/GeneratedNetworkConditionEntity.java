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
 * ネットワーク条件 Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedNetworkConditionEntity implements EntityInterface {

  // 永続属性 ↓
  /** ネットワーク識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String nwkskbcod = "";

  /** ネットワーク認証キー */
  @Keyfield(index = 2)
  @Builder.Default
  private String nwknnskey = "";

  /** ユーザーＩＤ保存フラグ */
  @Builder.Default
  private String usridhzoflg = "0";

  /** パスワード保存フラグ */
  @Builder.Default
  private String pwdhzoflg = "0";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** デバイス認証チェックフラグ */
  @Builder.Default
  private String dvinnschkflg = "0";

  /** ネットワークコメント */
  @Builder.Default
  private String nwkcmt = "";

}
