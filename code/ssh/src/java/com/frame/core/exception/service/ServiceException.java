package com.frame.core.exception.service;


/**
 * 业务异常类
 * @author Tandaly
 * @date 2013-3-7 下午4:08:01
 */
public class ServiceException extends RuntimeException {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1146636106136589243L;

	//异常代码
	private String key;
	
	private Object[] values;//一些其他信息
	
	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable throwable) {
		super(throwable);
	}
	
	public ServiceException(String message,String key){
		super(message);
		this.key = key;
	}
	
	public ServiceException(String message,String key,Object value){
		super(message);
		this.key = key;
		this.values = new Object[]{value};
	}
	
	public ServiceException(String message,String key,Object[] values){
		super(message);
		this.key = key;
		this.values = values;
	}

	public String getKey() {
		return key;
	}

	public Object[] getValues() {
		return values;
	}
}
