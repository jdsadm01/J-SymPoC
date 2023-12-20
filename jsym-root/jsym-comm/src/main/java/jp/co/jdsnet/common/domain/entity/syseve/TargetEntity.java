package jp.co.jdsnet.common.domain.entity.syseve;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import jp.co.jdsnet.common.domain.entity.Keyfield;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TargetEntity implements EntityInterface {
  /** ターゲットＩＤ */
  @Keyfield(index = 0)
  @Builder.Default
  private int tgtid = 0;

  /** トランフルコード */
  @Builder.Default
  private String trnfulcod = "";

  /** 元サービスＩＤ */
  @Builder.Default
  private String motsvcid = "";

  /** 先サービスＩＤ */
  @Builder.Default
  private String saksvcid = "";

  /** 検索キーフォーマットＮＯ */
  @Builder.Default
  private String kenkeyfmtno = "";

  /** 検索キー */
  @Builder.Default
  private String kenkey = "";

  /** 起点ターゲットＩＤ */
  @Builder.Default
  private int ktetgtid = 0;

  /** ターゲットステータス区分 */
  @Builder.Default
  private String tgtstskbn = "";

  /** 入力日付 */
  @Builder.Default
  private int inpdte = 0;

  /** 入力時刻 */
  @Builder.Default
  private int inpjkk = 0;

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
