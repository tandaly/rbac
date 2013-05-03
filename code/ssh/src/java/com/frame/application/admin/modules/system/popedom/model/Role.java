package com.frame.application.admin.modules.system.popedom.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.frame.core.base.model.BaseModel;
/**
 * 角色实体类
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-2-23 下午5:44:11
 */
@Entity
@Table(name = "t_sys_role")
public class Role extends BaseModel{

	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 8532263163815921103L;

	/**
	 * 角色名
	 */
	@Column(name = "role_name", unique = true, length = 100, nullable = false)
	private String roleName;
	
	/**
	 * 用户集合
	 */
	@ManyToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}
			,mappedBy = "roles"
			,targetEntity = User.class
			)
	private Set<User> users = new HashSet<User>();
	
//	/**
//	 * 用户组集合
//	 */
//	private Set<Usergroup> usergroups = new HashSet<Usergroup>();
//	
	/**
	 * 权限集合
	 */
	@ManyToMany(
			targetEntity = Privilege.class
			,cascade = CascadeType.ALL
			)
	@JoinTable(
				name = "t_sys_role_privilege"
				, joinColumns = {@JoinColumn(name="role_id")}
				, inverseJoinColumns = {@JoinColumn(name="privilege_id")}
			)
	private Set<Privilege> privileges = new HashSet<Privilege>();
	
	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

//	public Set<Usergroup> getUsergroups() {
//		return usergroups;
//	}
//
//	public void setUsergroups(Set<Usergroup> usergroups) {
//		this.usergroups = usergroups;
//	}
	
	
	
	
	
}
