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
 * 新譜追加受注　単価別サマリーEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuTsuikaJuchuTankaBetsuSummaryEntity implements EntityInterface {

  // 永続属性 ↓
  /** 得意先コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 2)
  @Builder.Default
  private String dscod = "";

  /** 代表会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 新譜番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String sinbng = "";

  /** 新譜行番号 */
  @Keyfield(index = 5)
  @Builder.Default
  private int singyb = 0;

  /** 仕切単価 */
  @Keyfield(index = 6)
  @Builder.Default
  private double skrtan = 0D;

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** 引当場所コード */
  @Builder.Default
  private String hatbshcod = "";

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** 引当倉庫コード */
  @Builder.Default
  private String hatskocod = "";

  /** 新譜リラティブＮＯ */
  @Builder.Default
  private String sinrelno = "";

  /** 貸レ店レンタル店区分 */
  @Builder.Default
  private String krerntkbn = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 納品伝票作成区分 */
  @Builder.Default
  private String nohdenssekbn = "";

  /** 在庫更新区分 */
  @Builder.Default
  private String zaiupdkbn = "";

  /** 売上更新区分 */
  @Builder.Default
  private String uriupdkbn = "";

  /** 翌勘コード */
  @Builder.Default
  private String ykncod = "";

  /** 金額 */
  @Builder.Default
  private long kin = 0L;

  /** 得意先発注番号 */
  @Builder.Default
  private String thcbng = "";

  /** 予測数 */
  @Builder.Default
  private int ysksuu = 0;

  /** 新譜確注数量 */
  @Builder.Default
  private int sinkcysur = 0;

  /** 新譜追加数量 */
  @Builder.Default
  private int sintuisur = 0;

  /** 割表ページ */
  @Builder.Default
  private int whypge = 0;

  /** 割表前回出力数 */
  @Builder.Default
  private int whyzkaoutsuu = 0;

  /** 確注締サイン */
  @Builder.Default
  private String kcysmesgn = "";

  /** 削除フラグ */
  @Builder.Default
  private String delflg = "0";

  /** 受注エラーサイン */
  @Builder.Default
  private String jucerrsgn = "";

  /** エラーコード／通常外売上サイン */
  @Builder.Default
  private String errcodtjgurisgn = "";

  /** 新譜通常外受注サイン */
  @Builder.Default
  private String sintjgjucsgn = "";

  /** 得意先発注メモ */
  @Builder.Default
  private String thcmemo = "";

  /** 伝票日付 */
  @Builder.Default
  private int dendte = 0;

  /** 出荷日付 */
  @Builder.Default
  private int syadte = 0;

  /** 受注区分（２桁） */
  @Builder.Default
  private String juckbn2kt = "";

  /** 別伝フラグ */
  @Builder.Default
  private String betflg = "0";

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
