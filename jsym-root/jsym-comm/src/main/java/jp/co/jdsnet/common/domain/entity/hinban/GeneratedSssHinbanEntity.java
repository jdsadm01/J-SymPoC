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
 * SSS品番マスターEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSssHinbanEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号－番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private String kigbng = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** メーカー分類 */
  @Builder.Default
  private String mkrbun = "";

  /** 記号部分の桁数 */
  @Builder.Default
  private int kigkta = 0;

  /** 記号変換有無 */
  @Builder.Default
  private String kighknumu = "";

  /** 省略記号 */
  @Builder.Default
  private String srykig = "";

  /** 表示品番 */
  @Builder.Default
  private String hjihnb = "";

  /** アーティストコード */
  @Builder.Default
  private String artcod = "";

  /** アーティスト（カナ） */
  @Builder.Default
  private String artkn = "";

  /** アーティスト（漢字） */
  @Builder.Default
  private String artkj = "";

  /** タイトル（カナ） */
  @Builder.Default
  private String titkn = "";

  /** タイトル（漢字） */
  @Builder.Default
  private String titkj = "";

  /** カテゴリーコード */
  @Builder.Default
  private String ctgcod = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** 新譜番号 */
  @Builder.Default
  private String sinbng = "";

  /** 行番 */
  @Builder.Default
  private int gyb = 0;

  /** 受注締日 */
  @Builder.Default
  private int jucsmedte = 0;

  /** 受注締日2 */
  @Builder.Default
  private int jucsmedte2 = 0;

  /** 得意先受注締日 */
  @Builder.Default
  private int tokjucsmedte = 0;

  /** 確注日 */
  @Builder.Default
  private int kcydte = 0;

  /** ＪＡＮコード */
  @Builder.Default
  private String jancod = "";

  /** 貸レ店出荷可否区分 */
  @Builder.Default
  private String kresyakhi = "";

  /** レンタル店出荷可否区分 */
  @Builder.Default
  private String rntsyakhikbn = "";

  /** 貸レ店邦洋区分 */
  @Builder.Default
  private String krehyokbn = "";

  /** 制作部コード */
  @Builder.Default
  private String ssbcod = "";

  /** キット区分 */
  @Builder.Default
  private String kitkbn = "";

  /** SSSキット */
  @Builder.Default
  private String ssskitkbn = "";

  /** 再発売区分 */
  @Builder.Default
  private String shbkbn = "";

  /** 登録区分 */
  @Builder.Default
  private String trkkbn = "";

  /** レーベルコード */
  @Builder.Default
  private String lblcod = "";

  /** レーベルメーカーコード */
  @Builder.Default
  private String lblmkrcod = "";

  /** 当月ランク */
  @Builder.Default
  private String tomrak = "";

  /** 市販／特販区分 */
  @Builder.Default
  private String shnthnkbn = "";

  /** ソートキー */
  @Builder.Default
  private String srtkey = "";

  /** 仕入掛率（一般） */
  @Builder.Default
  private double sirkrtipn = 0D;

  /** 仕入単価（一般） */
  @Builder.Default
  private double sirtanipn = 0D;

  /** 仕切単価決定パターン */
  @Builder.Default
  private String skrtanptn = "";

  /** 掛率／単価位置コード */
  @Builder.Default
  private int krttanichcod = 0;

  /** 仕切掛率（一般） */
  @Builder.Default
  private double skrkrtipn = 0D;

  /** 仕切掛率（貸レ店） */
  @Builder.Default
  private double skrkrtkre = 0D;

  /** 仕切単価（一般） */
  @Builder.Default
  private double skrtanipn = 0D;

  /** 仕切単価（貸レ店） */
  @Builder.Default
  private double skrtankre = 0D;

  /** 定価 */
  @Builder.Default
  private double tka = 0D;

  /** 税込定価 */
  @Builder.Default
  private double zeikmitka = 0D;

  /** プレスメーカーコード */
  @Builder.Default
  private String prsmkrcod = "";

  /** 取扱商品位置 */
  @Builder.Default
  private int takshoich = 0;

  /** テリトリー位置 */
  @Builder.Default
  private int terich = 0;

  /** 上限サイン */
  @Builder.Default
  private String jgnsgn = "";

  /** 発注ロット */
  @Builder.Default
  private int haclot = 0;

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
