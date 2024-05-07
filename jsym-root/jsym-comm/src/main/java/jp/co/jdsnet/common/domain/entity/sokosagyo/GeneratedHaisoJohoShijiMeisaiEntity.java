package jp.co.jdsnet.common.domain.entity.sokosagyo;

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
 * 配送情報指示明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHaisoJohoShijiMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 受付ＮＯ */
  @Keyfield(index = 1)
  @Builder.Default
  private int utkno = 0;

  /** 受注引当見出番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private String juchatmdsbng = "";

  /** ＳＥＱ */
  @Keyfield(index = 3)
  @Builder.Default
  private int seq = 0;

  /** 引当場所コード */
  @Builder.Default
  private String hatbshcod = "";

  /** トランコード */
  @Builder.Default
  private String trncod = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** メーカー伝票番号 */
  @Builder.Default
  private String mkrdenbng = "";

  /** 伝票日付 */
  @Builder.Default
  private int dendte = 0;

  /** 得意先／発注先コード */
  @Builder.Default
  private String tokhacsakcod = "";

  /** ＤＳコード */
  @Builder.Default
  private String dscod = "";

  /** 共同伝票番号 */
  @Builder.Default
  private String kyodenbng = "";

  /** 受注明細数 */
  @Builder.Default
  private int jucmsisuu = 0;

  /** 出荷明細数 */
  @Builder.Default
  private int syamsisuu = 0;

  /** 受注数量（９桁） */
  @Builder.Default
  private int jucsur9kt = 0;

  /** 出荷数量（９桁） */
  @Builder.Default
  private int syasur9kt = 0;

  /** 伝票ＧＰＲＯ送信済フラグ */
  @Builder.Default
  private String dengprossnzflg = "0";

  /** 伝票ＧＰＲＯ送信日付 */
  @Builder.Default
  private int dengprossndte = 0;

  /** 伝票ＧＰＲＯ送信時刻 */
  @Builder.Default
  private int dengprossnjkk = 0;

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
