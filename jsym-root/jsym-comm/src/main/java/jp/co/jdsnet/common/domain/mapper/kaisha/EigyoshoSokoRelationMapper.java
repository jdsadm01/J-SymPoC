package jp.co.jdsnet.common.domain.mapper.kaisha;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.kaisha.EigyoshoSokoRelationEntity;

/**
 * 営業所倉庫対応テーブルMapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface EigyoshoSokoRelationMapper extends GeneratedEigyoshoSokoRelationMapper {

  public List<EigyoshoSokoRelationEntity> selectEigSkoList(
      @Param("daikaiskbcod") String daikaiskbcod, @Param("pnllstid") String pnllstid,
      @Param("sykkbn") String syykbn, @Param("kaiskbcod") String kaiskbcod,
      @Param("pnllstkbn") String pnllstkbn);
}
