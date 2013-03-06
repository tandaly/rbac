package com.frame.core.base.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 抽象模型基类
 * 
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-23 下午5:40:06
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -41410766746653071L;

	@Id
	@GeneratedValue(generator = "myIncrement")
	@GenericGenerator(name = "myIncrement", strategy = "increment")
	private Long id;//主键ID

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
