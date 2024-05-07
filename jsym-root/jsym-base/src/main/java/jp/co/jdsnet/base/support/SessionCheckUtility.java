package jp.co.jdsnet.base.support;

import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.common.domain.entity.control.LoginControlEntity;
import jp.co.jdsnet.common.domain.mapper.control.LoginControlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class SessionCheckUtility {
  private final LoginControlMapper loginControlMapper;

  @Value("${property.session.userInfoKey}")
  private String userInfoKey;
  @Value("${property.session.lockTime}")
  private int lockTime;
  @Value("${property.session.contextName}")
  private String contextName;
  @Value("${property.session.idKey}")
  private String idKey;

  public void checkSession(UserInfoVO usrInfo) throws ResponseStatusException {
    if (Objects.isNull(usrInfo)) {
      log.error("Session情報未保持");
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
    LoginControlEntity loginControlEntity =
        loginControlMapper.select(LoginControlEntity.builder().usrid(usrInfo.getUsrid()).build());
    if (Objects.isNull(loginControlEntity)) {
      log.error("ログインコントロール無し");
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
    if (usrInfo.isStolenSession(loginControlEntity.getLogindte(),
        loginControlEntity.getLoginjkk())) {
      log.error("後続ログインあり");
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    LocalDateTime thisAccessTime = LocalDateTime.now();
    log.debug("lastaccess add" + lockTime + "=" + usrInfo.getLastAccessTime().plusMinutes(lockTime)
        + ",now="
        + thisAccessTime);
    if (thisAccessTime.isAfter(usrInfo.getLastAccessTime().plusMinutes(lockTime))) {
      throw new ResponseStatusException(HttpStatus.LOCKED);
    } else {
      usrInfo.setLastAccessTime(thisAccessTime);
    }
  }
}
