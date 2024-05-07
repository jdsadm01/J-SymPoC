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
 * MyメニューEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedMyMenuEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーID */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** 業務ID */
  @Keyfield(index = 2)
  @Builder.Default
  private String gymid = "";

  /** 画面ID */
  @Keyfield(index = 3)
  @Builder.Default
  private String gmnid = "";

  /** メニュー区分 */
  @Builder.Default
  private String mnukbn = "";

  /** 表示順 */
  @Builder.Default
  private int hjijun = 0;

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
