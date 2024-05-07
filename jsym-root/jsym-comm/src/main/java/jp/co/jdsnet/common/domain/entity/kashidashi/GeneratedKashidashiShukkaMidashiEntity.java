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
 * 貸出出荷見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedKashidashiShukkaMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 引当場所コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String hatbshcod = "";

  /** トランコード（前３桁） */
  @Keyfield(index = 2)
  @Builder.Default
  private String trncodmae3kt = "";

  /** 代表会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String daikaiskbcod = "";

  /** メーカー伝票番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String mkrdenbng = "";

  /** 伝票日付 */
  @Keyfield(index = 5)
  @Builder.Default
  private int dendte = 0;

  /** 得意先コード */
  @Keyfield(index = 6)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 7)
  @Builder.Default
  private String dscod = "";

  /** 得意先発注番号 */
  @Builder.Default
  private String thcbng = "";

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

  /** 仕切掛率指定フラグ */
  @Builder.Default
  private String skrkrtsteflg = "0";

  /** 仕切掛率 */
  @Builder.Default
  private double skrkrt = 0D;

  /** 貸出区分 */
  @Builder.Default
  private String kdakbn = "";

  /** 精算予定日 */
  @Builder.Default
  private int ssaytedte = 0;

  /** メーカー指定出荷日付 */
  @Builder.Default
  private int mkrstesyadte = 0;

  /** 貸出戻入済フラグ */
  @Builder.Default
  private String kdareizflg = "0";

  /** 貸出売上済フラグ */
  @Builder.Default
  private String kdaurizflg = "0";

  /** 精算済フラグ */
  @Builder.Default
  private String ssazflg = "0";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 部分売上済フラグ */
  @Builder.Default
  private String bbnurizflg = "0";

  /** 部分売上起点伝票日付 */
  @Builder.Default
  private int bbnuriktedendte = 0;

  /** 部分売上起点メーカー伝票番号 */
  @Builder.Default
  private String bbnuriktemkrdenbng = "";

  /** 部分売上ＳＥＱ */
  @Builder.Default
  private int bbnuriseq = 0;

}
