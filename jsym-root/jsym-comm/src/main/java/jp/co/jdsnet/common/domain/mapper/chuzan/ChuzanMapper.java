package jp.co.jdsnet.common.domain.mapper.chuzan;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.chuzan.ChuzanEntity;

@Mapper
public interface ChuzanMapper {
  ChuzanEntity select(String daikaiskbcod);


  int selectCount(ChuzanEntity entity, List<String> pageKey);
}
