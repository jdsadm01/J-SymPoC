package jp.co.jdsnet.common.domain.mapper.chuzan;

import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.chuzan.ChuzanEntity;

@Mapper
public interface ChuzanMapper {
  ChuzanEntity select(ChuzanEntity entity);
  ChuzanEntity selectCount(ChuzanEntity entity);
}
