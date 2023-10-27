package jp.co.jdsnet.base.interceptor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
    @Value("${property.userMapKey.time}")
    private String sessionTimeKey;
    
    
    @Override
	public boolean preHandle(HttpServletRequest request,
	    HttpServletResponse response, Object handler) throws Exception {
		if(request.getSession(false) == null) {
			log.error("URL不正リクエスト");
			return false;
		}
		@SuppressWarnings("unchecked")
		ConcurrentHashMap<String,String> loginMap = (ConcurrentHashMap<String,String>)httpSession.getAttribute(userInfoKey);
		if(loginMap == null) {
			log.error("Session情報未保持");
			response.setStatus(500);
			return false;
		}
		String sysTime = LocalTime.now()
						.format(DateTimeFormatter.ofPattern("HHmmss"));
		int sessionTime = loginMap.get(sessionTimeKey).transform(Integer::parseInt);
		if(sysTime.transform(Integer::parseInt) > sessionTime) {
			response.setStatus(500);
			return false;
		} else {
			loginMap.put(sessionTimeKey
					, LocalTime.parse(sysTime, DateTimeFormatter.ofPattern("HHmmss"))
						.plusMinutes(lockTime)
						.format(DateTimeFormatter.ofPattern("HHmmss")));
		}
		System.out.println("sessintime:"+sessionTime);
		httpSession.setAttribute(userInfoKey, loginMap);
		httpSession.getServletContext().getContext(contextName).setAttribute(idKey, loginMap);
		return true;
	}
}
