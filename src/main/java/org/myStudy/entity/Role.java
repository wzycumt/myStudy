package org.myStudy.entity;

import org.myStudy.enums.BaseStatusEnum;

/**
 * 角色实体
 * @author WZY
 */
public class Role extends BaseEntity {

    private String name;
    private BaseStatusEnum status;
    private String remark;
    
    public String getName() {
    	if (name != null)
    		return name.trim();
    	return name;
    }

    public void setName(String name) {
        this.name = name;
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