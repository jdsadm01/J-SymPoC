package jp.co.jdsnet.common.domain.mapper.sysmas;

import jp.co.jdsnet.common.domain.entity.sysmas.JsymMsEntity;

/**
 * ＭＳマスターMapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedJsymMsMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(JsymMsEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  JsymMsEntity select(JsymMsEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  JsymMsEntity selectWithLockForUpdate(JsymMsEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(JsymMsEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(JsymMsEntity entity);
}
