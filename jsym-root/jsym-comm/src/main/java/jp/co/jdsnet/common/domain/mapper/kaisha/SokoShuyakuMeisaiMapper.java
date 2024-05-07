package jp.co.jdsnet.common.domain.mapper.kaisha;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.kaisha.SokoShuyakuMeisaiEntity;

/**
 * 倉庫集約明細Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface SokoShuyakuMeisaiMapper extends GeneratedSokoShuyakuMeisaiMapper {

  /**
   * 画面・帳票、倉庫集約コードに紐づく、データの一覧を取得する
   *
   * @param daikaiskbcod
   * @param kaiskbcod
   * @param gmnlstkbn
   * @param skosyycod
   * @return
   */
  public List<SokoShuyakuMeisaiEntity> selectSkocodList(@Param("daikaiskbcod") String daikaiskbcod,
      @Param("kaiskbcod") String kaiskbcod, @Param("gmnlstkbn") String gmnlstkbn,
      @Param("skosyycod") String skosyycod);
}
