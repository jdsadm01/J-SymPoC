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
 * EXCELフォーム明細テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSssExcelTemplateDetailEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** フォーム番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private int formbng = 0;

  /** 表示順 */
  @Keyfield(index = 3)
  @Builder.Default
  private int hjijun = 0;

  /** 項目物理名 */
  @Builder.Default
  private String colnm = "";

  /** 並び順 */
  @Builder.Default
  private int odr = 0;

  /** 並び順区分 */
  @Builder.Default
  private String odrkbn = "";

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
