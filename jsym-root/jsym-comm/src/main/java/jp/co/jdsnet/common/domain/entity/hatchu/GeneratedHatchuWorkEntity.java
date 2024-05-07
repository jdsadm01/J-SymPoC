package jp.co.jdsnet.common.domain.entity.hatchu;

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
 * 発注ワークEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHatchuWorkEntity implements EntityInterface {

  // 永続属性 ↓
  /** ＣＰＵフルＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String cpufulid = "";

  /** ＷＳＳＥＱ（５桁） */
  @Keyfield(index = 2)
  @Builder.Default
  private int wsseq5kt = 0;

  /** 代表会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 発注ワークリラティブＮＯ */
  @Keyfield(index = 4)
  @Builder.Default
  private int hacwkrelno = 0;

  /** 発注会社コード */
  @Builder.Default
  private String hackaicod = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 発注先コード */
  @Builder.Default
  private String hacsakcod = "";

  /** 市販特販品区分 */
  @Builder.Default
  private String shnthnhinkbn = "";

  /** 発注伝票連番区分 */
  @Builder.Default
  private String hacdenrenkbn = "";

  /** 連番区分２ */
  @Builder.Default
  private String renkbn2 = "";

  /** 形態区分 */
  @Builder.Default
  private String ketkbn = "";

  /** メーカー分類コード */
  @Builder.Default
  private String mkrbuncod = "";

  /** 発注伝票区分 */
  @Builder.Default
  private String hacdenkbn = "";

  /** サンプルサイン */
  @Builder.Default
  private String smpsgn = "";

  /** 発注トラン区分 */
  @Builder.Default
  private String hactrnkbn = "";

  /** 発注新譜旧譜区分 */
  @Builder.Default
  private String hacsinkyukbn = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** カテゴリーコード */
  @Builder.Default
  private String ctgcod = "";

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 発注種別区分 */
  @Builder.Default
  private String hacsybkbn = "";

  /** 生産仕入区分 */
  @Builder.Default
  private String prdsirkbn = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** セット記号 */
  @Builder.Default
  private String setkig = "";

  /** 部品区分 */
  @Builder.Default
  private String bhnkbn = "";

  /** 部品枝番 */
  @Builder.Default
  private String bhneda = "";

  /** 発注数量 */
  @Builder.Default
  private int hacsur = 0;

  /** 入荷先コード */
  @Builder.Default
  private String nyasakcod = "";

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** 納期 */
  @Builder.Default
  private int nki = 0;

  /** 副資材管理コード */
  @Builder.Default
  private String fuksziknrcod = "";

  /** 自動／マニュアル区分 */
  @Builder.Default
  private String autmnlkbn = "";

  /** 仕様パターン */
  @Builder.Default
  private String siyptn = "";

  /** 理由コード */
  @Builder.Default
  private String ryucod = "";

  /** 発注担当コード */
  @Builder.Default
  private String hactntcod = "";

  /** 直納数 */
  @Builder.Default
  private int tynsuu = 0;

  /** セット数 */
  @Builder.Default
  private int setsuu = 0;

  /** ジャケット納期 */
  @Builder.Default
  private int jaknki = 0;

  /** ジャケット発注先コード */
  @Builder.Default
  private String jakhacsakcod = "";

  /** 発注元伝番号 */
  @Builder.Default
  private String hacmtdbng = "";

  /** 発注元伝行番号 */
  @Builder.Default
  private String hacmtdgyb = "";

  /** 発注元伝日付 */
  @Builder.Default
  private int hacmtddte = 0;

  /** ＲＭコード */
  @Builder.Default
  private String rmcod = "";

  /** バッチフラグ */
  @Builder.Default
  private String batflg = "0";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

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
