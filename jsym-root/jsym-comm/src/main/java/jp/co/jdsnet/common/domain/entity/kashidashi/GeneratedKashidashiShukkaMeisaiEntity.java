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
 * 貸出出荷明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedKashidashiShukkaMeisaiEntity implements EntityInterface {

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

  /** ＳＥＱ */
  @Keyfield(index = 8)
  @Builder.Default
  private int seq = 0;

  /** メーカー指定倉庫コード */
  @Builder.Default
  private String mkrsteskocod = "";

  /** 引当倉庫コード */
  @Builder.Default
  private String hatskocod = "";

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** 単価／金額指定区分 */
  @Builder.Default
  private String tankinstekbn = "";

  /** 仕切単価 */
  @Builder.Default
  private double skrtan = 0D;

  /** 貸出金額 */
  @Builder.Default
  private int kdakin = 0;

  /** 貸出数量 */
  @Builder.Default
  private int kdasur = 0;

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 部分売上明細ＳＥＱ */
  @Builder.Default
  private int bbnurimsiseq = 0;

}
