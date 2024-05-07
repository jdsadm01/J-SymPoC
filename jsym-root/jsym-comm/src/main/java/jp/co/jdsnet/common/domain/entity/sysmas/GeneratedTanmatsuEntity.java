package jp.co.jdsnet.common.domain.entity.sysmas;

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
 * 端末Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTanmatsuEntity implements EntityInterface {

  // 永続属性 ↓
  /** ＣＰＵＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String cpuid = "";

  /** 端末ＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String tmlid = "";

  /** 端末名 */
  @Builder.Default
  private String tmlnm = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

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
