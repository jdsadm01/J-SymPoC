package jp.co.jdsnet.common.domain.mapper.uriagejisseki;

import jp.co.jdsnet.common.domain.entity.uriagejisseki.HinbanTokuisakibetsuJissekiHatsubaiEntity;

/**
 * 品番得意先別実績（発売）Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedHinbanTokuisakibetsuJissekiHatsubaiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(HinbanTokuisakibetsuJissekiHatsubaiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HinbanTokuisakibetsuJissekiHatsubaiEntity select(HinbanTokuisakibetsuJissekiHatsubaiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HinbanTokuisakibetsuJissekiHatsubaiEntity selectWithLockForUpdate(HinbanTokuisakibetsuJissekiHatsubaiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(HinbanTokuisakibetsuJissekiHatsubaiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(HinbanTokuisakibetsuJissekiHatsubaiEntity entity);
}
