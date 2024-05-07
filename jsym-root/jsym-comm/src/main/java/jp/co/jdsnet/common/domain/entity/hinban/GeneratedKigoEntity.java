package jp.co.jdsnet.common.domain.entity.hinban;

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
 * 記号Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedKigoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号番号（記号部分） */
  @Keyfield(index = 2)
  @Builder.Default
  private String kigbngkigbbn = "";

  /** 記号番号（番号部分）ＦＲＯＭ */
  @Keyfield(index = 3)
  @Builder.Default
  private String kigbngbngbbnfrm = "";

  /** 記号番号（番号部分）ＴＯ */
  @Builder.Default
  private String kigbngbngbbnto = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** メーカー分類コード */
  @Builder.Default
  private String mkrbuncod = "";

  /** 記号桁数 */
  @Builder.Default
  private int kigkta = 0;

  /** 価格コード桁数 */
  @Builder.Default
  private int pricodkta = 0;

  /** 記号変換有無 */
  @Builder.Default
  private String kighknumu = "";

  /** カテゴリーコード */
  @Builder.Default
  private String ctgcod = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 指定伝形態グループコード */
  @Builder.Default
  private int stdketgrpcod = 0;

  /** 指定伝別伝グループコード */
  @Builder.Default
  private int stdbdngrpcod = 0;

  /** 貸レ店出荷可否区分 */
  @Builder.Default
  private String kresyakhikbn = "";

  /** レンタル店出荷可否区分 */
  @Builder.Default
  private String rntsyakhikbn = "";

  /** 貸レ店邦洋区分 */
  @Builder.Default
  private String krehyokbn = "";

  /** 限定盤サイン */
  @Builder.Default
  private String gbnsgn = "";

  /** 制作部コード */
  @Builder.Default
  private String ssbcod = "";

  /** セット数 */
  @Builder.Default
  private int setsuu = 0;

  /** セットコード */
  @Builder.Default
  private int setcod = 0;

  /** 添付区分 */
  @Builder.Default
  private String tnpkbn = "";

  /** 添付品番 */
  @Builder.Default
  private String tnphnb = "";

  /** キット品代表品番フラグ */
  @Builder.Default
  private String kithindaihnbflg = "0";

  /** 単売不可フラグ */
  @Builder.Default
  private String tbifkaflg = "0";

  /** 整梱数 */
  @Builder.Default
  private int sknsuu = 0;

  /** 体積係数 */
  @Builder.Default
  private int tskkes = 0;

  /** 容量 */
  @Builder.Default
  private double yry = 0D;

  /** 重量 */
  @Builder.Default
  private double jry = 0D;

  /** 重量単位区分 */
  @Builder.Default
  private String jrytanikbn = "";

  /** 全国ヒット指定フラグ */
  @Builder.Default
  private String znkhitsteflg = "0";

  /** 前月ランクコード */
  @Builder.Default
  private String znmrakcod = "";

  /** 当月ランクコード */
  @Builder.Default
  private String tomrakcod = "";

  /** 翌月ランクコード */
  @Builder.Default
  private String ykmrakcod = "";

  /** ＳＡＬＥＯＦＦフラグ */
  @Builder.Default
  private String sofflg = "0";

  /** ＳＡＬＥＯＦＦ日付 */
  @Builder.Default
  private int sofdte = 0;

  /** 在庫管理不要フラグ */
  @Builder.Default
  private String zaiknrhuyflg = "0";

  /** 市販特販品区分 */
  @Builder.Default
  private String shnthnhinkbn = "";

  /** 返品対策品区分 */
  @Builder.Default
  private String hpntaihinkbn = "";

  /** 物税サイン */
  @Builder.Default
  private String bzisgn = "";

  /** 仕入掛率（一般） */
  @Builder.Default
  private double sirkrtipn = 0D;

  /** 仕入単価（一般） */
  @Builder.Default
  private double sirtanipn = 0D;

  /** 仕切単価決定区分 */
  @Builder.Default
  private String skrtanktikbn = "";

  /** 仕切掛率グループコード */
  @Builder.Default
  private int skrkrtgrpcod = 0;

  /** 仕切掛率（一般店） */
  @Builder.Default
  private double skrkrtipn = 0D;

  /** 仕切掛率（貸レ店） */
  @Builder.Default
  private double skrkrtkre = 0D;

  /** 仕切単価（一般店） */
  @Builder.Default
  private double skrtanipn = 0D;

  /** 仕切単価（貸レ店） */
  @Builder.Default
  private double skrtankre = 0D;

  /** 販社仕切単価（一般） */
  @Builder.Default
  private double hshskrtanipn = 0D;

  /** 販社への仕切掛率（一般） */
  @Builder.Default
  private double hshskrkrtipn = 0D;

  /** 税抜価格 */
  @Builder.Default
  private double znupri = 0D;

  /** ＪＡＳＲＡＣ使用者コード */
  @Builder.Default
  private String jasracusr = "";

  /** ＪＡＳＲＡＣ報告サイン */
  @Builder.Default
  private String jasrachok = "";

  /** ＩＬ区分 */
  @Builder.Default
  private String ilkbn = "";

  /** 輸出不可フラグ */
  @Builder.Default
  private String expfkaflg = "0";

  /** 自動振替対象区分 */
  @Builder.Default
  private String afkobjkbn = "";

  /** 製造期限 */
  @Builder.Default
  private int szokgn = 0;

  /** 自発対象サイン */
  @Builder.Default
  private String jhtobjsgn = "";

  /** 受注．発注品サイン */
  @Builder.Default
  private String juchachin = "";

  /** 副資材管理コード */
  @Builder.Default
  private String fuksziknrcod = "";

  /** 副資材仕様 */
  @Builder.Default
  private String fukszisiy = "";

  /** プレスメーカーコード */
  @Builder.Default
  private String prsmkrcod = "";

  /** 受託プレスメーカーコード */
  @Builder.Default
  private String jytprsmkr = "";

  /** 副資材メーカーコード */
  @Builder.Default
  private String fukszimkrcod = "";

  /** その他メーカーコード */
  @Builder.Default
  private String etcmkrcod = "";

  /** 生産仕入区分 */
  @Builder.Default
  private String prdsirkbn = "";

  /** テリトリーグループコード */
  @Builder.Default
  private int tergrpcod = 0;

  /** 取扱商品グループコード */
  @Builder.Default
  private int takshogrpcod = 0;

  /** 納品伝票別伝グループコード */
  @Builder.Default
  private int nohdenbdngrpcod = 0;

  /** 売上グループコード */
  @Builder.Default
  private int urigrpcod = 0;

  /** 返品グループコード */
  @Builder.Default
  private int hpngrpcod = 0;

  /** ジャンルコード */
  @Builder.Default
  private String gnrcod = "";

  /** ＪＡＮコード */
  @Builder.Default
  private String jancod = "";

  /** 品番情報公開区分 */
  @Builder.Default
  private String hnbinfkokkbn = "";

  /** 面替フラグ */
  @Builder.Default
  private String mngflg = "0";

  /** ソートコード */
  @Builder.Default
  private String srtcod = "";

  /** 定価計算区分 */
  @Builder.Default
  private String tkaksnkbn = "";

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
