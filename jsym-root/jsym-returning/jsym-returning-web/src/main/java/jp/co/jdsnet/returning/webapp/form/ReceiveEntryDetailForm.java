package jp.co.jdsnet.returning.webapp.form;

import java.io.Serializable;
import jakarta.validation.constraints.Size;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.returning.domain.dto.ReceiveEntryDetailDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
// @Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ReceiveEntryDetailForm implements FormInterface<ReceiveEntryDetailDTO>, Serializable {

  private static final long serialVersionUID = 1L;

  @Size(max = 13)
  private String kigbng;

  private String hpnsur;

  private String rmcod;

  private String skrtan;

  private String tnaste;

  private String hpnkin;

  /* 品番情報 */
  private String hjihnb;

  private String artnm;

  private String titnm;

  private int hbidte;

  private String tomrakcod;

  private int setcod;

  private String tnpkbn;

  /* Ajax用 */
  private String daikaiskbcod;
  private String rowIndex;

  public ReceiveEntryDetailDTO toDTO() {
    return ReceiveEntryDetailDTO.builder().kigbng(this.kigbng).hpnsur(this.hpnsur).rmcod(this.rmcod)
        .skrtan(this.skrtan).tnaste(this.tnaste).hpnkin(this.hpnkin).hjihnb(this.hjihnb)
        .artnm(this.artnm).titnm(this.titnm).hbidte(this.hbidte).tomrakcod(this.tomrakcod)
        .setcod(this.setcod).tnpkbn(this.tnpkbn).daikaiskbcod(this.daikaiskbcod)
        .rowIndex(this.rowIndex).build();
  }

  public static ReceiveEntryDetailForm toForm(ReceiveEntryDetailDTO dto) {
    return ReceiveEntryDetailForm.builder().kigbng(dto.getKigbng()).hpnsur(dto.getHpnsur())
        .rmcod(dto.getRmcod()).skrtan(dto.getSkrtan()).tnaste(dto.getTnaste())
        .hpnkin(dto.getHpnkin()).hjihnb(dto.getHjihnb()).artnm(dto.getArtnm()).titnm(dto.getTitnm())
        .hbidte(dto.getHbidte()).tomrakcod(dto.getTomrakcod()).setcod(dto.getSetcod())
        .tnpkbn(dto.getTnpkbn()).daikaiskbcod(dto.getDaikaiskbcod()).rowIndex(dto.getRowIndex())
        .build();
  }

  public String getAjaxReturn() {
    StringBuilder json = new StringBuilder();
    json.append("{");
    json.append("\"rowIndex\":\"").append(this.rowIndex).append("\",");
    json.append("\"hjihnb\":\"").append(this.hjihnb).append("\",");
    json.append("\"titnm\":\"").append(this.titnm).append("\",");
    json.append("\"artnm\":\"").append(this.artnm).append("\",");
    json.append("\"tnaste\":\"").append(this.tnaste).append("\",");
    json.append("\"hbidte\":\"").append(this.hbidte).append("\",");
    json.append("\"tomrakcod\":\"").append(this.tomrakcod).append("\",");
    json.append("\"setcod\":\"").append(this.setcod).append("\",");
    json.append("\"tnpkbn\":\"").append(this.tnpkbn).append("\"");
    json.append("}");
    return json.toString();
  }
}
