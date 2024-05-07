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
 * マスターアップロード履歴Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedMasterUploadHistoryEntity implements EntityInterface {

  // 永続属性 ↓
  /** エントリー日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int enydte = 0;

  /** 代表会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String daikaiskbcod = "";

  /** テーブルＩＤ */
  @Keyfield(index = 3)
  @Builder.Default
  private String tblid = "";

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

  /** 予約無フラグ */
  @Builder.Default
  private String yyknasflg = "0";

  /** 予約反映日 */
  @Builder.Default
  private int yykhnedte = 0;

  /** ファイル処理区分 */
  @Builder.Default
  private String fleprckbn = "";

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
