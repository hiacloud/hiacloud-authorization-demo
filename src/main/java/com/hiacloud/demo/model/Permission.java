package com.hiacloud.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("许可")
public class Permission {
	public static final String RES_TYPE_MENU = "1";
	public static final Integer LEVEL_TOP = 1;
	
	
	public static final String IS_LEAF_TRUE = "1";
	public static final String IS_LEAF_FALSE = "0";
	
	@ApiModelProperty("编号")
	private String code;
	@ApiModelProperty("名称")
	private String name;
	@ApiModelProperty("英文名称")
	private String ename;
	@ApiModelProperty("类型")
	private String type;
	@ApiModelProperty("值")
	private String value;
	@ApiModelProperty("值2")
	private String value2;
	@ApiModelProperty("父节点编号。父节点编号为空，则表示为根节点。")
	private String parentCode;
	@ApiModelProperty("父节点名称(在树展示中使用)")
	private String parentName;
	@ApiModelProperty("图标")
	private String icon;
	@ApiModelProperty("状态")
	private String state;
	@ApiModelProperty("序号")
	private Integer orderNo;
	@ApiModelProperty("级别")
	private Integer level;
	@ApiModelProperty("是否叶子节点。1：是，0：否。")
	private String isLeaf;
	@ApiModelProperty("描述")
	private String description;
	@ApiModelProperty("创建时间")
	private Date createTime;
	@ApiModelProperty("创建人")
	private String creator;
	@ApiModelProperty("更新时间")
	private Date updateTime;
	@ApiModelProperty("更新人")
	private String updator;
	@ApiModelProperty("所属域")
	private String zoneCode;
	@ApiModelProperty("是否基础权限。true:是，false：否。")
	private Boolean buildin;
	
	private List<Permission> children;
	
	public List<Permission> getChildren() {
		if(null == children){
			return new ArrayList<>();
		}
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}

	public Boolean getBuildin() {
		return buildin;
	}

	public void setBuildin(Boolean buildin) {
		this.buildin = buildin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentName() {
		return parentName;
	}
	@Override
	public String toString() {
		return "Permission [code=" + code + ", name=" + name + ", ename=" + ename + ", type=" + type + ", value="
				+ value + ", value2=" + value2 + ", parentCode=" + parentCode + ", icon=" + icon + ", state=" + state
				+ ", orderNo=" + orderNo + ", level=" + level + ", isLeaf=" + isLeaf + ", description=" + description
				+ ", createTime=" + createTime + ", creator=" + creator + ", updateTime=" + updateTime + ", updator="
				+ updator + ", zoneCode=" + zoneCode + ", buildin=" + buildin + "]";
	}

}