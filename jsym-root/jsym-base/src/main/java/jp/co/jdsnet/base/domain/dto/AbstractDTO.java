package jp.co.jdsnet.base.domain.dto;

import java.util.Map;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DTO抽象クラス
 * @author Ryo.Matsumura
 *
 */
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access=AccessLevel.NONE)
public abstract class AbstractDTO implements Transformable {
	private Map<String, String> userMap;
}
