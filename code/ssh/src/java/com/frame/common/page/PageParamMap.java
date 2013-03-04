package com.frame.common.page;

import java.util.HashMap;

public class PageParamMap extends HashMap<String, Object>{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4929833749921880133L;
	
	public final static String PAGENO = "pageNo";
	public final static String PAGESIZE = "pageSize";
	
	//private Map<String, Object> paramMap = new HashMap<String, Object>();
	
	private int pageNo;
	private int pageSize;
	
	public PageParamMap(Integer pageNo, Integer pageSize)
	{
//		super.put(PAGENO, pageNo);
//		super.put(PAGESIZE, pageSize);
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
	
	public int getPageNo()
	{
		return this.pageNo;
	}
	
	public int getPageSize()
	{
		return this.pageSize;
	}
	
}