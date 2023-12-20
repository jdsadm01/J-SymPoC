package jp.co.jdsnet.common.domain.entity.kaisha;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import jp.co.jdsnet.common.domain.entity.Keyfield;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KaishaEntity implements EntityInterface {
  /** 会社識別コード */
  @Keyfield(index = 0)
  @Builder.Default
  private String kaiskbcod = "";

  /** 会社コード */
  @Builder.Default
  private String kaicod = "";

  /** 会社名カナ */
  @Builder.Default
  private String kainmkn = "";

  /** 会社名カナ（拡張） */
  @Builder.Default
  private String kainmknkkc = "";

  /** 会社名 */
  @Builder.Default
  private String kainm = "";

  /** 会社名（拡張） */
  @Builder.Default
  private String kainmkkc = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社分類区分 */
  @Builder.Default
  private String kaibunkbn = "";

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
