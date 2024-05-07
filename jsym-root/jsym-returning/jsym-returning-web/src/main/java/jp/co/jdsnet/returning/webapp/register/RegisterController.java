package jp.co.jdsnet.returning.webapp.register;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;

@Controller
public class RegisterController {
  @Autowired
  private HttpSession httpSession;
  @Autowired
  private HttpServletResponse response;

  @Value("${property.session.userInfoKey}")
  private String userInfoKey;
  @Value("${property.session.idKey}")
  private String idKey;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String register(Model model) throws Exception {
    // PrintWriter out = response.getWriter();
    // response.setContentType("text/html");
    // response.setCharacterEncoding("UTF-8");
    // test(out);
    // out.println("<script type=\"text/javascript\">");
    // out.println("alert('User Account already Exist !!');");
    // out.println("</script>");

    httpSession.setAttribute(idKey, httpSession.getId());
    httpSession.setAttribute(userInfoKey,UserInfoVO.builder()
        .usrid("JDSr-matsumura")
        .usrnm("レジスタユーザー")
        .daikaiskbcod("JDS")
        .kaiskbcod("JDS")
        .usrbun("JDS")
        .bshcod("C3")
        .mnugrpcod("100")
        .loginDateTime(LocalDateTime.now())
        .lastAccessTime(LocalDateTime.now()).build());
    return "register/menu";
  }

  private void test(PrintWriter pw) {
    StringBuilder sb = new StringBuilder();
    sb.append("<html>").append("\n");
    sb.append("<head>").append("\n");
    sb.append("<title>認証</title>").append("\n");
    // sb.append("<script type=\"text/javascript\">").append("\n");
    // sb.append("window.prompt(\"ユーザー名を入力してください\", \"\");").append("\n");
    // sb.append("window.prompt(\"パスワードを入力してください\", \"\");").append("\n");
    // sb.append("</script>").append("\n");
    sb.append("</head>").append("\n");
    sb.append("<body>").append("\n");
    sb.append("ユーザー名<br>").append("\n");
    sb.append("<input type='text' name='usrid'/>").append("\n");
    sb.append("パスワード<br>").append("\n");
    sb.append("<input type='password' name='pass'/>").append("\n");
    sb.append("<body>").append("\n");
    sb.append("<body>").append("\n");
    sb.append("</body>").append("\n");
    sb.append("</html>").append("\n");

    pw.print(sb.toString());
    pw.flush();
  }
  @RequestMapping(value = "/register/receiveEntry")
  public String reciveentry(Model model) {
    return "redirect:/receiveEntry";
  }
}
