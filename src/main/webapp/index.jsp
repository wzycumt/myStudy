<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>myStudy</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="">myStudy</a>
    </div>
    <div class="navbar-collapse collapse" id="navbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="javascript:void(0)">Abort</a></li>
        <li><a href="javascript:void(0)">Contact</a></li>
      </ul>
    </div>
  </div>
  </nav>

  <div class="container-fluid">
    <div class="row">
      <div class="col-md-2 sidebar">
        <ul class="nav nav-sidebar">
          <li class="active"><a href="#">系统信息 <span class="sr-only">(current)</span></a></li>
          <li><a href="#">Reports</a></li>
          <li><a href="#">Analytics</a></li>
          <li><a href="#">Export</a></li>
        </ul>
      </div>
      <div class="col-md-10 col-md-offset-2 main">
        <%@include file="WEB-INF/views/sysInfo.jsp"%>
      </div>
    </div>
  </div>
</body>
</html>
