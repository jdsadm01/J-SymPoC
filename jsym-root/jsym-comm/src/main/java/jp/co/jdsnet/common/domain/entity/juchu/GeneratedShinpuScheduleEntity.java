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
 * 新譜スケジュールEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuScheduleEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 発売日 */
  @Keyfield(index = 2)
  @Builder.Default
  private int hbidte = 0;

  /** 新譜受注サイン */
  @Keyfield(index = 3)
  @Builder.Default
  private String sinjucsgn = "";

  /** 確注処理日付 */
  @Builder.Default
  private int kcyprcdte = 0;

  /** 前回確注処理日付 */
  @Builder.Default
  private int zkakcyprcdte = 0;

  /** 確注処理完了フラグ */
  @Builder.Default
  private String kcyprckruflg = "0";

  /** デ－タ送信日（卸店） */
  @Builder.Default
  private int dtassnors = 0;

  /** 出荷日付 */
  @Builder.Default
  private int syadte = 0;

  /** ＭＳコード */
  @Builder.Default
  private String mscod = "";

  /** フリーメッセージ１ */
  @Builder.Default
  private String fmg1 = "";

  /** フリーメッセージ２ */
  @Builder.Default
  private String fmg2 = "";

  /** 新譜出荷可能日付 */
  @Builder.Default
  private int sinsyakandte = 0;

  /** 翌勘店締日（ＦＲＯＭ） */
  @Builder.Default
  private int ykksmedtefrm = 0;

  /** 翌勘店締日（ＴＯ） */
  @Builder.Default
  private int ykksmedteto = 0;

  /** 確注処理不要フラグ */
  @Builder.Default
  private String kcyprchuyflg = "0";

  /** 指定伝作成日付 */
  @Builder.Default
  private int stdssedte = 0;

  /** 指定伝作成ステータス区分 */
  @Builder.Default
  private String stdssestskbn = "";

  /** 仮引当日付 */
  @Builder.Default
  private int khadte = 0;

  /** 仮引当処理解除済フラグ */
  @Builder.Default
  private String khaprckjyzflg = "0";

  /** 新譜出荷プルーフ作成日付 */
  @Builder.Default
  private int sinsyaprfssedte = 0;

  /** 新譜出荷プルーフ作成ステータス区分 */
  @Builder.Default
  private String sinsyaprfssestskbn = "";

  /** 配送日報作成日付 */
  @Builder.Default
  private int hsonpossedte = 0;

  /** 配送日報作成ステータス区分 */
  @Builder.Default
  private String hsonpossestskbn = "";

  /** 売上在庫更新日付 */
  @Builder.Default
  private int urizaiupddte = 0;

  /** 売上在庫更新完了フラグ */
  @Builder.Default
  private String urizaiupdkruflg = "0";

  /** ＣＯＭ作成日付 */
  @Builder.Default
  private int comssedte = 0;

  /** ＣＯＭ作成ステータス区分 */
  @Builder.Default
  private String comssestskbn = "";

  /** 得意先ＥＤＩ日付１ */
  @Builder.Default
  private int tokedidte1 = 0;

  /** 得意先ＥＤＩ日付２ */
  @Builder.Default
  private int tokedidte2 = 0;

  /** 新譜得意先ＥＤＩステータス区分 */
  @Builder.Default
  private String sintokedistskbn = "";

  /** 確注登録日付 */
  @Builder.Default
  private int kcytrkdte = 0;

  /** 確注登録ステータス区分 */
  @Builder.Default
  private String kcytrkstskbn = "";

  /** レコード数（５桁） */
  @Builder.Default
  private int recsuu5kt = 0;

  /** 明細数（７桁） */
  @Builder.Default
  private int msisuu7kt = 0;

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
