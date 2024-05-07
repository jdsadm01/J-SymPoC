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
 * 会社Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedJsymKaishaEntity implements EntityInterface {

  // 永続属性 ↓
  /** 会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String kaiskbcod = "";

  /** 会社コード */
  @Builder.Default
  private String kaicod = "";

  /** 会社名（カナ） */
  @Builder.Default
  private String kainmkn = "";

  /** 会社名（漢字） */
  @Builder.Default
  private String kainmkj = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社関係ＦＬＧ */
  @Builder.Default
  private String kairltflg = "0";

  /** 契約サイン位置 */
  @Builder.Default
  private String kyksgnich = "";

  /** 帳残更新の有無 */
  @Builder.Default
  private String cyzupdumu = "";

  /** 注残指定サイン自動解除区分 */
  @Builder.Default
  private String cyzstsgnakjykbn = "";

  /** ＪＡＲＥＤ出力区分 */
  @Builder.Default
  private String jardoutkbn = "";

  /** ゲーム共同フラグ */
  @Builder.Default
  private String gamflg = "0";

  /** 営業所受注在確ＦＡＸ送信フラグ */
  @Builder.Default
  private String eigjuczkkfaxssnflg = "0";

  /** 共同受注在確ＦＡＸ送信フラグ */
  @Builder.Default
  private String juczkkfaxssnflg = "0";

  /** 最新更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
