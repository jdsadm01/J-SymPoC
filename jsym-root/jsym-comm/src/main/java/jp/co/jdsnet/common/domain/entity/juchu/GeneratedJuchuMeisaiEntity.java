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
 * 受注明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedJuchuMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 受注日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int jucdte = 0;

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String dscod = "";

  /** 受注見出ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int jucmdsseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 5)
  @Builder.Default
  private int seq = 0;

  /** 処理完了フラグ */
  @Builder.Default
  private String prckruflg = "0";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 受注品番 */
  @Builder.Default
  private String juchnb = "";

  /** 引当予定品番 */
  @Builder.Default
  private String hatytehnb = "";

  /** 受注数量 */
  @Builder.Default
  private int jucsur = 0;

  /** 引当数量 */
  @Builder.Default
  private int hatsur = 0;

  /** 単価／金額指定区分 */
  @Builder.Default
  private String tankinstekbn = "";

  /** 仕切単価 */
  @Builder.Default
  private double skrtan = 0D;

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

  /** 得意先発注メモ */
  @Builder.Default
  private String thcmemo = "";

  /** 金額 */
  @Builder.Default
  private long kin = 0L;

  /** メーカー指定倉庫コード */
  @Builder.Default
  private String mkrsteskocod = "";

  /** 入力チェックエラー区分 */
  @Builder.Default
  private String inpchkerrkbn = "";

  /** 翌営出荷フラグ */
  @Builder.Default
  private String ykesyaflg = "0";

  /** 翌営出荷仮引当倉庫コード */
  @Builder.Default
  private String ykesyakhaskocod = "";

  /** 翌営出荷引当済フラグ */
  @Builder.Default
  private String ykesyahatzflg = "0";

  /** 翌営出荷理由区分 */
  @Builder.Default
  private String ykesyaryukbn = "";

  /** 注残フラグ */
  @Builder.Default
  private String chzflg = "0";

  /** 新譜注残削除フラグ */
  @Builder.Default
  private String sinchzdelflg = "0";

  /** エラーコード */
  @Builder.Default
  private String errcod = "";

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

  /** 連動引当分割有フラグ */
  @Builder.Default
  private String rdohatbktariflg = "0";

  /** 出荷伝票番号 */
  @Builder.Default
  private String syadenbng = "";

  /** 出荷指示数量 */
  @Builder.Default
  private int syasjisur = 0;

  /** 出荷指示区分 */
  @Builder.Default
  private String syasjikbn = "";

}
