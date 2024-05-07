package jp.co.jdsnet.common.domain.entity.sysmas;

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
 * エラー名称テーブルEntityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedErrorNamingEntity implements EntityInterface {

  // 永続属性 ↓
  /** ﾘｽﾄｸﾞﾙｰﾌﾟ */
  @Keyfield(index = 1)
  @Builder.Default
  private String lstgrp = "";

  /** ｴﾗｰｸﾞﾙｰﾌﾟ */
  @Keyfield(index = 2)
  @Builder.Default
  private String errgrp = "";

  /** ｴﾗｰｺｰﾄﾞ */
  @Keyfield(index = 3)
  @Builder.Default
  private String errcod = "";

  /** ｼｰｹﾝｽNO */
  @Builder.Default
  private int seqno = 0;

  /** 内容 */
  @Builder.Default
  private String niy = "";

  /** 最新更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 最新更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
