package jp.co.jdsnet.common.domain.entity.soko;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ZaikoJokenEntity extends GeneratedZaikoJokenEntity {

  // 結合等の他テーブルカラム

  /** タイトル */
  @Builder.Default
  private String artnm = "";

}
