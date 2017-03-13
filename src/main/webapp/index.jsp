<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>myStudy</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<!-- Bootstrap treeView-->
<link href="http://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.css" rel="stylesheet">
<script src="http://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
</head>
<body class="fixed-sidebar full-height-layout gray-bg">
  <div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close">
      <i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
      <ul class="nav" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element">
            <span><img alt="image" class="img-circle" src="${pageContext.request.contextPath}/resources/hplus-v4.1.0/img/profile_small.jpg" /></span> 
            <a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
            <span class="clear"> 
              <span class="block m-t-xs"><strong class="font-bold">Beaut-zihan</strong></span> 
              <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
            </span>
            </a>
            <ul class="dropdown-menu animated fadeInRight m-t-xs">
              <li><a class="J_menuItem" href="form_avatar.html">修改头像</a></li>
              <li><a class="J_menuItem" href="profile.html">个人资料</a></li>
              <li><a class="J_menuItem" href="contacts.html">联系我们</a></li>
              <li><a class="J_menuItem" href="mailbox.html">信箱</a></li>
              <li class="divider"></li>
              <li><a href="login">安全退出</a></li>
            </ul>
          </div>
          <div class="logo-element">H+</div>
        </li>
        <li><a class="J_menuItem" href="home"><i class="fa fa-home"></i><span class="nav-label">主页</span></a></li>
        <li><a class="J_menuItem" href="user/index"><i class="fa fa-user"></i><span class="nav-label">用户管理</span></a></li>
        <li><a class="J_menuItem" href="role/index"><i class="fa fa-user-secret"></i><span class="nav-label">权限管理</span></a></li>
        <li><a class="J_menuItem" href="menu/index"><i class="fa fa-reorder"></i><span class="nav-label">菜单管理</span></a></li>
        <li><a class="J_menuItem" href="nav/fileUpload"><i class="fa fa-upload"></i><span class="nav-label">文件上传</span></a></li>
        <li>
          <a href="#"><i class="fa fa-home"></i><span class="nav-label">主页</span><span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li><a class="J_menuItem" href="index_v1.html" data-index="0">主页示例一</a></li>
            <li><a class="J_menuItem" href="index_v2.html">主页示例二</a></li>
            <li><a class="J_menuItem" href="index_v3.html">主页示例三</a></li>
            <li><a class="J_menuItem" href="index_v4.html">主页示例四</a></li>
            <li><a href="index_v5.html" target="_blank">主页示例五</a></li>
          </ul>
        </li>
        <li>
        	<div id="tree"></div>
        </li>
      </ul>
    </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
      <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
          <a class="navbar-minimalize minimalize-styl-2 btn btn-success " href="javascript:void(0);"><i class="fa fa-bars"></i> </a>
          <form role="search" class="navbar-form-custom" method="post" action="http://www.zi-han.net/theme/hplus/search_results.html">
            <div class="form-group">
              <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
            </div>
          </form>
        </div>
        <ul class="nav navbar-top-links navbar-right">
          <li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#"> <i class="fa fa-envelope"></i> <span
              class="label label-warning">16</span>
          </a>
            <ul class="dropdown-menu dropdown-messages">
              <li class="m-t-xs">
                <div class="dropdown-messages-box">
                  <a href="profile.html" class="pull-left"> <img alt="image" class="img-circle" src="${pageContext.request.contextPath}/resources/hplus-v4.1.0/img/a7.jpg">
                  </a>
                  <div class="media-body">
                    <small class="pull-right">46小时前</small> <strong>小四</strong> 这个在日本投降书上签字的军官，建国后一定是个不小的干部吧？ <br> <small class="text-muted">3天前
                      2014.11.8</small>
                  </div>
                </div>
              </li>
              <li class="divider"></li>
              <li>
                <div class="dropdown-messages-box">
                  <a href="profile.html" class="pull-left"> <img alt="image" class="img-circle" src="${pageContext.request.contextPath}/resources/hplus-v4.1.0/img/a4.jpg">
                  </a>
                  <div class="media-body ">
                    <small class="pull-right text-navy">25小时前</small> <strong>国民岳父</strong> 如何看待“男子不满自己爱犬被称为狗，刺伤路人”？——这人比犬还凶 <br> <small
                      class="text-muted">昨天</small>
                  </div>
                </div>
              </li>
              <li class="divider"></li>
              <li>
                <div class="text-center link-block">
                  <a class="J_menuItem" href="mailbox.html"> <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                  </a>
                </div>
              </li>
            </ul></li>
          <li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#"> <i class="fa fa-bell"></i> <span
              class="label label-primary">8</span>
          </a>
            <ul class="dropdown-menu dropdown-alerts">
              <li><a href="mailbox.html">
                  <div>
                    <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息 <span class="pull-right text-muted small">4分钟前</span>
                  </div>
              </a></li>
              <li class="divider"></li>
              <li><a href="profile.html">
                  <div>
                    <i class="fa fa-qq fa-fw"></i> 3条新回复 <span class="pull-right text-muted small">12分钟钱</span>
                  </div>
              </a></li>
              <li class="divider"></li>
              <li>
                <div class="text-center link-block">
                  <a class="J_menuItem" href="notifications.html"> <strong>查看所有 </strong> <i class="fa fa-angle-right"></i>
                  </a>
                </div>
              </li>
            </ul></li>
          <li><a href="message/msgBoard" class="J_menuItem"><i class="fa fa-smile-o"></i>留言板</a></li>
          <li class="dropdown hidden-xs"><a class="right-sidebar-toggle" aria-expanded="false"> <i class="fa fa-tasks"></i> 主题
          </a></li>
        </ul>
        </nav>
      </div>
      <div class="row content-tabs">
        <button class="roll-nav roll-left J_tabLeft">
          <i class="fa fa-backward"></i>
        </button>
        <nav class="page-tabs J_menuTabs">
        <div class="page-tabs-content">
          <a href="javascript:;" class="active J_menuTab" data-id="home">首页</a>
        </div>
        </nav>
        <button class="roll-nav roll-right J_tabRight">
          <i class="fa fa-forward"></i>
        </button>
        <div class="btn-group roll-nav roll-right">
          <button class="dropdown J_tabClose" data-toggle="dropdown">
                        关闭操作<span class="caret"></span>
          </button>
          <ul role="menu" class="dropdown-menu dropdown-menu-right">
            <li class="J_tabShowActive"><a>定位当前选项卡</a></li>
            <li class="divider"></li>
            <li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
            <li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
          </ul>
        </div>
        <a href="login" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
      </div>
      <div class="row J_mainContent" id="content-main">
        <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="nav/sysInfo" frameborder="0" data-id="home" seamless></iframe>
      </div>
      <div class="footer">
        <div class="pull-right">
          &copy; 2014-2015 <a href="http://www.zi-han.net/" target="_blank">zihan's blog</a>
        </div>
      </div>
    </div>
    <!--右侧部分结束-->
  </div>
<script type="text/javascript">
	$(document).ready(function() {
		
		var tree = [ {
			text : "系统设置",
			icon : 'fa fa-cogs',
			nodes : [ {
				text : "用户管理",
				nodes : [ {
					text : "Grandchild 1"
				}, {
					text : "Grandchild 2"
				} ]
			}, {
				text : "菜单管理"
			}, {
				text : "权限管理"
			} ]
		}, {
			text : "文件上传"
		}, {
			text : "Parent 3",
			nodes : [ {
				text : "Child 1"
			}, {
				text : "Child 2"
			} ]
		}, {
			text : "Parent 4"
		} ];
		$('#tree').treeview({
			text : "Node 1",
			//icon : "glyphicon glyphicon-stop",
			//selectedIcon : "glyphicon glyphicon-stop",
			//color : "#000000",
			//backColor : "#FFFFFF",
			levels : 0,
			showIcon : false,
			expandIcon : "",
			href : "#node-1",
			selectable : true,
			state : {
				checked : true,
				disabled : true,
				//expanded : true,
				selected : true
			},
			tags : [ 'available' ],
			data : tree
		});
	})
</script>
</body>
</html>
