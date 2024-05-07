package jp.co.jdsnet.common.domain.mapper.schedule;

import jp.co.jdsnet.common.domain.entity.schedule.KakushaSystemSyoriScheduleShokaiJokenEntity;

/**
 * 各社ｼｽﾃﾑ処理ｽｹｼﾞｭｰﾙ照会条件Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedKakushaSystemSyoriScheduleShokaiJokenMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(KakushaSystemSyoriScheduleShokaiJokenEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  KakushaSystemSyoriScheduleShokaiJokenEntity select(KakushaSystemSyoriScheduleShokaiJokenEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  KakushaSystemSyoriScheduleShokaiJokenEntity selectWithLockForUpdate(KakushaSystemSyoriScheduleShokaiJokenEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(KakushaSystemSyoriScheduleShokaiJokenEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(KakushaSystemSyoriScheduleShokaiJokenEntity entity);
}
