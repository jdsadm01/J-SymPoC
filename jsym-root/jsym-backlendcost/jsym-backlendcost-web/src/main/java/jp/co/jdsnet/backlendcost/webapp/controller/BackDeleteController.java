package jp.co.jdsnet.backlendcost.webapp.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.jdsnet.backlendcost.domain.service.BackDeleteService;
import jp.co.jdsnet.backlendcost.webapp.copydata.BackDeleteCBData;
import jp.co.jdsnet.backlendcost.webapp.form.BackDeleteForm;
import jp.co.jdsnet.base.webapp.controller.CommonOperationController;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import lombok.RequiredArgsConstructor;

/**
 * 注残一括削除
 */

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/backdelete")
public class BackDeleteController extends CommonOperationController {

  private static final String TEMPLATE_DIR = "backdelete/";
  private static final String TEMPLATE_HEADER = TEMPLATE_DIR + "header";
  private static final String TEMPLATE_DETAIL = TEMPLATE_DIR + "detail";
  private static final String TEMPLATE_DATAENTRY = TEMPLATE_DIR + "dataentry";
  private static final String TEMPLATE_SUBMIT = TEMPLATE_DIR + "submit";
  private final BackDeleteService service;

  private final Validator validator;

  private String SEARCH = "S";
  private String DELETE = "D";



  @GetMapping()
  public String init(Model model) {
    // 画面OPENの処理

    UserInfoVO usrInfo = getUserInfo();

    // 初期化
    BackDeleteForm form = service.init("JDS", "JDS").transform(BackDeleteForm::toForm);
    model.addAttribute("radioTokcod", form.getRadioTokcod());
    form.setTokkbn("1"); // 初期化処理では単独店に設定
    model.addAttribute("backDeleteForm", form);


    // 画面遷移 フォーカス
    return TEMPLATE_HEADER;

  }

  /**
   * 見出し
   * 
   */

  @RequestMapping(params = "btn_search", method = POST)
  // public String search(@Validated @ModelAttribute BackDeleteForm requestForm, BindingResult
  // result,
  // Model model) throws Exception {
  public String search(@ModelAttribute BackDeleteForm requestForm, Errors errors,
      Model model) throws Exception {
    // 検索条件入力チェック(実行)

    ValidationUtils.invokeValidator(validator, requestForm, errors);

    // 2.注残情報取得

    if (errors.hasErrors()) {
      // エラーの場合
      model.addAttribute("radioTokcod", requestForm.getRadioTokcod());
      model.addAttribute("backDeleteForm", requestForm);
      return TEMPLATE_HEADER;
    } else {
      try {

        // 正常終了の場合
        BackDeleteForm form =
            service.search(requestForm.toDTO(getUserInfo())).transform(BackDeleteForm::toForm);

        form.setCopyData(BackDeleteCBData::new);
        model.addAttribute("radioTokcod", form.getRadioTokcod());
        model.addAttribute("backDeleteForm", form);

      } catch (Exception e) {
        model.addAttribute("errors", e.getMessage());
        System.out.println(e);
        return TEMPLATE_HEADER;
      }

    }

    if (SEARCH.equals(requestForm.getUpdkbn())) {
      // 画面遷移 フォーカス(処理区分：照会)
      return TEMPLATE_DETAIL;
    } else {
      // 画面遷移 フォーカス(処理区分：削除)
      return TEMPLATE_DATAENTRY;
    }


  }


  @RequestMapping(params = "btn_prev100search", method = POST)
  public String prev100search(@Validated @ModelAttribute BackDeleteForm requestForm,
      BindingResult result, Model model) throws Exception {

    if (result.hasErrors()) {
      // エラーの場合
      return TEMPLATE_HEADER;
    } else {
      try {

        int pageNo = requestForm.getPageNo() - 1;

        // 正常終了の場合
        BackDeleteForm form = service.prev100Search(requestForm.toDTO(getUserInfo()), pageNo)
            .transform(BackDeleteForm::toForm);
        form.setCopyData(BackDeleteCBData::new);
        model.addAttribute("radioTokcod", form.getRadioTokcod());
        model.addAttribute("backDeleteForm", form);

      } catch (Exception e) {
        model.addAttribute("errors", e.getMessage());
        return TEMPLATE_HEADER;
      }

    }

    if (SEARCH.equals(requestForm.getUpdkbn())) {
      // 画面遷移 フォーカス(処理区分：照会)
      return TEMPLATE_DETAIL;
    } else {
      // 画面遷移 フォーカス(処理区分：削除)
      return TEMPLATE_DATAENTRY;
    }
  }


