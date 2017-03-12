package org.myStudy.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.myStudy.enums.BaseStatusEnum;

/**
 * 用户实体
 * @author WZY
 */
public class User extends BaseEntity {

	@NotEmpty(message = "{not.empty}")
	private String userName;
	private String password;
	private String nickname;
	private String realName;
	private String phone;
	@Email(message = "{email.not.correct}")
	private String email;
	private BaseStatusEnum status;
	private String remark;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BaseStatusEnum getStatus() {
    	if (status == null) {
    		status = BaseStatusEnum.INVALID;
    	}
		return status;
	}

	public void setStatus(BaseStatusEnum status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	//扩展
	public String getStatusDes() {
		return getStatus().getDescription();
	}
}
