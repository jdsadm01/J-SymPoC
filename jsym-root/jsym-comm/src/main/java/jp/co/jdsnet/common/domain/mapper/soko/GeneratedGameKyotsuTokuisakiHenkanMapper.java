package jp.co.jdsnet.common.domain.mapper.soko;

import jp.co.jdsnet.common.domain.entity.soko.GameKyotsuTokuisakiHenkanEntity;

/**
 * ゲーム共通得意先変換Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedGameKyotsuTokuisakiHenkanMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(GameKyotsuTokuisakiHenkanEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  GameKyotsuTokuisakiHenkanEntity select(GameKyotsuTokuisakiHenkanEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  GameKyotsuTokuisakiHenkanEntity selectWithLockForUpdate(GameKyotsuTokuisakiHenkanEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(GameKyotsuTokuisakiHenkanEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(GameKyotsuTokuisakiHenkanEntity entity);
}
