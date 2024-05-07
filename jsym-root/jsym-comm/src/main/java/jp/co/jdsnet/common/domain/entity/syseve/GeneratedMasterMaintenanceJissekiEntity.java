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
 * マスターメンテ実績Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedMasterMaintenanceJissekiEntity implements EntityInterface {

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

  /** キーフィールド */
  @Keyfield(index = 5)
  @Builder.Default
  private String keyfld = "";

  /** 入力日付 */
  @Keyfield(index = 6)
  @Builder.Default
  private int inpdte = 0;

  /** 入力時刻 */
  @Keyfield(index = 7)
  @Builder.Default
  private int inpjkk = 0;

  /** メンテ指示区分 */
  @Builder.Default
  private String mtnsjikbn = "";

  /** メンテ前更新日付 */
  @Builder.Default
  private int mtnmaeupddte = 0;

  /** メンテ前更新時刻 */
  @Builder.Default
  private int mtnmaeupdjkk = 0;

  /** メンテ処理コード */
  @Builder.Default
  private String mtnprccod = "";

  /** エラーコード */
  @Builder.Default
  private String errcod = "";

  /** メンテユーザー情報 */
  @Builder.Default
  private String mtnusrinf = "";

  /** メンテ前データ本体 */
  @Builder.Default
  private String mtnmaedtabdy = "";

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
