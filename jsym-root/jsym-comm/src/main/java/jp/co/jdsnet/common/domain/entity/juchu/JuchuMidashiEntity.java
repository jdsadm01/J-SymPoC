package jp.co.jdsnet.common.domain.entity.juchu;

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
 * 受注見出Entityクラス
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
public class JuchuMidashiEntity extends GeneratedJuchuMidashiEntity {

  // 関連属性 ↓
  List<JuchuMeisaiEntity> meisaiList;
}
