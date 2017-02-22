<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="customTag/ex" prefix="ex"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/uploadify/uploadify.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/uploadify/jquery.uploadify.min.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/webuploader/webuploader.css" />
<script src="${pageContext.request.contextPath}/resources/webuploader/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/webuploader/myWebuploader.js"></script>

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
<script>
	$(function() {
		$("#uploader").powerWebUpload({
			auto : false,
			fileNumLimit : 5
		});
	})
</script>