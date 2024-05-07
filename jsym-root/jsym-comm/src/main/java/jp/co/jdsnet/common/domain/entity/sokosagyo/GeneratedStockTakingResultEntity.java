package jp.co.jdsnet.common.domain.entity.sokosagyo;

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
 * 棚卸結果テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedStockTakingResultEntity implements EntityInterface {

  // 永続属性 ↓
  /** 会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String kaiskbcod = "";

  /** 倉庫コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String skocod = "";

  /** 記号番号 */
  @Keyfield(index = 3)
  @Builder.Default
  private String kigbng = "";

  /** A/B在庫区分 */
  @Keyfield(index = 4)
  @Builder.Default
  private String abzaikbn = "";

  /** 良/不良区分 */
  @Keyfield(index = 5)
  @Builder.Default
  private String ryofry = "";

  /** 棚卸日付前回（ＦＲＯＭ） */
  @Builder.Default
  private int tnodtezkafrm = 0;

  /** 棚卸日付前回（ＴＯ） */
  @Builder.Default
  private int tnodtezkato = 0;

  /** 棚卸日付今回（ＦＲＯＭ） */
  @Builder.Default
  private int tnodtekkafrm = 0;

  /** 棚卸日付今回（ＴＯ） */
  @Builder.Default
  private int tnodtekkato = 0;

  /** 前回在庫数 */
  @Builder.Default
  private int zkazaisuu = 0;

  /** 今回在庫数 */
  @Builder.Default
  private int kkazaisuu = 0;

  /** 前回訂正数(+) */
  @Builder.Default
  private int zkateisuupls = 0;

  /** 前回訂正数(-) */
  @Builder.Default
  private int zkateisuumns = 0;

}
