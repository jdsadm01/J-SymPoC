package jp.co.jdsnet.common.domain.mapper.kaisha;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 会社Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface KaishaMapper extends GeneratedKaishaMapper {

  /**
   * 代表会社識別コードの一覧を取得する。 必要に応じてソートすること。
   *
   * @param usrbun ユーザー分類
   * @return 代表会社識別コードリスト
   */
  public List<String> getDaikaiskbcodList(@Param("usrbun") String usrbun);

  /**
   * 代表会社識別コードに対する会社識別コードの一覧を取得する。
   *
   * @param daikaiskbcod 代表会社識別コード
   * @return 会社識別コードリスト
   */
  public List<String> getKaiskbcodList(@Param("daikaiskbcod") String daikaiskbcod);
}
