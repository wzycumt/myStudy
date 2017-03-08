<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<title>404 页面</title>
</head>
<body class="gray-bg">
  <div class="middle-box text-center animated fadeInDown">
    <h1>404</h1>
    <h3 class="font-bold">页面未找到！</h3>
    <div class="error-desc">
      <span>抱歉，页面好像去火星了~</span>
      <form class="form-inline m-t" role="form">
        <div class="form-group">
          <input type="email" class="form-control" placeholder="请输入您需要查找的内容 …">
        </div>
        <button type="submit" class="btn btn-primary">搜索</button>
      </form>
    </div>
  </div>
</body>
</html>
