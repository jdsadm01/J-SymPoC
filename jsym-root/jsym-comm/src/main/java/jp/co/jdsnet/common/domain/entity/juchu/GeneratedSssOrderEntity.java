package jp.co.jdsnet.common.domain.entity.juchu;

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
 * 新譜受注テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSssOrderEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private String kigbng = "";

  /** 得意先ｺｰﾄﾞ */
  @Keyfield(index = 3)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳｺｰﾄﾞ */
  @Keyfield(index = 4)
  @Builder.Default
  private String dscod = "";

  /** 受注区分 */
  @Keyfield(index = 5)
  @Builder.Default
  private String juckbn = "";

  /** 仕切単価 */
  @Builder.Default
  private double skrtan = 0D;

  /** ＲＥＬＮＯ */
  @Builder.Default
  private String relno = "";

  /** 引当倉庫ｺｰﾄﾞ */
  @Builder.Default
  private String hatskocod = "";

  /** 翌勘ｺｰﾄﾞ */
  @Builder.Default
  private String ykkcod = "";

  /** 発注番号 */
  @Keyfield(index = 7)
  @Builder.Default
  private String hacbng = "";

  /** エントリー番号 */
  @Builder.Default
  private String entbng = "";

  /** 受注数 */
  @Builder.Default
  private int jucsuu = 0;

  /** 前回品番 */
  @Builder.Default
  private String zenkigbng = "";

  /** 前回提案数 */
  @Builder.Default
  private int zentansuu = 0;

  /** 前回受注数 */
  @Builder.Default
  private int zenjcysuu = 0;

  /** 受注日付 */
  @Builder.Default
  private int jucdte = 0;

  /** 受注ｴﾗｰｺｰﾄﾞ */
  @Builder.Default
  private String jucerrcod = "";

  /** 受注入力済ｻｲﾝ */
  @Builder.Default
  private String jucsmisgn = "";

  /** 通常外受注ｻｲﾝ */
  @Keyfield(index = 6)
  @Builder.Default
  private String tjgjucsgn = "";

  /** リマーク */
  @Builder.Default
  private String rmcod = "";

  /** ＭＳｺｰﾄﾞ */
  @Builder.Default
  private String mscod = "";

  /** フリーメッセージ１ */
  @Builder.Default
  private String fmg1 = "";

  /** フリーメッセージ２ */
  @Builder.Default
  private String fmg2 = "";

  /** 伝票日付 */
  @Builder.Default
  private int dendte = 0;

  /** 出荷日付 */
  @Builder.Default
  private int syadte = 0;

  /** 納品日付（商品到着日） */
  @Builder.Default
  private int nhndte = 0;

  /** 別伝ﾌﾗｸﾞ */
  @Keyfield(index = 8)
  @Builder.Default
  private String betflg = "0";

  /** 確注締サイン */
  @Builder.Default
  private String kcysmesgn = "";

  /** 削除サイン */
  @Builder.Default
  private String delsgn = "";

  /** 確注日 */
  @Builder.Default
  private int kcydte = 0;

  /** ユーザーＩＤ */
  @Builder.Default
  private String usrid = "";

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
