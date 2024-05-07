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
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;

public class OperationLogInterceptor implements HandlerInterceptor {

  private static Logger log = LoggerFactory.getLogger("OperationLog");

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

    log.info("usrId=" + padSpaceUsrid(usrInfo.get().getUsrid()) + ", command="
        + String.format("%-20s", command) + ", RequestURI=" + request.getRequestURI());
    return true;
  }

  private String padSpaceUsrid(String id) {
    String addspace_id = Optional.ofNullable(id).orElse("null").trim();
    if (addspace_id.length() <= 20) {
      addspace_id = String.format("%-20s", addspace_id);
    } else if (addspace_id.length() <= 30) {
      addspace_id = String.format("%-30s", addspace_id);
    } else {
      addspace_id = String.format("%-40s", addspace_id);
    }
    return addspace_id;
  }
}
