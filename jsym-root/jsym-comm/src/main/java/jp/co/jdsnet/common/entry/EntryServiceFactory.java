package jp.co.jdsnet.common.entry;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * エントリーサービスを取得する
 *
 * @author r-matsumura
 *
 */
@Service
public class EntryServiceFactory {
  private final Map<String, EntryService<?>> entryServiceMap;

  /**
   * サービス判定に使用する
   */
  public enum ServiceId {
    Juchu, Reinyu, Henpin, Hatchu, Sokoshiji, Haisosaki;

    public String getClassName() {
      return "EntryServiceFor" + name();
    }
  }

  @Autowired
  public EntryServiceFactory(List<EntryService<?>> entryServices) {
    entryServiceMap = entryServices.stream()
        .collect(Collectors.toMap(EntryService::getServiceId, Function.identity()));
  }

  /**
   * 指定したサービスから対象クラスを取得する
   *
   * @param id ServiceId
   * @return 対象のサービスインスタンス
   */
  @SuppressWarnings("rawtypes")
  public EntryService findEntryService(ServiceId id) {
    return entryServiceMap.get(id.getClassName());
  }
}
