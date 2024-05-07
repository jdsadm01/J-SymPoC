package jp.co.jdsnet.common.domain.mapper.jokensettei;

import jp.co.jdsnet.common.domain.entity.jokensettei.ListBashoJuzokuKaishaEntity;

/**
 * リスト場所従属会社Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedListBashoJuzokuKaishaMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(ListBashoJuzokuKaishaEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ListBashoJuzokuKaishaEntity select(ListBashoJuzokuKaishaEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ListBashoJuzokuKaishaEntity selectWithLockForUpdate(ListBashoJuzokuKaishaEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(ListBashoJuzokuKaishaEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(ListBashoJuzokuKaishaEntity entity);
}
