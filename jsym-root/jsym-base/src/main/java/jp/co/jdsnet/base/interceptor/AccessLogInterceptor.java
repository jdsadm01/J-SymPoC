package jp.co.jdsnet.base.interceptor;

import java.util.Collections;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccessLogInterceptor implements HandlerInterceptor {

	private static Logger accesslog = LoggerFactory.getLogger("AccessLog");

	@Override
	public boolean preHandle(HttpServletRequest request,
	    HttpServletResponse response, Object handler) throws Exception {
		String command = Collections.list(request.getParameterNames()).stream()
			.filter(str -> str.startsWith("btn_"))
			.map(str -> str.replace("btn_",""))
			.collect(Collectors.joining(","));
		accesslog.info("RequestURI="+request.getRequestURI()+",Method="+request.getMethod()+",command="+command);
//		accesslog.info("Interceptorでユーザーとコマンドをだすようにできるかな？");
	  return true;
	}
}
