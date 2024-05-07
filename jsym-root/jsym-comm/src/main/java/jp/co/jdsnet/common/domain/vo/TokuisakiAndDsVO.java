package jp.co.jdsnet.common.domain.vo;

import jp.co.jdsnet.common.domain.entity.tokuisaki.DsEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KyotsuTokuisakiEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TokuisakiAndDsVO {

  @Builder.Default
  private final KyotsuTokuisakiEntity kyotsuTokuisaki = null;

  @Builder.Default
  private final DsEntity ds = null;

  @Builder.Default
  private final KakushaTokuisakiEntity kakushaTokuisaki = null;
}
