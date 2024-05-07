package jp.co.jdsnet.common.domain.mapper.sysmas;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.co.jdsnet.common.domain.entity.sysmas.JdsCalendarEntity;

/**
 * ＪＤＳカレンダーMapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface JdsCalendarMapper extends GeneratedJdsCalendarMapper {

  /**
   * JDSカレンダーをFROM-TO日付で取得する
   *
   * @param fromDate8kt 開始日８桁
   * @param toDate8kt 終了日８桁
   * @return JDSカレンダーリスト
   */
  public List<JdsCalendarEntity> selectListByFromToDate(int fromDate8kt, int toDate8kt);
}
