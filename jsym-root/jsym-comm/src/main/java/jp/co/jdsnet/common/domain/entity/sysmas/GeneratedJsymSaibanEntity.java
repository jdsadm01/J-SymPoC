package jp.co.jdsnet.common.domain.entity.sysmas;

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
 * ＮＯテーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedJsymSaibanEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** 代表会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 分類 */
  @Keyfield(index = 3)
  @Builder.Default
  private String bun = "";

  /** キーフィールド */
  @Keyfield(index = 4)
  @Builder.Default
  private String keyfld = "";

  /** カレントＮＯ */
  @Builder.Default
  private String curno = "";

  /** クリア方法 */
  @Builder.Default
  private String clemth = "";

  /** 上限ＮＯ */
  @Builder.Default
  private int jgnno = 0;

  /** 下限ＮＯ */
  @Builder.Default
  private int kgnno = 0;

  /** 前回処理日付 */
  @Builder.Default
  private int zkaprcdte = 0;

  /** 当日開始ＮＯ */
  @Builder.Default
  private int todsttno = 0;

  /** 当月開始ＮＯ */
  @Builder.Default
  private int tomsttno = 0;

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
