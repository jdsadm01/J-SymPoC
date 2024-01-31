package jp.co.jdsnet.base.webapp.form;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import jp.co.jdsnet.base.domain.dto.AbstractDTO;
import jp.co.jdsnet.base.webapp.parts.LabelData;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.common.utils.FormatUtility;
import jp.co.jdsnet.common.utils.StringUtility;

public interface FormInterface<T extends AbstractDTO> {

  default LocalDate getDateField(String filedName) throws Exception {
    Field field = this.getClass().getDeclaredField(filedName);
    field.setAccessible(true);
    String yyyyMMdd = FormatUtility.convertYYYYMMDD(String.valueOf(field.get(this)));

    return DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.LENIENT)
        .parse(yyyyMMdd, LocalDate::from);
  }

  default LocalTime getTimeField(String filedName) throws Exception {
    Field field = this.getClass().getDeclaredField(filedName);
    field.setAccessible(true);
    String s = String.valueOf(field.get(this));
    if (s.length() < 6) {
      s = StringUtility.lpad(s, 5, "0");
    }

    return DateTimeFormatter.ofPattern("Hmmss").withResolverStyle(ResolverStyle.LENIENT).parse(s,
        LocalTime::from);
  }

  default String getLabelText(String filedName, String labelfiledName) throws Exception {
    Field field = this.getClass().getDeclaredField(filedName);
    field.setAccessible(true);

    Field labelfield = this.getClass().getDeclaredField(labelfiledName);
    labelfield.setAccessible(true);

    @SuppressWarnings("unchecked")
    List<LabelData> labelList = (List<LabelData>) labelfield.get(this);
    String value = String.valueOf(field.get(this));
    return labelList.stream().filter(t -> t.getValue().equals(value)).findFirst()
        .map(t -> t.getText()).get();
  }

  /**
   * FormからDTOへ変換する 必要な場合は各Formで実装する
   * 
   * @return DTO
   */
  default T toDTO(UserInfoVO userMap) {
    return null;
  }

  /**
   * FormからDTOへ変換する 必要な場合は各Formで実装する
   * 
   * @return DTO
   */
  default T toDTO() {
    return null;
  }

  // /**
  // * DTOからFormへ変換する
  // * staticメソッドはOverride出来ないのでコメントアウト
  // * @param dto
  // * @return form
  // */
  // static String toForm(T dto) { return null; }
}
