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
public class KaishaQueryControlEntity {
	/** 代表会社識別コード */
	@Builder.Default
	private String daikaiskbcod = "";

	/** テーブル名 */
	@Builder.Default
	private String tblnm = "";

	/** 会社取得区分 */
	@Builder.Default
	private String kaigetkbn = "";

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
