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
    <form:form class="form-horizontal" modelAttribute="user" id="mainForm" action="user/info" method="post">
      <div class="page-header text-center">
        <h4>用户信息</h4>
        <form:hidden path="id"/>
        <form:hidden path="creator"/>
        <form:hidden path="createTime"/>
        <form:hidden path="updatePerson"/>
        <form:hidden path="updateTime"/>
        <form:hidden path="version"/>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">用户名</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="userName" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">昵称</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="nickname" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">真实姓名</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="realName" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">手机</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="phone" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">E-mail</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="email" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">状态</label>
        <div class="col-xs-10">
          <div class="radio i-checks">
            <form:radiobuttons class="form-control" path="status" itemLabel="description" />
          </div>
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label">备注</label>
        <div class="col-xs-10">
          <form:textarea class="form-control" rows="3" path="remark"/>
        </div>
      </div>
    </form:form>
  </div>
<script type="text/javascript">
$(document).ready(function() {
    var error = '${error}';
    	if (error != null && error != '') {
    		layer.alert(error, { icon: 0 });
    	}
    })
</script>
</body>
</html>