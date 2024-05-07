package jp.co.jdsnet.common.domain.entity.list;

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
 * 帳票作成制御テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedListControlEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String kaiskbcod = "";

  /** 帳票ＩＤ */
  @Keyfield(index = 3)
  @Builder.Default
  private String chyid = "";

  /** 表示フラグ */
  @Builder.Default
  private String hjiflg = "0";

  /** シーケンス№ */
  @Builder.Default
  private int seqno = 0;

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** 指示条件表示ﾌﾗｸﾞ */
  @Builder.Default
  private String sjijknhjiflg = "0";

}
