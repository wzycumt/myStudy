<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<title>登录</title>
<script language="JavaScript"> 
	if (window != top)
		top.location.href = location.href;
</script>
</head>
<body class="gray-bg">
  <div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
      <div>
        <h1 class="logo-name">H+</h1>
      </div>
      <h3>欢迎使用 H+</h3>

      <form class="m-t" role="form" action="login" method="post">
        <div class="form-group">
          <input type="text" class="form-control" name="userName" placeholder="用户名" required="">
        </div>
        <div class="form-group">
          <input type="password" class="form-control" name="password" placeholder="密码" required="">
        </div>
        <div class="form-group row">
          <div class="col-xs-5 text-left">
            <div class="i-checks">
              <input type="checkbox" id="rememberMe" name="rememberMe"><label for="rememberMe">记住我</label>
            </div>
          </div>
          <div class="col-xs-7 text-right">
            <span class="text-danger">${message}</span>
          </div>
        </div>
        <button type="submit" class="btn btn-success block full-width m-b">登 录</button>
        <p class="text-muted text-center">
          <a href="login.html"><small>忘记密码了？</small></a>
        </p>
      </form>
    </div>
  </div>
</body>
</html>