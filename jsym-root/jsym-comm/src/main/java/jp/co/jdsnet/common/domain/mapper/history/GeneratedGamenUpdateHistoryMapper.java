package jp.co.jdsnet.common.domain.mapper.history;

import jp.co.jdsnet.common.domain.entity.history.GamenUpdateHistoryEntity;

/**
 * 画面用更新履歴テーブルMapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedGamenUpdateHistoryMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(GamenUpdateHistoryEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  GamenUpdateHistoryEntity select(GamenUpdateHistoryEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  GamenUpdateHistoryEntity selectWithLockForUpdate(GamenUpdateHistoryEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(GamenUpdateHistoryEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(GamenUpdateHistoryEntity entity);
}
