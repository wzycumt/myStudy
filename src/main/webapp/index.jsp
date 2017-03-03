<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>myStudy</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="">myStudy</a>
    </div>
    <div class="navbar-collapse collapse" id="navbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a name="navigation" rel="nav/msgBoard" href="javascript:void(0);">Message board</a></li>
        <li><a name="navigation" rel="nav/contact" href="javascript:void(0);">Contact</a></li>
      </ul>
    </div>
  </div>
  </nav>

  <div class="container-fluid">
    <div class="row">
      <div class="col-xs-2 sidebar">
        <ul class="nav nav-sidebar">
          <li class="active"><a name="navigation" rel="nav/sysInfo" href="javascript:void(0);">Overview <span class="sr-only">(current)</span></a></li>
          <li><a name="navigation" rel="nav/fileUpload" href="javascript:void(0);">File upload</a></li>
          <li><a name="navigation" rel="nav/container/userManagement" href="javascript:void(0);">User Management</a></li>
          <li><a name="navigation" href="javascript:void(0);">Export</a></li>
        </ul>
      </div>
      <div class="col-xs-10 col-xs-offset-2 main">
        <div id="container">
          <c:import url="nav/sysInfo" />
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript">
  var action = 'nav/sysInfo';
  $(document).ready(function(){
	  $('a[name="navigation"]').click(function() {
          action = $(this).attr('rel');
          if (action) {
              $('#container').load(action);
          }
	  });
	  $('.nav-sidebar li').click(function(){
		  $('.nav-sidebar li').removeClass('active');
		  $(this).addClass('active');
	  });
  })
  
  function refresh(){
      if (action) {
          $('#container').load(action);
      }
  }
  </script>
</body>
</html>
