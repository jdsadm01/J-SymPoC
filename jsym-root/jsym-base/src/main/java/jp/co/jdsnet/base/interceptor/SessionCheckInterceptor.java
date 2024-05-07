package jp.co.jdsnet.base.interceptor;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.base.support.SessionCheckUtility;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SessionCheckInterceptor implements HandlerInterceptor {
  @Autowired
  private HttpSession httpSession;
  // @Autowired
  // private LoginControlMapper loginControlMapper;
  @Autowired
  private SessionCheckUtility sessionCheckUtility;

  @Value("${property.session.userInfoKey}")
  private String userInfoKey;
  @Value("${property.session.lockTime}")
  private int lockTime;
  @Value("${property.session.contextName}")
  private String contextName;
  @Value("${property.session.idKey}")
  private String idKey;


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("!!!!interceptor!!!!");
    if (Objects.isNull(request.getSession(false))) {
      log.error("URL不正リクエスト");
      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }
    UserInfoVO usrInfo = (UserInfoVO) httpSession.getAttribute(userInfoKey);
    sessionCheckUtility.checkSession(usrInfo);
    // if (Objects.isNull(usrInfo)) {
    // log.error("Session情報未保持");
    // throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    // }
    // LoginControlEntity loginControlEntity =
    // loginControlMapper.select(LoginControlEntity.builder().usrid(usrInfo.getUsrid()).build());
    // if (Objects.isNull(loginControlEntity)) {
    // log.error("ログインコントロール無し");
    // throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    // }
    // if (usrInfo.isStolenSession(loginControlEntity.getLogindte(),
    // loginControlEntity.getLoginjkk())) {
    // log.error("後続ログインあり");
    // throw new ResponseStatusException(HttpStatus.CONFLICT);
    // }
    //
    // LocalDateTime thisAccessTime = LocalDateTime.now();
    // log.debug("lastaccess add 30=" + usrInfo.getLastAccessTime().plusMinutes(lockTime) + ",now="
    // + thisAccessTime);
    // if (thisAccessTime.isAfter(usrInfo.getLastAccessTime().plusMinutes(lockTime))) {
    // throw new ResponseStatusException(HttpStatus.LOCKED);
    // } else {
    // usrInfo.setLastAccessTime(thisAccessTime);
    // }
    httpSession.setAttribute(userInfoKey, usrInfo);
    httpSession.getServletContext().getContext(contextName).setAttribute(
        String.valueOf(httpSession.getAttribute(idKey)), usrInfo.convertForServletContext());
    return true;
  }
}
