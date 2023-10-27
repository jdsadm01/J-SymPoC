package jp.co.jdsnet.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Objects;

import io.micrometer.common.util.StringUtils;
//import java.util.List;

public class StringUtility {

	
	/**
	 * 左方ゼロ埋め（文字列型数値）<BR>
	 * 引数が空の場合、変換後文字列の長さ分"0"を返す<BR>
	 * 引数が数字でない場合は、例外が発生する<BR>
	 * 
	 * @param str
	 *            文字列型変換前数値
	 * @param len
	 *            変換後文字列の長さ
	 * @return 左方ゼロ埋めした文字列。変換前の長さが変換後の長さよりも大きい場合に、例外が発生する。
	 */
	public static String padZero(String str, int len) {

		int i = 0;

		if (StringUtils.isNotBlank(str.trim())) {
			i = Integer.parseInt(str);
		}
		return padZero(i, len, true, false);

	}
	
	/**
	 * 左方ゼロ埋め
	 * 
	 * @param i
	 *            変換前数値
	 * @param len
	 *            変換後文字列の長さ
	 * @param todoCheckLength
	 *            変換前の長さが変換後の長さよりも大きい場合に、例外が発生するどうか。
	 * @param todoTrim
	 *            変換前の長さが変換後の長さよりも大きい場合に、右方切り捨てを行うかどうか。
	 * @return 左方ゼロ埋めした文字列
	 */
	public static String padZero(int i, int len, boolean todoCheckLength,
			boolean todoTrim) {
		return padZero(Integer.valueOf(i).longValue(), len, todoCheckLength,
				todoTrim);
	}
	
	/**
	 * 左方ゼロ埋め
	 * 
	 * @param l
	 *            変換前数値
	 * @param len
	 *            変換後文字列の長さ
	 * @param todoCheckLength
	 *            変換前の長さが変換後の長さよりも大きい場合に、例外が発生するどうか。
	 * @param todoTrim
	 *            変換前の長さが変換後の長さよりも大きい場合に、右方切り捨てを行うかどうか。
	 * @return 左方ゼロ埋めした文字列
	 */
	public static String padZero(long l, int len, boolean todoCheckLength,
			boolean todoTrim) {

		if (len <= 0) {
			throw new IllegalArgumentException("変換後の文字列の長さに0以下を指定した。: len = "
					+ len);
		}

		String tmpStr = Long.toString(l);

		if (isOverMaxLength(tmpStr, len)) {

			if (todoCheckLength) {
				throw new IndexOutOfBoundsException(
						"変換前の文字列の長さが変換後の文字列の長さよりも大きい。: str = " + tmpStr
								+ " ,len = " + len);
			}

			if (todoTrim) {

				tmpStr = rTrim(tmpStr, len);

				if ("-".equals(tmpStr) || "+".equals(tmpStr)) {
					tmpStr = "0";
				}
			}

		}

		return new Formatter().format("%1$0" + Integer.toString(len) + "d",
				Long.parseLong(tmpStr)).toString();

	}
	
	/**
	 * 文字列の左字埋めを行います。
	 * @param target 字埋め対象の文字列
	 * @param length 字埋め後の文字列長
	 * @param pad 追加される文字
	 * @return targetの前にpadが追加された文字列。追加された結果がlength以上の長さになるときは、(結果の長さ-length)からの部分文字列。
	 * @exception NullPointerException   引数がnullの場合
	 * @exception IllegalArgumentException   lengthが負の場合
	 * @exception IllegalArgumentException   padが空の文字列の場合
	 */	
	public static String lpad(String target,int length,String pad){
		if(Objects.isNull(target) || Objects.isNull(pad))		
			throw new java.lang.NullPointerException();
		if(length < 0)
			throw new java.lang.IllegalArgumentException("lenght is too small");
		if(StringUtils.isEmpty(pad))
			throw new java.lang.IllegalArgumentException("pad has no character");

		StringBuilder sb = new StringBuilder(target);
		while(sb.length() < length){
			sb.insert(0,pad);
		}
		
		return sb.substring(sb.length() - length);	
	}

	/**
	 * 右方切捨て<BR>
	 * マルチバイト文字を含む場合は、例外を発生する。<BR>
	 * 
	 * @param str
	 *            変換前文字列
	 * @param len
	 *            切捨て後文字列長さ
	 * @return 長さが切捨て後文字列長さよりも大きい場合は、右方切捨てした文字列。
	 */
	public static String rTrim(String str, int len) {

		if (isContainMultiByte(str)) {
			throw new IllegalArgumentException("マルチバイト文字を含む文字列を指定した。: str = "
					+ str);
		}

		if (isOverMaxLength(str, len)) {
			return str.substring(0, len);
		} else {
			return str;
		}
	}
	
	/**
	 * マルチバイト文字を含むか
	 * 
	 * @param str
	 *            文字列
	 * @return マルチバイト文字を含むかどうか。
	 */
	public static boolean isContainMultiByte(String str) {
		if (str == null) {
			return false;
		} else {
			try {
				return (str.length() != str
						.getBytes("IBM943").length);
			} catch (UnsupportedEncodingException e) {
//				log.info(LOG_MESSAGE_BASE_CHARSET_IS_UNSUPORTED, e);
				return false;
			}
		}
	}

	/**
	 * 長さが最大長（文字数）よりも大きいか
	 * 
	 * @param str
	 *            文字列
	 * @param len
	 *            指定長さ
	 * @return 長さが指定長さよりも大きいかどうか。
	 */
	public static boolean isOverMaxLength(String str, int len) {

		if (str == null) {
			return false;
		} else if (str.length() > len) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * 文字列の右端から指定した文字を取り除いた新しい文字列を返します。
	 * @param target 対象の文字列
	 * @param suffix 取り除きたい文字列
	 * @return 指定した文字を取り除いた文字列。引数が空のときはtargetをそのまま返す。
	 * @exception NullPointerException   引数がnullの場合
	 */
	public static String removeSuffix(String target,String suffix){
		if(Objects.isNull(target) || Objects.isNull(suffix))
		   throw new java.lang.NullPointerException();
		if(StringUtils.isBlank(target) || StringUtils.isBlank(suffix))
		   return target;

		String str = target;
		while(str.endsWith(suffix)){
		   str = str.substring(0,str.length()-suffix.length());
		}    		
   	   
		return str;   	    
	}


	/**
	 * クエリー編集（リスト）(VZJ053)<br>
	 * 条件値リストよりSQL条件用に文字列を編集する。
	 * @param editList 条件値リスト
	 * @return editListQuery 条件キー編集済み文字列
	 */
//	public static String editListToQuery(List queryList){
//		
//		String editQueryList = null;
//		if(queryList == null || queryList.size() == 0){
//			editQueryList = "= ''";
//		}else if(queryList.size() == 1){
//			editQueryList = "= '" + queryList.get(0) + "'";
//		}else if(queryList.size() > 1){
//			StringBuffer queryBuffer = new StringBuffer();
//			queryBuffer.append( "IN ('" );
//			for(int i=0; i<queryList.size(); i++){
//				queryBuffer.append(queryList.get(i));
//				if(i == queryList.size() - 1){
//				}else{
//					queryBuffer.append("','");
//				}
//			}
//			queryBuffer.append("')");
//			editQueryList = queryBuffer.toString();
//		}
//		return editQueryList;	
//	}

}
