package org.myStudy.web.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 序列化json返回结果
	 * @param result
	 * @param value
	 * @param descriptoin
	 * @return
	 */
	protected String jsonResult(boolean result, Object value, String descriptoin) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("value", value);
		map.put("des", descriptoin);
		ObjectMapper json = new ObjectMapper();
		json.setSerializationInclusion(Include.ALWAYS);
		try {
			return json.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	protected void addModelMessage(Model model, String message) {
		model.addAttribute("message", message);
	}
	
}
