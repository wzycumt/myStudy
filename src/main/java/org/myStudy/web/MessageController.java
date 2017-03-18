package org.myStudy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.myStudy.dto.MessageModel;
import org.myStudy.dto.Query;
import org.myStudy.entity.Message;
import org.myStudy.enums.OrderEnum;
import org.myStudy.service.IMessageService;
import org.myStudy.utility.VerifyCodeUtility;
import org.myStudy.web.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

	@Autowired
	private IMessageService messageService;

	/**
	 * 留言板
	 */
	@RequestMapping(value = "/msgBoard", method = RequestMethod.GET)
	public String msgBoard() {
		return "message/msgBoard";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String list(@RequestParam("page") int page) {
		try {
			Query query = new Query();
			query.setPaged(true);
			query.setOffset((page - 1) * 10);
			query.setLimit(10);
			query.addSortColumn("createTime", true);
			List<Message> list = messageService.getListWithNum(query);
			return jsonResult(true, list, "");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return jsonResult(false, null, e.getMessage());
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String save(MessageModel model, HttpServletRequest request) {
		if (model == null) {
			return jsonResult(false, null, "model is null");
		}
		String inputCode = model.getVerifyCode();
		HttpSession session = request.getSession(true);
		String verifyCode = session.getAttribute("verifyCode").toString();
		if (inputCode == null || inputCode.trim().equals("")) {
			return jsonResult(false, null, "请输入验证码");
		}
		if (verifyCode == null || verifyCode.equals("")) {
			return jsonResult(false, null, "验证码已过期，请刷新并重新输入");
		}
		if (!inputCode.toLowerCase().equals(verifyCode)) {
			return jsonResult(false, null, "验证码错误");
		}

		try {
			int res = messageService.add(model.getMessage());
			return jsonResult(true, res, "");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return jsonResult(false, 0, e.getMessage());
		}
	}

	@RequestMapping(value = "/getVerifyCode", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = VerifyCodeUtility.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("verifyCode");
		session.setAttribute("verifyCode", verifyCode.toLowerCase());
		// 生成图片
		int w = 100, h = 30;
		VerifyCodeUtility.outputImage(w, h, response.getOutputStream(), verifyCode);
	}
}
