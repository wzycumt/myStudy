package org.myStudy.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.myStudy.dto.BootstrapTable;
import org.myStudy.dto.Datatables;
import org.myStudy.dto.PageQuery;
import org.myStudy.dto.PageQuery1;
import org.myStudy.entity.User;
import org.myStudy.service.IUserService;
import org.myStudy.web.common.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.scene.control.behavior.TableCellBehavior;

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
	
	@RequestMapping(value="/pageList", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String pageList(@RequestBody PageQuery1 query) {
		Datatables<User> table = userService.getPageList(query);
	    return table.toJsonString();
	}
	
	@RequestMapping(value="/list", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String list(PageQuery query) throws JsonProcessingException {
		List<User> list = userService.getAll();
		BootstrapTable<User> table = new BootstrapTable<User>();
		table.setRows(list);
		table.setTotal(list.size());
		return table.toJsonString();
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "userManagement/info";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("user") User user, Model model) {
		try {
			userService.add(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute(user);
		return "userManagement/info";
	}
}
