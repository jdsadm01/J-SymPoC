package jp.co.jdsnet.base.webapp.form;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.concurrent.ConcurrentHashMap;

import jp.co.jdsnet.base.domain.dto.AbstractDTO;
import jp.co.jdsnet.common.utils.FormatUtility;

public interface FormInterface<T extends AbstractDTO> {

	default LocalDate getDateField(String filedName) throws Exception {
		Field field = this.getClass().getDeclaredField(filedName);
		field.setAccessible(true);
		String yyyyMMdd = FormatUtility.convertYYYYMMDD(String.valueOf(field.get(this)));
		
		return DateTimeFormatter.ofPattern("uuuuMMdd")
		        .withResolverStyle(ResolverStyle.STRICT)
		        .parse(yyyyMMdd, LocalDate::from);
	}
	
	/**
	 * FormからDTOへ変換する
	 * 必要な場合は各Formで実装する
	 * @return DTO
	 */
	default T toDTO(ConcurrentHashMap<String,String> userMap) { return null; }
	
//	/**
//	 * DTOからFormへ変換する
//	 * staticメソッドはOverride出来ないのでコメントアウト
//	 * @param dto
//	 * @return form
//	 */
//	static String toForm(T dto) { return null; }
}
