package jp.co.jdsnet.common.domain.entity.tokuisaki;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import jp.co.jdsnet.common.domain.entity.Keyfield;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KakushaTokuisakiEntity implements EntityInterface {
  /** 代表会社識別コード */
  @Keyfield(index = 0)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 得意先コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String tokcod = "";

  /** 請求締日 */
  @Builder.Default
  private int seismb = 0;

  /** 入金店サイン */
  @Builder.Default
  private String nkntensgn = "";

  /** 取扱商品フラグ群 */
  @Builder.Default
  private String takshoflggun = "";

  /** 得意先ランクコード */
  @Builder.Default
  private String tokrakcod = "";

  /** 販路コード */
  @Builder.Default
  private String hnrcod = "";

  /** 与信限度対象区分 */
  @Builder.Default
  private String ygdobjkbn = "";

  /** 個社得意先コード */
  @Builder.Default
  private String ktscod = "";

  /** 市販特販店区分 */
  @Builder.Default
  private String shnthntenkbn = "";

  /** 得意先発注番号必須区分 */
  @Builder.Default
  private String thcbnghiskbn = "";

  /** 単価／金額表示フラグ */
  @Builder.Default
  private String tankinhjiflg = "";

  /** 端数調整区分 */
  @Builder.Default
  private String hsuchskbn = "";

  /** 取引開始日付 */
  @Builder.Default
  private int torsttdte = 0;

  /** 出荷停止日付 */
  @Builder.Default
  private int syatesdte = 0;

  /** 出荷停止区分 */
  @Builder.Default
  private String syateskbn = "";

  /** 翌勘不可店区分 */
  @Builder.Default
  private String yknfkatenkbn = "";

  /** 伝票マージ制限フラグ */
  @Builder.Default
  private String denmrgsgeflg = "";

  /** 売上集約店フラグ */
  @Builder.Default
  private String urisyytenflg = "";

  /** 売上集約店コード */
  @Builder.Default
  private String urisyytencod = "";

  /** 売上主要店区分 */
  @Builder.Default
  private String urimntkbn = "";

  /** Ｃ直スキップ店区分 */
  @Builder.Default
  private String cchskptenkbn = "";

  /** 注残指定店区分 */
  @Builder.Default
  private String chzstetenkbn = "";

  /** 注残主要店区分 */
  @Builder.Default
  private String chzmntkbn = "";

  /** 注残日数 */
  @Builder.Default
  private int chznsu = 0;

  /** 引当倉庫地区コード */
  @Builder.Default
  private String hatskotikcod = "";

  /** 返品集約店フラグ */
  @Builder.Default
  private String hpnsyytenflg = "";

  /** 返品集約店コード */
  @Builder.Default
  private String hpnsyytencod = "";

  /** 返品不可店区分 */
  @Builder.Default
  private String hpnfkatenkbn = "";

  /** 返品受入倉庫コード */
  @Builder.Default
  private String hpnukeskocod = "";

  /** 返品対策店区分 */
  @Builder.Default
  private String hpntaitenkbn = "";

  /** 返品Ａ枠端数処理選択区分 */
  @Builder.Default
  private String hpnawkhsuprcsntkbn = "";

  /** 返品枠案内書枠額表示区分 */
  @Builder.Default
  private String hpwanswgkhjikbn = "";

  /** 返品枠案内書送付区分 */
  @Builder.Default
  private String hpwanssfukbn = "";

  /** 返品枠通知先メンテ区分 */
  @Builder.Default
  private String hpntchmtnkbn = "";

  /** 指定伝返信封筒無フラグ */
  @Builder.Default
  private String stdrtnhutnasflg = "";

  /** 返品通知得意先名１ */
  @Builder.Default
  private String hpntchtoknm1 = "";

  /** 返品通知得意先名２ */
  @Builder.Default
  private String hpntchtoknm2 = "";

  /** 返品通知得意先部課名 */
  @Builder.Default
  private String hpntchtokbknm = "";

  /** 返品通知得意先住所１ */
  @Builder.Default
  private String hpntchtokadr1 = "";

  /** 返品通知得意先住所２ */
  @Builder.Default
  private String hpntchtokadr2 = "";

  /** 返品通知電話番号 */
  @Builder.Default
  private String hpntchtelbng = "";

  /** 返品通知郵便番号（７桁） */
  @Builder.Default
  private String hpntchybnbng7kt = "";

  /** 出荷日付コード */
  @Builder.Default
  private String syadtecod = "";

  /** 配送日付コード */
  @Builder.Default
  private String hsodtecod = "";

  /** 新譜翌勘区分 */
  @Builder.Default
  private String sinyknkbn = "";

  /** 出荷制限グループコード */
  @Builder.Default
  private String syasgegrpcod = "";

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
