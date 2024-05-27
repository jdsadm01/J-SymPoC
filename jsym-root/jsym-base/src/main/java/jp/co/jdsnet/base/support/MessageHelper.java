package jp.co.jdsnet.base.support;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

/**
 * メッセージリソース取得用コンポーネント
 *
 * @author r-matsumura
 *
 */
@Component
@RequiredArgsConstructor
public class MessageHelper {

  private final MessageSource messageSource;
  
  /**
   * メッセージを取得する。
   *
   * <p>
   * 引数なしのメッセージを取得。ロケールはデフォルト。<br>
   * 取得できない場合はキーをそのまま返却する。
   *
   * @param key メッセージキー
   * @return 取得したメッセージ
   */
  public String getMessage(String key) {
    return getMessage(key, null);
  }

  /**
   * メッセージを取得する。
   *
   * <p>
   * 引数なしのメッセージを取得。ロケールはデフォルト。<br>
   * 取得できない場合はキーをそのまま返却する。
   *
   * @param key メッセージキー
   * @param args 引数
   * @return 取得したメッセージ
   */
  public String getMessage(String key, Object[] args) {
    return messageSource.getMessage(key, args, key, Locale.getDefault());
  }
  
  /**
   * メッセージを取得する。
   *
   * <p>
   * 引数なしのメッセージを取得。<br>
   * 取得できない場合はキーをそのまま返却する。
   *
   * @param key メッセージキー
   * @param args 引数
   * @param locale ロケール
   * @return 取得したメッセージ
   */
  public String getMessage(String key, Object[] args, Locale locale) {
    return messageSource.getMessage(key, args, key, locale);
  }
}