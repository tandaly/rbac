package com.frame;

import javax.annotation.Resource;

import org.junit.Test;

import com.frame.common.dao.BaseDao;

public class InitDB extends BaseCommonTest{

	@Resource(name = "baseDaoImpl")
	private BaseDao baseDao;
	
	@Test
	public void test() {
		this.baseDao.initDB();
	}

}
