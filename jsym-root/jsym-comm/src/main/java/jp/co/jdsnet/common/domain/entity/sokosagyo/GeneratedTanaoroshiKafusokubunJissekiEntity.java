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
 * 棚卸過不足分実績Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTanaoroshiKafusokubunJissekiEntity implements EntityInterface {

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

  /** Ａ／Ｂ在庫区分 */
  @Keyfield(index = 4)
  @Builder.Default
  private String abzaikbn = "";

  /** リマークコード */
  @Keyfield(index = 5)
  @Builder.Default
  private String rmcod = "";

  /** 前回過不足時棚卸日付ＦＲＯＭ */
  @Builder.Default
  private int zkakhjtnodtefrm = 0;

  /** 前回過不足時棚卸日付ＴＯ */
  @Builder.Default
  private int zkakhjtnodteto = 0;

  /** 棚卸日付ＦＲＯＭ */
  @Builder.Default
  private int tnodtefrm = 0;

  /** 棚卸日付ＴＯ */
  @Builder.Default
  private int tnodteto = 0;

  /** 帳残数量 */
  @Builder.Default
  private int cyzsur = 0;

  /** 実残数量 */
  @Builder.Default
  private int jznsur = 0;

  /** 帳残訂正数量（＋） */
  @Builder.Default
  private int cyzteisurpls = 0;

  /** 帳残訂正数量（－） */
  @Builder.Default
  private int cyzteisurmns = 0;

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
