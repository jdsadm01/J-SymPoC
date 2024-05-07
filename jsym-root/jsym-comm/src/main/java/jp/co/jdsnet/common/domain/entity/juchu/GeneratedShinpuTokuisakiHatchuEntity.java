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
 * 新譜得意先発注Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedShinpuTokuisakiHatchuEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 得意先コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 3)
  @Builder.Default
  private String dscod = "";

  /** 記号番号 */
  @Keyfield(index = 4)
  @Builder.Default
  private String kigbng = "";

  /** ＳＥＱ */
  @Keyfield(index = 5)
  @Builder.Default
  private int seq = 0;

  /** 受注数量 */
  @Builder.Default
  private int jucsur = 0;

  /** 得意先発注番号 */
  @Builder.Default
  private String thcbng = "";

  /** 得意先発注メモ */
  @Builder.Default
  private String thcmemo = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

  /** 受注締日 */
  @Builder.Default
  private int jucsmb = 0;

  /** 記号桁数（３桁） */
  @Builder.Default
  private int kigkta3kt = 0;

  /** 受信品番 */
  @Builder.Default
  private String jsnhnb = "";

  /** 受信日付 */
  @Builder.Default
  private int jsndte = 0;

  /** 受信時刻 */
  @Builder.Default
  private int jsnjkk = 0;

  /** 送信日付 */
  @Builder.Default
  private int ssndte = 0;

  /** 送信時刻 */
  @Builder.Default
  private int ssnjkk = 0;

  /** 新譜得意先発注受付番号 */
  @Builder.Default
  private String sinthcutkbng = "";

  /** 新譜得意先発注エラー区分 */
  @Builder.Default
  private String sinthcerrkbn = "";

  /** 新譜得意先発注ステータス区分 */
  @Builder.Default
  private String sinthcstskbn = "";

  /** 新譜得意先発注データ区分 */
  @Builder.Default
  private String sinthcdtakbn = "";

  /** 入力順 */
  @Builder.Default
  private int inpjn = 0;

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** ＡＥＳ受信日付 */
  @Builder.Default
  private int aesjsndte = 0;

  /** ＡＥＳ受信時刻 */
  @Builder.Default
  private int aesjsnjkk = 0;

}
