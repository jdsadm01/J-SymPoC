package jp.co.jdsnet.base.webapp.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.common.domain.entity.control.LoginControlEntity;
import jp.co.jdsnet.common.domain.mapper.control.LoginControlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class InitController {
  @Value("${property.session.userInfoKey}")
  private String userInfoKey;
  @Value("${property.session.contextName}")
  private String contextName;
  @Value("${property.session.idKey}")
  private String idKey;

  private final HttpSession httpSession;
  private final LoginControlMapper loginControlMapper;

  @RequestMapping(value = "/init", method = RequestMethod.GET)
  public String init(Model model, @RequestParam("name") String name,
      @RequestParam("gmn") String gmn) {

    LoginControlEntity loginControlEntity =
        loginControlMapper.select(LoginControlEntity.builder().usrid(name).build());
    if (Objects.isNull(loginControlEntity)) {
      log.error("ログインしていない");
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
    String sessionid = loginControlEntity.getSessionid();
    log.info("access user='" + name + "' home's sessionid='" + sessionid + "'");

    UserInfoVO usrInfo = UserInfoVO.builder().build();
    try {
      @SuppressWarnings("unchecked")
      ConcurrentHashMap<String, String> userMap = (ConcurrentHashMap<String, String>) httpSession
          .getServletContext().getContext(contextName).getAttribute(sessionid);
      if (Objects.isNull(userMap)) {
        log.error("ユーザー情報無し");
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
      }
      BeanUtils.populate(usrInfo, userMap);
    } catch (IllegalAccessException | InvocationTargetException e) {
      log.error("ユーザー情報不整合：" + e.getMessage());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    log.info("usrid=" + usrInfo.getUsrid() + ",usrnm=" + usrInfo.getUsrnm() + ",lastlogin="
        + usrInfo.getLoginDateTime() + ",lasttime=" + usrInfo.getLastAccessTime());

    httpSession.setAttribute(idKey, sessionid);
    httpSession.setAttribute(userInfoKey, usrInfo);

    return "redirect:/" + gmn;
  }

}
