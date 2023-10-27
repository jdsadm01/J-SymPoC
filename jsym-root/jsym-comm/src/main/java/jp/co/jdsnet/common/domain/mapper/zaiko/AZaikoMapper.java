package jp.co.jdsnet.common.domain.mapper.zaiko;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.jdsnet.common.domain.entity.zaiko.AZaikoEntity;

@Mapper
public interface AZaikoMapper {
	AZaikoEntity select(AZaikoEntity entity);
	AZaikoEntity selectAZaikoSkoSum(@Param("daikaiskbcod")String daikaiskbcod, @Param("kigbng")String kigbng, @Param("skocodList")List<String> skocodList);
}
