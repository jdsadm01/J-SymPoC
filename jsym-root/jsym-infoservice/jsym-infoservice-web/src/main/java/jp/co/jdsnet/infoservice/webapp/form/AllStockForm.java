package jp.co.jdsnet.infoservice.webapp.form;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jp.co.jdsnet.base.annotation.FieldOrder;
import jp.co.jdsnet.base.webapp.form.DBCopyForm;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.infoservice.domain.dto.AllStockDTO;
import jp.co.jdsnet.infoservice.webapp.copydata.AllStockCBData;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 全国在庫照会Form.
 *
 * @author Ryo.Matsumura
 */
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AllStockForm extends DBCopyForm<AllStockCBData>
    implements FormInterface<AllStockDTO>, Serializable {

  private static final long serialVersionUID = 1L;

  @NotBlank
  @Size(max = 3)
  @FieldOrder(1)
  private String kaiskbcod;

  @NotBlank
//  @FormatDate(format = FormatDate.FormatType.YYMMDD)
  @Size(max = 13)
  @FieldOrder(2)
  private String kigbng;

  private List<String> daikaiskbcodList;

  private boolean isInServiceTime;
  private boolean isFavoriteAuthority;

  private String hjihnb;
  private String artnm;
  private String titnm;
  private int hbidte;
  private int setsuu;
  private String tomrakcod;
  private double skrtanipn;
  private double znupri;
  private String ketcod;
  private String mngflg;
  private String rhbhnb;

  private int uriruisur;

  private List<AllStockDetailForm> detailList;

  @Override
  public AllStockDTO toDTO(UserInfoVO userVo) {
    return AllStockDTO.builder()
        .userInfo(userVo)
        .kaiskbcod(this.kaiskbcod)
        .kigbng(this.kigbng)
        .build();
  }

  /**
   * DTOからFormへ変換する.
   *
   * @param dto AllStockDTO
   * @return form
   */
  public static AllStockForm toForm(AllStockDTO dto) {
    return AllStockForm.builder()
        .kaiskbcod(dto.getKaiskbcod())
        .kigbng(dto.getKigbng())
        .daikaiskbcodList(dto.getDaikaiskbcodList())
        .isInServiceTime(dto.isInServiceTime())
        .isFavoriteAuthority(dto.isFavoriteAuthority())
        .hjihnb(dto.getHjihnb())
        .artnm(dto.getArtnm())
        .titnm(dto.getTitnm())
        .hbidte(dto.getHbidte())
        .setsuu(dto.getSetsuu())
        .znupri(dto.getZnupri())
        .skrtanipn(dto.getSkrtanipn())
        .ketcod(dto.getKetcod())
        .mngflg(dto.getMngflg())
        .rhbhnb(dto.getRhbhnb())
        .tomrakcod(dto.getTomrakcod())
        .uriruisur(dto.getUriruisur())
        .detailList(Optional.ofNullable(dto.getDetailList()).stream().flatMap(x -> x.stream())
            .map(t -> t.transform(AllStockDetailForm::toForm)).collect(Collectors.toList()))
        .build();
  }
}
