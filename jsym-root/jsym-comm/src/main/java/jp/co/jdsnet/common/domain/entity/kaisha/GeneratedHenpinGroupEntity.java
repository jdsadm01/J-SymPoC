package jp.co.jdsnet.common.domain.entity.kaisha;

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
 * 返品グループEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHenpinGroupEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 返品グループコード */
  @Keyfield(index = 2)
  @Builder.Default
  private int hpngrpcod = 0;

  /** 返品枠集約コード */
  @Builder.Default
  private String hpwsyycod = "";

  /** 返送対象フラグ */
  @Builder.Default
  private String hnsobjflg = "0";

  /** 返品グループ名 */
  @Builder.Default
  private String hpngrpnm = "";

  /** テリトリーグループコード */
  @Builder.Default
  private int tergrpcod = 0;

  /** Ｇ／Ｎ表示区分（一般店） */
  @Builder.Default
  private String gnhjikbnipn = "";

  /** Ｇ／Ｎ表示区分（貸レ店） */
  @Builder.Default
  private String gnhjikbnkre = "";

  /** 返品Ａ枠クリア基準額 */
  @Builder.Default
  private int hpnawkclekjngak = 0;

  /** 返品枠率 */
  @Builder.Default
  private double hpwrt = 0D;

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
