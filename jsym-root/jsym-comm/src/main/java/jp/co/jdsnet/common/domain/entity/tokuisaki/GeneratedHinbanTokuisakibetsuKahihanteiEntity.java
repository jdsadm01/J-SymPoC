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
 * 品番得意先別可否判定Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHinbanTokuisakibetsuKahihanteiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private String kigbng = "";

  /** 得意先コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String tokcod = "";

  /** 得意先集約区分 */
  @Keyfield(index = 4)
  @Builder.Default
  private String toksyykbn = "";

  /** 可否判定区分 */
  @Keyfield(index = 5)
  @Builder.Default
  private String khihtikbn = "";

  /** 期間ＦＲＯＭ */
  @Builder.Default
  private int kknfrm = 0;

  /** 期間ＴＯ */
  @Builder.Default
  private int kknto = 0;

  /** ＣＰＵフルＩＤ */
  @Builder.Default
  private String cpufulid = "";

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
