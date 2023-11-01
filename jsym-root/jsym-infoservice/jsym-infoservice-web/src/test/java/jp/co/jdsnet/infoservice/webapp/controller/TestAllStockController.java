package jp.co.jdsnet.infoservice.webapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.*;

import jp.co.jdsnet.base.interceptor.AccessLogInterceptor;
import jp.co.jdsnet.base.interceptor.SessionCheckInterceptor;
import jp.co.jdsnet.infoservice.InfoServiceApplication;
import jp.co.jdsnet.infoservice.domain.dto.AllStockDTO;
import jp.co.jdsnet.infoservice.domain.service.AllStockService;

@AutoConfigureMockMvc
@SpringBootTest(classes = InfoServiceApplication.class)
public class TestAllStockController {
	@MockBean
	SessionCheckInterceptor interceptorS;
	@MockBean
	AccessLogInterceptor interceptorA;
	@BeforeEach
	void initTest() throws Exception {
		when(interceptorS.preHandle(any(), any(), any())).thenReturn(true);
		when(interceptorA.preHandle(any(), any(), any())).thenReturn(true);
	}
	
    @MockBean
    private AllStockService target;

    @Nested
	class init {
        @Autowired
        private MockMvc mockMvc;
        
	    @Test
	    void responce() throws Exception {
	    	when(target.init(anyString(), anyString())).thenReturn(AllStockDTO.builder().build());
	        this.mockMvc.perform(get("/allstock")).andDo(print())
	            .andExpect(status().isOk());
	    }
	
	    @Test
	    void setform() throws Exception {
	    	when(target.init(anyString(), anyString())).thenReturn(AllStockDTO.builder().kaiskbcod("TST").build());
	        this.mockMvc.perform(get("/allstock")).andDo(print())
	            .andExpect(model().attribute("allStockForm", hasProperty("kaiskbcod", is("TST"))));
	    }
    }
}
