package jp.co.jdsnet.common.domain.mapper.soko;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.soko.ZaikoJokenEntity;

@Mapper
public interface ZaikoJokenMapper {
	ZaikoJokenEntity select(ZaikoJokenEntity entity);
	List<ZaikoJokenEntity> selectForTnasth(@Param("daikaiskbcod") String daikaiskbcod, @Param("kigbng") String kigbng);
}
