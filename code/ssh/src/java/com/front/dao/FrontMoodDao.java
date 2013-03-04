package com.front.dao;

import java.util.List;

import com.front.model.FrontMood;

public interface FrontMoodDao {

	/**
	 * 增加心情实体
	 * @param frontMood
	 */
	public int insertMood(FrontMood frontMood);
	
	/**
	 * 查询心情
	 * @param start
	 * @param current
	 * @return
	 */
	public List<FrontMood> queryFrontMoods(int start, int current);
}
