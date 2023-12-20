package jp.co.jdsnet.base.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private static final String[] STATIC_RESOURCES = {
			"/css/**", "/js/**", "/img/**", "/**.ico",
	};
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authz -> authz
//              .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//              .requestMatchers("/").permitAll()
//              .requestMatchers("/general").hasRole("GENERAL")
//              .requestMatchers("/admin").hasRole("ADMIN")
//				.requestMatchers(STATIC_RESOURCES).permitAll()
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.anyRequest().permitAll()
        );
//		http.csrf().disable();
		return http.build();
	}

}
