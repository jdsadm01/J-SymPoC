package jp.co.jdsnet.common.domain.mapper.sysmas;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.sysmas.DaihyoKaishaCalendarEntity;

/**
 * 代表会社カレンダーMapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface DaihyoKaishaCalendarMapper extends GeneratedDaihyoKaishaCalendarMapper {

  /**
   * 代表会社カレンダーをFROM-TO日付で取得する
   * <p>
   * JDSカレンダーの稼働日フラグも合わせて取得する
   *
   * @param daikaiskbcod 代表会社識別コード
   * @param fromDate8kt 開始日８桁
   * @param toDate8kt 終了日８桁
   * @return 代表会社カレンダーリスト
   */
  public List<DaihyoKaishaCalendarEntity> selectListByFromToDate(String daikaiskbcod,
      int fromDate8kt, int toDate8kt);
}
