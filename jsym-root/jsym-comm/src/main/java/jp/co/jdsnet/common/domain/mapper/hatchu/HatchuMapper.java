package jp.co.jdsnet.common.domain.mapper.hatchu;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 発注Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface HatchuMapper extends GeneratedHatchuMapper {

  /**
   * 直近の納期を取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kaiskbcod 会社識別コード
   * @param kigbng 記号番号
   * @return 納期 データが無い場合はnullが返る
   */
  public Integer getNkiMostRecently(@Param("daikaiskbcod") String daikaiskbcod,
      @Param("kaiskbcod") String kaiskbcod, @Param("kigbng") String kigbng);

  /**
   * 入庫予定数を取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kaiskbcod 会社識別コード
   * @param kigbng 記号番号
   * @param nki 納期
   * @return 入庫予定数 データが無い場合はnullが返る
   */
  public Integer getNyukoYoteisuu(@Param("daikaiskbcod") String daikaiskbcod,
      @Param("kaiskbcod") String kaiskbcod, @Param("kigbng") String kigbng, @Param("nki") int nki);
}
