package jp.co.jdsnet.common.domain.mapper.dbc;

import org.apache.ibatis.annotations.Mapper;

import jp.co.jdsnet.common.domain.entity.dbc.KaishaQueryControlEntity;

@Mapper
public interface KaishaQueryControlMapper {
	KaishaQueryControlEntity select(KaishaQueryControlEntity entity);
}
