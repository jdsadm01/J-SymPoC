package jp.co.jdsnet.common.domain.entity.tokuisaki;

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
 * 共通得意先Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedKyotsuTokuisakiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 得意先コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String tokcod = "";

  /** 得意先名カナ１ */
  @Builder.Default
  private String toknmkn1 = "";

  /** 得意先名カナ２ */
  @Builder.Default
  private String toknmkn2 = "";

  /** 得意先名カナ（拡張） */
  @Builder.Default
  private String toknmknkkc = "";

  /** 得意先名１ */
  @Builder.Default
  private String toknm1 = "";

  /** 得意先名２ */
  @Builder.Default
  private String toknm2 = "";

  /** 得意先名（拡張） */
  @Builder.Default
  private String toknmkkc = "";

  /** 得意先住所カナ１ */
  @Builder.Default
  private String tokadrkn1 = "";

  /** 得意先住所カナ２ */
  @Builder.Default
  private String tokadrkn2 = "";

  /** 得意先住所カナ（拡張） */
  @Builder.Default
  private String tokadrknkkc = "";

  /** 得意先住所１ */
  @Builder.Default
  private String tokadr1 = "";

  /** 得意先住所２ */
  @Builder.Default
  private String tokadr2 = "";

  /** 得意先住所（拡張） */
  @Builder.Default
  private String tokadrkkc = "";

  /** 得意先郵便番号 */
  @Builder.Default
  private String tokybnbng = "";

  /** 得意先電話番号 */
  @Builder.Default
  private String toktelbng = "";

  /** 得意先ＦＡＸ番号 */
  @Builder.Default
  private String tokfaxbng = "";

  /** 地区コード */
  @Builder.Default
  private String tikcod = "";

  /** 都道府県コード */
  @Builder.Default
  private int tdfcod = 0;

  /** 受注ブロックコード */
  @Builder.Default
  private String jucblkcod = "";

  /** 貸レ店レンタル店区分 */
  @Builder.Default
  private String krerntkbn = "";

  /** ＥＤＩ担当店コード */
  @Builder.Default
  private String editnttencod = "";

  /** ＥＤＩ出力場所コード */
  @Builder.Default
  private String edioutbshcod = "";

  /** ＶＡＮ処理指定時刻 */
  @Builder.Default
  private int vanprcstejkk = 0;

  /** 納品伝票別伝コード群 */
  @Builder.Default
  private String nohdenbdncodgun = "";

  /** 指定伝区分 */
  @Builder.Default
  private String stdkbn = "";

  /** メーカー別伝区分 */
  @Builder.Default
  private String mkrbdnkbn = "";

  /** 在確ＦＡＸ番号１ */
  @Builder.Default
  private String zkkfaxbng1 = "";

  /** 在確ＦＡＸ番号２ */
  @Builder.Default
  private String zkkfaxbng2 = "";

  /** 得意先発注番号展開区分 */
  @Builder.Default
  private String thcbngtekkbn = "";

  /** 得意先郵便番号（７桁） */
  @Builder.Default
  private String tokybnbng7kt = "";

  /** 店種別 */
  @Builder.Default
  private String msesyb = "";

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
