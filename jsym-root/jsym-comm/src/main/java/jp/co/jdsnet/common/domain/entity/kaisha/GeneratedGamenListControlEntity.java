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
 * 画面帳票コントロールテーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedGamenListControlEntity implements EntityInterface {

  // 永続属性 ↓
  /** 会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String kaiskbcod = "";

  /** 画面帳票ＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String pnllstid = "";

  /** 達成率計算条件 */
  @Builder.Default
  private String tsertuksnjkn = "";

  /** 売上分類項目出力条件 */
  @Builder.Default
  private String uribunkmkoutjkn = "";

  /** 営業所改ﾍﾟｰｼﾞ条件 */
  @Builder.Default
  private String eigkpgjkn = "";

  /** 営業部計出力条件 */
  @Builder.Default
  private String eibttloutjkn = "";

  /** 予算出力条件 */
  @Builder.Default
  private String ysnoutjkn = "";

  /** 営業所計出力条件 */
  @Builder.Default
  private String eigttloutjkn = "";

  /** ﾃﾘﾄﾘｰ系帳票改ﾍﾟｰｼﾞ条件 */
  @Builder.Default
  private String terchykpgjkn = "";

  /** ﾃﾘﾄﾘｰ上２桁合計出力条件 */
  @Builder.Default
  private String terk2kttloutjkn = "";

  /** 営業所課合計出力条件 */
  @Builder.Default
  private String eikttloutjkn = "";

  /** ﾃﾘﾄﾘｰ改ﾍﾟｰｼﾞ条件 */
  @Builder.Default
  private String terkpgjkn = "";

  /** 当日売上基準日 */
  @Builder.Default
  private int todurikjndte = 0;

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
