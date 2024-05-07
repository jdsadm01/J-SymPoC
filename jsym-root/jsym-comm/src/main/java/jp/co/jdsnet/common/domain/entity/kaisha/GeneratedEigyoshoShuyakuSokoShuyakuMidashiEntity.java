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
 * 営業所集約／倉庫集約　見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedEigyoshoShuyakuSokoShuyakuMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 画面リストＩＤ */
  @Keyfield(index = 2)
  @Builder.Default
  private String gmnlstid = "";

  /** 機能ＮＯ */
  @Keyfield(index = 3)
  @Builder.Default
  private String fncno = "";

  /** 会社識別コード */
  @Keyfield(index = 4)
  @Builder.Default
  private String kaiskbcod = "";

  /** 営業所集約コード */
  @Keyfield(index = 5)
  @Builder.Default
  private String eigsyycod = "";

  /** 倉庫集約コード */
  @Keyfield(index = 6)
  @Builder.Default
  private String skosyycod = "";

  /** 営業所集約名 */
  @Builder.Default
  private String eigsyynm = "";

  /** 倉庫集約名 */
  @Builder.Default
  private String skosyynm = "";

  /** ソートＳＥＱ */
  @Builder.Default
  private int srtseq = 0;

  /** 画面リスト区分 */
  @Builder.Default
  private String gmnlstkbn = "";

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
