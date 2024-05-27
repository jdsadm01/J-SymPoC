package jp.co.jdsnet.common.domain.mapper.juchu;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 受注見出Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface JuchuMidashiMapper extends GeneratedJuchuMidashiMapper {

  /**
   * 受注日付、得意先コード、DSコードに対して次のSEQを取得する
   *
   * @param jucdte 受注日付
   * @param tokcod 得意先コード
   * @param dscod DSコード
   * @return SEQ
   */
  public int getNextSeq(@Param("jucdte") int jucdte, @Param("tokcod") String tokcod,
      @Param("dscod") String dscod);
}
