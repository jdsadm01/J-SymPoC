package jp.co.jdsnet.common.logic.implement;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.DaihyoKaishaJokenEntity;
import jp.co.jdsnet.common.domain.mapper.hinban.HinbanMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.DaihyoKaishaJokenMapper;
import jp.co.jdsnet.common.logic.KigbngRelatedSharedService;
import jp.co.jdsnet.common.utils.GlobalConstants;
import jp.co.jdsnet.common.utils.GlobalConstants.Flg;
import jp.co.jdsnet.common.utils.StringUtility;
import lombok.RequiredArgsConstructor;

/**
 * 記号番号関連の共通サービス実装クラス
 */
@RequiredArgsConstructor
@Service
public class KigbngRelatedSharedServiceImpl implements KigbngRelatedSharedService {
  private String daikaiskbcod;
  private Flg gammkrflg;
  private String kigHead;
  private String kigTail;
  private final HinbanMapper hinbanMapper;
  private final DaihyoKaishaJokenMapper daihyoKaishaJokenMapper;
  private final MessageSource messageSource;

  @Override
  public HinbanEntity getHinban(String daikaiskbcod, String kigbng)
      throws NoSuchElementException, Exception {
    return getHinban(daikaiskbcod, daikaiskbcod, kigbng);
  }

  @Override
  public HinbanEntity getHinban(String daikaiskbcod, String kaiskbcod, String kigbng)
      throws Exception {
    try {
      // まずは入力値で検索を行う
      return getHinbanEntity(daikaiskbcod, kaiskbcod, kigbng.toUpperCase());
    } catch (NoSuchElementException e1) {
      try {
        // 初回の検索で無かったら、通常の変換を行って検索する
        return getHinbanEntity(daikaiskbcod, kaiskbcod, makeKigBng(daikaiskbcod, kigbng));
      } catch (NoSuchElementException e2) {
        // それでも無かったら、会社特有の変換を行って検索する
        if ("SPE".equals(daikaiskbcod)) {
          return getHinbanEntity(daikaiskbcod, kaiskbcod,
              makeKigBng(daikaiskbcod, kigbng.substring(2, kigbng.length())));
        } else {
          throw e2;
        }
      }
    }
  }

  @Override
  public String makeKigBng(String daikaiskbcod, String kigbng) throws Exception {
    if (StringUtils.isBlank(kigbng)) {
      return kigbng;
    }

    String result = kigbng;
    setGammkrflg(daikaiskbcod);
    if (kigbng.contains(".")) {
      getHinBanHead(kigbng, ".");
      getHinbanTail(kigbng, ".");
      result = getKigbngPadZero();
    } else if (kigbng.contains("-") && Flg.OFF == this.gammkrflg) {
      getHinBanHead(kigbng, "-");
      getHinbanTail(kigbng, "-");
      result = getKigbngPadZero();
    }
    return result.toUpperCase();
  }

  private HinbanEntity getHinbanEntity(String daikaiskbcod, String kaiskbcod, String kigbng)
      throws NoSuchElementException, Exception {
    List<HinbanEntity> hinbanList =
        hinbanMapper.selectByInputKigbng(daikaiskbcod, kigbng, kaiskbcod);

    if (hinbanList.size() == 0) {
      throw new NoSuchElementException(messageSource.getMessage("error.error",
          new Object[] {messageSource.getMessage("kigbng", null, Locale.getDefault())},
          Locale.getDefault()));
    }

    Comparator<HinbanEntity> comparator = Comparator.comparing(HinbanEntity::getUpddte).reversed()
        .thenComparing(Comparator.comparing(HinbanEntity::getUpdjkk).reversed())
        .thenComparing(Comparator.comparing(HinbanEntity::getKigbng));

    HinbanEntity result = hinbanList.stream().sorted(comparator)
        .filter(e -> kigbng.equals(e.getKigbng())).findFirst().orElse(null);

    if (Objects.isNull(result)) {
      result = hinbanList.stream().sorted(comparator).findFirst().orElseThrow();
    }

    if (!kigbng.equals(result.getKigbng()) && !kigbng.equals(result.getJancod())
        && (kigbng.equals(result.getSryhnb()) && "0".equals(result.getKighknumu()))) {
      throw new NoSuchElementException(messageSource.getMessage("error.error",
          new Object[] {messageSource.getMessage("kigbng", null, Locale.getDefault())},
          Locale.getDefault()));
    }
    return result;
  }

  private void setGammkrflg(String daikaiskbcod) {
    if (Objects.isNull(this.gammkrflg) || !this.daikaiskbcod.equals(daikaiskbcod)) {
      this.daikaiskbcod = daikaiskbcod;
      this.gammkrflg = GlobalConstants.valueOf(Flg.class,
          daihyoKaishaJokenMapper
              .select(DaihyoKaishaJokenEntity.builder().daikaiskbcod(daikaiskbcod).build())
              .getGammkrflg());
    }
  }

  private void getHinBanHead(String kigbng, String separater) {
    if (kigbng.trim().startsWith(".") || kigbng.trim().startsWith("-")) {
      return;
    } else {
      int separateIdx = kigbng.indexOf(separater, 0);
      if (separateIdx >= 0) {
        this.kigHead = kigbng.substring(0, separateIdx).trim();
      }
    }
  }

  // TODO Exceptionでいいのか
  private void getHinbanTail(String kigbng, String separater) throws Exception {
    if (kigbng.trim().length() == 1) {
      throw new Exception();
    }
    if (StringUtils.isBlank(this.kigHead)) {
      throw new Exception();
    }

    int separateIdx = kigbng.indexOf(separater, 0);
    this.kigTail = kigbng.substring(separateIdx + 1).trim();

    if ((this.kigHead.length() + this.kigTail.length()) > 13) {
      throw new Exception();
    }
    if (this.kigHead.contains(" ") || this.kigTail.contains(" ")) {
      throw new Exception();
    }
  }

  private String getKigbngPadZero() {
    return this.kigHead.concat(StringUtility.padZero(this.kigTail, (13 - this.kigHead.length())))
        .toUpperCase();
  }
}
