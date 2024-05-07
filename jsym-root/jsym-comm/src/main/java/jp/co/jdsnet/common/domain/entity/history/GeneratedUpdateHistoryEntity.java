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
 * 更新履歴テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedUpdateHistoryEntity implements EntityInterface {

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

  /** 処理グループコード */
  @Builder.Default
  private String prcgrpcod = "";

  /** エントリー更新区分 */
  @Builder.Default
  private String enyupdkbn = "";

  /** 処理済フラグ */
  @Builder.Default
  private String prcsmiflg = "0";

  /** エラー区分 */
  @Builder.Default
  private String errkbn = "";

  /** 更新前テキスト */
  @Builder.Default
  private String updtxtbf = "";

  /** 更新後テキスト */
  @Builder.Default
  private String updtxtat = "";

  /** 更新カラムフラグ */
  @Builder.Default
  private String updcolflg = "0";

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

  /** ﾏﾙﾁﾃﾞﾊﾞｲｽ更新済ﾌﾗｸﾞ */
  @Builder.Default
  private String mdvupdzflg = "0";

  /** MACS更新済フラグ */
  @Builder.Default
  private String macsupdzflg = "0";

}
