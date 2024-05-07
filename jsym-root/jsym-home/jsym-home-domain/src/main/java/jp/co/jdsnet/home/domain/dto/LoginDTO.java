package jp.co.jdsnet.home.domain.dto;

import jp.co.jdsnet.base.domain.dto.AbstractDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Setter(AccessLevel.NONE)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.NONE)
public class LoginDTO extends AbstractDTO {
  private String ipaddr;
  private String pwd;
  private String netwrkskbcod;
  private String enyusrid;
  private String sessionid;
  private String browserVersion;
}
