package org.myStudy.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.myStudy.enums.BaseStatusEnum;

/**
 * 菜单实体
 * @author WZY
 */
public class Menu extends BaseEntity {

	@NotEmpty(message = "{not.empty}")
    private String name;
    private int parentId;
    private String url;
	private String icon;
    private int serialNum;
    private BaseStatusEnum status;
    private String remark;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

	public BaseStatusEnum getStatus() {
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
		return status.getDescription();
	}
}