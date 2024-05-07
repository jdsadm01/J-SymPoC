package jp.co.jdsnet.common.domain.mapper.sysmas;

import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.sysmas.JsymMsEntity;

/**
 * ＭＳマスターMapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface JsymMsMapper extends GeneratedJsymMsMapper {

  /**
   * 論理削除を除外し主キー検索を行う
   *
   * @param entity 条件をセットしたEntity
   * @return 検索結果
   */
  public JsymMsEntity selectWithoutLogicalDelete(JsymMsEntity entity);
}
