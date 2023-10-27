package jp.co.jdsnet.base.webapp.parts;

import java.util.function.BiConsumer;

import org.springframework.ui.Model;

import jp.co.jdsnet.base.webapp.form.FormInterface;

public interface CreateCopy {
	
//	default <T extends FormInterface> void setCopydata(Model model, T form) {
//		;
//	}

	default <T extends CommonClipboardData> void setCopydata(BiConsumer<Model, T> func) {
		func.accept(null, null);
	}
	

}
