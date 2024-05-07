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
 * 代表会社返品条件Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDaihyoKaishaHenpinJokenEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 返品枠得意先締日サイン */
  @Builder.Default
  private String hpwtoksmbsgn = "";

  /** 返品枠計算開始月 */
  @Builder.Default
  private int hpwksnsttmm = 0;

  /** 返品Ａ枠端数処理区分（一般店） */
  @Builder.Default
  private String hpnawkhsuprckbnipn = "";

  /** 返品Ａ枠端数処理区分（リベート店） */
  @Builder.Default
  private String hpnawkhsuprckbnrbt = "";

  /** 返品枠計算基準月区分 */
  @Builder.Default
  private String hpwksnkjnmmkbn = "";

  /** 返品枠最低額 */
  @Builder.Default
  private int hpwmingak = 0;

  /** 返品枠基準額 */
  @Builder.Default
  private int hpwkjngak = 0;

  /** 返品枠算出翌勘サイン */
  @Builder.Default
  private String hpwsstyknsgn = "";

  /** 返品金額集計区分 */
  @Builder.Default
  private String hpnkinshkkbn = "";

  /** 廃盤受入価格区分 */
  @Builder.Default
  private String hibukeprikbn = "";

  /** 廃盤受入価格率 */
  @Builder.Default
  private int hibukeprirt = 0;

  /** 廃盤品返品枠外受入サイン */
  @Builder.Default
  private String hibhinhwgukesgn = "";

  /** 返品枠一覧表区分 */
  @Builder.Default
  private String hpwirnkbn = "";

  /** 返品枠一覧表表示区分 */
  @Builder.Default
  private String hpwirnhjikbn = "";

  /** 返品枠一覧表出力区分 */
  @Builder.Default
  private String hpwirnoutkbn = "";

  /** 返品明細票表示区分 */
  @Builder.Default
  private String hpnmshhjikbn = "";

  /** 返品明細票出力区分 */
  @Builder.Default
  private String hpnmshoutkbn = "";

  /** 編集返品締日１ */
  @Builder.Default
  private String edthpnsmb1 = "";

  /** 編集返品締日２ */
  @Builder.Default
  private String edthpnsmb2 = "";

  /** 編集返品締日３ */
  @Builder.Default
  private String edthpnsmb3 = "";

  /** 編集返品締日４ */
  @Builder.Default
  private String edthpnsmb4 = "";

  /** 編集返品締日５ */
  @Builder.Default
  private String edthpnsmb5 = "";

  /** 編集返品締日６ */
  @Builder.Default
  private String edthpnsmb6 = "";

  /** 編集返品締日７ */
  @Builder.Default
  private String edthpnsmb7 = "";

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
