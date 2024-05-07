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
 * 特殊画面権限Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedSpecialUserAuthorizationEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーID（内部） */
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

  /** 権限 */
  @Builder.Default
  private String rolekbn = "";

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
