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
 * コード値チェック条件Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedCodeChiCheckJokenEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** テーブルＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String tblid = "";

  /** テーブル属性物理名 */
  @Keyfield(index = 3)
  @Builder.Default
  private String tblzksbtrnm = "";

  /** コード値チェック区分 */
  @Builder.Default
  private String codchichkkbn = "";

  /** コード値桁数 */
  @Builder.Default
  private int codchikta = 0;

  /** コード値数 */
  @Builder.Default
  private int codchisuu = 0;

  /** コード値群 */
  @Builder.Default
  private String codchigun = "";

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
