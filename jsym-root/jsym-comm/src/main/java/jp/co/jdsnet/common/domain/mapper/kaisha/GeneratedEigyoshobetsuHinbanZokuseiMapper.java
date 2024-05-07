package jp.co.jdsnet.common.domain.mapper.kaisha;

import jp.co.jdsnet.common.domain.entity.kaisha.EigyoshobetsuHinbanZokuseiEntity;

/**
 * 営業所別品番属性Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedEigyoshobetsuHinbanZokuseiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(EigyoshobetsuHinbanZokuseiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  EigyoshobetsuHinbanZokuseiEntity select(EigyoshobetsuHinbanZokuseiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  EigyoshobetsuHinbanZokuseiEntity selectWithLockForUpdate(EigyoshobetsuHinbanZokuseiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(EigyoshobetsuHinbanZokuseiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(EigyoshobetsuHinbanZokuseiEntity entity);
}
