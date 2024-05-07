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
 * 帳票予約作成条件Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedListReservedConditionsEntity implements EntityInterface {

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

  /** SEQNO枝番 */
  @Keyfield(index = 5)
  @Builder.Default
  private int seqnoeda = 0;

  /** 作成条件名 */
  @Builder.Default
  private String ssejknnm = "";

  /** 作成条件NO */
  @Builder.Default
  private int ssejknno = 0;

  /** 作成条件 */
  @Builder.Default
  private String ssejkn = "";

  /** 展開フラグ */
  @Builder.Default
  private String tekflg = "0";

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
