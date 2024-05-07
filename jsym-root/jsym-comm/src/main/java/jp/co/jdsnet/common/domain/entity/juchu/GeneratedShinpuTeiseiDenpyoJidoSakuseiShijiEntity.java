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
 * 新譜訂正伝票自動作成指示Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuTeiseiDenpyoJidoSakuseiShijiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 新譜訂正対象区分 */
  @Keyfield(index = 1)
  @Builder.Default
  private String sinteiobjkbn = "";

  /** 代表会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 発売日 */
  @Keyfield(index = 3)
  @Builder.Default
  private int hbidte = 0;

  /** 記号番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String kigbng = "";

  /** 訂正指示有フラグ（＋） */
  @Builder.Default
  private String teisjiariflgpls = "";

  /** 訂正指示有フラグ（－） */
  @Builder.Default
  private String teisjiariflgmns = "";

  /** 送信日付 */
  @Builder.Default
  private int ssndte = 0;

  /** 確注処理日付 */
  @Builder.Default
  private int kcyprcdte = 0;

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** フリーメッセージ１ */
  @Builder.Default
  private String fmg1 = "";

  /** フリーメッセージ２ */
  @Builder.Default
  private String fmg2 = "";

  /** エントリー日付 */
  @Builder.Default
  private int entdte = 0;

  /** エントリー時刻 */
  @Builder.Default
  private int entjkk = 0;

  /** 処理予定日付 */
  @Builder.Default
  private int prcytedte = 0;

  /** 処理完了フラグ */
  @Builder.Default
  private String prckruflg = "0";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 元伝フリーメッセージ使用フラグ */
  @Builder.Default
  private String mtdfmguseflg = "0";

}
