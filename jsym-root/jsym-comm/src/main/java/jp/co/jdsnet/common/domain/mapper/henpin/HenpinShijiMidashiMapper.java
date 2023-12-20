package jp.co.jdsnet.common.domain.mapper.henpin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HenpinShijiMidashiMapper extends GeneratedHenpinShijiMidashiMapper {

  int getNextSeq(@Param("inpdte") int inpdte, @Param("bshcod") String bshcod);
}
