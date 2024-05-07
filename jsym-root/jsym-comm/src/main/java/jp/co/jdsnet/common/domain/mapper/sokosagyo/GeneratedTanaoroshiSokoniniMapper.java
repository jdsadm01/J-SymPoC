package jp.co.jdsnet.common.domain.mapper.sokosagyo;

import jp.co.jdsnet.common.domain.entity.sokosagyo.TanaoroshiSokoniniEntity;

/**
 * 棚卸（倉庫任意）Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedTanaoroshiSokoniniMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(TanaoroshiSokoniniEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  TanaoroshiSokoniniEntity select(TanaoroshiSokoniniEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  TanaoroshiSokoniniEntity selectWithLockForUpdate(TanaoroshiSokoniniEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(TanaoroshiSokoniniEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(TanaoroshiSokoniniEntity entity);
}
