package jp.co.jdsnet.common.domain.mapper.juchu;

import jp.co.jdsnet.common.domain.entity.juchu.ShinpuTeiseiDenpyoJidoSakuseiShijiEntity;

/**
 * 新譜訂正伝票自動作成指示Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedShinpuTeiseiDenpyoJidoSakuseiShijiMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(ShinpuTeiseiDenpyoJidoSakuseiShijiEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ShinpuTeiseiDenpyoJidoSakuseiShijiEntity select(ShinpuTeiseiDenpyoJidoSakuseiShijiEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ShinpuTeiseiDenpyoJidoSakuseiShijiEntity selectWithLockForUpdate(ShinpuTeiseiDenpyoJidoSakuseiShijiEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(ShinpuTeiseiDenpyoJidoSakuseiShijiEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(ShinpuTeiseiDenpyoJidoSakuseiShijiEntity entity);
}
