<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<title>用户管理</title>
</head>
<body class="fixed-sidebar">
  <div class="wrapper wrapper-content animated fadeInRight">
    <div class="panel panel-default">
      <div class="panel-heading">用户信息</div>
      <div class="panel-body">
        
        <form class="form-horizontal" id="formSearch_" method="post">
          <div class="form-group row">
            <label class="col-xs-3 control-label">用户名</label>
            <div class="col-xs-9">
              <input type="text" class="form-control" name="message.name" placeholder="用户名" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-xs-3 control-label">状态</label>
            <div class="col-xs-9">
              <select class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
              </select>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-xs-3 control-label">创建时间</label>
            <div class="col-xs-9">
              <input class="form-control layer-date" id="start" placeholder="开始日期">
              <input class="form-control layer-date" id="end" placeholder="结束日期">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-xs-12">
              <input type="button" class="btn btn-default" id="btnSubmit" value="提交" />
            </div>
          </div>
        </form>
        
        <div class="btn-group" id="toolbar">
          <button type="button" class="btn btn-success" id="btnAdd"><i class="fa fa-plus"></i>&nbsp;添加</button>
          <button type="button" class="btn btn-primary" id="btnEdit"><i class="fa fa-edit"></i>&nbsp;编辑</button>
          <button type="button" class="btn btn-danger" id="btnRemove"><i class="fa fa-remove"></i>&nbsp;删除</button>
          <button type="button" class="btn btn-default" id="btnSearch" title="search">
            <i class="fa fa-search"></i>&nbsp;<span class="caret"></span>
          </button>
        </div>
        <table id="table" 
          data-toggle="table"
          data-striped="true"
          data-pagination="true"
          data-side-pagination="server"
          data-pagination-loop="false"
          data-page-list="[10, 20, 100, ALL]"
          data-show-columns="true"
          data-show-refresh="true"
          data-click-to-select="true"
          data-toolbar="#toolbar"
          data-id-field="id"
          data-search-code="11"
          data-url="user/pageList">
          <thead>
            <tr>
                <th data-field="isChecked" data-checkbox="true"></th>
                <th data-field="id" data-visible="false">ID</th>
                <th data-field="userName" data-sortable="true">用户名</th>
                <th data-field="nickname" data-sortable="true">昵称</th>
                <th data-field="realName" data-sortable="true">真实姓名</th>
                <th data-field="phone">手机</th>
                <th data-field="email">E-mail</th>
                <th data-field="statusDes" data-sortable="true">状态</th>
                <th data-field="remark">备注</th>
                <th data-field="creator" data-sortable="true">创建人</th>
                <th data-field="createTime" data-sortable="true">创建时间</th>
                <th data-field="updateTime" data-sortable="true">更新时间</th>
            </tr>
          </thead>
        </table>
      </div>
    </div>
  </div>
<script type="text/javascript">
	$(document).ready(function() {
		var grid = $('#table');
		//添加
		$('#btnAdd').click(function() {
			layerAdd(grid, '添加', 'user/info', '80%', '90%');
		})
		
		//编辑
		$('#btnEdit').click(function() {
			layerEdit(grid, '编辑', 'user/info', '80%', '90%');
		})
		
		//删除
		$('#btnRemove').click(function() {
			operateGird(grid, '删除', 'user/delete');
		})

		$('#btnSearch').popover({
  			title : '选择头像',
  			placement : 'right',
  			container : '.fixed-table-container',
  			trigger : 'manual',
  			html : true,
  			content : function() {
  				var avatar = '<div class="row" style="padding:0px 5px;">';
  				for (var i = 0; i < 8; i++) {
  					avatar += '<div class="col-xs-3 col-md-2" style="padding:0px;">';
  					avatar += '<a href="javascript:void(0)" class="thumbnail avatar">';
  					avatar += '<img src="${pageContext.request.contextPath}/resources/images/avatar-collection/boy-' + i + '.png" alt="boy-' + i + '.png">';
  					avatar += '</a>';
  					avatar += '</div>';
  				}
  				for (var i = 0; i < 8; i++) {
  					avatar += '<div class="col-xs-3 col-md-2" style="padding:0px;">';
  					avatar += '<a href="javascript:void(0)" class="thumbnail avatar">';
  					avatar += '<img src="${pageContext.request.contextPath}/resources/images/avatar-collection/girl-' + i + '.png" alt="girl-' + i + '.png">';
  					avatar += '</a>';
  					avatar += '</div>';
  				}
  				avatar += '</div>';
  				var html = $('#formSearch_').get(0).outerHTML;
  				return html;
  			}
  		});
		$('#btnSearch').click(function() {
			$('#btnSearch').popover('toggle');
		});
		$('#btnSubmit').click(function() {
			$('#btnSearch').popover('toggle');
		});

		var start = {
			elem : "#start",
			format : "YYYY-MM-DD",
			istoday : true,
			choose : function(datas) {
				end.min = datas;
				end.start = datas
			}
		};
		var end = {
			elem : "#end",
			format : "YYYY-MM-DD",
			istoday : true,
			choose : function(datas) {
				start.max = datas
			}
		};
		laydate(start);
		laydate(end);
	})
</script>
</body>
</html>