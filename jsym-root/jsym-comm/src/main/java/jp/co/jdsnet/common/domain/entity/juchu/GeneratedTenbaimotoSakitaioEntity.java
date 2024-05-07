package jp.co.jdsnet.common.domain.entity.juchu;

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
 * 転売元／先対応Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTenbaimotoSakitaioEntity implements EntityInterface {

  // 永続属性 ↓
  /** 受注日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int jucdte = 0;

  /** 転売元得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tbmtokcod = "";

  /** 転売元ＤＳコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String tbmdscod = "";

  /** 転売元ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int tbmseq = 0;

  /** 転売先得意先コード */
  @Builder.Default
  private String tbstokcod = "";

  /** 転売先ＤＳコード */
  @Builder.Default
  private String tbsdscod = "";

  /** 転売先ＳＥＱ */
  @Builder.Default
  private int tbsseq = 0;

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
