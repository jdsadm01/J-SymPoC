package jp.co.jdsnet.base.domain.dto;

import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * DTO抽象クラス
 * @author Ryo.Matsumura
 *
 */
@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access=AccessLevel.NONE)
public abstract class AbstractDTO implements Transformable {
	private UserInfoVO userInfo;
}
