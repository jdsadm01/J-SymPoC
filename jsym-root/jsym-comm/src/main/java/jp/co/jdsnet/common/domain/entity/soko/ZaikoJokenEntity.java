package jp.co.jdsnet.common.domain.entity.soko;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ZaikoJokenEntity {
	/** 代表会社識別コード */
	@Builder.Default
	private String daikaiskbcod = "";

	/** 記号番号 */
	@Builder.Default
	private String kigbng = "";

	/** 倉庫コード */
	@Builder.Default
	private String skocod = "";

	/** 旧譜ストック棚番 */
	@Builder.Default
	private String kyustotnb = "";

	/** 旧譜ピック棚番 */
	@Builder.Default
	private String kyupictnb = "";

	/** 棚上指定品区分 */
	@Builder.Default
	private String tnasthkbn = "";

	/** 棚上指示下限数量 */
	@Builder.Default
	private int tnasjikagsur = 0;

	/** 棚上指示上限数量 */
	@Builder.Default
	private int tnasjijogsur = 0;

	/** Ｃ直品区分 */
	@Builder.Default
	private String cchhinkbn = "";

	/** 常備品区分 */
	@Builder.Default
	private String jybhinkbn = "";

	/** 出荷コード */
	@Builder.Default
	private String syacod = "";

	/** 特殊料金区分 */
	@Builder.Default
	private String tsyrynkbn = "";

	/** 更新区分 */
	@Builder.Default
	private String updkbn = "";

	/** 更新日付 */
	@Builder.Default
	private int upddte = 0;

	/** 更新時刻 */
	@Builder.Default
	private int updjkk = 0;
}
