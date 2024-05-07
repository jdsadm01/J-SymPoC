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
 * 受注引当見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedJuchuHikiateMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 受注引当見出番号 */
  @Keyfield(index = 1)
  @Builder.Default
  private String juchatmdsbng = "";

  /** トランフルコード */
  @Builder.Default
  private String trnfulcod = "";

  /** 引当場所コード */
  @Builder.Default
  private String hatbshcod = "";

  /** 引当日付 */
  @Builder.Default
  private int hatdte = 0;

  /** 引当時刻 */
  @Builder.Default
  private int hatjkk = 0;

  /** 得意先コード */
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Builder.Default
  private String dscod = "";

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

  /** 受注日付 */
  @Builder.Default
  private int jucdte = 0;

  /** 受注時刻 */
  @Builder.Default
  private int jucjkk = 0;

  /** 受注区分 */
  @Builder.Default
  private String juckbn = "";

  /** Ｃ直要求場所コード */
  @Builder.Default
  private String cchreqbshcod = "";

  /** 伝票作成結果区分 */
  @Builder.Default
  private String denssektkkbn = "";

  /** 伝票マージ待機フラグ */
  @Builder.Default
  private String denmrgtaikflg = "0";

  /** 伝票マージ制限フラグ */
  @Builder.Default
  private String denmrgsgeflg = "0";

  /** 伝票マージトリガー区分 */
  @Builder.Default
  private String denmrgtrgkbn = "";

  /** 配送方面コード */
  @Builder.Default
  private String hsohmncod = "";

  /** 体積 */
  @Builder.Default
  private int tsk = 0;

  /** 引当数量合計 */
  @Builder.Default
  private int hatsurttl = 0;

  /** 伝票マージグループＮＯ */
  @Builder.Default
  private String denmrggrpno = "";

  /** 税区分 */
  @Builder.Default
  private String zeikbn = "";

  /** 科目コード */
  @Builder.Default
  private String kamcod = "";

  /** サンプルサイン */
  @Builder.Default
  private String smpsgn = "";

  /** 経費出庫管理ＮＯ */
  @Builder.Default
  private String kehsyoknrno = "";

  /** 経費出庫振替ＮＯ */
  @Builder.Default
  private String kehsyofkeno = "";

  /** 経費出庫振替先コード */
  @Builder.Default
  private String kehsyofkesakcod = "";

  /** 経費出庫内容 */
  @Builder.Default
  private String kehsyoniy = "";

  /** 経費出庫摘要 */
  @Builder.Default
  private String kehsyotyo = "";

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
