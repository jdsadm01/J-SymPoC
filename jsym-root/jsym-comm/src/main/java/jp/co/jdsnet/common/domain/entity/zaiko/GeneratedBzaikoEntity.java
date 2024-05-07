package jp.co.jdsnet.common.domain.entity.zaiko;

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
 * Ｂ在庫Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedBzaikoEntity implements EntityInterface {

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

  /** 当月在庫数量（良品） */
  @Builder.Default
  private int tomzaisurryo = 0;

  /** 当月在庫数量（不良品） */
  @Builder.Default
  private int tomzaisurfry = 0;

  /** 前月迄在庫数量（良品） */
  @Builder.Default
  private int zmmzaisurryo = 0;

  /** 前月迄在庫数量（不良品） */
  @Builder.Default
  private int zmmzaisurfry = 0;

  /** 当月在庫訂正数量（良品＋） */
  @Builder.Default
  private int tomzaiteisurryopls = 0;

  /** 当月在庫訂正数量（良品－） */
  @Builder.Default
  private int tomzaiteisurryomns = 0;

  /** 当月在庫訂正数量（不良品＋） */
  @Builder.Default
  private int tomzaiteisurfrypls = 0;

  /** 当月在庫訂正数量（不良品－） */
  @Builder.Default
  private int tomzaiteisurfrymns = 0;

  /** 前月迄在庫訂正数量（良品＋） */
  @Builder.Default
  private int zmmzaiteisurryopls = 0;

  /** 前月迄在庫訂正数量（良品－） */
  @Builder.Default
  private int zmmzaiteisurryomns = 0;

  /** 前月迄在庫訂正数量（不良品＋） */
  @Builder.Default
  private int zmmzaiteisurfrypls = 0;

  /** 前月迄在庫訂正数量（不良品－） */
  @Builder.Default
  private int zmmzaiteisurfrymns = 0;

  /** 積送残数量 */
  @Builder.Default
  private int sekzansur = 0;

  /** 当月棚上数量（指示後） */
  @Builder.Default
  private int tomtnasursjg = 0;

  /** 当日生産返品数量（良品） */
  @Builder.Default
  private int todprdhpnsurryo = 0;

  /** 当日生産返品数量（不良品） */
  @Builder.Default
  private int todprdhpnsurfry = 0;

  /** 当日仕入返品数量（良品） */
  @Builder.Default
  private int todsirhpnsurryo = 0;

  /** 当日仕入返品数量（不良品） */
  @Builder.Default
  private int todsirhpnsurfry = 0;

  /** 当日自動仕入返品数量（良品） */
  @Builder.Default
  private int todasrhpnsurryo = 0;

  /** 当日自動仕入返品数量（不良品） */
  @Builder.Default
  private int todasrhpnsurfry = 0;

  /** 当日転送入庫数量（良品） */
  @Builder.Default
  private int todtsonyosurryo = 0;

  /** 当日転送入庫数量（不良品） */
  @Builder.Default
  private int todtsonyosurfry = 0;

  /** 当日転送出庫数量（良品） */
  @Builder.Default
  private int todtsosyosurryo = 0;

  /** 当日転送出庫数量（不良品） */
  @Builder.Default
  private int todtsosyosurfry = 0;

  /** 当日振替入庫数量（良品） */
  @Builder.Default
  private int todfkenyosurryo = 0;

  /** 当日振替入庫数量（不良品） */
  @Builder.Default
  private int todfkenyosurfry = 0;

  /** 当日振替出庫数量（良品） */
  @Builder.Default
  private int todfkesyosurryo = 0;

  /** 当日振替出庫数量（不良品） */
  @Builder.Default
  private int todfkesyosurfry = 0;

  /** 当日部門振替入庫数量（良品） */
  @Builder.Default
  private int todbmnfkenyosurryo = 0;

  /** 当日部門振替入庫数量（不良品） */
  @Builder.Default
  private int todbmnfkenyosurfry = 0;

  /** 当日部門振替出庫数量（良品） */
  @Builder.Default
  private int todbmnfkesyosurryo = 0;

  /** 当日部門振替出庫数量（不良品） */
  @Builder.Default
  private int todbmnfkesyosurfry = 0;

  /** 当日償却振替入庫数量（良品） */
  @Builder.Default
  private int todskyfkenyosurryo = 0;

  /** 当日償却振替入庫数量（不良品） */
  @Builder.Default
  private int todskyfkenyosurfry = 0;

  /** 当日償却振替出庫数量（良品） */
  @Builder.Default
  private int todskyfkesyosurryo = 0;

  /** 当日償却振替出庫数量（不良品） */
  @Builder.Default
  private int todskyfkesyosurfry = 0;

  /** 当日償却数量（良品） */
  @Builder.Default
  private int todskysurryo = 0;

  /** 当日償却数量（不良品） */
  @Builder.Default
  private int todskysurfry = 0;

  /** 当日廃棄数量（良品） */
  @Builder.Default
  private int todhiksurryo = 0;

  /** 当日廃棄数量（不良品） */
  @Builder.Default
  private int todhiksurfry = 0;

  /** 当日棚上数量 */
  @Builder.Default
  private int todtnasur = 0;

  /** 当日棚下数量（良品） */
  @Builder.Default
  private int todtnssurryo = 0;

  /** 当日棚下数量（不良品） */
  @Builder.Default
  private int todtnssurfry = 0;

  /** 当日会社間返品数量（良品） */
  @Builder.Default
  private int todkikhpnsurryo = 0;

  /** 当日会社間返品数量（不良品） */
  @Builder.Default
  private int todkikhpnsurfry = 0;

  /** 当日商品返品数量（良品） */
  @Builder.Default
  private int todshohpnsurryo = 0;

  /** 当日商品返品数量（不良品） */
  @Builder.Default
  private int todshohpnsurfry = 0;

  /** 当日通常返品数量（良品） */
  @Builder.Default
  private int todtjyhpnsurryo = 0;

  /** 当日通常返品数量（不良品） */
  @Builder.Default
  private int todtjyhpnsurfry = 0;

  /** 当日通常外返品数量（良品） */
  @Builder.Default
  private int todtjghpnsurryo = 0;

  /** 当日通常外返品数量（不良品） */
  @Builder.Default
  private int todtjghpnsurfry = 0;

  /** 当日特販／カスタム／特注返品数量（良品） */
  @Builder.Default
  private int todtcthpnsurryo = 0;

  /** 当日特販／カスタム／特注返品数量（不良品） */
  @Builder.Default
  private int todtcthpnsurfry = 0;

  /** 当日輸出返品数量（良品） */
  @Builder.Default
  private int todexphpnsurryo = 0;

  /** 当日輸出返品数量（不良品） */
  @Builder.Default
  private int todexphpnsurfry = 0;

  /** 夜間伝票発行当日振替出庫数量（良品） */
  @Builder.Default
  private int ydhtodfkesyosurryo = 0;

  /** 夜間伝票発行当日振替出庫数量（不良品） */
  @Builder.Default
  private int ydhtodfkesyosurfry = 0;

  /** 夜間伝票発行当日会社間返品数量（良品） */
  @Builder.Default
  private int ydhtodkikhpnsurryo = 0;

  /** 夜間伝票発行当日会社間返品数量（不良品） */
  @Builder.Default
  private int ydhtodkikhpnsurfry = 0;

  /** 当月生産返品数量（良品） */
  @Builder.Default
  private int tomprdhpnsurryo = 0;

  /** 当月生産返品数量（不良品） */
  @Builder.Default
  private int tomprdhpnsurfry = 0;

  /** 当月仕入返品数量（良品） */
  @Builder.Default
  private int tomsirhpnsurryo = 0;

  /** 当月仕入返品数量（不良品） */
  @Builder.Default
  private int tomsirhpnsurfry = 0;

  /** 当月自動仕入返品数量（良品） */
  @Builder.Default
  private int tomasrhpnsurryo = 0;

  /** 当月自動仕入返品数量（不良品） */
  @Builder.Default
  private int tomasrhpnsurfry = 0;

  /** 当月転送入庫数量（良品） */
  @Builder.Default
  private int tomtsonyosurryo = 0;

  /** 当月転送入庫数量（不良品） */
  @Builder.Default
  private int tomtsonyosurfry = 0;

  /** 当月転送出庫数量（良品） */
  @Builder.Default
  private int tomtsosyosurryo = 0;

  /** 当月転送出庫数量（不良品） */
  @Builder.Default
  private int tomtsosyosurfry = 0;

  /** 当月振替入庫数量（良品） */
  @Builder.Default
  private int tomfkenyosurryo = 0;

  /** 当月振替入庫数量（不良品） */
  @Builder.Default
  private int tomfkenyosurfry = 0;

  /** 当月振替出庫数量（良品） */
  @Builder.Default
  private int tomfkesyosurryo = 0;

  /** 当月振替出庫数量（不良品） */
  @Builder.Default
  private int tomfkesyosurfry = 0;

  /** 当月部門振替入庫数量（良品） */
  @Builder.Default
  private int tombmnfkenyosurryo = 0;

  /** 当月部門振替入庫数量（不良品） */
  @Builder.Default
  private int tombmnfkenyosurfry = 0;

  /** 当月部門振替出庫数量（良品） */
  @Builder.Default
  private int tombmnfkesyosurryo = 0;

  /** 当月部門振替出庫数量（不良品） */
  @Builder.Default
  private int tombmnfkesyosurfry = 0;

  /** 当月償却振替入庫数量（良品） */
  @Builder.Default
  private int tomskyfkenyosurryo = 0;

  /** 当月償却振替入庫数量（不良品） */
  @Builder.Default
  private int tomskyfkenyosurfry = 0;

  /** 当月償却振替出庫数量（良品） */
  @Builder.Default
  private int tomskyfkesyosurryo = 0;

  /** 当月償却振替出庫数量（不良品） */
  @Builder.Default
  private int tomskyfkesyosurfry = 0;

  /** 当月償却数量（良品） */
  @Builder.Default
  private int tomskysurryo = 0;

  /** 当月償却数量（不良品） */
  @Builder.Default
  private int tomskysurfry = 0;

  /** 当月廃棄数量（良品） */
  @Builder.Default
  private int tomhiksurryo = 0;

  /** 当月廃棄数量（不良品） */
  @Builder.Default
  private int tomhiksurfry = 0;

  /** 当月棚上数量 */
  @Builder.Default
  private int tomtnasur = 0;

  /** 当月棚下数量（良品） */
  @Builder.Default
  private int tomtnssurryo = 0;

  /** 当月棚下数量（不良品） */
  @Builder.Default
  private int tomtnssurfry = 0;

  /** 当月会社間返品数量（良品） */
  @Builder.Default
  private int tomkikhpnsurryo = 0;

  /** 当月会社間返品数量（不良品） */
  @Builder.Default
  private int tomkikhpnsurfry = 0;

  /** 当月商品返品数量（良品） */
  @Builder.Default
  private int tomshohpnsurryo = 0;

  /** 当月商品返品数量（不良品） */
  @Builder.Default
  private int tomshohpnsurfry = 0;

  /** 当月通常返品数量（良品） */
  @Builder.Default
  private int tomtjyhpnsurryo = 0;

  /** 当月通常返品数量（不良品） */
  @Builder.Default
  private int tomtjyhpnsurfry = 0;

  /** 当月通常外返品数量（良品） */
  @Builder.Default
  private int tomtjghpnsurryo = 0;

  /** 当月通常外返品数量（不良品） */
  @Builder.Default
  private int tomtjghpnsurfry = 0;

  /** 当月特販／カスタム／特注返品数量（良品） */
  @Builder.Default
  private int tomtcthpnsurryo = 0;

  /** 当月特販／カスタム／特注返品数量（不良品） */
  @Builder.Default
  private int tomtcthpnsurfry = 0;

  /** 当月輸出返品数量（良品） */
  @Builder.Default
  private int tomexphpnsurryo = 0;

  /** 当月輸出返品数量（不良品） */
  @Builder.Default
  private int tomexphpnsurfry = 0;

  /** 前月商品返品数量（良品） */
  @Builder.Default
  private int znmshohpnsurryo = 0;

  /** 前月商品返品数量（不良品） */
  @Builder.Default
  private int znmshohpnsurfry = 0;

  /** 前月通常返品数量（良品） */
  @Builder.Default
  private int znmtjyhpnsurryo = 0;

  /** 前月通常返品数量（不良品） */
  @Builder.Default
  private int znmtjyhpnsurfry = 0;

  /** 前月通常外返品数量（良品） */
  @Builder.Default
  private int znmtjghpnsurryo = 0;

  /** 前月通常外返品数量（不良品） */
  @Builder.Default
  private int znmtjghpnsurfry = 0;

  /** 前月特販／カスタム／特注返品数量（良品） */
  @Builder.Default
  private int znmtcthpnsurryo = 0;

  /** 前月特販／カスタム／特注返品数量（不良品） */
  @Builder.Default
  private int znmtcthpnsurfry = 0;

  /** 前月輸出返品数量（良品） */
  @Builder.Default
  private int znmexphpnsurryo = 0;

  /** 前月輸出返品数量（不良品） */
  @Builder.Default
  private int znmexphpnsurfry = 0;

  /** 償却数量累計（良品） */
  @Builder.Default
  private int skysurruiryo = 0;

  /** 償却数量累計（不良品） */
  @Builder.Default
  private int skysurruifry = 0;

  /** 廃棄数量累計（良品） */
  @Builder.Default
  private int hiksurruiryo = 0;

  /** 廃棄数量累計（不良品） */
  @Builder.Default
  private int hiksurruifry = 0;

  /** 旧ＡＶＩＳフラグ */
  @Builder.Default
  private String oldavisflg = "0";

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
