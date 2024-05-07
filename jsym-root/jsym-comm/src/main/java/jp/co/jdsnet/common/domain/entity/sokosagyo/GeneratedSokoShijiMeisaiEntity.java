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
 * 倉庫指示明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSokoShijiMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 倉庫指示見出ＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String skosjimdsid = "";

  /** ＳＥＱ */
  @Keyfield(index = 2)
  @Builder.Default
  private int seq = 0;

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 指示数量 */
  @Builder.Default
  private int sjisur = 0;

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

  /** 訂正指示有フラグ（＋） */
  @Builder.Default
  private String teisjiariflgpls = "";

  /** 訂正数量（＋） */
  @Builder.Default
  private int teisurpls = 0;

  /** 訂正リマークコード（＋） */
  @Builder.Default
  private String teirmcodpls = "";

  /** 訂正伝票摘要（＋） */
  @Builder.Default
  private String teidentyopls = "";

  /** 訂正指示有フラグ（－） */
  @Builder.Default
  private String teisjiariflgmns = "";

  /** 訂正数量（－） */
  @Builder.Default
  private int teisurmns = 0;

  /** 訂正リマークコード（－） */
  @Builder.Default
  private String teirmcodmns = "";

  /** 訂正伝票摘要（－） */
  @Builder.Default
  private String teidentyomns = "";

  /** 先行トランコード */
  @Builder.Default
  private String snktrncod = "";

  /** 先行トラン会社識別コード */
  @Builder.Default
  private String snktrnkaiskbcod = "";

  /** 先行トラン伝票日付 */
  @Builder.Default
  private int snktrndendte = 0;

  /** 先行トランメーカー伝票番号ＦＲＯＭ */
  @Builder.Default
  private String snktrnmkrdenbngfrm = "";

  /** 先行トランメーカー伝票番号ＴＯ */
  @Builder.Default
  private String snktrnmkrdenbngto = "";

  /** 発注伝票番号 */
  @Builder.Default
  private String hacdenbng = "";

  /** 発注伝票行番号 */
  @Builder.Default
  private String hacdengyb = "";

  /** 画面行番号 */
  @Builder.Default
  private String gmngyb = "";

  /** 積送ＳＥＱ */
  @Builder.Default
  private int sekseq = 0;

  /** 自動償却リラティブＮＯ ＦＲＯＭ */
  @Builder.Default
  private int autskyrelnofrm = 0;

  /** 自動償却リラティブＮＯ ＴＯ */
  @Builder.Default
  private int autskyrelnoto = 0;

  /** 留置倉庫コード */
  @Builder.Default
  private String tmeskocod = "";

  /** Ａ／Ｂ在庫区分 */
  @Builder.Default
  private String abzaikbn = "";

  /** 償却／留置区分 */
  @Builder.Default
  private String skytmekbn = "";

  /** 伝票摘要 */
  @Builder.Default
  private String dentyo = "";

  /** 棚上指示有サイン */
  @Builder.Default
  private String tnasjiarisgn = "";

  /** 入力チェックエラー区分 */
  @Builder.Default
  private String inpchkerrkbn = "";

  /** エラー有フラグ */
  @Builder.Default
  private String errariflg = "0";

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
