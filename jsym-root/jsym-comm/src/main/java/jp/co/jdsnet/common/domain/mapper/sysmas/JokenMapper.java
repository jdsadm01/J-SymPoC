package jp.co.jdsnet.common.domain.mapper.sysmas;

import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.sysmas.JokenEntity;

/**
 * 条件テーブルMapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface JokenMapper extends GeneratedJokenMapper {

  /**
   * 論理削除を除外し、主キー検索を行う
   *
   * @param entity 検索条件をセットしたEntity
   * @return 検索結果
   */
  public JokenEntity selectWithoutLogicalDelete(JokenEntity entity);
}
