package jp.co.jdsnet.base.interceptor;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.common.domain.vo.UserInfoVO;

public class AccessLogInterceptor implements HandlerInterceptor {

  private static Logger accesslog = LoggerFactory.getLogger("AccessLog");

  @Value("${property.session.userInfoKey}")
  private String userInfoKey;

  @Autowired
  private HttpSession httpSession;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    Optional<UserInfoVO> usrInfo =
        Optional.ofNullable((UserInfoVO) httpSession.getAttribute(userInfoKey))
        .or(() -> Optional.of(UserInfoVO.builder().build()));
    
    String command = Collections.list(request.getParameterNames()).stream()
        .filter(str -> str.startsWith("btn_"))
        .map(str -> str.replace("btn_", ""))
        .collect(Collectors.joining(","));

    System.out.println("usrId=" + usrInfo.get().getUsrid() + ",RequestURI="
        + request.getRequestURI() + ",Method=" + request.getMethod() + ",command=" + command);
    accesslog.info("RequestURI=" + request.getRequestURI() + ",Method=" + request.getMethod()
        + ",command=" + command);
    return true;
  }
}
