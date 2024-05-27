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
 * 中央倉庫対応テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedCenterSokoRelationEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 画面帳票ID */
  @Keyfield(index = 2)
  @Builder.Default
  private String pnllstid = "";

  /** 会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String kaiskbcod = "";

  /** 対応パターンコード */
  @Keyfield(index = 4)
  @Builder.Default
  private String tioptncod = "";

  /** ＳＥＱ№ */
  @Keyfield(index = 5)
  @Builder.Default
  private int seqno = 0;

  /** 倉庫コード */
  @Builder.Default
  private String skocod = "";

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