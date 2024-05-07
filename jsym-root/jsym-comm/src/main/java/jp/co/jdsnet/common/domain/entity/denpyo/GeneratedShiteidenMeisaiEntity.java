package jp.co.jdsnet.common.domain.entity.denpyo;

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
 * 指定伝明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShiteidenMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 指定伝作成日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int stdssedte = 0;

  /** 場所コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String bshcod = "";

  /** 指定伝リラティブＮＯ */
  @Keyfield(index = 3)
  @Builder.Default
  private int stdrelno = 0;

  /** ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int seq = 0;

  /** 指定伝明細代替キー */
  @Builder.Default
  private String stdmsidtikey = "";

  /** 得意先発注メモ */
  @Builder.Default
  private String thcmemo = "";

  /** Ａ欄 */
  @Builder.Default
  private String arn = "";

  /** 品名 */
  @Builder.Default
  private String hnm = "";

  /** 出荷数量 */
  @Builder.Default
  private int syasur = 0;

  /** 原価単価 */
  @Builder.Default
  private double gkatan = 0D;

  /** 原価金額 */
  @Builder.Default
  private int gkakin = 0;

  /** 売価単価 */
  @Builder.Default
  private int bkatan = 0;

  /** 売価金額 */
  @Builder.Default
  private int bkakin = 0;

  /** ＥＭサイン */
  @Builder.Default
  private String emsgn = "";

  /** ＥＭ前出荷数量 */
  @Builder.Default
  private int emmaesyasur = 0;

  /** ＥＭ前原価単価 */
  @Builder.Default
  private double emmaegkatan = 0D;

  /** ＥＭ前原価金額 */
  @Builder.Default
  private int emmaegkakin = 0;

  /** ＥＭ前売価単価 */
  @Builder.Default
  private int emmaebkatan = 0;

  /** ＥＭ前売価金額 */
  @Builder.Default
  private int emmaebkakin = 0;

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
