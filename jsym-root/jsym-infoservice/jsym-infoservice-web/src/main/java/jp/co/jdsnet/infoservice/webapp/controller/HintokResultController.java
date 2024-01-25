package jp.co.jdsnet.infoservice.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.jdsnet.base.webapp.controller.CommonOperationController;
import jp.co.jdsnet.infoservice.webapp.form.HintokResultDetailForm;
import jp.co.jdsnet.infoservice.webapp.form.HintokResultForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/hintokResult")
public class HintokResultController extends CommonOperationController {

  private static final String TEMPLATE_DIR = "hintokResult/";
  private static final String TEMPLATE_SEARCH = TEMPLATE_DIR + "search2";


  // private final MessageSource messageSource;

  @GetMapping()
  public String init(Model model) {
    List<HintokResultDetailForm> detailList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      detailList.add(HintokResultDetailForm.builder().tokcod("0000000" + i).toknm("デモ得意先 亀有店")
          .share(24.5).dendte(240123).urisuu(i * 10).urikin(i * 1000).hpnsuu(i * 1).hpnkin(i * 100)
          .netsuu((i * 10) - (i * 1)).netkin((i * 1000) - (i * 100)).build());
    }
    HintokResultForm form = HintokResultForm.builder().kaiskbcod("JDS").kknfrm("231201")
        .kknto("240110").dendtefrm("231101").dendteto("240101").prctype("期間で合算").resultdisp("すべて表示")
        .stenyo("集約店").inputtype("直接入力").tokcod("00036365").toknm("デモ得意先 渋谷店").urikin(118924)
        .urisuu(112).hpnsuu(0).hpnkin(0).netsuu(112).netkin(118924).detailList(detailList).build();

    model.addAttribute("hintokResultForm", form);
    return TEMPLATE_SEARCH;
  }
}
