package jp.co.jdsnet.infoservice.webapp.register;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.common.domain.vo.UserInfoVO;
import jp.co.jdsnet.infoservice.webapp.controller.AllStockController;

@Controller
public class RegisterController {
    @Autowired
    private HttpSession httpSession;
	@Autowired
	private AllStockController controller;

    @Value("${property.session.userInfoKey}")
    private String userInfoKey;
    @Value("${property.session.idKey}")
    private String idKey;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
    	httpSession.setAttribute(idKey, httpSession.getId());
		httpSession.setAttribute(userInfoKey, 
				UserInfoVO.builder()
	    		.usrid("test.userid")
	    		.usrnm("レジスタユーザー")
	    		.daikaiskbcod("JDS")
	    		.kaiskbcod("JDS")
	    		.usrbun("JDS")
	    		.mnugrpcod("100")
	    		.lastAccessTime(LocalDateTime.now())
	    		.build());
        return "register/menu";
	}

	@RequestMapping(value = "/register/allstock")
	public String allstock(Model model) {
		return controller.init(model);
    }
	
}
