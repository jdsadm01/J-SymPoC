package jp.co.jdsnet.common.logic.Implement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jp.co.jdsnet.common.domain.entity.dbc.EigyoshoGroupEntity;
import jp.co.jdsnet.common.domain.entity.dbc.EigyoshoSokoEntity;
import jp.co.jdsnet.common.domain.entity.dbc.KaishaQueryControlEntity;
import jp.co.jdsnet.common.domain.mapper.dbc.EigyoshoGroupMapper;
import jp.co.jdsnet.common.domain.mapper.dbc.EigyoshoSokoMapper;
import jp.co.jdsnet.common.domain.mapper.dbc.KaishaQueryControlMapper;
import jp.co.jdsnet.common.domain.mapper.dbc.SokoGroupMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaMapper;
import jp.co.jdsnet.common.domain.vo.EigyoshoSokoGroupVO;
import jp.co.jdsnet.common.logic.DataGetSharedService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataGetSharedServiceImpl implements DataGetSharedService {

	private final KaishaQueryControlMapper kaishaQueryControlMapper;
	private final KaishaMapper kaishaMapper;
	private final EigyoshoSokoMapper eigyoshoSokoMapper;
	private final EigyoshoGroupMapper eigyoshoGroupMapper;
	private final SokoGroupMapper sokoGroupMapper;
	
	public List<String> getKaiQueryList(String daikaiskbcod, String kaiskbcod, String tblnm){
		List<String> kaiQueryList = new ArrayList<>();
		
		KaishaQueryControlEntity entity = kaishaQueryControlMapper.select(
				KaishaQueryControlEntity.builder()
				.daikaiskbcod(daikaiskbcod)
				.tblnm(tblnm).build());
		
		if(Objects.isNull(entity) || "0".equals(entity.getKaigetkbn())) {
			kaiQueryList.add(daikaiskbcod);
		} else if("1".equals(entity.getKaigetkbn()) 
				|| ("2".equals(entity.getKaigetkbn()) && !daikaiskbcod.equals(kaiskbcod))) {
			kaiQueryList.add(kaiskbcod);
		} else {
			kaiQueryList.addAll(kaishaMapper.selectKaiskbcodList(daikaiskbcod));
		}
		return kaiQueryList;
	}

	public List<EigyoshoSokoGroupVO> getEigSkoGrpList(String daikaiskbcod, String kaiskbcod, String pnlLstId, String pnlLstKbn, String sykKbn) throws Exception {
//		List<EigyoshoSokoGroupVO> result = new LinkedList<>();
		
		List<EigyoshoSokoEntity> eigskoEntityList = eigyoshoSokoMapper.selectEigSkoList(daikaiskbcod, pnlLstId, sykKbn, this.getKaiQueryList(daikaiskbcod, kaiskbcod, "VTBDBC08"), pnlLstKbn);
		
		if(eigskoEntityList.isEmpty()) { throw new Exception(); }

		List<EigyoshoSokoGroupVO> result = eigskoEntityList.stream().map(entity -> {
			List<String> eigcodList = eigyoshoGroupMapper.selectEigcodList(daikaiskbcod, this.getKaiQueryList(daikaiskbcod, kaiskbcod, "VTBDBC09"), pnlLstKbn, entity.getEiggrpcod()).stream()
										.map(t -> t.getEigcod())
										.collect(Collectors.toList());
			if(eigcodList.isEmpty()) {
				eigcodList.add(entity.getEiggrpcod());
			}
			
			List<String> skocodList = sokoGroupMapper.selectSkocodList(daikaiskbcod, this.getKaiQueryList(daikaiskbcod, kaiskbcod, "VTBDBC10"), pnlLstKbn, entity.getSkogrpcod()).stream()
					.map(t -> t.getSkocod())
					.collect(Collectors.toList());
			if(skocodList.isEmpty()) {
				skocodList.add(entity.getSkogrpcod());
			}

//			result.add(EigyoshoSokoGroupVO.builder()
//					.hjinm1(entity.getHjinm1())
//					.hjinm2(entity.getHjinm2())
//					.eiggrpcod(entity.getEiggrpcod())
//					.skogrpcod(entity.getSkogrpcod())
//					.eigcodList(eigcodList)
//					.skocodList(skocodList)
//					.build());
			return EigyoshoSokoGroupVO.builder()
					.hjinm1(entity.getHjinm1())
					.hjinm2(entity.getHjinm2())
					.eiggrpcod(entity.getEiggrpcod())
					.skogrpcod(entity.getSkogrpcod())
					.eigcodList(eigcodList)
					.skocodList(skocodList)
					.build();
		}).collect(Collectors.toList());
		
		return result;
	}
}
