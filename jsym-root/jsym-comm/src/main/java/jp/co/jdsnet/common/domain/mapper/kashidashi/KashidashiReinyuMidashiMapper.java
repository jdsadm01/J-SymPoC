package jp.co.jdsnet.common.domain.mapper.kashidashi;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 貸出戻入見出Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface KashidashiReinyuMidashiMapper extends GeneratedKashidashiReinyuMidashiMapper {

  /**
   * 貸出戻入日付、得意先コード、DSコードに対して次のSEQを取得する
   *
   * @param kdareidte 貸出戻入日付
   * @param tokcod 得意先コード
   * @param dscod DSコード
   * @return SEQ
   */
  public int getNextSeq(@Param("kdareidte") int kdareidte, @Param("tokcod") String tokcod,
      @Param("dscod") String dscod);
}
