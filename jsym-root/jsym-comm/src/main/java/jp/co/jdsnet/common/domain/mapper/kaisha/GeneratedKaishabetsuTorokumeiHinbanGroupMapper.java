package jp.co.jdsnet.common.domain.mapper.kaisha;

import jp.co.jdsnet.common.domain.entity.kaisha.KaishabetsuTorokumeiHinbanGroupEntity;

/**
 * 会社別登録名（品番グループ）Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedKaishabetsuTorokumeiHinbanGroupMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(KaishabetsuTorokumeiHinbanGroupEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  KaishabetsuTorokumeiHinbanGroupEntity select(KaishabetsuTorokumeiHinbanGroupEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  KaishabetsuTorokumeiHinbanGroupEntity selectWithLockForUpdate(KaishabetsuTorokumeiHinbanGroupEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(KaishabetsuTorokumeiHinbanGroupEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(KaishabetsuTorokumeiHinbanGroupEntity entity);
}
