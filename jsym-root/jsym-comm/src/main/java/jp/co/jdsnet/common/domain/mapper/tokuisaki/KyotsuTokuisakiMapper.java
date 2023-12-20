package jp.co.jdsnet.common.domain.mapper.tokuisaki;

import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KyotsuTokuisakiEntity;

@Mapper
public interface KyotsuTokuisakiMapper {
	KyotsuTokuisakiEntity selectWithoutLogicalDelete(KyotsuTokuisakiEntity entity);
}
