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
public class HenpinShijiMidashiEntity implements EntityInterface {
  /** 返品指示見出ＩＤ */
  @Keyfield(index = 0)
  @Builder.Default
  private String hpnsjimdsid = "";

  /** 入力日付 */
  @Builder.Default
  private int inpdte = 0;

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** ＳＥＱ */
  @Builder.Default
  private int seq = 0;

  /** 返品指示区分 */
  @Builder.Default
  private String hpnsjikbn = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 倉庫コード */
  @Builder.Default
  private String skocod = "";

  /** 返品リラティブＮＯ */
  @Builder.Default
  private String hpnrelno = "";

  /** 得意先コード */
  @Builder.Default
  private String tokcod = "";

  /** トランコード */
  @Builder.Default
  private String trncod = "";

  /** 返品受付番号 */
  @Builder.Default
  private String hpnutkbng = "";

  /** 返品理由区分 */
  @Builder.Default
  private String hpnryukbn = "";

  /** 返品受領日付 */
  @Builder.Default
  private int hpnjurdte = 0;

  /** 管理区分 */
  @Builder.Default
  private String knrkbn = "";

  /** 金額表示区分 */
  @Builder.Default
  private String kinhjikbn = "";

  /** 仕向地コード */
  @Builder.Default
  private String smtcod = "";

  /** 仕切掛率 */
  @Builder.Default
  private double skrkrt = 0d;

  /** 得意先伝票番号１ */
  @Builder.Default
  private String tokdenbng1 = "";

  /** 得意先伝票番号２ */
  @Builder.Default
  private String tokdenbng2 = "";

  /** ロケーション番号 */
  @Builder.Default
  private String locbng = "";

  /** 元伝日付 */
  @Builder.Default
  private int mtddte = 0;

  /** 元伝番号 */
  @Builder.Default
  private String mtdbng = "";

  /** オーダーＮＯ */
  @Builder.Default
  private String odrno = "";

  /** 返品数量 */
  @Builder.Default
  private int hpnsur = 0;

  /** 返品金額 */
  @Builder.Default
  private int hpnkin = 0;

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** フリーメッセージ１ */
  @Builder.Default
  private String fmg1 = "";

  /** フリーメッセージ２ */
  @Builder.Default
  private String fmg2 = "";

  /** 明細数 */
  @Builder.Default
  private int msisuu = 0;

  /** 返品特殊受入フラグ */
  @Builder.Default
  private String hpntsyukeflg = "";

  /** 再受サイン */
  @Builder.Default
  private String suksgn = "";

  /** ＣＰＵフルＩＤ */
  @Builder.Default
  private String cpufulid = "";

  /** ＷＳＳＥＱ（４桁） */
  @Builder.Default
  private int wsseq4kt = 0;

  /** 処理完了フラグ */
  @Builder.Default
  private String prckruflg = "";

  /** スタック指定フラグ */
  @Builder.Default
  private String stasteflg = "";

  /** スタック解除済フラグ */
  @Builder.Default
  private String stakjyzflg = "";

  /** 削除フラグ */
  @Builder.Default
  private String delflg = "";

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

  /** 入力時刻 */
  @Builder.Default
  private int inpjkk = 0;

  /** 溜め打ち指定フラグ */
  @Builder.Default
  private String tmusteflg = "";

  /** 溜め打ち解除済フラグ */
  @Builder.Default
  private String tmukjyzflg = "";
}
