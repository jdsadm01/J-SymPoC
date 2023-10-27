package jp.co.jdsnet.common.domain.mapper.hatchu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface HatchuMapper {
    List<Map<String, Integer>> selectHatchuyoteiList(@Param("daikaiskbcod") String daikaiskbcod, @Param("kigbng") String kigbng, @Param("kaiskbcodList") List<String> kaiskbcodList);
}
