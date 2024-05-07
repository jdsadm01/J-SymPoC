package jp.co.jdsnet.common.domain.mapper.schedule;

import jp.co.jdsnet.common.domain.entity.schedule.SystemSyoriScheduleSaibanEntity;

/**
 * システム処理スケジュール採番Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedSystemSyoriScheduleSaibanMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(SystemSyoriScheduleSaibanEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  SystemSyoriScheduleSaibanEntity select(SystemSyoriScheduleSaibanEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  SystemSyoriScheduleSaibanEntity selectWithLockForUpdate(SystemSyoriScheduleSaibanEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(SystemSyoriScheduleSaibanEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(SystemSyoriScheduleSaibanEntity entity);
}
