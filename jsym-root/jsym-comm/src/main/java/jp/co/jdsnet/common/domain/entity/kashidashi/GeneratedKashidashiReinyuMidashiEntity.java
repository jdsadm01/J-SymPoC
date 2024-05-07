package jp.co.jdsnet.common.domain.entity.kashidashi;

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
 * 貸出戻入見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedKashidashiReinyuMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 貸出戻入日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int kdareidte = 0;

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String dscod = "";

  /** ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int seq = 0;

  /** 貸出戻入時刻 */
  @Builder.Default
  private int kdareijkk = 0;

  /** トランフルコード */
  @Builder.Default
  private String trnfulcod = "";

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** フリーメッセージ１ */
  @Builder.Default
  private String fmg1 = "";

  /** フリーメッセージ２ */
  @Builder.Default
  private String fmg2 = "";

  /** 単価／金額表示フラグ */
  @Builder.Default
  private String tankinhjiflg = "0";

  /** 精算予定日 */
  @Builder.Default
  private int ssaytedte = 0;

  /** ＣＰＵフルＩＤ */
  @Builder.Default
  private String cpufulid = "";

  /** ＷＳＳＥＱ（７桁） */
  @Builder.Default
  private int wsseq7kt = 0;

  /** 戻入ステータス区分 */
  @Builder.Default
  private String reistskbn = "";

  /** 入力チェックエラー区分 */
  @Builder.Default
  private String inpchkerrkbn = "";

  /** 貸出出荷倉庫コード */
  @Builder.Default
  private String kdsskocod = "";

  /** 貸出出荷代表会社識別コード */
  @Builder.Default
  private String kdsdaikaiskbcod = "";

  /** 貸出出荷メーカー伝票番号 */
  @Builder.Default
  private String kdsmkrdenbng = "";

  /** 貸出出荷伝票日付 */
  @Builder.Default
  private int kdsdendte = 0;

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

  /** 仕切掛率 */
  @Builder.Default
  private double skrkrt = 0D;

  /** 仕切掛率指定フラグ */
  @Builder.Default
  private String skrkrtsteflg = "0";

  /** 得意先発注番号 */
  @Builder.Default
  private String thcbng = "";

  /** 貸出区分 */
  @Builder.Default
  private String kdakbn = "";

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
