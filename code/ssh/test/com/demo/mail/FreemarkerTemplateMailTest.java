package com.demo.mail;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.mail.TemplateEmail;
/**
 * 邮件模版发送
 * @author Tandaly
 * @date 2013-3-7 下午2:07:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/demo/applicationContext-sendMail.xml"})
public class FreemarkerTemplateMailTest {
	
	@Resource(name="templateEmail")
	private TemplateEmail templateEmail;
	
	/**
	 * 同步发送
	 */
	@Test
	public void testMail()
	{
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("username", "tandaly");
		templateEmail.sendTemplateMail(root, "619606426@qq.com,1058014456@qq.com;tandaly001@gmail.com;","FreemarkerTemplateMailTest主题标题","mail.ftl");
	}
	
	/**
	 * 异步发送
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAsySendTemplateMail()
	{
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("username", "tandaly");
		templateEmail.asySendTemplateMail(root, "619606426@qq.com", "FreemarkerTemplateMailTest主题标题[异步]","mail.ftl");
		
		try {
			Thread.currentThread().sleep(TimeUnit.MINUTES.toMillis(3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
