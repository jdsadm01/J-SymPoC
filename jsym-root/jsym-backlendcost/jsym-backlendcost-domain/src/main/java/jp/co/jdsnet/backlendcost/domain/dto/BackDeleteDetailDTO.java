package jp.co.jdsnet.backlendcost.domain.dto;

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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.NONE)
public class BackDeleteDetailDTO extends AbstractDTO {

  // 明細部明細部分
  private int no;
  private String skocod;
  private String kigbng;
  private int chzsur;
  private String tomrakcod;
  private int hbidte;
  private int usnjndte; // 優先順日付
  private String urisyytencod;
  private String tokcod;
  private String dscod;
  private String toknm;
  private int jucdte;
  private int chzdeldte;
  private String chzdelKbn;
  private String deletechk;


  // 付加情報
  private String daikaiskbcod;
  private String hjihnb;

}