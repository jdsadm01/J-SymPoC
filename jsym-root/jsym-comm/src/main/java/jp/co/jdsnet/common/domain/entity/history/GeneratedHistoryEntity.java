package jp.co.jdsnet.common.domain.entity.history;

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
 * 履歴テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedHistoryEntity implements EntityInterface {

  // 永続属性 ↓
  /** ユーザーＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String usrid = "";

  /** 受信日付 */
  @Keyfield(index = 2)
  @Builder.Default
  private int jsndte = 0;

  /** 受信時刻 */
  @Keyfield(index = 3)
  @Builder.Default
  private int jsnjkk = 0;

  /** ユーザーシーケンス№ */
  @Keyfield(index = 4)
  @Builder.Default
  private int usrseqno = 0;

  /** シーケンス№ */
  @Keyfield(index = 5)
  @Builder.Default
  private int seqno = 0;

  /** 画面ＩＤ */
  @Builder.Default
  private String gmnid = "";

  /** 画面ＩＤシーケンスＮｏ */
  @Builder.Default
  private String gmnseqno = "";

  /** 画面区分 */
  @Builder.Default
  private String gmnkbn = "";

  /** テキスト */
  @Builder.Default
  private String txt = "";

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
