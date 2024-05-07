package jp.co.jdsnet.common.domain.entity.tokuisaki;

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
 * 得意先返品枠Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTokuisakiHenpinwakuEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** 返品グループコード */
  @Keyfield(index = 3)
  @Builder.Default
  private int hpngrpcod = 0;

  /** 返品枠集約コード */
  @Builder.Default
  private String hpwsyycod = "";

  /** 返送対象フラグ */
  @Builder.Default
  private String hnsobjflg = "0";

  /** 返品枠率 */
  @Builder.Default
  private double hpwrt = 0D;

  /** 返品Ａ枠額 */
  @Builder.Default
  private int hpnawkgak = 0;

  /** 返品Ｍ枠額 */
  @Builder.Default
  private int hpnmwkgak = 0;

  /** 返品枠計算期間 */
  @Builder.Default
  private int hpwksnkkn = 0;

  /** 翌月返品Ａ枠額 */
  @Builder.Default
  private int ykmhpnawkgak = 0;

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
