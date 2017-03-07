<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<%-- 
    <link href="${pageContext.request.contextPath}/resources/hplus-v4.1.0/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/hplus-v4.1.0/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/hplus-v4.1.0/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
     --%>
</head>
<body class="fixed-sidebar full-height-layout gray-bg">
  <div class="wrapper wrapper-content animated fadeInRight">
    <!-- 
        <table id="datatables" class="table table-striped table-bordered table-hover"></table>
    -->
    <div class="panel panel-default">
      <div class="panel-heading">用户信息</div>
      <div class="panel-body">
        <div class="btn-group" id="toolbar" role="group" aria-label="...">
          <button type="button" class="btn btn-primary" id="btnAdd">新增</button>
        </div>
        <table id="table" data-toggle="table"
           data-striped="true"
           data-pagination="true"
           data-pagination-loop="false"
           data-side-pagination="server"
           data-search="true"
           data-search-on-enter-key="true"
           data-show-columns="true"
           data-show-refresh="true"
           data-click-to-select="true"
           data-toolbar="#toolbar"
           data-id-field="id"
           data-url="user/list">
           <thead>
            <tr>
                <th data-field="id" data-checkbox="true"></th>
                <th data-field="userName" data-sortable="true">用户名</th>
                <th data-field="nickname" data-sortable="true">昵称</th>
                <th data-field="realName" data-sortable="true">真实姓名</th>
                <th data-field="phone">手机</th>
                <th data-field="email">E-mail</th>
                <th data-field="statusDes" data-sortable="true">状态</th>
                <th data-field="remark">备注</th>
                <th data-field="creator" data-sortable="true">创建人</th>
                <th data-field="createTime" data-sortable="true">创建时间</th>
            </tr>
          </thead>
        </table>
      </div>
    </div>
  </div>

  <script type="text/javascript">
	$(document).ready(function() {
		//新增
		$('#btnAdd').click(function() {
			layer_show('新增', 'user/info', '80%', '90%');
		})
		
		/* $('#datatables').DataTable({
			responsive: true,
			serverSide: true,
			//processing: true,//载入数据的时候是否显示“载入中”
            pagingType: "full_numbers",
            //autoWidth: false,
			ajax: {
				url: "user/pageList",
				type: "POST",
				contentType: "application/json",
				data: function(d) {
					return JSON.stringify(d);
				}
			},
			columns: [
				{	//复选框单元格
                    className: "td-checkbox",
                    orderable: false,
                    width: "30px",
                    data: "id",
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" class="iCheck">';
                	}
				},
				{data: "id", title: "序号", orderable: false, width: 40, render: function(data, type, row, meta) {  
                    // 显示行号  
                    var startIndex = meta.settings._iDisplayStart;  
                    return startIndex + meta.row + 1;  
                }},
				{data: "userName", name: "user_name", title: "用户名", className: "ellipsis", width: 100},
				{data: "nickname", title: "昵称"},
				{data: "realName", name: "real_name", title: "真实姓名"},
				{data: "phone", title: "手机号码", type: "num-fmt"},
				{data: "email", title: "E-mail"},
				{data: "statusDes", title: "状态"},
				{data: "remark", title: "备注", orderable: false},
				{data: "creator", title: "创建人", type: "num-fmt"},
				{data: "createTime", name: "create_time", title: "创建时间", type: "date"},
				{data: null, title: "操作", render : function(data, type, row, meta) {  
                    var edit = '<a href="javascript:editKeeperUserInfo(' + row.id + ')">修改</a>&nbsp;|&nbsp;';  
                    var del = '<a href="javascript:deleteKeeperUser(' + row.id + ');">删除</a>';  
                    return edit + del;
                }}
			],
			language: { url: "${pageContext.request.contextPath}/resources/js/language.json" },
			initComplete: function () {
                $("#mytool").append('<button id="datainit" type="button" class="btn btn-primary btn-sm">增加基础数据</button>&nbsp');
                $("#mytool").append('<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal">添加</button>');
                //$("#datainit").on("click", initData);
        		$('#datatables tbody tr').click(function () {
        	        $(this).toggleClass('selected');
        	    });
            }
		}); */
		
	})
</script>
</body>
</html>