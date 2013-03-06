package com.frame.application.admin.modules.system.model;

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
	
	/**
	 * 显示图标
	 */
	private String icon;
	
	//----------------------GETTER AND SETTER-----------------------------------
	
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
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		if(null != icon && !"".equals(icon))
		{
			
			this.icon = "plugins/ztree/icons/" + icon;
		}
	}
	
	
	
	
	
}
