package jp.co.jdsnet.common.entry;

import jp.co.jdsnet.common.domain.entity.menu.EventEntity;
import jp.co.jdsnet.common.domain.entity.syseve.TargetEntity;

/**
 * エントリーサービスインターフェース
 *
 * @author r-matsumura
 *
 * @param <T> 対象テーブルのEntity
 */
public interface EntryService<T> {

  /**
   * 指示テーブルへの登録を行う
   *
   * @param eventEntity イベントマスターEntity
   * @param entity 登録値をセットしたEntity
   * @return ターゲット
   * @throws Exception 予期しないException
   */
  public TargetEntity entry(final EventEntity eventEntity, T entity) throws Exception;

  /**
   * サービスを区別する為のID
   *
   * @return クラス名
   */
  public String getServiceId();

  /**
   * 受注状況テーブルの登録
   *
   * @param entity 指示テーブルに登録したデータ
   * @param usrid ユーザーID
   * @param cpuid CPUID
   * @param tmlid 端末ID
   * @param usrbshcod ユーザー場所コード
   * @param isKyodoJuchu 共同受注かどうか
   */
  default public void insertEny01(T entity, String usrid, String cpuid, String tmlid,
      String usrbshcod, boolean isKyodoJuchu) {
    // 登録が必要なエントリーサービスでのみ実装する
  }
}
