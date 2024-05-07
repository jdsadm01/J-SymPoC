package jp.co.jdsnet.infoservice.domain.service.implement;

import static java.util.stream.Collectors.toList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.stereotype.Service;
import jp.co.jdsnet.base.exception.ApplicationExceptions;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.KaishaEntity;
import jp.co.jdsnet.common.domain.entity.menu.EventEntity.Gmnkbn;
import jp.co.jdsnet.common.domain.entity.soko.ZaikoJokenEntity;
import jp.co.jdsnet.common.domain.entity.zaiko.AzaikoEntity;
import jp.co.jdsnet.common.domain.mapper.hatchu.HatchuMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaMapper;
import jp.co.jdsnet.common.domain.mapper.soko.ZaikoJokenMapper;
import jp.co.jdsnet.common.domain.mapper.uriagejisseki.EigyoshobetsuHinbanUriageMapper;
import jp.co.jdsnet.common.domain.mapper.zaiko.AzaikoMapper;
import jp.co.jdsnet.common.domain.vo.EigyoshoSokoGroupVo;
import jp.co.jdsnet.common.domain.vo.HikiateKanosuuVo;
import jp.co.jdsnet.common.logic.CommonCheckSharedService;
import jp.co.jdsnet.common.logic.HikiateKanoSuuCalculateService;
import jp.co.jdsnet.common.logic.KaishaRelatedSharedService;
import jp.co.jdsnet.common.logic.KigbngRelatedSharedService;
import jp.co.jdsnet.common.utils.GlobalConstants.Rmcod;
import jp.co.jdsnet.common.utils.GlobalConstants.Trncod;
import jp.co.jdsnet.infoservice.domain.dto.AllStockDTO;
import jp.co.jdsnet.infoservice.domain.dto.AllStockDetailDTO;
import jp.co.jdsnet.infoservice.domain.service.AllStockService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AllStockServiceImpl implements AllStockService {

  private final KaishaMapper kaishaMapper;
  private final EigyoshobetsuHinbanUriageMapper eigyoshobetsuHinbanUriageMapper;
  private final HatchuMapper hatchuMapper;
  private final AzaikoMapper azaikoMapper;
  private final ZaikoJokenMapper zaikoJokenMapper;

  private final CommonCheckSharedService commonCheckSharedService;
  private final KigbngRelatedSharedService kigbngCheckSharedService;
  private final KaishaRelatedSharedService kaishaRelatedSharedService;
  private final HikiateKanoSuuCalculateService kanosuuCalcurateService;

  public AllStockDTO init(String daikaiskbcod, String usrbun) throws Exception {
    checkServiceTime(daikaiskbcod, usrbun, "001", Gmnkbn.ServiceTimeCheck);

    boolean isFavorite = false;
    List<String> lst = kaishaMapper.getDaikaiskbcodList(usrbun).stream().sorted().toList();

    return AllStockDTO.builder()
        .daikaiskbcodList(lst)
        .isFavoriteAuthority(isFavorite).build();
  }

  public AllStockDTO search(AllStockDTO dto) throws Exception {
    checkServiceTime(dto.getUserInfo().getDaikaiskbcod(), dto.getUserInfo().getUsrbun(), "001",
        Gmnkbn.Search);

    // 権限チェック
    boolean isFavorite = false;

    try {

      KaishaEntity kaishaEntity =
          kaishaMapper.select(KaishaEntity.builder().kaiskbcod(dto.getKaiskbcod()).build());

      // 品番チェック
      HinbanEntity hinbanEntity = getHinban(kaishaEntity.getDaikaiskbcod(), dto.getKigbng());
      // 売上累計取得
      int urisurrui = eigyoshobetsuHinbanUriageMapper
          .getUrisurruiSummary(hinbanEntity.getDaikaiskbcod(), hinbanEntity.getKigbng());

      // ワーニング
      Map<String, Boolean> w_warning = new HashMap<>();
      w_warning.put("isSyaStop", false);
      w_warning.put("isChzFka", false);
      setSykkaStopChzBadByTomRak(hinbanEntity.getTomrakcod(), w_warning);

      // 発注情報取得

      // 出荷制限取得

      // 在庫情報取得
      List<EigyoshoSokoGroupVo> eigSkoList = kaishaRelatedSharedService.getEigSkoGrpList(
          kaishaEntity.getDaikaiskbcod(), kaishaEntity.getKaiskbcod(), "VHJ002", "1", "1");

      List<AllStockDetailDTO> detail = eigSkoList.stream().map(t -> {
        AzaikoEntity azaikoEntity = azaikoMapper.selectSokoSummary(hinbanEntity.getDaikaiskbcod(),
            hinbanEntity.getKigbng(), t.getSkocodList());

        // 可能数取得
        HikiateKanosuuVo vo = kanosuuCalcurateService.getHatKnoSuu(kaishaEntity.getDaikaiskbcod(),
            hinbanEntity.getKigbng(),
            t.getSkocodList().toArray(new String[t.getSkocodList().size()]), Trncod.TSUJO_URIAGE,
            Rmcod.SHITEINASHI, "PCH".equals(kaishaEntity.getDaikaiskbcod()));

        int syaknosuu = vo.getKnosuuSum();

        ZaikoJokenEntity zaikojokenEntity = zaikoJokenMapper
            .select(ZaikoJokenEntity.builder().daikaiskbcod(hinbanEntity.getDaikaiskbcod())
                .kigbng(hinbanEntity.getKigbng()).skocod(t.getSkogrpcod()).build());
        // 在庫条件が取得できなかった時の処理
        if (Objects.isNull(zaikojokenEntity)) {
          // 倉庫グループだから取得できなかった
          zaikojokenEntity = ZaikoJokenEntity.builder().build();

          // 倉庫コードでレコードがなかった
          // 前の倉庫の出荷コードとC直をセットする
        }
        // 出荷コードの判別
        // ・・・

        return AllStockDetailDTO.builder().hjinm2(t.getSkohjinm())
            .syacod(zaikojokenEntity.getSyacod()).cchhinkbn(zaikojokenEntity.getCchhinkbn())
            .zaisur(azaikoEntity.getZaisur()).syaknosur(syaknosuu)
            .zaikhokhasur(azaikoEntity.getZaikhokhasur()).chzkhasur(azaikoEntity.getChzkhasur())
            .sinjuckhasur(azaikoEntity.getSinjuckhasur()).sinsyasur(azaikoEntity.getSinsyasur())
            .sekzansur(azaikoEntity.getSekzansur()).kdazansur(azaikoEntity.getKdazansur())
            .ykesyakhasur(azaikoEntity.getYkesyakhasur()).todjucsur(azaikoEntity.getTodjucsur())
            .todsyasur(azaikoEntity.getTodsyasur()).tomjucsur(azaikoEntity.getTomjucsur())
            .tomsyasur(azaikoEntity.getTomsyasur()).build();
      }).collect(toList());

      AllStockDTO ret = dto.toBuilder() // dtoを複製して必要な項目を置き換える
          .kigbng(hinbanEntity.getKigbng()).hjihnb(hinbanEntity.getHjihnb())
          .artnm(hinbanEntity.getArtnm()).titnm(hinbanEntity.getTitnm())
          .hbidte(hinbanEntity.getHbidte()).setsuu(hinbanEntity.getSetsuu())
          .znupri(hinbanEntity.getZnupri()).skrtanipn(setSkrtanipn(hinbanEntity))
          .ketcod(hinbanEntity.getKetcod()).mngflg(hinbanEntity.getMngflg())
          .rhbhnb(hinbanEntity.getRhbhnb()).tomrakcod(hinbanEntity.getTomrakcod())
          .uriruisur(urisurrui).detailList(detail).build();
      return ret;

    } catch (Exception e) {
      ApplicationExceptions aes = new ApplicationExceptions();
      aes.add("kigbng", e);
      aes.add("test", new NoSuchElementException("testError Message!"));
      throw aes;
    }
  }

  private void setSykkaStopChzBadByTomRak(String tomrakcod, Map<String, Boolean> w_warning) {
    switch (tomrakcod.trim()) {
      case ("D"):
        w_warning.replace("isChzFka", true);
        break;
      case ("E"):
      case ("F"):
      case ("FF"):
        w_warning.replace("isSyaStop", true);
        break;
      default:
    }
  }

  private double setSkrtanipn(HinbanEntity hinbanEntity) {
    if ("CO ".equals(hinbanEntity.getDaikaiskbcod())
        || "FDI".equals(hinbanEntity.getDaikaiskbcod())
        || "K  ".equals(hinbanEntity.getDaikaiskbcod())
        || "VAP".equals(hinbanEntity.getDaikaiskbcod())) {
      return hinbanEntity.getSkrtanipn();
    } else {
      return 0d;
    }
  }

  private HinbanEntity getHinban(String daikaiskbcod, String kigbng) throws Exception {
    // 品番チェック
    HinbanEntity hinbanEntity = kigbngCheckSharedService.getHinban(daikaiskbcod, kigbng);
    if ("D ".equals(hinbanEntity.getUpdkbn())) {
      throw new NoSuchElementException("削除済みです。");
    }
    return hinbanEntity;
  }

  private void checkServiceTime(String daikaiskbcod, String usrbun, String gmnseq,
      Gmnkbn gmnkbn) throws Exception {
    CommonCheckSharedService.ServiceTime check =
        commonCheckSharedService.checkServiceTime(daikaiskbcod, usrbun, "VHJ002", gmnseq, gmnkbn);
    if (CommonCheckSharedService.ServiceTime.ONLINE != check) {
      ApplicationExceptions aes = new ApplicationExceptions();
      aes.add("detail", new RuntimeException("サービス時間外です。"));
      throw aes;
    }
  }
}
