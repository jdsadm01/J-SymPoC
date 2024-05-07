package jp.co.jdsnet.common.domain.entity.menu;

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
 * イベントマスタEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedEventEntity implements EntityInterface {

  // 永続属性 ↓
  /** 画面ＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String gmnid = "";

  /** 画面ＩＤシーケンスＮＯ */
  @Keyfield(index = 2)
  @Builder.Default
  private String gmnseqno = "";

  /** 画面区分 */
  @Keyfield(index = 3)
  @Builder.Default
  private String gmnkbn = "";

  /** 処理トラン */
  @Builder.Default
  private String prctrn = "";

  /** サービスID */
  @Builder.Default
  private String svcid = "";

  /** 業務ＩＤ */
  @Builder.Default
  private String gymid = "";

  /** 処理区分 */
  @Builder.Default
  private String prckbn = "";

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 溜め打ちフラグ */
  @Builder.Default
  private String tameuchiflg = "0";

  /** Senderクラス名 */
  @Builder.Default
  private String sendclsnm = "";

  /** 処理名称 */
  @Builder.Default
  private String prcnm = "";

  /** エントリーチェック有フラグ */
  @Builder.Default
  private String entchkariflg = "0";

}
