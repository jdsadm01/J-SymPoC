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
 * 受注引当明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedJuchuHikiateMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 受注日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int jucdte = 0;

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String dscod = "";

  /** 受注見出ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int jucmdsseq = 0;

  /** 受注明細ＳＥＱ */
  @Keyfield(index = 5)
  @Builder.Default
  private int jucmsiseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 6)
  @Builder.Default
  private int seq = 0;

  /** 受注引当明細代替キー */
  @Builder.Default
  private String juchatmsidtikey = "";

  /** 受注引当見出番号 */
  @Builder.Default
  private String juchatmdsbng = "";

  /** 引当順 */
  @Builder.Default
  private int hatjn = 0;

  /** 出荷コード */
  @Builder.Default
  private String syacod = "";

  /** 引当倉庫コード */
  @Builder.Default
  private String hatskocod = "";

  /** 旧譜ストック棚番 */
  @Builder.Default
  private String kyustotnb = "";

  /** 旧譜ピック棚番 */
  @Builder.Default
  private String kyupictnb = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 受注品番 */
  @Builder.Default
  private String juchnb = "";

  /** 引当品番 */
  @Builder.Default
  private String hathnb = "";

  /** 伝票明細受注数量 */
  @Builder.Default
  private int denmsijucsur = 0;

  /** 引当数量 */
  @Builder.Default
  private int hatsur = 0;

  /** 単価／金額指定区分 */
  @Builder.Default
  private String tankinstekbn = "";

  /** 仕切単価 */
  @Builder.Default
  private double skrtan = 0D;

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

  /** 得意先発注メモ */
  @Builder.Default
  private String thcmemo = "";

  /** 金額 */
  @Builder.Default
  private long kin = 0L;

  /** メーカー指定倉庫コード */
  @Builder.Default
  private String mkrsteskocod = "";

  /** コメントコード群 */
  @Builder.Default
  private String cmtcodgun = "";

  /** 注残品納期 */
  @Builder.Default
  private int chzhinnki = 0;

  /** 受注品展開区分 */
  @Builder.Default
  private String juchintekkbn = "";

  /** 入力チェックエラー詳細区分 */
  @Builder.Default
  private String inpchkerrssikbn = "";

  /** 注残／翌営キック区分 */
  @Builder.Default
  private String chzykekickbn = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** 経費サンプル出庫引当エラー区分 */
  @Builder.Default
  private String kehsmpsyohaterrkbn = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 貸出出荷明細ＳＥＱ */
  @Builder.Default
  private int kdsmsiseq = 0;

  /** 出荷伝票番号 */
  @Builder.Default
  private String syadenbng = "";

  /** 出荷指示数量 */
  @Builder.Default
  private int syasjisur = 0;

}
