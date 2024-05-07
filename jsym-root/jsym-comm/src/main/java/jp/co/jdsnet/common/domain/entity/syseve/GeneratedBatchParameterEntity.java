package jp.co.jdsnet.common.domain.entity.syseve;

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
 * バッチパラメーターEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedBatchParameterEntity implements EntityInterface {

  // 永続属性 ↓
  /** バッチＳＥＱ */
  @Keyfield(index = 1)
  @Builder.Default
  private int batseq = 0;

  /** ジョブＩＤ */
  @Builder.Default
  private String jobid = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** ユーザー情報 */
  @Builder.Default
  private String usrinf = "";

  /** 入力日付（８桁） */
  @Builder.Default
  private int inpdte8kt = 0;

  /** 入力時刻 */
  @Builder.Default
  private int inpjkk = 0;

  /** バッチ起動区分 */
  @Builder.Default
  private String batkidkbn = "";

  /** バッチステータス区分 */
  @Builder.Default
  private String batstskbn = "";

  /** バッチワークデータ使用区分 */
  @Builder.Default
  private String batwkdtausekbn = "";

  /** バッチパラメーター本体 */
  @Builder.Default
  private String batprmbdy = "";

  /** 処理日付指定有フラグ */
  @Builder.Default
  private String prcdtesteariflg = "0";

  /** ユーザー指定処理日付（８桁） */
  @Builder.Default
  private int usrsteprcdte8kt = 0;

  /** 処理日付（８桁） */
  @Builder.Default
  private int prcdte8kt = 0;

  /** 処理開始時刻 */
  @Builder.Default
  private int prcsttjkk = 0;

  /** 処理終了時刻 */
  @Builder.Default
  private int prcendjkk = 0;

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
