package jp.co.jdsnet.common.domain.mapper.kaisha;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.kaisha.EigyoshoShuyakuMeisaiEntity;

/**
 * 営業所集約明細Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface EigyoshoShuyakuMeisaiMapper extends GeneratedEigyoshoShuyakuMeisaiMapper {

  /**
   * 画面・帳票、営業所集約コードに紐づく、データの一覧を取得する
   *
   * @param daikaiskbcod
   * @param kaiskbcod
   * @param gmnlstkbn
   * @param eigsyycod
   * @return
   */
  public List<EigyoshoShuyakuMeisaiEntity> selectEigcodList(
      @Param("daikaiskbcod") String daikaiskbcod,
      @Param("kaiskbcod") String kaiskbcod, @Param("gmnlstkbn") String gmnlstkbn,
      @Param("eigsyycod") String eigsyycod);
}
