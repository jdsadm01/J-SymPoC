package jp.co.jdsnet.common.domain.entity.henpin;

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
 * 返品指示明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHenpinShijiMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 返品指示見出ＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String hpnsjimdsid = "";

  /** ＳＥＱ */
  @Keyfield(index = 2)
  @Builder.Default
  private int seq = 0;

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 仕切単価 */
  @Builder.Default
  private double skrtan = 0D;

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
  private String errariflg = "0";

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
