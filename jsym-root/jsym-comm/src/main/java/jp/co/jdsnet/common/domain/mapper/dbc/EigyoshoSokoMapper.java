package jp.co.jdsnet.common.domain.mapper.dbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.jdsnet.common.domain.entity.dbc.EigyoshoSokoEntity;

@Mapper
public interface EigyoshoSokoMapper {
	EigyoshoSokoEntity select(EigyoshoSokoEntity entity);
	List<EigyoshoSokoEntity> selectEigSkoList(@Param("daikaiskbcod")String daikaiskbcod, @Param("pnllstid")String pnllstid, @Param("sykkbn")String sykkbn, @Param("kaiskbcodList")List<String> kaiskbcodList, @Param("pnllstkbn")String pnllstkbn);
}
