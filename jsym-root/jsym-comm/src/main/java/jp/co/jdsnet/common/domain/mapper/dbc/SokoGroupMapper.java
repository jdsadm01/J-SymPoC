package jp.co.jdsnet.common.domain.mapper.dbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.jdsnet.common.domain.entity.dbc.SokoGroupEntity;

@Mapper
public interface SokoGroupMapper {
	SokoGroupEntity select(SokoGroupEntity entity);
	List<SokoGroupEntity> selectSkocodList(@Param("daikaiskbcod")String daikaiskbcod, @Param("kaiskbcodList")List<String> kaiskbcodList, @Param("pnllstkbn")String pnllstkbn, @Param("skogrpcod")String skogrpcod);
}
