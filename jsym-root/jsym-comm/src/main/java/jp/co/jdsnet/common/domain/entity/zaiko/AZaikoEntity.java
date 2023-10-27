package jp.co.jdsnet.common.domain.entity.zaiko;

import org.apache.ibatis.annotations.AutomapConstructor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AZaikoEntity {
	/** 代表会社識別コード */
	@Builder.Default
	private String daikaiskbcod = "";

	/** 記号番号 */
	@Builder.Default
	private String kigbng = "";

	/** 倉庫コード */
	@Builder.Default
	private String skocod = "";

	/** 在庫数量 */
	@Builder.Default
	private int zaisur = 0;

	/** 前日在庫数量 */
	@Builder.Default
	private int zndzaisur = 0;

	/** 前月在庫数量 */
	@Builder.Default
	private int znmzaisur = 0;

	/** 当月在庫訂正数量（＋） */
	@Builder.Default
	private int tomzaiteisurpls = 0;

	/** 当月在庫訂正数量（－） */
	@Builder.Default
	private int tomzaiteisurmns = 0;

	/** 前月迄在庫訂正数量（＋） */
	@Builder.Default
	private int zmmzaiteisurpls = 0;

	/** 前月迄在庫訂正数量（－） */
	@Builder.Default
	private int zmmzaiteisurmns = 0;

	/** 外倉庫在庫 */
	@Builder.Default
	private int sskzai = 0;

	/** 輸出確保分 */
	@Builder.Default
	private int expkho = 0;

	/** 在庫確保仮引当数量 */
	@Builder.Default
	private int zaikhokhasur = 0;

	/** 翌営出荷仮引当数量 */
	@Builder.Default
	private int ykesyakhasur = 0;

	/** 注残仮引当数量 */
	@Builder.Default
	private int chzkhasur = 0;

	/** Ｃ直仮引当数量 */
	@Builder.Default
	private int cchkhasur = 0;

	/** 新譜受注仮引当数量 */
	@Builder.Default
	private int sinjuckhasur = 0;

	/** 新譜出荷数量 */
	@Builder.Default
	private int sinsyasur = 0;

	/** 入庫予定数量 */
	@Builder.Default
	private int nyoytesur = 0;

	/** 貸出残数量 */
	@Builder.Default
	private int kdazansur = 0;

	/** 改造残数量 */
	@Builder.Default
	private int kzozansur = 0;

	/** 再加工残数量 */
	@Builder.Default
	private int rprzansur = 0;

	/** 積送残数量 */
	@Builder.Default
	private int sekzansur = 0;

	/** 棚上積送残数量 */
	@Builder.Default
	private int tnasekzansur = 0;

	/** 自動振替仮引当数量 */
	@Builder.Default
	private int afkkhasuu = 0;

	/** 前回自動振替振替点在庫数量 */
	@Builder.Default
	private int zkaafkfktzaisur = 0;

	/** 当日生産発注数量 */
	@Builder.Default
	private int todprdhacsur = 0;

	/** 当日仕入発注数量 */
	@Builder.Default
	private int todsirhacsur = 0;

	/** 当日生産入庫数量 */
	@Builder.Default
	private int todprdnyosur = 0;

	/** 当日生産返品数量 */
	@Builder.Default
	private int todprdhpnsur = 0;

	/** 当日仕入入庫数量 */
	@Builder.Default
	private int todsirnyosur = 0;

	/** 当日自動仕入振替数量 */
	@Builder.Default
	private int todasrfkesur = 0;

	/** 当日仕入返品数量 */
	@Builder.Default
	private int todsirhpnsur = 0;

	/** 当日サンプル入庫数量 */
	@Builder.Default
	private int todsmpnyosur = 0;

	/** 当日サンプル出庫数量 */
	@Builder.Default
	private int todsmpsyosur = 0;

	/** 当日ラフテスト入庫数量 */
	@Builder.Default
	private int todrtsnyosur = 0;

	/** 当日ラフテスト出庫数量 */
	@Builder.Default
	private int todrtssyosur = 0;

	/** 当日再加工入庫数量 */
	@Builder.Default
	private int todrprnyosur = 0;

	/** 当日再加工出庫数量 */
	@Builder.Default
	private int todrprsyosur = 0;

	/** 当日改造入庫数量 */
	@Builder.Default
	private int todkzonyosur = 0;

	/** 当日改造出庫数量 */
	@Builder.Default
	private int todkzosyosur = 0;

	/** 当日経費出庫数量 */
	@Builder.Default
	private int todkehsyosur = 0;

	/** 当日輸出出庫数量 */
	@Builder.Default
	private int todexpsyosur = 0;

	/** 当日輸出出庫返品 */
	@Builder.Default
	private int todexpsyohpn = 0;

	/** 当日転送入庫数量 */
	@Builder.Default
	private int todtsonyosur = 0;

	/** 当日転送出庫数量 */
	@Builder.Default
	private int todtsosyosur = 0;

	/** 当日振替入庫数量 */
	@Builder.Default
	private int todfkenyosur = 0;

	/** 当日振替出庫数量 */
	@Builder.Default
	private int todfkesyosur = 0;

	/** 当日部門振替入庫数量 */
	@Builder.Default
	private int todbmnfkenyosur = 0;

	/** 当日部門振替出庫数量 */
	@Builder.Default
	private int todbmnfkesyosur = 0;

	/** 当日償却振替入庫数量 */
	@Builder.Default
	private int todskyfkenyosur = 0;

	/** 当日償却振替出庫数量 */
	@Builder.Default
	private int todskyfkesyosur = 0;

	/** 当日償却数量 */
	@Builder.Default
	private int todskysur = 0;

	/** 当日廃棄数量 */
	@Builder.Default
	private int todhiksur = 0;

	/** 当日棚上数量 */
	@Builder.Default
	private int todtnasur = 0;

	/** 当日棚下数量 */
	@Builder.Default
	private int todtnssur = 0;

	/** 当日会社間売上数量 */
	@Builder.Default
	private int todkikurisur = 0;

	/** 当日会社間返品数量 */
	@Builder.Default
	private int todkikhpnsur = 0;

	/** 当日貸出出荷数量 */
	@Builder.Default
	private int todkdasyasur = 0;

	/** 当日貸出戻入数量 */
	@Builder.Default
	private int todkdareisur = 0;

	/** 当日貸出売上数量 */
	@Builder.Default
	private int todkdaurisur = 0;

	/** 当日特注売上数量 */
	@Builder.Default
	private int todtcyurisur = 0;

	/** 当日輸出売上数量 */
	@Builder.Default
	private int todexpurisur = 0;

	/** 当日管轄内商品売上数量 */
	@Builder.Default
	private int todknnshourisur = 0;

	/** 当日管轄外商品売上数量 */
	@Builder.Default
	private int todkngshourisur = 0;

	/** 当日管轄内通常売上数量 */
	@Builder.Default
	private int todknntjyurisur = 0;

	/** 当日管轄外通常売上数量 */
	@Builder.Default
	private int todkngtjyurisur = 0;

	/** 当日管轄内通常外売上数量 */
	@Builder.Default
	private int todknntjgurisur = 0;

	/** 当日管轄外通常外売上数量 */
	@Builder.Default
	private int todkngtjgurisur = 0;

	/** 当日管轄内特販売上数量 */
	@Builder.Default
	private int todknnthnurisur = 0;

	/** 当日管轄外特販売上数量 */
	@Builder.Default
	private int todkngthnurisur = 0;

	/** 夜間伝票発行当日振替出庫数量 */
	@Builder.Default
	private int ydhtodfkesyosur = 0;

	/** 夜間伝票発行当日会社間売上数量 */
	@Builder.Default
	private int ydhtodkikurisur = 0;

	/** 夜間伝票発行当日会社間返品数量 */
	@Builder.Default
	private int ydhtodkikhpnsur = 0;

	/** 当日受注数量 */
	@Builder.Default
	private int todjucsur = 0;

	/** 当日出荷数量 */
	@Builder.Default
	private int todsyasur = 0;

	/** 当日全受注数量 */
	@Builder.Default
	private int todalljucsur = 0;

	/** 当日全出荷数量 */
	@Builder.Default
	private int todallsyasur = 0;

	/** 当月生産発注数量 */
	@Builder.Default
	private int tomprdhacsur = 0;

	/** 当月仕入発注数量 */
	@Builder.Default
	private int tomsirhacsur = 0;

	/** 当月生産入庫数量 */
	@Builder.Default
	private int tomprdnyosur = 0;

	/** 当月生産返品数量 */
	@Builder.Default
	private int tomprdhpnsur = 0;

	/** 当月仕入入庫数量 */
	@Builder.Default
	private int tomsirnyosur = 0;

	/** 当月自動仕入振替数量 */
	@Builder.Default
	private int tomasrfkesur = 0;

	/** 当月仕入返品数量 */
	@Builder.Default
	private int tomsirhpnsur = 0;

	/** 当月サンプル入庫数量 */
	@Builder.Default
	private int tomsmpnyosur = 0;

	/** 当月サンプル出庫数量 */
	@Builder.Default
	private int tomsmpsyosur = 0;

	/** 当月ラフテスト入庫数量 */
	@Builder.Default
	private int tomrtsnyosur = 0;

	/** 当月ラフテスト出庫数量 */
	@Builder.Default
	private int tomrtssyosur = 0;

	/** 当月再加工入庫数量 */
	@Builder.Default
	private int tomrprnyosur = 0;

	/** 当月再加工出庫数量 */
	@Builder.Default
	private int tomrprsyosur = 0;

	/** 当月改造入庫数量 */
	@Builder.Default
	private int tomkzonyosur = 0;

	/** 当月改造出庫数量 */
	@Builder.Default
	private int tomkzosyosur = 0;

	/** 当月経費出庫数量 */
	@Builder.Default
	private int tomkehsyosur = 0;

	/** 当月輸出出庫数量 */
	@Builder.Default
	private int tomexpsyosur = 0;

	/** 当月輸出出庫返品 */
	@Builder.Default
	private int tomexpsyohpn = 0;

	/** 当月転送入庫数量 */
	@Builder.Default
	private int tomtsonyosur = 0;

	/** 当月転送出庫数量 */
	@Builder.Default
	private int tomtsosyosur = 0;

	/** 当月振替入庫数量 */
	@Builder.Default
	private int tomfkenyosur = 0;

	/** 当月振替出庫数量 */
	@Builder.Default
	private int tomfkesyosur = 0;

	/** 当月部門振替入庫数量 */
	@Builder.Default
	private int tombmnfkenyosur = 0;

	/** 当月部門振替出庫数量 */
	@Builder.Default
	private int tombmnfkesyosur = 0;

	/** 当月償却振替入庫数量 */
	@Builder.Default
	private int tomskyfkenyosur = 0;

	/** 当月償却振替出庫数量 */
	@Builder.Default
	private int tomskyfkesyosur = 0;

	/** 当月償却数量 */
	@Builder.Default
	private int tomskysur = 0;

	/** 当月廃棄数量 */
	@Builder.Default
	private int tomhiksur = 0;

	/** 当月棚上数量 */
	@Builder.Default
	private int tomtnasur = 0;

	/** 当月棚下数量 */
	@Builder.Default
	private int tomtnssur = 0;

	/** 当月会社間売上数量 */
	@Builder.Default
	private int tomkikurisur = 0;

	/** 当月会社間返品数量 */
	@Builder.Default
	private int tomkikhpnsur = 0;

	/** 当月貸出出荷数量 */
	@Builder.Default
	private int tomkdasyasur = 0;

	/** 当月貸出戻入数量 */
	@Builder.Default
	private int tomkdareisur = 0;

	/** 当月貸出売上数量 */
	@Builder.Default
	private int tomkdaurisur = 0;

	/** 当月特注売上数量 */
	@Builder.Default
	private int tomtcyurisur = 0;

	/** 当月輸出売上数量 */
	@Builder.Default
	private int tomexpurisur = 0;

	/** 当月管轄内商品売上数量 */
	@Builder.Default
	private int tomknnshourisur = 0;

	/** 当月管轄外商品売上数量 */
	@Builder.Default
	private int tomkngshourisur = 0;

	/** 当月管轄内通常売上数量 */
	@Builder.Default
	private int tomknntjyurisur = 0;

	/** 当月管轄外通常売上数量 */
	@Builder.Default
	private int tomkngtjyurisur = 0;

	/** 当月管轄内通常外売上数量 */
	@Builder.Default
	private int tomknntjgurisur = 0;

	/** 当月管轄外通常外売上数量 */
	@Builder.Default
	private int tomkngtjgurisur = 0;

	/** 当月管轄内特販売上数量 */
	@Builder.Default
	private int tomknnthnurisur = 0;

	/** 当月管轄外特販売上数量 */
	@Builder.Default
	private int tomkngthnurisur = 0;

	/** 当月受注数量 */
	@Builder.Default
	private int tomjucsur = 0;

	/** 当月出荷数量 */
	@Builder.Default
	private int tomsyasur = 0;

	/** 当月全受注数量 */
	@Builder.Default
	private int tomalljucsur = 0;

	/** 当月全出荷数量 */
	@Builder.Default
	private int tomallsyasur = 0;

	/** 生産入庫数量累計 */
	@Builder.Default
	private int prdnyosurrui = 0;

	/** 仕入入庫数量累計 */
	@Builder.Default
	private int sirnyosurrui = 0;

	/** 償却数量累計 */
	@Builder.Default
	private int skysurrui = 0;

	/** 廃棄数量累計 */
	@Builder.Default
	private int hiksurrui = 0;

	/** 旧ＡＶＩＳフラグ */
	@Builder.Default
	private String oldavisflg = "";

	/** 更新区分 */
	@Builder.Default
	private String updkbn = "";

	/** 更新日付 */
	@Builder.Default
	private int upddte = 0;

	/** 更新時刻 */
	@Builder.Default
	private int updjkk = 0;
	
	
	@AutomapConstructor
	private AZaikoEntity(String daikaiskbcod, String kigbng, int zaisur, int zaikhokhasur, int sinjuckhasur, int sinsyasur, int chzkhasur, int ykesyakhasur, int sekzansur, int kdazansur, int todjucsur, int todsyasur, int tomjucsur, int tomsyasur) {
		this.daikaiskbcod = daikaiskbcod;
		this.kigbng = kigbng;
		this.zaisur = zaisur;
		this.zaikhokhasur = zaikhokhasur;
		this.sinjuckhasur = sinjuckhasur;
		this.sinsyasur = sinsyasur;
		this.chzkhasur = chzkhasur;
		this.ykesyakhasur = ykesyakhasur;
		this.sekzansur = sekzansur;
		this.kdazansur = kdazansur;
		this.todjucsur = todjucsur;
		this.todsyasur = todsyasur;
		this.tomjucsur = tomjucsur;
		this.tomsyasur = tomsyasur;
	}
}
