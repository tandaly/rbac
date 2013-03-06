package com.frame.application.front.modules.index.dao;

import java.util.List;

import com.frame.application.front.modules.index.model.FrontMood;
import com.frame.core.base.dao.BaseDao;

public interface FrontMoodDao extends BaseDao{

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
