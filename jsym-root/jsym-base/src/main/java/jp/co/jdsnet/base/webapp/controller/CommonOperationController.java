package jp.co.jdsnet.base.webapp.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.base.support.SessionCheckUtility;
import jp.co.jdsnet.base.webapp.parts.UserConfirmModel;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;

public abstract class CommonOperationController {

  @Autowired
  private HttpSession httpSession;
  @Autowired
  private SessionCheckUtility sessionCheckUtility;

  @Value("${property.session.userInfoKey}")
  private String userInfoKey;

  protected UserInfoVO getUserInfo() {
    return (UserInfoVO) httpSession.getAttribute(userInfoKey);
  }

  @RequestMapping(path = "/checksession", method = POST)
  @ResponseBody
  public String checkSession() {
    System.out.println("!!!checkSession!!!");
    int statuscode = HttpStatus.OK.value();
    try {
      sessionCheckUtility.checkSession(getUserInfo());
    } catch (ResponseStatusException e) {
      statuscode = e.getStatusCode().value();
    }
    return String.valueOf(statuscode);
  }

  @RequestMapping(path = "/confirmuser", method = POST)
  @ResponseBody
  public String confirmUser(@RequestBody UserConfirmModel model) {
    System.out.println("!!!confirmuser!!!");
    System.out.println(
        "usrid=" + model.getUsrid() + ",pwd=" + model.getPwd() + ",count=" + model.getCount());
    
    UserInfoVO userInfo = getUserInfo();
    boolean isOk = (userInfo.getEnyusrid().equals(model.getUsrid()))
        && (userInfo.getPwd().equals(model.getPwd()));
    /*
    if(!isOk) {
      int misscount = (Integer)httpSession.getAttribute("misscount");
      httpSession.setAttribute("misscount", misscount+1);
      return "NG";
    }
    return "OK";
    */
    int misscount = Integer.parseInt(model.getCount());
    if (misscount > 1) {
      userInfo.setLastAccessTime(LocalDateTime.now());
      httpSession.setAttribute(userInfoKey, userInfo);
      misscount = 0;
    } else {
      misscount += 1;
    }
    System.out.println("misscount=" + misscount);
    return String.valueOf(misscount);
  }
}
