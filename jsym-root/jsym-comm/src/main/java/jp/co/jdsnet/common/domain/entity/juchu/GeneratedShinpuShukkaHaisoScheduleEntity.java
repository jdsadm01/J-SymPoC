package jp.co.jdsnet.common.domain.entity.juchu;

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
 * 新譜出荷配送スケジュールEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuShukkaHaisoScheduleEntity implements EntityInterface {

  // 永続属性 ↓
  /** 場所コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String bshcod = "";

  /** 代表会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 発売日 */
  @Keyfield(index = 3)
  @Builder.Default
  private int hbidte = 0;

  /** 配送日数 */
  @Keyfield(index = 4)
  @Builder.Default
  private int hsonsu = 0;

  /** 新譜受注区分 */
  @Keyfield(index = 5)
  @Builder.Default
  private String sinjuckbn = "";

  /** 出荷日数 */
  @Keyfield(index = 6)
  @Builder.Default
  private int syansu = 0;

  /** 配送日付 */
  @Builder.Default
  private int hsodte = 0;

  /** 倉庫出荷日付 */
  @Builder.Default
  private int skosyadte = 0;

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
