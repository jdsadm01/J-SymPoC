package jp.co.jdsnet.common.domain.entity.syseve;

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
 * エラーデータ管理Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedErrordataManagementEntity implements EntityInterface {

  // 永続属性 ↓
  /** 場所ｺｰﾄﾞ */
  @Keyfield(index = 1)
  @Builder.Default
  private String bshcod = "";

  /** CPUIDｸﾞﾙｰﾌﾟ */
  @Keyfield(index = 2)
  @Builder.Default
  private String cpuidgrp = "";

  /** ﾘｽﾄID */
  @Keyfield(index = 3)
  @Builder.Default
  private String lstid = "";

  /** 会社識別ｺｰﾄﾞ */
  @Keyfield(index = 4)
  @Builder.Default
  private String kaiskbcod = "";

  /** 作成日付 */
  @Keyfield(index = 5)
  @Builder.Default
  private int ssedte = 0;

  /** 作成時間 */
  @Keyfield(index = 6)
  @Builder.Default
  private int ssejkk = 0;

  /** ﾚｺｰﾄﾞSEQ */
  @Keyfield(index = 7)
  @Builder.Default
  private int recseq = 0;

  /** ﾕｰｻﾞｰID */
  @Builder.Default
  private String usrid = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
