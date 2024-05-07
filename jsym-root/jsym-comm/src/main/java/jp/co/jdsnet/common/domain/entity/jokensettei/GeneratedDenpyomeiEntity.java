package jp.co.jdsnet.common.domain.entity.jokensettei;

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
 * 伝票名Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDenpyomeiEntity implements EntityInterface {

  // 永続属性 ↓
  /** トランコード */
  @Keyfield(index = 1)
  @Builder.Default
  private String trncod = "";

  /** 貸出伝票名区分 */
  @Keyfield(index = 2)
  @Builder.Default
  private String kdadennmkbn = "";

  /** 伝票名１ */
  @Builder.Default
  private String dennm1 = "";

  /** 伝票名２ */
  @Builder.Default
  private String dennm2 = "";

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
