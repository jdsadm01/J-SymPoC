package jp.co.jdsnet.home.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.home.domain.service.LoginService;
import jp.co.jdsnet.home.webapp.form.LoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {
  private final HttpServletRequest request;
  private final HttpSession httpSession;

  private final LoginService service;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("loginForm",
        LoginForm.builder().ipaddr(request.getRemoteAddr())
            .netwrkskbcod(service.getNetwrkskbcod(request.getRemoteAddr())).build());
    return "login/login";
  }

  @PostMapping(value = "login")
  public String login(@ModelAttribute LoginForm loginForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "login/login";
    }

    try {
      loginForm = service
          .entry(loginForm.toBuilder().sessionid(httpSession.getId())
              .browserVersion(request.getHeader("User-Agent")).build().toDTO())
          .transform(LoginForm::toForm);
      
      httpSession.getServletContext().setAttribute(loginForm.getSessionid(),
          loginForm.getUserInfo().convertForServletContext());

      // TODO 一旦直接セッションに保持
      httpSession.setAttribute("usrid", loginForm.getUserInfo().getUsrid().trim());
      httpSession.setAttribute("usrnm", loginForm.getUserInfo().getUsrnm());
    } catch (Exception e) {
      e.printStackTrace();
      return "login/login";
    }
    return "home/menu";
  }

}
