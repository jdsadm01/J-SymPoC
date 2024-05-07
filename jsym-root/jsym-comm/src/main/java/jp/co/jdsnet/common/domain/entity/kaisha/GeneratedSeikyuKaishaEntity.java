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
 * 請求会社Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSeikyuKaishaEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 変換代表会社識別コード */
  @Keyfield(index = 2)
  @Builder.Default
  private String hkndaikaiskbcod = "";

  /** ボリュームディスカウント形態取得条件区分 */
  @Builder.Default
  private String vdcketstkjknkbn = "";

  /** デフォルトボリュームディスカウント区分 */
  @Builder.Default
  private String dftvdckbn = "";

  /** ボリュームディスカウント計算区分 */
  @Builder.Default
  private String vdcksnkbn = "";

  /** ＥＤＩ処理実績計算区分（アマゾン） */
  @Builder.Default
  private String ediprcjskksnkbnamz = "";

  /** ＥＤＩ処理実績計算区分（ヨドバシ） */
  @Builder.Default
  private String ediprcjskksnkbnydb = "";

  /** ユーザーメモ */
  @Builder.Default
  private String usrmemo = "";

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

  /** ＥＤＩ処理実績計算区分（ビックカメラ） */
  @Builder.Default
  private String ediprcjskksnkbnbic = "";

}
