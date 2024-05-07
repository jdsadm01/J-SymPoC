package jp.co.jdsnet.common.domain.entity.sokosagyo;

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
 * 倉庫指示見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSokoShijiMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 倉庫指示見出ＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String skosjimdsid = "";

  /** 入力場所コード */
  @Builder.Default
  private String inpbshcod = "";

  /** 入力日付 */
  @Builder.Default
  private int inpdte = 0;

  /** 入力時刻 */
  @Builder.Default
  private int inpjkk = 0;

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** トランコード */
  @Builder.Default
  private String trncod = "";

  /** 元倉庫コード */
  @Builder.Default
  private String msocod = "";

  /** 先倉庫コード */
  @Builder.Default
  private String ssocod = "";

  /** ＣＰＵフルＩＤ */
  @Builder.Default
  private String cpufulid = "";

  /** ＷＳＳＥＱ（５桁） */
  @Builder.Default
  private int wsseq5kt = 0;

  /** 受信日付（８桁） */
  @Builder.Default
  private int jsndte8kt = 0;

  /** 受信時刻（９桁） */
  @Builder.Default
  private int jsnjkk9kt = 0;

  /** トランフルコード */
  @Builder.Default
  private String trnfulcod = "";

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** フリーメッセージ１ */
  @Builder.Default
  private String fmg1 = "";

  /** フリーメッセージ２ */
  @Builder.Default
  private String fmg2 = "";

  /** 元伝日付 */
  @Builder.Default
  private int mtddte = 0;

  /** 元伝番号 */
  @Builder.Default
  private String mtdbng = "";

  /** Ａ／Ｂ在庫区分 */
  @Builder.Default
  private String abzaikbn = "";

  /** 元当月／前月迄在庫区分 */
  @Builder.Default
  private String mottomzmmzaikbn = "";

  /** 先当月／前月迄在庫区分 */
  @Builder.Default
  private String saktomzmmzaikbn = "";

  /** 元リマークコード */
  @Builder.Default
  private String motrmcod = "";

  /** 先リマークコード */
  @Builder.Default
  private String sakrmcod = "";

  /** 先行トランコード */
  @Builder.Default
  private String snktrncod = "";

  /** 先行トラン伝票日付 */
  @Builder.Default
  private int snktrndendte = 0;

  /** 先行トランメーカー伝票番号 */
  @Builder.Default
  private String snktrnmkrdenbng = "";

  /** 発注先コード */
  @Builder.Default
  private String hacsakcod = "";

  /** 発注先納品番号 */
  @Builder.Default
  private String hacsaknohbng = "";

  /** 入荷日付 */
  @Builder.Default
  private int nyadte = 0;

  /** サンプルサイン */
  @Builder.Default
  private String smpsgn = "";

  /** 税区分 */
  @Builder.Default
  private String zeikbn = "";

  /** 償却／留置区分 */
  @Builder.Default
  private String skytmekbn = "";

  /** 当月ランクコード */
  @Builder.Default
  private String tomrakcod = "";

  /** ＷＳＳＥＱ（４桁） */
  @Builder.Default
  private int wsseq4kt = 0;

  /** 倉庫指示ステータス区分 */
  @Builder.Default
  private String skosjistskbn = "";

  /** 入力チェックエラー区分 */
  @Builder.Default
  private String inpchkerrkbn = "";

  /** スタック指定フラグ */
  @Builder.Default
  private String stasteflg = "0";

  /** スタック解除済フラグ */
  @Builder.Default
  private String stakjyzflg = "0";

  /** 削除フラグ */
  @Builder.Default
  private String delflg = "0";

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

  /** 溜め打ち指定フラグ */
  @Builder.Default
  private String tmusteflg = "0";

  /** 溜め打ち解除済フラグ */
  @Builder.Default
  private String tmukjyzflg = "0";

}
