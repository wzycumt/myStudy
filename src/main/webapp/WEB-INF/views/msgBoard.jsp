<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date" %>

<h2 class="page-header">留言板</h2>
<div class="page-content col-xs-12 col-md-10 col-lg-8">
  <form id="mainForm" method="post" class="form-horizontal">
    <div class="form-group">
      <div class="col-xs-2 col-sm-1">
      <a href="javascript:void(0)" id="avatar" class="avatar">
	  	<img class="img-rounded" width="35px" height="35px" src="${pageContext.request.contextPath}/resources/images/avatar-collection/boy-5.png" alt="" />
	  </a>
	  <input type="hidden" class="form-control" id="message_avatar" name="message.avatar" value="boy-5.png" />
      </div>
      <div class="col-xs-10 col-sm-11">
      <input type="text" class="form-control" name="message.name" placeholder="留言人" value="匿名" />
      </div>
    </div>
    <div class="form-group">
      <div class="col-xs-12">
      <textarea class="form-control" name="message.content" rows="3" placeholder="留言内容"></textarea>
      </div>
    </div>
    <div class="form-group">
      <div class="col-xs-4 col-sm-3 col-md-3 col-lg-2">
        <input type="text" class="form-control" id="verifyCode" name="verifyCode" placeholder="验证码" />
      </div>
      <div class="col-xs-4 col-sm-4 col-md-3 col-lg-3">
        <a id="changeCode" href="javascript:void(0)">
          <img id="imgVerifyCode" src="message/getVerifyCode?date=<%= new Date() %>" title="看不清，点击换一张" />
          <small>换一张</small>
        </a>
      </div>
      <div class="col-xs-2">
        <input type="button" class="btn btn-primary" id="btnSubmit" value="提交" />
      </div>
    </div>
  </form>
	<%-- <div class="media message-item">
    <div class="media-left">
      <img class="media-object" width="40px" height="40px" src="${pageContext.request.contextPath}/resources/images/avatar-collection/boy-5.png" alt="" />
    </div>
    <div class="media-body">
      <div class="row">
        <h5 class="media-heading text-primary col-md-11">站长</h5>
        <small class="text-right col-xs-1">1#</small>
      </div>
      <p>@匿名，增加xml生成实体的功能已经加上了，请大家享用，在左侧“实体生成”菜单下</p>
      <small class="text-muted">10小时前</small>
    </div>
  </div> --%>
  <a href="javascript:void(0)" id="more"><span class="message-more">加载更多</span></a>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		//提交留言
		$('#btnSubmit').click(function() {
			$(this).attr('disabled');
			$.ajax({
				url : 'message/save',
				type : 'post',
				data : $('#mainForm').serialize(),
				dataType : 'json',
				success : function(data, textStatus, jqXHR) {
					$(this).removeAttr('disabled');
					if (data.result) {
						refresh();
					} else {
						alert(data.des);
					}
				},
				error : function(xhr, textStatus) {
					$(this).removeAttr('disabled');
					console.log(xhr);
					console.log(textStatus);
				}
			});
		});

		/* <div class="row">
			<div class="col-xs-3 col-md-2">
				<a href="javascript:void(0)" class="thumbnail">
					<img src="${pageContext.request.contextPath}/resources/images/avatar-collection/boy-0.png" alt="">
				</a>
			</div>
		</div> */
		$('#avatar').popover({
			title : '选择头像',
			placement : 'right',
			container : 'form',
			trigger : 'focus',
			html : true,
			content : function () {
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
				return avatar;
			}
		});
		$('#avatar').on('shown.bs.popover', function () {
			$('a.thumbnail.avatar').click(function () {
				var src = $(this).find('img').attr('src');
				$('#avatar').find('img').attr('src', src);
				var imgName = $(this).find('img').attr('alt');
				$('#message_avatar').val(imgName);
				$('#avatar').popover('hide');
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
                            html += '<img class="media-object" width="40px" height="40px" src="${pageContext.request.contextPath}/resources/images/avatar-collection/' + list[i].avatar + '" alt="">';
                            html += '</div>';
                            html += '<div class="media-body">';
                            html += '<div class="row">';
                            html += '<h5 class="media-heading text-primary col-xs-11">' + list[i].name + '</h5>';
                            html += '<small class="text-right col-xs-1">' + list[i].rowNum + '#</small>';
                            html += '</div>';
                            html += '<p>' + list[i].content + '</p>';
                            html += '<small class="text-muted">' + list[i].createTimeStr + '</small>';
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
	  	
	  	//刷新验证码
	  	$('#changeCode').click(function() {
	  		$('#imgVerifyCode').attr('src', 'message/getVerifyCode?date=' + new Date());
	  	})
	})
	
	function selectAvatar() {
		$('#avatar').popover('hide');
	}
</script>