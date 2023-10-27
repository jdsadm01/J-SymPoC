package jp.co.jdsnet.infoservice.webapp.register;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.infoservice.webapp.controller.AllStockController;

@Controller
public class RegisterController {
    @Autowired
    private HttpSession httpSession;
	@Autowired
	private AllStockController controller;

    @Value("${property.session.userInfoKey}")
    private String userInfoKey;
    @Value("${property.session.lockTime}")
    private int lockTime;
    @Value("${property.userMapKey.time}")
    private String sessionTimeKey;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		ConcurrentHashMap<String,String> userMap = new ConcurrentHashMap<String,String>();
		userMap.put("usrid", "test.userid");
		userMap.put("usrnm", "テストレジスタ");
		userMap.put("daikaiskbcod", "JDS");
		userMap.put("kaiskbcod", "JDS");
		userMap.put("usrbun", "JDS");
		userMap.put(sessionTimeKey, LocalTime.now().plusMinutes(lockTime).format(DateTimeFormatter.ofPattern("HHmmss")));
		httpSession.setAttribute(userInfoKey, userMap);
        return "register/menu";
	}

	@RequestMapping(value = "/register/allstock")
	public String allstock(Model model) {
		return controller.init(model);
    }
	
}
