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
 * 受注状況テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedOrderStatusEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** ＣＰＵＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String cpuid = "";

  /** 端末ＩＤ */
  @Keyfield(index = 3)
  @Builder.Default
  private String tmlid = "";

  /** 受注日付 */
  @Keyfield(index = 4)
  @Builder.Default
  private int jucdte = 0;

  /** 受注時刻 */
  @Keyfield(index = 5)
  @Builder.Default
  private int jucjkk = 0;

  /** ユーザーシーケンス№ */
  @Keyfield(index = 6)
  @Builder.Default
  private int usrseqno = 0;

  /** 会社識別コード */
  @Keyfield(index = 7)
  @Builder.Default
  private String kaiskbcod = "";

  /** 得意先コード */
  @Keyfield(index = 8)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 9)
  @Builder.Default
  private String dscod = "";

  /** トランコード */
  @Keyfield(index = 10)
  @Builder.Default
  private String trncod = "";

  /** 地区コード */
  @Keyfield(index = 11)
  @Builder.Default
  private String tikcod = "";

  /** 場所コード */
  @Keyfield(index = 12)
  @Builder.Default
  private String bshcod = "";

  /** 新旧区分 */
  @Builder.Default
  private String sinkyukbn = "";

  /** 受注区分 */
  @Builder.Default
  private String juckbn = "";

  /** 受注行数 */
  @Builder.Default
  private int jucgysuu = 0;

  /** 受注数量 */
  @Builder.Default
  private int jucsuu = 0;

  /** オーダー数 */
  @Builder.Default
  private int ordsuu = 0;

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
