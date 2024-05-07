package jp.co.jdsnet.common.domain.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * 引当可能数を保持するVO
 *
 * @author r-matsumura
 *
 */
public class HikiateKanosuuVo {
  /** 引当可能数Map key:倉庫コード value:可能数 */
  private Map<String, Integer> hatknosuu;

  /**
   * コンストラクタ 外からは呼ばせない
   *
   * @param builder ビルダー
   */
  private HikiateKanosuuVo(builder builder) {
    this.hatknosuu = builder.hatknosuu;
  }

  /**
   * HikiateKanosuuVOのビルダー
   */
  // CHECKSTYLE.SUPPRESS: TypeName lombokと同じ記述にする為にstyleチェックから除外する
  public static class builder {
    private Map<String, Integer> hatknosuu;

    public builder() {
      hatknosuu = new HashMap<>();
    }

    /**
     * 引当可能数をセットする
     *
     * @param skocod 倉庫コード
     * @param knosuu 引当可能数
     * @return セット後のビルダー
     */
    public builder add(String skocod, int knosuu) {
      hatknosuu.put(skocod, knosuu);
      return this;
    }

    /**
     * HikiateKanosuuVOオブジェクトを生成する
     *
     * @return HikiateKanosuuVo
     * @throws IllegalStateException データをセットしていない場合
     */
    public HikiateKanosuuVo build() throws IllegalStateException {
      if (hatknosuu.isEmpty()) {
        throw new IllegalStateException();
      }
      return new HikiateKanosuuVo(this);
    }
  }

  /**
   * 指定の倉庫コードの引当可能数を取得する
   *
   * @param skocod 引当可能数を取得したい倉庫コード
   * @return 引当可能数
   * @throws NoSuchElementException VOの中に指定の倉庫コードが存在しない場合
   */
  public int getKnosuu(String skocod) throws NoSuchElementException {
    if (hatknosuu.containsKey(skocod)) {
      return hatknosuu.get(skocod);
    } else {
      throw new NoSuchElementException("データが存在しません。");
    }
  }

  /**
   * 引当可能数を取得する 取得対象は倉庫コードでソートした１件目のデータ。 算出時に指定した倉庫が１件の場合はこちらを使用することを推奨する。
   *
   * @return １件目の引当可能数
   */
  public int getKnosuu() {
    return hatknosuu.entrySet().stream().sorted(Map.Entry.comparingByKey()).findFirst()
        .map(e -> e.getValue()).get();
  }

  /**
   * 取得した倉庫の引当可能数のサマリーを取得する
   *
   * @return 引当可能数のサマリー
   */
  public int getKnosuuSum() {
    return hatknosuu.values().stream().mapToInt(Integer::intValue).sum();
  }
}

