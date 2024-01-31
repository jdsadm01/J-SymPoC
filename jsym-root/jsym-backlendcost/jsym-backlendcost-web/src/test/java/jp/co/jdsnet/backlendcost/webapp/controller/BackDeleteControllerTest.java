package jp.co.jdsnet.backlendcost.webapp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import jp.co.jdsnet.backlendcost.JsymBacklendcostApplication;
import jp.co.jdsnet.backlendcost.domain.dto.BackDeleteDTO;
import jp.co.jdsnet.backlendcost.domain.service.BackDeleteService;
import jp.co.jdsnet.backlendcost.webapp.form.BackDeleteForm;
import jp.co.jdsnet.base.interceptor.AccessLogInterceptor;
import jp.co.jdsnet.base.interceptor.SessionCheckInterceptor;



@AutoConfigureMockMvc
@SpringBootTest(classes = JsymBacklendcostApplication.class)
public class BackDeleteControllerTest {

  @MockBean
  SessionCheckInterceptor interceptorS;
  @MockBean
  AccessLogInterceptor interceptorA;

  @InjectMocks
  BackDeleteController backDeleteController;

  @BeforeEach
  void initTest() throws Exception {
    when(interceptorS.preHandle(any(), any(), any())).thenReturn(true);
    when(interceptorA.preHandle(any(), any(), any())).thenReturn(true);
  }

  @MockBean
  private BackDeleteService target;

  @Nested
  class init {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void responce() throws Exception {
      when(target.init(anyString(), anyString())).thenReturn(BackDeleteDTO.builder().build());
      this.mockMvc.perform(get("/backdelete")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void setform() throws Exception {
      when(target.init(anyString(), anyString()))
          .thenReturn(BackDeleteDTO.builder().kaiskbcod("TST").build());
      this.mockMvc.perform(get("/backdelete")).andDo(print())
          .andExpect(model().attribute("backDeleteForm", hasProperty("kaiskbcod", is("TST"))));


    }


  }

  @Nested
  class search {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void displayMode() throws Exception {

      String test = backDeleteController.search(testForm(), any(), any());

      assertAll("結果確認", () -> assertEquals("backdelete/detail", test, "S：照会"));

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

    }

  }

}
