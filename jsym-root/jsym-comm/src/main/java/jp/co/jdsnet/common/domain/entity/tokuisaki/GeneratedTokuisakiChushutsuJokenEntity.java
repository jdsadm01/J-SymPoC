package jp.co.jdsnet.common.domain.entity.tokuisaki;

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
 * 得意先抽出条件Entityクラス
 *
 * @author ソース生成ツールによる自動生成
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneratedTokuisakiChushutsuJokenEntity implements EntityInterface {

  // 永続属性 ↓
  /** リストＩＤ */
  @Keyfield(index = 1)
  @Builder.Default
  private String lstid = "";

  /** リスト枝番 */
  @Keyfield(index = 2)
  @Builder.Default
  private String lsteda = "";

  /** 代表会社識別コード */
  @Keyfield(index = 3)
  @Builder.Default
  private String daikaiskbcod = "";

  /** 変換代表会社識別コード */
  @Keyfield(index = 4)
  @Builder.Default
  private String hkndaikaiskbcod = "";

  /** 売上集約店コード */
  @Keyfield(index = 5)
  @Builder.Default
  private String urisyytencod = "";

  /** 得意先コード */
  @Keyfield(index = 6)
  @Builder.Default
  private String tokcod = "";

  /** 有効期間ＦＲＯＭ */
  @Builder.Default
  private int ykokknfrm = 0;

  /** 有効期間ＴＯ */
  @Builder.Default
  private int ykokknto = 0;

  /** ユーザーメモ */
  @Builder.Default
  private String usrmemo = "";

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
