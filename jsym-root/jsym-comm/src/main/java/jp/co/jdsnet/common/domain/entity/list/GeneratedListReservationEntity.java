package jp.co.jdsnet.common.domain.entity.list;

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
 * 帳票予約作成登録Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedListReservationEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 帳票ID */
  @Keyfield(index = 2)
  @Builder.Default
  private String chyid = "";

  /** 入力日付 */
  @Keyfield(index = 3)
  @Builder.Default
  private int inpdte = 0;

  /** SEQNO */
  @Keyfield(index = 4)
  @Builder.Default
  private int seqno = 0;

  /** 帳票区分 */
  @Builder.Default
  private String chykbn = "";

  /** CPUFULID */
  @Builder.Default
  private String cpufulid = "";

  /** エントリーユーザーID */
  @Builder.Default
  private String enyusrid = "";

  /** ユーザー分類 */
  @Builder.Default
  private String usrbun = "";

  /** 予約処理区分 */
  @Builder.Default
  private String yykprckbn = "";

  /** 作成指定日(8桁) */
  @Builder.Default
  private int ssestedte8kt = 0;

  /** バッチ起動区分 */
  @Builder.Default
  private String batkidkbn = "";

  /** 作成指定時刻 */
  @Builder.Default
  private int ssestejkk = 0;

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** ユーザー情報 */
  @Builder.Default
  private String usrinf = "";

  /** コメント */
  @Builder.Default
  private String cmt = "";

  /** バッチワークデータ使用区分 */
  @Builder.Default
  private String batwkdtausekbn = "";

  /** 予約条件 */
  @Builder.Default
  private String yykjkn = "";

  /** ジョブID */
  @Builder.Default
  private String jobid = "";

  /** 処理済フラグ */
  @Builder.Default
  private String prckruflg = "0";

  /** 更新ユーザーID */
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
