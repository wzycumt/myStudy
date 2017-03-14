package org.myStudy.web;

import java.util.List;

import org.myStudy.entity.Menu;
import org.myStudy.service.IMenuService;
import org.myStudy.web.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页控制器
 * @author WZY
 */
@Controller
public class HomeController extends BaseController {
	
	@Autowired
	private IMenuService MenuService;
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Menu> menuTree = MenuService.getMenuTreeByParentId(0);
		model.addAttribute("menuTree", menuTree);
		return "home/index";
	}
}
