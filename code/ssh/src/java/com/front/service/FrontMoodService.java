package com.front.service;

import java.util.List;

import com.front.model.FrontMood;

public interface FrontMoodService {

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
