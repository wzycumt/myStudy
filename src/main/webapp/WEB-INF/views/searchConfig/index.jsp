<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<title>查询配置</title>
</head>
<body class="fixed-sidebar">
  <div class="wrapper wrapper-content animated fadeInRight">
    <div class="panel panel-default">
      <div class="panel-heading">查询配置列表</div>
      <div class="panel-body">
        <div class="btn-group" id="toolbar">
          <button type="button" class="btn btn-success" id="btnAdd"><i class="fa fa-plus"></i>&nbsp;添加</button>
          <button type="button" class="btn btn-primary" id="btnEdit"><i class="fa fa-edit"></i>&nbsp;编辑</button>
          <button type="button" class="btn btn-danger" id="btnRemove"><i class="fa fa-remove"></i>&nbsp;删除</button>
        </div>
        <table id="table" 
          data-toggle="table"
          data-striped="true"
          data-pagination="true"
          data-side-pagination="server"
          data-pagination-loop="false"
          data-page-list="[10, 20, 100, ALL]"
          data-show-columns="true"
          data-click-to-select="true"
          data-toolbar="#toolbar"
          data-id-field="id"
          data-url="searchConfig/pageList">
          <thead>
            <tr>
                <th data-field="checked" data-checkbox="true"></th>
                <th data-field="id" data-visible="false" data-switchable="false">ID</th>
                <th data-field="code" data-sortable="true">编码</th>
                <th data-field="description" data-sortable="true">描述</th>
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
    var grid = $('#table');
    //添加
    $('#btnAdd').click(function() {
      layerAdd(grid, '添加', 'searchConfig/info', '80%', '90%');
    })

    //编辑
    $('#btnEdit').click(function() {
      layerEdit(grid, '编辑', 'searchConfig/info', '80%', '90%');
    })

    //删除
    $('#btnRemove').click(function() {
      operateGird(grid, '删除', 'searchConfig/delete');
    })

  })
</script>
</body>
</html>