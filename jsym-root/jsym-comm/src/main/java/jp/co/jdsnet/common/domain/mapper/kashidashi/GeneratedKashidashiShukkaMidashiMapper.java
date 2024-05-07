package jp.co.jdsnet.common.domain.mapper.kashidashi;

import jp.co.jdsnet.common.domain.entity.kashidashi.KashidashiShukkaMidashiEntity;

/**
 * 貸出出荷見出Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedKashidashiShukkaMidashiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(KashidashiShukkaMidashiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  KashidashiShukkaMidashiEntity select(KashidashiShukkaMidashiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  KashidashiShukkaMidashiEntity selectWithLockForUpdate(KashidashiShukkaMidashiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(KashidashiShukkaMidashiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(KashidashiShukkaMidashiEntity entity);
}
