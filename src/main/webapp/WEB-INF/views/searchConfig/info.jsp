<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<title>查询配置信息</title>
</head>
<body class="fixed-sidebar">
  <div class="layer-content">
    <div class="container">
      <form:form class="form-horizontal" modelAttribute="searchConfig" id="mainForm" action="searchConfig/info" method="post">
        <div class="page-header text-center">
          <h4>查询配置信息</h4>
          <form:hidden path="id"/>
          <form:hidden path="creator"/>
          <form:hidden path="createTime"/>
          <form:hidden path="updatePerson"/>
          <form:hidden path="updateTime"/>
          <form:hidden path="version"/>
        </div>
        <div class="form-group">
          <label class="col-xs-2 control-label">编码</label>
          <div class="col-xs-10">
            <form:input class="form-control" path="code" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-2 control-label">描述</label>
          <div class="col-xs-10">
            <form:input class="form-control" path="description" />
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
            <form:textarea class="form-control" path="remark" rows="3"/>
          </div>
        </div>
        <strong>字段列表</strong>
        <button type="button" class="btn btn-default" id="btnAdd"><i class="fa fa-plus"></i></button>
        <table id="tblItems" class="table table-bordered table-condensed">
          <thead>
            <tr>
                <th width="20%">显示名称</th>
                <th width="20%">字段名称</th>
                <th width="10%">字段类型</th>
                <th width="30%">引用<small class="text-muted">（枚举：枚举类全名，字典：字典code）</small></th>
                <th width="8%">序号</th>
                <th width="8%">删除</th>
            </tr>
          </thead>
          <tbody>
            <c:if test="${not empty searchConfig.fields}">
              <c:forEach items="${searchConfig.fields}" var="field" varStatus="status">
                <tr id="tr_${status.index }">
                  <td>
                    <form:hidden class="form-control" path="fields[${status.index}].id" />
                    <form:input class="form-control" path="fields[${status.index}].displayName" />
                  </td>
                  <td><form:input class="form-control" path="fields[${status.index}].fieldName" /></td>
                  <td>
                    <form:select class="form-control" path="fields[${status.index}].fieldType">
                      <form:options items="${org.myStudy.enums.FieldTypeEnum.values()}" itemLabel="description"/>
                    </form:select>
                  </td>
                  <td><form:input class="form-control" path="fields[${status.index}].fieldReference" /></td>
                  <td><form:input class="form-control" path="fields[${status.index}].orderNum" /></td>
                  <td><a href="javascript:void(0);">删除</a></td>
                </tr>
              </c:forEach>
            </c:if>
            <c:if test="${empty searchConfig.fields}">
              <tr id="tr_0">
                <td>
                  <form:hidden class="form-control" path="fields[0].id" />
                  <form:input class="form-control" path="fields[0].displayName" />
                </td>
                <td><form:input class="form-control" path="fields[0].fieldName" /></td>
                <td>
                  <form:select class="form-control" path="fields[0].fieldType">
                    <form:options items="${org.myStudy.enums.FieldTypeEnum.values()}" itemLabel="description"/>
                  </form:select>
                </td>
                <td><form:input class="form-control" path="fields[0].fieldReference" /></td>
                <td><form:input class="form-control" path="fields[0].orderNum" /></td>
                <td><a href="javascript:void(0);">删除</a></td>
              </tr>
            </c:if>
          </tbody>
        </table>
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
			url : 'searchConfig/info',
			type : 'post',
			dataType : 'json',
			data : $('#mainForm').serialize(),
			success : function(data) {
				layer.close(loading);
				if (data.result) {
					parent.layer.msg(data.des, { time : 2000 });
					window.location.href = 'searchConfig/info?id=' + data.value;
				} else {
					layer.alert(data.des, { icon : 0 });
				}
			},
			error : function(xhr, textStatus, error) {
				layer.close(loading);
				layer.alert(error, { icon : 2 });
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

    // 添加行
    $('#btnAdd').click(function() {
        var count = $('#tblItems tbody tr').length;
        var index = parseInt(count);
        var $tr = $('#tblItems tbody tr').first().clone(true).attr('id', 'tr_' + index); //克隆新的一行
        $tr.appendTo('#tblItems');
        //清空克隆行的数据
        $tr.find('input[name="fields[0].id"]').attr('id', 'fields' + index + '.id').attr('name', 'fields[' + index + '].id').val('0');
        $tr.find('input[name="fields[0].displayName"]').attr('id', 'fields' + index + '.displayName').attr('name', 'fields[' + index + '].displayName').val('');
        $tr.find('input[name="fields[0].fieldName"]').attr('id', 'fields' + index + '.fieldName').attr('name', 'fields[' + index + '].fieldName').val('');
        $tr.find('select[name="fields[0].fieldType"]').children('option').first().attr('selected', true);
        $tr.find('select[name="fields[0].fieldType"]').attr('id', 'fields' + index + '.fieldType').attr('name', 'fields[' + index + '].fieldType');
        $tr.find('input[name="fields[0].fieldReference"]').attr('id', 'fields' + index + '.fieldReference').attr('name', 'fields[' + index + '].fieldReference').val('');
        $tr.find('input[name="fields[0].orderNum"]').attr('id', 'fields' + index + '.orderNum').attr('name', 'fields[' + index + '].orderNum').val(index);
    });
	
	// 删除行
	$('#tblItems td a').click(function() {
        var count = $('#tblItems tbody tr').length;
        if (count > 1) {
			$(this).parents('tr').remove();
            $('#tblItems tbody tr').each(function(index, element) {
            	$(element).attr('id', 'tr_' + index);
            	// 修改行内表单的id与name属性
            	$(element).find('.form-control').each(function() {
            		var id = $(this).attr('id');
            		var name = $(this).attr('name');
					id = id.replace(/fields[0-9]\d*/, 'fields' + index);
            		name = name.replace(/[[0-9]\d*]/, '[' + index + ']');
            		$(this).attr('id', id).attr('name', name);
            	});
            });
        }
        else {
        	layer.msg('至少保留一行', {time: 2000 });
        }
	})
})
</script>
</body>
</html>