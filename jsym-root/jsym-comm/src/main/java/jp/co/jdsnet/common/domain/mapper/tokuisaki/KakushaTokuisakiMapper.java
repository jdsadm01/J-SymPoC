package jp.co.jdsnet.common.domain.mapper.tokuisaki;

import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;

@Mapper
public interface KakushaTokuisakiMapper {
	KakushaTokuisakiEntity selectWithoutLogicalDelete(KakushaTokuisakiEntity entity);
}
