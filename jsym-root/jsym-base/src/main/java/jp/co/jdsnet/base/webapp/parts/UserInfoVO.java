package jp.co.jdsnet.base.webapp.parts;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import jp.co.jdsnet.common.utils.StringUtility;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.Setter;

@Data
// @Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoVO implements Serializable {

  private static final long serialVersionUID = 2764364819019710523L;

  /** ユーザーID */
  @Builder.Default
  private String usrid = "";

  /** 入力用ユーザーID */
  @Builder.Default
  private String enyusrid = "";

  /** パスワード */
  @Builder.Default
  private String pwd = "";

  /** ユーザー名 */
  @Builder.Default
  private String usrnm = "";

  /** 代表会社識別コード */
  @Builder.Default
  private String daikaiskbcod = "";

  /** 会社識別コード */
  @Builder.Default
  private String kaiskbcod = "";

  /** ユーザー分類 */
  @Builder.Default
  private String usrbun = "";

  /** 場所コード */
  @Builder.Default
  private String bshcod = "";

  /** メニューグループコード */
  @Builder.Default
  private String mnugrpcod = "";

  /** CPUID */
  @Builder.Default
  private String cpuid = "";

  /** 端末ID */
  @Builder.Default
  private String tmlid = "";

  /** ログイン日時 */
  @Builder.Default
  private LocalDateTime loginDateTime = LocalDateTime.now();

  /** 前回アクセス時間 */
  // @Setter
  @Builder.Default
  private LocalDateTime lastAccessTime = LocalDateTime.now();

  /**
   * CPUFULIDを返す
   * 
   * @return CPUID + 端末ID
   */
  public String getCpufulid() {
    return this.cpuid + this.tmlid;
  }

  /**
   * 重複ログインにてセッションが切れているかをチェックする
   * <p>
   * ログイン時にセットしたログイン日付・時刻と現在のログインコントロールに登録されているログイン日付・時刻を比較する
   * </p>
   *
   * @param logindate ログインコントロールのログイン日付
   * @param logintime ログインコントロールのログイン時刻
   * @return true：このsessionでこれ以上操作させない
   */
  public boolean isStolenSession(int logindate, int logintime) {
    String sttjkk = String.valueOf(logintime);
    if (sttjkk.length() < 6) {
      sttjkk = StringUtility.lpad(sttjkk, 5, "0");
    }
    LocalDateTime loginDteTime = LocalDateTime.of(
        DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.LENIENT)
            .parse(String.valueOf(logindate), LocalDate::from),
        DateTimeFormatter.ofPattern("Hmmss").withResolverStyle(ResolverStyle.LENIENT).parse(sttjkk,
            LocalTime::from));

    return loginDteTime.isAfter(this.loginDateTime);
  }

  /**
   * ServletContext上で扱える形に変換する。
   *
   * @return ConcurrentHashMapに変換したVO
   */
  public ConcurrentHashMap<String, Object> convertForServletContext() {
    return (ConcurrentHashMap<String, Object>) Stream.of(this.getClass().getDeclaredFields())
        .collect(Collectors.toConcurrentMap(Field::getName, e -> {
          try {
            return e.get(this);
          } catch (IllegalArgumentException | IllegalAccessException e1) {
            return "";
          }
        }));
  }
}
