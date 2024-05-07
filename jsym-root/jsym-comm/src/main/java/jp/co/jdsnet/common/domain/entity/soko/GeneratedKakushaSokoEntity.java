package jp.co.jdsnet.common.domain.entity.soko;

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
 * 各社倉庫Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedKakushaSokoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 倉庫コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String skocod = "";

  /** 振替締日ＦＲＯＭ */
  @Builder.Default
  private int fkesmedtefrm = 0;

  /** 振替締日ＴＯ */
  @Builder.Default
  private int fkesmedteto = 0;

  /** Ｃ直品区分 */
  @Builder.Default
  private String cchhinkbn = "";

  /** 常備品区分 */
  @Builder.Default
  private String jybhinkbn = "";

  /** 出荷コード */
  @Builder.Default
  private String syacod = "";

  /** Ａ在庫有フラグ */
  @Builder.Default
  private String azaiariflg = "0";

  /** Ｂ在庫有フラグ */
  @Builder.Default
  private String bzaiariflg = "0";

  /** 生産入庫可否区分 */
  @Builder.Default
  private String prdnyokhikbn = "";

  /** 仕入入庫可否区分 */
  @Builder.Default
  private String sirnyokhikbn = "";

  /** 再加工不可フラグ */
  @Builder.Default
  private String rprfkaflg = "0";

  /** 棚上棚下不可フラグ */
  @Builder.Default
  private String tnatnsfkaflg = "0";

  /** 部門振替不可フラグ */
  @Builder.Default
  private String bmnfkefkaflg = "0";

  /** 償却倉庫可否区分 */
  @Builder.Default
  private String skyskokhikbn = "";

  /** 留置不可フラグ */
  @Builder.Default
  private String tmefkaflg = "0";

  /** 発注予定可能フラグ */
  @Builder.Default
  private String hacytekanflg = "0";

  /** 中央倉庫フラグ */
  @Builder.Default
  private String choskoflg = "0";

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
