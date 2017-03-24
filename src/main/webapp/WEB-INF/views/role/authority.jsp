<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="org.myStudy.enums.BaseStatusEnum"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/jstree-v3.3.3/themes/default/style.min.css" />
<script src="${pageContext.request.contextPath}/resources/plugins/jstree-v3.3.3/jstree.min.js"></script>
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" /> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script> -->
<title>角色信息</title>
</head>
<body>
  <div class="container layer-content">
    <p>角色：<strong>${role.name}</strong></p>
    <input type="hidden" id="roleId" name="roleId" value="${role.id}">
    <div id="menuTree"></div>
  </div>
  <div class="layer-toolbar">
    <button type="button" class="btn btn-success" id="btnSave">保存</button>
    <button type="button" class="btn btn-default" id="btnClose">关闭</button>
  </div>
<script type="text/javascript">
$(document).ready(function() {
	var roleId = $('#roleId').val();
	$.getJSON('role/allMenus', { id: roleId }, function(data) {
		if (data && data.result) {
			var menus = data.value;
			var dataArr = [];
			var checkedArr = [];
			for (var i = 0; i < menus.length; i++) {
				dataArr.push({
					id : menus[i].id,
					parent : menus[i].parentId == 0 ? "#" : menus[i].parentId,
					text : menus[i].name,
					icon : menus[i].icon,
					state : {
						opened : true,
						selected : menus[i].checked
					}
				});
				if (menus[i].checked)
					checkedArr.push(menus[i].id);
			}
			$('#menuTree').jstree({
				'core' : { 'data' : dataArr },
				'plugins' : [ "wholerow", "checkbox" ]
			});
		}
	});

	$('#btnSave').click(function() {
		var menus = $('#menuTree').jstree('get_checked');
		var loading = layer.load(1);
		$.ajax({
			url: 'role/saveAuthority',
            type: 'post',
			dataType: 'json',
			data: { roleId: roleId, menuIds: menus.join(',') },
			success: function(data) {
				layer.close(loading);
				if (data && data.result)
		  			layer.msg(data.des, { time: 2000 });
				else
		  			layer.alert(data.des, { icon: 0 });
			},
			error: function (xhr, textStatus, error) {
    			layer.close(loading);
	  			layer.alert(error, { icon: 2 });
            }
		})
	})
	
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