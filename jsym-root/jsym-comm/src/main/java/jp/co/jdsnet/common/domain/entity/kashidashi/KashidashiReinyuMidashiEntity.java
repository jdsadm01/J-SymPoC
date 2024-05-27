package jp.co.jdsnet.common.domain.entity.kashidashi;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 貸出戻入見出Entityクラス
 *
 * @author ソース生成ツール
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KashidashiReinyuMidashiEntity extends GeneratedKashidashiReinyuMidashiEntity {

  // 関連属性 ↓
  List<KashidashiReinyuMeisaiEntity> meisaiList;
}
