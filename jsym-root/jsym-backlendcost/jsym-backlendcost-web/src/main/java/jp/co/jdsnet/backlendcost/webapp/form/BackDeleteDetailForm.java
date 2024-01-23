package jp.co.jdsnet.backlendcost.webapp.form;

import java.io.Serializable;
import jakarta.validation.constraints.Pattern;
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

  @Pattern(regexp = "1")
  private String deletechk;

  // 明細に出力しない注残項目(更新で使用) TODO一部済 更新の為だけに保持しているなら不要
  private int jucmdsseq;
  private int jucmeiseq;
  private int seq;
  
  private String kigbng;

  public BackDeleteDetailDTO toDTO() {
    return BackDeleteDetailDTO.builder().no(this.no).skocod(this.skocod).hjihnb(this.hjihnb)
        .chzsur(this.chzsur).tomrakcod(this.tomrakcod).hbidte(this.hbidte).usnjndte(this.usnjndte)
        .urisyytencod(this.urisyytencod).tokcod(this.tokcod).dscod(this.dscod).toknm(this.toknm)
        .jucdte(this.jucdte).chzdeldte(this.chzdeldte).chzdelKbn(this.chzdelKbn)
        .deletechk(this.deletechk).jucmdsseq(this.jucmdsseq).jucmeiseq(this.jucmeiseq).seq(this.seq).kigbng(this.kigbng)
        .build();
  }

  public static BackDeleteDetailForm toForm(BackDeleteDetailDTO dto) {
    return BackDeleteDetailForm.builder().no(dto.getNo()).skocod(dto.getSkocod())
        .hjihnb(dto.getHjihnb()).chzsur(dto.getChzsur()).tomrakcod(dto.getTomrakcod())
        .hbidte(dto.getHbidte()).usnjndte(dto.getUsnjndte()).urisyytencod(dto.getUrisyytencod())
        .tokcod(dto.getTokcod()).dscod(dto.getDscod()).toknm(dto.getToknm()).jucdte(dto.getJucdte()).deletechk(dto.getDeletechk())
        .chzdeldte(dto.getChzdeldte()).chzdelKbn(dto.getChzdelKbn()).jucmdsseq(dto.getJucmdsseq())
        .jucmeiseq(dto.getJucmeiseq()).seq(dto.getSeq()).kigbng(dto.getKigbng())
        .build();
  

  }


}
