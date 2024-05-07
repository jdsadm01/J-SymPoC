package jp.co.jdsnet.common.domain.mapper.soko;

import jp.co.jdsnet.common.domain.entity.soko.BashobetsuHaisoHomenZokuseiEntity;

/**
 * 場所別配送方面属性Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedBashobetsuHaisoHomenZokuseiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(BashobetsuHaisoHomenZokuseiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  BashobetsuHaisoHomenZokuseiEntity select(BashobetsuHaisoHomenZokuseiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  BashobetsuHaisoHomenZokuseiEntity selectWithLockForUpdate(BashobetsuHaisoHomenZokuseiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(BashobetsuHaisoHomenZokuseiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(BashobetsuHaisoHomenZokuseiEntity entity);
}
