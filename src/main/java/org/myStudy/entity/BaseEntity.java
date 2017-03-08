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

	private Integer id;
	private Integer creator;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private Integer updatePerson;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	private Integer version;
	
	private boolean isChecked;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
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

	public Integer getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(Integer updatePerson) {
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
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
