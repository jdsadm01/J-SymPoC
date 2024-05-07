package jp.co.jdsnet.common.domain.mapper.control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import jp.co.jdsnet.common.domain.entity.control.MdvSessionControlEntity;
import jp.co.jdsnet.common.domain.mapper.MapperTest;

/**
 * MdvSessionControlの自動生成テスト CSVが正しいことを確認する。 CSVが合っていればツールで作成されるSQLは正しいことが前提とする。
 */
@MapperTest
public class GeneratedMdvSessionControlMapperTest {

  @Autowired
  MdvSessionControlMapper target;

  /**
   * フィールドについての期待値
   *
   * @return 期待値
   */
  private String getExpData() {
    return "test,,0,0,,,0,0"; // 変更点
  }

  /**
   * SQLを実行し、selectの結果でフィールドの確認も実施する
   */
  @Test
  void test() {
    MdvSessionControlEntity input = MdvSessionControlEntity.builder().mdvusrid("test").build(); // 変更点
    // SQLが正しく実行される＝カラム定義に間違いがないことを確認する
    try {
      target.insert(input);
      final MdvSessionControlEntity ret = target.select(input);
      target.selectWithLockForUpdate(input);
      target.update(input);
      target.delete(input);
      assertEquals(getExpData(), getDataString(ret), "フィールドの不一致");
    } catch (Exception e) {
      fail("SQLが正しく実行されませんでした。カラムの型、もしくは外部キーの有無を確認してください。message=" + e.getMessage());
    }
  }

  /**
   * Entityからデータをカンマ区切りの文字列で取得する
   *
   * @param entity select結果
   * @return CSV形式のデータ
   */
  private String getDataString(MdvSessionControlEntity entity) {
    String str = entity.toString();
    str = str.substring(str.lastIndexOf("("), str.length() - 2);
    String[] fields = str.split(",");
    List<String> fieldsList =
        Arrays.stream(fields).map(v -> v.concat(" ").split("=")[1].trim()).toList();
    return String.join(",", fieldsList);
  }
}
