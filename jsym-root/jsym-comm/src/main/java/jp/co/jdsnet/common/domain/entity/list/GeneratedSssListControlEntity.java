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
 * EXCELフォーム関連テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSssListControlEntity implements EntityInterface {

  // 永続属性 ↓
  /** 帳票データファイルＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String chydtafleid = "";

  /** ユーザーＩＤ */
  @Builder.Default
  private String usrid = "";

  /** フォーム番号 */
  @Builder.Default
  private int formbng = 0;

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
