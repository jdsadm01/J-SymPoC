package jp.co.jdsnet.common.domain.entity.sokosagyo;

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
 * 配送情報指示見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHaisoJohoShijiMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 受付ＮＯ */
  @Keyfield(index = 1)
  @Builder.Default
  private int utkno = 0;

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** メーカー受付ＮＯ */
  @Builder.Default
  private int mkrutkno = 0;

  /** 検索キー */
  @Builder.Default
  private String kenkey = "";

  /** Ｊ－ＳＹＭユーザー代表会社識別コード */
  @Builder.Default
  private String jsymusrdaikaiskbcod = "";

  /** Ｊ－ＳＹＭユーザー会社名 */
  @Builder.Default
  private String jsymusrkainm = "";

  /** Ｊ－ＳＹＭユーザー部門名 */
  @Builder.Default
  private String jsymusrbmnnm = "";

  /** Ｊ－ＳＹＭ入力ユーザーＩＤ */
  @Builder.Default
  private String jsyminpusrid = "";

  /** Ｊ－ＳＹＭユーザー名 */
  @Builder.Default
  private String jsymusrnm = "";

  /** Ｊ－ＳＹＭユーザー場所コード */
  @Builder.Default
  private String jsymusrbshcod = "";

  /** トランフルコード */
  @Builder.Default
  private String trnfulcod = "";

  /** 配送先郵便番号（７桁） */
  @Builder.Default
  private String hsosakybnbng7kt = "";

  /** 配送先住所１ */
  @Builder.Default
  private String hsosakadr1 = "";

  /** 配送先住所２ */
  @Builder.Default
  private String hsosakadr2 = "";

  /** 配送先名 */
  @Builder.Default
  private String hsosaknm = "";

  /** 配送先電話番号（１３桁） */
  @Builder.Default
  private String hsosaktelbng13kt = "";

  /** 配送先出荷日付 */
  @Builder.Default
  private int hsosaksyadte = 0;

  /** 配送先店着日付 */
  @Builder.Default
  private int hsosaktncdte = 0;

  /** 時間帯指定区分 */
  @Builder.Default
  private String jktstekbn = "";

  /** 送り状表示メッセージ */
  @Builder.Default
  private String okrhjimsg = "";

  /** 倉庫伝達事項 */
  @Builder.Default
  private String skodntjko = "";

  /** 単価／金額表示フラグ */
  @Builder.Default
  private String tankinhjiflg = "0";

  /** 伝票送付先郵便番号（７桁） */
  @Builder.Default
  private String densfusakybnbng7kt = "";

  /** 伝票送付先住所１ */
  @Builder.Default
  private String densfusakadr1 = "";

  /** 伝票送付先住所２ */
  @Builder.Default
  private String densfusakadr2 = "";

  /** 伝票送付先名 */
  @Builder.Default
  private String densfusaknm = "";

  /** 伝票送付先電話番号（１３桁） */
  @Builder.Default
  private String densfusaktelbng13kt = "";

  /** 受信日付（８桁） */
  @Builder.Default
  private int jsndte8kt = 0;

  /** 受信時刻（９桁） */
  @Builder.Default
  private int jsnjkk9kt = 0;

  /** エラー有フラグ */
  @Builder.Default
  private String errariflg = "0";

  /** 配送先ＧＰＲＯ送信済フラグ */
  @Builder.Default
  private String hsosakgprossnzflg = "0";

  /** 配送先ＧＰＲＯ送信日付 */
  @Builder.Default
  private int hsosakgprossndte = 0;

  /** 配送先ＧＰＲＯ送信時刻 */
  @Builder.Default
  private int hsosakgprossnjkk = 0;

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
