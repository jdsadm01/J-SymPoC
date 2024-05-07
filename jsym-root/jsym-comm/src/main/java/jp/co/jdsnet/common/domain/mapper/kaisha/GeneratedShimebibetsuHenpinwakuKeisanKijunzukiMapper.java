package jp.co.jdsnet.common.domain.mapper.kaisha;

import jp.co.jdsnet.common.domain.entity.kaisha.ShimebibetsuHenpinwakuKeisanKijunzukiEntity;

/**
 * 締日別返品枠計算基準月Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedShimebibetsuHenpinwakuKeisanKijunzukiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(ShimebibetsuHenpinwakuKeisanKijunzukiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ShimebibetsuHenpinwakuKeisanKijunzukiEntity select(ShimebibetsuHenpinwakuKeisanKijunzukiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ShimebibetsuHenpinwakuKeisanKijunzukiEntity selectWithLockForUpdate(ShimebibetsuHenpinwakuKeisanKijunzukiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(ShimebibetsuHenpinwakuKeisanKijunzukiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(ShimebibetsuHenpinwakuKeisanKijunzukiEntity entity);
}
