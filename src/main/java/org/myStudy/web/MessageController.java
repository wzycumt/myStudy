package org.myStudy.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.myStudy.Enum.OrderEnum;
import org.myStudy.entity.Message;
import org.myStudy.service.IMessageService;
import org.myStudy.utility.VerifyCodeUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/message")
public class MessageController {
	private final Logger Logger = LoggerFactory.getLogger(this.getClass());

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
			Logger.error(e.getMessage(), e);
			return jsonResult(false, 0, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String list(@RequestParam("page") int page) {
		try {
			List<Message> list = messageService.getAll(page, 10, "CREATE_TIME", OrderEnum.DESC);
			return jsonResult(true, list, "");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			return jsonResult(false, null, e.getMessage());
		}
	}

	@RequestMapping(value = "/getVerifyCode", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException { 
        response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        response.setContentType("image/jpeg"); 
           
        //生成随机字串 
        String verifyCode = VerifyCodeUtility.generateVerifyCode(4); 
        //存入会话session 
        HttpSession session = request.getSession(true); 
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase()); 
        //生成图片 
        int w = 100, h = 30; 
        VerifyCodeUtility.outputImage(w, h, response.getOutputStream(), verifyCode); 
   
    }

	/**
	 * 序列化json返回结果
	 * @param result
	 * @param value
	 * @param descriptoin
	 * @return
	 */
	private String jsonResult(boolean result, Object value, String descriptoin) {
		JSONSerializer serializer = new JSONSerializer().include("value");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("value", value);
		map.put("des", descriptoin);
		return serializer.serialize(map);
	}
}
