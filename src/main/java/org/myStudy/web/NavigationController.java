package org.myStudy.web;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.myStudy.entity.Menu;
import org.myStudy.service.implement.MenuService;
import org.myStudy.web.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/nav")
public class NavigationController extends BaseController {
	
	@Autowired
	MenuService MenuService;

	@RequestMapping(value = "/{menuId}", method = RequestMethod.GET)
	public String index(@PathVariable Integer menuId, Model model) {
		//TODO 权限控制
		if(menuId != null && menuId != 0) {
			Menu menu = MenuService.selectById(menuId);
			if (menu != null) {
		        model.addAttribute("title", menu.getName());
		        model.addAttribute("url", menu.getUrl());
			}
		}
		return "common/layout_default";
	}

	/**
	 * 系统信息
	 */
	@RequestMapping(value = "/sysInfo", method = RequestMethod.GET)
	public String sysInfo(HttpServletRequest request, Model model) {
		// 获取服务器信息
		Properties props = System.getProperties();
		Runtime runtime = Runtime.getRuntime();
		long freeMemory = runtime.freeMemory();
		long totalMemory = runtime.totalMemory();
		long maxMemory = runtime.maxMemory();
		long usedMemory = totalMemory - freeMemory;
		long useableMemory = maxMemory - totalMemory + freeMemory;
		int div = 1024;
		double freeMemoryMB = ((double) freeMemory) / div / div;
		double totalMemoryMB = ((double) totalMemory) / div / div;
		double usedMemoryMB = ((double) usedMemory) / div / div;
		double maxMemoryMB = ((double) maxMemory) / div / div;
		double useableMemoryMB = ((double) useableMemory) / div / div;
		model.addAttribute("props", props);
		model.addAttribute("maxMemoryMB", maxMemoryMB);
		model.addAttribute("usedMemoryMB", usedMemoryMB);
		model.addAttribute("useableMemoryMB", useableMemoryMB);
		model.addAttribute("totalMemoryMB", totalMemoryMB);
		model.addAttribute("freeMemoryMB", freeMemoryMB);

		return "sysInfo";
	}
	
	/**
	 * 文件上传
	 */
	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public String fileUpload(HttpServletRequest request, Model model) {
		return "fileUpload";
	}
}
