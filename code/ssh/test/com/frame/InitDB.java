package com.frame;

import javax.annotation.Resource;

import org.junit.Test;

import com.frame.common.dao.CommonDao;

public class InitDB extends BaseCommonTest{

	@Resource(name = "commonDaoSupport")
	private CommonDao commonDao;
	
	@Test
	public void test() {
		commonDao.initDB();
	}

}
