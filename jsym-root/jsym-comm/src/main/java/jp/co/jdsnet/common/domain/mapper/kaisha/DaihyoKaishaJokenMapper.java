package jp.co.jdsnet.common.domain.mapper.kaisha;

import org.apache.ibatis.annotations.Mapper;

import jp.co.jdsnet.common.domain.entity.kaisha.DaihyoKaishaJokenEntity;

@Mapper
public interface DaihyoKaishaJokenMapper {
    DaihyoKaishaJokenEntity select(DaihyoKaishaJokenEntity entity);
}
