<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="org.myStudy.enums.BaseStatusEnum"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/jstree-v3.3.3/themes/default/style.min.css" />
<script src="${pageContext.request.contextPath}/resources/plugins/jstree-v3.3.3/jstree.min.js"></script>
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" /> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script> -->
<title>用户信息</title>
</head>
<body class="fixed-sidebar">
  <div class="container">
    <form:form class="form-horizontal" modelAttribute="role" id="mainForm" action="role/info" method="post">
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
        <label class="col-xs-2 control-label">角色名</label>
        <div class="col-xs-10">
          <form:input class="form-control" path="name" />
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
      <div id="menuTree"></div>
    </form:form>
  </div>
<script type="text/javascript">
$(document).ready(function() {
	$.getJSON('role/menuTree', function(data) {
		if (data && data.result) {
			var menus = data.value;
			var arr = [];
			for (var i = 0; i < menus.length; i++) {
				arr.push({
					id: menus[i].id,
					parent: menus[i].parentId == 0 ? "#" : menus[i].parentId,
					text: menus[i].name,
					icon: menus[i].icon
				})
			}
			$('#menuTree').jstree({
				'core' : { 'data' : arr },
	            'plugins' : [ "wholerow", "checkbox" ]
			});
		}
	});
})
</script>
</body>
</html>