package org.myStudy.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.myStudy.constant.Constant;
import org.myStudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSessionFilter extends AccessControlFilter {

	@Autowired
	private IUserService userService;
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		if (subject == null) {
			// 没有登录
			return false;
		}
		HttpSession session = WebUtils.toHttp(request).getSession();
		Object currentUser = session.getAttribute(Constant.SESSION_USER);
		if (currentUser == null) {
			//获取当前登录用户，存入session中
			Object principal = subject.getPrincipal();
			if (principal != null) {
				currentUser = userService.getByUserName(principal.toString());
				session.setAttribute(Constant.SESSION_USER, currentUser);
			}
		}
		return true;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return false;
	}
}
