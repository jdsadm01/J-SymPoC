package jp.co.jdsnet.common.domain.mapper.soko;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.soko.GameKyotsuTokuisakiHenkanEntity;

@Mapper
public interface GameKyotsuTokuisakiHenkanMapper extends GeneratedGameKyotsuTokuisakiHenkanMapper {
  GameKyotsuTokuisakiHenkanEntity selectWithName(GameKyotsuTokuisakiHenkanEntity entity);

  List<GameKyotsuTokuisakiHenkanEntity> selectWithNameByGyktokcod(
      GameKyotsuTokuisakiHenkanEntity entity);
}
