package jp.co.jdsnet.home;

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
public class JsymHomeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JsymHomeApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		setRegisterErrorPageFilter(false);
		return application.sources(JsymHomeApplication.class);
	}

    // 別のテンプレートフォルダを追加する
    @Bean
    public ClassLoaderTemplateResolver htmlTemplateResolver() {
        ClassLoaderTemplateResolver baseTemplateResolver = new ClassLoaderTemplateResolver();
        baseTemplateResolver.setPrefix("base_templates/"); //追加するテンプレートフォルダを指定
        baseTemplateResolver.setSuffix(".html");
        baseTemplateResolver.setTemplateMode(TemplateMode.HTML);
        baseTemplateResolver.setCharacterEncoding("UTF-8");
        baseTemplateResolver.setOrder(2); //読み込み順
        baseTemplateResolver.setCheckExistence(true);

        return baseTemplateResolver;
    }
//
//    @Bean
//    public ClassLoaderTemplateResolver cssTemplateResolver() {
//        ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
//        secondaryTemplateResolver.setPrefix("base_static/css/"); //追加するテンプレートフォルダを指定
//        secondaryTemplateResolver.setSuffix(".css");
//        secondaryTemplateResolver.setTemplateMode(TemplateMode.CSS);
//        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
//        secondaryTemplateResolver.setOrder(3); //読み込み順
//        secondaryTemplateResolver.setCheckExistence(true);
//
//        return secondaryTemplateResolver;
//    }
//
//    @Bean
//    public ClassLoaderTemplateResolver jsTemplateResolver() {
//        ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
//        secondaryTemplateResolver.setPrefix("base_static/js/"); //追加するテンプレートフォルダを指定
//        secondaryTemplateResolver.setSuffix(".js");
//        secondaryTemplateResolver.setTemplateMode(TemplateMode.JAVASCRIPT);
//        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
//        secondaryTemplateResolver.setOrder(4); //読み込み順
//        secondaryTemplateResolver.setCheckExistence(true);
//
//        return secondaryTemplateResolver;
//    }
}
