package jp.co.jdsnet.common.domain.mapper.kaisha;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.kaisha.EigyoshoShuyakuSokoShuyakuMidashiEntity;

/**
 * 営業所集約／倉庫集約　見出Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface EigyoshoShuyakuSokoShuyakuMidashiMapper extends GeneratedEigyoshoShuyakuSokoShuyakuMidashiMapper {

  public List<EigyoshoShuyakuSokoShuyakuMidashiEntity> selectEigSkoList(
      @Param("daikaiskbcod") String daikaiskbcod, @Param("gmnlstid") String gmnlstid,
      @Param("fncno") String fncno, @Param("kaiskbcod") String kaiskbcod,
      @Param("gmnlstkbn") String gmnlstkbn);
}
