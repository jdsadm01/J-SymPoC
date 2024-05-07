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
 * 倉庫別登録名（品番グループ）Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSokobetsuTorokumeiHinbanGroupEntity implements EntityInterface {

  // 永続属性 ↓
  /** 倉庫コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String skocod = "";

  /** 会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String kaiskbcod = "";

  /** 登録名 */
  @Keyfield(index = 3)
  @Builder.Default
  private String trknm = "";

  /** ＳＥＱ */
  @Keyfield(index = 4)
  @Builder.Default
  private int seq = 0;

  /** 正式品番 */
  @Builder.Default
  private String seshnb = "";

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
