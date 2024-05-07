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
 * 納品伝票別伝グループ明細Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedNohinDenpyoBetsudenGroupMeisaiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 形態コードＦＲＯＭ */
  @Keyfield(index = 1)
  @Builder.Default
  private String ketcodfrm = "";

  /** 形態コードＴＯ */
  @Builder.Default
  private String ketcodto = "";

  /** 納品伝票別伝グループコード */
  @Builder.Default
  private int nohdenbdngrpcod = 0;

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
