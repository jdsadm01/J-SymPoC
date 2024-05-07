package jp.co.jdsnet.common.domain.entity.tokuisaki;

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
 * ＤＳEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDsEntity implements EntityInterface {

  // 永続属性 ↓
  /** 得意先コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 2)
  @Builder.Default
  private String dscod = "";

  /** ＤＳ名カナ１ */
  @Builder.Default
  private String dsnmkn1 = "";

  /** ＤＳ名カナ２ */
  @Builder.Default
  private String dsnmkn2 = "";

  /** ＤＳ名カナ（拡張） */
  @Builder.Default
  private String dsnmknkkc = "";

  /** ＤＳ名１ */
  @Builder.Default
  private String dsnm1 = "";

  /** ＤＳ名２ */
  @Builder.Default
  private String dsnm2 = "";

  /** ＤＳ名（拡張） */
  @Builder.Default
  private String dsnmkkc = "";

  /** ＤＳ住所カナ１ */
  @Builder.Default
  private String dsadrkn1 = "";

  /** ＤＳ住所カナ２ */
  @Builder.Default
  private String dsadrkn2 = "";

  /** ＤＳ住所カナ（拡張） */
  @Builder.Default
  private String dsadrknkkc = "";

  /** ＤＳ住所１ */
  @Builder.Default
  private String dsadr1 = "";

  /** ＤＳ住所２ */
  @Builder.Default
  private String dsadr2 = "";

  /** ＤＳ住所（拡張） */
  @Builder.Default
  private String dsadrkkc = "";

  /** ＤＳ電話番号 */
  @Builder.Default
  private String dstelbng = "";

  /** ＤＳ郵便番号 */
  @Builder.Default
  private String dsybnbng = "";

  /** 新譜旧譜使用区分 */
  @Builder.Default
  private String sinkyuusekbn = "";

  /** ＤＳ郵便番号（７桁） */
  @Builder.Default
  private String dsybnbng7kt = "";

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
