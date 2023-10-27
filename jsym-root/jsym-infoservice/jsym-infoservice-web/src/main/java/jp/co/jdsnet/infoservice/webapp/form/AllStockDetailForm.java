package jp.co.jdsnet.infoservice.webapp.form;

import java.io.Serializable;

import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.infoservice.domain.dto.AllStockDetailDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class AllStockDetailForm implements FormInterface,Serializable {

	private static final long serialVersionUID = 1L;

	/** 表示名２（倉庫名） */
	private String hjinm2;
	
	/** 出荷コード */
	private String syacod;
	/** Ｃ直品区分 */
	private String cchhinkbn;

	/** 在庫数量 */
	private int zaisur;
	/** 出荷可能数 */
	private int syaknosur;
	/** 在庫確保仮引当数量 */
	private int zaikhokhasur;
	/** 注残仮引当数量 */
	private int chzkhasur;
	/** 新譜受注仮引当数量 */
	private int sinjuckhasur;
	/** 新譜出荷数量 */
	private int sinsyasur;
	/** 積送残数量 */
	private int sekzansur;
	/** 貸出残数量 */
	private int kdazansur;
	/** 翌営出荷仮引当数量 */
	private int ykesyakhasur;
	/** 当日受注数 */
	private int todjucsur;
	/** 当日出荷数 */
	private int todsyasur;
	/** 当月受注数 */
	private int tomjucsur;
	/** 当月出荷数 */
	private int tomsyasur;
	
	public AllStockDetailDTO toDTO() {
		return AllStockDetailDTO.builder()
				.hjinm2(this.hjinm2)
				.syacod(this.syacod)
				.cchhinkbn(this.cchhinkbn)
				.zaisur(this.zaisur)
				.syaknosur(this.syaknosur)
				.zaikhokhasur(this.zaikhokhasur)
				.chzkhasur(this.chzkhasur)
				.sinjuckhasur(this.sinjuckhasur)
				.sinsyasur(this.sinsyasur)
				.sekzansur(this.sekzansur)
				.kdazansur(this.kdazansur)
				.ykesyakhasur(this.ykesyakhasur)
				.todjucsur(this.todjucsur)
				.todsyasur(this.todsyasur)
				.tomjucsur(this.tomjucsur)
				.tomsyasur(this.tomsyasur)
				.build();
	}

	public static AllStockDetailForm toForm(AllStockDetailDTO dto) {
		return AllStockDetailForm.builder()
				.hjinm2(dto.getHjinm2())
				.syacod(dto.getSyacod())
				.cchhinkbn(dto.getCchhinkbn())
				.zaisur(dto.getZaisur())
				.syaknosur(dto.getSyaknosur())
				.chzkhasur(dto.getChzkhasur())
				.sinjuckhasur(dto.getSinjuckhasur())
				.sinsyasur(dto.getSinsyasur())
				.sekzansur(dto.getSekzansur())
				.kdazansur(dto.getKdazansur())
				.ykesyakhasur(dto.getYkesyakhasur())
				.todjucsur(dto.getTodjucsur())
				.todsyasur(dto.getTodsyasur())
				.tomjucsur(dto.getTomjucsur())
				.tomsyasur(dto.getTomsyasur())
				.build();
	}

}
