package jp.co.jdsnet.common.domain.entity.dbc;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EigyoshoGroupEntity {
	/** 代表会社識別コード */
	@Builder.Default
	private String daikaiskbcod = "";

	/** 会社識別コード */
	@Builder.Default
	private String kaiskbcod = "";

	/** 画面帳票区分 */
	@Builder.Default
	private String pnllstkbn = "";

	/** 営業所グループコード */
	@Builder.Default
	private String eiggrpcod = "";

	/** 営業所コード */
	@Builder.Default
	private String eigcod = "";

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
