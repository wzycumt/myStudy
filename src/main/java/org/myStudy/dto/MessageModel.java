package org.myStudy.dto;

import org.myStudy.entity.Message;

/**
 * 留言信息模型
 * @author WZY
 */
public class MessageModel {
	private Message message;
	private String verifyCode; //验证码

	public MessageModel() {

	}
	/**
	 * 获取留言实体
	 * @return
	 */
	public Message getMessage() {
		return message;
	}
	
	/**
	 * 设置留言实体
	 * @param message
	 */
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public String getVerifyCode() {
		return verifyCode;
	}
	
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}
