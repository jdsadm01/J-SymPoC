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
 * 画面用更新履歴テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedGamenUpdateHistoryEntity implements EntityInterface {

  // 永続属性 ↓
  /** エントリー日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int enydte = 0;

  /** エントリー時刻 */
  @Keyfield(index = 2)
  @Builder.Default
  private int enyjkk = 0;

  /** エントリーユーザーＩＤ */
  @Keyfield(index = 3)
  @Builder.Default
  private String enyusrid = "";

  /** エントリーＣＰＵＩＤ */
  @Keyfield(index = 4)
  @Builder.Default
  private String enycpuid = "";

  /** エントリー端末ＩＤ */
  @Keyfield(index = 5)
  @Builder.Default
  private String enytmlid = "";

  /** 代表会社識別コード */
  @Keyfield(index = 6)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 場所コード */
  @Keyfield(index = 7)
  @Builder.Default
  private String bshcod = "";

  /** テーブルＩＤ */
  @Keyfield(index = 8)
  @Builder.Default
  private String tblid = "";

  /** テーブルキー */
  @Keyfield(index = 9)
  @Builder.Default
  private String tblkey = "";

  /** セグメントＮＯ */
  @Keyfield(index = 10)
  @Builder.Default
  private int segno = 0;

  /** シーケンスＮＯ */
  @Keyfield(index = 11)
  @Builder.Default
  private int seqno = 0;

  /** エントリー更新区分 */
  @Builder.Default
  private String enyupdkbn = "";

  /** 処理済フラグ */
  @Builder.Default
  private String prcsmiflg = "0";

  /** エラー区分 */
  @Builder.Default
  private String errkbn = "";

  /** 業務ID */
  @Builder.Default
  private String gymid = "";

  /** 更新前業務使用状況 */
  @Builder.Default
  private String updgymbf = "";

  /** 更新後業務使用状況 */
  @Builder.Default
  private String updgymat = "";

  /** 画面ID */
  @Builder.Default
  private String gmnid = "";

  /** 更新前権限 */
  @Builder.Default
  private String updroleidbf = "";

  /** 更新後権限 */
  @Builder.Default
  private String updroleidat = "";

  /** 更新ユーザーＩＤ */
  @Builder.Default
  private String updusrid = "";

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
