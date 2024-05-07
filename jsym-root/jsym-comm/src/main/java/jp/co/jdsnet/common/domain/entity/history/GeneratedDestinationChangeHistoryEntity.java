package jp.co.jdsnet.common.domain.entity.history;

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
 * 配送先利用履歴Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDestinationChangeHistoryEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** シーケンスＮＯ */
  @Keyfield(index = 3)
  @Builder.Default
  private int seqno = 0;

  /** 配送先郵便番号（７桁） */
  @Builder.Default
  private String hsosakybnbng7kt = "";

  /** 配送先住所１ */
  @Builder.Default
  private String hsosakadr1 = "";

  /** 配送先住所２ */
  @Builder.Default
  private String hsosakadr2 = "";

  /** 配送先名 */
  @Builder.Default
  private String hsosaknm = "";

  /** 配送先電話番号（１３桁） */
  @Builder.Default
  private String hsosaktelbng13kt = "";

  /** 最新利用日付 */
  @Builder.Default
  private int sisriydte = 0;

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
