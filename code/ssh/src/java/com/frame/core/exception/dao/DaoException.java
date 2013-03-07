package com.frame.core.exception.dao;


/**
 * 数据库异常类
 * @author Tandaly
 * @date 2013-3-7 下午4:08:01
 */
public class DaoException extends RuntimeException {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1146636106136589243L;

	//异常代码
	private String key;
	
	private Object[] values;//一些其他信息
	
	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable throwable) {
		super(throwable);
	}
	
	public DaoException(String message,String key){
		super(message);
		this.key = key;
	}
	
	public DaoException(String message,String key,Object value){
		super(message);
		this.key = key;
		this.values = new Object[]{value};
	}
	
	public DaoException(String message,String key,Object[] values){
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
