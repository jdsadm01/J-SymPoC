package jp.co.jdsnet.home.webapp.form;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.home.domain.dto.LoginDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginForm implements FormInterface<LoginDTO>, Serializable {
  private static final long serialVersionUID = 1L;

  @NotBlank
  private String enyusrid;
  @NotBlank
  private String pwd;

  private String ipaddr;
  private String netwrkskbcod;
  private String sessionid;
  private String browserVersion;
  private UserInfoVO userInfo;

  @Override
  public LoginDTO toDTO() {
    return LoginDTO.builder().enyusrid(this.enyusrid).pwd(this.pwd).ipaddr(this.ipaddr)
        .netwrkskbcod(this.netwrkskbcod).sessionid(this.sessionid)
        .browserVersion(this.browserVersion).build();
  }

  public static LoginForm toForm(LoginDTO dto) {
    return LoginForm.builder().enyusrid(dto.getEnyusrid()).pwd(dto.getPwd()).ipaddr(dto.getIpaddr())
        .sessionid(dto.getSessionid()).browserVersion(dto.getBrowserVersion())
        .userInfo(dto.getUserInfo()).build();
  }
}
