package jp.co.jdsnet.common.domain.entity.user;

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
 * EXCELフォームテーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSssExcelTemplateHeaderEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** フォーム番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private int formbng = 0;

  /** フォーム名 */
  @Builder.Default
  private String formnm = "";

  /** テーブルＩＤ */
  @Builder.Default
  private String tblid = "";

  /** 保存フラグ */
  @Builder.Default
  private String hznflg = "0";

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
