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
 * ＳＳＳ新譜集計ﾃｰﾌﾞﾙEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSssTotallingEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード  */
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

  /** 店種別 */
  @Keyfield(index = 4)
  @Builder.Default
  private String toksyb = "";

  /** 目標数 */
  @Builder.Default
  private int mhysuu = 0;

  /** 目標金額 */
  @Builder.Default
  private long mhykin = 0L;

  /** 一次修正数 */
  @Builder.Default
  private int ichijisuu = 0;

  /** 一次修正金額 */
  @Builder.Default
  private long ichijikin = 0L;

  /** 二次修正数 */
  @Builder.Default
  private int nijisuu = 0;

  /** 二次修正金額 */
  @Builder.Default
  private long nijikin = 0L;

  /** 確定数 */
  @Builder.Default
  private int kakteisuu = 0;

  /** 確定金額 */
  @Builder.Default
  private long kakteikin = 0L;

  /** 追加（250S）数 */
  @Builder.Default
  private int tuikasuu = 0;

  /** 追加（250S）金額 */
  @Builder.Default
  private long tuikakin = 0L;

  /** 最終更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最終更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最終更新時間 */
  @Builder.Default
  private int updjkk = 0;

}
