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
 * 指定伝条件Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShiteidenJokenEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** 指定伝法人コード */
  @Builder.Default
  private String stdhjncod = "";

  /** 指定伝取引先コード */
  @Builder.Default
  private String stdtorsakcod = "";

  /** 指定伝請求締日 */
  @Builder.Default
  private int stdseismb = 0;

  /** 指定伝分類コード指示区分 */
  @Builder.Default
  private String stdbuncodsjikbn = "";

  /** 代表指定伝分類コード */
  @Builder.Default
  private String daistdbuncod = "";

  /** 指定伝別伝コード群 */
  @Builder.Default
  private String stdbdncodgun = "";

  /** 指定伝明細集計区分 */
  @Builder.Default
  private int stdmsishkkbn = 0;

  /** 指定伝伝票区分コード */
  @Builder.Default
  private String stddenkbncod = "";

  /** 和暦西暦区分 */
  @Builder.Default
  private String wrksrkkbn = "";

  /** 品名指示区分 */
  @Builder.Default
  private String hnmsjikbn = "";

  /** 品別番号指示区分 */
  @Builder.Default
  private int hbebngsjikbn = 0;

  /** 指定伝形態コード群 */
  @Builder.Default
  private String stdketcodgun = "";

  /** 指定伝摘要表示フラグ群 */
  @Builder.Default
  private String stdtyohjiflggun = "";

  /** 指定伝分類コード群 */
  @Builder.Default
  private String stdbuncodgun = "";

  /** Ａ欄指示区分 */
  @Builder.Default
  private String arnsjikbn = "";

  /** Ｆ欄指示区分 */
  @Builder.Default
  private String frnsjikbn = "";

  /** 売価表示区分 */
  @Builder.Default
  private String bkahjikbn = "";

  /** 商品コード指示区分 */
  @Builder.Default
  private String shocodsjikbn = "";

  /** 型番号指示区分 */
  @Builder.Default
  private String katbngsjikbn = "";

  /** 指定伝出力開始日付 */
  @Builder.Default
  private int stdoutsttdte = 0;

  /** 指定伝納品場所コード */
  @Builder.Default
  private String stdnohbshcod = "";

  /** 指定伝納品場所名 */
  @Builder.Default
  private String stdnohbshnm = "";

  /** 指定伝行数 */
  @Builder.Default
  private int stdgsu = 0;

  /** 指定伝法人削除フラグ */
  @Builder.Default
  private String stdhjndelflg = "0";

  /** ＧＰＲＯ送信区分 */
  @Builder.Default
  private String gprossnkbn = "";

  /** ＧＰＲＯ指定伝ＩＤ */
  @Builder.Default
  private String gprostdid = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 指定伝番号集約区分 */
  @Builder.Default
  private String stdbngsyykbn = "";

}
