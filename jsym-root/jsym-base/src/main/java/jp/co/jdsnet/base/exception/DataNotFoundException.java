package jp.co.jdsnet.base.exception;

/**
 * データ無し例外
 * @author Ryo.Matsumura
 *
 */
public class DataNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public DataNotFoundException(String message) {
    super(message);
  }
}
