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
 * テーブル更新履歴Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTableKoshinRirekiEntity implements EntityInterface {

  // 永続属性 ↓
  /** テーブルＩＤ */
  @Builder.Default
  private String tblid = "";

  /** 主キー */
  @Builder.Default
  private String prykey = "";

  /** テーブル更新区分 */
  @Builder.Default
  private String tblupdkbn = "";

  /** ＣＰＵＩＤ */
  @Builder.Default
  private String cpuid = "";

  /** 端末ＩＤ */
  @Builder.Default
  private String tmlid = "";

  /** ＷＳＳＥＱ（７桁） */
  @Builder.Default
  private int wsseq7kt = 0;

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** Ｊ－ＳＹＭユーザーＩＤ */
  @Builder.Default
  private String jsymusrid = "";

  /** サービスＩＤ */
  @Builder.Default
  private String svcid = "";

  /** 入力日付 */
  @Builder.Default
  private int inpdte = 0;

  /** 入力時刻 */
  @Builder.Default
  private int inpjkk = 0;

  /** テーブル更新日付（８桁） */
  @Builder.Default
  private int tblupddte8kt = 0;

  /** テーブル更新時刻（９桁） */
  @Builder.Default
  private int tblupdjkk9kt = 0;

  /** 更新前データ本体 */
  @Builder.Default
  private String updmaedtabdy = "";

  /** 更新後データ本体 */
  @Builder.Default
  private String updgodtabdy = "";

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
