package org.myStudy.web;

import java.util.List;

import org.myStudy.dto.BootstrapTable;
import org.myStudy.dto.PageQuery;
import org.myStudy.entity.Menu;
import org.myStudy.service.IMenuService;
import org.myStudy.web.common.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 菜单管理控制器
 * @author WZY
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IMenuService menuService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return "menu/index";
	}

	@RequestMapping(value = "/treeList", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String treeList() {
		List<Menu> list = menuService.getAll();
		ObjectMapper json = new ObjectMapper();
		try {
			return json.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/pageList", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String pageList(PageQuery query) {
		List<Menu> list = menuService.getPageList(query);
		BootstrapTable<Menu> table = new BootstrapTable<Menu>();
		table.setRows(list);
		table.setTotal(menuService.getPageListTotal(query));
		return table.toJsonString();
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "parentId", required = false) Integer parentId, Model model) {
		Menu menu;
		if (id == null || id == 0) {
			menu = new Menu();
			if (parentId != null)
				menu.setParentId(parentId);
		} else {
			menu = menuService.getById(id);
		}
		model.addAttribute(menu);
		return "menu/info";
	}

	@RequestMapping(value = "/info", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String info(Menu menu) {
		if (menu == null) {
			return jsonResult(false, null, "model is null");
		}
		try {
			if (menu.getId() == 0) {
				int id = menuService.add(menu);
				return jsonResult(true, id, "添加成功");
			} else {
				int id = menuService.edit(menu);
				return jsonResult(true, id, "保存成功");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return jsonResult(false, 0, e.getMessage());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(String ids) {
		try {
			menuService.deleteBatch(ids);
			return jsonResult(true, null, "删除成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return jsonResult(false, null, e.getMessage());
		}
	}
}
