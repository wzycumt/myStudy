package org.myStudy.entity;

import org.myStudy.enums.BaseStatusEnum;

/**
 * 用户实体
 * @author WZY
 */
public class User extends BaseEntity {

	private String userName;
	private String password;
	private String nickname;
	private String realName;
	private String phone;
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
		return status;
	}
	
	/**状态描述
	 * @return
	 */
	public String getStatusDes(){
		return status.getDescription();
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

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", nickname=" + nickname + ", realName=" + realName + ", phone=" + phone
				+ ", email=" + email + ", status=" + status + ", remark=" + remark + "]";
	}
	
}
