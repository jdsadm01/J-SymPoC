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
 * 棚卸指示Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTanaoroshiShijiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 倉庫コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String skocod = "";

  /** 棚卸日付ＦＲＯＭ */
  @Keyfield(index = 3)
  @Builder.Default
  private int tnodtefrm = 0;

  /** 棚卸日付ＴＯ */
  @Builder.Default
  private int tnodteto = 0;

  /** 棚卸形態グループコード群 */
  @Builder.Default
  private String tnoketgrpcodgun = "";

  /** 棚卸在庫区分 */
  @Builder.Default
  private String tnozaikbn = "";

  /** 帳残更新区分 */
  @Builder.Default
  private String cyzupdkbn = "";

  /** 処理タイプ */
  @Builder.Default
  private String prctyp = "";

  /** 棚卸新譜旧譜区分群 */
  @Builder.Default
  private String tnosinkyukbngun = "";

  /** メーカー分類コード群 */
  @Builder.Default
  private String mkrbuncodgun = "";

  /** 棚卸中フラグ（２５０ストップ） */
  @Builder.Default
  private String tno250stp = "";

  /** 棚卸中フラグ（２５０以外ストップ） */
  @Builder.Default
  private String tnoexc250stp = "";

  /** 本棚仮棚区分 */
  @Builder.Default
  private String htnktnkbn = "";

  /** 帳残更新スケジュール済フラグ */
  @Builder.Default
  private String cyzupdschzflg = "0";

  /** 帳残更新済フラグ */
  @Builder.Default
  private String cyzupdzflg = "0";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 会社識別コード群 */
  @Builder.Default
  private String kaiskbcodgun = "";

  /** 対象商品処理区分 */
  @Builder.Default
  private String tshprckbn = "";

}
