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
 * 新譜倉庫別品番属性Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuSokobetsuHinbanZokuseiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private String kigbng = "";

  /** 倉庫コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String skocod = "";

  /** 発売日（文字型） */
  @Builder.Default
  private String hbidtechrkat = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 棚番自動設定サイン */
  @Builder.Default
  private String tnbautstisgn = "";

  /** 納品伝票別伝グループコード */
  @Builder.Default
  private int nohdenbdngrpcod = 0;

  /** 新譜ストック棚番 */
  @Builder.Default
  private String sinstotnb = "";

  /** 新譜ピック棚番 */
  @Builder.Default
  private String sinpictnb = "";

  /** 整端別伝フラグ（数値型） */
  @Builder.Default
  private int shabdnflgnumkat = 0;

  /** 新譜受注店数（一般店） */
  @Builder.Default
  private int sinjuctensuuipn = 0;

  /** 新譜受注数量（一般店） */
  @Builder.Default
  private int sinjucsuripn = 0;

  /** 新譜受注店数（貸レ店） */
  @Builder.Default
  private int sinjuctensuukre = 0;

  /** 新譜受注数量（貸レ店） */
  @Builder.Default
  private int sinjucsurkre = 0;

  /** 振替入庫数量 */
  @Builder.Default
  private int fkenyosur = 0;

  /** 振替出庫数量 */
  @Builder.Default
  private int fkesyosur = 0;

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
