package jp.co.jdsnet.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jp.co.jdsnet.base.interceptor.AccessLogInterceptor;
import jp.co.jdsnet.base.interceptor.SessionCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	private static final String[] STATIC_RESOURCES = {
			"/css/**", "/js/**", "/img/**","/favicon.ico",
	};

	private static final String[] SESSIONCHECK_EXCLUDE = {
			"/css/**", "/js/**", "/img/**","/favicon.ico",
			"/init/**", "/error/**", "/register/**",
	};

	@Bean
	AccessLogInterceptor accessLogInterceptor() {
		return new AccessLogInterceptor();
	}
	
	@Bean
	SessionCheckInterceptor sessionCheckInterceptor() {
		return new SessionCheckInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(accessLogInterceptor()).excludePathPatterns(STATIC_RESOURCES);
		registry.addInterceptor(sessionCheckInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns(SESSIONCHECK_EXCLUDE);
	}
}
