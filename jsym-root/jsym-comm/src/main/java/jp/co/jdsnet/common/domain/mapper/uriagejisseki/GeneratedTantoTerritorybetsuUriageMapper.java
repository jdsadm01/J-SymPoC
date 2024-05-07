package jp.co.jdsnet.common.domain.mapper.uriagejisseki;

import jp.co.jdsnet.common.domain.entity.uriagejisseki.TantoTerritorybetsuUriageEntity;

/**
 * 担当テリトリー別売上Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedTantoTerritorybetsuUriageMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(TantoTerritorybetsuUriageEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  TantoTerritorybetsuUriageEntity select(TantoTerritorybetsuUriageEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  TantoTerritorybetsuUriageEntity selectWithLockForUpdate(TantoTerritorybetsuUriageEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(TantoTerritorybetsuUriageEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(TantoTerritorybetsuUriageEntity entity);
}
