package org.myStudy.utility;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.myStudy.Constant.Constant;
import org.myStudy.entity.User;

/**
 * 应用程序工具类
 * @author WZY
 */
public class ApplycationUtility {
	
	/**
	 * 获取当前登录用户
	 * @return
	 */
	public static User getCurrentUser() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(); 
			Object sessionUser = session.getAttribute(Constant.SESSION_USER);
			if (session != null) {
				User currentUser = (User)sessionUser;
				return currentUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取当前登录用户Id
	 * @return
	 */
	public static int getCurrentUserId() {
		User currentUser = getCurrentUser();
		if (currentUser != null)
			return currentUser.getId();
		return 0;
	}
}
