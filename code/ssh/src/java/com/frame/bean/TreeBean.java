package com.frame.bean;

import java.io.Serializable;

/**
 * 
 * @author tanfei 
 * @date Mar 4, 2013 9:43:56 AM
 */
public class TreeBean implements Serializable{

	/**
	 *序列号 
	 */
	private static final long serialVersionUID = 4542667966180441411L;
	
	/********************树的基本属性***********************/

	/**
	 * 树结点ID
	 */
	private String treeId;

	/**
	 * 父节点ID
	 */
	private String parentId;

	/**
	 * 名称
	 */
	private String name;
	

	
	/**
	 * 是否是父结点
	 */
	private Boolean isParent;
	
	/**********************菜单超链接 start**********************/
	/**
	 * 连接地址
	 */
	private String url;
	
	/**
	 * 连接目标
	 */
	private String target;
	
	/**
	 * 点击连接事件
	 */
	private String click;
	
	/**********************菜单超链接 end**********************/
	
	//----------------------GETTER AND SETTER-----------------------------------
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
