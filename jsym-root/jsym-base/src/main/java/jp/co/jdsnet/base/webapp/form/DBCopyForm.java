package jp.co.jdsnet.base.webapp.form;

import java.util.function.Supplier;

import jp.co.jdsnet.base.webapp.parts.CommonClipboardData;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuppressWarnings("rawtypes")
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public abstract class DBCopyForm<T extends CommonClipboardData> {
	private String dataBody;
	
	@SuppressWarnings("unchecked")
	public void setCopyData(Supplier<T> supplier) {
		T ret = supplier.get();
		dataBody = ret.getClipboardData(this);
	}
}
