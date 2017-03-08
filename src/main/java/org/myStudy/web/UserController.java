package org.myStudy.web;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return "userManagement/index";
	}

	@RequestMapping(value = "/pageList", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String pageList(PageQuery query) {
		List<User> list = userService.getPageList(query);
		BootstrapTable<User> table = new BootstrapTable<User>();
		table.setRows(list);
		table.setTotal(userService.getPageListTotal(query));
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
		return "userManagement/info";
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
		model.addAttribute(user);
		if (!result.hasErrors()) {
			try {
				if (user.getId() == 0) {
					userService.add(user);
				} else {
					userService.edit(user);
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
				model.addAttribute("error", e.getMessage());
			}
		}
		return "userManagement/info";
	}
}
