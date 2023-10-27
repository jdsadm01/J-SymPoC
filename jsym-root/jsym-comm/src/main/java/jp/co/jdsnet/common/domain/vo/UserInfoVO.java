package jp.co.jdsnet.common.domain.vo;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoVO {

	/** ユーザーID */
	@Builder.Default
	private String usrid = "";
	
	/** ユーザー名 */
	@Builder.Default
	private String usrnm = "";
	
	/** 代表会社識別コード */
	@Builder.Default
	private String daikaiskbcod = "";
	
	/** 会社識別コード */
	@Builder.Default
	private String kaiskbcod = "";
	
	/** ユーザー分類 */
	@Builder.Default
	private String usrbun = "";
	
	/** 場所コード */
	@Builder.Default
	private String bshcod = "";
	
	/** メニューグループコード */
	@Builder.Default
	private String mnugrpcod = "";
	
	/** 前回アクセス時間 */
	@Setter
	@Builder.Default
	private LocalDateTime lastAccessTime = LocalDateTime.now();
}
