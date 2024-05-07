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
 * 棚卸（倉庫任意）Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTanaoroshiSokoniniEntity implements EntityInterface {

  // 永続属性 ↓
  /** 棚卸日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int tnodte = 0;

  /** 会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String kaiskbcod = "";

  /** 倉庫コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String skocod = "";

  /** 記号番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String kigbng = "";

  /** Ａ／Ｂ在庫区分 */
  @Keyfield(index = 5)
  @Builder.Default
  private String abzaikbn = "";

  /** リマークコード */
  @Keyfield(index = 6)
  @Builder.Default
  private String rmcod = "";

  /** 棚卸票ＮＯ */
  @Keyfield(index = 7)
  @Builder.Default
  private String tnhno = "";

  /** 行番号 */
  @Keyfield(index = 8)
  @Builder.Default
  private String gyb = "";

  /** 棚卸訂正フラグ */
  @Keyfield(index = 9)
  @Builder.Default
  private String tnoteiflg = "0";

  /** 棚卸新譜旧譜区分 */
  @Builder.Default
  private String tnosinkyukbn = "";

  /** 棚区分 */
  @Builder.Default
  private String tnkbn = "";

  /** 棚卸形態グループコード */
  @Builder.Default
  private String tnoketgrpcod = "";

  /** 棚番 */
  @Builder.Default
  private String tnb = "";

  /** 帳残数量 */
  @Builder.Default
  private int cyzsur = 0;

  /** 実残数量 */
  @Builder.Default
  private int jznsur = 0;

  /** ＥＤＩ入力サイン */
  @Builder.Default
  private String ediinpsgn = "";

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
