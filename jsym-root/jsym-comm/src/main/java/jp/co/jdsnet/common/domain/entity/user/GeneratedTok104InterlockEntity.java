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
 * 得意先104連動状況Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTok104InterlockEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーＩＤ（内部） */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** 移行区分 */
  @Builder.Default
  private String ikokbn = "";

  /** 処理済フラグ */
  @Builder.Default
  private String prcsmiflg = "";

  /** エラー区分 */
  @Builder.Default
  private String errkbn = "";

  /** 処理指示日付 */
  @Builder.Default
  private int prcsjidte = 0;

  /** 処理指示時刻 */
  @Builder.Default
  private int prcsjijkk = 0;

  /** 処理完了日付 */
  @Builder.Default
  private int prckrydte = 0;

  /** 処理完了時刻 */
  @Builder.Default
  private int prckryjkk = 0;

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
