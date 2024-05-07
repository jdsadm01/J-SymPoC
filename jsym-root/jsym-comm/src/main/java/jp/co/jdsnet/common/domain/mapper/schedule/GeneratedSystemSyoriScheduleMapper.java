package jp.co.jdsnet.common.domain.mapper.schedule;

import jp.co.jdsnet.common.domain.entity.schedule.SystemSyoriScheduleEntity;

/**
 * システム処理スケジュールMapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedSystemSyoriScheduleMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(SystemSyoriScheduleEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  SystemSyoriScheduleEntity select(SystemSyoriScheduleEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  SystemSyoriScheduleEntity selectWithLockForUpdate(SystemSyoriScheduleEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(SystemSyoriScheduleEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(SystemSyoriScheduleEntity entity);
}
