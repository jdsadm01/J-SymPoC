package jp.co.jdsnet.common.domain.mapper.soko;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.soko.GameKyotsuTokuisakiHenkanEntity;

/**
 * ゲーム共通得意先変換Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface GameKyotsuTokuisakiHenkanMapper extends GeneratedGameKyotsuTokuisakiHenkanMapper {

  /**
   * 主キー検索し、共通得意先から名称を合わせて取得する
   *
   * @param entity 主キーをセット
   * @return 検索結果
   */
  GameKyotsuTokuisakiHenkanEntity selectWithName(GameKyotsuTokuisakiHenkanEntity entity);

  /**
   * ゲーム共通得意先で検索し、共通得意先から名称を合わせて取得する
   *
   * @param bshcod 場所コード
   * @param gkytokcod ゲーム共通得意先コード
   * @return
   */
  List<GameKyotsuTokuisakiHenkanEntity> selectWithNameByGkytokcod(@Param("bshcod") String bshcod,
      @Param("gkytokcod") String gkytokcod);
}
