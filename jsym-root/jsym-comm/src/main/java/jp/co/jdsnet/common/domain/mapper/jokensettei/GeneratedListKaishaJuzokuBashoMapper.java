package jp.co.jdsnet.common.domain.mapper.jokensettei;

import jp.co.jdsnet.common.domain.entity.jokensettei.ListKaishaJuzokuBashoEntity;

/**
 * リスト会社従属場所Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedListKaishaJuzokuBashoMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(ListKaishaJuzokuBashoEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ListKaishaJuzokuBashoEntity select(ListKaishaJuzokuBashoEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ListKaishaJuzokuBashoEntity selectWithLockForUpdate(ListKaishaJuzokuBashoEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(ListKaishaJuzokuBashoEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(ListKaishaJuzokuBashoEntity entity);
}