  @RequestMapping(params = "btn_next100search", method = POST)
  public String next100search(@Validated @ModelAttribute BackDeleteForm requestForm,
      BindingResult result, Model model) throws Exception {

    if (result.hasErrors()) {
      // エラーの場合
      return TEMPLATE_HEADER;
    } else {
      try {

        int pageNo = requestForm.getPageNo() + 1;

        // 正常終了の場合
        BackDeleteForm form = service.next100Search(requestForm.toDTO(getUserInfo()), pageNo)
            .transform(BackDeleteForm::toForm);
        form.setCopyData(BackDeleteCBData::new);
        model.addAttribute("radioTokcod", form.getRadioTokcod());
        model.addAttribute("backDeleteForm", form);

      } catch (Exception e) {
        model.addAttribute("errors", e.getMessage());
        return TEMPLATE_HEADER;
      }

    }

    if (SEARCH.equals(requestForm.getUpdkbn())) {
      // 画面遷移 フォーカス(処理区分：照会)
      return TEMPLATE_DETAIL;
    } else {
      // 画面遷移 フォーカス(処理区分：削除)
      return TEMPLATE_DATAENTRY;
    }
  }

  @RequestMapping(params = "btn_confirm", method = POST)
  public String chkInputDeleteData(@Validated @ModelAttribute BackDeleteForm requestForm,
      BindingResult result,
      Model model) throws Exception {
    // 削除チェック処理(入力確定)

    // 画面遷移 フォーカス
    return TEMPLATE_DATAENTRY;
  }

  @RequestMapping(params = "btn_submit", method = POST)
  public String submit(@Validated @ModelAttribute BackDeleteForm requestForm, BindingResult result,
      Model model) throws Exception {
    // 送信

    try {
      service.submit(requestForm.toDTO(getUserInfo()));
    } catch (Exception e) {
      model.addAttribute("errors", e.getMessage());
      return TEMPLATE_SUBMIT;
    }
    return init(model);
  }

  @RequestMapping(params = "btn_back", method = POST)
  public String back(@Validated @ModelAttribute BackDeleteForm requestForm, BindingResult result,
      Model model) throws Exception {
    // 戻る


      try {

        int pageNo = requestForm.getPageNo() - 1;

        // 正常終了の場合
        BackDeleteForm form =
            service.back(requestForm.toDTO(getUserInfo())).transform(BackDeleteForm::toForm);
        model.addAttribute("radioTokcod", form.getRadioTokcod());
        model.addAttribute("backDeleteForm", form);

      } catch (Exception e) {
        model.addAttribute("errors", e.getMessage());
        return TEMPLATE_HEADER;


    }


    // 画面遷移 フォーカス
    return TEMPLATE_HEADER;

  }

  @RequestMapping(params = "btn_initial", method = POST)
  public String initPartOfForm(@Validated @ModelAttribute BackDeleteForm requestForm,
      BindingResult result,
      Model model) throws Exception {
    // 初期

    UserInfoVO usrInfo = getUserInfo();
    // 初期化
    BackDeleteForm form = service.initPartOfForm("JDS", "JDS").transform(BackDeleteForm::toForm);
    model.addAttribute("radioTokcod", form.getRadioTokcod());
    form.setTokkbn("1"); // 初期化処理では単独店に設定
    model.addAttribute("backDeleteForm", form);

    // 画面遷移 フォーカス
    return TEMPLATE_HEADER;

  }


}

