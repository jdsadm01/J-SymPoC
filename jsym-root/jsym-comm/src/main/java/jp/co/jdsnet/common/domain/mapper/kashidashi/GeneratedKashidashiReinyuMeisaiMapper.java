package jp.co.jdsnet.common.domain.mapper.kashidashi;

import jp.co.jdsnet.common.domain.entity.kashidashi.KashidashiReinyuMeisaiEntity;

/**
 * 貸出戻入明細Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedKashidashiReinyuMeisaiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(KashidashiReinyuMeisaiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  KashidashiReinyuMeisaiEntity select(KashidashiReinyuMeisaiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  KashidashiReinyuMeisaiEntity selectWithLockForUpdate(KashidashiReinyuMeisaiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(KashidashiReinyuMeisaiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(KashidashiReinyuMeisaiEntity entity);
}
