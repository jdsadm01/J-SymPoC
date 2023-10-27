package jp.co.jdsnet.common.domain.vo;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EigyoshoSokoGroupVO {

	/** 表示名１ */
	@Builder.Default
	private String hjinm1 = "";

	/** 表示名２ */
	@Builder.Default
	private String hjinm2 = "";

	/** 営業所グループコード */
	@Builder.Default
	private String eiggrpcod = "";

	/** 倉庫グループコード */
	@Builder.Default
	private String skogrpcod = "";

	/** 営業所コードリスト */
	@Builder.Default
	private List<String> eigcodList = null;

	/** 倉庫コードリスト */
	@Builder.Default
	private List<String> skocodList = null;

}
