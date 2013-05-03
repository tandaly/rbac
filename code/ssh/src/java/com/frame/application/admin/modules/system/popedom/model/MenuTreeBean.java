package com.frame.application.admin.modules.system.popedom.model;

import com.frame.core.base.model.BaseTreeModel;

/**
 * 
 * @author tanfei 
 * @date Mar 4, 2013 9:43:56 AM
 */
public class MenuTreeBean extends BaseTreeModel{

	/**
	 *序列号 
	 */
	private static final long serialVersionUID = 4542667966180441411L;
	
	/********************树的基本属性***********************/

	/**********************菜单超链接 start**********************/
	/**
	 * 连接地址
	 */
	private String linkUrl;
	
	
	/**********************菜单超链接 end**********************/
	
	/**
	 *  结点展开 / 折叠 状态
	 * true 表示节点为 展开 状态
	 * false 表示节点为 折叠 状态
	 */
	private boolean open = true;
	
	/**
	 * 显示图标
	 */
	private String icon;
	
	//----------------------GETTER AND SETTER-----------------------------------
	
	
	
	public String getIcon() {
		return icon;
	}
	
	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public void setIcon(String icon) {
		if(null != icon && !"".equals(icon))
		{
			
			this.icon = "plugins/ztree/icons/" + icon;
		}
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	
	
	
	
	
}
