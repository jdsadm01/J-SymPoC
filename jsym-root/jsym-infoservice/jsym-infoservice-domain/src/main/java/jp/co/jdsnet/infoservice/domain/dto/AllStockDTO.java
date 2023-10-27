package jp.co.jdsnet.infoservice.domain.dto;

import java.util.List;

import jp.co.jdsnet.base.domain.dto.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor(access=AccessLevel.NONE)
public class AllStockDTO extends AbstractDTO {
	private String kaiskbcod;
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
	
	private List<AllStockDetailDTO> detailList;
}
