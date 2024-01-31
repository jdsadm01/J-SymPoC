package jp.co.jdsnet.master.domain.dto;

import jp.co.jdsnet.base.domain.dto.AbstractDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.NONE)
public class NohsakEntryDetailDTO extends AbstractDTO {
  /** 得意先コード */
  private String tokcod;
  /** DSコード */
  private String dscod;
  /** ゲーム共通得意先コード */
  private String gkytokcod;
  /** 得意先名 */
  private String toknm;
  /** ゲーム共通得意先名 */
  private String gkytoknm;
  /** 更新区分 */
  private String updkbn;
  /** 更新日付 */
  private int upddte;
  /** 更新時刻 */
  private int updjkk;
}
