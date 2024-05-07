package jp.co.jdsnet.common.domain.entity.zaiko;

import jp.co.jdsnet.common.domain.entity.EntityInterface;
import jp.co.jdsnet.common.domain.entity.Keyfield;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 在庫確保Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedZaikoKakuhoEntity implements EntityInterface {

  // 永続属性 ↓
  /** 代表会社識別コード */
  @Keyfield(index = 1)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 記号番号 */
  @Keyfield(index = 2)
  @Builder.Default
  private String kigbng = "";

  /** 倉庫コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String skocod = "";

  /** 解除日付（８桁） */
  @Keyfield(index = 4)
  @Builder.Default
  private int kjydte8kt = 0;

  /** 営業所コード */
  @Keyfield(index = 5)
  @Builder.Default
  private String eigcod = "";

  /** 在庫確保得意先集約区分 */
  @Keyfield(index = 6)
  @Builder.Default
  private String zkhtoksyykbn = "";

  /** 得意先コード */
  @Keyfield(index = 7)
  @Builder.Default
  private String tokcod = "";

  /** ＤＳコード */
  @Keyfield(index = 8)
  @Builder.Default
  private String dscod = "";

  /** 在庫確保区分 */
  @Keyfield(index = 9)
  @Builder.Default
  private String zaikhokbn = "";

  /** 在庫確保仮引当数量 */
  @Builder.Default
  private int zaikhokhasur = 0;

  /** 在庫確保コメント */
  @Builder.Default
  private String zaikhocmt = "";

  /** ＣＰＵフルＩＤ */
  @Builder.Default
  private String cpufulid = "";

  /** 入力日付 */
  @Builder.Default
  private int inpdte = 0;

  /** 更新区分 */
  @Builder.Default
  private String updkbn = "";

  /** 更新日付 */
  @Builder.Default
  private int upddte = 0;

  /** 更新時刻 */
  @Builder.Default
  private int updjkk = 0;

}
