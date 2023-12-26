package jp.co.jdsnet.base.interceptor;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SessionCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private HttpSession httpSession;

    @Value("${property.session.userInfoKey}")
    private String userInfoKey;
    @Value("${property.session.lockTime}")
    private int lockTime;
    @Value("${property.session.contextName}")
    private String contextName;
    @Value("${property.session.idKey}")
    private String idKey;
    
    
    @Override
	public boolean preHandle(HttpServletRequest request,
	    HttpServletResponse response, Object handler) throws Exception {
		if(request.getSession(false) == null) {
			log.error("URL不正リクエスト");
			return false;
		}
		UserInfoVO usrInfo = (UserInfoVO)httpSession.getAttribute(userInfoKey);
		if(usrInfo == null) {
			log.error("Session情報未保持");
			response.setStatus(500);
			return false;
		}
		LocalDateTime thisAccessTime = LocalDateTime.now();
		if(thisAccessTime.isAfter(usrInfo.getLastAccessTime().plusMinutes(lockTime))) {
			response.setStatus(500);
			return false;
		} else {
			usrInfo.setLastAccessTime(thisAccessTime);
		}
		httpSession.setAttribute(userInfoKey, usrInfo);
		httpSession.getServletContext().getContext(contextName).setAttribute(String.valueOf(httpSession.getAttribute(idKey)), usrInfo);
		return true;
	}
}
