package jp.co.jdsnet.common.domain.mapper.zaiko;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.zaiko.AzaikoEntity;

/**
 * Ａ在庫Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface AzaikoMapper extends GeneratedAzaikoMapper {

  /**
   * 対象品番の指定倉庫のサマリーを取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param kigbng 記号番号
   * @param skocodList サマリー対象の倉庫リスト
   * @return
   */
  public AzaikoEntity selectSokoSummary(@Param("daikaiskbcod") String daikaiskbcod,
      @Param("kigbng") String kigbng, @Param("skocodList") List<String> skocodList);

  /**
   * 引当可能数算出向けの在庫情報取得
   *
   * @param entity キーをセットしたEntity
   * @return 出荷コード付きA在庫データ
   */
  public AzaikoEntity selectForCalcurateKanosuu(AzaikoEntity entity);
}
