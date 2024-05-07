package jp.co.jdsnet.common.domain.entity;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface EntityInterface {

  /**
   * アノテーション"Keyfield"を付与した項目をカンマ区切りで出力する.
   * @return 主キーの文字列
   */
  default String getKeyString() {
    Class<Keyfield> clazz = Keyfield.class;
    List<String> keyList = Stream.concat(
        Stream.of(this.getClass().getSuperclass().getDeclaredFields()),
            Stream.of(this.getClass().getDeclaredFields()))
        .filter(field -> field.isAnnotationPresent(clazz))
        .sorted(Comparator.comparing((Field field) -> field.getAnnotation(clazz).index()))
        .map(field -> {
          field.setAccessible(true);
          try {
            return String.valueOf(field.get(this));
          } catch (IllegalArgumentException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            return "";
          }
        })
        .collect(Collectors.toList());
    
    return String.join(",", keyList);
  }
}
