package jp.co.jdsnet.common.domain.entity.hinban;

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
 * 新譜番号Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuBangoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 新譜番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private String sinbng = "";

  /** 新譜行番号 */
  @Keyfield(index = 3)
  @Builder.Default
  private int singyb = 0;

  /** 記号番号 */
  @Builder.Default
  private String kigbng = "";

  /** 受注締日 */
  @Builder.Default
  private int jucsmb = 0;

  /** 別伝フラグ */
  @Builder.Default
  private String bdnflg = "0";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** リラティブＮＯ */
  @Builder.Default
  private String relno = "";

  /** 割表ペ－ジ */
  @Builder.Default
  private int whypge = 0;

  /** 翌勘コード */
  @Builder.Default
  private String ykncod = "";

  /** 再発番区分 */
  @Builder.Default
  private String shtkbn = "";

  /** アーティスト名カナ */
  @Builder.Default
  private String artnmkn = "";

  /** アーティスト名 */
  @Builder.Default
  private String artnm = "";

  /** タイトル名カナ */
  @Builder.Default
  private String titnmkn = "";

  /** タイトル名 */
  @Builder.Default
  private String titnm = "";

  /** メーカー分類コード */
  @Builder.Default
  private String mkrbuncod = "";

  /** 形態コード */
  @Builder.Default
  private String ketcod = "";

  /** 在庫更新サイン */
  @Builder.Default
  private String zaiupdsgn = "";

  /** 売上更新サイン */
  @Builder.Default
  private String uriupdsgn = "";

  /** 税抜価格 */
  @Builder.Default
  private double znupri = 0D;

  /** 特典商品数 */
  @Builder.Default
  private String ttnshosuu = "";

  /** 特典物数 */
  @Builder.Default
  private String ttbsuu = "";

  /** 特典物品番 */
  @Builder.Default
  private String ttbhnb = "";

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
