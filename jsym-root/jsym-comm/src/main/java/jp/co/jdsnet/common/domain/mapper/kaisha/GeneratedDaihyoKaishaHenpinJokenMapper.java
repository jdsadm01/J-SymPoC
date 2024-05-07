package jp.co.jdsnet.common.domain.mapper.kaisha;

import jp.co.jdsnet.common.domain.entity.kaisha.DaihyoKaishaHenpinJokenEntity;

/**
 * 代表会社返品条件Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedDaihyoKaishaHenpinJokenMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(DaihyoKaishaHenpinJokenEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  DaihyoKaishaHenpinJokenEntity select(DaihyoKaishaHenpinJokenEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  DaihyoKaishaHenpinJokenEntity selectWithLockForUpdate(DaihyoKaishaHenpinJokenEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(DaihyoKaishaHenpinJokenEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(DaihyoKaishaHenpinJokenEntity entity);
}
