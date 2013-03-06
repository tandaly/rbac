package com.frame.application.front.modules.index.service;

import java.util.List;

import com.frame.application.front.modules.index.model.FrontMood;
import com.frame.core.base.service.BaseService;

public interface FrontMoodService extends BaseService{

	/**
	 * 发表心情
	 * @param frontMood
	 * @return
	 */
	public boolean publishMood(FrontMood frontMood);
	
	/**
	 * 获取心情列表
	 * @return
	 */
	public List<FrontMood> fetchFrontMoods();
}
