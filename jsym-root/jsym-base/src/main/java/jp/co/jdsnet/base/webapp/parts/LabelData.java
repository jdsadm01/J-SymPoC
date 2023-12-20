package jp.co.jdsnet.base.webapp.parts;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * リストボックス等の表示用のデータオブジェクト
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access=AccessLevel.PUBLIC)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
public class LabelData {
  /** コード値 */
  private String value;
  /** 表示名称 */
  private String text;
}
