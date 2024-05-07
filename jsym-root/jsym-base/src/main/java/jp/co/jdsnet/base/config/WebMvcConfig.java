package jp.co.jdsnet.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.support.RequestDataValueProcessor;
import jp.co.jdsnet.base.interceptor.OperationLogInterceptor;
import jp.co.jdsnet.base.interceptor.SessionCheckInterceptor;
import jp.co.jdsnet.base.support.CompositeRequestDataValueProcessor;
import jp.co.jdsnet.base.support.ExpansionLocalValidatorFactoryBean;
import jp.fintan.keel.spring.web.token.transaction.TransactionTokenInterceptor;
import jp.fintan.keel.spring.web.token.transaction.TransactionTokenRequestDataValueProcessor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Autowired
  private MessageSource messageSource;

  private static final String[] STATIC_RESOURCES =
      {"/css/**", "/js/**", "/img/**", "/favicon.ico",};

  private static final String[] SESSIONCHECK_EXCLUDE = {"/css/**", "/js/**", "/img/**",
      "/favicon.ico", "/init/**", "/error/**", "/register/**", "/", "/login", "/**/checksession",
      "/**/confirmuser"};

  @Override
  public Validator getValidator() {
    return validator();
  }

  @Bean
  @Primary
  public LocalValidatorFactoryBean validator() {
    final ExpansionLocalValidatorFactoryBean factoryBean = new ExpansionLocalValidatorFactoryBean();
    factoryBean.setValidationMessageSource(messageSource);
    return factoryBean;
  }

  @Bean
  public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
    return new ResourceUrlEncodingFilter();
  }

  @Bean
  public OperationLogInterceptor accessLogInterceptor() {
    return new OperationLogInterceptor();
  }

  @Bean
  public SessionCheckInterceptor sessionCheckInterceptor() {
    return new SessionCheckInterceptor();
  }

  @Bean
  public TransactionTokenInterceptor transactionTokenInterceptor() {
    return new TransactionTokenInterceptor();
  }

  @Bean
  public RequestDataValueProcessor requestDataValueProcessor() {
    return new CompositeRequestDataValueProcessor(new CsrfRequestDataValueProcessor(),
        new TransactionTokenRequestDataValueProcessor());
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(accessLogInterceptor()).excludePathPatterns(STATIC_RESOURCES).order(1);
    registry.addInterceptor(sessionCheckInterceptor()).addPathPatterns("/**")
        .excludePathPatterns(SESSIONCHECK_EXCLUDE).order(2);
    registry.addInterceptor(transactionTokenInterceptor()).addPathPatterns("/**").order(3);
  }
}
