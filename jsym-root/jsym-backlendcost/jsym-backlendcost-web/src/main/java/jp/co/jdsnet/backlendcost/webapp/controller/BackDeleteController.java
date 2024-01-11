package jp.co.jdsnet.backlendcost.webapp.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.jdsnet.backlendcost.domain.service.BackDeleteService;
import jp.co.jdsnet.backlendcost.webapp.copydata.BackDeleteCBData;
import jp.co.jdsnet.backlendcost.webapp.form.BackDeleteForm;
import jp.co.jdsnet.base.webapp.controller.CommonOperationController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/backlendcost")
public class BackDeleteController extends CommonOperationController {

  private static final String TEMPLATE_DIR = "backdelete/";
  private static final String TEMPLATE_SEARCH = TEMPLATE_DIR + "header";
  private final BackDeleteService service;

  @GetMapping()
  public String init(Model model) {
    // 画面OPENの処理

    // サービス時間チェック

    // 初期化
    BackDeleteForm form = service.init("JDS", "JDS").transform(BackDeleteForm::toForm);
    model.addAttribute("BackDeleteForm", form);

    // 画面遷移 フォーカス
    return TEMPLATE_SEARCH;

  }

  @RequestMapping(params = "btn_search", method = POST)
  public String search(@Validated @ModelAttribute BackDeleteForm requestForm, BindingResult result,
      Model model) throws Exception {
    // 検索条件入力チェック(実行)

    if (result.hasErrors()) {
      // エラーの場合
    } else {
      // 正常終了の場合
      BackDeleteForm form =
          service.search(requestForm.toDTO(getUserInfo())).transform(BackDeleteForm::toForm);
      form.setCopyData(BackDeleteCBData::new);
      model.addAttribute("backDeleteForm", form);
    }

    // 画面遷移 フォーカス
    return TEMPLATE_SEARCH;
  }



  @RequestMapping(params = "btn_next100search", method = POST)
  public String next100search(@Validated @ModelAttribute BackDeleteForm requestForm,
      BindingResult result, Model model) throws Exception {
    // 次100件

    // 画面遷移 フォーカス
    return TEMPLATE_SEARCH;
  }

  @RequestMapping(params = "btn_confirm", method = POST)
  public String chkInputDeleteData(@Validated @ModelAttribute BackDeleteForm requestForm,
      BindingResult result,
      Model model) throws Exception {
    // 削除チェック処理(入力確定)

    // 画面遷移 フォーカス
    return TEMPLATE_SEARCH;
  }

  @RequestMapping(params = "btn_submit", method = POST)
  public String submit(@Validated @ModelAttribute BackDeleteForm requestForm, BindingResult result,
      Model model) throws Exception {
    // 送信

    // 画面遷移 フォーカス
    return TEMPLATE_SEARCH;

  }

  @RequestMapping(params = "btn_back", method = POST)
  public String back(@Validated @ModelAttribute BackDeleteForm requestForm, BindingResult result,
      Model model) throws Exception {
    // 戻る

    // 画面遷移 フォーカス
    return TEMPLATE_SEARCH;

  }

  @RequestMapping(params = "btn_initial", method = POST)
  public String initPartOfForm(@Validated @ModelAttribute BackDeleteForm requestForm,
      BindingResult result,
      Model model) throws Exception {
    // 初期

    // 画面遷移 フォーカス
    return TEMPLATE_SEARCH;

  }

}

