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
  private String hjihnb;
  private int chzsur;
  private String tomrakcod;
  private String hbidte;
  private String usnjndte; // 優先順日付
  private String urisyytencod;
  private String tokcod;
  private String dscod;
  private String toknm;
  private String jucdte;
  private String chzdeldte;
  private String chzdelKbn;
  private String deletechk;

  // 明細に出力しない注残項目(更新で使用)
  private int jucmdsseq;
  private int jucmeiseq;
  private int seq;
  private String trncod;
  private int chzjkk;
  private String thcbng;
  private String sjcod;
  private String ykncod;
  private String mscod;
  private String tankinhjiflg;
  private String daikaiskbcod;
  private String kigbng;
  private int trjchzsur;
  private String tankinstekbn;
  private double skrtan;
  private String rmcod;
  private String eigcod;
  private String tercod;
  private String skosteariflg;
  private int chzrelno;
  private String cpufulid;
  private int wsseq7kt;
  private String chzkicsjizflg;
  private String chzstskbn;
  private String cchflg;
  private String cchtioktkkbn;
  private String cchhatskocod;
  private int chzdelkjndte;
  private String fmg1;
  private String fmg2;



}