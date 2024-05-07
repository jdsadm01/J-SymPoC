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
 * 締日別返品枠計算基準月Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShimebibetsuHenpinwakuKeisanKijunzukiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 返品枠計算基準月区分（５日締店） */
  @Builder.Default
  private String hpwksnkjnmmkbn5jt = "";

  /** 返品枠計算基準月区分（１０日締店） */
  @Builder.Default
  private String hpwksnkjnmmkbn10jt = "";

  /** 返品枠計算基準月区分（１４日締店） */
  @Builder.Default
  private String hpwksnkjnmmkbn14jt = "";

  /** 返品枠計算基準月区分（１５日締店） */
  @Builder.Default
  private String hpwksnkjnmmkbn15jt = "";

  /** 返品枠計算基準月区分（２０日締店） */
  @Builder.Default
  private String hpwksnkjnmmkbn20jt = "";

  /** 返品枠計算基準月区分（２５日締店） */
  @Builder.Default
  private String hpwksnkjnmmkbn25jt = "";

  /** 返品枠計算基準月区分（３１日締店） */
  @Builder.Default
  private String hpwksnkjnmmkbn31jt = "";

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
