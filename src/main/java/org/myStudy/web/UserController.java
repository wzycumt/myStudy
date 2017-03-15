package org.myStudy.web;

import java.util.List;

import org.myStudy.dto.BootstrapTable;
import org.myStudy.dto.PageQuery;
import org.myStudy.entity.User;
import org.myStudy.service.IUserService;
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
 * 用户管理控制器
 * @author WZY
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserService userService;

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
		User user;
		if (id == null || id == 0) {
			user = new User();
		} else {
			user = userService.getById(id);
		}
		model.addAttribute(user);
		return "user/info";
	}

	@RequestMapping(value = "/info", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String info(User user) {
		if (user == null) {
			return jsonResult(false, null, "model is null");
		}
		try {
			int res;
			if (user.getId() == 0) {
				res = userService.add(user);
			} else {
				res = userService.edit(user);
			}
			return jsonResult(true, res, "");
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
