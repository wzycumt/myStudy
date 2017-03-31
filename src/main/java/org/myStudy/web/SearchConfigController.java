package org.myStudy.web;

import java.util.List;

import org.myStudy.dto.Query;
import org.myStudy.entity.SearchConfig;
import org.myStudy.service.ISearchConfigService;
import org.myStudy.web.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 查询配置控制器
 * @author WZY
 */
@Controller
@RequestMapping("/searchConfig")
public class SearchConfigController extends BaseController {
	
	@Autowired
	private ISearchConfigService searchConfigService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "searchConfig/index";
	}

	@RequestMapping(value = "/pageList", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String pageList(Query query) {
		List<SearchConfig> list = searchConfigService.getList(query);
		return listResult(list, query);
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(@RequestParam(value = "id", required = false) Integer id, Model model) {
		SearchConfig searchConfig;
		if (id == null || id == 0) {
			searchConfig = new SearchConfig();
		} else {
			searchConfig = searchConfigService.getByIdWithChildren(id);
		}
		model.addAttribute(searchConfig);
		return "searchConfig/info";
	}

	@RequestMapping(value = "/info", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String info(SearchConfig searchConfig) {
		if (searchConfig == null) {
			return jsonResult(false, null, "model is null");
		}
		try {
			if (searchConfig.getId() == 0) {
				int id = searchConfigService.add(searchConfig);
				return jsonResult(true, id, "");
			} else {
				searchConfigService.edit(searchConfig);
				return jsonResult(true, searchConfig.getId(), "");
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
			searchConfigService.deleteBatch(ids);
			return jsonResult(true, null, "删除成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return jsonResult(false, null, e.getMessage());
		}
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getSearchConfigByCode(@PathVariable String code) {
		SearchConfig entity = searchConfigService.getByCodeWithChildren(code);
		if (entity != null)
			return jsonResult(true, entity, "");
		return jsonResult(false, null, "查询条件未配置");
	}
}
