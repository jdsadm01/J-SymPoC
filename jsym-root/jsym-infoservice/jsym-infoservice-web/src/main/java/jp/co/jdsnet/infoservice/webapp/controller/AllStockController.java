package jp.co.jdsnet.infoservice.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import jp.co.jdsnet.base.webapp.controller.CommonOperationController;
import jp.co.jdsnet.infoservice.domain.service.AllStockService;
import jp.co.jdsnet.infoservice.webapp.copydata.AllStockCBData;
//import jp.co.jdsnet.infoservice.webapp.copydata.AllStockCBData;
import jp.co.jdsnet.infoservice.webapp.form.AllStockForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/allstock")
public class AllStockController extends CommonOperationController {

	private final String TEMPLATE_DIR = "allstock/";
	private final String TEMPLATE_SEARCH = TEMPLATE_DIR + "search";
	
	private final AllStockService service;

//	private final MessageSource messageSource;

	@GetMapping()
	public String init(Model model) {
		AllStockForm form = service.init("JDS","JAR").transform(AllStockForm::toForm);
		model.addAttribute("allStockForm", form);
		return TEMPLATE_SEARCH;
	}

	@RequestMapping(params = "btn_search", method = POST)
	public String search(@Validated @ModelAttribute AllStockForm requestForm, BindingResult result, Model model) {
		System.out.println("pass search method");
		if(result.hasErrors()) {
//			model.addAttribute("validationError",
//					result.getFieldErrors().stream()
//					.map(e -> e.getDefaultMessage())
//					.collect(Collectors.toList()));
		} else {
			try {
				AllStockForm form = service.search(requestForm.toDTO(getUserInfo())).transform(AllStockForm::toForm);
				form.setCopyData(AllStockCBData::new);
				model.addAttribute("allStockForm", form);
			} catch(Exception e) {
				model.addAttribute("errors",e.getMessage());
			}
		}
		return TEMPLATE_SEARCH;
	}
}
