package jp.co.jdsnet.common.domain.mapper.tokuisaki;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.tokuisaki.HinbanTokuisakiKakeritsuTankaEntity;

/**
 * 品番得意先掛率単価Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface HinbanTokuisakiKakeritsuTankaMapper extends GeneratedHinbanTokuisakiKakeritsuTankaMapper {

  /**
   * 対象期間のデータを取得する
   *
   * @param entity 主キーをセット
   * @param kkn 対象期間yyMMdd
   * @return
   */
  public HinbanTokuisakiKakeritsuTankaEntity selectKrtTan(
      HinbanTokuisakiKakeritsuTankaEntity entity, @Param("kkn") int kkn);
}
