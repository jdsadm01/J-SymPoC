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
 * EXCEL作成指示履歴Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedExcelSakuseiShijiRirekiEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** 帳票ＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String chyid = "";

  /** 初回作成指示日付 */
  @Builder.Default
  private int sykssesjidte = 0;

  /** 累計指示回数 */
  @Builder.Default
  private int ruisjicnt = 0;

  /** 最新作成指示日付 */
  @Builder.Default
  private int sisssesjidte = 0;

  /** 最新作成指示時刻 */
  @Builder.Default
  private int sisssesjijkk = 0;

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
