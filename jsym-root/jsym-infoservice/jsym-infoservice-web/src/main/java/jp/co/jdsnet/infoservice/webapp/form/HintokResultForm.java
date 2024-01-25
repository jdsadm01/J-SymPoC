package jp.co.jdsnet.infoservice.webapp.form;

import java.io.Serializable;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HintokResultForm implements /* FormInterface<AllStockDTO>, */ Serializable {

  private static final long serialVersionUID = 1L;

  // テスト用
  private String kaiskbcod;
  private String kknfrm;
  private String kknto;
  private String dendtefrm;
  private String dendteto;
  private String prctype;
  private String resultdisp;
  private String stenyo;
  private String inputtype;
  private String tokcod;
  private String toknm;
  private int urisuu;
  private long urikin;
  private int hpnsuu;
  private long hpnkin;
  private int netsuu;
  private long netkin;
  private List<HintokResultDetailForm> detailList;
}
