package jp.co.jdsnet.common.domain.mapper.hatchu;

import jp.co.jdsnet.common.domain.entity.hatchu.HatchuWorkEntity;

/**
 * 発注ワークMapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedHatchuWorkMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(HatchuWorkEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HatchuWorkEntity select(HatchuWorkEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HatchuWorkEntity selectWithLockForUpdate(HatchuWorkEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(HatchuWorkEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(HatchuWorkEntity entity);
}
