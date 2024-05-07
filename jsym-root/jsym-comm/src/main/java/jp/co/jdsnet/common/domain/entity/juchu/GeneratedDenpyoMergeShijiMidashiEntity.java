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
 * 伝票マージ指示見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDenpyoMergeShijiMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 入力日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int inpdte = 0;

  /** ＳＥＱ */
  @Keyfield(index = 2)
  @Builder.Default
  private int seq = 0;

  /** 伝票マージトリガー区分 */
  @Builder.Default
  private String denmrgtrgkbn = "";

  /** 抽出条件指定区分 */
  @Builder.Default
  private String cshjknstekbn = "";

  /** 引当場所コード */
  @Builder.Default
  private String hatbshcod = "";

  /** 配送方面コードＦＲＯＭ */
  @Builder.Default
  private String hsohmncodfrm = "";

  /** 配送方面コードＴＯ */
  @Builder.Default
  private String hsohmncodto = "";

  /** 処理完了フラグ */
  @Builder.Default
  private String prckruflg = "0";

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
