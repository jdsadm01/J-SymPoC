package jp.co.jdsnet.common.domain.entity.juchu;

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
 * ＥＭ指示明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedEmShijiMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 入力日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int inpdte = 0;

  /** ＥＭ指示見出ＳＥＱ */
  @Keyfield(index = 2)
  @Builder.Default
  private int emsjimdsseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 3)
  @Builder.Default
  private int seq = 0;

  /** 伝票明細出力順 */
  @Builder.Default
  private int denmsioutjn = 0;

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** メーカー伝票番号 */
  @Builder.Default
  private String mkrdenbng = "";

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 伝票明細受注数量 */
  @Builder.Default
  private int denmsijucsur = 0;

  /** 伝票明細出荷数量 */
  @Builder.Default
  private int denmsisyasur = 0;

  /** ＥＭ指示受注数量 */
  @Builder.Default
  private int emsjijucsur = 0;

  /** ＥＭ指示出荷数量 */
  @Builder.Default
  private int emsjisyasur = 0;

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

}
