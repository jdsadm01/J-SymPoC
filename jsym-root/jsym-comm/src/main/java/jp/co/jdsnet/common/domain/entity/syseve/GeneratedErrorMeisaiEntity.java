package jp.co.jdsnet.common.domain.entity.syseve;

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
 * エラー明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedErrorMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 場所コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String bshcod = "";

  /** リストＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String lstid = "";

  /** レコードＳＥＱ */
  @Keyfield(index = 3)
  @Builder.Default
  private int recseq = 0;

  /** 作成日付 */
  @Keyfield(index = 4)
  @Builder.Default
  private int ssedte = 0;

  /** 作成時刻 */
  @Keyfield(index = 5)
  @Builder.Default
  private int ssejkk = 0;

  /** 会社識別コード */
  @Keyfield(index = 6)
  @Builder.Default
  private String kaiskbcod = "";

  /** データＳＥＱ */
  @Keyfield(index = 7)
  @Builder.Default
  private int dtaseq = 0;

  /** エラーコード（明細） */
  @Builder.Default
  private String errcod = "";

  /** 営業所コード（明細） */
  @Builder.Default
  private String eigcod = "";

  /** テリトリー（明細） */
  @Builder.Default
  private String tercod = "";

  /** 倉庫コード（明細） */
  @Builder.Default
  private String skocod = "";

  /** 得意先コード（明細） */
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード（明細） */
  @Builder.Default
  private String dscod = "";

  /** 行番号 */
  @Builder.Default
  private int gyb = 0;

  /** 記号ー番号 */
  @Builder.Default
  private String kigbng = "";

  /** 受注数 */
  @Builder.Default
  private int jucsuu = 0;

  /** リマークコード（明細） */
  @Builder.Default
  private String rmcod = "";

  /** 発注メモ（明細） */
  @Builder.Default
  private String hacmemo = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** 翌勘コード（明細） */
  @Builder.Default
  private String ykkcod = "";

  /** 出荷コード */
  @Builder.Default
  private String syacod = "";

  /** 当月ランク */
  @Builder.Default
  private String tomrak = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 納期 */
  @Builder.Default
  private int nki = 0;

  /** 出荷数 */
  @Builder.Default
  private int syasuu = 0;

  /** Ｃ直マーク */
  @Builder.Default
  private String cchmrk = "";

  /** コメント */
  @Builder.Default
  private String cmt = "";

  /** 貸レ邦洋区分 */
  @Builder.Default
  private String krehyokbn = "";

  /** 面替サイン */
  @Builder.Default
  private String mngsgn = "";

  /** 積送数 */
  @Builder.Default
  private int skssuu = 0;

  /** 受注締日 */
  @Builder.Default
  private int jucsmedte = 0;

  /** 確注日 */
  @Builder.Default
  private int kcydte = 0;

  /** 貸レンタル店サイン */
  @Builder.Default
  private String krerntsgn = "";

  /** シーケンシャルＮＯ */
  @Builder.Default
  private int seqno = 0;

  /** 新譜番号 */
  @Builder.Default
  private String sinbng = "";

  /** 出荷日 */
  @Builder.Default
  private int syadte = 0;

  /** 処理区分 */
  @Builder.Default
  private String prckbn = "";

  /** 単価 */
  @Builder.Default
  private double tan = 0D;

  /** ダブリ品番 */
  @Builder.Default
  private String dubhin = "";

  /** グループＮＯ */
  @Builder.Default
  private String grpno = "";

  /** 発売会社コード */
  @Builder.Default
  private String hbikaicod = "";

  /** 廃盤期間ＴＯ */
  @Builder.Default
  private int hibkknto = 0;

  /** 販売会社コード */
  @Builder.Default
  private String hankaicod = "";

  /** 品目番号 */
  @Builder.Default
  private String hnmbng = "";

  /** 市販特販品区分 */
  @Builder.Default
  private String shnthnkbn = "";

  /** ジャンルコード */
  @Builder.Default
  private String gnrcod = "";

  /** 権利登録日時 */
  @Builder.Default
  private String kerdte = "";

  /** 権利者区分 */
  @Builder.Default
  private String kerkbn = "";

  /** 権利者区分枝番 */
  @Builder.Default
  private int kerkbneda = 0;

  /** 記号桁数 */
  @Builder.Default
  private int kigkta = 0;

  /** 曲登録日時 */
  @Builder.Default
  private String kykadddte = "";

  /** メディア順 */
  @Builder.Default
  private int mdajun = 0;

  /** パッケージ順 */
  @Builder.Default
  private int pacjun = 0;

  /** ＰＯＳ */
  @Builder.Default
  private String pos = "";

  /** ＰＯＳ補足１ */
  @Builder.Default
  private int posh1 = 0;

  /** ＰＯＳ補足２ */
  @Builder.Default
  private int posh2 = 0;

  /** サイド（Ａ／Ｂ） */
  @Builder.Default
  private String side = "";

  /** セールＯＦＦ日付 */
  @Builder.Default
  private int sofdte = 0;

  /** 商品構成区分 */
  @Builder.Default
  private String syhksekbn = "";

  /** 商品タイトル表示サイン */
  @Builder.Default
  private String syotithji = "";

  /** 製品登録日時 */
  @Builder.Default
  private String szonji = "";

  /** トラック */
  @Builder.Default
  private int track = 0;

  /** トラックメドレ */
  @Builder.Default
  private int trackm = 0;

  /** 税込定価 */
  @Builder.Default
  private double zeikmitka = 0D;

  /** 販売価格２ */
  @Builder.Default
  private double zeinkitka = 0D;

  /** セット数 */
  @Builder.Default
  private int setsuu = 0;

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
