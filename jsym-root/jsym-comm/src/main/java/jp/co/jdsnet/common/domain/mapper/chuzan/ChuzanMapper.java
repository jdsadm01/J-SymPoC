package jp.co.jdsnet.common.domain.mapper.chuzan;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.chuzan.ChuzanEntity;

@Mapper
public interface ChuzanMapper {
  List<ChuzanEntity> select(String daikaiskbcod, String pageKey);

  int selectCount(ChuzanEntity entity);

  void update(ChuzanEntity entity);
}
