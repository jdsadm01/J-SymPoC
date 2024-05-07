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
 * 注残出荷指示見出Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedChuzanShukkaShijiMidashiEntity implements EntityInterface {

  // 永続属性 ↓
  /** 入力日付 */
  @Keyfield(index = 1)
  @Builder.Default
  private int inpdte = 0;

  /** ＳＥＱ */
  @Keyfield(index = 2)
  @Builder.Default
  private int seq = 0;

  /** 注残出荷指示区分 */
  @Builder.Default
  private String chzsyasjikbn = "";

  /** 引当場所コード */
  @Builder.Default
  private String hatbshcod = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 倉庫コード */
  @Builder.Default
  private String skocod = "";

  /** 配送方面指定区分 */
  @Builder.Default
  private String hsohmnstekbn = "";

  /** 品番指定有フラグ */
  @Builder.Default
  private String hnbsteariflg = "0";

  /** 処理完了フラグ */
  @Builder.Default
  private String prckruflg = "0";

  /** 送信元ＣＰＵＩＤ */
  @Builder.Default
  private String ssmcpuid = "";

  /** 送信元端末ＩＤ */
  @Builder.Default
  private String ssmtmlid = "";

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
