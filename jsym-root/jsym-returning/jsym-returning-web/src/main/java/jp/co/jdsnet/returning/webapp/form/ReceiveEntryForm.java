package jp.co.jdsnet.returning.webapp.form;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.groups.Default;
import jp.co.jdsnet.base.annotation.CheckDate;
import jp.co.jdsnet.base.annotation.CheckDate.AllowException;
import jp.co.jdsnet.base.annotation.CheckDate.FormatType;
import jp.co.jdsnet.base.annotation.CheckRelationRequired;
import jp.co.jdsnet.base.annotation.CheckString;
import jp.co.jdsnet.base.annotation.CheckString.CheckStyle;
import jp.co.jdsnet.base.annotation.Size;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.base.webapp.parts.LabelData;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.returning.domain.dto.ReceiveEntryDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 返品入力Form
 *
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
// @CheckRelationDate(firstField = "tokcod", secondField = "hpnjurdte", mode = CheckMode.AFTER)
// @NotBlankAny(fields = {/* "fmg2", */"mscod", "fmg1"})
@CheckRelationRequired(checkField = "tokcod", condField = "dscod")
public class ReceiveEntryForm implements FormInterface<ReceiveEntryDTO>, Serializable {

  // トラン等により必須チェックの有無が変わる場合はgroupで指定する
  public interface Trn260Barcode extends Default {
  }
  public interface Trn262Barcode extends Default {
  }
  // public interface Trn260 extends Default {}
  // public interface Trn262 extends Default {}
  // public interface Trn232 extends Default {}
  // public interface Trn292 extends Default {}
  // public interface Trn277 extends Default {}
  // public interface Trn287 extends Default {}

  private static final long serialVersionUID = 1L;

  @Size(max = 1)
  private String stasteflg;

  @Size(max = 6)
  @CheckDate(format = FormatType.YYMMDD, allow = AllowException.NOT_ALLOW)
  private String stakjydte;

  @NotBlank
  @Size(max = 3)
  private String daikaiskbcod;

  @NotBlank
  private String trncod;

  @NotBlank
  @Size(min = 3, max = 8)
  @CheckString(style = CheckStyle.ASCII_DIGIT)
  // @Range(min = 0.1, max = 100)
  // @CheckLengthDecimalPlaces(1)
  private String tokcod;

  @CheckString(style = CheckStyle.ASCII_DIGIT)
  private String dscod;

  private String rmcod;

  @NotBlank
  @Size(max = 6)
  @CheckDate(format = FormatType.YYMMDD, allow = AllowException.NOT_ALLOW)
  private String hpnjurdte;

  @NotBlank
  @Size(max = 5)
  private String hpnutkbng;

  @NotBlank(groups = {Trn260Barcode.class, Trn262Barcode.class})
  private String ttlsur;

  private String kinhjikbn;

  private String knrkbn;

  private String smtcod;

  private String skrkrt;

  private String hpntsyukeflg;

  private String locbng;

  private String tokdenbng1;

  private String tokdenbng2;

  private String odrno;

  private String mscod;

  private String fmg1;

  private String fmg2;


  private String stano;

  private String toknm;

  private String telbng;

  private String smedte;

  @Valid
  private List<ReceiveEntryDetailForm> detailList;

  private List<String> daikaiskbcodList;
  private List<LabelData> trncodList;
  private List<LabelData> rmcodList;
  private List<LabelData> kinhjikbnList;
  private List<LabelData> hpntsyukeflgList;


  @Override
  public ReceiveEntryDTO toDTO(UserInfoVO userVo) {
    return ReceiveEntryDTO.builder().userInfo(userVo).daikaiskbcod(this.daikaiskbcod)
        .trncod(this.trncod).tokcod(this.tokcod).dscod(this.dscod).rmcod(this.rmcod)
        .hpnjurdte(this.hpnjurdte).hpnutkbng(this.hpnutkbng).ttlsur(this.ttlsur)
        .kinhjikbn(this.kinhjikbn).knrkbn(this.knrkbn).smtcod(this.smtcod).skrkrt(this.skrkrt)
        .hpntsyukeflg(this.hpntsyukeflg).locbng(this.locbng).tokdenbng1(this.tokdenbng1)
        .tokdenbng2(this.tokdenbng2).odrno(this.odrno).mscod(this.mscod).fmg1(this.fmg1)
        .fmg2(this.fmg2).stano(this.stano).toknm(this.toknm).telbng(this.telbng).smedte(this.smedte)
        .trncodList(this.trncodList).rmcodList(this.rmcodList).kinhjikbnList(this.kinhjikbnList)
        .hpntsyukeflgList(this.hpntsyukeflgList)
        .detailList(Optional.ofNullable(this.detailList).stream().flatMap(x -> x.stream())
            .map(t -> t.toDTO()).collect(Collectors.toList()))
        .build();
  }

  /**
   * DTOからFormへ変換する.
   *
   * @param dto AllStockDTO
   * @return form
   */
  public static ReceiveEntryForm toForm(ReceiveEntryDTO dto) {
    return ReceiveEntryForm.builder().daikaiskbcod(dto.getDaikaiskbcod()).trncod(dto.getTrncod())
        .tokcod(dto.getTokcod()).dscod(dto.getDscod()).rmcod(dto.getRmcod())
        .hpnjurdte(dto.getHpnjurdte()).hpnutkbng(dto.getHpnutkbng()).ttlsur(dto.getTtlsur())
        .kinhjikbn(dto.getKinhjikbn()).knrkbn(dto.getKnrkbn()).smtcod(dto.getSmtcod())
        .skrkrt(dto.getSkrkrt()).hpntsyukeflg(dto.getHpntsyukeflg()).locbng(dto.getLocbng())
        .tokdenbng1(dto.getTokdenbng1()).tokdenbng2(dto.getTokdenbng2()).odrno(dto.getOdrno())
        .mscod(dto.getMscod()).fmg1(dto.getFmg1()).fmg2(dto.getFmg2()).stano(dto.getStano())
        .toknm(dto.getToknm()).telbng(dto.getTelbng()).smedte(dto.getSmedte())
        .daikaiskbcodList(dto.getDaikaiskbcodList()).trncodList(dto.getTrncodList())
        .rmcodList(dto.getRmcodList()).kinhjikbnList(dto.getKinhjikbnList())
        .hpntsyukeflgList(dto.getHpntsyukeflgList())
        .detailList(Optional.ofNullable(dto.getDetailList()).stream().flatMap(x -> x.stream())
            .map(t -> t.transform(ReceiveEntryDetailForm::toForm)).collect(Collectors.toList()))
        .build();
  }
}
