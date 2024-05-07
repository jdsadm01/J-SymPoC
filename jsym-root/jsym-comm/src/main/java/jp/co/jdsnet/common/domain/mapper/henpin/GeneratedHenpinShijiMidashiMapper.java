package jp.co.jdsnet.common.domain.mapper.henpin;

import jp.co.jdsnet.common.domain.entity.henpin.HenpinShijiMidashiEntity;

/**
 * 返品指示見出Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedHenpinShijiMidashiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(HenpinShijiMidashiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HenpinShijiMidashiEntity select(HenpinShijiMidashiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HenpinShijiMidashiEntity selectWithLockForUpdate(HenpinShijiMidashiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(HenpinShijiMidashiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(HenpinShijiMidashiEntity entity);
}
