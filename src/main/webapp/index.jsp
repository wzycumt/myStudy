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
        <li><a href="javascript:void(0);">Abort</a></li>
        <li><a href="javascript:void(0);">Contact</a></li>
      </ul>
    </div>
  </div>
  </nav>

  <div class="container-fluid">
    <div class="row">
      <div class="col-md-2 sidebar">
        <ul class="nav nav-sidebar">
          <li class="active"><a rel="sysInfo" href="javascript:void(0);">系统信息 <span class="sr-only">(current)</span></a></li>
          <li><a href="javascript:void(0);">Reports</a></li>
          <li><a href="">Analytics</a></li>
          <li><a href="">Export</a></li>
        </ul>
      </div>
      <div class="col-md-10 col-md-offset-2 main">
        <%-- <%@include file="WEB-INF/views/sysInfo.jsp"%> --%>
        <%-- <jsp:include page="WEB-INF/views/common/container.jsp" flush="true" /> --%>
        <div id="container">
          <c:import url="sysInfo" />
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript">
  $(document).ready(function(){
	  $('.nav-sidebar a').click(function() {
          var action = $(this).attr('rel');
          $('#container').load(action);
	  });
  })
  </script>
</body>
</html>
