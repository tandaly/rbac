package com.front.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.util.dao.MyHibernateTemplate;
import com.front.dao.FrontMoodDao;
import com.front.model.FrontMood;

@Repository
public class FrontMoodDaoImpl implements FrontMoodDao{

	@Autowired
	private MyHibernateTemplate hibernateTemplate;
	
	@Override
	public int insertMood(FrontMood frontMood) {
		this.hibernateTemplate.save(frontMood);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrontMood> queryFrontMoods(int startResult, int maxResult) {
		String queryString = "FROM FrontMood fm ORDER BY fm.publishDatetime DESC";
		return this.hibernateTemplate.find(queryString, startResult, maxResult);
	}
	
}
