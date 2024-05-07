package jp.co.jdsnet.common.domain.mapper.menu;

import jp.co.jdsnet.common.domain.entity.menu.UseCategoryEntity;

/**
 * 使用カテゴリマスタMapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedUseCategoryMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(UseCategoryEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  UseCategoryEntity select(UseCategoryEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  UseCategoryEntity selectWithLockForUpdate(UseCategoryEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(UseCategoryEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(UseCategoryEntity entity);
}
