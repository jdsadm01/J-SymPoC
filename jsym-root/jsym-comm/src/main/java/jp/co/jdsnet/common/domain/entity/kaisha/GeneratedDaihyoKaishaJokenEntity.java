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
 * 代表会社条件Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedDaihyoKaishaJokenEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 帳残更新区分 */
  @Builder.Default
  private String cyzupdkbn = "";

  /** 注残指定解除区分 */
  @Builder.Default
  private String chzstekjykbn = "";

  /** ゲームメーカーフラグ */
  @Builder.Default
  private String gammkrflg = "0";

  /** ゲームメーカー共同受注区分 */
  @Builder.Default
  private String gammkrkyojuckbn = "";

  /** 営業所受注在確ＦＡＸ送信有フラグ */
  @Builder.Default
  private String eijzfxssnariflg = "0";

  /** 共同受注在確ＦＡＸ送信有フラグ */
  @Builder.Default
  private String kyjzfxssnariflg = "0";

  /** 仕切単価グループコード数 */
  @Builder.Default
  private int skrtangrpcodsuu = 0;

  /** 仕切掛率グループコード数 */
  @Builder.Default
  private int skrkrtgrpcodsuu = 0;

  /** レコード協会会社コード */
  @Builder.Default
  private String rkkkaicod = "";

  /** 新譜伝票日付基準区分 */
  @Builder.Default
  private String sindendtekjnkbn = "";

  /** 新譜配送メンテ表示フラグ */
  @Builder.Default
  private String sinhsomtnhjiflg = "0";

  /** 新譜配送メンテ表示順 */
  @Builder.Default
  private int sinhsomtnhjijn = 0;

  /** 新譜出荷日設定可能フラグ */
  @Builder.Default
  private String sinshdstikanflg = "0";

  /** 翌営出荷判定方式区分 */
  @Builder.Default
  private String ykesyahtihukkbn = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** レコード取扱メーカーフラグ */
  @Builder.Default
  private String rectakmkrflg = "0";

  /** 新譜追加強制売上可能フラグ */
  @Builder.Default
  private String sintuikysurikanflg = "0";

  /** 個社配送日メンテ表示フラグ */
  @Builder.Default
  private String kshhsdmtnhjiflg = "0";

  /** 個社配送日メンテ表示順 */
  @Builder.Default
  private int kshhsdmtnhjijn = 0;

  /** 新譜確注出荷日数使用フラグ */
  @Builder.Default
  private String sinkcysyansuuseflg = "0";

  /** 品番得意先削除区分（直近） */
  @Builder.Default
  private String hnbtokdelkbnckn = "";

  /** 品番得意先保存日数（直近） */
  @Builder.Default
  private int hnbtokhzonsuckn = 0;

  /** 品番得意先売上計上区分（発売） */
  @Builder.Default
  private String hnbtokurikjukbnhbi = "";

  /** ランキング対象区分 */
  @Builder.Default
  private String rknobjkbn = "";

  /** 画面伝票計算区分 */
  @Builder.Default
  private String gmndenksnkbn = "";

  /** 強制売上連動引当区分 */
  @Builder.Default
  private String kysurirdohatkbn = "";

  /** ジャケット写真表示フラグ */
  @Builder.Default
  private String jkshjiflg = "0";

}
