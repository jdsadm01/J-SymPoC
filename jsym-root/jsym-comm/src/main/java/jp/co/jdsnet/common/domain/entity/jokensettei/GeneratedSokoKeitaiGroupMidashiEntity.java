package jp.co.jdsnet.common.domain.entity.jokensettei;

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
 * 倉庫形態グループ見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSokoKeitaiGroupMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 倉庫形態グループコード */
  @Keyfield(index = 1)
  @Builder.Default
  private int skoketgrpcod = 0;

  /** 倉庫形態グループ名カナ */
  @Builder.Default
  private String skoketgrpnmkn = "";

  /** 倉庫形態グループ名 */
  @Builder.Default
  private String skoketgrpnm = "";

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
