/**
 * bootstrapTable查询扩展插件
 * @author: WZY
 */
!function($) {

    var showFormSearch = function(grid, fields) {
    	var $btnSearch = grid.$toolbar.find('#btnSearch_' + grid.options.searchCode);
    	$btnSearch.popover({
			placement : 'bottom',
			container : grid.$tableContainer,
			trigger : 'manual',
			html : true,
			content : function () {
				html = '';
				html += '<form class="form-horizontal" id="formSearch_' + grid.options.searchCode + '" method="post">';
				for (var i = 0; i < fields.length; i++) {
					var field = fields[i];
					html += '<div class="form-group row">';
					html += '<label class="col-xs-3 control-label">' + field.displayName + '</label>';
					html += '<div class="col-xs-9">';
					switch (field.fieldType) {
						case 'VARCHAR': //文本
							html += '<input type="text" class="form-control" name="' + field.fieldName + '" placeholder="' + field.displayName + '" />';
							break;
						case 'NUMBER': //数字
							html += '<div class="input-group">';
							html += '<input type="text" class="form-control input-sm" name="' + field.fieldName + '_Start" placeholder="起"/>';
							html += '<span class="input-group-addon">-</span>';
							html += '<input type="text" class="form-control input-sm" name="' + field.fieldName + '_End" placeholder="止"/>';
							html += '</div>';
							break;
						case 'BOOLEAN': //布尔
							html += '<label class="radio-inline i-checks"><input type="radio" class="form-control" name="' + field.fieldName + '" value="true">是</label>';
							html += '<label class="radio-inline i-checks"><input type="radio" class="form-control" name="' + field.fieldName + '" value="false" checked="checked">否</label>';
							break;
						case 'DATETIME': //日期
							html += '<div class="input-group">';
							html += '<input type="text" class="form-control layer-date" name="' + field.fieldName + '_Start" placeholder="起"/>';
							html += '<span class="input-group-addon">-</span>';
							html += '<input type="text" class="form-control layer-date" name="' + field.fieldName + '_End" placeholder="止"/>';
							html += '</div>';
							break;
						case 'ENUMERATION': //枚举
							html += '<select class="form-control" name="' + field.fieldName + '">';
							html += '<option value="-1">--请选择--</option>';
							html += '<option value="0">无效</option>';
							html += '<option value="1">有效</option>';
							html += '</select>';
							break;
						case 'DICTIONARY': //字典
							html += '<select class="form-control" name="' + field.fieldName + '">';
							html += '<option value="-1">--请选择--</option>';
							html += '<option value="0">无效</option>';
							html += '<option value="1">有效</option>';
							html += '</select>';
							break;
					}
					//html += '<input type="text" class="form-control" name="' + field.fieldName + '" placeholder="' + field.displayName + '" />';
					html += '</div>';
					html += '</div>';
				}
				html += '<div class="form-group text-center">';
				html += '<div class="btn-group">';
				html += '<input type="button" class="btn btn-success" id="btnSubmit" value="查询" />';
				html += '<input type="reset" class="btn btn-primary" id="btnReset" value="重置" />';
				html += '<input type="button" class="btn btn-danger" id="btnCancel" value="取消" />';
				html += '</div>';
				html += '</div>';
				html += '</form>';
				return html;
			}
		}).on('shown.bs.popover', function() {
			//查询提交
	    	$('#formSearch_' + grid.options.searchCode).find('#btnSubmit').click(function() {
	    		var forms = $('#formSearch_' + grid.options.searchCode).serializeArray();
	    		var query = {};
	    		for (var i = 0; i < forms.length; i++) {
	    			if (forms[i].value != '') {
		    			query['queryFilters[' + i + '].columnName'] = forms[i].name;
		    			query['queryFilters[' + i + '].operator'] = 'LIKE';
		    			query['queryFilters[' + i + '].value'] = forms[i].value;
	    			}
	    		}
	    		var params = { query : query };
	    		grid.$el.bootstrapTable('refresh', params);
	    	});
	    	//取消
	    	$('#formSearch_' + grid.options.searchCode).find('#btnCancel').click(function() {
	    		$btnSearch.popover('toggle');
	    	});
		}).click(function() {
    		$btnSearch.popover('toggle');
    	});
    }

    $.extend($.fn.bootstrapTable.defaults, {
    	queryParamsType: 'pageSize',
    	queryParams: function(params) {
    		var queryParams = {
    			paged: this.pagination && this.sidePagination == 'server',
				pageNumber: params.pageNumber,
				pageSize: params.pageSize,
    		};
    		if (params.sortName) {
    			queryParams['sortColumns[0].columnName'] = params.sortName;
    			queryParams['sortColumns[0].sortOrder'] = params.sortOrder.toUpperCase();
    		}
    		return queryParams;
    	},
    	ajax: function(settings) {
    		settings.contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
    		settings.type = 'post';
    		$.ajax(settings);
    	}
    });

    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales);

    var BootstrapTable = $.fn.bootstrapTable.Constructor,
        _initToolbar = BootstrapTable.prototype.initToolbar;
    
    BootstrapTable.prototype.initToolbar = function() {
        _initToolbar.apply(this, Array.prototype.slice.apply(arguments));

        if (!this.options.searchCode) {
            return;
        }
        //工具栏右侧添加查询按钮
        var rightbar = this.$toolbar.find('.columns-right').last();
        if (rightbar.length == 0) {
        	rightbar = $('<div class="columns columns-right btn-group pull-right" role="group"></div>');
        	this.$toolbar.prepend(rightbar);
        }
    	var html = '<button type="button" class="btn btn-default" id="btnSearch_' + this.options.searchCode + '">';
    	html += '<i class="fa fa-search"></i>&nbsp;<span class="caret"></span>';
    	html += '</button>';
    	rightbar.append(html);

    	var grid = this;
		$.get('searchConfig/' + grid.options.searchCode, null, function(data) {
			if (data.result) {
				showFormSearch(grid, data.value.fields);
			} else {
				grid.$toolbar.find('#btnSearch_' + grid.options.searchCode).click(function() {
					layer.tips(data.des, '#btnSearch_' + grid.options.searchCode);
				})
			}
		}, 'json')
    };
}(jQuery);
