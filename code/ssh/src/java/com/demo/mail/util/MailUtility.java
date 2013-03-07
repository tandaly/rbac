package com.demo.mail.util;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 邮件发送工具类
 * @author Tandaly
 * @date 2013-3-7 下午1:51:18
 */
@Component
public class MailUtility {
	
	@Resource 
	JavaMailSender mailSender;// 注入Spring封装的javamail，Spring的xml中已让框架装配
	
	@Resource 
	TaskExecutor taskExecutor;// 注入Spring封装的异步执行器
	
	/**
	 * 异步发送
	 * 直接使用 spring 3.0 的异步框架 只需使用 @Async 注解即可。 
	 * 需要激活 <!-- 注解异步任务驱动 -->
	 * <task:annotation-driven/>
	 * @param receivers 收件人
	 * @param subject 主题
	 * @param content 内容
	 */
	@Async  
	public void sendMail(String receivers, String subject, String content){  
	  
		System.out.println(" 在做发送准备工作中  ");  
		  
		try {  
			System.out.println("异步发送...");  
			this.sendMailBySynchronizationMode(receivers, subject, content);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Spring线程出现异常！！！");
		}  
		  
		System.out.println(" 异步发送完毕");  
	  
	}  
	
	/**
	 * 异步发送(手动)
	 * @param receivers 收件人
	 * @param subject 主题
	 * @param content 内容
	 */
	public void sendMailByAsynchronousMode(final String receivers, final String subject, final String content) {
		System.out.println("当前邮件采取异步发送..");
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					sendMailBySynchronizationMode(receivers, subject, content);
					System.out.println("邮件发送耗时任务完成");
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.exit(1);//当邮件发送完成时退出程序
			}
		});
	}
	
	/**
	 * 同步最终发送
	 * @param receivers 收件人
	 * @param subject 主题
	 * @param content 内容
	 * @return
	 * @throws Exception
	 */
	public boolean sendMailBySynchronizationMode(String receivers, String subject, String content) {
		if (receivers == null) {
			throw new IllegalArgumentException("收件人不能为空");
		}
		System.out.println("邮件开始发送...");
		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, "utf-8");

		try {
			receivers = receivers.replaceAll("\\;", ",");
			// 设置收件人，寄件人
			InternetAddress[] toAddress = InternetAddress.parse(receivers);
			mailMessage.setRecipients(Message.RecipientType.TO, toAddress); // 发送给多个账号
			messageHelper.setFrom("tandaly@163.com"); // 发件人
			messageHelper.setSubject(subject); // 主题
			// true 表示启动HTML格式的邮件
			messageHelper.setText(content, true); // 邮件内容，注意加参数true，表示启用html格式

			// 发送邮件
			mailSender.send(mailMessage);
			System.out.println("邮件开始发送成功！");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("邮件开始发送失败！");
			return false;
		}
	}
	
}
