package org.myStudy.web;

import java.util.List;

import org.myStudy.dto.BootstrapTable;
import org.myStudy.dto.PageQuery;
import org.myStudy.entity.Role;
import org.myStudy.service.IRoleService;
import org.myStudy.web.common.BaseController;
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

	@Autowired
	private IRoleService roleService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "role/index";
	}

	@RequestMapping(value = "/pageList", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String pageList(PageQuery pageQuery) {
		List<Role> list = roleService.getList(pageQuery.toQuery());
		BootstrapTable<Role> table = new BootstrapTable<Role>();
		table.setRows(list);
		table.setTotal(roleService.getListTotal(pageQuery.toQuery()));
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

	@RequestMapping(value = "/info", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String save(Role role) {
		if (role == null) {
			return jsonResult(false, null, "model is null");
		}
		try {
			if (role.getId() == 0) {
				int id = roleService.add(role);
				return jsonResult(true, id, "添加成功");
			} else {
				int id = roleService.edit(role);
				return jsonResult(true, id, "保存成功");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return jsonResult(false, null, e.getMessage());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(String ids) {
		try {
			roleService.deleteBatch(ids);
			return jsonResult(true, null, "删除成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return jsonResult(false, null, e.getMessage());
		}
	}
}
