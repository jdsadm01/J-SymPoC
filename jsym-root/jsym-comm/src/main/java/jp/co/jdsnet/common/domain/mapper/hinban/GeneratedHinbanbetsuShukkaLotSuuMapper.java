package jp.co.jdsnet.common.domain.mapper.hinban;

import jp.co.jdsnet.common.domain.entity.hinban.HinbanbetsuShukkaLotSuuEntity;

/**
 * 品番別出荷ロット数Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedHinbanbetsuShukkaLotSuuMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(HinbanbetsuShukkaLotSuuEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HinbanbetsuShukkaLotSuuEntity select(HinbanbetsuShukkaLotSuuEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  HinbanbetsuShukkaLotSuuEntity selectWithLockForUpdate(HinbanbetsuShukkaLotSuuEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(HinbanbetsuShukkaLotSuuEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(HinbanbetsuShukkaLotSuuEntity entity);
}
