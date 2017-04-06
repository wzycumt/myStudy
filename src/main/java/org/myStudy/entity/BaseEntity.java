package org.myStudy.entity;

import java.util.Date;

import org.myStudy.utility.DateUtility;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 所有实体类的基类
 * @author WZY
 */
public class BaseEntity {

	private int id;
	private int creator;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private int updatePerson;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	private int version;
	
	private boolean checked;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		if(createTime == null) {
			createTime = DateUtility.getMinDateTime();
		}
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(int updatePerson) {
		this.updatePerson = updatePerson;
	}

	public Date getUpdateTime() {
		if(updateTime == null) {
			updateTime = DateUtility.getMinDateTime();
		}
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	//----------------------------
	//扩展方法
	public String getCreateTimeStr() {
		return DateUtility.formatDateTime(getCreateTime());
	}

	public String getUpdateTimeStr() {
		return DateUtility.formatDateTime(getUpdateTime());
	}
}
