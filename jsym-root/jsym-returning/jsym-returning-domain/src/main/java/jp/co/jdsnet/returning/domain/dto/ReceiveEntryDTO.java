package jp.co.jdsnet.returning.domain.dto;

import java.util.List;
import jp.co.jdsnet.base.domain.dto.AbstractDTO;
import jp.co.jdsnet.base.webapp.parts.LabelData;
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
public class ReceiveEntryDTO extends AbstractDTO {
  private String daikaiskbcod;
  private String trncod;
  private String tokcod;
  private String dscod;
  private String rmcod;
  private String hpnjurdte;
  private String hpnutkbng;
  private String ttlsur;
  private String kinhjikbn;
  private String knrkbn;
  private String smtcod;
  private String skrkrt;
  private String hpntsyukeflg;
  private String locbng;
  private String tokdenbng1;
  private String tokdenbng2;
  private String odrno;
  private String mscod;
  private String fmg1;
  private String fmg2;

  private String stano;
  private String toknm;
  private String telbng;
  private String smedte;
  
  private List<ReceiveEntryDetailDTO> detailList;
  
  private List<String> daikaiskbcodList;
  private List<LabelData> trncodList;
  private List<LabelData> rmcodList;
  private List<LabelData> kinhjikbnList;
  private List<LabelData> hpntsyukeflgList;
}
