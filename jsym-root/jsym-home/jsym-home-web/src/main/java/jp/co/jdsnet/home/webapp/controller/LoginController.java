package jp.co.jdsnet.home.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import com.example.multimodule.application.form.LoginForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
    @Autowired private HttpServletRequest request;
    @Autowired private HttpSession httpSession;

	@GetMapping("/")
    public String index(Model model) {
        return "login";
	}
	
    @PostMapping(value = "login")
    public String login(/*@ModelAttribute LoginForm loginForm,*/ Model model) {
        return "menu";
    }

}
