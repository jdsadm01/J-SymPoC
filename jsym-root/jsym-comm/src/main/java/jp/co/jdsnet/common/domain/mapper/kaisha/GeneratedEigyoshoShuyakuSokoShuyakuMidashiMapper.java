package jp.co.jdsnet.common.domain.mapper.kaisha;

import jp.co.jdsnet.common.domain.entity.kaisha.EigyoshoShuyakuSokoShuyakuMidashiEntity;

/**
 * 営業所集約／倉庫集約　見出Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedEigyoshoShuyakuSokoShuyakuMidashiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(EigyoshoShuyakuSokoShuyakuMidashiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  EigyoshoShuyakuSokoShuyakuMidashiEntity select(EigyoshoShuyakuSokoShuyakuMidashiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  EigyoshoShuyakuSokoShuyakuMidashiEntity selectWithLockForUpdate(EigyoshoShuyakuSokoShuyakuMidashiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(EigyoshoShuyakuSokoShuyakuMidashiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(EigyoshoShuyakuSokoShuyakuMidashiEntity entity);
}
