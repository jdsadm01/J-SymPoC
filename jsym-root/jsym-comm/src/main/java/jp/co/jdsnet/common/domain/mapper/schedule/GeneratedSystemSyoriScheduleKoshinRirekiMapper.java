package jp.co.jdsnet.common.domain.mapper.schedule;

import jp.co.jdsnet.common.domain.entity.schedule.SystemSyoriScheduleKoshinRirekiEntity;

/**
 * システム処理スケジュール更新履歴Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedSystemSyoriScheduleKoshinRirekiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(SystemSyoriScheduleKoshinRirekiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  SystemSyoriScheduleKoshinRirekiEntity select(SystemSyoriScheduleKoshinRirekiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  SystemSyoriScheduleKoshinRirekiEntity selectWithLockForUpdate(SystemSyoriScheduleKoshinRirekiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(SystemSyoriScheduleKoshinRirekiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(SystemSyoriScheduleKoshinRirekiEntity entity);
}
