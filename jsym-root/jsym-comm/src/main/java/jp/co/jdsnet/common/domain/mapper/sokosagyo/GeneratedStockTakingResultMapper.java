package jp.co.jdsnet.common.domain.mapper.sokosagyo;

import jp.co.jdsnet.common.domain.entity.sokosagyo.StockTakingResultEntity;

/**
 * 棚卸結果テーブルMapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedStockTakingResultMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(StockTakingResultEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  StockTakingResultEntity select(StockTakingResultEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  StockTakingResultEntity selectWithLockForUpdate(StockTakingResultEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(StockTakingResultEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(StockTakingResultEntity entity);
}
