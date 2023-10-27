package jp.co.jdsnet.common.domain.mapper.uriagejisseki;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EigyoshobetsuHinbanUriageMapper {
	int getUrisurruiSummary(@Param("daikaiskbcod") String daikaiskbcod, @Param("kigbng") String kigbng);
}
