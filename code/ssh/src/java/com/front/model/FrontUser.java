package com.front.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_front_sys_user")
public class FrontUser implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="username", nullable=false)
	private String userName;
	
	@Column(name="password", nullable=false)
	private String password;
	
//	@OneToMany //一对多关系
//	@Cascade(CascadeType.SAVE_UPDATE) //级联关系：当保存和修改时对应级联的表也保存和修改
//	private Set<FrontMood> frontMoods;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public Set<FrontMood> getFrontMoods() {
//		return frontMoods;
//	}
//	public void setFrontMoods(Set<FrontMood> frontMoods) {
//		this.frontMoods = frontMoods;
//	}
	
	
}
