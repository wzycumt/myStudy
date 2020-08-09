<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<title>用户信息</title>
</head>
<body class="fixed-sidebar">
  <div class="layer-content">
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
            <form:select path="user.roles[0].id" class="form-control" items="${userModel.dicRoleList}"></form:select>
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
  </div>
  <div class="layer-toolbar">
    <button type="button" class="btn btn-success" id="btnSave">保存</button>
    <button type="button" class="btn btn-default" id="btnClose">关闭</button>
  </div>
<script type="text/javascript">
$(document).ready(function() {
	//保存
	$('#btnSave').click(function() {
		var loading = layer.load(1);
		$.ajax({
			url: 'user/info',
            type: 'post',
			dataType: 'json',
			data: $('#mainForm').serialize(),
			success: function(data) {
				layer.close(loading);
				if (data.result) {
		  			parent.layer.msg(data.des, { time: 2000 });
		  			window.location.href = 'user/info?id=' + data.value;
				} else {
		  			layer.alert(data.des, { icon: 0 });
				}
			},
			error: function (xhr, textStatus, error) {
    			layer.close(loading);
	  			layer.alert(error, { icon: 2 });
            }
		})
	})
	
	//关闭
	$('#btnClose').click(function() {
		if (window == top)
			window.close();
		else
			window.layerClose();
	})
})
</script>
</body>
</html>