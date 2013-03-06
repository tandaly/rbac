package com.frame;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.frame.core.base.dao.BaseDao;

public class InitDB extends BaseCommonTest{

	@Resource(name = "baseDaoImpl")
	private BaseDao baseDao;
	
	@Before
    public void setUp() throws Exception {
	System.out.println("测试开始");
    }

    @After
    public void tearDown() throws Exception {
	System.out.println("测试结束");
    }

    @BeforeTransaction
    public void beforeTransaction() {
	System.out.println("事务开始");
    }

    @AfterTransaction
    public void afterTransaction() {
	System.out.println("事务结束");
    }
	
	@Test
	public void test() {
		this.baseDao.initDB();
	}

}
