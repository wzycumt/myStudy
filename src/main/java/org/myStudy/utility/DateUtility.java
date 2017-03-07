package org.myStudy.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 * 
 * @author WZY
 */
public class DateUtility {
	/**
	 * 获取最小时间1000-01-01 00:00:00
	 */
	public static Date getMinDateTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1000, 0, 1, 0, 0, 0);
		return calendar.getTime();
	}

	/**
	 * 获取最大时间9999-12-31 23:59:59
	 */
	public static Date getMaxDateTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(9999, 11, 31, 23, 59, 59);
		return calendar.getTime();
	}

	/**
	 * 格式化日期
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return "1000-01-01";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 格式化日期时间
	 * @param dateTime
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String formatDateTime(Date dateTime) {
		if (dateTime == null) {
			return "1000-01-01 00:00:00";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dateTime);
	}
}
