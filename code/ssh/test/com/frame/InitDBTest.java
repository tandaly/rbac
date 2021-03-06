package com.frame;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frame.core.base.dao.impl.InitDB;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext*.xml", "/spring/admin/applicationContext*.xml"})
@TransactionConfiguration(defaultRollback = false)
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class InitDBTest{

	@Resource
	private InitDB initDB;
	
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
		this.initDB.excute();
	}

}
