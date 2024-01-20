package jp.co.jdsnet.backlendcost.webapp.form;

import java.io.Serializable;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDetailDTO;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BackDeleteDetailForm implements FormInterface<BackDeleteDetailDTO>, Serializable {

  private static final long serialVersionUID = 1L;

  // 明細部明細部分
  private int no;
  private String skocod;
  private String hjihnb;
  private int chzsur;
  private String tomrakcod;
  private String hbidte;
  private String usnjndte; // 優先順日付
  private String urisyytencod;
  private String tokcod;
  private String dscod;
  private String toknm;
  private String jucdte;
  private String chzdeldte;
  private String chzdelKbn;
  private String deletechk;

  public BackDeleteDetailDTO toDTO() {
    return BackDeleteDetailDTO.builder().no(this.no).skocod(this.skocod).hjihnb(this.hjihnb)
        .chzsur(this.chzsur).tomrakcod(this.tomrakcod).hbidte(this.hbidte).usnjndte(this.usnjndte)
        .urisyytencod(this.urisyytencod).tokcod(this.tokcod).dscod(this.dscod).toknm(this.toknm)
        .jucdte(this.jucdte).chzdeldte(this.chzdeldte).chzdelKbn(this.chzdelKbn)
        .deletechk(this.deletechk).build();
  }

  public static BackDeleteDetailForm toForm(BackDeleteDetailDTO dto) {
    return BackDeleteDetailForm.builder().no(dto.getNo()).skocod(dto.getSkocod())
        .hjihnb(dto.getHjihnb()).chzsur(dto.getChzsur()).tomrakcod(dto.getTomrakcod())
        .hbidte(dto.getHbidte()).usnjndte(dto.getUsnjndte()).urisyytencod(dto.getUrisyytencod())
        .tokcod(dto.getTokcod()).dscod(dto.getDscod()).toknm(dto.getToknm())
        .jucdte(dto.getJucdte()).chzdeldte(dto.getChzdeldte()).chzdelKbn(dto.getChzdelKbn())
        .deletechk(dto.getDeletechk()).build();
  }


}
