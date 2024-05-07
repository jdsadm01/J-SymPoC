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
 * 発注Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHatchuEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String kaiskbcod = "";

  /** 発注先コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String hacsakcod = "";

  /** 発注伝票番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String hacdenbng = "";

  /** 行番号 */
  @Keyfield(index = 5)
  @Builder.Default
  private String gyb = "";

  /** 発注種別区分 */
  @Keyfield(index = 6)
  @Builder.Default
  private String hacsybkbn = "";

  /** 記号番号 */
  @Keyfield(index = 7)
  @Builder.Default
  private String kigbng = "";

  /** セット記号 */
  @Builder.Default
  private String setkig = "";

  /** 部品区分 */
  @Builder.Default
  private String bhnkbn = "";

  /** 部品枝番 */
  @Builder.Default
  private String bhneda = "";

  /** 発注日付 */
  @Builder.Default
  private int hacdte = 0;

  /** 自動／マニュアル区分 */
  @Builder.Default
  private String autmnlkbn = "";

  /** 生産仕入区分 */
  @Builder.Default
  private String prdsirkbn = "";

  /** サンプルサイン */
  @Builder.Default
  private String smpsgn = "";

  /** 発注新譜旧譜区分 */
  @Builder.Default
  private String hacsinkyukbn = "";

  /** 市販特販品区分 */
  @Builder.Default
  private String shnthnhinkbn = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 注文書ＮＯ */
  @Builder.Default
  private String cmsno = "";

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

  /** ＲＭコード */
  @Builder.Default
  private String rmcod = "";

  /** メーカー分類コード */
  @Builder.Default
  private String mkrbuncod = "";

  /** セット数 */
  @Builder.Default
  private int setsuu = 0;

  /** 発注数量 */
  @Builder.Default
  private int hacsur = 0;

  /** 入荷数量 */
  @Builder.Default
  private int nyasur = 0;

  /** 引当数量 */
  @Builder.Default
  private int hatsuu = 0;

  /** 納期 */
  @Builder.Default
  private int nki = 0;

  /** 納期訂正フラグ */
  @Builder.Default
  private String nkiteiflg = "0";

  /** 入荷先コード */
  @Builder.Default
  private String nyasakcod = "";

  /** 入荷先訂正フラグ */
  @Builder.Default
  private String nyasakteiflg = "0";

  /** 入荷日付 */
  @Builder.Default
  private int nyadte = 0;

  /** 完納サイン */
  @Builder.Default
  private String knusgn = "";

  /** 管理番号 */
  @Builder.Default
  private String knrbng = "";

  /** 削除サイン */
  @Builder.Default
  private String delsgn = "";

  /** 伝票日付 */
  @Builder.Default
  private int dendte = 0;

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
