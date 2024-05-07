package jp.co.jdsnet.returning.webapp.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.validation.groups.Default;
import jp.co.jdsnet.base.webapp.controller.CommonOperationController;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.returning.domain.service.ReceiveEntryService;
import jp.co.jdsnet.returning.webapp.form.ReceiveEntryDetailForm;
import jp.co.jdsnet.returning.webapp.form.ReceiveEntryForm;
import jp.fintan.keel.spring.web.token.transaction.TransactionTokenCheck;
import jp.fintan.keel.spring.web.token.transaction.TransactionTokenType;
import lombok.RequiredArgsConstructor;

/**
 * 返品入力
 *
 * @author xx
 *
 */
@RequiredArgsConstructor
@Controller
@TransactionTokenCheck("ReceiveEntry")
@RequestMapping(value = "/receiveEntry")
public class ReceiveEntryController extends CommonOperationController {

  private static final String REDIRECT_INIT = "redirect:/receiveEntry";
  private static final String TEMPLATE_DIR = "receiveentry/";
  private static final String TEMPLATE_HEADER = TEMPLATE_DIR + "header";
  private static final String TEMPLATE_DETAIL = TEMPLATE_DIR + "detail";
  private static final String TEMPLATE_SUBMIT = TEMPLATE_DIR + "submit";

  private final Validator validator;
  private final ReceiveEntryService service;
  
  /**
   * 明細上限値の設定
   * @param binder
   */
  @InitBinder
  public void configureWebDataBinder(WebDataBinder binder) {
    binder.setAutoGrowCollectionLimit(512);
  }

  /**
   * 初期処理
   * @param model
   * @return
   */
  // @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
  @GetMapping()
  public String init(Model model) {
    UserInfoVO usrInfo = getUserInfo();
    model.addAttribute("receiveEntryForm",
        service.init(usrInfo.getDaikaiskbcod(), usrInfo.getUsrbun())
          .transform(ReceiveEntryForm::toForm));
    return TEMPLATE_HEADER;
  }

  // @TransactionTokenCheck
  @RequestMapping(params = "btn_changeTrncod", method = POST)
  public String changeTrncod(@ModelAttribute ReceiveEntryForm requestForm, Model model)
      throws Exception {
    model.addAttribute("receiveEntryForm",requestForm);
    return TEMPLATE_HEADER;
  }

  /**
   * 見出チェック
   * @param requestForm
   * @param errors
   * @param model
   * @return
   * @throws Exception
   */
  // @TransactionTokenCheck
  @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
  @RequestMapping(params = "btn_checkHeader", method = POST)
//  public String checkHeader(@Validated @ModelAttribute ReceiveEntryForm requestForm,
//      BindingResult result, Model model) throws Exception {
  public String checkHeader(@ModelAttribute ReceiveEntryForm requestForm,
      Errors errors, Model model) throws Exception {

    System.out.println("!!!checkHeader!!!");
    Object[] groups = createValidationGroups(requestForm.getTrncod());
    ValidationUtils.invokeValidator(validator, requestForm, errors, groups);
    if (errors.hasErrors()) {
      model.addAttribute("receiveEntryForm", requestForm);
      return TEMPLATE_HEADER;
    } else {
      try {
        model.addAttribute("receiveEntryForm",
              service.checkHeader(requestForm.toDTO(getUserInfo()))
              .transform(ReceiveEntryForm::toForm));
      } catch (Exception e) {
        model.addAttribute("errors", e.getMessage());
        return TEMPLATE_HEADER;
      }
    }
    return TEMPLATE_DETAIL;
  }

  
  private Object[] createValidationGroups(String trncod) {
    List<Object> groups = new ArrayList<>();
    switch(trncod) {
      case "260B":
        groups.add(ReceiveEntryForm.Trn260Barcode.class);
        break;
      case "262B":
        groups.add(ReceiveEntryForm.Trn262Barcode.class);
        break;
//      case "260":
//        groups.add(ReceiveEntryForm.Trn260.class);
//        break;
//      case "262":
//        groups.add(ReceiveEntryForm.Trn262.class);
//        break;
//      case "232":
//        groups.add(ReceiveEntryForm.Trn232.class);
//        break;
//      case "292":
//        groups.add(ReceiveEntryForm.Trn292.class);
//        break;
//      case "277":
//        groups.add(ReceiveEntryForm.Trn277.class);
//        break;
//      case "287":
//        groups.add(ReceiveEntryForm.Trn287.class);
//        break;
      default:
        groups.add(Default.class);
    }
    return groups.toArray();
  }

  /**
   * 明細チェック
   * @param requestForm
   * @param result
   * @param model
   * @return
   * @throws Exception
   */
  @TransactionTokenCheck
  @RequestMapping(params = "btn_checkDetail", method = POST)
  public String checkDetail(@Validated @ModelAttribute ReceiveEntryForm requestForm,
      BindingResult result, Model model) throws Exception {
    
    if (result.hasErrors()) {
      model.addAttribute("receiveEntryForm", requestForm);
      return TEMPLATE_DETAIL;
    } else {
      try {
        model.addAttribute("receiveEntryForm",
              service.checkDetail(requestForm.toDTO(getUserInfo()))
              .transform(ReceiveEntryForm::toForm));
      } catch (Exception e) {
        model.addAttribute("errors", e.getMessage());
        return TEMPLATE_DETAIL;
      }
    }
    return TEMPLATE_SUBMIT;
  }
  
  /**
   * 品番チェック(ajax)
   * @param detailForm
   * @return
   * @throws Exception
   */
  @RequestMapping(path = "/ajax", method = POST)
  @ResponseBody
  public String getHinbanAjax(@RequestBody ReceiveEntryDetailForm detailForm) throws Exception {
    detailForm = service.checkHinban(detailForm.toDTO())
        .transform(ReceiveEntryDetailForm::toForm);
    return detailForm.getAjaxReturn();
  }

  /**
   * エントリー
   * @param requestForm
   * @param result
   * @param model
   * @return
   * @throws Exception
   */
  @TransactionTokenCheck
  @RequestMapping(params = "btn_submit", method = POST)
  public String submit(@ModelAttribute ReceiveEntryForm requestForm,
      Model model) throws Exception {
    
    try {
      service.submit(requestForm.toDTO(getUserInfo()));
    } catch (Exception e) {
      model.addAttribute("errors", e.getMessage());
      return TEMPLATE_SUBMIT;
    }
    return REDIRECT_INIT;
  }
}
