<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="customTag/ex" prefix="ex"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>myStudy</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/uploadify-v3.2.1/uploadify.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/uploadify-v3.2.1/jquery.uploadify.min.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/webuploader-v0.1.5/webuploader.css" />
<script src="${pageContext.request.contextPath}/resources/plugins/webuploader-v0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/webuploader-v0.1.5/myWebuploader.js"></script>
</head>
<body class="fixed-sidebar full-height-layout gray-bg">
  <div class="wrapper wrapper-content animated fadeInRight">
    <h2 class="page-header">File upload</h2>
    <div class="row">
      <div class="col-md-6">
        <div class="panel panel-default ">
          <div class="panel-heading">uploadify</div>
          <div class="panel-body">
            <ex:file name="attachmentId" action="file/upload" swf="${pageContext.request.contextPath}/resources/uploadify/uploadify.swf"></ex:file>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
        <div class="panel panel-default">
          <div class="panel-heading">webuploader</div>
          <div class="panel-body">
            <div id="uploader"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
	$(function() {
		$("#uploader").powerWebUpload({
			auto : false,
			fileNumLimit : 5
		});
	})
</script>
</body>
</html>