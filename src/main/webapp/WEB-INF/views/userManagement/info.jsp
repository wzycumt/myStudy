<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="org.myStudy.enums.BaseStatusEnum"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户信息</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<link href="${pageContext.request.contextPath}/resources/hplus-v4.1.0/css/plugins/iCheck/custom.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/hplus-v4.1.0/js/plugins/iCheck/icheck.min.js"></script>
</head>
<body class="fixed-sidebar gray-bg">
  <div class="container">
    <form class="form-horizontal" id="mainForm" action="user/add" method="post">
      <div class="page-header text-center">
        <h4>用户信息</h4>
        <input type="hidden" class="form-control" name="id" value="${user.id }">
        <input type="hidden" class="form-control" name="creator" value="${user.creator }">
        <input type="hidden" class="form-control" name="createTime" value="${user.createTimeStr }">
        <input type="hidden" class="form-control" name="updatePerson" value="${user.updatePerson }">
        <input type="hidden" class="form-control" name="updateTime" value="${user.updateTimeStr }">
        <input type="hidden" class="form-control" name="version" value="${user.version }">
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">用户名</label>
        <div class="col-xs-10">
          <input type="text" class="form-control" name="userName" value="${user.userName }">
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">昵称</label>
        <div class="col-xs-10">
          <input type="text" class="form-control" name="nickname" value="${user.nickname }">
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">真实姓名</label>
        <div class="col-xs-10">
          <input type="text" class="form-control" name="realName" value="${user.realName }">
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">手机</label>
        <div class="col-xs-10">
          <input type="text" class="form-control" name="phone" value="${user.phone }">
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">E-mail</label>
        <div class="col-xs-10">
          <input type="email" class="form-control" name="email" value="${user.email }">
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">状态</label>
        <div class="col-xs-10">
          <div class="radio i-checks">
            <label><input type="radio" <c:if test="${user.status != BaseStatusEnum.VALID }"> checked="" </c:if> value="<%=BaseStatusEnum.INVALID %>" name="status"> 无效 </label> 
            <label><input type="radio" <c:if test="${user.status == BaseStatusEnum.VALID }"> checked="" </c:if> value="<%=BaseStatusEnum.VALID %>" name="status"> 有效</label>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">备注</label>
        <div class="col-xs-10">
          <textarea class="form-control" name="remark" rows="3"></textarea>
        </div>
      </div>
    </form>
  </div>
</body>
</html>