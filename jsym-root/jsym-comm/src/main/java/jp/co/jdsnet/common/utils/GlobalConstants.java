package jp.co.jdsnet.common.utils;

import java.util.Arrays;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 横断的に最頻出の定数の定義をする。
 *
 * @author r-matsumura
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalConstants {

  /**
   * 第一引数に指定されたEnumの中から、第2引数のコード値と一致するものを取得する。
   *
   * @param target 取得したいEnumのクラス
   * @param code 検索するコード値
   * @param <E> CodeInterfaceを実装したEnumクラス
   * @return 対象が存在しない場合はnullが変える
   */
  @SuppressWarnings("rawtypes")
  public static <E extends Enum & CodeInterface> E valueOf(Class<E> target, String code) {

    return Arrays.stream(target.getEnumConstants())
        .filter(data -> String.valueOf(data.getCode()).trim().equals(code.trim())).findFirst()
        .orElse(null);
  }

  /**
   * コード値からEnumの逆引き用インターフェース
   *
   * @param <T> コード値の型
   */
  public interface CodeInterface<T> {
    public T getCode();
  }

  /**
   * トランコード
   */
  @RequiredArgsConstructor
  public enum Trncod implements CodeInterface<String> {

    /** 棚卸指示 */
    TANAOROSHI_SHIJI("100  ", false, false),
    /** 棚卸 */
    TANAOROSHI("102  ", false, false),
    /** 棚卸訂正(-) */
    TANAOROSHI_MINUS("103  ", false, false),
    /** 生産発注 */
    SEISAN_HATCHU("110  ", false, false),
    /** 生産発注訂正(＋) */
    SEISAN_HATCHU_PLUS("110T ", false, false),
    /** 生産発注訂正(－) */
    SEISAN_HATCHU_MINUS("111  ", false, false),
    /** 仕入発注 */
    SHIIRE_HATCHU("112  ", false, false),
    /** 仕入発注訂正(＋) */
    SHIIRE_HATCHU_PLUS("112T ", false, false),
    /** 仕入発注訂正(－) */
    SHIIRE_HATCHU_MINUS("113  ", false, false),
    /** 生産入庫 */
    SEISAN_NYUKO("120  ", false, false),
    /** 生産入庫訂正(＋) */
    SEISAN_NYUKO_PLUS("120T ", false, false),
    /** 生産入庫訂正(－) */
    SEISAN_NYUKO_MINUS("121  ", false, false),
    /** 仕入入庫 */
    SHIIRE_NYUKO("122  ", false, false),
    /** 仕入入庫訂正(＋) */
    SHIIRE_NYUKO_PLUS("122T ", false, false),
    /** 仕入入庫訂正(－) */
    SHIIRE_NYUKO_MINUS("123  ", false, false),
    /** 生産返品 */
    SEISAN_HENPIN("125  ", false, false),
    /** 生産返品訂正(＋) */
    SEISAN_HENPIN_PLUS("125T ", false, false),
    /** 生産返品訂正(－) */
    SEISAN_HENPIN_MINUS("126  ", false, false),
    /** 仕入返品 */
    SHIIRE_HENPIN("127  ", false, false),
    /** 仕入返品訂正(＋) */
    SHIIRE_HENPIN_PLUS("127T ", false, false),
    /** 仕入返品訂正(－) */
    SHIIRE_HENPIN_MINUS("128  ", false, false),
    /** 経費出庫 */
    KEIHI_SHUKKO("130  ", false, true),
    /** 経費出庫訂正(＋) */
    KEIHI_SHUKKO_PLUS("130T ", false, true),
    /** 経費出庫訂正(－) */
    KEIHI_SHUKKO_MINUS("131  ", false, true),
    /** サンプル出庫 */
    SAMPLE_SHUKKO("134  ", false, false),
    /** サンプル出庫訂正(＋) */
    SAMPLE_SHUKKO_PLUS("134T ", false, false),
    /** サンプル出庫訂正(－) */
    SAMPLE_SHUKKO_MINUS("135  ", false, false),
    /** 再加工出庫 */
    SAIKAKO_SHUKKO("140  ", false, false),
    /** 再加工出庫訂正(＋) */
    SAIKAKO_SHUKKO_PLUS("140T ", false, false),
    /** 再加工出庫訂正(－) */
    SAIKAKO_SHUKKO_MINUS("141  ", false, false),
    /** 再加工入庫 */
    SAIKAKO_NYUKO("142  ", false, false),
    /** 再加工入庫訂正(＋) */
    SAIKAKO_NYUKO_PLUS("142T ", false, false),
    /** 再加工入庫訂正(－) */
    SAIKAKO_NYUKO_MINUS("143  ", false, false),
    /** 振替入庫 */
    FURIKAE_NYUKO("150  ", false, false),
    /** 振替入庫訂正(＋) */
    FURIKAE_NYUKO_PLUS("150T ", false, false),
    /** 振替入庫訂正(－) */
    FURIKAE_NYUKO_MINUS("151  ", false, false),
    /** ＤＥＡＤ償却 */
    DEAD_SHOKYAKU("170  ", false, false),
    /** ＤＥＡＤ償却訂正(＋) */
    DEAD_SHOKYAKU_PLUS("170T ", false, false),
    /** ＤＥＡＤ償却訂正(－) */
    DEAD_SHOKYAKU_MINUS("171  ", false, false),
    /** 不良償却 */
    FURYO_SHOKYAKU("172  ", false, false),
    /** 不良償却訂正(＋) */
    FURYO_SHOKYAKU_PLUS("172T ", false, false),
    /** 不良償却訂正(－) */
    FURYO_SHOKYAKU_MINUS("173  ", false, false),
    /** 自動償却 */
    JIDO_SHOKYAKU("174  ", false, false),
    /** 自動償却訂正(＋) */
    JIDO_SHOKYAKU_PLUS("174T ", false, false),
    /** 自動償却訂正(－) */
    JIDO_SHOKYAKU_MINUS("175  ", false, false),
    /** 絶盤償却 */
    ZEPPAN_SHOKYAKU("176  ", false, false),
    /** 絶盤償却訂正(＋) */
    ZEPPAN_SHOKYAKU_PLUS("176T ", false, false),
    /** 絶盤償却訂正(－) */
    ZEPPAN_SHOKYAKU_MINUS("177  ", false, false),
    /** 廃盤償却 */
    HAIBAN_SHOKYAKU("178  ", false, false),
    /** 廃盤償却訂正(＋) */
    HAIBAN_SHOKYAKU_PLUS("178T ", false, false),
    /** 廃盤償却訂正(－) */
    HAIBAN_SHOKYAKU_MINUS("179  ", false, false),
    /** 部門振替出庫 */
    BUMONFURIKAE_SHUKKO("180  ", false, false),
    /** 部門振替出庫訂正(＋) */
    BUMONFURIKAE_SHUKKO_PLUS("180T ", false, false),
    /** 部門振替出庫訂正(－) */
    BUMONFURIKAE_SHUKKO_MINUS("181  ", false, false),
    /** 部門振替入庫 */
    BUMONFURIKAE_NYUKO("182  ", false, false),
    /** 部門振替入庫訂正(＋) */
    BUMONFURIKAE_NYUKO_PLUS("182T ", false, false),
    /** 部門振替入庫訂正(－) */
    BUMONFURIKAE_NYUKO_MINUS("183  ", false, false),
    /** 在庫訂正(＋) */
    ZAIKOTEISEI_PLUS("185  ", false, false),
    /** 在庫訂正(－) */
    ZAIKOTEISEI_MINUS("186  ", false, false),
    /** 廃棄 */
    HAIKI("188  ", false, false),
    /** 廃棄訂正(＋) */
    HAIKI_PLUS("188T ", false, false),
    /** 廃棄訂正(－) */
    HAIKI_MINUS("189  ", false, false),
    /** 振替出庫 */
    FURIKAE_SHUKKO("190  ", false, false),
    /** 振替出庫訂正(＋) */
    FURIKAE_SHUKKO_PLUS("190T ", false, false),
    /** 振替出庫訂正(－) */
    FURIKAE_SHUKKO_MINUS("191  ", false, false),
    /** 転送出庫 */
    TENSO_SHUKKO("193  ", false, false),
    /** 転送出庫訂正(＋) */
    TENSO_SHUKKO_PLUS("193T ", false, false),
    /** 転送出庫訂正(－) */
    TENSO_SHUKKO_MINUS("194  ", false, false),
    /** 棚上 */
    TANAAGE("195  ", false, false),
    /** 棚上訂正(＋) */
    TANAAGE_PLUS("195T ", false, false),
    /** 棚上訂正(－) */
    TANAAGE_MINUS("196  ", false, false),
    /** 棚下 */
    TANASAGE("197  ", false, false),
    /** 棚下訂正(＋) */
    TANASAGE_PLUS("197T ", false, false),
    /** 棚下訂正(－) */
    TANASAGE_MINUS("198  ", false, false),
    /** 商品売上 */
    SHOHIN_URIAGE("230  ", false, true),
    /** 商品売上訂正(＋) */
    SHOHIN_URIAGE_PLUS("230T ", false, true),
    /** 商品売上訂正(－) */
    SHOHIN_URIAGE_MINUS("231  ", false, true),
    /** 貸出出荷 */
    KASHIDASHI_SHUKKA("240  ", false, true),
    /** 貸出出荷訂正(＋) */
    KASHIDASHI_SHUKKA_PLUS("240T ", false, true),
    /** 貸出出荷訂正(－) */
    KASHIDASHI_SHUKKA_MINUS("241  ", false, true),
    /** 貸出出荷通常外 */
    KASHIDASHI_SHUKKA_TSUJOGAI("242  ", false, true),
    /** 貸出出荷通常外訂正(＋) */
    KASHIDASHI_SHUKKA_TSUJOGAI_PLUS("242T ", false, true),
    /** 貸出出荷通常外訂正(－) */
    KASHIDASHI_SHUKKA_TSUJOGAI_MINUS("243  ", false, true),
    /** 貸出戻入通常 */
    KASHIDASHI_REINYU_TSUJO("245  ", false, false),
    /** 貸出戻入通常外 */
    KASHIDASHI_REINYU_TSUJOGAI("247  ", false, false),
    /** 通常売上 */
    TSUJO_URIAGE("250  ", false, true),
    /** 通常売上訂正(＋) */
    TSUJO_URIAGE_PLUS("250T ", false, true),
    /** 通常売上訂正(－) */
    TSUJO_URIAGE_MINUS("251  ", false, true),
    /** 強制売上 */
    KYOSEI_URIAGE("250K ", false, true),
    /** 納品済売上 */
    NOHINZUMI_URIAGE("250X ", false, true),
    /** 転売売上 */
    TENBAI_URIAGE("250A ", false, true),
    /** 転売売上訂正(－) */
    TENBAI_URIAGE_MINUS("251A ", false, true),
    /** 新譜追加売上 */
    SINPU_TSUIKA_URIAGE("250S ", true, false),
    /** 新譜追加売上訂正(＋) */
    SINPU_TSUIKA_URIAGE_PLUS("250ST", true, false),
    /** 新譜追加売上訂正(－) */
    SINPU_TSUIKA_URIAGE_MINUS("251S ", true, false),
    /** 通常外売上 */
    TSUJOGAI_URIAGE("252  ", false, true),
    /** 通常外売上訂正(＋) */
    TSUJOGAI_URIAGE_PLUS("252T ", false, true),
    /** 通常外売上訂正(－) */
    TSUJOGAI_URIAGE_MINUS("253  ", false, true),
    /** 貸出売上 */
    KASHIDASHI_URIAGE("255  ", false, false),
    /** 貸出売上訂正(＋) */
    KASHIDASHI_URIAGE_PLUS("255T ", false, false),
    /** 貸出売上訂正(－) */
    KASHIDASHI_URIAGE_MINUS("256  ", false, false),
    /** 貸出売上通常外 */
    KASHIDASHI_URIAGE_TSUJOGAI("257  ", false, false),
    /** 貸出売上通常外訂正(＋) */
    KASHIDASHI_URIAGE_TSUJOGAI_PLUS("257T ", false, false),
    /** 貸出売上通常外訂正(－) */
    KASHIDASHI_URIAGE_TSUJOGAI_MINUS("258  ", false, false),
    /** 通常返品 */
    TSUJO_HENPIN("260  ", false, false),
    /** 通常返品訂正(＋) */
    TSUJO_HENPIN_PLUS("260T ", false, false),
    /** 通常返品訂正(－) */
    TSUJO_HENPIN_MINUS("261  ", false, false),
    /** 通常外返品 */
    TSUJOGAI_HENPIN("262  ", false, false),
    /** 通常外返品訂正(＋) */
    TSUJOGAI_HENPIN_PLUS("262T ", false, false),
    /** 通常外返品訂正(－) */
    TSUJOGAI_HENPIN_MINUS("263  ", false, false),
    /** 返送 */
    HENSO("268  ", false, false),
    /** 返送訂正(＋) */
    HENSO_PLUS("268T ", false, false),
    /** 返送訂正(－) */
    HENSO_MINUS("269  ", false, false),
    /** 特注売上 */
    TOKUCHU_URIAGE("275  ", false, true),
    /** 特注売上訂正(＋) */
    TOKUCHU_URIAGE_PLUS("275T ", false, true),
    /** 特注売上訂正(－) */
    TOKUCHU_URIAGE_MINUS("276  ", false, true),
    /** 特注返品 */
    TOKUCHU_HENPIN("277  ", false, false),
    /** 特注返品訂正(＋) */
    TOKUCHU_HENPIN_PLUS("277T ", false, false),
    /** 特注返品訂正(－) */
    TOKUCHU_HENPIN_MINUS("278  ", false, false),
    /** 輸出売上 */
    YUSHUTSU_URIAGE("285  ", false, true),
    /** 輸出売上訂正(＋) */
    YUSHUTSU_URIAGE_PLUS("285T ", false, true),
    /** 輸出売上訂正(－) */
    YUSHUTSU_URIAGE_MINUS("286  ", false, true),
    /** 輸出返品 */
    YUSHUTSU_HENPIN("287  ", false, false),
    /** 輸出返品訂正(＋) */
    YUSHUTSU_HENPIN_PLUS("287T ", false, false),
    /** 輸出返品訂正(－) */
    YUSHUTSU_HENPIN_MINUS("288  ", false, false),
    /** 特販売上 */
    TOKUHAN_URIAGE("290  ", false, true),
    /** 特販売上訂正(＋) */
    TOKUHAN_URIAGE_PLUS("290T ", false, true),
    /** 特販売上訂正(－) */
    TOKUHAN_URIAGE_MINUS("291  ", false, true),
    /** 特販返品 */
    TOKUHAN_HENPIN("292  ", false, false),
    /** 特販返品訂正(＋) */
    TOKUHAN_HENPIN_PLUS("292T ", false, false),
    /** 特販返品訂正(－) */
    TOKUHAN_HENPIN_MINUS("293  ", false, false),
    ;

    private final String code;
    private final boolean isSinpu;
    private final boolean isOnlyJuchuShukkaAri;

    public String getCode() {
      return this.code;
    }

    public boolean isSinpuTrn() {
      return this.isSinpu;
    }

    public boolean isOnlyJuAriKadoTrn() {
      return this.isOnlyJuchuShukkaAri;
    }

    public boolean isMae3kt(String trncod) {
      return this.code.substring(0, 3).equals(trncod);
    }
  }

  /**
   * 更新区分
   */
  @RequiredArgsConstructor
  public enum Updkbn implements CodeInterface<String> {
    INSERT("A "), UPDATE("U "), DELETE("D ");

    private final String code;

    public String getCode() {
      return this.code;
    }
  }

  /**
   * フラグ
   */
  @RequiredArgsConstructor
  public enum Flg implements CodeInterface<String> {
    OFF("0"), ON("1");

    private final String code;

    public String getCode() {
      return this.code;
    }
  }

  /**
   * リマーク
   */
  @RequiredArgsConstructor
  public enum Rmcod implements CodeInterface<String> {
    SHITEINASHI("  "),CHUZAN("B "), HENSO("G "), KYOSEI("K "), KYOSEI_RESERVE("KV"), SINPU("M "),
    NOT_CHUZAN("N "), FURYO("R "), ZAIKO_KAKUNIN("T "), RESERVE("V "), RESERVE_FURYO("VR"),
    NOHINZUMI("X "), SINPU_CHUZAN("Y "), CHUZAN_ZAIKAKU("Z ");

    private final String code;

    public String getCode() {
      return this.code;
    }
  }

  /**
   * 出荷コード
   */
  @RequiredArgsConstructor
  public enum Syacod implements CodeInterface<String> {
    TSUJO("1"), MENGAE_KYUHINBAN("2"), KANZEN_GENTEIBAN("3"), JIKO_1("4"), ZAIKO_URIKIRI("5"),
    JIKO_2("6"), SHINPU("7"), PAUSE("8"), GENTEIBAN("9"), CHUZAN_SHUKKA_ONLY("C"), 
    CHUZAN_SEIRI("D"), CHUZAN_MUSHI("W")
    ;

    private final String code;

    public String getCode() {
      return this.code;
    }
  }

  /**
   * ユーザー分類 Enumや値の取得はenumのvalueOf,nameメソッドを使用する
   */
  public enum Usrbun {
    MKR, JDS, JAR, TAK;
  }

  /**
   * 区切り文字
   */
  @RequiredArgsConstructor
  public enum Separator {
    TAB("\t"), COMMA(","), ENTER("\n");
    private final String value;

    public String getValue() {
      return this.value;
    }
  }
}
