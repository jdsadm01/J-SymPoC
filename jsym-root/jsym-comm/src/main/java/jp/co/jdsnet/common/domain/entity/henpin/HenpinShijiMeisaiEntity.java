package jp.co.jdsnet.common.domain.entity.henpin;

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
public class HenpinShijiMeisaiEntity implements EntityInterface {
  /** 返品指示見出ＩＤ */
  @Keyfield(index = 0)
  @Builder.Default
  private String hpnsjimdsid = "";

  /** ＳＥＱ */
  @Keyfield(index = 1)
  @Builder.Default
  private int seq = 0;

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 仕切単価 */
  @Builder.Default
  private double skrtan = 0d;

  /** 返品数量 */
  @Builder.Default
  private int hpnsur = 0;

  /** 返品金額 */
  @Builder.Default
  private int hpnkin = 0;

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

  /** エラー有フラグ */
  @Builder.Default
  private String errariflg = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 単価／金額指定区分 */
  @Builder.Default
  private String tankinstekbn = "";

  /** エラーコード */
  @Builder.Default
  private String errcod = "";
}
