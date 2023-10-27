package jp.co.jdsnet.common.logic;

public interface CheckSharedService {

	String SERVICETIME_ONLINE = "0";
	String SERVICETIME_SUBTIME = "1";
	String SERVICETIME_TIMEOUT = "2";
	
	public String checkServiceTime(String daikaiskbcod, String usrbun, String gmnid, String gmnseq, String gmnkbn);
	
	public void checkDaikaiskbcod(String checkCode, String usrDaikaiskbcod) throws Exception;
}
