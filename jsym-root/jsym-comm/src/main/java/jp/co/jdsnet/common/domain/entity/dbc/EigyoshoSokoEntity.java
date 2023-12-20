package jp.co.jdsnet.common.domain.entity.dbc;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import jp.co.jdsnet.common.domain.entity.Keyfield;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EigyoshoSokoEntity implements EntityInterface {
  /** 代表会社識別コード */
  @Keyfield(index = 0)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 画面帳票ID */
  @Keyfield(index = 1)
  @Builder.Default
  private String pnllstid = "";

  /** 照会区分 */
  @Keyfield(index = 2)
  @Builder.Default
  private String sykkbn = "";

  /** 会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String kaiskbcod = "";

  /** 営業所グループコード */
  @Keyfield(index = 4)
  @Builder.Default
  private String eiggrpcod = "";

  /** 倉庫グループコード */
  @Keyfield(index = 5)
  @Builder.Default
  private String skogrpcod = "";

  /** 表示名１ */
  @Builder.Default
  private String hjinm1 = "";

  /** 表示名２ */
  @Builder.Default
  private String hjinm2 = "";

  /** 表示順 */
  @Builder.Default
  private int hjijun = 0;

  /** 画面帳票区分 */
  @Builder.Default
  private String pnllstkbn = "";

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;
}
