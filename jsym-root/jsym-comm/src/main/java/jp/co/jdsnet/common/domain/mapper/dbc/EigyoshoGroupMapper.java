package jp.co.jdsnet.common.domain.mapper.dbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.jdsnet.common.domain.entity.dbc.EigyoshoGroupEntity;

@Mapper
public interface EigyoshoGroupMapper {
	EigyoshoGroupEntity select(EigyoshoGroupEntity entity);
	List<EigyoshoGroupEntity> selectEigcodList(@Param("daikaiskbcod")String daikaiskbcod, @Param("kaiskbcodList")List<String> kaiskbcodList, @Param("pnllstkbn")String pnllstkbn, @Param("eiggrpcod")String eiggrpcod);
}
