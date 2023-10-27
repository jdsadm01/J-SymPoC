package jp.co.jdsnet.base.webapp.parts;

import java.text.DecimalFormat;
import java.util.Objects;

import org.springframework.ui.Model;

import io.micrometer.common.util.StringUtils;
import jp.co.jdsnet.base.webapp.form.FormInterface;
import jp.co.jdsnet.common.utils.FormatUtility;
import jp.co.jdsnet.common.utils.StringUtility;

public abstract class CommonClipboardData <T extends FormInterface> {

	/** クリップボードデータをrequestにセットするキー */
	public static final String CLIPBOARD_DATA_KEY = "CLIPBOARD_DATA_KEY";

	/** 改行：\n */
	protected static final String ENTER = "\n";
	/** タブ：\t */
	protected static final String TAB = "\t";
	/** 波線：～ */
	protected static final String WAVEDASH = "～";
	/** パーセント：% */
	protected static final String PERCENT = "%";
	/** クリップボードデータ */
	protected StringBuilder cbData = new StringBuilder();
	
	protected CommonClipboardData(Model model, T form) {
		createClipboardData(form);
		model.addAttribute(CLIPBOARD_DATA_KEY, cbData.toString());
	}
	
	/**
	 * クリップボードに送るデータを生成します。
	 */
	abstract protected void createClipboardData(T form);
	
	/**
	 * 渡されたデータをクリップボードデータの末尾に加えます。<br>
	 * データがnullだった場合は、ブランクを加えます。
	 * @param data
	 */
	protected void add(Object data){
		cbData.append(nullToBlank(data));
	}
	
	/**
	 * 渡されたデータをクリップボードデータの末尾に加え、TABを追加します。<br>
	 * データがnullだった場合は、ブランクを加えます。
	 * @param data
	 */
	protected void addTab(Object data){
		cbData.append(nullToBlank(data));
		tab();
	}
	
	/**
	 * 渡されたデータをクリップボードデータの末尾に加え、行を終了します。<br>
	 * データがnullだった場合は、ブランクを加えます。
	 * @param data
	 */
	protected void addln(Object data){
		cbData.append(nullToBlank(data));
		enter();
	}
	
	/**
	 * クリップボードデータの行を終了します。
	 */
	protected void enter(){
		cbData.append(ENTER);
	}
	
	/**
	 * クリップボードデータにTABを加えます。
	 */
	protected void tab(){
		cbData.append(TAB);
	}
	
	/**
	 * 渡されたデータがnullだったらブランク、そうでないときはデータをそのまま返します。
	 * @param data
	 * @return dataがnullならばブランク、そうでなければdata
	 */
	protected Object nullToBlank(Object data){
		return Objects.isNull(data)? "" : data;
	}
	
	/**
	 * 渡されたデータをタブ区切りにして返します。
	 * @param title
	 * @param data1
	 * @return タブ区切り文字列
	 */
	protected String createStringSet(String title, Object data1) {
		return title + TAB + nullToBlank(data1) + TAB;
	}
	
	/**
	 * 渡されたデータをタブ区切りにして返します。
	 * @param title
	 * @param data1
	 * @param data2
	 * @return タブ区切り文字列
	 */
	protected String createStringSet(String title, Object data1, Object data2) {
		return title + TAB + 
				nullToBlank(data1) + TAB + 
				nullToBlank(data2) + TAB;
	}
	
	/**
	 * 渡されたデータをタブ区切りにし、fromData、toDataの間には"～"を入れて返します。<br>
	 * "～"はTOに入力があるときのみ追加します。
	 * @param title
	 * @param fromData
	 * @param toData
	 * @return タブ区切り文字列(FROM～TO)
	 */
	protected String createStringSetFromTo1(String title, Object fromData, Object toData) {
		StringBuilder sb = new StringBuilder();
		sb.append(title + TAB + nullToBlank(fromData) + TAB);
		if(!isEmpty(toData))
			sb.append(WAVEDASH);
		else
			sb.append("");
		sb.append(TAB + nullToBlank(toData) + TAB);		
		return sb.toString();
	}
	
	/**
	 * 渡されたデータをタブ区切りにし、fromData、toDataの間には"～"を入れて返します。<br>
	 * "～"はFROM、TOいずれかに入力があるときのみ追加します。
	 * @param title
	 * @param fromData
	 * @param toData
	 * @return タブ区切り文字列(FROM～TO)
	 */
	protected String createStringSetFromTo2(String title, Object fromData, Object toData) {
		StringBuffer sb = new StringBuffer();
		sb.append(title + TAB + nullToBlank(fromData) + TAB);
		if(!isEmpty(fromData) || !isEmpty(toData))
			sb.append(WAVEDASH);
		else
			sb.append("");
		sb.append(TAB + nullToBlank(toData) + TAB);		
		return sb.toString();
	}
	
