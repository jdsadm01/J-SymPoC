package jp.co.jdsnet.backlendcost.domain.dto;

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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.NONE)
public class BackDeleteDTO extends AbstractDTO {

  private String kaiskbcod; // 会社識別
  private String mkrbuncod; // メーカー分類(テーブル物理名引用)
  private String skocod; // 倉庫コード
  private String kigbng; // 記号番号
  private String tokcod; // 得意先
  private String dscod; // DS
  private String eigcod; // 営業所
  private String tercod; // テリトリー
  private String prckbn; // 処理区分
  private int jucdtefrom; // 受注日From
  private int jucdteto; // 受注日To
  private int hbidtefrom; // 発売日From
  private int hbidteto; // 発売日To
  private String delchk;

  // 明細部見出し部分
  private String titnm;
  private String artnm;
  private String toknm;
  private String dsnm;
  private int chzCnt;
  private int chzsurTotal;

  private String allDeletechk; // 一括削除チェックボックス
  private String updKbn;

  private List<BackDeleteDetailDTO> detailList;

  private List<LabelData> updKbnList; // 処理区分
  private List<BackDeleteDetailDTO> deleteList; // 削除チェックがされている明細

  private List<String> pageKey;
  private int pageNo;


}
