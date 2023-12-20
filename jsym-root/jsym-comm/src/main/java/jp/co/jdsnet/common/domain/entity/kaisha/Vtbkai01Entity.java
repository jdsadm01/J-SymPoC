package jp.co.jdsnet.common.domain.entity.kaisha;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import jp.co.jdsnet.common.domain.entity.Keyfield;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Vtbkai01Entity implements EntityInterface {
  @Keyfield(index = 0)
  @Builder.Default
  private String kaiskbcod = "";
  @Builder.Default
  private String kaicod = "";
  @Builder.Default
  private String kainmkn = "";
  @Builder.Default
  private String kainmkj = "";
  @Builder.Default
  private String daikaiskbcod = "";
  @Builder.Default
  private String kairltflg = "";
  @Builder.Default
  private String kyksgnich = "";
  @Builder.Default
  private String cyzupdumu = "";
  @Builder.Default
  private String cyzstsgnakjykbn = "";
  @Builder.Default
  private String jardoutkbn = "";
  @Builder.Default
  private String gamflg = "";
  @Builder.Default
  private String eigjuczkkfaxssnflg = "";
  @Builder.Default
  private String juczkkfaxssnflg = "";
  @Builder.Default
  private String updkbn = "";
  @Builder.Default
  private int upddte = 0;
  @Builder.Default
  private int updjkk = 0;
}
