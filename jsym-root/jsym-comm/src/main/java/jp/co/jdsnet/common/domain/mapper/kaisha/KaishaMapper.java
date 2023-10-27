package jp.co.jdsnet.common.domain.mapper.kaisha;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.jdsnet.common.domain.entity.kaisha.KaishaEntity;

@Mapper
public interface KaishaMapper {
    List<String> selectKaiskbcodList(@Param("daikaiskbcod") String daikaiskbcod);
    List<String> selectDaikaiskbcodList();
    List<KaishaEntity> selectAll();
    KaishaEntity select(KaishaEntity entity);
}
