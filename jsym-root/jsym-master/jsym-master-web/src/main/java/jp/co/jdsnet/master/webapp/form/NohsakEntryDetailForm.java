package jp.co.jdsnet.master.webapp.form;

import java.io.Serializable;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.master.domain.dto.NohsakEntryDetailDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
// @Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class NohsakEntryDetailForm implements FormInterface<NohsakEntryDetailDTO>, Serializable {
  private static final long serialVersionUID = 1L;

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

  @Override
  public NohsakEntryDetailDTO toDTO() {
    return NohsakEntryDetailDTO.builder().tokcod(this.tokcod).dscod(this.dscod)
        .gkytokcod(this.gkytokcod).toknm(this.toknm).gkytoknm(this.gkytoknm).updkbn(this.updkbn)
        .upddte(this.upddte).updjkk(this.updjkk).build();
  }

  /**
   * DTOからFormへ変換する
   * 
   * @param dto
   * @return
   */
  public static NohsakEntryDetailForm toForm(NohsakEntryDetailDTO dto) {
    return NohsakEntryDetailForm.builder().tokcod(dto.getTokcod()).dscod(dto.getDscod())
        .gkytokcod(dto.getGkytokcod()).toknm(dto.getToknm()).gkytoknm(dto.getGkytoknm())
        .updkbn(dto.getUpdkbn()).upddte(dto.getUpddte()).updjkk(dto.getUpdjkk()).build();
  }
}
