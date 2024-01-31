package jp.co.jdsnet.master.domain.dto;

import java.util.List;
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
public class NohsakEntryDTO extends AbstractDTO {
  /** 予約 */
  private String yykflg;
  /** 予約日付 */
  private String yykdte;
  /** 場所コード */
  private String bshcod;
  /** 処理区分 */
  private String prckbn;
  /** 明細 */
  private List<NohsakEntryDetailDTO> detailList;
}
