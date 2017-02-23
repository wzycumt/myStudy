package org.myStudy.web;

import java.util.HashMap;
import java.util.Map;

import org.myStudy.entity.Message;
import org.myStudy.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private IMessageService messageService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String save(@RequestBody Message message, String code) {
		if (message == null) {
			return jsonResult(false, 0, "message is null");
		}
		try {
			long res = 0;
			if (message.getId() == null || message.getId() == 0) {
				res = messageService.add(message);
			} else {
				res = messageService.edit(message);
			}
			return jsonResult(true, res, "");
		} catch (Exception e) {
			return jsonResult(false, 0, e.getMessage());
		}
	}

	/**
	 * 序列化json返回结果
	 * @param result
	 * @param value
	 * @param descriptoin
	 * @return
	 */
	private String jsonResult(boolean result, Object value, String descriptoin) {
		JSONSerializer serializer = new JSONSerializer();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("value", value);
		map.put("des", descriptoin);
		return serializer.serialize(map);
	}
}
