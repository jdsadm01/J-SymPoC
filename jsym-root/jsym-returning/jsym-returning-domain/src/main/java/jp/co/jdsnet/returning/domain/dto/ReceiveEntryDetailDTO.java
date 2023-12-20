package jp.co.jdsnet.returning.domain.dto;

import jp.co.jdsnet.base.domain.dto.AbstractDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor(access=AccessLevel.NONE)
public class ReceiveEntryDetailDTO extends AbstractDTO {
  
  private String kigbng;
  
  private String hpnsur;
  
  private String rmcod;
  
  private String skrtan;
  
  private String tnaste;
  
  private String hpnkin;
  
  /* 品番情報 */
  private String hjihnb;
  
  private String artnm;
  
  private String titnm;
  
  private int hbidte;
  
  private String tomrakcod;
  
  private int setcod;
  
  private String tnpkbn;
  
  /* Ajax用 */
  private String daikaiskbcod;
  private String rowIndex;
}
