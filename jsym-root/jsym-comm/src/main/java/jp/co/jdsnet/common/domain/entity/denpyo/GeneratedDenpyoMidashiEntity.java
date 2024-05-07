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
 * 伝票見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDenpyoMidashiEntity implements EntityInterface {

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

  /** 共同伝票番号 */
  @Builder.Default
  private String kyodenbng = "";

  /** 引当日付 */
  @Builder.Default
  private int hatdte = 0;

  /** 引当時刻 */
  @Builder.Default
  private int hatjkk = 0;

  /** 得意先発注番号／発注伝票番号（行番号付） */
  @Builder.Default
  private String thcbnghdbgybtuk = "";

  /** ＳＪコード */
  @Builder.Default
  private String sjcod = "";

  /** 翌勘コード */
  @Builder.Default
  private String ykncod = "";

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** フリーメッセージ１ */
  @Builder.Default
  private String fmg1 = "";

  /** フリーメッセージ２ */
  @Builder.Default
  private String fmg2 = "";

  /** 単価／金額表示フラグ */
  @Builder.Default
  private String tankinhjiflg = "0";

  /** 元伝日付 */
  @Builder.Default
  private int mtddte = 0;

  /** 元伝番号 */
  @Builder.Default
  private String mtdbng = "";

  /** ＣＰＵフルＩＤ */
  @Builder.Default
  private String cpufulid = "";

  /** ＷＳＳＥＱ（４桁） */
  @Builder.Default
  private int wsseq4kt = 0;

  /** 受注日付 */
  @Builder.Default
  private int jucdte = 0;

  /** 受注時刻 */
  @Builder.Default
  private int jucjkk = 0;

  /** 受注区分 */
  @Builder.Default
  private String juckbn = "";

  /** 受注場所コード */
  @Builder.Default
  private String jucbshcod = "";

  /** 個口数 */
  @Builder.Default
  private int kogsuu = 0;

  /** 梱包資材名群 */
  @Builder.Default
  private String konszinmgun = "";

  /** 梱包資材数群 */
  @Builder.Default
  private String konszisuugun = "";

  /** 貸レシール名群 */
  @Builder.Default
  private String krsnmgun = "";

  /** 貸レシール数群 */
  @Builder.Default
  private String krssuugun = "";

  /** 別伝処理区分 */
  @Builder.Default
  private String bdnprckbn = "";

  /** 指定伝区分 */
  @Builder.Default
  private String stdkbn = "";

  /** 貸レ店レンタル店区分 */
  @Builder.Default
  private String krerntkbn = "";

  /** 配送方面／ブロックコード */
  @Builder.Default
  private String hsohmnblkcod = "";

  /** ＥＭサイン */
  @Builder.Default
  private String emsgn = "";

  /** 指定伝番号ＦＲＯＭ */
  @Builder.Default
  private String stdbngfrm = "";

  /** 指定伝番号ＴＯ */
  @Builder.Default
  private String stdbngto = "";

  /** 出荷日付 */
  @Builder.Default
  private int syadte = 0;

  /** ページ番号 */
  @Builder.Default
  private int pagbng = 0;

  /** ページ番号終了サイン */
  @Builder.Default
  private String pagbngendsgn = "";

  /** 共用エリア */
  @Builder.Default
  private String kyyare = "";

  /** 与信限度オーバーフラグ */
  @Builder.Default
  private String ygdovrflg = "0";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** 処理日付 */
  @Builder.Default
  private int prcdte = 0;

  /** 伝票作成／出力区分 */
  @Builder.Default
  private String densseoutkbn = "";

  /** 元倉庫コード */
  @Builder.Default
  private String msocod = "";

  /** 先倉庫コード */
  @Builder.Default
  private String ssocod = "";

  /** 貸出区分 */
  @Builder.Default
  private String kdakbn = "";

  /** その他出荷管理区分 */
  @Builder.Default
  private String etcsyaknrkbn = "";

  /** 税区分 */
  @Builder.Default
  private String zeikbn = "";

  /** サンプルサイン */
  @Builder.Default
  private String smpsgn = "";

  /** 当月／前月迄在庫区分 */
  @Builder.Default
  private String tomzmmzaikbn = "";

  /** Ａ／Ｂ在庫区分 */
  @Builder.Default
  private String abzaikbn = "";

  /** 仕向地コード */
  @Builder.Default
  private String smtcod = "";

  /** 科目コード */
  @Builder.Default
  private String kamcod = "";

  /** 返品受付番号 */
  @Builder.Default
  private String hpnutkbng = "";

  /** 返品理由区分 */
  @Builder.Default
  private String hpnryukbn = "";

  /** 定期返品金額／発注先納品番号 */
  @Builder.Default
  private int tkihpnkinhcnbng = 0;

  /** 廃盤返品金額 */
  @Builder.Default
  private int hibhpnkin = 0;

  /** 既廃盤返品金額 */
  @Builder.Default
  private int khbhpnkin = 0;

  /** 不良品返品金額 */
  @Builder.Default
  private int fryhpnkin = 0;

  /** 返送金額 */
  @Builder.Default
  private int hnskin = 0;

  /** 得意先伝票番号１ */
  @Builder.Default
  private String tokdenbng1 = "";

  /** 得意先伝票番号２ */
  @Builder.Default
  private String tokdenbng2 = "";

  /** 返品受領／入荷日付 */
  @Builder.Default
  private int hpnjurnyadte = 0;

  /** 精算予定日 */
  @Builder.Default
  private int ssaytedte = 0;

  /** ロケーション番号 */
  @Builder.Default
  private String locbng = "";

  /** 伝票単位積送区分／仕切掛率指定フラグ */
  @Builder.Default
  private String dentanisekkbnsksflg = "0";

  /** 個口別伝ページ番号 */
  @Builder.Default
  private int kogbdnpagbng = 0;

  /** 確注処理／追加受注処理日付 */
  @Builder.Default
  private int kcyprctuijucprcdte = 0;

  /** 確注伝票出力順／追加受注処理時刻 */
  @Builder.Default
  private int kcydenoutjntjsjkk = 0;

  /** 売上在庫更新完了フラグ */
  @Builder.Default
  private String urizaiupdkruflg = "0";

  /** 売上在庫更新日付 */
  @Builder.Default
  private int urizaiupddte = 0;

  /** 新譜得意先ＥＤＩステータス区分 */
  @Builder.Default
  private String sintokedistskbn = "";

  /** 新譜得意先ＥＤＩ日付 */
  @Builder.Default
  private int sintokedidte = 0;

  /** 新譜ＪＡＲＥＤ ＥＤＩ済フラグ */
  @Builder.Default
  private String sinjrdedizflg = "0";

  /** 新譜ＪＡＲＥＤ ＥＤＩ日付 */
  @Builder.Default
  private int sinjrdedidte = 0;

  /** 新譜出荷プルーフ作成ステータス区分 */
  @Builder.Default
  private String sinsyaprfssestskbn = "";

  /** 新譜出荷プルーフ作成日付 */
  @Builder.Default
  private int sinsyaprfssedte = 0;

  /** ＣＯＭ作成ステータス区分 */
  @Builder.Default
  private String comssestskbn = "";

  /** ＣＯＭ作成日付 */
  @Builder.Default
  private int comssedte = 0;

  /** 仮引当処理解除済フラグ */
  @Builder.Default
  private String khaprckjyzflg = "0";

  /** 仮引当日付 */
  @Builder.Default
  private int khadte = 0;

  /** 新譜抽出ステータス区分（伝票日付基準） */
  @Builder.Default
  private String sincshstskbndnkj = "";

  /** 新譜抽出ステータス区分（発売日基準） */
  @Builder.Default
  private String sincshstskbnhbkj = "";

  /** 新譜抽出ステータス区分（作成日基準） */
  @Builder.Default
  private String sincshstskbnsbkj = "";

  /** 伝票作成日付 */
  @Builder.Default
  private int denssedte = 0;

  /** 伝票作成時刻 */
  @Builder.Default
  private int denssejkk = 0;

  /** ＥＤＩ済フラグ */
  @Builder.Default
  private String edizflg = "0";

  /** ＥＤＩ日付 */
  @Builder.Default
  private int edidte = 0;

  /** ＥＤＩ時刻 */
  @Builder.Default
  private int edijkk = 0;

  /** ＧＰＲＯ送信済フラグ */
  @Builder.Default
  private String gprossnzflg = "0";

  /** ＧＰＲＯ送信日付 */
  @Builder.Default
  private int gprossndte = 0;

  /** ＧＰＲＯ送信時刻 */
  @Builder.Default
  private int gprossnjkk = 0;

  /** 伝票統合入力済フラグ */
  @Builder.Default
  private String dentguinpzflg = "0";

  /** 伝票統合入力日付 */
  @Builder.Default
  private int dentguinpdte = 0;

  /** 伝票統合入力時刻 */
  @Builder.Default
  private int dentguinpjkk = 0;

  /** 伝票トラン作成済フラグ */
  @Builder.Default
  private String dentrnssezflg = "0";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 配送日付 */
  @Builder.Default
  private int hsodte = 0;

  /** 倉庫出荷日付 */
  @Builder.Default
  private int skosyadte = 0;

  /** 配送情報指示見出受付ＮＯ */
  @Builder.Default
  private int hsoinfsjimdsutkno = 0;

  /** 配送ルートコード */
  @Builder.Default
  private String hsorotcod = "";

  /** 日中伝票トラン送信済フラグ */
  @Builder.Default
  private String nchdentrnssnzflg = "0";

  /** 日中伝票トラン送信日付 */
  @Builder.Default
  private int nchdentrnssndte = 0;

  /** 日中伝票トラン送信時刻 */
  @Builder.Default
  private int nchdentrnssnjkk = 0;

}
