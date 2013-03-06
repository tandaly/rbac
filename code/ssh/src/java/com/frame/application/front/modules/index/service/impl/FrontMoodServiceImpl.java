package com.frame.application.front.modules.index.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.application.front.modules.index.dao.FrontMoodDao;
import com.frame.application.front.modules.index.model.FrontMood;
import com.frame.application.front.modules.index.service.FrontMoodService;
import com.frame.core.base.service.impl.BaseServiceImpl;

@Service
public class FrontMoodServiceImpl extends BaseServiceImpl implements FrontMoodService{

	@Autowired
	private FrontMoodDao frontMoodDao;
	
	@Override
	public boolean publishMood(FrontMood frontMood) {
		if(1 == this.frontMoodDao.insertMood(frontMood))
		{
			return true;
		}
		return false;
	}

	@Override
	public List<FrontMood> fetchFrontMoods() {
		
		return this.frontMoodDao.queryFrontMoods(0, 10);
	}

	
}
