package jp.co.jdsnet.common.domain.entity.denpyo;

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
 * 指定伝見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShiteidenMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 指定伝作成日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int stdssedte = 0;

  /** 場所コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String bshcod = "";

  /** 指定伝リラティブＮＯ */
  @Keyfield(index = 3)
  @Builder.Default
  private int stdrelno = 0;

  /** トランコード */
  @Builder.Default
  private String trncod = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** メーカー伝票番号 */
  @Builder.Default
  private String mkrdenbng = "";

  /** 共同伝票番号 */
  @Builder.Default
  private String kyodenbng = "";

  /** 納品伝票日付 */
  @Builder.Default
  private int nohdendte = 0;

  /** 得意先コード */
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Builder.Default
  private String dscod = "";

  /** 指定伝番号 */
  @Builder.Default
  private String stdbng = "";

  /** チェックデジット */
  @Builder.Default
  private String chd = "";

  /** 指定伝日付 */
  @Builder.Default
  private int stddte = 0;

  /** 指定伝区分 */
  @Builder.Default
  private String stdkbn = "";

  /** 指定伝法人コード */
  @Builder.Default
  private String stdhjncod = "";

  /** 指定伝納品場所コード */
  @Builder.Default
  private String stdnohbshcod = "";

  /** 指定伝取引先コード */
  @Builder.Default
  private String stdtorsakcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** 指定伝分類コード */
  @Builder.Default
  private String stdbuncod = "";

  /** 指定伝伝票区分コード */
  @Builder.Default
  private String stddenkbncod = "";

  /** 品別番号コード */
  @Builder.Default
  private String hbebngcod = "";

  /** 配送方面／ブロックコード */
  @Builder.Default
  private String hsohmnblkcod = "";

  /** 商品タイトル表示区分 */
  @Builder.Default
  private String shotithjikbn = "";

  /** 得意先発注番号 */
  @Builder.Default
  private String thcbng = "";

  /** 翌勘コード */
  @Builder.Default
  private String ykncod = "";

  /** 請求月 */
  @Builder.Default
  private int seimm = 0;

  /** 指定伝摘要１ */
  @Builder.Default
  private String stdtyo1 = "";

  /** 指定伝摘要２ */
  @Builder.Default
  private String stdtyo2 = "";

  /** 指定伝摘要３ */
  @Builder.Default
  private String stdtyo3 = "";

  /** 指定伝摘要４ */
  @Builder.Default
  private String stdtyo4 = "";

  /** Ｆ欄 */
  @Builder.Default
  private String frn = "";

  /** ページ番号 */
  @Builder.Default
  private int pagbng = 0;

  /** ページ番号終了サイン */
  @Builder.Default
  private String pagbngendsgn = "";

  /** ＥＭサイン */
  @Builder.Default
  private String emsgn = "";

  /** 明細数 */
  @Builder.Default
  private int msisuu = 0;

  /** ＧＰＲＯ送信済フラグ */
  @Builder.Default
  private String gprossnzflg = "0";

  /** ＧＰＲＯ送信日付 */
  @Builder.Default
  private int gprossndte = 0;

  /** ＧＰＲＯ送信時刻 */
  @Builder.Default
  private int gprossnjkk = 0;

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
