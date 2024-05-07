package jp.co.jdsnet.assistant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


@SpringBootApplication(scanBasePackages = "jp.co.jdsnet")
@MapperScan("jp.co.jdsnet.common.domain.mapper")
public class JsymAssistantApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(JsymAssistantApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(JsymAssistantApplication.class);
  }

  // 別のテンプレートフォルダを追加する
  @Bean
  public ClassLoaderTemplateResolver htmlTemplateResolver() {
    ClassLoaderTemplateResolver baseTemplateResolver = new ClassLoaderTemplateResolver();
    baseTemplateResolver.setPrefix("base_templates/"); // 追加するテンプレートフォルダを指定
    baseTemplateResolver.setSuffix(".html");
    baseTemplateResolver.setTemplateMode(TemplateMode.HTML);
    baseTemplateResolver.setCharacterEncoding("UTF-8");
    baseTemplateResolver.setOrder(2); // 読み込み順
    baseTemplateResolver.setCheckExistence(true);

    return baseTemplateResolver;
  }
}
