package org.myStudy.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.myStudy.enums.BaseStatusEnum;

/**
 * 角色实体
 * @author WZY
 */
public class Role extends BaseEntity {

	@NotEmpty(message = "{not.empty}")
    private String name;
    private BaseStatusEnum status;
    private String remark;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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