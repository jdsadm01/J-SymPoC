package jp.co.jdsnet.common.domain.entity.juchu;

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
 * 注残Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedChuzanEntity implements EntityInterface {

  // 永続属性 ↓
  /** 受注日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int jucdte = 0;

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String dscod = "";

  /** 受注見出ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int jucmdsseq = 0;

  /** 受注明細ＳＥＱ */
  @Keyfield(index = 5)
  @Builder.Default
  private int jucmsiseq = 0;

  /** ＳＥＱ */
  @Keyfield(index = 6)
  @Builder.Default
  private int seq = 0;

  /** トランコード */
  @Builder.Default
  private String trncod = "";

  /** 注残場所コード */
  @Builder.Default
  private String chzbshcod = "";

  /** 注残倉庫コード */
  @Builder.Default
  private String chzskocod = "";

  /** 注残日付 */
  @Builder.Default
  private int chzdte = 0;

  /** 注残時刻 */
  @Builder.Default
  private int chzjkk = 0;

  /** 得意先発注番号 */
  @Builder.Default
  private String thcbng = "";

  /** ＳＪコード */
  @Builder.Default
  private String sjcod = "";

  /** 翌勘コード */
  @Builder.Default
  private String ykncod = "";

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** 単価／金額表示フラグ */
  @Builder.Default
  private String tankinhjiflg = "0";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 登録時注残数量 */
  @Builder.Default
  private int trjchzsur = 0;

  /** 注残数量 */
  @Builder.Default
  private int chzsur = 0;

  /** 単価／金額指定区分 */
  @Builder.Default
  private String tankinstekbn = "";

  /** 仕切単価 */
  @Builder.Default
  private double skrtan = 0D;

  /** リマークコード */
  @Builder.Default
  private String rmcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** 倉庫指定有フラグ */
  @Builder.Default
  private String skosteariflg = "0";

  /** 注残リラティブＮＯ */
  @Builder.Default
  private int chzrelno = 0;

  /** ＣＰＵフルＩＤ */
  @Builder.Default
  private String cpufulid = "";

  /** ＷＳＳＥＱ（７桁） */
  @Builder.Default
  private int wsseq7kt = 0;

  /** 注残キック指示済フラグ */
  @Builder.Default
  private String chzkicsjizflg = "0";

  /** 注残ステータス区分 */
  @Builder.Default
  private String chzstskbn = "";

  /** 削除フラグ */
  @Builder.Default
  private String delflg = "0";

  /** 優先順日付 */
  @Builder.Default
  private int usnjndte = 0;

  /** Ｃ直フラグ */
  @Builder.Default
  private String cchflg = "0";

  /** Ｃ直対応結果区分 */
  @Builder.Default
  private String cchtioktkkbn = "";

  /** Ｃ直引当倉庫コード */
  @Builder.Default
  private String cchhatskocod = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 注残削除日付 */
  @Builder.Default
  private int chzdeldte = 0;

  /** 注残削除基準日付 */
  @Builder.Default
  private int chzdelkjndte = 0;

  /** フリーメッセージ１ */
  @Builder.Default
  private String fmg1 = "";

  /** フリーメッセージ２ */
  @Builder.Default
  private String fmg2 = "";

}
