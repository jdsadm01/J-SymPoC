package jp.co.jdsnet.infoservice.webapp.form;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HintokResultDetailForm implements /* FormInterface<AllStockDTO>, */ Serializable {

  private static final long serialVersionUID = 1L;

  // テスト用
  private String tokcod;
  private String toknm;
  private double share;
  private int dendte;
  private int urisuu;
  private long urikin;
  private int hpnsuu;
  private long hpnkin;
  private int netsuu;
  private long netkin;

}
