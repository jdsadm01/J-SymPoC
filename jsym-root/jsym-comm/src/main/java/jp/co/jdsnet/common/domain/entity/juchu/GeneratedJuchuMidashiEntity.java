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
 * 受注見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedJuchuMidashiEntity implements EntityInterface {

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

  /** ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int seq = 0;

  /** 受注時刻 */
  @Builder.Default
  private int jucjkk = 0;

  /** トランフルコード */
  @Builder.Default
  private String trnfulcod = "";

  /** 得意先発注番号 */
  @Builder.Default
  private String thcbng = "";

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

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

  /** 単価／金額表示フラグ */
  @Builder.Default
  private String tankinhjiflg = "0";

  /** 仕切掛率指定フラグ */
  @Builder.Default
  private String skrkrtsteflg = "0";

  /** 仕切掛率 */
  @Builder.Default
  private double skrkrt = 0D;

  /** その他出荷管理区分 */
  @Builder.Default
  private String etcsyaknrkbn = "";

  /** 仕向地コード */
  @Builder.Default
  private String smtcod = "";

  /** 貸出区分 */
  @Builder.Default
  private String kdakbn = "";

  /** 精算予定日 */
  @Builder.Default
  private int ssaytedte = 0;

  /** メーカー指定出荷日付 */
  @Builder.Default
  private int mkrstesyadte = 0;

  /** 元伝日付 */
  @Builder.Default
  private int mtddte = 0;

  /** 元伝番号 */
  @Builder.Default
  private String mtdbng = "";

  /** ＣＰＵフルＩＤ */
  @Builder.Default
  private String cpufulid = "";

  /** ＷＳＳＥＱ（７桁） */
  @Builder.Default
  private int wsseq7kt = 0;

  /** 受信日付（８桁） */
  @Builder.Default
  private int jsndte8kt = 0;

  /** 受信時刻（９桁） */
  @Builder.Default
  private int jsnjkk9kt = 0;

  /** 受注区分 */
  @Builder.Default
  private String juckbn = "";

  /** 受注ステータス区分 */
  @Builder.Default
  private String jucstskbn = "";

  /** 入力チェックエラー区分 */
  @Builder.Default
  private String inpchkerrkbn = "";

  /** 翌営出荷フラグ */
  @Builder.Default
  private String ykesyaflg = "0";

  /** 翌営出荷解除済フラグ */
  @Builder.Default
  private String ykesyakjyzflg = "0";

  /** スタック指定フラグ */
  @Builder.Default
  private String stasteflg = "0";

  /** スタック解除済フラグ */
  @Builder.Default
  private String stakjyzflg = "0";

  /** 削除フラグ */
  @Builder.Default
  private String delflg = "0";

  /** 経費出庫管理ＮＯ */
  @Builder.Default
  private String kehsyoknrno = "";

  /** 税区分 */
  @Builder.Default
  private String zeikbn = "";

  /** サンプルサイン */
  @Builder.Default
  private String smpsgn = "";

  /** 経費出庫振替先コード */
  @Builder.Default
  private String kehsyofkesakcod = "";

  /** 科目コード */
  @Builder.Default
  private String kamcod = "";

  /** 経費出庫内容 */
  @Builder.Default
  private String kehsyoniy = "";

  /** 経費出庫振替ＮＯ */
  @Builder.Default
  private String kehsyofkeno = "";

  /** 経費出庫摘要 */
  @Builder.Default
  private String kehsyotyo = "";

  /** エラー有フラグ */
  @Builder.Default
  private String errariflg = "0";

  /** 伝票ＧＰＲＯ送信済フラグ（初回） */
  @Builder.Default
  private String dengprossnzflgski = "";

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
