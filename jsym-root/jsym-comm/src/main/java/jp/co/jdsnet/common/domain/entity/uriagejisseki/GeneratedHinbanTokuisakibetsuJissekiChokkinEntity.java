package jp.co.jdsnet.common.domain.entity.uriagejisseki;

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
 * 品番得意先別実績（直近）Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHinbanTokuisakibetsuJissekiChokkinEntity implements EntityInterface {

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

  /** 伝票日付 */
  @Keyfield(index = 4)
  @Builder.Default
  private int dendte = 0;

  /** 当日新譜売上数量 */
  @Builder.Default
  private int todsinurisur = 0;

  /** 当日通常売上数量 */
  @Builder.Default
  private int todtjyurisur = 0;

  /** 当日その他売上数量 */
  @Builder.Default
  private int todetcurisur = 0;

  /** 当日貸出売上数量 */
  @Builder.Default
  private int todkdaurisur = 0;

  /** 当日返品数量 */
  @Builder.Default
  private int todhpnsur = 0;

  /** 当日受注数量 */
  @Builder.Default
  private int todjucsur = 0;

  /** 当日新譜売上金額 */
  @Builder.Default
  private long todsinurikin = 0L;

  /** 当日通常売上金額 */
  @Builder.Default
  private long todtjyurikin = 0L;

  /** 当日その他売上金額 */
  @Builder.Default
  private long todetcurikin = 0L;

  /** 当日貸出売上金額 */
  @Builder.Default
  private long todkdaurikin = 0L;

  /** 当日返品金額 */
  @Builder.Default
  private long todhpnkin = 0L;

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 当日伝票明細受注数量 */
  @Builder.Default
  private int toddenmsijucsur = 0;

}
