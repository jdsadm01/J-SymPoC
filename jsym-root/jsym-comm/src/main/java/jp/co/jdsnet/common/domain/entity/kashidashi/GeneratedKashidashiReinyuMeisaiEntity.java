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
 * 貸出戻入明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedKashidashiReinyuMeisaiEntity implements EntityInterface {

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

  /** 貸出戻入見出ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int kdareimdsseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 5)
  @Builder.Default
  private int seq = 0;

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 戻入数量 */
  @Builder.Default
  private int reisur = 0;

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

  /** 入力チェックエラー区分 */
  @Builder.Default
  private String inpchkerrkbn = "";

  /** エラー有フラグ */
  @Builder.Default
  private String errariflg = "0";

  /** 仕切単価 */
  @Builder.Default
  private double skrtan = 0D;

  /** 単価／金額指定区分 */
  @Builder.Default
  private String tankinstekbn = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 部分売上数量 */
  @Builder.Default
  private int bbnurisur = 0;

}
