package jp.co.jdsnet.common.domain.mapper.juchu;

import jp.co.jdsnet.common.domain.entity.juchu.ShinpuScheduleEntity;

/**
 * 新譜スケジュールMapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedShinpuScheduleMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(ShinpuScheduleEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ShinpuScheduleEntity select(ShinpuScheduleEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ShinpuScheduleEntity selectWithLockForUpdate(ShinpuScheduleEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(ShinpuScheduleEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(ShinpuScheduleEntity entity);
}
