package jp.co.jdsnet.common.domain.mapper.hinban;

import jp.co.jdsnet.common.domain.entity.hinban.HaibanEntity;

/**
 * 廃盤Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedHaibanMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(HaibanEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HaibanEntity select(HaibanEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HaibanEntity selectWithLockForUpdate(HaibanEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(HaibanEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(HaibanEntity entity);
}
