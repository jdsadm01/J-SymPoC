package jp.co.jdsnet.common.logic.implement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity.Skrtanktikbn;
import jp.co.jdsnet.common.domain.entity.hinban.ShikiritankaEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.DaihyoKaishaJokenEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.HinbanTokuisakiKakeritsuTankaEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.HinbanTokuisakiKakeritsuTankaEntity.Krttankbn;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KakushaTokuisakiEntity.Hsuchskbn;
import jp.co.jdsnet.common.domain.entity.tokuisaki.KyotsuTokuisakiEntity;
import jp.co.jdsnet.common.domain.entity.tokuisaki.ShikirikakeritsuEntity;
import jp.co.jdsnet.common.domain.mapper.hatchu.HatchuMapper;
import jp.co.jdsnet.common.domain.mapper.hinban.HinbanMapper;
import jp.co.jdsnet.common.domain.mapper.hinban.ShikiritankaMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.DaihyoKaishaJokenMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.HinbanTokuisakiKakeritsuTankaMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KakushaTokuisakiMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.KyotsuTokuisakiMapper;
import jp.co.jdsnet.common.domain.mapper.tokuisaki.ShikirikakeritsuMapper;
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
  private final HatchuMapper hatchuMapper;
  private final MessageSource messageSource;
  private final HinbanTokuisakiKakeritsuTankaMapper hinbanTokuisakiKakeritsuTankaMapper;
  private final KakushaTokuisakiMapper kakushaTokuisakiMapper;
  private final KyotsuTokuisakiMapper kyotsuTokuisakiMapper;
  private final ShikirikakeritsuMapper shikirikakeritsuMapper;
  private final ShikiritankaMapper shikiritankaMapper;

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
      throw new NoSuchElementException(messageSource.getMessage("error.errors",
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
      throw new NoSuchElementException(messageSource.getMessage("error.errors",
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

  private void getHinbanTail(String kigbng, String separater) throws Exception {
    if (kigbng.trim().length() == 1) {
      throw new IllegalArgumentException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("kigbng", null, Locale.getDefault())},
          Locale.getDefault()));
    }
    if (StringUtils.isBlank(this.kigHead)) {
      throw new IllegalArgumentException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("kigbng", null, Locale.getDefault())},
          Locale.getDefault()));
    }

    int separateIdx = kigbng.indexOf(separater, 0);
    this.kigTail = kigbng.substring(separateIdx + 1).trim();

    if ((this.kigHead.length() + this.kigTail.length()) > 13) {
      throw new IllegalArgumentException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("kigbng", null, Locale.getDefault())},
          Locale.getDefault()));
    }
    if (this.kigHead.contains(" ") || this.kigTail.contains(" ")) {
      throw new IllegalArgumentException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("kigbng", null, Locale.getDefault())},
          Locale.getDefault()));
    }
  }

  private String getKigbngPadZero() {
    return this.kigHead.concat(StringUtility.padZero(this.kigTail, (13 - this.kigHead.length())))
        .toUpperCase();
  }

  @Override
  public Map<String, Integer> getNkiHacSuu(String daikaiskbcod, String kaiskbcod, String kigbng)
      throws Exception {
    Map<String, Integer> nkiData = new HashMap<>();
    Integer nki = hatchuMapper.getNkiMostRecently(daikaiskbcod, kaiskbcod, kigbng);
    if (Objects.nonNull(nki)) {
      int nyuytesuu =
          Optional.ofNullable(hatchuMapper.getNyukoYoteisuu(daikaiskbcod, kaiskbcod, kigbng, nki))
              .orElse(0);
      nkiData.put("nki", nki);
      nkiData.put("hacsuu", nyuytesuu);
    }
    return nkiData;
  }

  @Override
  public double getSkrtan(String daikaiskbcod, String kigbng, String tokcod, double skrkrt)
      throws Exception {

    if ("PCH".equals(daikaiskbcod) && skrkrt == 0d) {
      HinbanTokuisakiKakeritsuTankaEntity hintokKakeTanEntity =
          getHinbanTokuisakiKakeritsuTanka(daikaiskbcod, kigbng, tokcod);
      if (Objects.isNull(hintokKakeTanEntity)) {
        return getSkrtanCommon(daikaiskbcod, kigbng, tokcod, skrkrt);
      } else {
        Krttankbn krttankbn =
            GlobalConstants.valueOf(Krttankbn.class, hintokKakeTanEntity.getKrttankbn());
        if (krttankbn == Krttankbn.KAKERITU_SHITEI) {
          return getSkrtanCommon(daikaiskbcod, kigbng, tokcod, hintokKakeTanEntity.getSkrkrt());
        } else if (krttankbn == Krttankbn.TANKA_SHITEI) {
          return Math.floor(hintokKakeTanEntity.getSkrtan());
        } else {
          throw new IllegalArgumentException(messageSource.getMessage("error.errors",
              new Object[] {messageSource.getMessage("arg.skrtankti", null, Locale.getDefault())},
              Locale.getDefault()));
        }
      }
    } else {
      return getSkrtanCommon(daikaiskbcod, kigbng, tokcod, skrkrt);
    }
  }

  private HinbanTokuisakiKakeritsuTankaEntity getHinbanTokuisakiKakeritsuTanka(String daikaiskbcod,
      String kigbng, String tokcod) {
    HinbanTokuisakiKakeritsuTankaEntity param = HinbanTokuisakiKakeritsuTankaEntity.builder()
        .daikaiskbcod(daikaiskbcod).kigbng(kigbng).tokcod(tokcod).toksyykbn("T").build();
    int kkn = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")));

    HinbanTokuisakiKakeritsuTankaEntity hintokKakeTanEntity =
        hinbanTokuisakiKakeritsuTankaMapper.selectKrtTan(param, kkn);

    if (Objects.isNull(hintokKakeTanEntity)) {
      KakushaTokuisakiEntity kakushaTokuisakiEntity = kakushaTokuisakiMapper.select(
          KakushaTokuisakiEntity.builder().daikaiskbcod(daikaiskbcod).tokcod(tokcod).build());
      param =
          param.toBuilder().tokcod(kakushaTokuisakiEntity.getUrisyytencod()).toksyykbn("U").build();
      hintokKakeTanEntity = hinbanTokuisakiKakeritsuTankaMapper.selectKrtTan(param, kkn);
    }

    return hintokKakeTanEntity;
  }

  private double getSkrtanCommon(String daikaiskbcod, String kigbng, String tokcod, double skrkrt)
      throws NoSuchElementException, ArithmeticException, IllegalArgumentException {
    HinbanEntity hinban = hinbanMapper
        .select(HinbanEntity.builder().daikaiskbcod(daikaiskbcod).kigbng(kigbng).build());
    KakushaTokuisakiEntity kakusha = kakushaTokuisakiMapper
        .select(KakushaTokuisakiEntity.builder().daikaiskbcod(daikaiskbcod).tokcod(tokcod).build());
    KyotsuTokuisakiEntity kyotsu =
        kyotsuTokuisakiMapper.select(KyotsuTokuisakiEntity.builder().tokcod(tokcod).build());
    if (Objects.isNull(hinban)) {
      throw new NoSuchElementException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("kigbng", null, Locale.getDefault())},
          Locale.getDefault()));
    } else if (Objects.isNull(kyotsu)) {
      throw new NoSuchElementException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("tokcod", null, Locale.getDefault())},
          Locale.getDefault()));
    } else if (Objects.isNull(kakusha)) {
      throw new NoSuchElementException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("arg.kaikyy", null, Locale.getDefault())},
          Locale.getDefault()));
    }

    double tmpSkrtan = 0d;
    double znupri = hinban.getZnupri();
    if (skrkrt != 0d) {
      tmpSkrtan = (znupri * 100) * (skrkrt * 10) / 100000;
    } else {
      Skrtanktikbn skrtanktikbn =
          GlobalConstants.valueOf(Skrtanktikbn.class, hinban.getSkrtanktikbn());
      if (Skrtanktikbn.HINBAN_SKRTAN == skrtanktikbn) {
        tmpSkrtan = getTmpskrtanForPatternA(hinban, kyotsu.getKrerntkbn());
      } else if (Skrtanktikbn.ZNUPRI_TIMES_SKRKRT == skrtanktikbn) {
        tmpSkrtan = getTmpskrtanForPatternB(hinban, tokcod);
      } else if (Skrtanktikbn.TANKA_SKRTAN == skrtanktikbn) {
        tmpSkrtan = getTmpskrtanForPatternC(hinban, tokcod);
      } else {
        throw new IllegalArgumentException(messageSource.getMessage("error.errors",
            new Object[] {messageSource.getMessage("arg.skrtankti", null, Locale.getDefault())},
            Locale.getDefault()));
      }
    }
    if (tmpSkrtan == 0d) {
      throw new ArithmeticException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("arg.skrtankti", null, Locale.getDefault())},
          Locale.getDefault()));
    }
    Hsuchskbn hsuchskbn = GlobalConstants.valueOf(Hsuchskbn.class, kakusha.getHsuchskbn());
    tmpSkrtan = hsuchskbn.ajustSkrtan(tmpSkrtan);

    return (double) ((long) (tmpSkrtan * 100)) / 100; // 小数第３位以下を切り捨てする。
  }

  private double getTmpskrtanForPatternA(HinbanEntity hinban, String krerntkbn) {
    if ("1".equals(krerntkbn)) {
      return hinban.getSkrtankre();
    } else {
      return hinban.getSkrtanipn();
    }
  }

  private double getTmpskrtanForPatternB(HinbanEntity hinban, String tokcod)
      throws NoSuchElementException {
    ShikirikakeritsuEntity skrkrt = shikirikakeritsuMapper
        .select(ShikirikakeritsuEntity.builder().daikaiskbcod(hinban.getDaikaiskbcod())
            .tokcod(tokcod).skrkrtgrpcod(hinban.getSkrkrtgrpcod()).build());
    if (Objects.isNull(skrkrt)) {
      throw new NoSuchElementException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("arg.skrtankti", null, Locale.getDefault())},
          Locale.getDefault()));
    }
    return (hinban.getZnupri() * 100) * (skrkrt.getSkrkrt() * 10) / 100000;
  }

  private double getTmpskrtanForPatternC(HinbanEntity hinban, String tokcod)
      throws NoSuchElementException {
    ShikirikakeritsuEntity skrkrt = shikirikakeritsuMapper
        .select(ShikirikakeritsuEntity.builder().daikaiskbcod(hinban.getDaikaiskbcod())
            .tokcod(tokcod).skrkrtgrpcod(hinban.getSkrkrtgrpcod()).build());
    if (Objects.isNull(skrkrt)) {
      throw new NoSuchElementException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("arg.skrtankti", null, Locale.getDefault())},
          Locale.getDefault()));
    }

    ShikiritankaEntity skrtan = shikiritankaMapper
        .select(ShikiritankaEntity.builder().daikaiskbcod(hinban.getDaikaiskbcod())
            .kigbng(hinban.getKigbng()).skrtangrpcod(skrkrt.getSkrtangrpcod()).build());
    if (Objects.isNull(skrtan)) {
      throw new NoSuchElementException(messageSource.getMessage("error.errors",
          new Object[] {messageSource.getMessage("arg.skrtankti", null, Locale.getDefault())},
          Locale.getDefault()));
    }
    return skrtan.getSkrtan();
  }

}
