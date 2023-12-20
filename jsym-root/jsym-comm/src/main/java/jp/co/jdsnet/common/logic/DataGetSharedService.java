package jp.co.jdsnet.common.logic;

import java.util.List;
import jp.co.jdsnet.common.domain.vo.EigyoshoSokoGroupVO;
import jp.co.jdsnet.common.domain.vo.TokuisakiAndDsVO;

public interface DataGetSharedService {
	
	public List<String> getKaiQueryList(String daikaiskbcod, String kaiskbcod, String tblnm);
	public List<EigyoshoSokoGroupVO> getEigSkoGrpList(String daikaiskbcod, String kaiskbcod, String pnlLstId, String pnlLstKbn, String sykKbn) throws Exception;
	public TokuisakiAndDsVO getKyotsuAndKakushaTokuisakiData(String daikaiskbcod, String tokcod) throws Exception;
	public String convertTokcod8kt(String daikaiskbcod, String tokcod) throws Exception;
}
