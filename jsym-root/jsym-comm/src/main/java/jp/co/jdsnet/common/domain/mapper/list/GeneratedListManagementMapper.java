package jp.co.jdsnet.common.domain.mapper.list;

import jp.co.jdsnet.common.domain.entity.list.ListManagementEntity;

/**
 * 帳票管理テーブルMapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedListManagementMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(ListManagementEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ListManagementEntity select(ListManagementEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ListManagementEntity selectWithLockForUpdate(ListManagementEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(ListManagementEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(ListManagementEntity entity);
}
