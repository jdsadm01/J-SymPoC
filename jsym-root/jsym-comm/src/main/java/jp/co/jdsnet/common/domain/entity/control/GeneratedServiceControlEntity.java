package jp.co.jdsnet.common.domain.entity.control;

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
 * サービスコントロールテーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedServiceControlEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** ユーザー分類 */
  @Keyfield(index = 2)
  @Builder.Default
  private String usrbun = "";

  /** 業務ＩＤ */
  @Keyfield(index = 3)
  @Builder.Default
  private String gymid = "";

  /** 処理区分 */
  @Keyfield(index = 4)
  @Builder.Default
  private String prckbn = "";

  /** サービスＦＬＧ１ */
  @Builder.Default
  private String svcflg1 = "";

  /** サービス開始日１ */
  @Builder.Default
  private int svcsttdte1 = 0;

  /** サービス終了日１ */
  @Builder.Default
  private int svcenddte1 = 0;

  /** サービス開始時刻１ */
  @Builder.Default
  private int svcsttjkk1 = 0;

  /** サービス終了時刻１ */
  @Builder.Default
  private int svcendjkk1 = 0;

  /** サービスＦＬＧ２ */
  @Builder.Default
  private String svcflg2 = "";

  /** サービス開始日２ */
  @Builder.Default
  private int svcsttdte2 = 0;

  /** サービス終了日２ */
  @Builder.Default
  private int svcenddte2 = 0;

  /** サービス開始時刻２ */
  @Builder.Default
  private int svcsttjkk2 = 0;

  /** サービス終了時刻２ */
  @Builder.Default
  private int svcendjkk2 = 0;

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
