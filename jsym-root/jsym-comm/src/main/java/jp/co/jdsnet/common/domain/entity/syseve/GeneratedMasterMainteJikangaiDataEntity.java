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
 * マスターメンテ時間外データEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedMasterMainteJikangaiDataEntity implements EntityInterface {

  // 永続属性 ↓
  /** テーブルＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String tblid = "";

  /** メンテキー */
  @Keyfield(index = 2)
  @Builder.Default
  private String mtnkey = "";

  /** フォーマットＮＯ */
  @Keyfield(index = 3)
  @Builder.Default
  private String fmtno = "";

  /** メンテＮＯ */
  @Keyfield(index = 4)
  @Builder.Default
  private String mtnno = "";

  /** 場所コード */
  @Keyfield(index = 5)
  @Builder.Default
  private String bshcod = "";

  /** 入力日付８桁 */
  @Keyfield(index = 6)
  @Builder.Default
  private int inpdte8kt = 0;

  /** 入力時刻 */
  @Keyfield(index = 7)
  @Builder.Default
  private int inpjkk = 0;

  /** ユーザーシーケンスＮＯ */
  @Builder.Default
  private int usrseqno = 0;

  /** メンテ指示区分 */
  @Builder.Default
  private String mtnsjikbn = "";

  /** 反映予定日付 */
  @Builder.Default
  private int hneytedte = 0;

  /** 送信フラグ */
  @Builder.Default
  private String ssnflg = "0";

  /** 送信日付８桁 */
  @Builder.Default
  private int ssndte8kt = 0;

  /** 送信時刻 */
  @Builder.Default
  private int ssnjkk = 0;

  /** ユーザーＩＤ */
  @Builder.Default
  private String usrid = "";

  /** メンテ指示データ本体 */
  @Builder.Default
  private String mtnsjidtabdy = "";

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
