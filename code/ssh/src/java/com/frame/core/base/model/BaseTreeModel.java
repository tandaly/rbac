package com.frame.core.base.model;

import java.io.Serializable;

/**
 * 基础树
 * @author tanfei 
 * @date Mar 4, 2013 9:43:56 AM
 */
public class BaseTreeModel implements Serializable{

	/**
	 *序列号 
	 */
	private static final long serialVersionUID = -7080415097326280695L;
	
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
	
}
