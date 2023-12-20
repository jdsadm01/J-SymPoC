package jp.co.jdsnet.common.logic.Implement;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import jp.co.jdsnet.common.domain.entity.kaisha.KaishaEntity;
import jp.co.jdsnet.common.domain.mapper.kaisha.KaishaMapper;
import jp.co.jdsnet.common.logic.CheckSharedService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CheckSharedServiceImpl implements CheckSharedService {

	private final KaishaMapper kaishaMapper;
	private final MessageSource messageSource;
	
	public String checkServiceTime(String daikaiskbcod, String usrbun, String gmnid, String gmnseq, String gmnkbn) {
		return SERVICETIME_ONLINE;
	}
	
	
	public void checkDaikaiskbcod(String checkCode, String usrDaikaiskbcod) throws Exception {
		if(!"JDS".equals(usrDaikaiskbcod)) return;
		
		KaishaEntity kaishaEntity = kaishaMapper.selectByPrimaryKey(KaishaEntity.builder().kaiskbcod(checkCode).build());
		if(kaishaEntity == null) {
			throw new Exception(messageSource.getMessage("error.error"
					, new Object[] {messageSource.getMessage("kaiskbcod",null,Locale.getDefault())}
					, Locale.getDefault()));
		}else if(!"0".equals(kaishaEntity.getKaibunkbn())) {
			throw new Exception();
		}
	}
}
