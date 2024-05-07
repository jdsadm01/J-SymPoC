package jp.co.jdsnet.base.interceptor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.base.webapp.controller.InitController;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.common.domain.mapper.control.LoginControlMapper;

@WebMvcTest(value = InitController.class)
public class SessionCheckInterceptorTest {

  private MockMvc mockMvc;
  @Mock
  private HttpSession httpSession;
  @Mock
  private LoginControlMapper loginControlMapper;

  @Value("${property.session.userInfoKey}")
  private String userInfoKey;

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(new InitController(httpSession, loginControlMapper))
        .addInterceptors(new SessionCheckInterceptor()).build();
  }

  @Test
  void Session情報未保持() throws Exception {
    HttpServletRequest request;
    request = new MockHttpServletRequest();
    request.setAttribute(userInfoKey, UserInfoVO.builder().build());
    RequestContextHolder.setRequestAttributes(new ServletWebRequest(request));
    mockMvc.perform(get("/init"))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.UNAUTHORIZED.value()));
  }
}
