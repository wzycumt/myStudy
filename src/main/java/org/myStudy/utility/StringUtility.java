package org.myStudy.utility;

import java.util.List;

public class StringUtility {
	
	/**
	 * 判断是否为空
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty(String value) {
		if (value == null || value.trim().equals(""))
			return true;
		return false;
	}
	
	/**
	 * 将list集合拼接为字符串
	 * @param list
	 * @param separator 分隔符
	 * @return
	 */
	public static String join(List<Integer> list, String separator) {
		if (list == null || list.isEmpty())
			return null;
		StringBuilder sBuilder = new StringBuilder();
		for (Integer item : list) {
			if (item != null)
				sBuilder.append("," + item.toString());
		}
		sBuilder.deleteCharAt(0);
		return sBuilder.toString();
	}

}
