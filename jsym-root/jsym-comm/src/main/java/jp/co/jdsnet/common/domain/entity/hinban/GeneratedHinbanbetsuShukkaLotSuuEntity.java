package jp.co.jdsnet.common.domain.entity.hinban;

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
 * 品番別出荷ロット数Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHinbanbetsuShukkaLotSuuEntity implements EntityInterface {

  // 永続属性 ↓
  /** リストＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String lstid = "";

  /** リスト枝番 */
  @Keyfield(index = 2)
  @Builder.Default
  private String lsteda = "";

  /** 変換代表会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String hkndaikaiskbcod = "";

  /** 記号番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String kigbng = "";

  /** 出荷ロット数 */
  @Builder.Default
  private int syalotsuu = 0;

  /** ユーザーメモ */
  @Builder.Default
  private String usrmemo = "";

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
