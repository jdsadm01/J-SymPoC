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
 * エラー見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedErrorMidashiEntity implements EntityInterface {

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

  /** 作成時間 */
  @Keyfield(index = 5)
  @Builder.Default
  private int ssejkk = 0;

  /** 会社識別コード */
  @Keyfield(index = 6)
  @Builder.Default
  private String kaiskbcod = "";

  /** トータル明細数 */
  @Builder.Default
  private int ttlmsisuu = 0;

  /** Ｗ／ＳＳＥＱＮＯ */
  @Builder.Default
  private String wsseqno = "";

  /** ターミナルＮＯ */
  @Builder.Default
  private String trmno = "";

  /** トラン区分 */
  @Builder.Default
  private String trnkbn = "";

  /** 受注区分 */
  @Builder.Default
  private String juckbn = "";

  /** 得意先コード */
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Builder.Default
  private String dscod = "";

  /** 倉庫コード（ヘッダ） */
  @Builder.Default
  private String skocod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** 発注番号（ヘッダ） */
  @Builder.Default
  private String hacbng = "";

  /** リマークコード（ヘッダ） */
  @Builder.Default
  private String rmcod = "";

  /** ＳＪコード */
  @Builder.Default
  private String sjcod = "";

  /** Ｃ直スキップ */
  @Builder.Default
  private String cchskp = "";

  /** 注残マージスキップ */
  @Builder.Default
  private String chzmskp = "";

  /** 貸出区分 */
  @Builder.Default
  private String kdakbn = "";

  /** 金額表示区分 */
  @Builder.Default
  private String kinhjikbn = "";

  /** 管理区分 */
  @Builder.Default
  private String knrkbn = "";

  /** 仕向地 */
  @Builder.Default
  private String smt = "";

  /** 翌勘コード */
  @Builder.Default
  private String ykkcod = "";

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** フリーメッセージ１ */
  @Builder.Default
  private String fmg1 = "";

  /** フリーメッセージ２ */
  @Builder.Default
  private String fmg2 = "";

  /** 返品リラティブＮＯ */
  @Builder.Default
  private String hpnrelno = "";

  /** エラーレコード件数 */
  @Builder.Default
  private int errrecsuu = 0;

  /** 受信レコード件数 */
  @Builder.Default
  private int jsnrecsuu = 0;

  /** 送信レコード件数 */
  @Builder.Default
  private int ssnrecsuu = 0;

  /** Ａ／Ｂ在庫区分 */
  @Builder.Default
  private String abkbn = "";

  /** 元倉庫コード */
  @Builder.Default
  private String mso = "";

  /** 先倉庫コード */
  @Builder.Default
  private String sso = "";

  /** 当／前月 */
  @Builder.Default
  private String tomznmkbn = "";

  /** 受付番号 */
  @Builder.Default
  private String utkbng = "";

  /** エラーコード（ヘッダ） */
  @Builder.Default
  private String errcod = "";

  /** トランザクション名称コード */
  @Builder.Default
  private String trnnmcod = "";

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
