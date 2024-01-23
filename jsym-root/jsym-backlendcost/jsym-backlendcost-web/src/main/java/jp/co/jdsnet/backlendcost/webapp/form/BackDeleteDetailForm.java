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

  // 明細に出力しない注残項目(更新で使用) TODO 更新の為だけに保持しているなら不要
  private int jucmdsseq;
  private int jucmeiseq;
  private int seq;
  private String trncod;
  private int chzjkk;
  private String thcbng;
  private String sjcod;
  private String ykncod;
  private String mscod;
  private String tankinhjiflg;
  private String daikaiskbcod;
  private String kigbng;
  private int trjchzsur;
  private String tankinstekbn;
  private double skrtan;
  private String rmcod;
  private String eigcod;
  private String tercod;
  private String skosteariflg;
  private int chzrelno;
  private String cpufulid;
  private int wsseq7kt;
  private String chzkicsjizflg;
  private String chzstskbn;
  private String cchflg;
  private String cchtioktkkbn;
  private String cchhatskocod;
  private int chzdelkjndte;
  private String fmg1;
  private String fmg2;

  // private String[] inputMultiCheck;
  //
  // public String[] getInputMultiCheck() {
  // return inputMultiCheck;
  // }
  //
  // public void setInputMultiCheck(String[] inputMultiCheck) {
  // this.inputMultiCheck = inputMultiCheck;
  // }

  public BackDeleteDetailDTO toDTO() {
    return BackDeleteDetailDTO.builder().no(this.no).skocod(this.skocod).hjihnb(this.hjihnb)
        .chzsur(this.chzsur).tomrakcod(this.tomrakcod).hbidte(this.hbidte).usnjndte(this.usnjndte)
        .urisyytencod(this.urisyytencod).tokcod(this.tokcod).dscod(this.dscod).toknm(this.toknm)
        .jucdte(this.jucdte).chzdeldte(this.chzdeldte).chzdelKbn(this.chzdelKbn)
        .jucmdsseq(this.jucmdsseq).jucmeiseq(this.jucmeiseq).seq(this.seq).trncod(this.trncod)
        .chzjkk(this.chzjkk).thcbng(this.thcbng).sjcod(this.sjcod).ykncod(this.ykncod)
        .mscod(this.mscod).tankinhjiflg(this.tankinhjiflg).daikaiskbcod(this.daikaiskbcod)
        .kigbng(this.kigbng).trjchzsur(this.trjchzsur).tankinstekbn(this.tankinstekbn)
        .skrtan(this.skrtan).rmcod(this.rmcod).eigcod(this.eigcod).tercod(this.tercod)
        .skosteariflg(this.skosteariflg).chzrelno(this.chzrelno).cpufulid(this.cpufulid)
        .wsseq7kt(this.wsseq7kt).chzkicsjizflg(this.chzkicsjizflg).chzstskbn(this.chzstskbn)
        .cchflg(this.cchflg).cchtioktkkbn(this.cchtioktkkbn).cchhatskocod(this.cchhatskocod)
        .chzdelkjndte(this.chzdelkjndte).fmg1(this.fmg1).fmg2(this.fmg2).deletechk(this.deletechk)
        .build();
  }

  public static BackDeleteDetailForm toForm(BackDeleteDetailDTO dto) {
    return BackDeleteDetailForm.builder().no(dto.getNo()).skocod(dto.getSkocod())
        .hjihnb(dto.getHjihnb()).chzsur(dto.getChzsur()).tomrakcod(dto.getTomrakcod())
        .hbidte(dto.getHbidte()).usnjndte(dto.getUsnjndte()).urisyytencod(dto.getUrisyytencod())
        .tokcod(dto.getTokcod()).dscod(dto.getDscod()).toknm(dto.getToknm()).jucdte(dto.getJucdte())
        .chzdeldte(dto.getChzdeldte()).chzdelKbn(dto.getChzdelKbn()).jucmdsseq(dto.getJucmdsseq())
        .jucmeiseq(dto.getJucmeiseq()).seq(dto.getSeq()).trncod(dto.getTrncod())
        .chzjkk(dto.getChzjkk()).thcbng(dto.getThcbng()).sjcod(dto.getSjcod())
        .ykncod(dto.getYkncod()).mscod(dto.getMscod()).tankinhjiflg(dto.getTankinhjiflg())
        .daikaiskbcod(dto.getDaikaiskbcod()).kigbng(dto.getKigbng()).trjchzsur(dto.getTrjchzsur())
        .tankinstekbn(dto.getTankinstekbn()).skrtan(dto.getSkrtan()).rmcod(dto.getRmcod())
        .eigcod(dto.getEigcod()).tercod(dto.getTercod()).skosteariflg(dto.getSkosteariflg())
        .chzrelno(dto.getChzrelno()).cpufulid(dto.getCpufulid()).wsseq7kt(dto.getWsseq7kt())
        .chzkicsjizflg(dto.getChzkicsjizflg()).chzstskbn(dto.getChzstskbn()).cchflg(dto.getCchflg())
        .cchtioktkkbn(dto.getCchtioktkkbn()).cchhatskocod(dto.getCchhatskocod())
        .chzdelkjndte(dto.getChzdelkjndte()).fmg1(dto.getFmg1()).fmg2(dto.getFmg2())
        .deletechk(dto.getDeletechk()).build();
  }


}
