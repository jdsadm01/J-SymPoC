package jp.co.jdsnet.backlendcost.webapp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.FlashMap;
import jp.co.jdsnet.backlendcost.JsymBacklendcostApplication;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
import jp.co.jdsnet.backlendcost.domain.service.BackDeleteService;
import jp.co.jdsnet.backlendcost.domain.service.implement.BackDeleteServiceImpl;
import jp.co.jdsnet.backlendcost.webapp.form.BackDeleteForm;
import jp.co.jdsnet.base.interceptor.AccessLogInterceptor;
import jp.co.jdsnet.base.interceptor.SessionCheckInterceptor;


@AutoConfigureMockMvc
@SpringBootTest(classes = JsymBacklendcostApplication.class)
public class BackDeleteControllerTest {

  private MockMvc mockmvc;

  @Autowired
  BackDeleteController targetController;

  @MockBean
  SessionCheckInterceptor interceptorS;
  @MockBean
  AccessLogInterceptor interceptorA;

  @InjectMocks
  BackDeleteController backDeleteController;

  @Mock
  ValidationUtils validationUtils;

  @BeforeEach
  void initTest() throws Exception {
    when(interceptorS.preHandle(any(), any(), any())).thenReturn(true);
    when(interceptorA.preHandle(any(), any(), any())).thenReturn(true);
    mockmvc = MockMvcBuilders.standaloneSetup(targetController).build();
  }

  @MockBean
  private BackDeleteService targetService;

  @Nested
  class init {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void responce() throws Exception {
      when(targetService.init(anyString(), anyString()))
          .thenReturn(BackDeleteDTO.builder().build());
      this.mockMvc.perform(get("/backdelete")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void setform() throws Exception {
      when(targetService.init(anyString(), anyString()))
          .thenReturn(BackDeleteDTO.builder().kaiskbcod("TST").build());
      this.mockMvc.perform(get("/backdelete")).andDo(print())
          .andExpect(model().attribute("backDeleteForm", hasProperty("kaiskbcod", is("TST"))));

    }

  }

  @Nested
  class search {

    @Test
    void 照会画面に遷移する() throws Exception {
      BackDeleteDTO testDto = BackDeleteDTO.builder().updkbn("S").nextGamenMode("submit").build();
      BackDeleteForm detailform = testForm();
      when(targetService.search(testDto)).thenReturn(testDto);

      mockmvc.perform(post("/backdelete").sessionAttr("BackDeleteForm", detailform))
          .param("btn_search", "")
          .andExpect(view().name("/"))
          .andExpect(model().hasNoErrors()).andReturn();

    }

  }

  BackDeleteForm testForm() {
    BackDeleteDTO testDto = BackDeleteDTO.builder().updkbn("S").nextGamenMode("submit").build();

    return BackDeleteForm.toForm(testDto);
  }

  @Nested
  class chkInputDeleteData {

    @Test
    void displayMode() throws Exception {

      targetController = new BackDeleteController(targetService, any());

      BackDeleteServiceImpl mockService = new BackDeleteServiceImpl(any(), any(), any(), any());

      ResultActions results = mockmvc.perform(get("/backdelete")).andDo(print())
          .andExpect(model().attribute("backDeleteForm", hasProperty("kaiskbcod", is("TST"))));

      FlashMap flashMap = results.andReturn().getFlashMap();

      mockmvc = MockMvcBuilders.standaloneSetup(targetController).build();

      // when(targetService.chkInputDeleteData(any()))
      // .thenReturn(BackDeleteDTO.builder().nextGamenMode("submit").build());
      //
      // String test = backDeleteController.chkInputDeleteData(testForm(), any(), any());
      //
      // assertAll("結果確認", () -> assertEquals("backdelete/submit", test, "送信前"));

    }

  }

}
