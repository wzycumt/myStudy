
$(document).ready(function() {
	//单选、复选按钮样式
	$(".i-checks").iCheck({
		checkboxClass : "icheckbox_square-green",
		radioClass : "iradio_square-green",
	})
});

/* 新增弹出层
参数解释：
table	table元素
title	标题
url		请求的url
w		弹出层宽度（缺省调默认值）
h		弹出层高度（缺省调默认值）
*/
function layerAdd(table, title, url, w, h) {
	if (table == null) {
		return false;
	}
	if (title == null || title == '') {
		title = false;
	}
	if (url == null || url == '') {
		url = "common/404.html";
	}
	if (w == null || w == '') {
		w = '80%'; // 默认宽度
	}
	if (w.indexOf('%') == -1 && w.indexOf('px') == -1) {
		w = w + 'px';
	}
	if (h == null || h == '') {
		h = '90%'; // 默认高度
	}
	if (h.indexOf('%') == -1 && h.indexOf('px') == -1) {
		h = h + 'px';
	}
	layer.open({
		type : 2,
		title : title,
		area : [ w, h ],
		maxmin : true,
		content : url,
		btn : [ '保存', '关闭' ],
		yes : function(index, layero) {
			var loading = layer.load(1);
			var mainForm = layer.getChildFrame('#mainForm', index);
			$.post(mainForm.attr('action'), mainForm.serialize(), function(data) {
				layer.close(loading);
				if (data.result) {
		  			layer.msg("添加成功", { time: 2000 });
					layero.find('iframe').attr('src', layero.find('iframe').attr('src')); //刷新页面
				} else {
		  			layer.alert(data.des, { icon: 0 });
				}
			}, 'json');
		},
		end : function(index, layero) {
			table.bootstrapTable('refresh');
		}
	});
}

/* 编辑弹出层
参数解释：
table	table元素
key		传递到服务器的参数名称
title	标题
url		请求的url
w		弹出层宽度（缺省调默认值）
h		弹出层高度（缺省调默认值）
*/
function layerEdit(table, key, title, url, w, h) {
	if (table == null)
		return false;
	var rows = table.bootstrapTable('getSelections');
	if (rows.length == 0) {
		layer.msg('请选择一行数据');
		return false;
	}
	if (key == null || key == '')
		key = "id";
	if (title == null || title == '')
		title = false;
	if (w == null || w == '')
		w = '80%'; // 默认宽度
	if (w.indexOf('%') == -1 && w.indexOf('px') == -1)
		w = w + 'px';
	if (h == null || h == '')
		h = '90%'; // 默认高度
	if (h.indexOf('%') == -1 && h.indexOf('px') == -1)
		h = h + 'px';
	url = url + "?" + key + "=" + rows[0].id;
	layer.open({
		type : 2,
		title : title,
		area : [ w, h ],
		maxmin : true,
		content : url,
		btn : [ '保存', '关闭' ],
		yes : function(index, layero) {
			var loading = layer.load(1);
			var mainForm = layer.getChildFrame('#mainForm', index);
			$.post(mainForm.attr('action'), mainForm.serialize(), function(data) {
				layer.close(loading);
				if (data.result) {
		  			layer.msg("保存成功", { time: 2000 });
					layero.find('iframe').attr('src', layero.find('iframe').attr('src')); //刷新页面
				} else {
		  			layer.alert(data.des, { icon: 0 });
				}
			}, 'json');
		},
		end : function(index, layero) {
			table.bootstrapTable('refresh');
		}
	});
}

function gridOperation(table, operationName, url) {
	layer.confirm('确定要' + operationName + '所选数据？', {
		icon : 3,
		title : '提示'
	}, function(index) {
		var loading = layer.load(1);
		$.post(url, {}, function(data) {
			layer.close(loading);
			if (data.result) {
	  			layer.msg(operationName + "成功", { time: 2000 });
			} else {
	  			layer.alert(data.des, { icon: 0 });
			}
		}, 'json');
	});
}

/*关闭弹出框口*/
function layerClose() {
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}