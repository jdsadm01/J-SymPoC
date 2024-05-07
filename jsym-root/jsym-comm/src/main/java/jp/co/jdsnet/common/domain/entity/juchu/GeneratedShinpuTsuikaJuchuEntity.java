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
 * 新譜追加受注Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuTsuikaJuchuEntity implements EntityInterface {

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

  /** 新譜追加受注ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int sintuijucseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 5)
  @Builder.Default
  private int seq = 0;

  /** 伝票明細出力順 */
  @Builder.Default
  private int denmsioutjn = 0;

  /** トランコード */
  @Builder.Default
  private String trncod = "";

  /** 得意先発注番号 */
  @Builder.Default
  private String thcbng = "";

  /** ＳＪコード */
  @Builder.Default
  private String sjcod = "";

  /** 翌勘コード */
  @Builder.Default
  private String ykncod = "";

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

  /** ＣＰＵフルＩＤ */
  @Builder.Default
  private String cpufulid = "";

  /** ＷＳＳＥＱ（４桁） */
  @Builder.Default
  private int wsseq4kt = 0;

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 新譜追加数量 */
  @Builder.Default
  private int sintuisur = 0;

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

  /** 出荷日付 */
  @Builder.Default
  private int syadte = 0;

  /** 引当倉庫コード */
  @Builder.Default
  private String hatskocod = "";

  /** 引当場所コード */
  @Builder.Default
  private String hatbshcod = "";

  /** 伝票作成済サイン */
  @Builder.Default
  private String denssezsgn = "";

  /** 削除フラグ */
  @Builder.Default
  private String delflg = "0";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 貸レ店レンタル店区分 */
  @Builder.Default
  private String krerntkbn = "";

  /** 仕切掛率 */
  @Builder.Default
  private double skrkrt = 0D;

  /** スタック指定フラグ */
  @Builder.Default
  private String stasteflg = "0";

  /** スタック解除済フラグ */
  @Builder.Default
  private String stakjyzflg = "0";

  /** 注残フラグ */
  @Builder.Default
  private String chzflg = "0";

  /** エラー有フラグ（見出） */
  @Builder.Default
  private String errariflgmds = "";

  /** エラー有フラグ（明細） */
  @Builder.Default
  private String errariflgmsi = "";

  /** 新譜追加受注ステータス区分 */
  @Builder.Default
  private String sintuijucstskbn = "";

  /** 新譜通常外受注サイン */
  @Builder.Default
  private String sintjgjucsgn = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 配送日付 */
  @Builder.Default
  private int hsodte = 0;

  /** 倉庫出荷日付 */
  @Builder.Default
  private int skosyadte = 0;

  /** 新譜受注数量 */
  @Builder.Default
  private int sinjucsur = 0;

  /** 受注時刻 */
  @Builder.Default
  private int jucjkk = 0;

  /** エラーコード */
  @Builder.Default
  private String errcod = "";

  /** 受注区分 */
  @Builder.Default
  private String juckbn = "";

  /** 単価／金額表示フラグ */
  @Builder.Default
  private String tankinhjiflg = "0";

  /** 出荷伝票番号 */
  @Builder.Default
  private String syadenbng = "";

  /** 溜め打ち指定フラグ */
  @Builder.Default
  private String tmusteflg = "0";

  /** 溜め打ち解除済フラグ */
  @Builder.Default
  private String tmukjyzflg = "0";

}
