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
 * 伝票マージ指示明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDenpyoMergeShijiMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 入力日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int inpdte = 0;

  /** 伝票マージ指示見出ＳＥＱ */
  @Keyfield(index = 2)
  @Builder.Default
  private int denmrgsjimdsseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 3)
  @Builder.Default
  private int seq = 0;

  /** 配送方面コード */
  @Builder.Default
  private String hsohmncod = "";

  /** 得意先コード */
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Builder.Default
  private String dscod = "";

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
