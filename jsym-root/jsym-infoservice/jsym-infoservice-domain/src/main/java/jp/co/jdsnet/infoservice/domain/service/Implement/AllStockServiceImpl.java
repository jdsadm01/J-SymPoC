package jp.co.jdsnet.infoservice.domain.service.Implement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.KaishaEntity;
import jp.co.jdsnet.common.domain.entity.soko.ZaikoJokenEntity;
import jp.co.jdsnet.common.domain.entity.zaiko.AZaikoEntity;
import jp.co.jdsnet.common.domain.mapper.hatchu.HatchuMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaMapper;
import jp.co.jdsnet.common.domain.mapper.soko.ZaikoJokenMapper;
import jp.co.jdsnet.common.domain.mapper.uriagejisseki.EigyoshobetsuHinbanUriageMapper;
import jp.co.jdsnet.common.domain.mapper.zaiko.AZaikoMapper;
import jp.co.jdsnet.common.domain.vo.EigyoshoSokoGroupVO;
import jp.co.jdsnet.common.logic.CheckSharedService;
import jp.co.jdsnet.common.logic.DataGetSharedService;
import jp.co.jdsnet.common.logic.KigbngCheckSharedService;
import jp.co.jdsnet.infoservice.domain.dto.AllStockDTO;
import jp.co.jdsnet.infoservice.domain.dto.AllStockDetailDTO;
import jp.co.jdsnet.infoservice.domain.service.AllStockService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AllStockServiceImpl implements AllStockService {

	private final KaishaMapper kaishaMapper;
	private final EigyoshobetsuHinbanUriageMapper eigyoshobetsuHinbanUriageMapper;
	private final HatchuMapper hatchuMapper;
	private final AZaikoMapper aZaikoMapper;
	private final ZaikoJokenMapper zaikoJokenMapper;

	private final CheckSharedService checkSharedService;
	private final KigbngCheckSharedService kigbngCheckSharedService;
	private final DataGetSharedService dataGetSharedService;
	
	public AllStockDTO init(String daikaiskbcod, String usrbun) {
		boolean isOnline = false; 
		if(CheckSharedService.SERVICETIME_ONLINE.equals(checkSharedService.checkServiceTime(daikaiskbcod, usrbun, "VHJ002", "001", "O"))) {
			isOnline = true;
		}

		boolean isFavorite = false;
//		List<String> lst = kaishaMapper.selectDaikaiskbcodList();
		List<KaishaEntity> lst = kaishaMapper.selectAll(); //StreamAPIのサンプル用にこれで取得
		
		return AllStockDTO.builder()
				.daikaiskbcodList(lst.stream()
						.map(t -> t.getDaikaiskbcod())
						.distinct()
						.collect(Collectors.toList()))
				.isInServiceTime(isOnline)
				.isFavoriteAuthority(isFavorite)
				.build();
	}
	
	public AllStockDTO search(AllStockDTO dto) throws Exception {
		//サービス時間チェック
		boolean isOnline = false; 
		if(CheckSharedService.SERVICETIME_ONLINE.equals(
				checkSharedService.checkServiceTime(
						dto.getKaiskbcod(), dto.getUserMap().get("usrbun"), "VHJ002", "001", "S"))) {
			isOnline = true;
		}

		//権限チェック
		boolean isFavorite = false;
		
		//会社チェック
		KaishaEntity kaishaEntity;
		try {
			checkSharedService.checkDaikaiskbcod(dto.getKaiskbcod(), dto.getUserMap().get("daikaiskbcod"));
			String checkcod = ("JDS".equals(dto.getUserMap().get("daikaiskbcod"))) ? dto.getKaiskbcod() : dto.getUserMap().get("kaiskbcod"); 
			kaishaEntity = kaishaMapper.select(KaishaEntity.builder().kaiskbcod(checkcod).build());
			//checkSharedService.checkKyoten(kaishaEntity.getDaikaiskbcod(), dto.getUserMap().get("usrbun"));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		//品番チェック
		HinbanEntity hinbanEntity = getHinban(kaishaEntity.getDaikaiskbcod(), dto.getKigbng());

		//売上累計取得
		int urisurrui = eigyoshobetsuHinbanUriageMapper.getUrisurruiSummary(kaishaEntity.getDaikaiskbcod(), hinbanEntity.getKigbng());

		//ワーニング
		Map<String, Boolean> w_warning = new HashMap<>();
		w_warning.put("isSyaStop", false);
		w_warning.put("isChzFka", false);
		setSykkaStopChzBadByTomRak(hinbanEntity.getTomrakcod(), w_warning);
		
		//発注情報取得
		List<Map<String, Integer>> hatchYoteList = hatchuMapper.selectHatchuyoteiList(
				kaishaEntity.getDaikaiskbcod(), hinbanEntity.getKigbng()
				, dataGetSharedService.getKaiQueryList(kaishaEntity.getDaikaiskbcod(), kaishaEntity.getKaiskbcod(), "JTBTRN12V"));
		
		//出荷制限取得
		
		//在庫情報取得
		List<EigyoshoSokoGroupVO> eigSkoList = dataGetSharedService.getEigSkoGrpList(kaishaEntity.getDaikaiskbcod(), kaishaEntity.getKaiskbcod(), "VHJ002", "1", "1");
		
		List<AllStockDetailDTO> detail = eigSkoList.stream().map(t -> {
			AZaikoEntity aZaikoEntity = aZaikoMapper.selectAZaikoSkoSum(hinbanEntity.getDaikaiskbcod(), hinbanEntity.getKigbng(), t.getSkocodList());
			//可能数取得
			int syaknosuu = 5;
			ZaikoJokenEntity zaikojokenEntity = zaikoJokenMapper.select(ZaikoJokenEntity.builder()
					.daikaiskbcod(hinbanEntity.getDaikaiskbcod())
					.kigbng(hinbanEntity.getKigbng())
					.skocod(t.getSkogrpcod()).build());
			//在庫条件が取得できなかった時の処理
			if(Objects.isNull(zaikojokenEntity)) {
				//倉庫グループだから取得できなかった
				zaikojokenEntity = ZaikoJokenEntity.builder().build();
				
				//倉庫コードでレコードがなかった
				//前の倉庫の出荷コードとC直をセットする
			};
			//出荷コードの判別
			//・・・
			
			return AllStockDetailDTO.builder()
					.hjinm2(t.getHjinm2())
					.syacod(zaikojokenEntity.getSyacod())
					.cchhinkbn(zaikojokenEntity.getCchhinkbn())
					.zaisur(aZaikoEntity.getZaisur())
					.syaknosur(syaknosuu)
					.zaikhokhasur(aZaikoEntity.getZaikhokhasur())
					.chzkhasur(aZaikoEntity.getChzkhasur())
					.sinjuckhasur(aZaikoEntity.getSinjuckhasur())
					.sinsyasur(aZaikoEntity.getSinsyasur())
					.sekzansur(aZaikoEntity.getSekzansur())
					.kdazansur(aZaikoEntity.getKdazansur())
					.ykesyakhasur(aZaikoEntity.getYkesyakhasur())
					.todjucsur(aZaikoEntity.getTodjucsur())
					.todsyasur(aZaikoEntity.getTodsyasur())
					.tomjucsur(aZaikoEntity.getTomjucsur())
					.tomsyasur(aZaikoEntity.getTomsyasur())
					.build();
		}).collect(Collectors.toList());
		
		AllStockDTO ret = dto.toBuilder() //dtoを複製して必要な項目を置き換える
				.kigbng(hinbanEntity.getKigbng())
				.hjihnb(hinbanEntity.getHjihnb())
				.artnm(hinbanEntity.getArtnm())
				.titnm(hinbanEntity.getTitnm())
				.hbidte(hinbanEntity.getHbidte())
				.setsuu(hinbanEntity.getSetsuu())
				.znupri(hinbanEntity.getZnupri())
				.skrtanipn(setSkrtanipn(hinbanEntity))
				.ketcod(hinbanEntity.getKetcod())
				.mngflg(hinbanEntity.getMngflg())
				.rhbhnb(hinbanEntity.getRhbhnb())
				.tomrakcod(hinbanEntity.getTomrakcod())
				.uriruisur(urisurrui)
				.detailList(detail)
				.build();
		return ret;
	}
	
	private void setSykkaStopChzBadByTomRak(String tomrakcod, Map<String, Boolean> w_warning) {
		switch(tomrakcod.trim()) {
		case("D"):
			w_warning.replace("isChzFka", true);
			break;
		case("E"):
		case("F"):
		case("FF"):
			w_warning.replace("isSyaStop", true);
			break;
		default:
		}
	}
	
	private double setSkrtanipn(HinbanEntity hinbanEntity) {
		if("CO".equals(hinbanEntity.getDaikaiskbcod().trim())
				||"FDI".equals(hinbanEntity.getDaikaiskbcod())
				||"K".equals(hinbanEntity.getDaikaiskbcod().trim())
				||"VAP".equals(hinbanEntity.getDaikaiskbcod())) {
			return hinbanEntity.getSkrtanipn();
		} else {
			return 0d;
		}
	}
	
	private HinbanEntity getHinban(String daikaiskbcod, String kigbng) throws Exception {
		//品番チェック
		HinbanEntity hinbanEntity = kigbngCheckSharedService.getHinban(daikaiskbcod, kigbng);
		if("D".equals(hinbanEntity.getUpdkbn())) {
			throw new Exception();
		}
		return hinbanEntity;
	}
}
