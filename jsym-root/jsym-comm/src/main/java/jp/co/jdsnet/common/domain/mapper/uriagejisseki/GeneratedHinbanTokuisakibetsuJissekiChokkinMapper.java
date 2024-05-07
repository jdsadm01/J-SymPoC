package jp.co.jdsnet.common.domain.mapper.uriagejisseki;

import jp.co.jdsnet.common.domain.entity.uriagejisseki.HinbanTokuisakibetsuJissekiChokkinEntity;

/**
 * 品番得意先別実績（直近）Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedHinbanTokuisakibetsuJissekiChokkinMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(HinbanTokuisakibetsuJissekiChokkinEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HinbanTokuisakibetsuJissekiChokkinEntity select(HinbanTokuisakibetsuJissekiChokkinEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HinbanTokuisakibetsuJissekiChokkinEntity selectWithLockForUpdate(HinbanTokuisakibetsuJissekiChokkinEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(HinbanTokuisakibetsuJissekiChokkinEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(HinbanTokuisakibetsuJissekiChokkinEntity entity);
}
