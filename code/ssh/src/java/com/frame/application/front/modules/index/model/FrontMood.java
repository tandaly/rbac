package com.frame.application.front.modules.index.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 发表心情实体
 * 
 * @author 谭飞
 * @date 2013-2-6 下午2:41:27
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_front_mood")
public class FrontMood implements Serializable {

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Integer id;


	/**
	 * 发表内容
	 */
	@Column(name="publish_content", nullable = false, length=100)
	private String publishContent;

	/**
	 * 发表日期
	 */
	@Column(name="publish_datetime", columnDefinition="timestamp")
	private Date publishDatetime;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private FrontUser frontUser;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPublishContent() {
		return publishContent;
	}

	public void setPublishContent(String publishContent) {
		this.publishContent = publishContent;
	}

	public Date getPublishDatetime() {
		return publishDatetime;
	}

	public void setPublishDatetime(Date publishDatetime) {
		this.publishDatetime = publishDatetime;
	}

	public FrontUser getFrontUser() {
		return frontUser;
	}

	public void setFrontUser(FrontUser frontUser) {
		this.frontUser = frontUser;
	}
	
	
}
