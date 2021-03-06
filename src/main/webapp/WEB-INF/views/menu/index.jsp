<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<link href="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqx.base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqx.bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqxcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqxdata.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqxbuttons.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqxscrollbar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqxlistbox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqxdropdownlist.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqxdatatable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jqxtreegrid-v4.5.0/jqxtreegrid.js"></script>
<title>菜单管理</title>
</head>
<body class="fixed-sidebar">
  <div class="wrapper wrapper-content animated fadeInRight">
    <div class="panel panel-default">
      <div class="panel-heading">菜单列表</div>
      <div class="panel-body">
        <div class="btn-group" id="toolbar">
          <button type="button" class="btn btn-success" id="btnAddRoot"><i class="fa fa-plus"></i>&nbsp;添加根节点</button>
          <button type="button" class="btn btn-success" id="btnAddChild"><i class="fa fa-plus"></i>&nbsp;添加子节点</button>
          <button type="button" class="btn btn-primary" id="btnEdit"><i class="fa fa-edit"></i>&nbsp;编辑</button>
          <button type="button" class="btn btn-danger" id="btnRemove"><i class="fa fa-remove"></i>&nbsp;删除</button>
        </div>
        <div id="treeGrid"></div>
      </div>
    </div>
  </div>
<script type="text/javascript">
$(document).ready(function() {
	var grid = $("#treeGrid");
	// prepare the data
    var dataAdapter = new $.jqx.dataAdapter({
        dataType: "json",
        dataFields: [
            { name: 'id', type: 'number' },
            { name: 'parentId', type: 'number' },
            { name: 'name', type: 'string' },
            { name: 'url', type: 'string' },
            { name: 'icon', type: 'string' },
            { name: 'orderNum', type: 'number' },
            { name: 'status', type: 'string' },
            { name: 'statusDes', type: 'string' },
            { name: 'remark', type: 'string' },
            { name: 'creator', type: 'number' },
            { name: 'createTime', type: 'date' },
            { name: 'updatePerson', type: 'number' },
            { name: 'updateTime', type: 'date' },
        ],
        hierarchy:
        {
            keyDataField: { name: 'id' },
            parentDataField: { name: 'parentId' }
        },
        id: 'id',
        url: 'menu/treeList'
    });
    // create Tree Grid
    grid.jqxTreeGrid(
    {
        width: '100%',
        columnsHeight: 36,
        source: dataAdapter,
        altRows: true,
        checkboxes: true,
        //hierarchicalCheckboxes: true,
        sortable: true,
        columnsReorder: true,
        theme: 'bootstrap',
        pageable: false,
        columnsResize: true,
        enableBrowserSelection: true,
        columns: [
            { text: 'ID', dataField: 'id', hidden: true, minWidth: 80, width: 80 },
            { text: 'PARENT_ID', dataField: 'parentId', hidden: true, minWidth: 80, width: 80 },
            { text: '名称', dataField: 'name', width: 300, cellsRenderer: function (row, column, value, rowData) {
            	return '&nbsp;<i class="' + rowData['icon'] + '"></i>&nbsp;' + value;
            } },
            { text: '路径',  dataField: 'url', width: 200 },
            { text: '图标',  dataField: 'icon', width: 150 },
            { text: '序号', dataField: 'orderNum', width: 50 },
            { text: '状态', dataField: 'status', displayField: 'statusDes', width: 60 },
            { text: '备注', dataField: 'remark' },
            { text: '创建人', dataField: 'creator', width: 100 },
            { text: '创建时间', dataField: 'createTime', cellsFormat: 'yyyy-MM-dd HH:mm:ss', width: 150 },
            { text: '更新时间', dataField: 'updateTime', cellsFormat: 'yyyy-MM-dd HH:mm:ss', width: 150 }
        ],
        ready: function() {
        	grid.jqxTreeGrid('sortBy', 'orderNum', 'asc');
            //grid.jqxTreeGrid('expandAll');
        }
    });
    
	//添加根节点
	$('#btnAddRoot').click(function() {
		layerAdd(grid, '添加根节点', 'menu/info', '80%', '90%');
	})
    
	//添加根节点
	$('#btnAdd').click(function() {
		layer.open({
			type : 2,
			title : '添加根节点',
			area : [ '80%', '90%' ],
			maxmin : true,
			content : 'menu/info'
		});
	})
    
	//添加子节点
	$('#btnAddChild').click(function() {
		var rows = grid.jqxTreeGrid('getSelection');
		if (rows.length == 0) {
			layer.msg('请选择一行');
			return false;
		}
		layer.open({
			type : 2,
			title : '添加子节点',
			area : [ '80%', '90%' ],
			maxmin : true,
			content : 'menu/info?parentId=' + rows[0].id
		});
	})

	//编辑
	$('#btnEdit').click(function() {
		var rows = grid.jqxTreeGrid('getSelection');
		if (rows.length == 0) {
			layer.msg('请选择一行');
			return false;
		}
		layer.open({
			type : 2,
			title : '编辑',
			area : [ '80%', '90%' ],
			maxmin : true,
			content : 'menu/info?id=' + rows[0].id
		});
	})

	//删除
	$('#btnRemove').click(function() {
		var rows = grid.jqxTreeGrid('getSelection');
	    if (rows == undefined || rows.length == 0) {
			layer.msg('请至少选择一行数据', { time: 2000 });
			return false;
	    }
	    layer.confirm('确定删除所选数据？', { icon : 3, title : '提示' }, function(index) {
			var idArr = [];
	    	for (var i = 0; i < rows.length; i++) {
	        	idArr.push(rows[i].id);
	        }
			var loading = layer.load(1);
	        $.ajax({
	            url: 'menu/delete',
	            data: { ids: idArr.join(',') },
	            type: 'post',
	            dataType: 'json',
	            success: function (data) {
	    			layer.close(loading);
	    			if (data.result) {
	    	  			layer.msg(data.des, { time: 2000 });
	    				//grid.jqxTreeGrid('refresh');
	    				location.reload();
	    			} else {
	    	  			layer.alert(data.des, { icon: 0 });
	    			}
	            },
	            error: function (xhr, textStatus, error) {
	    			layer.close(loading);
		  			layer.alert(error, { icon: 2 });
	            }
	        });
		});
	})
})
</script>
</body>
</html>