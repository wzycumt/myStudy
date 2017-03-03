package org.myStudy.entity;

import java.util.Date;

import org.myStudy.enums.BaseStatusEnum;
import org.myStudy.utility.DateUtility;

/**
 * 留言表
 * @author WZY
 */
public class Message extends BaseEntity {

	private String name;
	private String content;
	private String avatar;
	private BaseStatusEnum status;

	// 扩展字段
	private long rowNum;

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

	public BaseStatusEnum getStatus() {
		return status;
	}

	public void setStatus(BaseStatusEnum status) {
		this.status = status;
	}

	@Override
	public String getCreateTimeStr() {
		Date now = new Date();
		long diffSec = (now.getTime() - getCreateTime().getTime()) / 1000; // 时间差（秒）
		if (diffSec < 60) {
			return diffSec + "秒前";
		} else if (diffSec < 60 * 60) {
			return diffSec / 60 + "分钟前";
		} else if (diffSec < 60 * 60 * 24) {
			return diffSec / (60 * 60) + "小时前";
		} else {
			return DateUtility.formatDateTime(getCreateTime());
		}
	}
	
	// ----------------------------
	// 扩展方法
	public long getRowNum() {
		return rowNum;
	}

	public void setRowNum(long rowNum) {
		this.rowNum = rowNum;
	}

}
