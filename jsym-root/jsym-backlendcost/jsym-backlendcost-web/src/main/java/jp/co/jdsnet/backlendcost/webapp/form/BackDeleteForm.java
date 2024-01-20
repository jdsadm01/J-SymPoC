package jp.co.jdsnet.backlendcost.webapp.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
import jp.co.jdsnet.backlendcost.webapp.copydata.BackDeleteCBData;
import jp.co.jdsnet.base.annotation.CheckAsciiDigit;
import jp.co.jdsnet.base.annotation.FormatDate;
import jp.co.jdsnet.base.webapp.form.DBCopyForm;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.base.webapp.parts.LabelData;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class BackDeleteForm extends DBCopyForm<BackDeleteCBData>
    implements FormInterface<BackDeleteDTO>, Serializable {

  private static final long serialVersionUID = 1L;

  @NotBlank
  @Size(max = 3)
  private String kaiskbcod; // 会社識別

  @Size(max = 1)
  private String mkrbuncod; // メーカー分類(テーブル物理名引用)

  @Size(max = 3)
  private String skocod; // 倉庫コード

  @Size(max = 13)
  private String kigbng; // 記号番号

  @Size(max = 8)
  @CheckAsciiDigit
  private String tokcod; // 得意先

  @Size(max = 3)
  @CheckAsciiDigit
  private String dscod; // DS

  @Size(max = 2)
  @CheckAsciiDigit
  private String eigcod; // 営業所

  @Size(max = 4)
  @CheckAsciiDigit
  private String tercod; // テリトリー


  private String updkbn; // 処理区分

  @Size(max = 6)
  @CheckAsciiDigit
  @FormatDate(format = FormatDate.FormatType.YYMMDD)
  private String jucdtefrom; // 受注日From

  @Size(max = 6)
  @CheckAsciiDigit
  @FormatDate(format = FormatDate.FormatType.YYMMDD)
  private String jucdteto; // 受注日To

  @Size(max = 6)
  @CheckAsciiDigit
  @FormatDate(format = FormatDate.FormatType.YYMMDD)
  private String hbidtefrom; // 発売日From

  @Size(max = 6)
  @CheckAsciiDigit
  @FormatDate(format = FormatDate.FormatType.YYMMDD)
  private String hbidteto; // 発売日To

  @AssertTrue(message = "M分類、記号番号、得意先、受注日、発売日いずれかを入力してください")
  public boolean isTextEmpty() {
    // ここに任意の相関チェックを実装
    if (StringUtils.isEmpty(mkrbuncod) && StringUtils.isEmpty(kigbng) && StringUtils.isEmpty(tokcod)
        && StringUtils.isEmpty(jucdtefrom) && StringUtils.isEmpty(jucdteto)
        && StringUtils.isEmpty(hbidtefrom) && StringUtils.isEmpty(hbidteto)) {
      return false;
    }
    return true;
  }


  private String titnm;
  private String artnm;
  private String toknm;
  private String dsnm;

  private int chzCnt;
  private int chzsurTotal;

  @Pattern(regexp = "true")
  private String allDeletechk;

  // public String getallDeletechk() {
  // return allDeletechk;
  // }
  // public void setallDeletechk(String allDeletechk) {
  // this.allDeletechk = allDeletechk;
  // }
  //

  @Valid
  private List<BackDeleteDetailForm> detailList;

  private List<String> detailBottomList;

  private List<LabelData> tokkbnList; // 得意先区分ラジオボタン用
  private List<LabelData> updkbnList; // 処理区分
  private List<BackDeleteDetailForm> deleteList; // 削除チェックがされている明細

  private String pageKeyPrev;
  private String pageKeyNow;
  private String pageKeyNext;
  private int pageNo;
  private boolean prevFlg;
  private boolean nextFlg;
  private boolean delchk;

  private Map<String, String> radioTokcod;
  private String tokkbn;
  private List<String> checkList;


  private Map<Integer, String> checkBoxDelete;
  private HashMap<Integer, String> keyMap;



  @Override
  public BackDeleteDTO toDTO(UserInfoVO userVo) {
    return BackDeleteDTO.builder().userInfo(userVo).kaiskbcod(this.kaiskbcod.toUpperCase())
        .mkrbuncod(this.mkrbuncod).skocod(this.skocod).kigbng(this.kigbng).tokcod(this.tokcod)
        .dscod(this.dscod).eigcod(this.eigcod).tercod(this.tercod).updkbn(this.updkbn)
        .jucdtefrom(this.jucdtefrom).jucdteto(this.jucdteto).hbidtefrom(this.hbidtefrom)
        .hbidteto(this.hbidteto).titnm(this.titnm).artnm(this.artnm).toknm(this.toknm)
        .dsnm(this.dsnm).chzCnt(this.chzCnt).chzsurTotal(this.chzsurTotal)
        .allDeletechk(this.allDeletechk).detailBottomList(this.detailBottomList)
        .tokkbnList(this.tokkbnList).updkbnList(this.updkbnList).checkBoxDelete(this.checkBoxDelete)
        .detailList(Optional.ofNullable(this.detailList).stream().flatMap(x -> x.stream())
            .map(t -> t.toDTO()).collect(Collectors.toList()))
        .deleteList(Optional.ofNullable(this.deleteList).stream().flatMap(x -> x.stream())
            .map(t -> t.toDTO()).collect(Collectors.toList()))
        .pageKeyPrev(this.pageKeyPrev).pageKeyNow(this.pageKeyNow).pageKeyNext(this.pageKeyNext)
        .pageNo(this.pageNo).prevFlg(this.prevFlg).nextFlg(this.nextFlg)
        .radioTokcod(this.radioTokcod).build();
  }

  /**
   * DTOからFormへ変換する.
   *
   * @param dto BackDeleteDTO
   * @return form
   */
  public static BackDeleteForm toForm(BackDeleteDTO dto) {

    return BackDeleteForm.builder().kaiskbcod(dto.getKaiskbcod()).mkrbuncod(dto.getMkrbuncod())
        .skocod(dto.getSkocod()).kigbng(dto.getKigbng()).tokcod(dto.getTokcod())
        .dscod(dto.getDscod()).eigcod(dto.getEigcod()).tercod(dto.getTercod())
        .updkbn(dto.getUpdkbn()).jucdtefrom(dto.getJucdtefrom()).jucdteto(dto.getJucdteto())
        .hbidtefrom(dto.getHbidtefrom()).hbidteto(dto.getHbidteto()).titnm(dto.getTitnm())
        .artnm(dto.getArtnm()).toknm(dto.getToknm()).dsnm(dto.getDsnm()).chzCnt(dto.getChzCnt())
        .chzsurTotal(dto.getChzsurTotal()).allDeletechk(dto.getAllDeletechk())
        .detailBottomList(dto.getDetailBottomList()).updkbnList(dto.getUpdkbnList())
        .tokkbnList(dto.getTokkbnList()).pageKeyPrev(dto.getPageKeyPrev())
        .pageKeyNow(dto.getPageKeyNow()).pageKeyNext(dto.getPageKeyNext()).pageNo(dto.getPageNo())
        .prevFlg(dto.isPrevFlg()).nextFlg(dto.isNextFlg()).checkBoxDelete(dto.getCheckBoxDelete())
        .detailList(Optional.ofNullable(dto.getDetailList()).stream().flatMap(x -> x.stream())
            .map(t -> t.transform(BackDeleteDetailForm::toForm)).collect(Collectors.toList()))
        .deleteList(Optional.ofNullable(dto.getDeleteList()).stream().flatMap(x -> x.stream())
            .map(t -> t.transform(BackDeleteDetailForm::toForm)).collect(Collectors.toList()))
        .radioTokcod(dto.getRadioTokcod()).build();
  }

  //
  // protected String createRadioTokcod(BackDeleteForm form, Model model) {
  //
  // radioTokcod = initRadioTokcod();
  // model.addAttribute("radioTokCod", radioTokcod);
  //
  // // BackDeleteForm.setRadioTokcod("1");
  // // model.addAttribute("BackDeleteForm", BackDeleteForm);
  //
  // return "createRadioTokcod";
  // }



}
