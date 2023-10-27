package jp.co.jdsnet.base.domain.dto;

import java.util.function.Function;

/**
 * DTOからFormへの変換インターフェース
 * @author Ryo.Matsumura
 */
public interface Transformable {
	@SuppressWarnings("unchecked")
	default <T, R> R transform(Function<T, R> func) {
		return func.apply((T) this);
	}
}
