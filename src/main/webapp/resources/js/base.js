
$(document).ready(function() {
	//单选、复选按钮样式
	$(".i-checks").iCheck({
		checkboxClass : "icheckbox_square-green",
		radioClass : "iradio_square-green",
	})
});

/**
 * 新增弹出层
 * @param grid grid元素
 * @param title 标题
 * @param url
 * @param w 弹出层宽度（默认值80%）
 * @param h 弹出层高度（默认值90%）
 */
function layerAdd(grid, title, url, w, h) {
	if (grid == null)
		return false;
	if (title == null || title == '')
		title = false;
	if (url == null || url == '')
		url = "common/404.html";
	if (w == null || w == '')
		w = '80%'; // 默认宽度
	if (w.indexOf('%') == -1 && w.indexOf('px') == -1)
		w = w + 'px';
	if (h == null || h == '')
		h = '90%'; // 默认高度
	if (h.indexOf('%') == -1 && h.indexOf('px') == -1)
		h = h + 'px';
	layer.open({
		type : 2,
		title : title,
		area : [ w, h ],
		maxmin : true,
		content : url
	});
}

/**
 * 编辑弹出层
 * @param grid grid元素
 * @param title 标题
 * @param url
 * @param w 弹出层宽度（默认值80%）
 * @param h 弹出层高度（默认值90%）
 */
function layerEdit(grid, title, url, w, h) {
	if (grid == undefined)
		return false;
	var rows = grid.bootstrapTable('getSelections');
	if (rows == undefined || rows.length == 0) {
		layer.msg('请选择一行数据', { time: 2000 });
		return false;
	}
	if (title == undefined || title == '')
		title = false;
	if (w == null || w == '')
		w = '80%'; // 默认宽度
	if (w.indexOf('%') == -1 && w.indexOf('px') == -1)
		w = w + 'px';
	if (h == null || h == '')
		h = '90%'; // 默认高度
	if (h.indexOf('%') == -1 && h.indexOf('px') == -1)
		h = h + 'px';
	var options = grid.bootstrapTable('getOptions');
	var key = options.idField;
	url = url + "?id=" + rows[0][key];
	layer.open({
		type : 2,
		title : title,
		area : [ w, h ],
		maxmin : true,
		content : url
	});
}

/**
 * 操作
 * @param grid grid元素
 * @param operationName 操作
 * @param url
 * @param ajaxData ajax参数(object类型)
 * @returns
 */
function operateGird(grid, operationName, url, ajaxData) {
	var rows = grid.bootstrapTable('getSelections');
    if (rows == undefined || rows.length == 0) {
		layer.msg('请至少选择一行数据', { time: 2000 });
		return false;
    }
    if (undefined == operationName || "" == operationName)
    	operationName = "操作";
	layer.confirm('确定' + operationName + '所选数据？', { icon : 3, title : '提示' }, function(index) {
		if (ajaxData == undefined)
			ajaxData = {};
		if (ajaxData['ids'] == undefined) {
			var options = grid.bootstrapTable('getOptions');
			var key = options.idField;
			var idArr = [];
	        for (var i = 0; i < rows.length; i++) {
	        	idArr.push(rows[i][key]);
	        }
	        ajaxData['ids'] = idArr.join(',');
		}
		var loading = layer.load(1);
        $.ajax({
            url: url,
            data: ajaxData,
            type: 'post',
            dataType: 'json',
            success: function (data) {
    			layer.close(loading);
    			if (data.result) {
    	  			layer.msg(data.des, { time: 2000 });
    				grid.bootstrapTable('refresh');
    			} else {
    	  			layer.alert(data.des, { icon: 0 });
    			}
            },
            error: function (xhr, textStatus, error) {
    			layer.close(loading);
	  			layer.alert(error, { icon: 2 });
            }
        });
	});
}

/**
 * 关闭弹出层
 */
function layerClose() {
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}

var bootstrapTable = {
	queryParams : function(params) {
		console.log(params);
		return params;
	}
}

