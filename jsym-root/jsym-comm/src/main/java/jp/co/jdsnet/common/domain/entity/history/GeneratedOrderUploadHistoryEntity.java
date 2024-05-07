package jp.co.jdsnet.common.domain.entity.history;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import jp.co.jdsnet.common.domain.entity.Keyfield;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * オーダーアップロード履歴Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedOrderUploadHistoryEntity implements EntityInterface {

  // 永続属性 ↓
  /** エントリー日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int enydte = 0;

  /** 代表会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String daikaiskbcod = "";

  /** トランコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String trncod = "";

  /** シーケンスＮＯ */
  @Keyfield(index = 4)
  @Builder.Default
  private int seqno = 0;

  /** エントリー時刻 */
  @Builder.Default
  private int enyjkk = 0;

  /** アップロードファイル名 */
  @Builder.Default
  private String uplflenm = "";

  /** 変換後ファイル名 */
  @Builder.Default
  private String hknflenm = "";

  /** 明細数 */
  @Builder.Default
  private int msisuu = 0;

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** 確注日 */
  @Builder.Default
  private int kcydte = 0;

  /** 品番数 */
  @Builder.Default
  private int hinsuu = 0;

  /** 受注数量 */
  @Builder.Default
  private int jucsur = 0;

  /** 得意先数 */
  @Builder.Default
  private int toksuu = 0;

  /** 処理区分 */
  @Builder.Default
  private String prckbn = "";

  /** ユーザーID */
  @Builder.Default
  private String usrid = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
