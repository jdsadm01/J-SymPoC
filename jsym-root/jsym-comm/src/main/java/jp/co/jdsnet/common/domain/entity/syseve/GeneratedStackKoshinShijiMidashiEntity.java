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
 * スタック更新指示見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedStackKoshinShijiMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 入力日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int inpdte = 0;

  /** 会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String kaiskbcod = "";

  /** ＳＥＱ */
  @Keyfield(index = 3)
  @Builder.Default
  private int seq = 0;

  /** スタック更新指示区分 */
  @Builder.Default
  private String staupdsjikbn = "";

  /** 営業所コード */
  @Builder.Default
  private String eigcod = "";

  /** 倉庫コード */
  @Builder.Default
  private String skocod = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** 処理完了フラグ */
  @Builder.Default
  private String prckruflg = "0";

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
