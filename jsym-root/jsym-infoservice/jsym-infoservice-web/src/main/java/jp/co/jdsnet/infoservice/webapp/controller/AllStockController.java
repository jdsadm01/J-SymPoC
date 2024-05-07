package jp.co.jdsnet.infoservice.webapp.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.jdsnet.base.exception.ApplicationExceptions;
import jp.co.jdsnet.base.webapp.controller.CommonOperationController;
import jp.co.jdsnet.infoservice.domain.service.AllStockService;
import jp.co.jdsnet.infoservice.webapp.copydata.AllStockCBData;
import jp.co.jdsnet.infoservice.webapp.form.AllStockForm;
import jp.fintan.keel.spring.web.token.transaction.TransactionTokenCheck;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@TransactionTokenCheck("AllStock")
@RequestMapping(value = "/allstock")
public class AllStockController extends CommonOperationController {

  private static final String TEMPLATE_DIR = "allstock/";
  private static final String TEMPLATE_SEARCH = TEMPLATE_DIR + "search";

  private final AllStockService service;

  // private final MessageSource messageSource;

  @GetMapping()
  public String init(Model model) throws Exception {
    try {
      AllStockForm form = service.init(getUserInfo().getDaikaiskbcod(), getUserInfo().getUsrbun())
          .transform(AllStockForm::toForm);
      model.addAttribute("allStockForm", form);
    } catch (ApplicationExceptions e) {
      List<String> errors =
          e.getExceptions().entrySet().stream().map(el -> el.getValue().getMessage()).toList();
      model.addAttribute("errors", errors);
      model.addAttribute("allStockForm", AllStockForm.builder().build());
    } catch (Exception e) {
      model.addAttribute("errors", e.getMessage());
      throw e;
    }
    return TEMPLATE_SEARCH;
  }

  @RequestMapping(params = "btn_search", method = POST)
  public String search(@Validated @ModelAttribute AllStockForm requestForm, BindingResult result,
      Model model) throws Exception {
    if (!result.hasErrors()) {
      try {
        AllStockForm form =
            service.search(requestForm.toDTO(getUserInfo())).transform(AllStockForm::toForm);
        form.setCopyData(AllStockCBData::new);
        model.addAttribute("allStockForm", form);
      } catch (ApplicationExceptions e) {
        model.addAttribute("allStockForm", requestForm);
        e.setErrorsForBindingResult(result);
        // e.getExceptions().forEach((k, v) -> {
        // FieldError fieldError = new FieldError(result.getObjectName(), k, v.getMessage());
        // result.addError(fieldError);
        // });
      } catch (Exception e) {
        model.addAttribute("errors", e.getMessage());
        throw e;
      }
    }
    return TEMPLATE_SEARCH;
  }
}
