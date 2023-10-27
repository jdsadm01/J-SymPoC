package jp.co.jdsnet.infoservice.webapp.form;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.ui.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.infoservice.domain.dto.AllStockDTO;
import jp.co.jdsnet.infoservice.webapp.copydata.AllStockCBData;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class AllStockForm implements FormInterface<AllStockDTO>,Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(max=3)
	private String kaiskbcod;
	@NotBlank(message= "{Not_Blank}")
	@Size(max=13)
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

	private String ttfld;
	
	@Override
	public AllStockDTO toDTO(ConcurrentHashMap<String,String> userMap) {
		return AllStockDTO.builder()
				.userMap(userMap)
				.kaiskbcod(this.kaiskbcod)
				.kigbng(this.kigbng)
				.build();
	}

	/**
	 * DTOからFormへ変換する
	 * @param dto
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
				.detailList(Optional.ofNullable(dto.getDetailList()).stream()
						.flatMap(x -> x.stream())
						.map(t -> t.transform(AllStockDetailForm::toForm))
						.collect(Collectors.toList()))
//				.ttfld(test())
				.build();
	}
	
	private static String test() {
		Model model = null;
		new AllStockCBData(model, AllStockForm.builder().build());
		return "a";
	}

}
