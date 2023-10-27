package jp.co.jdsnet.common.logic;

import java.util.List;

import jp.co.jdsnet.common.domain.vo.EigyoshoSokoGroupVO;

public interface DataGetSharedService {
	
	public List<String> getKaiQueryList(String daikaiskbcod, String kaiskbcod, String tblnm);
	public List<EigyoshoSokoGroupVO> getEigSkoGrpList(String daikaiskbcod, String kaiskbcod, String pnlLstId, String pnlLstKbn, String sykKbn) throws Exception;
}
