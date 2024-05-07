package jp.co.jdsnet.common.domain.mapper.juchu;

import jp.co.jdsnet.common.domain.entity.juchu.ChuzanShukkaShijiMeisaiHinbanEntity;

/**
 * 注残出荷指示明細（品番）Mapperインターフェース
 *
 * @author ソース生成ツールによる自動生成
 */
public interface GeneratedChuzanShukkaShijiMeisaiHinbanMapper {

  /**
   * 新規登録を行う。
   *
   * @param entity 登録内容を詰めたEntity
   */
  void insert(ChuzanShukkaShijiMeisaiHinbanEntity entity);

  /**
   * 検索を行う。(未コミット読み取り (READ UNCOMMITTED))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ChuzanShukkaShijiMeisaiHinbanEntity select(ChuzanShukkaShijiMeisaiHinbanEntity entity);

  /**
   * 検索を行う。(幻像読み取り(更新ロック))
   * ヒットしない場合はnullを返す。
   *
   * @param entity 検索条件を詰めたEntity
   * @return 検索結果を詰めたEntity
   */
  ChuzanShukkaShijiMeisaiHinbanEntity selectWithLockForUpdate(ChuzanShukkaShijiMeisaiHinbanEntity entity);

  /**
   * 更新を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void update(ChuzanShukkaShijiMeisaiHinbanEntity entity);

  /**
   * 削除を行う。
   *
   * @param entity 検索条件を詰めたEntity
   */
  void delete(ChuzanShukkaShijiMeisaiHinbanEntity entity);
}
