package jp.co.jdsnet.base.webapp.controller;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InitController {
    @Autowired
    private HttpSession httpSession;
//	@Autowired
//	private UserGetSharedService userGetService;
    
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model,@RequestParam("name") String name,@RequestParam("gmn") String gmn) {
//		if (httpSession == null) {
//			log.error("URL不正リクエスト");
//			return "500";
//		}
//		log.info("parameter="+name);
//		String sessionid = userGetService.getSessionId(name);
//		log.info("info.sessionid="+sessionid);

//		ServletContext homeContext = httpSession.getServletContext().getContext("/jsym-home");
//		ConcurrentHashMap<String,String> loginMap = (ConcurrentHashMap<String,String>)homeContext.getAttribute(sessionid);
//		log.info("userId:"+loginMap.get("usrid")+",userName:"+loginMap.get("usrnm")+",sessiontime:"+loginMap.get("sessiontime"));
//		loginMap.put("sessiontime", "180000");
//		homeContext.setAttribute(sessionid, loginMap);
//		httpSession.setAttribute("loginUser", loginMap);

        return "redirect:/"+gmn;
    }
}
