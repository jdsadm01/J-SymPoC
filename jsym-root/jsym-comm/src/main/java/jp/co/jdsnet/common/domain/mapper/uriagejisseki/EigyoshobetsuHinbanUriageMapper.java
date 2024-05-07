package jp.co.jdsnet.common.domain.mapper.uriagejisseki;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 営業所別品番売上Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface EigyoshobetsuHinbanUriageMapper extends GeneratedEigyoshobetsuHinbanUriageMapper {
  /**
   * 対象の品番の売上数累計の全営業所合計を取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kigbng 記号番号
   * @return
   */
  int getUrisurruiSummary(@Param("daikaiskbcod") String daikaiskbcod,
      @Param("kigbng") String kigbng);
}
