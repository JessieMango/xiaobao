package com.hqgj.xb.util;

/**
 * String工具类
 * 
 * @author 崔兴伟
 * @datetime 2015年6月17日 下午2:53:01
 */
public class StringUtil {

	/**
	 * 格式化字符串 例：
	 * 
	 * formateString("xxx{0}bbb",1) = xxx1bbb
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年6月17日 下午2:56:19
	 * @param str
	 * @param params
	 * @return
	 */
	public static String formateString(String str, String... params) {
		for (int i = 0; i < params.length; i++) {
			str = str
					.replace("{" + i + "}", params[i] == null ? "" : params[i]);
		}
		return str;
	}
}
