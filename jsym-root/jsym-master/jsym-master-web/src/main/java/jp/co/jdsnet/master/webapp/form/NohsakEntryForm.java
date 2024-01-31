package jp.co.jdsnet.master.webapp.form;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.master.domain.dto.NohsakEntryDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NohsakEntryForm implements Serializable, FormInterface<NohsakEntryDTO> {
  private static final long serialVersionUID = 1L;

  /** 予約 */
  private String yykflg;
  /** 予約日付 */
  private String yykdte;
  /** 場所コード */
  private String bshcod;
  /** 処理区分 */
  private String prckbn;
  /** 明細 */
  @Valid
  private List<NohsakEntryDetailForm> detailList;

  @Override
  public NohsakEntryDTO toDTO(UserInfoVO userVo) {
    return NohsakEntryDTO.builder().userInfo(userVo).yykflg(this.yykflg).yykdte(this.yykdte)
        .bshcod(this.bshcod).prckbn(this.prckbn).detailList(Optional.ofNullable(this.detailList)
            .stream().flatMap(x -> x.stream()).map(t -> t.toDTO()).collect(Collectors.toList()))
        .build();
  }

  /**
   * DTOからFormに変換する
   * 
   * @param dto
   * @return
   */
  public static NohsakEntryForm toForm(NohsakEntryDTO dto) {
    return NohsakEntryForm.builder().yykflg(dto.getYykflg()).yykdte(dto.getYykdte())
        .bshcod(dto.getBshcod()).prckbn(dto.getPrckbn())
        .detailList(Optional.ofNullable(dto.getDetailList()).stream().flatMap(x -> x.stream())
            .map(t -> t.transform(NohsakEntryDetailForm::toForm)).collect(Collectors.toList()))
        .build();
  }
}
