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
 * 会社分類Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedKaishaBunruiEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザー分類 */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrbun = "";

  /** 会社分類 */
  @Keyfield(index = 2)
  @Builder.Default
  private String kaibun = "";

  /** 会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String kaiskbcod = "";

  /** 表示順 */
  @Builder.Default
  private int hjijun = 0;

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 月令上限値 */
  @Builder.Default
  private int gre = 0;

  /** 出荷率 */
  @Builder.Default
  private int srt = 0;

  /** 項目数値条件 */
  @Builder.Default
  private int itmtrm = 0;

  /** データ交換フラグ */
  @Builder.Default
  private String dtaexcflg = "0";

  /** 市販特版区分 */
  @Builder.Default
  private String shnthnkbn = "";

  /** 決算月 */
  @Builder.Default
  private int ksnmnt = 0;

  /** 訂正含有フラグ */
  @Builder.Default
  private String teignyflg = "0";

}
