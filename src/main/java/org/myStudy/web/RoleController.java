package org.myStudy.web;

import java.util.List;

import org.myStudy.dto.BootstrapTable;
import org.myStudy.dto.PageQuery;
import org.myStudy.entity.Role;
import org.myStudy.service.IRoleService;
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

/**
 * 角色管理控制器
 * @author WZY
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRoleService roleService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "role/index";
	}

	@RequestMapping(value = "/pageList", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String pageList(PageQuery query) {
		List<Role> list = roleService.getPageList(query);
		BootstrapTable<Role> table = new BootstrapTable<Role>();
		table.setRows(list);
		table.setTotal(roleService.getPageListTotal(query));
		return table.toJsonString();
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(@RequestParam(value = "id", required = false) Integer id, Model model) {
		Role role;
		if (id == null || id == 0) {
			role = new Role();
		} else {
			role = roleService.getById(id);
		}
		model.addAttribute(role);
		return "role/info";
	}

	@RequestMapping(value = "/info", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String info(Role role) {
		if (role == null) {
			return jsonResult(false, null, "model is null");
		}
		try {
			int res;
			if (role.getId() == 0) {
				res = roleService.add(role);
			} else {
				res = roleService.edit(role);
			}
			return jsonResult(true, res, "");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return jsonResult(false, 0, e.getMessage());
		}
	}
}
