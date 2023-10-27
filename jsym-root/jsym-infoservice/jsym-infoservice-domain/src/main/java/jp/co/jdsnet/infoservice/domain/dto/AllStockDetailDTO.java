package jp.co.jdsnet.infoservice.domain.dto;

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
public class AllStockDetailDTO extends AbstractDTO {
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
}
