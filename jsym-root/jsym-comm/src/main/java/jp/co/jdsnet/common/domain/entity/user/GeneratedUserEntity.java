package jp.co.jdsnet.common.domain.entity.user;

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
 * ユーザーマスターEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedUserEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーＩＤ（内部） */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** 会社名 */
  @Builder.Default
  private String kainmkj = "";

  /** 部署名 */
  @Builder.Default
  private String bmnnmkj = "";

  /** ユーザー名 */
  @Builder.Default
  private String usrnmkj = "";

  /** 使用開始日 */
  @Builder.Default
  private int usesttdte = 0;

  /** 使用停止日 */
  @Builder.Default
  private int useenddte = 0;

  /** ユーザー区分 */
  @Builder.Default
  private String usrkbn = "";

  /** ユーザー分類 */
  @Builder.Default
  private String usrbun = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** 倉庫コードＦＲＯＭ */
  @Builder.Default
  private String skocodfrom = "";

  /** 倉庫コードＴＯ */
  @Builder.Default
  private String skocodto = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** メーカー分類 */
  @Builder.Default
  private String mkrbun = "";

  /** テリトリーコード */
  @Builder.Default
  private String tercod = "";

  /** ＣＰＵＩＤ */
  @Builder.Default
  private String cpuid = "";

  /** 端末ＩＤ */
  @Builder.Default
  private String tmlid = "";

  /** ロールＩＤ */
  @Builder.Default
  private String roleid = "";

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** メールアドレス */
  @Builder.Default
  private String malads = "";

  /** 110用営業所コード */
  @Builder.Default
  private String eigcod110 = "";

  /** 得意先104役職ID */
  @Builder.Default
  private int tok104yakid = 0;

  /** 備考 */
  @Builder.Default
  private String bikou = "";

}
