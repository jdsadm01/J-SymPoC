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
 * セッション管理Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedMdvSessionControlEntity implements EntityInterface {

  // 永続属性 ↓
  /** マルチデバイスユーザーＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String mdvusrid = "";

  /** セッションＩＤ */
  @Builder.Default
  private String sessionid = "";

  /** ログイン日付８桁 */
  @Builder.Default
  private int lgidte8kt = 0;

  /** ログイン時刻 */
  @Builder.Default
  private int lgijkk = 0;

  /** ブラウザバージョン */
  @Builder.Default
  private String brwsver = "";

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
