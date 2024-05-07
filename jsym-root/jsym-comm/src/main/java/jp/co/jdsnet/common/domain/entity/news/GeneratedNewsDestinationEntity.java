package jp.co.jdsnet.common.domain.entity.news;

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
 * ニュース宛先Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedNewsDestinationEntity implements EntityInterface {

  // 永続属性 ↓
  /** ニュースＳＥＱ */
  @Keyfield(index = 1)
  @Builder.Default
  private int nwsseq = 0;

  /** ニュース宛先ＳＥＱ */
  @Keyfield(index = 2)
  @Builder.Default
  private int nwsatsseq = 0;

  /** 宛先区分 */
  @Builder.Default
  private String atskbn = "";

  /** 宛先情報 */
  @Builder.Default
  private String atsinf = "";

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
