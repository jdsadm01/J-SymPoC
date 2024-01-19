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
  private String updkbn; // 処理区分
  private String jucdtefrom; // 受注日From
  private String jucdteto; // 受注日To
  private String hbidtefrom; // 発売日From
  private String hbidteto; // 発売日To
  private String delchk;

  // 明細項目
  private String urisyytencod;
  private String jucdte;
  private String usnjndte;

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
  private List<String> detailBottomList;

  private List<LabelData> tokkbnList; // 得意先区分ラジオボタン用
  private List<LabelData> updkbnList; // 処理区分
  private List<BackDeleteDetailDTO> deleteList; // 削除チェックがされている明細

  private String pageKey;
  private int pageNo;


}
