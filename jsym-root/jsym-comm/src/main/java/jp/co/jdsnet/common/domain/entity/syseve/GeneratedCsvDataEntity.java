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
 * ＣＳＶデータEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedCsvDataEntity implements EntityInterface {

  // 永続属性 ↓
  /** 作成日付（８桁） */
  @Keyfield(index = 1)
  @Builder.Default
  private int ssedte8kt = 0;

  /** 作成時刻（８桁） */
  @Keyfield(index = 2)
  @Builder.Default
  private int ssejkk8kt = 0;

  /** 場所コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String bshcod = "";

  /** リストＩＤ */
  @Keyfield(index = 4)
  @Builder.Default
  private String lstid = "";

  /** 出力ＳＥＱ */
  @Keyfield(index = 5)
  @Builder.Default
  private int outseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 6)
  @Builder.Default
  private int seq = 0;

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** 処理完了フラグ */
  @Builder.Default
  private String prckruflg = "0";

  /** ＣＳＶデータ本体 */
  @Builder.Default
  private String csvdtabdy = "";

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
