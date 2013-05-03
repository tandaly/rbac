package com.frame.application.admin.modules.system.popedom.model;

import java.util.HashSet;
import java.util.Set;

import com.frame.core.base.model.BaseModel;
/**
 * 用户组实体
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-2-23 下午8:47:11
 */
public class Usergroup extends BaseModel{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 2696997961115112460L;

	/**
	 * 父用户组
	 */
	private Long parentId;
	
	/**
	 * 用户组名称
	 */
	private String usergroupName;
	
	/**
	 * 用户集合
	 */
	private Set<User> users = new HashSet<User>();
	
	/**
	 * 角色集合
	 */
	private Set<Role> roles = new HashSet<Role>();

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getUsergroupName() {
		return usergroupName;
	}

	public void setUsergroupName(String usergroupName) {
		this.usergroupName = usergroupName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
