package org.myStudy.entity;

import java.util.List;

import org.myStudy.enums.BaseStatusEnum;

/**
 * 菜单实体
 * @author WZY
 */
public class Menu extends BaseEntity {

    private String name;
    private int parentId;
    private String url;
	private String icon;
    private int order;
    private BaseStatusEnum status;
    private String remark;

	private Menu parent;
    private List<Menu> children;
    //菜单对应访问权限
    private List<Role> roles;
    
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
        return order;
    }

    public void setSerialNum(int serialNum) {
        this.order = serialNum;
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

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}