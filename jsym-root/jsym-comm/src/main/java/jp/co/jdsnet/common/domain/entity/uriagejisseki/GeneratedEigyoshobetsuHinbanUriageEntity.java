package jp.co.jdsnet.common.domain.entity.uriagejisseki;

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
 * 営業所別品番売上Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedEigyoshobetsuHinbanUriageEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 営業所コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String eigcod = "";

  /** 記号番号 */
  @Keyfield(index = 3)
  @Builder.Default
  private String kigbng = "";

  /** 新譜受注数量 */
  @Builder.Default
  private int sinjucsur = 0;

  /** 新譜出荷数量 */
  @Builder.Default
  private int sinsyasur = 0;

  /** 新譜出荷店数 */
  @Builder.Default
  private int sinsyatensuu = 0;

  /** 注残数量累計 */
  @Builder.Default
  private int chzsurrui = 0;

  /** 注残店数累計 */
  @Builder.Default
  private int chztensuurui = 0;

  /** 当日受注数量 */
  @Builder.Default
  private int todjucsur = 0;

  /** 当日受注店数 */
  @Builder.Default
  private int todjuctensuu = 0;

  /** 当日出荷数量 */
  @Builder.Default
  private int todsyasur = 0;

  /** 当日出荷店数 */
  @Builder.Default
  private int todsyatensuu = 0;

  /** 当日未出荷数量 */
  @Builder.Default
  private int todmsysur = 0;

  /** 当日未出荷店数 */
  @Builder.Default
  private int todmsytensuu = 0;

  /** 当日注残出荷数量 */
  @Builder.Default
  private int todchzsyasur = 0;

  /** 当日注残未出荷数量 */
  @Builder.Default
  private int todchzmsysur = 0;

  /** 当日注残出荷店数 */
  @Builder.Default
  private int todchzsyatensuu = 0;

  /** 当日注残未出荷店数 */
  @Builder.Default
  private int todchzmsytensuu = 0;

  /** 当日返品店数 */
  @Builder.Default
  private int todhpntensuu = 0;

  /** 当日通常売上数量 */
  @Builder.Default
  private int todtjyurisur = 0;

  /** 当日商品売上数量 */
  @Builder.Default
  private int todshourisur = 0;

  /** 当日通常外売上数量 */
  @Builder.Default
  private int todtjgurisur = 0;

  /** 当日貸出出荷数量 */
  @Builder.Default
  private int todkdasyasur = 0;

  /** 当日貸出売上数量 */
  @Builder.Default
  private int todkdaurisur = 0;

  /** 当日特注売上数量 */
  @Builder.Default
  private int todtcyurisur = 0;

  /** 当日輸出売上数量 */
  @Builder.Default
  private int todexpurisur = 0;

  /** 当日特販売上数量 */
  @Builder.Default
  private int todthnurisur = 0;

  /** 当日経費出庫数量 */
  @Builder.Default
  private int todkehsyosur = 0;

  /** 当日通常売上数量（貸レ店） */
  @Builder.Default
  private int todtjyurisurkre = 0;

  /** 当日商品売上数量（貸レ店） */
  @Builder.Default
  private int todshourisurkre = 0;

  /** 当日通常外売上数量（貸レ店） */
  @Builder.Default
  private int todtjgurisurkre = 0;

  /** 当日会社間売上 */
  @Builder.Default
  private long todkaiuri = 0L;

  /** 当日通常返品数量 */
  @Builder.Default
  private int todtjyhpnsur = 0;

  /** 当日商品返品数量 */
  @Builder.Default
  private int todshohpnsur = 0;

  /** 当日通常外返品数量 */
  @Builder.Default
  private int todtjghpnsur = 0;

  /** 当日特注返品数量 */
  @Builder.Default
  private int todtcyhpnsur = 0;

  /** 当日輸出返品数量 */
  @Builder.Default
  private int todexphpnsur = 0;

  /** 当日特販返品数量 */
  @Builder.Default
  private int todthnhpnsur = 0;

  /** 当日通常返品数量（貸レ店） */
  @Builder.Default
  private int todtjyhpnsurkre = 0;

  /** 当日商品返品数量（貸レ店） */
  @Builder.Default
  private int todshohpnsurkre = 0;

  /** 当日通常外返品数量（貸レ店） */
  @Builder.Default
  private int todtjghpnsurkre = 0;

  /** 当日会社間返品 */
  @Builder.Default
  private long todkaihpn = 0L;

  /** 当月通常売上数量 */
  @Builder.Default
  private int tomtjyurisur = 0;

  /** 当月商品売上数量 */
  @Builder.Default
  private int tomshourisur = 0;

  /** 当月通常外売上数量 */
  @Builder.Default
  private int tomtjgurisur = 0;

  /** 当月貸出出荷数量 */
  @Builder.Default
  private int tomkdasyasur = 0;

  /** 当月貸出売上数量 */
  @Builder.Default
  private int tomkdaurisur = 0;

  /** 当月特注売上数量 */
  @Builder.Default
  private int tomtcyurisur = 0;

  /** 当月輸出売上数量 */
  @Builder.Default
  private int tomexpurisur = 0;

  /** 当月特販売上数量 */
  @Builder.Default
  private int tomthnurisur = 0;

  /** 当月経費出庫数量 */
  @Builder.Default
  private int tomkehsyosur = 0;

  /** 当月通常売上数量（貸レ店） */
  @Builder.Default
  private int tomtjyurisurkre = 0;

  /** 当月商品売上数量（貸レ店） */
  @Builder.Default
  private int tomshourisurkre = 0;

  /** 当月通常外売上数量（貸レ店） */
  @Builder.Default
  private int tomtjgurisurkre = 0;

  /** 当月会社間売上 */
  @Builder.Default
  private long tomkaiuri = 0L;

  /** 当月通常返品数量 */
  @Builder.Default
  private int tomtjyhpnsur = 0;

  /** 当月商品返品数量 */
  @Builder.Default
  private int tomshohpnsur = 0;

  /** 当月通常外返品数量 */
  @Builder.Default
  private int tomtjghpnsur = 0;

  /** 当月特注返品数量 */
  @Builder.Default
  private int tomtcyhpnsur = 0;

  /** 当月輸出返品数量 */
  @Builder.Default
  private int tomexphpnsur = 0;

  /** 当月特販返品数量 */
  @Builder.Default
  private int tomthnhpnsur = 0;

  /** 当月通常返品数量（貸レ店） */
  @Builder.Default
  private int tomtjyhpnsurkre = 0;

  /** 当月商品返品数量（貸レ店） */
  @Builder.Default
  private int tomshohpnsurkre = 0;

  /** 当月通常外返品数量（貸レ店） */
  @Builder.Default
  private int tomtjghpnsurkre = 0;

  /** 当月会社間返品 */
  @Builder.Default
  private long tomkaihpn = 0L;

  /** 売上数量累計 */
  @Builder.Default
  private int urisurrui = 0;

  /** 売上数量累計（貸レ店） */
  @Builder.Default
  private int urisurruikre = 0;

  /** 返品数量累計 */
  @Builder.Default
  private int hpnsurrui = 0;

  /** 返品数量累計（貸レ店） */
  @Builder.Default
  private int hpnsurruikre = 0;

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
