package jp.co.jdsnet.infoservice.webapp.register;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.infoservice.webapp.controller.AllStockController;
import jp.co.jdsnet.infoservice.webapp.controller.HintokResultController;

@Controller
public class RegisterController {
  @Autowired
  private HttpSession httpSession;
  @Autowired
  private AllStockController allStockController;
  @Autowired
  private HintokResultController hintokResultController;

  @Value("${property.session.userInfoKey}")
  private String userInfoKey;
  @Value("${property.session.idKey}")
  private String idKey;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String register(Model model) {
    httpSession.setAttribute(idKey, httpSession.getId());
    httpSession.setAttribute(userInfoKey,
        UserInfoVO.builder()
            .usrid("JDSr-matsumura")
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
  public String allstock(Model model) throws Exception {
    return allStockController.init(model);
  }

  @RequestMapping(value = "/register/hintokResult")
  public String hintokResult(Model model) throws Exception {
    return hintokResultController.init(model);
  }

}
