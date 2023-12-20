package jp.co.jdsnet.common.domain.mapper.hinban;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;

@Mapper
public interface HinbanMapper {
  HinbanEntity select(HinbanEntity entity);

  List<HinbanEntity> selectByInputKigbng(@Param("daikaiskbcod") String daikaiskbcod,
      @Param("inpKigbng") String inpKigbng);
}
