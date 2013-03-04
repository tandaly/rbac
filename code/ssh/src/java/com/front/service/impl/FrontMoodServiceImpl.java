package com.front.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.front.dao.FrontMoodDao;
import com.front.model.FrontMood;
import com.front.service.FrontMoodService;

@Service
public class FrontMoodServiceImpl implements FrontMoodService{

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
