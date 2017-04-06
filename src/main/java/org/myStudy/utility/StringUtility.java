package org.myStudy.utility;

import java.util.ArrayList;
import java.util.List;

import org.myStudy.entity.BaseEntity;

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

	/**
	 * 将驼峰式命名的字符串转换为下划线大写方式。如果传入null，则返回null。</br>
	 * 例如：helloWorld->HELLO_WORLD
	 * @param name 转换前的驼峰式命名的字符串
	 * @return 转换后下划线大写方式命名的字符串
	 */
	public static String toUnderscoreName(String name) {
		if (name == null)
			return null;
	    StringBuilder result = new StringBuilder();
	    if (name.length() > 0) {
	        // 将第一个字符处理成大写
	        result.append(name.substring(0, 1).toUpperCase());
	        // 循环处理其余字符
	        for (int i = 1; i < name.length(); i++) {
	            String s = name.substring(i, i + 1);
	            // 在大写字母前添加下划线
	            if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
	                result.append("_");
	            }
	            // 其他字符直接转成大写
	            result.append(s.toUpperCase());
	        }
	    }
	    return result.toString();
	}
	
	/**
	 * 获取实体集合entityList的id拼接字符串
	 * @param list BaseEntity类型集合
	 * @return
	 */
	public static String getIdsFromEntityList(List<?> list) {
		List<Integer> idList = new ArrayList<Integer>();
		if (list == null || list.isEmpty())
			return null;
		for (Object obj : list) {
			if (obj instanceof BaseEntity) {
				BaseEntity entity = (BaseEntity)obj;
				idList.add(entity.getId());
			}
		}
		return StringUtility.join(idList, ",");
	}
}
