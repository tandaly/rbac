package com.frame.core.base.page;

import java.util.HashMap;

public class PageParamMap extends HashMap<String, Object>{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4929833749921880133L;
	
	public final static String PAGENO = "pageNo";
	public final static String PAGESIZE = "pageSize";
	
	//private Map<String, Object> paramMap = new HashMap<String, Object>();
	
	private String entityName; //查询实体名称
	private int pageNo;
	private int pageSize;
	
	public PageParamMap(Integer pageNo, Integer pageSize)
	{
		if(null == pageNo)
		{
			this.pageNo = 0;
		}
		else 
		{
			this.pageNo = pageNo;
		}
		
		if(null == pageSize)
			this.pageSize = 0;
		else
			this.pageSize = pageSize;
	}
	
	public PageParamMap(String entityName, Integer pageNo, Integer pageSize)
	{
//		super.put(PAGENO, pageNo);
//		super.put(PAGESIZE, pageSize);
		
		this.entityName = entityName;
		
		if(null == pageNo)
		{
			this.pageNo = 0;
		}
		else 
		{
			this.pageNo = pageNo;
		}
		
		if(null == pageSize)
			this.pageSize = 0;
		else
			this.pageSize = pageSize;
	}
	
	
	public String getEntityName() {
		return entityName;
	}

	public int getPageNo()
	{
		return this.pageNo;
	}
	
	public int getPageSize()
	{
		return this.pageSize;
	}
	
	
}
