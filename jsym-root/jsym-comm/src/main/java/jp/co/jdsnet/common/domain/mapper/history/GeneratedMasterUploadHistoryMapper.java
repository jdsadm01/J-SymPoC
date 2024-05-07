package jp.co.jdsnet.common.domain.mapper.history;

import jp.co.jdsnet.common.domain.entity.history.MasterUploadHistoryEntity;

/**
 * マスターアップロード履歴Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedMasterUploadHistoryMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(MasterUploadHistoryEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  MasterUploadHistoryEntity select(MasterUploadHistoryEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  MasterUploadHistoryEntity selectWithLockForUpdate(MasterUploadHistoryEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(MasterUploadHistoryEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(MasterUploadHistoryEntity entity);
}
