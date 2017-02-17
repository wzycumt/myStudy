package org.myStudy.web;

import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigationController {

	@RequestMapping(value = "/container/{viewName}", method = RequestMethod.GET)
	public String container(@PathVariable("viewName") String viewName, Model model) {
		model.addAttribute("viewName", viewName);
		return viewName;
	}
	
	@RequestMapping(value = "/sysInfo", method = RequestMethod.GET)
	public String sysInfo(HttpServletRequest request, Model model) {
		//获取服务器信息
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
		
		String clientIp = request.getHeader("X-Real-IP");
		model.addAttribute("clientIp", clientIp);
		return "sysInfo";
	}
}
