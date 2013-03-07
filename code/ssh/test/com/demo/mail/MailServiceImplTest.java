package com.demo.mail;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.mail.MailService;
import com.frame.BaseTest;

/**
 * 邮件发送测试
 * @author Tandaly
 * @date 2013-3-7 下午1:59:15
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4  
@ContextConfiguration({"/spring/demo/spring-ds.xml", "/spring/demo/spring-mail.xml"}) //指定Spring的配置文件 /为classpath下
public class MailServiceImplTest extends BaseTest {

	@Resource
	public MailService mailService = null;
	
	/**
	 * html异步发送
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testSendHtmlEmails() {
		System.out.println("testSendHtmlEmails开始");
		this.mailService.sendHtmlEmails("tandaly@163.com,619606426@qq.com", "MailServiceImplTestSpringMail异步发送邮件测试", "共同学习共同进步!!! 邮件发送很耗时，还需异步发送啊啊啊啊---<font color='red'>飞龙剑</font>");
		try {
			Thread.currentThread().sleep(TimeUnit.MINUTES.toMillis(3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 模版异步发送
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testSendTemplateHtmlEmails()
	{
		System.out.println("testSendTemplateHtmlEmails开始");
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("username", "tandaly");
		this.mailService.sendTemplateHtmlEmails(root, "mail.ftl", "619606426@qq.com,1058014456@qq.com;tandaly001@gmail.com;","MailServiceImplTest模版主题标题-异步");

		try {
			Thread.currentThread().sleep(TimeUnit.MINUTES.toMillis(3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * html异步
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testSendAsync()
	{
		System.out.println("testSendAsync开始");
		try {
			this.mailService.sendAsync("tandaly@163.com,619606426@qq.com", "SpringMail异步发送邮件测试", "共同学习共同进步!!! 邮件发送很耗时，还需异步发送啊啊啊啊---<font color='red'>飞龙剑</font>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.currentThread().sleep(TimeUnit.MINUTES.toMillis(3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
