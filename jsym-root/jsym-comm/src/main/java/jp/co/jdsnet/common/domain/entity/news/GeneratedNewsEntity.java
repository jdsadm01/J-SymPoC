package jp.co.jdsnet.common.domain.entity.news;

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
 * ニューステーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedNewsEntity implements EntityInterface {

  // 永続属性 ↓
  /** ニュースＳＥＱ */
  @Keyfield(index = 1)
  @Builder.Default
  private int nwsseq = 0;

  /** ニュース区分 */
  @Builder.Default
  private String nwskbn = "";

  /** 表示日付(FROM) */
  @Builder.Default
  private int hjidtefrm = 0;

  /** 表示日付(TO) */
  @Builder.Default
  private int hjidteto = 0;

  /** ニュースタイトル */
  @Builder.Default
  private String nwstit = "";

  /** ニュース内容 */
  @Builder.Default
  private String nwsnyo = "";

  /** 添付ファイル名 */
  @Builder.Default
  private String tnpflenm = "";

  /** 添付物理ファイル名 */
  @Builder.Default
  private String tnpbtrflenm = "";

  /** 宛先コメント */
  @Builder.Default
  private String atscmt = "";

  /** 更新ユーザーID */
  @Builder.Default
  private String updusrid = "";

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
