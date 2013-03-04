package com.frame.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.frame.common.model.AbstractBaseModel;
/**
 * 用户实体类
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 下午9:54:53
 */
@Entity
@Table(name = "t_sys_user")
public class User  extends AbstractBaseModel{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -3526526220429580943L;
	
//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//	@Column(name = "id", unique = true, nullable = false)
//	private Long id;
	
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String userName;
	
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	
	/**
	 * 角色集合
	 */
	@ManyToMany(
			targetEntity = Role.class
			,cascade = CascadeType.ALL
			)
	@JoinTable(
				name = "t_sys_user_role"
				, joinColumns = {@JoinColumn(name="user_id")}
				, inverseJoinColumns = {@JoinColumn(name="role_id")}
			)
	private Set<Role> roles = new HashSet<Role>();
	
	/**
	 * 用户组集合
	 */
//	@ManyToMany(
//			targetEntity = Usergroup.class
//			,cascade = CascadeType.ALL
//			)
//	@JoinTable(
//				name = "t_sys_user_usergroup"
//				, joinColumns = {@JoinColumn(name="user_id")}
//				, inverseJoinColumns = {@JoinColumn(name="usergroup_id")}
//			)
//	private Set<Usergroup> usergroups = new HashSet<Usergroup>();
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
//	public Set<Usergroup> getUsergroups() {
//		return usergroups;
//	}
//	public void setUsergroups(Set<Usergroup> usergroups) {
//		this.usergroups = usergroups;
//	}
	
	
}
