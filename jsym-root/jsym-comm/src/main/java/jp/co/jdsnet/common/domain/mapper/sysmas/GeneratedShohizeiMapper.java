package jp.co.jdsnet.common.domain.mapper.sysmas;

import jp.co.jdsnet.common.domain.entity.sysmas.ShohizeiEntity;

/**
 * 消費税Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedShohizeiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(ShohizeiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ShohizeiEntity select(ShohizeiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ShohizeiEntity selectWithLockForUpdate(ShohizeiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(ShohizeiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(ShohizeiEntity entity);
}