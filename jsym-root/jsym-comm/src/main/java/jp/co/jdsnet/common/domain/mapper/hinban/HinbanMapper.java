package jp.co.jdsnet.common.domain.mapper.hinban;


import org.apache.ibatis.annotations.Mapper;

import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;

@Mapper
public interface HinbanMapper {
	HinbanEntity select(HinbanEntity entity);
}
