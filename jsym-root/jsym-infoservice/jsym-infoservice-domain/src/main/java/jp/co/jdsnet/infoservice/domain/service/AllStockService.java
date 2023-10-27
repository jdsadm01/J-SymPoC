package jp.co.jdsnet.infoservice.domain.service;

import jp.co.jdsnet.infoservice.domain.dto.AllStockDTO;

public interface AllStockService {

	/**
	 * 画面表示の初期処理を行う
	 * @return
	 */
	public AllStockDTO init(String daikaiskbcod, String usrbun);

	/**
	 * 検索処理を行う
	 * @return
	 */
	public AllStockDTO search(AllStockDTO dto) throws Exception;
}
