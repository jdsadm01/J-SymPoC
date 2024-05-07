package jp.co.jdsnet.common.domain.entity.denpyo;

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
 * 伝票明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDenpyoMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 引当場所コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String hatbshcod = "";

  /** トランコード */
  @Keyfield(index = 2)
  @Builder.Default
  private String trncod = "";

  /** 代表会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String daikaiskbcod = "";

  /** メーカー伝票番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String mkrdenbng = "";

  /** 伝票日付 */
  @Keyfield(index = 5)
  @Builder.Default
  private int dendte = 0;

  /** 得意先／発注先コード */
  @Keyfield(index = 6)
  @Builder.Default
  private String tokhacsakcod = "";

  /** ＤＳコード */
  @Keyfield(index = 7)
  @Builder.Default
  private String dscod = "";

  /** ＳＥＱ */
  @Keyfield(index = 8)
  @Builder.Default
  private int seq = 0;

  /** 共同伝票番号 */
  @Builder.Default
  private String kyodenbng = "";

  /** 共同伝票枝番 */
  @Builder.Default
  private String kyodeneda = "";

  /** 引当倉庫コード */
  @Builder.Default
  private String hatskocod = "";

  /** 作業対象棚区分 */
  @Builder.Default
  private String sgyobjtnkbn = "";

  /** 新譜ストック棚番 */
  @Builder.Default
  private String sinstotnb = "";

  /** 新譜ピック棚番 */
  @Builder.Default
  private String sinpictnb = "";

  /** 旧譜ストック棚番 */
  @Builder.Default
  private String kyustotnb = "";

  /** 旧譜ピック棚番 */
  @Builder.Default
  private String kyupictnb = "";

  /** 旧譜ストック編集棚番 */
  @Builder.Default
  private String kyustoedttnb = "";

  /** 旧譜ピック編集棚番 */
  @Builder.Default
  private String kyupicedttnb = "";

  /** 受注品番 */
  @Builder.Default
  private String juchnb = "";

  /** 引当品番 */
  @Builder.Default
  private String hathnb = "";

  /** 受注数量 */
  @Builder.Default
  private int jucsur = 0;

  /** 出荷数量 */
  @Builder.Default
  private int syasur = 0;

  /** ＥＭサイン */
  @Builder.Default
  private String emsgn = "";

  /** ＥＭ前受注数量 */
  @Builder.Default
  private int emmaejucsur = 0;

  /** ＥＭ前出荷数量 */
  @Builder.Default
  private int emmaesyasur = 0;

  /** 仕切単価 */
  @Builder.Default
  private double skrtan = 0D;

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

  /** 得意先発注メモ／発注伝票番号（行番号付） */
  @Builder.Default
  private String thcmemohdbgybtuk = "";

  /** 金額 */
  @Builder.Default
  private long kin = 0L;

  /** コメントコード群 */
  @Builder.Default
  private String cmtcodgun = "";

  /** ピック数 */
  @Builder.Default
  private int picsuu = 0;

  /** セット数 */
  @Builder.Default
  private int setsuu = 0;

  /** 伝票摘要 */
  @Builder.Default
  private String dentyo = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** メーカー分類コード */
  @Builder.Default
  private String mkrbuncod = "";

  /** カテゴリーコード */
  @Builder.Default
  private String ctgcod = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 貸レ店出荷可否区分 */
  @Builder.Default
  private String kresyakhikbn = "";

  /** 貸レ店邦洋区分 */
  @Builder.Default
  private String krehyokbn = "";

  /** メーカー伝票形態グループコード */
  @Builder.Default
  private int mkrdenketgrpcod = 0;

  /** 記号桁数 */
  @Builder.Default
  private int kigkta = 0;

  /** 当月ランクコード */
  @Builder.Default
  private String tomrakcod = "";

  /** 受注引当明細代替キー */
  @Builder.Default
  private String juchatmsidtikey = "";

  /** 倉庫指示引当明細代替キー */
  @Builder.Default
  private String skosjihatmsidtikey = "";

  /** 指定伝明細代替キー */
  @Builder.Default
  private String stdmsidtikey = "";

  /** 受注明細ＳＥＱ */
  @Builder.Default
  private int jucmsiseq = 0;

  /** 伝票明細出力順 */
  @Builder.Default
  private int denmsioutjn = 0;

  /** チェックデジット */
  @Builder.Default
  private String chd = "";

  /** 表示品番 */
  @Builder.Default
  private String hjihnb = "";

  /** 省略品番 */
  @Builder.Default
  private String sryhnb = "";

  /** 指定伝番号 */
  @Builder.Default
  private String stdbng = "";

  /** 棚上予定品サイン */
  @Builder.Default
  private String tnaytehinsgn = "";

  /** ハンディーターミナル入力フラグ */
  @Builder.Default
  private String htlinpflg = "0";

  /** 共用エリア */
  @Builder.Default
  private String kyyare = "";

  /** 汎用伝票引当エラー区分 */
  @Builder.Default
  private String hnydenhaterrkbn = "";

  /** 解禁日（４桁） */
  @Builder.Default
  private int kkidte4kt = 0;

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 制作部コード */
  @Builder.Default
  private String ssbcod = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 出荷伝票番号 */
  @Builder.Default
  private String syadenbng = "";

  /** 出荷指示数量 */
  @Builder.Default
  private int syasjisur = 0;

}
