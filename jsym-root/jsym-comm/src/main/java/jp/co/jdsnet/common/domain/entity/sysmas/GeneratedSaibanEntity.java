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
 * 採番Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSaibanEntity implements EntityInterface {

  // 永続属性 ↓
  /** 採番ＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String sibid = "";

  /** 採番ＣＰＵフルＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String sibcpufulid = "";

  /** 採番会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String sibkaiskbcod = "";

  /** 採番倉庫コード */
  @Keyfield(index = 4)
  @Builder.Default
  private String sibskocod = "";

  /** 採番トランコード */
  @Keyfield(index = 5)
  @Builder.Default
  private String sibtrncod = "";

  /** 採番得意先コード */
  @Keyfield(index = 6)
  @Builder.Default
  private String sibtokcod = "";

  /** 採番トランフルコード */
  @Keyfield(index = 7)
  @Builder.Default
  private String sibtrnfulcod = "";

  /** カレントＮＯ */
  @Builder.Default
  private int curno = 0;

  /** 上限ＮＯ */
  @Builder.Default
  private int jogno = 0;

  /** 下限ＮＯ */
  @Builder.Default
  private int kagno = 0;

  /** 当日開始ＮＯ */
  @Builder.Default
  private int todsttno = 0;

  /** 当月開始ＮＯ */
  @Builder.Default
  private int tomsttno = 0;

  /** クリア方法コード */
  @Builder.Default
  private String clemthcod = "";

  /** 前回処理日付 */
  @Builder.Default
  private int zkaprcdte = 0;

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
