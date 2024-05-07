package jp.co.jdsnet.master.webapp.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.jdsnet.base.webapp.controller.CommonOperationController;
import jp.co.jdsnet.master.domain.service.NohsakEntryService;
import jp.co.jdsnet.master.webapp.form.NohsakEntryForm;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author xx
 *
 */
@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/nohsakEntry")
public class NohsakEntryController extends CommonOperationController {

  private static final String TEMPLATE_DIR = "nohsakentry/";
  private static final String TEMPLATE_SEARCH = TEMPLATE_DIR + "search";
  private static final String TEMPLATE_INPUT = TEMPLATE_DIR + "input";
  private static final String TEMPLATE_SEND = TEMPLATE_DIR + "send";

  private final NohsakEntryService service;

  @GetMapping()
  public String init(Model model) {
    try {
      model.addAttribute("nohsakEntryForm",
          service.init(getUserInfo()).transform(NohsakEntryForm::toForm));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return TEMPLATE_SEARCH;
  }

  @RequestMapping(params = "btn_changePrckbn", method = POST)
  public String changeprckbn(@ModelAttribute NohsakEntryForm requestForm, Model model)
      throws Exception {
    model.addAttribute("nohsakEntryForm", requestForm);
    return TEMPLATE_SEARCH;
  }

  @RequestMapping(params = "btn_search_tok", method = POST)
  public String searchNoh(@ModelAttribute NohsakEntryForm requestForm, Model model)
      throws Exception {
    try {
      model.addAttribute("nohsakEntryForm",
          service.searchByTokcod(requestForm.toDTO(getUserInfo()))
              .transform(NohsakEntryForm::toForm));
    } catch (Exception e) {
      e.printStackTrace();
    }

    if ("A".equals(requestForm.getPrckbn()) || "U".equals(requestForm.getPrckbn())) {
      return TEMPLATE_INPUT;
    } else if ("D".equals(requestForm.getPrckbn())) {
      return TEMPLATE_SEND;
    } else {
      return TEMPLATE_SEARCH;
    }
  }

  @RequestMapping(params = "btn_search_noh", method = POST)
  public String searchTok(@ModelAttribute NohsakEntryForm requestForm, Model model)
      throws Exception {
    try {
      model.addAttribute("nohsakEntryForm", service
          .searchByGkyTokcod(requestForm.toDTO(getUserInfo())).transform(NohsakEntryForm::toForm));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return TEMPLATE_SEARCH;
  }

  @RequestMapping(params = "btn_checkDetail", method = POST)
  public String checkDetail(@ModelAttribute NohsakEntryForm requestForm, Model model)
      throws Exception {
    try {
      model.addAttribute("nohsakEntryForm",
          service.checkDetail(requestForm.toDTO(getUserInfo())).transform(NohsakEntryForm::toForm));
    } catch (Exception e) {
      return TEMPLATE_INPUT;
    }
    return TEMPLATE_SEND;
  }

  @RequestMapping(params = "btn_update", method = POST)
  public String update(@ModelAttribute NohsakEntryForm requestForm, Model model) throws Exception {
    try {
      model.addAttribute("nohsakEntryForm",
          service.update(requestForm.toDTO(getUserInfo())).transform(NohsakEntryForm::toForm));
    } catch (Exception e) {
      return TEMPLATE_SEND;
    }
    return init(model);
  }

}
