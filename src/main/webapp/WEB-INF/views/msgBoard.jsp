<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<h2 class="page-header">留言板</h2>
<div class="page-content col-sm-8">
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
      <div class="col-sm-3">
        <a id="changeCode" href="javascript:void(0)">
          <img id="imgVerifyCode" src="message/getVerifyCode" title="看不清，点击换一张" />换一张
        </a>
      </div>
      <div class="col-sm-2">
        <input type="button" class="btn btn-primary" id="btnSubmit" value="提交" />
      </div>
    </div>
  </form>
  <div class="media message-item">
    <div class="media-left">
      <img class="media-object" width="40px" height="40px" src="${pageContext.request.contextPath}/resources/images/avatar-collection/boy-5.png" alt="" />
    </div>
    <div class="media-body">
      <div class="row">
        <h5 class="media-heading text-primary col-md-11">站长</h5>
        <small class="text-right col-md-1">1#</small>
      </div>
      <p>@匿名，增加xml生成实体的功能已经加上了，请大家享用，在左侧“实体生成”菜单下</p>
      <small>10小时前</small>
    </div>
  </div>
  <a href="javascript:void(0)" id="more"><span class="message-more">加载更多</span></a>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		//提交留言
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

		//加载更多
		var page = 0;
        $('#more').click(function () {
            $.post('message/list', { page: page}, function (data) {
                if (data && data.result) {
                	var list = data.value;
                    var html = '';
                	if (list.length > 0) {
                        for (var i = 0; i < list.length;i++) {
                            html += '<div class="media message-item">';
                            html += '<div class="media-left">';
                            html += '<img class="media-object" width="40px" height="40px" src="${pageContext.request.contextPath}/resources/images/avatar-collection/boy-5.png" alt="">';
                            html += '</div>';
                            html += '<div class="media-body">';
                            html += '<div class="row">';
                            html += '<h5 class="media-heading text-primary col-md-11">' + list[i].name + '</h5>';
                            html += '<small class="text-right col-md-1">' + list[i].rowNum + '#</small>';
                            html += '</div>';
                            html += '<p>' + list[i].content + '</p>';
                            html += '<small>' + list[i].createTimeStr + '</small>';
                            html += '</div>';
                            html += '</div>';
                        }
                	} else {
                        $('#more').hide();
                        html += '<span class="message-more">没有更多</span>';
                	}
                    $('#more').before(html);
                }
            });
            page++;
        });
	  	$('#more').click();
	  	
	  	$('#changeCode').click(function() {
	  		$('#imgVerifyCode').attr('src', 'message/getVerifyCode?date=' + new Date());
	  	})
	})
</script>