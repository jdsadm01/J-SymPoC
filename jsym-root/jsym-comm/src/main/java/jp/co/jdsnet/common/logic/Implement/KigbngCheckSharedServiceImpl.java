package jp.co.jdsnet.common.logic.Implement;

import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.common.domain.entity.hinban.HinbanEntity;
import jp.co.jdsnet.common.domain.entity.kaisha.DaihyoKaishaJokenEntity;
import jp.co.jdsnet.common.domain.mapper.hinban.HinbanMapper;
import jp.co.jdsnet.common.domain.mapper.kaisha.DaihyoKaishaJokenMapper;
import jp.co.jdsnet.common.logic.KigbngCheckSharedService;
import jp.co.jdsnet.common.utils.StringUtility;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KigbngCheckSharedServiceImpl implements KigbngCheckSharedService {
	private String daikaiskbcod;
	private String gammkrflg;
	private String kigHead;
	private String kigTail;
	private final HinbanMapper hinbanMapper;
	private final DaihyoKaishaJokenMapper daihyoKaishaJokenMapper;
	
	@Override
	public HinbanEntity getHinban(String daikaiskbcod, String kigbng) throws Exception {
		return hinbanMapper.select(HinbanEntity.builder()
									.daikaiskbcod(daikaiskbcod)
									.kigbng(makeKigBng(daikaiskbcod, kigbng))
									.build());
	}

	@Override
	public HinbanEntity getHinbanByJutaku(String daikaiskbcod, String kaiskbcod, String kigbng) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String makeKigBng(String daikaiskbcod, String kigbng) throws Exception {
		System.out.println("BEFORE KIGBNG="+kigbng);
		if(StringUtils.isBlank(kigbng)) {
			return kigbng;
		}
		
		String result = kigbng;
		setGammkrflg(daikaiskbcod);
		if(kigbng.contains(".")) {
			getHinBanHead(kigbng, ".");
			getHinbanTail(kigbng, ".");
			result = getKigbngPadZero();
		} else if(kigbng.contains("-") && !"1".equals(this.gammkrflg)) {
			getHinBanHead(kigbng, "-");
			getHinbanTail(kigbng, "-");
			result = getKigbngPadZero();
		}
		System.out.println("AFTER KIGBNG="+result);
		return result.toUpperCase();
	}

	private void setGammkrflg(String daikaiskbcod) {
		if(StringUtils.isBlank(this.gammkrflg) || !this.daikaiskbcod.equals(daikaiskbcod)) {
			this.daikaiskbcod = daikaiskbcod;
			this.gammkrflg = daihyoKaishaJokenMapper.select(
					DaihyoKaishaJokenEntity.builder()
					.daikaiskbcod(daikaiskbcod)
					.build()).getGammkrflg();
		}
		System.out.println("GAMMKRFLG="+this.gammkrflg);
	}
	
	private void getHinBanHead(String kigbng, String separater) {
		if(kigbng.trim().startsWith(".") || kigbng.trim().startsWith("-")) {
			return;
		} else {
			int separateIdx = kigbng.indexOf(separater,0);
			if(separateIdx >= 0) {
				this.kigHead = kigbng.substring(0, separateIdx).trim();
			}
		}
	}
	
	private void getHinbanTail(String kigbng, String separater) throws Exception {
		if(kigbng.trim().length() == 1) { throw new Exception(); }
		if(StringUtils.isBlank(this.kigHead)) { throw new Exception(); }
		
		int separateIdx = kigbng.indexOf(separater,0);
		this.kigTail = kigbng.substring(separateIdx + 1).trim();
		
		if((this.kigHead.length() + this.kigTail.length()) > 13) { throw new Exception(); }
		if(this.kigHead.contains(" ") || this.kigTail.contains(" ")) { throw new Exception(); }
	}
	
	private String getKigbngPadZero() {
		return this.kigHead.concat(StringUtility.padZero(
				this.kigTail, (13 - this.kigHead.length()))).toUpperCase();
	}
}
