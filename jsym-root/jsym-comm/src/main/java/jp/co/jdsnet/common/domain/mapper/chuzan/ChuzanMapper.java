package jp.co.jdsnet.common.domain.mapper.chuzan;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.chuzan.ChuzanEntity;
import jp.co.jdsnet.common.domain.entity.chuzan.GeneratedChuzanEntity;

@Mapper
public interface ChuzanMapper {
  List<ChuzanEntity> select(ChuzanEntity entity);

  int selectCount(ChuzanEntity entity);

  int selectTotalchzSur(ChuzanEntity entity);

  void update(GeneratedChuzanEntity updChuzanEntityList);

  GeneratedChuzanEntity selectOnly(ChuzanEntity entity);
}
