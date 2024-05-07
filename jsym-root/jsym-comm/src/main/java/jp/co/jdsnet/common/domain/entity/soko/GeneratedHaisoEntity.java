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
 * 配送Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHaisoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 場所コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String bshcod = "";

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String dscod = "";

  /** 配送ルートコード */
  @Builder.Default
  private String hsorotcod = "";

  /** 配送ルート枝番 */
  @Builder.Default
  private String hsoroteda = "";

  /** 配送ソートコード */
  @Builder.Default
  private String hsosrtcod = "";

  /** 配送方面コード */
  @Builder.Default
  private String hsohmncod = "";

  /** 配送ブロックコード */
  @Builder.Default
  private String hsoblkcod = "";

  /** 配送日報作成コード */
  @Builder.Default
  private String hsonpossecod = "";

  /** 商品送り状作成コード */
  @Builder.Default
  private String shookrssecod = "";

  /** 出力先コード */
  @Builder.Default
  private String outsakcod = "";

  /** 商品仕分コード */
  @Builder.Default
  private String shoswkcod = "";

  /** 配送区分け */
  @Builder.Default
  private String hsokwk = "";

  /** 開店時刻 */
  @Builder.Default
  private String ktnjkk = "";

  /** 指定伝回収 */
  @Builder.Default
  private String stdksy = "";

  /** 店形態 */
  @Builder.Default
  private String misket = "";

  /** 納品場所 */
  @Builder.Default
  private String nohbsh = "";

  /** 検品形態 */
  @Builder.Default
  private String kpnket = "";

  /** 店休日 */
  @Builder.Default
  private String mky = "";

  /** 伝票マージ不可サイン */
  @Builder.Default
  private String denmrgfkasgn = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 新譜配送日数 */
  @Builder.Default
  private int sinhsonsu = 0;

  /** 新譜確注出荷日数 */
  @Builder.Default
  private int sinkcysyansu = 0;

  /** 新譜追加出荷日数 */
  @Builder.Default
  private int sintuisyansu = 0;

  /** 旧譜配送日数 */
  @Builder.Default
  private int kyuhsonsu = 0;

}
