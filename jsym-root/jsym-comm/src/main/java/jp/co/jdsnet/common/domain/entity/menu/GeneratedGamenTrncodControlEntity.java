package jp.co.jdsnet.common.domain.entity.menu;

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
 * 画面別トラン制御テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedGamenTrncodControlEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** メニューパターンコード */
  @Keyfield(index = 2)
  @Builder.Default
  private String mnuptncod = "";

  /** 画面ＩＤ */
  @Keyfield(index = 3)
  @Builder.Default
  private String gmnid = "";

  /** トランコード */
  @Keyfield(index = 4)
  @Builder.Default
  private String trncod = "";

  /** ＳＥＱＮＯ */
  @Keyfield(index = 5)
  @Builder.Default
  private int seqno = 0;

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
