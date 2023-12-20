package jp.co.jdsnet.base.webapp.parts;

import java.util.Map;
import java.util.Optional;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GlobalErrorViewResolver extends DefaultErrorViewResolver {
  /**
   * Create a new {@link DefaultErrorViewResolver} instance.
   * @param applicationContext the source application context
   * @param resourceProperties resource properties
   */
  public GlobalErrorViewResolver(ApplicationContext applicationContext,WebProperties webProperties) {
    super(applicationContext, webProperties.getResources());
  }

  @Override
  public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
    Optional<ModelAndView> mav = Optional.ofNullable(super.resolveErrorView(request, status, model))
        .or(() -> Optional.of(new ModelAndView("",model)));
    String errcode = model.get("status").toString();
    String path = model.get("path").toString();
    String massage = model.get("message").toString();
    log.error("ERRORCODE="+errcode+", RequestURI="+path+", Message="+massage);
    System.out.println("ERRORCODE="+errcode+", RequestURI="+path+", Message="+massage);
    if (status.is4xxClientError()) {
      // 4XX系エラーの時の処理
      mav.get().setViewName("error/4xx");
    } else if (status.is5xxServerError()) {
      // 5XX系エラーの時の処理
      String trace = model.get("trace").toString();
      log.error(trace);
      mav.get().setViewName("error/5xx");
    }
    return mav.get();
  }
}
