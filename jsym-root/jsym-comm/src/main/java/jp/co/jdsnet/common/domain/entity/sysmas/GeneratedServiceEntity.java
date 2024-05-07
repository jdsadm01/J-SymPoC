package jp.co.jdsnet.common.domain.entity.sysmas;

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
 * サービスEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedServiceEntity implements EntityInterface {

  // 永続属性 ↓
  /** サービスＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String svcid = "";

  /** サービス名 */
  @Builder.Default
  private String svcnm = "";

  /** サービスプログラムＩＤ */
  @Builder.Default
  private String svcpgmid = "";

  /** 入力データ連携区分 */
  @Builder.Default
  private String inpdtarnkkbn = "";

  /** 入力データＩＤ */
  @Builder.Default
  private String inpdtaid = "";

  /** スレッドサービスプログラムＩＤ */
  @Builder.Default
  private String trdsvcpgmid = "";

  /** サービスグループＩＤ */
  @Builder.Default
  private String svcgrpid = "";

  /** 多重起動可能フラグ */
  @Builder.Default
  private String tajkidkanflg = "0";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
