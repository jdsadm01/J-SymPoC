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
 * 発注先Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHatchusakiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 発注先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String hacsakcod = "";

  /** 発注先編集名 */
  @Builder.Default
  private String hacsakedtnm = "";

  /** 発注先名１ */
  @Builder.Default
  private String hacsaknm1 = "";

  /** 発注先名２ */
  @Builder.Default
  private String hacsaknm2 = "";

  /** 発注先名カナ */
  @Builder.Default
  private String hacsaknmkn = "";

  /** 発注先住所１ */
  @Builder.Default
  private String hacsakadr1 = "";

  /** 発注先住所２ */
  @Builder.Default
  private String hacsakadr2 = "";

  /** 発注先郵便番号（５桁） */
  @Builder.Default
  private String hacsakybnbng5kt = "";

  /** 発注先郵便番号（７桁） */
  @Builder.Default
  private String hacsakybnbng7kt = "";

  /** 発注先電話番号 */
  @Builder.Default
  private String hacsaktelbng = "";

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
