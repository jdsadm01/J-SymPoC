package jp.co.jdsnet.common.domain.mapper.menu;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.menu.GamenTrncodControlEntity;

/**
 * 画面別トラン制御テーブルMapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface GamenTrncodControlMapper extends GeneratedGamenTrncodControlMapper {

  /**
   * プルダウン名トランリスト取得
   * <p>
   * VTBMNU11・VTBMNU12・AESYSM31を検索し、使用可能なプルダウンとプルダウン名のリストを返します。
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param mnuptncod メニューパターンコード
   * @param gmnid 画面ID
   * @return 取得したデータ
   */
  public List<GamenTrncodControlEntity> selectTrncodList(@Param("daikaiskbcod") String daikaiskbcod,
      @Param("mnuptncod") String mnuptncod, @Param("gmnid") String gmnid);

}
