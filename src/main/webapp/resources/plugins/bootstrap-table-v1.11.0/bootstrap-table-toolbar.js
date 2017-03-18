/**
 * @author: aperez <aperez@datadec.es>
 * @version: v2.0.0
 *
 * @update Dennis Hernández <http://djhvscf.github.io/Blog>
 */

!function($) {
//    'use strict';

    var firstLoad = false;

    var sprintf = $.fn.bootstrapTable.utils.sprintf;

    var showAvdSearch = function(pColumns, searchTitle, searchText, that) {
        if (!$("#avdSearchModal" + "_" + that.options.idTable).hasClass("modal")) {
            var vModal = sprintf("<div id=\"avdSearchModal%s\"  class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"mySmallModalLabel\" aria-hidden=\"true\">", "_" + that.options.idTable);
            vModal += "<div class=\"modal-dialog modal-xs\">";
            vModal += " <div class=\"modal-content\">";
            vModal += "  <div class=\"modal-header\">";
            vModal += "   <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\" >&times;</button>";
            vModal += sprintf("   <h4 class=\"modal-title\">%s</h4>", searchTitle);
            vModal += "  </div>";
            vModal += "  <div class=\"modal-body modal-body-custom\">";
            vModal += sprintf("   <div class=\"container-fluid\" id=\"avdSearchModalContent%s\" style=\"padding-right: 0px;padding-left: 0px;\" >", "_" + that.options.idTable);
            vModal += "   </div>";
            vModal += "  </div>";
            vModal += "  </div>";
            vModal += " </div>";
            vModal += "</div>";

            $("body").append($(vModal));

            var vFormAvd = createFormAvd(pColumns, searchText, that),
                timeoutId = 0;;

            $('#avdSearchModalContent' + "_" + that.options.idTable).append(vFormAvd.join(''));

            $('#' + that.options.idForm).off('keyup blur', 'input').on('keyup blur', 'input', function (event) {
                clearTimeout(timeoutId);
                timeoutId = setTimeout(function () {
                    that.onColumnAdvancedSearch(event);
                }, that.options.searchTimeOut);
            });

            $("#btnCloseAvd" + "_" + that.options.idTable).click(function() {
                $("#avdSearchModal" + "_" + that.options.idTable).modal('hide');
            });

            $("#avdSearchModal" + "_" + that.options.idTable).modal();
        } else {
            $("#avdSearchModal" + "_" + that.options.idTable).modal();
        }
    };

    $.extend($.fn.bootstrapTable.defaults, {
    	searchCode: undefined
//        advancedSearch: false,
//        idForm: 'advancedSearch',
//        actionForm: '',
//        idTable: undefined,
//        onColumnAdvancedSearch: function (field, text) {
//            return false;
//        }
    });

//    $.extend($.fn.bootstrapTable.defaults.icons, {
//        advancedSearchIcon: 'glyphicon-chevron-down'
//    });
//
//    $.extend($.fn.bootstrapTable.Constructor.EVENTS, {
//        'column-advanced-search.bs.table': 'onColumnAdvancedSearch'
//    });

//    $.extend($.fn.bootstrapTable.locales, {
//        formatAdvancedSearch: function() {
//            return 'Advanced search';
//        },
//        formatAdvancedCloseButton: function() {
//            return "Close";
//        }
//    });

    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales);

    var BootstrapTable = $.fn.bootstrapTable.Constructor,
        _initToolbar = BootstrapTable.prototype.initToolbar,
        _load = BootstrapTable.prototype.load,
        _initSearch = BootstrapTable.prototype.initSearch;

    BootstrapTable.prototype.initToolbar = function() {
        _initToolbar.apply(this, Array.prototype.slice.apply(arguments));

        if (!this.options.searchCode) {
            return;
        }

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
		$.get('searchConfig/' + this.options.searchCode, null, function(data) {
			if (data.result) {
				grid.$toolbar.find('#btnSearch_' + grid.options.searchCode).popover({
					placement : 'bottom',
					container : grid.$tableContainer,
					trigger : 'click',
					html : true,
					content : function () {
						var fields = data.value.fields;
						html = '';
						html += '<form class="form-horizontal" id="formSearch_" method="post">';
						for (var i = 0; i < fields.length; i++) {
							html += '<div class="form-group row">';
							html += '<label class="col-xs-3 control-label">' + fields[i].displayName + '</label>';
							html += '<div class="col-xs-9">';
							
							html += '<input type="text" class="form-control" name="' + fields[i].fieldName + '" placeholder="' + fields[i].displayName + '" />';
							
							html += '</div>';
							html += '</div>';
						}
						html += '<div class="form-group text-center">';
						html += '<input type="button" class="btn btn-default" id="btnSubmit" value="查询" />';
						html += '<input type="button" class="btn btn-default" id="btnReset" value="重置" />';
						html += '<input type="button" class="btn btn-default" id="btnCancel" value="取消" />';
						html += '</div>';
						html += '</form>';
						return html;
					}
				});
			} else {
				grid.$toolbar.find('#btnSearch_' + grid.options.searchCode).click(function() {
					layer.tips(data.des, '#btnSearch_' + grid.options.searchCode);
				})
			}
		}, 'json')
//    	that.$toolbar.find('#btnSearch_' + that.options.searchCode)
//            .off('click')
//            .on('click', function() {
//                showAvdSearch(that.columns, '', 'Close', that);
//                layer.tips('<i class="fa fa-search">只想提示地精准些', this, {tips: 3, time: 0});
//            });
    };

//    BootstrapTable.prototype.load = function(data) {
//        _load.apply(this, Array.prototype.slice.apply(arguments));
//
//        if (!this.options.advancedSearch) {
//            return;
//        }
//
//        if (typeof this.options.idTable === 'undefined') {
//            return;
//        } else {
//            if (!firstLoad) {
//                var height = parseInt($(".bootstrap-table").height());
//                height += 10;
//                $("#" + this.options.idTable).bootstrapTable("resetView", {height: height});
//                firstLoad = true;
//            }
//        }
//    };

    BootstrapTable.prototype.initSearch = function () {
        _initSearch.apply(this, Array.prototype.slice.apply(arguments));

        if (!this.options.advancedSearch) {
            return;
        }

        var that = this;
        var fp = $.isEmptyObject(this.filterColumnsPartial) ? null : this.filterColumnsPartial;

        this.data = fp ? $.grep(this.data, function (item, i) {
            for (var key in fp) {
                var fval = fp[key].toLowerCase();
                var value = item[key];
                value = $.fn.bootstrapTable.utils.calculateObjectValue(that.header,
                    that.header.formatters[$.inArray(key, that.header.fields)],
                    [value, item, i], value);

                if (!($.inArray(key, that.header.fields) !== -1 &&
                    (typeof value === 'string' || typeof value === 'number') &&
                    (value + '').toLowerCase().indexOf(fval) !== -1)) {
                    return false;
                }
            }
            return true;
        }) : this.data;
    };

//    BootstrapTable.prototype.onColumnAdvancedSearch = function (event) {
//        var text = $.trim($(event.currentTarget).val());
//        var $field = $(event.currentTarget)[0].id;
//
//        if ($.isEmptyObject(this.filterColumnsPartial)) {
//            this.filterColumnsPartial = {};
//        }
//        if (text) {
//            this.filterColumnsPartial[$field] = text;
//        } else {
//            delete this.filterColumnsPartial[$field];
//        }
//
//        this.options.pageNumber = 1;
//        this.onSearch(event);
//        this.updatePagination();
//        this.trigger('column-advanced-search', $field, text);
//    };
}(jQuery);
