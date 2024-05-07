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
 * 引当倉庫Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHikiateSokoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 引当倉庫地区コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String hatskotikcod = "";

  /** 引当倉庫新譜旧譜区分 */
  @Keyfield(index = 3)
  @Builder.Default
  private String hatskosinkyukbn = "";

  /** 連動引当フラグ */
  @Builder.Default
  private String rdohatflg = "0";

  /** Ｃ直引当サイン */
  @Builder.Default
  private String cchhatsgn = "";

  /** 引当倉庫数 */
  @Builder.Default
  private int hatskosuu = 0;

  /** 引当倉庫コード１ */
  @Builder.Default
  private String hatskocod1 = "";

  /** 引当倉庫コード２ */
  @Builder.Default
  private String hatskocod2 = "";

  /** 引当倉庫コード３ */
  @Builder.Default
  private String hatskocod3 = "";

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
