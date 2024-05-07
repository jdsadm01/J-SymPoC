package jp.co.jdsnet.common.domain.entity.kaisha;

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
 * 会社情報Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedLightKaishaInformationEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String kaiskbcod = "";

  /** カレント世代ユーザーＩＤ */
  @Builder.Default
  private int cursdiusrid = 0;

  /** パスワード */
  @Builder.Default
  private String pwd = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 会社名 */
  @Builder.Default
  private String kainmkj = "";

  /** 会社関係フラグ */
  @Builder.Default
  private String kairltflg = "0";

  /** 郵便番号 */
  @Builder.Default
  private String kaiybnno = "";

  /** 住所１ */
  @Builder.Default
  private String kaiadr1kj = "";

  /** 住所２ */
  @Builder.Default
  private String kaiadr2kj = "";

  /** ＴＥＬ */
  @Builder.Default
  private String kaitelno = "";

  /** ＦＡＸ */
  @Builder.Default
  private String kaifaxbng = "";

  /** ＬＯＧＯ */
  @Builder.Default
  private String kailogo = "";

  /** チェックＩＰ */
  @Builder.Default
  private String chkip = "";

  /** ｱｸｾｽﾁｪｯｸ区分 */
  @Builder.Default
  private String acschkkbn = "";

  /** 表示区分 */
  @Builder.Default
  private String hyokbn = "";

  /** 会社締め日 */
  @Builder.Default
  private int kaismb = 0;

  /** 発注書パターン */
  @Builder.Default
  private String hacsyoptn = "";

  /** 会社名２ */
  @Builder.Default
  private String kainmkj2 = "";

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
