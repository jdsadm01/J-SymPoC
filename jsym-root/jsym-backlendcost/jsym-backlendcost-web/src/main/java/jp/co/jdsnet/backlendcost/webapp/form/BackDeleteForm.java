package jp.co.jdsnet.backlendcost.webapp.form;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDetailDTO;
import jp.co.jdsnet.backlendcost.webapp.copydata.BackDeleteCBData;
import jp.co.jdsnet.base.webapp.form.DBCopyForm;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@Builder(toBuilder = true)
@Controller // ラジオボタン用
public class BackDeleteForm extends DBCopyForm<BackDeleteCBData>
    implements FormInterface<BackDeleteDTO>, Serializable {

  private static final long serialVersionUID = 1L;

  @NotBlank
  @Size(max = 3)
  private String kaiskbcod; // 会社識別

  private String mkrbuncod; // メーカー分類(テーブル物理名引用)
  private String skocod; // 倉庫コード

  private String kigbng; // 記号番号

  private String tokcod; // 得意先
  private String dscod; // DS
  private String eigcod; // 営業所
  private String tercod; // テリトリー
  private String prckbn; // 処理区分
  private String jucdtefrom; // 受注日From
  private String jucdteto; // 受注日To
  private String hbidtefrom; // 発売日From
  private String hbidteto; // 発売日To

  public BackDeleteDetailDTO toDTO() {
    return BackDeleteDetailDTO.builder().kaiskbcod(this.kaiskbcod).mkrbuncod(this.mkrbuncod)
        .skocod(this.skocod).kigbng(this.kigbng).tokcod(this.tokcod).dscod(this.dscod)
        .eigcod(this.eigcod).tercod(this.tercod).prckbn(this.prckbn).jucdtefrom(this.jucdtefrom)
        .jucdteto(this.jucdteto).hbidtefrom(this.hbidtefrom).hbidteto(this.hbidteto).build();
  }

  public static BackDeleteForm toForm(BackDeleteDTO dto) {

    return BackDeleteForm.builder().kaiskbcod(dto.kaiskbcod()).mkrbuncod(dto.mkrbuncod())
        .skocod(dto.skocod()).kigbng(dto.kigbng()).tokcod(dto.tokcod()).dscod(dto.dscod())
        .eigcod(dto.eigcod()).tercod(dto.tercod()).prckbn(dto.prckbn()).jucdtefrom(dto.jucdtefrom())
        .jucdteto(dto.jucdteto()).hbidtefrom(dto.hbidtefrom()).hbidteto(dto.hbidteto()).build();
  }



  // 以下ラジオボタン
  private Map<String, String> radioTokcod;

  private Map<String, String> initRadioTokcod() {

    Map<String, String> radioTokcod = new LinkedHashMap<>();
    radioTokcod.put("1", "単独店");
    radioTokcod.put("2", "単独店");

    return radioTokcod;
  }

  protected String createRadioTokcod(BackDeleteForm form, Model model) {

    radioTokcod = initRadioTokcod();
    model.addAttribute("radioTokCod", radioTokcod);

    BackDeleteForm.setRadioTokcod("1");
    model.addAttribute("BackDeleteForm", BackDeleteForm);

    return "createRadioTokcod";
  }



}
