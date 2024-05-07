package jp.co.jdsnet.home.domain.service.implement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.jdsnet.base.webapp.parts.UserInfoVO;
import jp.co.jdsnet.common.domain.entity.control.LoginControlEntity;
import jp.co.jdsnet.common.domain.entity.control.ServiceControlEntity;
import jp.co.jdsnet.common.domain.entity.user.IpAddressEntity;
import jp.co.jdsnet.common.domain.entity.user.UserAuthenticationEntity;
import jp.co.jdsnet.common.domain.entity.user.UserEntity;
import jp.co.jdsnet.common.domain.mapper.control.LoginControlMapper;
import jp.co.jdsnet.common.domain.mapper.control.ServiceControlMapper;
import jp.co.jdsnet.common.domain.mapper.user.IpAddressMapper;
import jp.co.jdsnet.common.domain.mapper.user.UserAuthenticationMapper;
import jp.co.jdsnet.common.domain.mapper.user.UserMapper;
import jp.co.jdsnet.common.utils.CipherUtility;
import jp.co.jdsnet.common.utils.GlobalConstants.Updkbn;
import jp.co.jdsnet.common.utils.StringUtility;
import jp.co.jdsnet.home.domain.dto.LoginDTO;
import jp.co.jdsnet.home.domain.service.LoginService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

  private final LoginControlMapper loginControlMapper;
  private final IpAddressMapper ipAddressMapper;
  private final UserAuthenticationMapper userAuthenticationMapper;
  private final UserMapper userMapper;
  private final ServiceControlMapper serviceControlMapper;

  @Override
  public String getNetwrkskbcod(String ippadr) {
    return ipAddressMapper.select(IpAddressEntity.builder().ipaddr(ippadr).build())
        .getNetwrkskbcod();
  }

  @Override
  @Transactional
  public LoginDTO entry(LoginDTO dto) throws Exception {
    return userAuthentication(dto);
  }

  private LoginDTO userAuthentication(LoginDTO dto) throws Exception {
    LocalDateTime now = LocalDateTime.now().withNano(0);

    UserAuthenticationEntity userAuthenticationEntity =
        userAuthenticationMapper.select(UserAuthenticationEntity.builder()
            .netwrkskbcod(dto.getNetwrkskbcod()).enyusrid(dto.getEnyusrid()).build());

    checkPassword(dto.getPwd(), userAuthenticationEntity);

    UserEntity userEntity =
        userMapper.selectWithLockForUpdate(UserEntity.builder().usrid(userAuthenticationEntity.getUsrid()).build());

    checkServiceTime(userEntity.getDaikaiskbcod(), userEntity.getUsrbun());

    // 更新とかいろいろ

    updateLoginControl(userEntity.getUsrid(), dto.getSessionid(), dto.getBrowserVersion(), now);

    UserInfoVO userInfo =
        UserInfoVO.builder().usrid(userEntity.getUsrid()).usrnm(userEntity.getUsrnmkj())
            .usrbun(userEntity.getUsrbun()).bshcod(userEntity.getBshcod())
            .cpuid(userEntity.getCpuid()).daikaiskbcod(userEntity.getDaikaiskbcod())
            .kaiskbcod(userEntity.getKaiskbcod()).mnugrpcod(userEntity.getRoleid())
            .tmlid(userEntity.getTmlid()).loginDateTime(now).build();
    return dto.toBuilder().userInfo(userInfo).build();
  }

  private void checkPassword(String enyPwd, UserAuthenticationEntity entity) throws Exception {
    // MdvKaisha取得

    String decyptPwd = "";
    try {
      decyptPwd = CipherUtility.decrypt(entity.getPwd());
    } catch (Exception e) {

    }
    if (!decyptPwd.equals(enyPwd)) {
      updatePwdCorrectCount(entity);
      throw new Exception("パスワードがちがうよ");
    }

    // 正しい場合も誤入力回数を更新する

  }

  private void updatePwdCorrectCount(
      UserAuthenticationEntity entity/* ,MdvKaishaEntity kaishaEntity */) {

  }

  private void checkServiceTime(String daikaiskbcod, String usrbun) throws Exception {

    ServiceControlEntity serviceControlEntity = serviceControlMapper.select(ServiceControlEntity
        .builder().daikaiskbcod(daikaiskbcod).usrbun(usrbun).gymid("00").prckbn("00").build());

    if (!"1".equals(serviceControlEntity.getSvcflg1())) {
      // ERROR
      throw new Exception("サービスしてない");
    }
    String sttjkk = String.valueOf(serviceControlEntity.getSvcsttjkk1());
    if (sttjkk.length() < 6) {
      sttjkk = StringUtility.lpad(sttjkk, 5, "0");
    }
    LocalDateTime sttDteTime = LocalDateTime.of(
        DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.LENIENT)
            .parse(String.valueOf(serviceControlEntity.getSvcsttdte1()), LocalDate::from),
        DateTimeFormatter.ofPattern("Hmmss").withResolverStyle(ResolverStyle.LENIENT).parse(sttjkk,
            LocalTime::from));

    String endjkk = String.valueOf(serviceControlEntity.getSvcendjkk1());
    if (endjkk.length() < 6) {
      endjkk = StringUtility.lpad(endjkk, 5, "0");
    }
    LocalDateTime endDteTime = LocalDateTime.of(
        DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.LENIENT)
            .parse(String.valueOf(serviceControlEntity.getSvcenddte1()), LocalDate::from),
        DateTimeFormatter.ofPattern("Hmmss").withResolverStyle(ResolverStyle.LENIENT).parse(endjkk,
            LocalTime::from));

    LocalDateTime sysDteTime = LocalDateTime.now();

    if (sttDteTime.isAfter(sysDteTime) || endDteTime.isBefore(sysDteTime)) {
      // 時間外エラー
      throw new Exception("サービス時間外");
    }
  }

  private void updateLoginControl(String usrid, String sessionid, String browser,
      LocalDateTime localDateTime) {
    int sysdate = Integer.parseInt(localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    int systime = Integer.parseInt(localDateTime.format(DateTimeFormatter.ofPattern("HHmmss")));

    LoginControlEntity entity = loginControlMapper
        .selectWithLockForUpdate(LoginControlEntity.builder().usrid(usrid).build());

    if (Objects.isNull(entity)) {
      // loginControlMapper.insert(LoginControlEntity.builder().build());
    } else {
      // 一旦セッションとブラウザバージョンのみ 実際は日時とかも
      loginControlMapper
          .update(entity.toBuilder()/* .sts("I") */.sessionid(sessionid).browserversion(browser)
              .logindte(sysdate).loginjkk(systime).logoutdte(0).logoutjkk(0)
              .updkbn(Updkbn.UPDATE.getCode()).upddte(sysdate).updjkk(systime).build());
    }
  }
}
