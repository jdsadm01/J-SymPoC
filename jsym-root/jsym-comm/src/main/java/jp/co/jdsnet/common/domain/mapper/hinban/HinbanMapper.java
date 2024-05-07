package jp.co.jdsnet.common.domain.mapper.hinban;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;

/**
 * 品番Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface HinbanMapper extends GeneratedHinbanMapper {

  /**
   * 記号番号・JANCOD・省略品番のいずれかに該当する品番を取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kigbng 記号番号
   * @param kaiskbcod 会社識別コード 代表会社識別コードと同一の場合は検索条件に含めない
   * @return HinbanEntityのList
   */
  List<HinbanEntity> selectByInputKigbng(@Param("daikaiskbcod") String daikaiskbcod,
      @Param("kigbng") String kigbng, @Param("kaiskbcod") String kaiskbcod);
}
