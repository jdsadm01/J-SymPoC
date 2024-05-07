package jp.co.jdsnet.common.domain.entity.soko;

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
 * 伝票マージ条件Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDenpyoMergeJokenEntity implements EntityInterface {

  // 永続属性 ↓
  /** 場所コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String bshcod = "";

  /** 配送方面コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String hsohmncod = "";

  /** 伝票マージ基準区分 */
  @Builder.Default
  private String denmrgkjnkbn = "";

  /** 伝票マージ基準体積 */
  @Builder.Default
  private int denmrgkjntsk = 0;

  /** 伝票マージ基準数量 */
  @Builder.Default
  private int denmrgkjnsur = 0;

  /** 自動キック基準区分 */
  @Builder.Default
  private String autkickjnkbn = "";

  /** 自動キック基準体積 */
  @Builder.Default
  private int autkickjntsk = 0;

  /** 自動キック基準数量 */
  @Builder.Default
  private int autkickjnsur = 0;

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
