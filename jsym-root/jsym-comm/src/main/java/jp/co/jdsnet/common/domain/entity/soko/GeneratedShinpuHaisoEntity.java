package jp.co.jdsnet.common.domain.entity.soko;

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
 * 新譜配送Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuHaisoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 場所コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String bshcod = "";

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String dscod = "";

  /** 代表会社識別コード */
  @Keyfield(index = 4)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 配送ルートコード */
  @Builder.Default
  private String hsorotcod = "";

  /** 配送ルート枝番 */
  @Builder.Default
  private String hsoroteda = "";

  /** 配送ソートコード */
  @Builder.Default
  private String hsosrtcod = "";

  /** 配送ブロックコード */
  @Builder.Default
  private String hsoblkcod = "";

  /** 配送日報作成コード */
  @Builder.Default
  private String hsonpossecod = "";

  /** 商品送り状作成コード */
  @Builder.Default
  private String shookrssecod = "";

  /** 商品仕分コード */
  @Builder.Default
  private String shoswkcod = "";

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
