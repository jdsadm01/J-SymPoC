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

  @Builder.Default
  private int jucdtefrom = 0;

  @Builder.Default
  private int jucdteto = 0;

  @Builder.Default
  private int hbidtefrom = 0;

  @Builder.Default
  private int hbidteto = 0;

  @Builder.Default
  private String usrDaikaiskbcod = "";

  @Builder.Default
  private String usrKaiskbcod = "";


  @Builder.Default

  private String kaiskbcod = "";

  @Builder.Default
  private String skocod = "";

  @Builder.Default
  private String pageKey = "";

  @Builder.Default
  private String tokkbn = "";



  // 品番
  /** タイトル */
  @Builder.Default
  private String titnm = "";

  /** アーティスト */
  @Builder.Default
  private String artnm = "";

  /** M分類 */
  @Builder.Default
  private String mkrbuncod = "";

  /** 表示品番 */
  @Builder.Default
  private String hjihnb = "";

  /** 当月ランク */
  @Builder.Default
  private String tomrakcod = "";

  /** 発売日 */
  @Builder.Default
  private int hbidte = 0;

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
