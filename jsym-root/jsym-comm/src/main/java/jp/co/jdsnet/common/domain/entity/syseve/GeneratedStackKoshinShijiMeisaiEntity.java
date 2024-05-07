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
 * スタック更新指示明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedStackKoshinShijiMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 入力日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int inpdte = 0;

  /** 会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String kaiskbcod = "";

  /** スタック更新指示見出ＳＥＱ */
  @Keyfield(index = 3)
  @Builder.Default
  private int staupdsjimdsseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int seq = 0;

  /** スタック更新区分 */
  @Builder.Default
  private String staupdkbn = "";

  /** トランフルコード */
  @Builder.Default
  private String trnfulcod = "";

  /** スタック解除日付（旧） */
  @Builder.Default
  private int stakjydteold = 0;

  /** スタック解除日付（新） */
  @Builder.Default
  private int stakjydtenew = 0;

  /** スタック入力日付 */
  @Builder.Default
  private int stainpdte = 0;

  /** ＣＰＵＩＤ */
  @Builder.Default
  private String cpuid = "";

  /** 端末ＩＤ */
  @Builder.Default
  private String tmlid = "";

  /** スタックＮＯ */
  @Builder.Default
  private String stano = "";

  /** スタックコントロールＳＥＱ */
  @Builder.Default
  private int stacnlseq = 0;

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
