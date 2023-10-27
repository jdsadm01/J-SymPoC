package jp.co.jdsnet.common.logic;

import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;

public interface KigbngCheckSharedService {

	public HinbanEntity getHinban(String daikaiskbcod, String kigbng) throws Exception;
	public HinbanEntity getHinbanByJutaku(String daikaiskbcod, String kaiskbcod, String kigbng) throws Exception;
	public String makeKigBng(String daikaiskbcod, String kigbng) throws Exception;
}
