package jp.co.jdsnet.common.domain.entity.soko;

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
 * 倉庫Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSokoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 倉庫コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String skocod = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 使用ブロックコード */
  @Builder.Default
  private String siyblkcod = "";

  /** 倉庫名カナ */
  @Builder.Default
  private String skonmkn = "";

  /** 倉庫名 */
  @Builder.Default
  private String skonm = "";

  /** 地区コード */
  @Builder.Default
  private String tikcod = "";

  /** 納品伝票マージ明細数 */
  @Builder.Default
  private int nohdenmrgmsisuu = 0;

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
