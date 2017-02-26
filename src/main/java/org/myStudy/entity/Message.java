package org.myStudy.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 留言表
 * 
 * @author WZY
 */
public class Message {
	private Long id;
	private String name;
	private String content;
	private String avatar;
	private int status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	private int version;
	
	//扩展字段
	private long rowNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
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

	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", content=" + content + ", status=" + status + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", version=" + version + ", rowNum=" + rowNum + "]";
	}

	//----------------------------
	//扩展方法
	public String getCreateTimeStr() {
		Date now = new Date();
		long diffSec = (now.getTime() - createTime.getTime()) / 1000; // 时间差（秒）
		if (diffSec < 60) {
			return diffSec + "秒前";
		} else if (diffSec < 60 * 60) {
			return diffSec / 60 + "分钟前";
		} else if (diffSec < 60 * 60 * 24) {
			return diffSec / (60 * 60) + "小时前";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(createTime);
		}
	}

	public String getUpdateTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(updateTime);
	}

	public long getRowNum() {
		return rowNum;
	}

	public void setRowNum(long rowNum) {
		this.rowNum = rowNum;
	}

}
