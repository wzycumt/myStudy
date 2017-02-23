<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<h2 class="page-header">留言板</h2>
<div class="page-content col-sm-7">
  <form id="mainForm" method="post" class="form-horizontal">
    <div class="form-group col-sm-12">
      <input type="text" class="form-control" id="name" name="name" placeholder="留言人" value="匿名" />
    </div>
    <div class="form-group col-sm-12">
      <textarea class="form-control" id="content" name="content" rows="3" placeholder="留言内容"></textarea>
    </div>
    <div class="form-group">
      <div class="col-sm-2">
        <input type="text" class="form-control" id="code" name="code" placeholder="验证码" />
      </div>
      <div class="col-sm-2">
        <img id="GL_StandardCode" src="" /> 
        <a id="changeCode" href="javascript:void(0)">换一张</a>
      </div>
      <div class="col-sm-2">
        <input type="button" class="btn btn-primary" id="btnSubmit" value="提交" />
      </div>
    </div>
  </form>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#btnSubmit').click(function() {
			var formData = $("#mainForm").serializeArray();
			var data = {};
			$.each(formData, function() {
				data[this.name] = this.value;
			});

			$.ajax({
				url : "message/save",
				type : "post",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : 'application/json;charset=utf-8',
				success : function(data, textStatus, jqXHR) {
					if (data.result) {
						refresh();
					} else {
						alert(data.des);
					}
				},
				error : function(xhr, textStatus) {
					console.log(xhr);
					console.log(textStatus);
				}
			});
		});
	})
</script>