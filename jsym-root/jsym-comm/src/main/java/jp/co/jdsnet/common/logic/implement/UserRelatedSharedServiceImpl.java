package jp.co.jdsnet.common.logic.implement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.jdsnet.common.logic.UserRelatedSharedService;
import lombok.RequiredArgsConstructor;

/**
 * ユーザー関連の共通処理実装クラス
 *
 * @author r-matsumura
 *
 */
@RequiredArgsConstructor
@Service
public class UserRelatedSharedServiceImpl implements UserRelatedSharedService {

  @Override
  @Transactional
  public int getCurrentNo(String usrid, String bun, CurrentNoGetType prckbn) {
    // TODO 自動生成されたメソッド・スタブ
    return 0;
  }

}
