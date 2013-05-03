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
 * 权限实体类
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-2-23 下午6:14:18
 */
@Entity
@Table(name = "t_sys_privilege")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(
//		name = "privilegeType",
//		discriminatorType = DiscriminatorType.STRING
//		)
public class Privilege extends BaseModel{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -5394944005449488239L;
	
	/**
	 * 权限名称
	 */
	@Column(name = "privilege_name", length = 100)
	private String privilegeName;
	/**
	 * 权限类型
	 */
	//private String privilegeType;
	
	/**
	 * 角色集合
	 */
	@ManyToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}
			,mappedBy = "privileges"
			,targetEntity = Role.class
			)
	private Set<Role> roles = new HashSet<Role>();
	
	/**
	 * 菜单集合
	 */
	@ManyToMany(
			targetEntity = Menu.class
			,cascade = CascadeType.ALL
			)
	@JoinTable(
				name = "t_sys_privilege_menu"
				, joinColumns = {@JoinColumn(name="privilege_id")}
				, inverseJoinColumns = {@JoinColumn(name="menu_id")}
			)
	private Set<Menu> menus = new HashSet<Menu>();

	
//	public String getPrivilegeType() {
//		return privilegeType;
//	}
//
//	public void setPrivilegeType(String privilegeType) {
//		this.privilegeType = privilegeType;
//	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	
	
	
	
	
}
