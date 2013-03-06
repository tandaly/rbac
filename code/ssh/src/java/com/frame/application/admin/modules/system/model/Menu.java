package com.frame.application.admin.modules.system.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.frame.core.base.model.BaseModel;

/**
 * 菜单实体类
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-2-23 下午8:07:49
 */
@Entity
@Table(name = "t_sys_menu")
public class Menu extends BaseModel{


	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 4863313616994182941L;

	/**
	 * 菜单编号
	 */
	@Column(name = "menu_no", length = 100, nullable = false)
	private String menuNo;
	
	/**
	 * 父菜单编号
	 */
	@Column(name = "parent_no", length = 100, nullable = true)
	private String parentNo;
	
	/**
	 * 菜单名称
	 */
	@Column(name = "menu_name", length = 100, nullable = false)
	private String menuName;
	
	/**
	 * 菜单URL
	 */
	@Column(name = "menu_url", length = 1000)
	private String menuUrl;
	
	/**
	 * 目标值
	 */
	@Column(name = "target", length = 50)
	private String target;
	
	/**
	 * 菜单事件处理函数
	 */
	@Column(name = "click", length = 1000)
	private String click;//默认无效
	
	/**
	 * 排序编号
	 */
	@Column(name = "order_no", length = 100)
	private String orderNo;
	
	/**
	 * 权限集合
	 */
	@ManyToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}
			,mappedBy = "menus"
			,targetEntity = Privilege.class
			)
	private Set<Privilege> privileges = new HashSet<Privilege>();

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public String getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}
	
}
