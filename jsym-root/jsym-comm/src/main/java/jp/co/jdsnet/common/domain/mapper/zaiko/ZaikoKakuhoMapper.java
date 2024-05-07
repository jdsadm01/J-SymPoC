package jp.co.jdsnet.common.domain.mapper.zaiko;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.jdsnet.common.domain.entity.zaiko.ZaikoKakuhoEntity;

/**
 * 在庫確保Mapperインターフェース
 *
 * @author ソース生成ツール
 */
@Mapper
public interface ZaikoKakuhoMapper extends GeneratedZaikoKakuhoMapper {

  /**
   * ３種の条件で在庫確保を検索する
   *
   * @param tok 得意先（単独店）での検索条件
   * @param syy 集約店での検索条件
   * @param eig 営業所での検索条件
   * @return union allの結果
   */
  public List<ZaikoKakuhoEntity> selectZaikoKakuhoList(@Param("tok") ZaikoKakuhoEntity tok,
      @Param("syy") ZaikoKakuhoEntity syy, @Param("eig") ZaikoKakuhoEntity eig);
}
