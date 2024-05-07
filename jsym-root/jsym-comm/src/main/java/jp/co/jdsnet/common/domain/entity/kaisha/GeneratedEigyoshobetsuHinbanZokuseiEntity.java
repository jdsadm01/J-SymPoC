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
 * 営業所別品番属性Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedEigyoshobetsuHinbanZokuseiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 営業所コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String eigcod = "";

  /** 記号番号 */
  @Keyfield(index = 3)
  @Builder.Default
  private String kigbng = "";

  /** 出荷制限数量 */
  @Builder.Default
  private int syasgesur = 0;

  /** 返品対策品受入期間ＦＲＯＭ */
  @Builder.Default
  private int hpntaihinukekknfrm = 0;

  /** 返品対策品受入期間ＴＯ */
  @Builder.Default
  private int hpntaihinukekknto = 0;

  /** 返品不可品区分 */
  @Builder.Default
  private String hpnfkahinkbn = "";

  /** 返品対策品区分 */
  @Builder.Default
  private String hpntaihinkbn = "";

  /** 返品不可品表示区分 */
  @Builder.Default
  private String hpnfkahinhjikbn = "";

  /** 返品対策品表示区分 */
  @Builder.Default
  private String hpntaihinhjikbn = "";

  /** 営業所ヒット指定フラグ */
  @Builder.Default
  private String eighitsteflg = "0";

  /** 注残指定品区分 */
  @Builder.Default
  private String chzsthkbn = "";

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