	/**
	 * 渡されたデータをタブ区切りにして返します。
	 * @param dataArr
	 * @return タブ区切り文字列
	 */
	protected String createStringSet(Object[] dataArr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < dataArr.length; i++) {
			sb.append(nullToBlank(dataArr[i]));
			sb.append(TAB);
		}
		return sb.toString();
	}
	
	/**
	 * 渡されたデータを（）で括って返します。
	 * @param data
	 * @return 変換済み文字列
	 */
	protected String roundBracket(Object data) {
		return "（" + nullToBlank(data) + "）";
	}
	
	/**
	 * 渡されたデータを＜＞で括って返します。
	 * @param data
	 * @return 変換済み文字列
	 */
	protected String angleBracket(Object data) {
		return "＜" + nullToBlank(data) + "＞";
	}
	
	/**
	 * 渡されたデータの右端から半角・全角スペースを取り除き、エクセルの文字列に変換して返します。
	 * @param data
	 * @return 変換済み文字列（="data"）
	 */
	protected String toText(Object data) {
		if (isEmpty(data))
			return "";
		String s = String.valueOf(data).trim();
		s = StringUtility.removeSuffix(s, "　");//右側の全角スペースを取り除く
		return "=\"" + escapeString(s) + "\"";
	}

	/**
	 * エクセルの文字列に変換して返します。
	 * (半角・全角ブランク取り除き有無フラグ有り).
	 * @param data
	 * @param isTrim (isTrimがtrueの時はtrimあり、falseの時はtrim無し)
	 * @return 変換済み文字列（="data"）
	 */
	protected String toText(Object data, boolean isTrim) {
		if(isTrim) {
		   return toText(data);
		} else {
		   if (Objects.isNull(data)) return "";
		   else{
				String s = String.valueOf(data);
				return "=\"" + escapeString(s) + "\"";
		   }
		}
	}	

	/**
	 * ダブルクォーテーション(「"」「”」「＂」)をエスケープして返します。
	 * @param s
	 * @return エスケープ済みの文字列
	 */
	private String escapeString(String text) {
		//「"」「”」「＂」が含まれていなければ渡された値を返す
		if (text.indexOf('"') < 0
			&& text.indexOf('”') < 0
			&& text.indexOf('＂') < 0) {
			return text;
		}
		StringBuffer sb = new StringBuffer();
		for (int idx = 0; idx < text.length(); idx++) {
			char ch = text.charAt(idx);
			if (('"' == ch) || ('”' == ch) || ('＂' == ch)) {
				sb.append("\"");
			}
			sb.append(ch);
		}
		return sb.toString();
	}

	/**
	 * 渡された数値データをカンマ区切りに変換して返します。
	 * @param data
	 * @return 変換済み文字列（３桁区切り）
	 * @see #formatAsNumber(String, String)
	 */
	protected String toDigit(Object data) {
		if (isEmpty(data))
			return "";
		return formatAsNumber(String.valueOf(data).trim(), null);
	}
	
	/**
	 * 渡された数値データを指定されたフォーマットに変換して返します。
	 * @param data
	 * @param formatStr
	 * @return 変換済み文字列
	 * @see #formatAsNumber(String, String)
	 */
	protected String toDigit(Object data, String formatStr) {
		if (isEmpty(data))
			return "";
		return formatAsNumber(String.valueOf(data).trim(), formatStr);
	}
	
	/**
	 * nested-exタグのtype属性にnumberを指定したのと同じ仕様で数値フォーマットを行います。
	 * @param valueToFormat
	 * @return フォーマット済み文字列
	 * @see jp.co.jdsnet.common.taglib.NestedWriteTagEx#formatAsNumber(String)
	 */
	private String formatAsNumber(String valueToFormat, String formatStr) {
		Object value = valueToFormat;
		try {
			Long l = Long.parseLong(valueToFormat);
			if (StringUtils.isBlank(formatStr))
				formatStr = "###,###,###,###,##0";//デフォルトformatStr			
			value = l;//java.lang.Long型で渡す
		
		} catch (NumberFormatException e) {
			try{
				Double d = Double.parseDouble(valueToFormat);
				if (StringUtils.isBlank(formatStr))
					formatStr = "###,###,###,###,##0.#############";//デフォルトformatStr
				value = d;//java.lang.Double型で渡す
			} catch (NumberFormatException e2) {
				return valueToFormat;
			}
		}
		return new DecimalFormat(formatStr).format(value);
	}
	
	/**
	 * 渡されたデータを日付型（yyyy/MM/dd）に変換して返します。
	 * @param data（yMMdd or yyMMdd）
	 * @return 変換済み文字列（yyyy/MM/dd）
	 * @see DataGetUtils#convertYYYYMMDD(String)
	 * @see DataFormatUtils#setFormatYYYYMMDD(String)
	 */
	protected String toDate(Object data) {
		if (isEmpty(data)) { return ""; }
		
		return FormatUtility.setFormatYYYYMMDD(String.valueOf(data).trim());
	}
	
	/**
	 * 渡されたデータを時刻型（H:mm:ss）に変換して返します。
	 * @param data（Hmmss or HHmmss）
	 * @return 変換済み文字列（H:mm:ss）
	 * @see DataFormatUtils#setFormatHHMMSS(String)
	 */
	protected String toTime(Object data) {
		if (isEmpty(data)) { return ""; }
		
		return FormatUtility.setFormatHHMMSS(String.valueOf(data).trim());
	}
	
	/**
	 * 渡されたデータから指定された文字列を取り除いて返します。
	 * @param data
	 * @param remStr 取り除きたい文字列
	 * @return 編集済み文字列
	 */
	protected String remove(Object data, String remStr) {
		if (Objects.isNull(data)) { return ""; }
		
		return String.valueOf(data).replace(remStr, "");
	}
	
	/**
	 * 渡されたデータが空かどうかチェックしてtrue/falseを返します。
	 * @param data
	 * @return ブランク または nullならばtrue、そうでなければfalse
	 */
	protected boolean isEmpty(Object data){
		return StringUtils.isBlank(Objects.toString(data, null));
	}
}
