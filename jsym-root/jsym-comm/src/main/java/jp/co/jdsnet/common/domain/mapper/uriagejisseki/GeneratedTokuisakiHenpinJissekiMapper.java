package jp.co.jdsnet.common.domain.mapper.uriagejisseki;

import jp.co.jdsnet.common.domain.entity.uriagejisseki.TokuisakiHenpinJissekiEntity;

/**
 * 得意先返品実績Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedTokuisakiHenpinJissekiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(TokuisakiHenpinJissekiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  TokuisakiHenpinJissekiEntity select(TokuisakiHenpinJissekiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  TokuisakiHenpinJissekiEntity selectWithLockForUpdate(TokuisakiHenpinJissekiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(TokuisakiHenpinJissekiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(TokuisakiHenpinJissekiEntity entity);
}
