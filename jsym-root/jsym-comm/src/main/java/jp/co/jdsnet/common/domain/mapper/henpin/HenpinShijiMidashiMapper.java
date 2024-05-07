package jp.co.jdsnet.common.domain.mapper.henpin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 返品指示見出Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface HenpinShijiMidashiMapper extends GeneratedHenpinShijiMidashiMapper {

  /**
   * 入力日付・場所におけるSEQを取得する
   *
   * @param inpdte
   * @param bshcod
   * @return 次のSEQ
   */
  public int getNextSeq(@Param("inpdte") int inpdte, @Param("bshcod") String bshcod);
}
