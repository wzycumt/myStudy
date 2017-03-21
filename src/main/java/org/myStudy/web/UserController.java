package org.myStudy.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.myStudy.dto.BootstrapTable;
import org.myStudy.dto.PageQuery;
import org.myStudy.dto.UserModel;
import org.myStudy.entity.Role;
import org.myStudy.entity.User;
import org.myStudy.service.IRoleService;
import org.myStudy.service.IUserService;
import org.myStudy.web.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理控制器
 * @author WZY
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "user/index";
	}

	@RequestMapping(value = "/pageList", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String pageList(PageQuery pageQuery) {
		List<User> list = userService.getList(pageQuery.toQuery());
		BootstrapTable<User> table = new BootstrapTable<User>();
		table.setRows(list);
		table.setTotal(userService.getListTotal(pageQuery.toQuery()));
		return table.toJsonString();
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(@RequestParam(value = "id", required = false) Integer id, Model model) {
		UserModel userModel = new UserModel(); 
		if (id != null && id != 0) {
			userModel.setUser(userService.getById(id));
		}
		List<Role> roleList = roleService.getAll();
		Map<Integer, String> dicRoleList = new HashMap<Integer, String>();
		dicRoleList.put(0, "--请选择--");
		dicRoleList.putAll(roleList.stream().collect(Collectors.toMap(Role::getId, Role::getName)));
		userModel.setDicRoleList(dicRoleList);;
		model.addAttribute(userModel);
		return "user/info";
	}

	@RequestMapping(value = "/info", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String info(UserModel userModel) {
		if (userModel == null || userModel.getUser() == null) {
			return jsonResult(false, null, "model is null");
		}
		logger.info(userModel.toString());
		try {
			if (userModel.getUser().getId() == 0) {
				int res = userService.add(userModel.getUser(), userModel.getRoleIds());
				return jsonResult(true, res, "添加成功");
			} else {
				int res = userService.edit(userModel.getUser(), userModel.getRoleIds());
				return jsonResult(true, res, "保存成功");
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
			userService.deleteBatch(ids);
			return jsonResult(true, null, "删除成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return jsonResult(false, null, e.getMessage());
		}
	}
}
