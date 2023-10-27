package jp.co.jdsnet.common.domain.mapper.soko;

import org.apache.ibatis.annotations.Mapper;

import jp.co.jdsnet.common.domain.entity.soko.ZaikoJokenEntity;

@Mapper
public interface ZaikoJokenMapper {
	ZaikoJokenEntity select(ZaikoJokenEntity entity);
}
