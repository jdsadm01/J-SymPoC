package jp.co.jdsnet.common.domain.entity.dbc;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SokoGroupEntity {
	/** 代表会社識別コード */
	@Builder.Default
	private String daikaiskbcod = "";

	/** 会社識別コード */
	@Builder.Default
	private String kaiskbcod = "";

	/** 画面帳票区分 */
	@Builder.Default
	private String pnllstkbn = "";

	/** 倉庫グループコード */
	@Builder.Default
	private String skogrpcod = "";

	/** 倉庫コード */
	@Builder.Default
	private String skocod = "";

	/** 表示順 */
	@Builder.Default
	private int hjijun = 0;

	/** 最新更新区分 */
	@Builder.Default
	private String updkbn = "";

	/** 最新更新日付 */
	@Builder.Default
	private int upddte = 0;

	/** 最新更新時刻 */
	@Builder.Default
	private int updjkk = 0;
}
