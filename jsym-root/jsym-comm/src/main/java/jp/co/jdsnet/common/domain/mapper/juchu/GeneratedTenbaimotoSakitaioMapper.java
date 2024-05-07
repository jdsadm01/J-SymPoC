package jp.co.jdsnet.common.domain.mapper.juchu;

import jp.co.jdsnet.common.domain.entity.juchu.TenbaimotoSakitaioEntity;

/**
 * 転売元／先対応Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedTenbaimotoSakitaioMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(TenbaimotoSakitaioEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  TenbaimotoSakitaioEntity select(TenbaimotoSakitaioEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  TenbaimotoSakitaioEntity selectWithLockForUpdate(TenbaimotoSakitaioEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(TenbaimotoSakitaioEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(TenbaimotoSakitaioEntity entity);
}
