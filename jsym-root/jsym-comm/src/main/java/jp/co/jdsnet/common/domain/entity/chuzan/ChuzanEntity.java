package jp.co.jdsnet.common.domain.entity.chuzan;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChuzanEntity extends GeneratedChuzanEntity {

  // 注残以外のカラム
  
  /** no */
  @Builder.Default
  private int no = 0;


  // 品番
  /** タイトル */
  @Builder.Default
  private String titnm = "";

  /** アーティスト */
  @Builder.Default
  private String artnm = "";

  /** 表示品番 */
  @Builder.Default
  private String hjihnb = "";

  /** 当月ランク */
  @Builder.Default
  private String tomrakcod = "";

  /** 発売日 */
  @Builder.Default
  private int htbdte = 0;

  // 共通得意先
  /** 得意先名1 */
  @Builder.Default
  private String toknm1 = "";

  /** 得意先名2 */
  @Builder.Default
  private String toknm2 = "";

  // DS
  /** DS名1 */
  @Builder.Default
  private String dsnm1 = "";

  /** DS名2 */
  @Builder.Default
  private String dsnm2 = "";

  // 各社得意先
  /** 売上集約店コード */
  @Builder.Default
  private String urisyytencod = "";

}
