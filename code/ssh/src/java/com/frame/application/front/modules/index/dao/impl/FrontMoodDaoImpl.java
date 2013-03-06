package com.frame.application.front.modules.index.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frame.application.front.modules.index.dao.FrontMoodDao;
import com.frame.application.front.modules.index.model.FrontMood;
import com.frame.core.base.dao.impl.BaseDaoImpl;

@Repository
public class FrontMoodDaoImpl extends BaseDaoImpl implements FrontMoodDao{
	
	@Override
	public int insertMood(FrontMood frontMood) {
		super.save(frontMood);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrontMood> queryFrontMoods(int startResult, int maxResult) {
		String queryString = " FROM FrontMood fm ORDER BY fm.publishDatetime DESC ";
		
		return super.getHibernateTemplate().find(queryString, startResult, maxResult);
	}
	
}
