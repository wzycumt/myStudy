<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<title>用户信息</title>
</head>
<body class="fixed-sidebar">
  <div class="container">
    <form:form class="form-horizontal" modelAttribute="userModel" id="mainForm" action="user/info" method="post">
      <div class="page-header text-center">
        <h4>用户信息</h4>
        <form:hidden path="user.id"/>
        <form:hidden path="user.creator"/>
        <form:hidden path="user.createTime"/>
        <form:hidden path="user.updatePerson"/>
        <form:hidden path="user.updateTime"/>
        <form:hidden path="user.version"/>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">用户名</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="user.userName" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">昵称</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="user.nickname" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">真实姓名</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="user.realName" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">手机</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="user.phone" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">E-mail</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="user.email" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">状态</label>
        <div class="col-xs-10">
          <div class="radio i-checks">
            <form:radiobuttons class="form-control" path="user.status" itemLabel="description" />
          </div>
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">角色</label>
        <div class="col-xs-10">
<!--           <div class="radio i-checks"> -->
<%--             <form:checkboxes path="user.roleIds" items="${userModel.dicRoleList}"/> --%>
<!--           </div> -->
          <form:select path="user.roles[0].id" class="form-control" items="${userModel.dicRoleList}"></form:select>
<!--           <a class="btn btn-default" id="btnSelectRole">选择</a> -->
<%--           <form:hidden class="form-control" path="user.roles"/> --%>
<!--           <span class="label label-default label-item">管理员 -->
<!--             <a href="javascript:;"><i class="fa fa-remove"></i></a> -->
<!--           </span> -->
<!--           <span class="label label-default label-item">普通用户 -->
<!--             <a href="javascript:;"><i class="fa fa-remove"></i></a> -->
<!--           </span> -->
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">备注</label>
        <div class="col-xs-10">
          <form:textarea class="form-control" path="user.remark" rows="3"/>
        </div>
      </div>
    </form:form>
  </div>
<script type="text/javascript">
$(document).ready(function() {
	
})
</script>
</body>
</html>